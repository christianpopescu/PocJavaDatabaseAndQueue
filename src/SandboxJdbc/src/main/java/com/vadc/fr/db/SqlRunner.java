package com.vadc.fr.db;

import javax.sql.DataSource;

public class SqlRunner {

    DataSource dataSource;

    public SqlRunner (DataSource pDataSource)
    {
        dataSource = pDataSource;
    }


}
