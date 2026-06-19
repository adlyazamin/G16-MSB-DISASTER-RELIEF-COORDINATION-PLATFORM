package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReportDBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/reporting_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Reporting Database Connected!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

        return conn;
    }
}