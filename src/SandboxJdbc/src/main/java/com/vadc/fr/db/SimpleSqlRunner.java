package com.vadc.fr.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleSqlRunner extends SqlRunner{
    public SimpleSqlRunner(DataSource pDataSource)
    {
        super(pDataSource);
    }

    // method to delete
    public List<String> RunCommand(String pCommand)
    {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection())
        {
            PreparedStatement statement = conn.prepareStatement(pCommand);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(rs.getString(1));
            }
        }
        catch (SQLException se)
        {
            System.out.println("Sql Exception: " + se.getMessage());

        }
        return result;
    }

}
