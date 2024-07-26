// 76. Write a program to perform addition of two polynomial equations using
// appropriate data structure.

import java.util.Scanner;

public class Q76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("enter 1st polynomial equation");
        // String s1 = new String();
        String s1 = "5x^2+8x+3";
        // System.out.println("enter 2nd polynomial equation");
        // String s2 = new String();
        String s2 = "2x^2-7x+13";
        AddPolynomial ap1 = new AddPolynomial();
        ap1.addPolynomialLL(s1, s2);
    }
}
class AddPolynomial{
    Node first;
    Node last;
    void addPolynomialLL(String s1,String s2){
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(Character.isDigit(s1.charAt(i))){
                sb1.append(s1.charAt(i));
            }
            else{
                break;
            }
        }
        Node a = new Node(Integer.parseInt(sb1.toString()));
        // System.out.println(a.info);
    }   
}
class Node {
    int info;
    Node link;
    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}