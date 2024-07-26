
import java.util.Scanner;

public class Q44_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc-->0){
            int n=sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] ch = new char[n];
            int curr=n-1;
            int ind=n-1;
            int j=n-1;
            int i=0;
            int add=-1;
            while(curr>0){
                ch[ind] = s.charAt(curr);
                ind=ind+add;
                if("aeiou".indexOf(s.charAt(curr))!=-1){
                    if(add==-1){
                        j=ind;
                        ind=i;
                        add=1;
                    }
                    else{
                        i=ind;
                        ind=j;
                        add=-1;
                    }
                }
                curr--;
            }
            System.out.println(String.valueOf(ch));
        }
    }
}
