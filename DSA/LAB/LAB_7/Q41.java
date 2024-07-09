import java.util.Scanner;
public class Q41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(0);
        System.out.println("enter number of test cases");
        int tc=sc.nextInt();
        
        for(int i=0;i<tc;i++){
            System.out.println("enter string");
            String s = sc.nextLine();
            int count1=0,count2=0;
            for(char ch:s.toCharArray()){
                if(ch=='(' || ch=='{' || ch=='['){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            if(count1==count2){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
}
