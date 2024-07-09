
import java.util.Scanner;
import java.util.Stack;

public class Q40 {
    static int i=-1;
    static char nextchar (String s){
        if(i==s.length()){
            return '5';
        }
        i++;
        return s.charAt(i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        Stack <Character> s1 = new Stack<>();
        char next = nextchar(s);
        s1.push(next);
        int count1=1;
        int count2=0;
        for(int i=0;i<s.length()-1;i++){
            next=nextchar(s);
            if(next==' '){
                break;
            }
            if(s1.peek()==next){
                s1.push(next);
                count1++;
            }
            else{
                count2++;
            }
        }
        if(count1==count2){
            System.out.println("valid string");
        }
        else{
            System.out.println("invalid string");
        }
    }
}
