// Create array of object of class Student_Detail with attributes Enrollment_No,
// Name, Semester, CPI for 5 students, scan their information and print it

import java.util.Scanner;

/**
 * Q35
 */
public class Q35 {

    public static void main(String[] args) {
        Student_Detail[] s = new Student_Detail[5];
        for(int i=0;i<5;i++){
            s[i] = new Student_Detail();
            System.out.println("enter details for student  "+(i+1));
            s[i].getDetails();
        }
        for(int i=0;i<5;i++){
            System.out.println("details of student = "+(i+1));
            s[i].printDetails();
        }
    }
}
class Student_Detail{
    Scanner sc = new Scanner(System.in);
    String enrollment_no;
    String name;
    int semester;
    double cpi;
    void getDetails(){
        System.out.println("enter Enrollment number");
        enrollment_no=sc.nextLine();
        System.out.println("Name");
        name = sc.nextLine();
        System.out.println("Semester");
        // name = sc.nextLine();
        semester=sc.nextInt();
        System.out.println("CPI");
        cpi = sc.nextDouble();
    }
    void printDetails(){
        System.out.println("Enrollment number = "+enrollment_no);
        System.out.println("Name = "+name);
        System.out.println("semster = "+semester);
        System.out.println("CPI "+cpi);
    }
}