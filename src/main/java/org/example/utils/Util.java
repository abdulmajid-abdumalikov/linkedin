package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/linkedin",
                    "postgres",
                    "8463"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
