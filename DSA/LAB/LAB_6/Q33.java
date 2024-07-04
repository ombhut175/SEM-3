// Write a program to swap two numbers using user-defines method

import java.util.Scanner;

public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter value of a");
        int a = sc.nextInt();
        System.out.println("enter value of b");
        int b = sc.nextInt();
        // System.out.println("before = "+" a= "+a+" b = "+b);
        swap(a,b);
        // System.out.println("after = "+" a= "+a+" b = "+b);
    }
    static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("after = "+" a= "+a+" b = "+b);
    }
}
