package com.vadc.fr;
import com.vadc.fr.db.DbUtilsFactory;
import com.vadc.fr.db.SqlRunner;
import oracle.jdbc.driver.OracleDriver;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SqlRunner sqlRunner =
                new SqlRunner( DbUtilsFactory.CreateDataSource(new OracleDriver(), "oracle.jdbc.driver.OracleDriver",
        "sandbox", "sandbox","jdbc:oracle:thin:@192.168.5.129:1521:orcl"));
        sqlRunner.test();
    }
}
