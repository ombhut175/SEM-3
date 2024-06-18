// WAP to sort the N names in an alphabetical order.
/**
 * Q20
 */
import java.util.Scanner;
public class Q20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n number of strings");
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];
        char[] ch = new char[n];
        int[] ascii = new int[n];
        
        for(int i=0;i<n;i++){
            System.out.println("enter name "+(i+1));
            s[i] = sc.nextLine();
            ch[i] = s[i].charAt(0);
            ch[i] = Character.toLowerCase(ch[i]);
            ascii[i] = (int)ch[i];
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(ascii[i]>ascii[j]){
                    int temp = ascii[i];
                    ascii[i] = ascii[j];
                    ascii[j] = temp;
                }
            }
        }
        char[] ch2 = new char[n];
        for(int i=0;i<n;i++){
            ch2[i] = (char) ascii[i];
            for(int j=0;j<n;j++){
                if(ch2[i]==ch[j]){
                    System.out.println("name "+(i+1));
                    System.out.println(s[j]+" ");
                }
            }
        }
    }
}