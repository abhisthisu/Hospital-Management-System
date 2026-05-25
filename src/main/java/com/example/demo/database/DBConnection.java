package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/hospital_db";
    static String user = "root";
    static String password = "..Abhishek18..";

    public static Connection connect() {

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            user,
                            password
                    );

            System.out.println("Database Connected Successfully");

            return con;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}