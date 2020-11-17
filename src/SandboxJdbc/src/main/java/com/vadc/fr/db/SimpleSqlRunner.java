package com.vadc.fr.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vadc.fr.dto.ListOfLines;

public class SimpleSqlRunner extends SqlRunner{
    public SimpleSqlRunner(DataSource pDataSource)
    {
        super(pDataSource);
    }

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

    public List<List<String>> RunCommandList(List<String> pCommandList)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        try (Connection conn = dataSource.getConnection())
        {
            for (String command : pCommandList) {
                List<String> aCommandResult = new ArrayList<String>();
                PreparedStatement statement = conn.prepareStatement(command);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    aCommandResult.add(rs.getString(1));
                }
                result.add(aCommandResult);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Sql Exception: " + se.getMessage());
        }
        return result;
    }

    public List<ListOfLines> RunCommandList(ListOfLines pListOfLines)
    {
        List<ListOfLines> result = new ArrayList<ListOfLines>();
        try (Connection conn = dataSource.getConnection())
        {
            for (String command : pListOfLines) {
                ListOfLines aCommandResult = new ListOfLines(new ArrayList<String>());
                PreparedStatement statement = conn.prepareStatement(command);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    aCommandResult.add(rs.getString(1));
                }
                result.add(aCommandResult);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Sql Exception: " + se.getMessage());
        }
        return result;
    }
}
