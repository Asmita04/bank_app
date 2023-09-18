package com.bluesky.bankapp.collectors;

import com.bluesky.bankapp.model.ActionRequest;

import java.sql.SQLException;

public interface DataCollector {
     ActionRequest collect() ;

}
