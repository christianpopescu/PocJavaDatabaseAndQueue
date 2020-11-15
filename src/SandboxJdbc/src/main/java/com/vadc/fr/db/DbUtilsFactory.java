package com.vadc.fr.db;

import java.util.Properties;
import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DbUtilsFactory {
    public static DataSource
    CreateDataSource (Driver pDriver, String pDriverClassName, String pUser, String pPassword, String pUrl)
    {
        Properties properties = new Properties();
        properties.put("driverClassName",pDriverClassName);
        properties.put("user",pUser);
        properties.put("password",pPassword);
        properties.put("url",pUrl);
        return new SimpleDriverDataSource(pDriver, properties.getProperty("url"), properties);
    }
}
