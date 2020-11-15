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

    // method to delete
    public void test()
    {
        try (Connection conn = dataSource.getConnection())
        {
            String command = "select * from person";
            PreparedStatement statement = conn.prepareStatement(command);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }

        }
        catch (SQLException se)
        {
            System.out.println("Sql Exception: " + se.getMessage());

        }
    }


}
