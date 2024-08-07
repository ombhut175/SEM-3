package LAB_7;

import java.util.Scanner;

public class Q42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb1 = new StringBuilder(s);
        for (int i = 0; i < sb1.length(); i++) {
            if(sb1.charAt(i)=='*'){
                sb1.delete(i-1,i+1);
                i-=2;
            }
        }
        System.out.println(sb1.toString());
    }
}
