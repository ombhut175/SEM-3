
import java.util.Scanner;
import java.util.Stack;

public class Q39 {
    static  int i=-1;

    public static char nextChar(String s){
       
        i++;
        return s.charAt(i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Character> s = new Stack<Character> ();
        System.out.println("enter string");
        String input = sc.nextLine();
        s.push('c');
        char next = nextChar(input);
        while(next!='c'){
            if(next==' '){
                System.out.println("invalid");
            }
            else{
                s.push(next);
                next=nextChar(input);
            }
        }
        // next=nextChar(input);
        while(s.peek()!='c'){
            next=nextChar(input);
            char x = s.pop();
            if(x!=next){
                System.out.println("invalid string");
                return;
            }
        }
        if(i==input.length()-1){
            System.out.println("invalid");
        }
        else{
            next=nextChar(input);
            
            if(next==' '){
                System.out.println("valid");
            }
            else{
                System.out.println("invalid");
            }
        }   
    }
}
