package com.vadc.fr.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class SqlRunner {

    DataSource dataSource;

    public SqlRunner (DataSource pDataSource)
    {
        dataSource = pDataSource;
    }
    private SqlRunner() {}
}
