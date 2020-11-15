package com.vadc.fr;
import com.vadc.fr.db.DbUtilsFactory;
import com.vadc.fr.db.SimpleSqlRunner;
import com.vadc.fr.db.SqlRunner;
import oracle.jdbc.driver.OracleDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
/*        SqlRunner sqlRunner =
                new SqlRunner( DbUtilsFactory.CreateDataSource(new OracleDriver(), "oracle.jdbc.driver.OracleDriver",
        "sandbox", "sandbox","jdbc:oracle:thin:@192.168.5.129:1521:orcl"));
        */
        SimpleSqlRunner sqlRunner =
                new SimpleSqlRunner( DbUtilsFactory.CreateDataSource(new OracleDriver(), "oracle.jdbc.driver.OracleDriver",
                        "sandbox", "sandbox","jdbc:oracle:thin:@192.168.5.129:1521:orcl"));
        List<String> result = sqlRunner.RunCommand("select * from person");
        for (String line : result) System.out.println(line);
    }
}
