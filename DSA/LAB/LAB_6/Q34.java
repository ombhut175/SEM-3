// Create class Employee_Detail with attributes Employee_ID, Name, Designation,
// and Salary. Write a program to read the detail from user and print it. 

import java.util.Scanner;

/**
 * Q34
 */
public class Q34 {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.getDetails();
        e1.printDetails();
    }
}
/**
Employee
 */ 
class Employee {
    Scanner sc = new Scanner(System.in);
    String employee_id;
    String name;
    String designation;
    int salary;    
    Employee(){
        this.employee_id=null;
        this.name=null;
        this.designation=null;
        this.salary=0;
    }
    public void getDetails(){
        System.out.println("enter employee id");
        employee_id = sc.nextLine();
        System.out.println("enter name ");
        name=sc.nextLine();
        System.out.println("enter designation");
        designation=sc.nextLine();
        System.out.println("enter salary");
        salary = sc.nextInt();
    }
    
    public  void printDetails(){
        System.out.println("employee id = "+employee_id);
        System.out.println("name = "+name);
        System.out.println("designation = "+designation);
        System.out.println("salary = "+salary);
    }
}