package com.employee.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBuilder {
    static Connection con;
    public static Connection create_connection(String username, String password){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_employee", username, password);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("invalid username/password OR connection error");
            System.exit(0);
        }

        return con;
    }

    public static Connection create_connection() {
        return con;
    }
}
