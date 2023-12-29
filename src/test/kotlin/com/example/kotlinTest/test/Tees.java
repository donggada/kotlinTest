package com.example.kotlinTest.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Tees {


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionUrl = "jdbc:mysql://coderpad:@/coderpad?unix_socket=/tmp/mysql/socket/mysqld.sock";



        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 3 AddressID, AddressLine1 FROM Person.address ORDER BY AddressID ASC");

            while (rs.next()) {
                int AddressID = rs.getInt("AddressID");
                String AddressLine1 = rs.getString("AddressLine1");

                System.out.println(AddressID + ", " + AddressLine1);
            }
            rs.close();
            stmt.close();
            connection.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
