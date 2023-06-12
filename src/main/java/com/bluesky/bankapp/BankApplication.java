package com.bluesky.bankapp;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Simple Bank Application
 *
 * */
public class BankApplication {
    int sequenceNumber;

    public Map<String, User> userMap;
    public HashMap<String, Integer> accountNumbers ;

    public BankApplication() {
        userMap=new HashMap<>();
        accountNumbers = new HashMap<>();
    }

    public void addUserAccount(@NotNull User user) {
        String adhaarNo = user.getAdhaarNo();
        if (!accountNumbers.containsKey(adhaarNo)) {
            accountNumbers.put(adhaarNo, 1);
        } else {
             sequenceNumber = accountNumbers.get(adhaarNo) + 1;
            accountNumbers.put(adhaarNo, sequenceNumber);
        }

         sequenceNumber = accountNumbers.get(adhaarNo);
        String accountNo = adhaarNo + "-" + sequenceNumber;
        user.setAccountNo(accountNo);
        userMap.put(accountNo, user);
    }

    public User getUserDetails(String accountNo) {
        return userMap.get(accountNo);
    }

    public Map<String, User> map;
    public HashMap<String, Integer> accountNumbers ;

    public BankApplication() {
        map=new HashMap<>();
        accountNumbers = new HashMap<>();
    }

    public void addUserAccount(@NotNull User user) {
        String adhaarNo = user.getAdhaarNo();
        if (!accountNumbers.containsKey(adhaarNo)) {
            accountNumbers.put(adhaarNo, 1);
        } else {
            int sequenceNumber = accountNumbers.get(adhaarNo) + 1;
            accountNumbers.put(adhaarNo, sequenceNumber);
        }

        int sequenceNumber = accountNumbers.get(adhaarNo);
        String accountNo = adhaarNo + "-" + sequenceNumber;
        user.setAccountNo(accountNo);
        map.put(accountNo, user);
    }

    public User getUserDetails(String accountNo) {
        return map.get(accountNo);
    }

    public static void main(String[] args) {

        int Choice;

        String userName;
<<<<<<< Updated upstream
        String DOB;
=======
        String birthDate;
>>>>>>> Stashed changes
        long mobileNo = 0;
        String adhaarNo;
        String accountNo;
        int balance = 0;

        System.out.println("Welcome to MHETRE's Bank Pvt Ltd!!");
        Scanner scan = new Scanner(System.in);
<<<<<<< Updated upstream
      ///  Map<String, User> map = new HashMap<>();
   //     HashMap<String, Integer> accountNumbers = new HashMap<>();
        BankApplication account = new BankApplication();

        //   Iterator<user> it = obj.iterator();
=======
        BankApplication account = new BankApplication();

>>>>>>> Stashed changes

        do {
            int temp = 1;
            System.out.println("1.Register User");
            System.out.println("2.Remove Account");
            System.out.println("3.Transfer Money");
            System.out.println("4. View account details");
<<<<<<< Updated upstream
            System.out.println("5.Display List of All Accounts");
            System.out.println("6.Exit");
=======
            System.out.println("5.Exit");
>>>>>>> Stashed changes
            System.out.println("Enter Your Choice:");
            Choice = scan.nextInt();

            switch (Choice) {
                case 1: {

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
                    System.out.println("Enter name:");
                    scan.nextLine();
                    userName = scan.nextLine();

<<<<<<< Updated upstream
                    System.out.println("Enter DOB:");
                    DOB = scan.nextLine();
=======
                    System.out.println("Enter Birth Date:");
                    birthDate = scan.nextLine();
>>>>>>> Stashed changes

                    System.out.println("Enter Mobile:");
                    mobileNo = scan.nextLong();


                    System.out.println("Enter Adhaar No:");
                    scan.nextLine();
                    adhaarNo = new String(scan.nextLine());

                    System.out.println("Enter Balance:");
                    balance = scan.nextInt();

<<<<<<< Updated upstream
                    User user = new User(userName, DOB, mobileNo, adhaarNo, balance);
                    account.addUserAccount(user);

                    //Get Account number
//                    System.out.println("get account number!");
//                    scan.nextLine();

              /*      if(map.containsKey(adhaarNo)){
                        accountNo= account.setAccountNo(new String(adhaarNo +(-temp)));

                    }
                    else{
                        accountNo=account.setAccountNo(new String (adhaarNo +(-temp++)));
                    }

                    map.put(accountNo, account);*/

=======
                    User user = new User(userName, birthDate, mobileNo, adhaarNo, balance);
                    account.addUserAccount(user);

>>>>>>> Stashed changes
                    break;
                }

                case 2: {

                    System.out.println("Enter Account number to remove from list");
                    scan.nextLine();
                    accountNo = new String(scan.nextLine());
<<<<<<< Updated upstream
                    if (account.map.containsKey(accountNo)) {
                        account.map.remove(accountNo);
                        System.out.println("1 Account Deleted!");
=======
                    if (account.userMap.containsKey(accountNo)) {
                        account.userMap.remove(accountNo);
                        System.out.println(" Account Deleted Successfully!!");
>>>>>>> Stashed changes
                    } else {
                        System.out.println("Account is not present!");
                    }
                    break;

                }
                case 3: {
                    System.out.println("Enter account to which you wanted to send money:");
                    String receiverAccount = scan.nextLine();

                    System.out.println("Enter payee account number:");
                    String senderAccount = scan.nextLine();

                    System.out.println("\nEnter Amount: ");
                    int dAmount = scan.nextInt();

<<<<<<< Updated upstream
                    User sender =account. map.get(senderAccount);
                    User receiver = account.map.get(receiverAccount);
=======
                    User sender =account. userMap.get(senderAccount);
                    User receiver = account.userMap.get(receiverAccount);
>>>>>>> Stashed changes
                    if (sender.getBalance() >= dAmount) {
                        sender.setBalance(sender.getBalance() - dAmount);
                        receiver.setBalance(receiver.getBalance() + dAmount);

                    } else {
                        System.out.println("Insufficient Balance!");
                    }
<<<<<<< Updated upstream
                   account.map.put(senderAccount, sender);
                    account.map.put(receiverAccount, receiver);
=======
                    account.userMap.put(senderAccount, sender);
                    account.userMap.put(receiverAccount, receiver);
>>>>>>> Stashed changes
                    break;
                }
                case 4: {
                    System.out.println("Enter Account number:");
                    scan.nextLine();
                    accountNo = scan.nextLine();
                    User userdetails= account.getUserDetails(accountNo);

                    if(userdetails!=null){
                        System.out.println("Account No: \t\t" + "User Name: \t\t" + "DOB\t\t" + "Mobile No:\t\t" + "Adhaar No\t\t" + "Balance\t\n");
<<<<<<< Updated upstream
                        System.out.println(accountNo + "  \t" + userdetails.userName + "  \t  " + userdetails.DOB + "  \t " + userdetails.mobileNo + "  \t" + userdetails.adhaarNo + "  \t" + userdetails.balance + "  \t\n");
=======
                        System.out.println(accountNo + " \t\t\t \t" + userdetails.userName + "  \t  " + userdetails.birthDate + "  \t " + userdetails.mobileNo + "  \t" + userdetails.adhaarNo + "  \t" + userdetails.balance + "  \t\n");
>>>>>>> Stashed changes
                    }
                    else{
                        System.out.println("User not found!");
                    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
                    break;

<<<<<<< Updated upstream
                }
                case 5: {

                    //    System.out.println(map);
                    System.out.println("Account No: \t\t" + "User Name: \t\t" + "DOB\t\t" + "Mobile No:\t\t" + "Adhaar No\t\t" + "Balance\t\n");
                    for (Map.Entry<String, User> entry : account.map.entrySet()) {
                        User account1 = entry.getValue();
                        System.out.println(account1.accountNo + "  \t" + account1.userName + "  \t  " + account1.DOB + "  \t " + account1.mobileNo + "  \t" + account1.adhaarNo + "  \t" + account1.balance + "  \t\n");
                    }
                    break;
                }
                case 6:{

                    System.out.println("exit");
                    break;
                }


            }

        }while (Choice != 6) ;

=======
                case 5:{

                    System.out.println("exit");
                    break;
                }
                default:
                    throw new IllegalStateException(" I'm happy to help you on this journey please click one of the option below to get started!" );
            }

        }while (Choice != 5) ;

>>>>>>> Stashed changes
    }
}
