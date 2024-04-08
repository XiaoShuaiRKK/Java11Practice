package com.JDBC.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_test?useSSL=false",
                "root","xiaoshuai0628");
             Statement statement = connection.createStatement()){
            String sql = "INSERT INTO emp VALUES(?,?,?)";
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
