package org.dpa.study.userbase1.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/shopdb";
    static final String USER = "postgres";
    static final String PASS = "q";
//    @Getter
//    private static Connection connection;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //    public Connection getConnection() {
//        return this.connection;
//    }



}
