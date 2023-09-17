package com.bluesky.bankapp.executors;

import java.sql.SQLException;

public interface ActionExecutor {
    void execute() throws Exception;
    boolean validate();
}
