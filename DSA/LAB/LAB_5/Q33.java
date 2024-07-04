// Design anagram game using array.
import java.util.Random;
import java.util.Scanner;
public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.println("enter size");
        int n=sc.nextInt();
        sc.nextLine();
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("enter word "+(i+1));
            arr[i] = sc.nextLine();
        }
        Random r = new Random();
        int randomNumber = r.nextInt(n);
        System.out.println("enter anagram of "+arr[randomNumber]);
        String anagram = sc.nextLine();
        char[] ch1=new char[arr[randomNumber].length()];
        char[] ch2=new char[anagram.length()];
        for(int i=0;i<ch1.length;i++){
            ch1[i]=arr[randomNumber].charAt(i);
            ch2[i]=anagram.charAt(i);
        }
        int count=0;
        for(int i=0;i<ch1.length;i++){
            for(int j=0;j<ch1.length;j++){
                if(ch1[i]==ch2[j]){
                    count++;
                    break;
                }
            }
        }
        if(count==(ch1.length)){
            System.out.println("anagram");
        }
        else{
            System.out.println("not anagram");
        }
    }
}
