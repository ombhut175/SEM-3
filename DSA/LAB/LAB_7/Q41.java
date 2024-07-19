import java.util.Scanner;
import java.util.Stack;
public class Q41 {
    static int i=-1;
    public static char nextChar(String s){
        if(i>=s.length()-1){
            return '$';
        }
        i++;
        return s.charAt(i);
    }
    public static int checkBraces(char ch){
        switch (ch) {
            case '(':
            case ')': 
                        return 1;
            case '[':
            case ']':
                        return 2;
            case '{':
            case '}':   
                        return 3;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of test cases");
        int tc=sc.nextInt();
        sc.nextLine();
        
        for(int j=0;j<tc;j++){
            i=-1;
            System.out.println("enter string");
            String s = sc.nextLine();
            Stack <Character> s1 = new Stack<>();
            char next = nextChar(s);
            s1.push(next);
            next=nextChar(s);

            while (next!='$') {
                if(!s1.isEmpty() && checkBraces(next)==checkBraces(s1.peek())){
                    s1.pop();
                }
                else{
                    s1.push(next);
                }
                next=nextChar(s);
            }
            if(s1.isEmpty()){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
}
