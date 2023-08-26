package com.bluesky.bankapp.io;

import com.bluesky.bankapp.BankAppDataStorage;
import com.bluesky.bankapp.executors.ActionExecutor;
import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.RegistrationRequest;
import com.bluesky.bankapp.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StartupDataLoader {


    private BankAppDataStorage dataStorage;

    public StartupDataLoader(BankAppDataStorage dataStorage) {

        this.dataStorage = dataStorage;
    }

    public void initDatabase() throws IOException {
        List<RegistrationRequest> requests = loadAllUsers();
        for (RegistrationRequest request : requests) {

            User user = new User(request.getFirstName(),
                    request.getLastName(),
                    request.getBirthDate(),
                    request.getMobile(),
                    request.getUsername());
            user.setPin(request.getPin());

            Account account = new Account(user.getUserName() + "-1", user, request.getBalance());

            // At the time of registration, first account is always
            // primary account
            account.setPrimary(true);

            user.getAccounts().add(account);
            boolean exists = dataStorage.userExists(user);
            if (exists) {
                System.out.println("User already exists, please login!");
            } else {
                // add user to db
                dataStorage.addUser(user);
            }
        }

    }

    private List<RegistrationRequest> loadAllUsers() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        System.out.println("Inside StartupDataLoader:loadAllUsers");

        URL url = classloader.getResource("data");
        String path = url.getPath();
        File[] files = new File(path).listFiles();

        List<RegistrationRequest> requests = new ArrayList<>();

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            RegistrationRequest request = new RegistrationRequest(
                    reader.readLine(),
                    reader.readLine(),
                    reader.readLine(),
                    reader.readLine(),
                    reader.readLine(),
                    Double.parseDouble(reader.readLine().trim()),
                    Integer.parseInt(reader.readLine().trim())
            );
            reader.close();
            requests.add(request);
        }

        return requests;
    }
}
