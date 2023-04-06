import com.employee.manage.ConnectionBuilder;
import com.employee.manage.Employee;
import com.employee.manage.EmployeeDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mainLogin;
        String mainPassword;

        System.out.println("main user login_id");
        mainLogin = br.readLine();
        System.out.println("main user password");
        mainPassword = br.readLine();
        ConnectionBuilder.create_connection(mainLogin, mainPassword);

//=================================== main login ended ============================
//=================================== user login started ============================
        String admin = "admin1234";
        String user = "user1234";

        System.out.println("enter user_id and password");

        String username = br.readLine();
        String password = br.readLine();

        if (username.equals(admin)) {         //if username selected admin
            System.out.println("welcome to admin panel, what would you like to do?");
            while (true) {
                System.out.println("1.add new employee\n2.update existing employee detail\n3.delete employee" +
                        "\n4.get every employee detail\n5. get detail by user id\n6. get detail by user name\n7.exit app");
                int adminChoice = 0;
                try {
                    adminChoice = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("choose option from numbers");
                }
                switch (adminChoice) {
                    case 1 -> {
                        //add
                        System.out.print("name :");
                        String name = br.readLine();
                        System.out.print("id :");
                        int id = Integer.parseInt(br.readLine());
                        System.out.print("age :");
                        int age = Integer.parseInt(br.readLine());
                        System.out.print("salary :");
                        long salary = Long.parseLong(br.readLine());
                        System.out.print("address :");
                        String address = br.readLine();

                        Employee emp = new Employee(name, id, age, salary, address);
                        boolean ans = EmployeeDao.addNewEmployee(emp);

                        if (ans) {
                            System.out.println("employee added successfully");
                        } else {
                            System.out.println("oops... try again !!!");
                        }
                        System.out.println(emp);


                    }
                    case 2 -> {
                        //UPDATE
                        System.out.println("select choice you want to update");
                        System.out.println("1.name\n2.id\n.3.age\n4.salary\n5.address");
                        int updateChoice = Integer.parseInt(br.readLine());

                        if(updateChoice==2){
                            System.out.println("enter name of employee : ");
                            String name = br.readLine();

                            boolean ans = EmployeeDao.updateEmployeeDetail(name, updateChoice);
                            if (ans) {
                                System.out.println("detail updated successfully");
                            } else {
                                System.out.println("oops.... try again !!!");
                            }
                        }else {
                            System.out.println("enter following id to update detail");
                            int id = Integer.parseInt(br.readLine());

                            boolean ans = EmployeeDao.updateEmployeeDetail(id, updateChoice);
                            if (ans) {
                                System.out.println("detail updated successfully");
                            } else {
                                System.out.println("oops.... try again !!!");
                            }
                        }
                    }
                    case 3 -> {
                        //delete
                        System.out.println("enter id you want to delete");
                        int id = Integer.parseInt(br.readLine());
                        boolean ans = EmployeeDao.deleteEmployee(id);
                        if (ans) {
                            System.out.println("employee deleted successfully");
                        } else {
                            System.out.println("oops.... try again !!!");
                        }
                    }
                    case 4 -> {
                        //show all
                        EmployeeDao.showAllEmployees();
                    }
                    case 5 -> {
                        //detail by id
                        System.out.println("enter id to get detail");
                        int id = Integer.parseInt(br.readLine());
                        EmployeeDao.detailByIdForAdmin(id);
                    }
                    case 6 -> {
                        //detail by name
                        System.out.println("enter employee name : ");
                        String name = br.readLine();
                        EmployeeDao.detailByNameForAdmin(name);
                    }
                    case 7 -> //exit app
                            System.exit(0);
                }
            }
        }

        if (username.equals(user)) {
            while (true) {
                System.out.println("what would you like to do?");
                System.out.println("1. see all employee details");
                System.out.println("2. get employee detail by id");
                System.out.println("3. get employee detail by name");
                System.out.println("4. exit app");
                int userChoice = 0;

                try {
                    userChoice = Integer.parseInt(br.readLine());

                    switch (userChoice) {
                        case 1 -> {
                            //all employee detail
                            EmployeeDao.allEmployeesToUser();
                        }
                        case 2 -> {
                            //detail by id
                            System.out.println("enter id of employee you want to see detail");
                            int id = Integer.parseInt(br.readLine());
                            EmployeeDao.detailByIdForUser(id);
                        }
                        case 3 -> {
                            //detail by name
                            System.out.println("enter name of employee");
                            String name = br.readLine();
                            EmployeeDao.detailByNameForUser(name);
                        }
                        case 4 -> {
                            //exit
                            System.exit(0);
                        }
                        default -> {
                            System.out.println("select valid option");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}