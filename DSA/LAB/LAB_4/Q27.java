// WAP to replace lowercase characters by uppercase & vice-versa in a user specified
// string
/**
 * Q27
 */
import java.util.Scanner;
public class Q27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        int l = s.length();
        char[] ch = new char[l];
        int[] ascii = new int[l];
        for(int i=0;i<l;i++){
            ch[i]=s.charAt(i);
            ascii[i] = ch[i];
            if(ascii[i]>=65 && ascii[i]<=90){
                ascii[i] = ascii[i]+32;
            }
            else{
                ascii[i]=ascii[i]-32;
            }
            ch[i]=(char)ascii[i];
            System.out.print(ch[i]);
        } 
    }
}