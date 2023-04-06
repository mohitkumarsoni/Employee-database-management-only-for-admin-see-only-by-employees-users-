package com.employee.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {
    public static boolean addNewEmployee(Employee emp) {
        boolean f= false;
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query = "insert into employee_info(name, id, age, salary,address)values(?,?,?,?,?)";

            PreparedStatement prs = con.prepareStatement(query);

            prs.setString(1, emp.getName());
            prs.setInt(2,emp.getId());
            prs.setInt(3,emp.getAge());
            prs.setLong(4,emp.getSalary());
            prs.setString(5, emp.getAddress());

            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }
    public static boolean updateEmployeeDetail(int id, int updateChoice) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean f = false;
        try {
            Connection con = ConnectionBuilder.create_connection();
            switch (updateChoice){
                case 1->{
                    System.out.print("enter new name : ");
                    String newName = br.readLine();
                    String query = "update employee_info set name=? where id=?";
                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setString(1,newName);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 2->{
                    System.out.print("enter new id");
                    int newId = Integer.parseInt(br.readLine());
                    String query ="update employee_info set id=? where id=?";

                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setInt(1,newId);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 3 ->{
                    System.out.print("enter new age : ");
                    int newAge = Integer.parseInt(br.readLine());

                    String query = "update employee_info set age=? where id=?";

                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setInt(1,newAge);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 4->{
                    System.out.print("enter new salary");
                    long newSalary = Long.parseLong(br.readLine());

                    String query = "update employee_info set salary=? where id =?";

                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setLong(1,newSalary);
                    prs.setInt(2, id);

                    prs.executeUpdate();
                    f=true;
                }
                case 5->{
                    System.out.print("enter new address");
                    String newAddress = br.readLine();

                    String query = "update employee_info set address=? where id=?";
                    PreparedStatement prs = con.prepareStatement(query);

                    prs.setString(1,newAddress);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                default -> {
                    System.out.println("select option from given options");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static boolean updateEmployeeDetail(String name, int updateChoice) {
        boolean f = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Connection con = ConnectionBuilder.create_connection();
            System.out.println("enter new id");
            int newId = Integer.parseInt(br.readLine());

            String query = "update employee_info set id=? where name=?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setInt(1,newId);
            prs.setString(2, name);

            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  f;
    }     //if you want to update id


    public static boolean deleteEmployee(int id) {
        boolean f= false;
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query ="delete from employee_info where id =?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setInt(1,id);
            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void showAllEmployees() {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query = "select * from employee_info";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){
                System.out.println("name : "+resultSet.getString(1));
                System.out.println("id : "+resultSet.getInt(2));
                System.out.println("age : "+resultSet.getInt(3));
                System.out.println("salary : "+resultSet.getLong(4));
                System.out.println("address : "+resultSet.getString(5));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void detailByIdForAdmin(int id) {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query ="select * from employee_info where id=?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setInt(1,id);

            ResultSet result = prs.executeQuery();
            while (result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getInt(3));
                System.out.println(result.getLong(4));
                System.out.println(result.getString(5));
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void detailByNameForAdmin(String name) {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query ="select * from employee_info where name=?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1,name);

            ResultSet result = prs.executeQuery();
            while (result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getInt(3));
                System.out.println(result.getLong(4));
                System.out.println(result.getString(5));
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void allEmployeesToUser() {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query = "select name,id, age from employee_info";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){
                System.out.println("name : "+resultSet.getString(1));
                System.out.println("id : "+resultSet.getInt(2));
                System.out.println("age : "+resultSet.getInt(3));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void detailByIdForUser(int id) {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query ="select name,id,age from employee_info where id=?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setInt(1,id);

            ResultSet result =  prs.executeQuery();
            while (result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getInt(3));
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void detailByNameForUser(String name) {
        try {
            Connection con = ConnectionBuilder.create_connection();
            String query = "select name, id, age from employee_info where name=?";
            PreparedStatement prs= con.prepareStatement(query);
            prs.setString(1,name);

            ResultSet result = prs.executeQuery();
            while(result.next()) {
                System.out.println(result.getString(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getInt(3));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
