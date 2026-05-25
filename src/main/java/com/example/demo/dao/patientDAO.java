package com.example.demo.dao;

import com.example.demo.database.DBConnection;
import com.example.demo.model.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class patientDAO {

    public void addPatient(patient p) {

        try {

            Connection con =
                    DBConnection.connect();

            String sql =
                    "INSERT INTO patients(name,age,gender,phone,address) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            ps.setString(3,p.getGender());
            ps.setString(4,p.getPhone());
            ps.setString(5,p.getAddress());

            ps.executeUpdate();

            System.out.println("Patient Added");

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }
}
