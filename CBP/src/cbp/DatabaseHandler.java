package cbp;

import java.sql.*;
import java.util.*;

/**
 * Handles database connectivity.
 * Demonstrates JDBC, Exception Handling, and Generics.
 */
public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3307/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "22022007";

    // Custom Exception (demonstrates user-defined exception)
    static class DatabaseException extends Exception {
        public DatabaseException(String message) {
            super(message);
        }
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Demonstrating Generics: A reusable method to print any list
    public static <T> void printList(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
