package com.bluesky.bankapp.util;

import com.bluesky.bankapp.model.Account;
import com.bluesky.bankapp.model.User;

public class UserUtils {

    public static Account getPrimaryAccount(User user) {
        return user.getAccounts().stream().filter(Account::getPrimary).findFirst().orElse(null);
    }
}
