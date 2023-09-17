package com.bluesky.bankapp.dao;

import com.bluesky.bankapp.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao = new UserDao();

    @Test
    void userExists() {
        String userName = "1991";
        User user = new User("", "", "", "", userName);
        try {
            boolean result = dao.userExists(user);
            assertTrue(result);
            user.setUserName("33211");
            result = dao.userExists(user);
            assertFalse(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}