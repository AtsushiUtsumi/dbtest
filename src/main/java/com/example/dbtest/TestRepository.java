package com.example.dbtest;

import java.sql.*;

public class TestRepository {
    public String select(String query) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");

            // データベースのPATHを指定。相対パスでも絶対パスでも行けるようです
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = connection.createStatement();
            //String sql = "CREATE TABLE table1(id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
			//String sql = "INSERT INTO table1(id, name) VALUES(2,22)";
			//String sql = "INSERT INTO table1(id, name) VALUES(5,'utsumi')";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return rs.getString(1) + ":" + rs.getString(2);
            }
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
