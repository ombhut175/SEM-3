// WAP to print Armstrong number from 1 to 1000
/**
 * Q12
 */
import java.util.Scanner;
public class Q12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String s = new String();
        for(int i=1;i<=1000;i++){
            int sum=0;
            s = String.valueOf(i);
            int length = s.length();
            int[] ch = new int[length];
            for(int j=0;j<length;j++){
               ch[j] = Character.getNumericValue(s.charAt(j));
                sum = sum+(int)Math.pow(ch[j], length);
            }
                if(i==sum){
                    System.out.println(i);
                }
        }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            sc.close();
        }
    }
}