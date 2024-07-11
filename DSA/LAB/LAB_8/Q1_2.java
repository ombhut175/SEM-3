import java.util.Scanner;
import java.util.Stack;

public class Q1_2 {
    static int i=-1;
    public static char nextChar(String s1){
        if(i>=s1.length()-1){
            return ' ';
        }
        i++;
        return s1.charAt(i);
    }
    public static int checkInfix(char ch){
        if(ch>=97 && ch<=122){
            return 1;
        }
        else if(ch=='+' || ch=='-'){
            return 2;
        }
        else if(ch=='/'|| ch=='*'){
            return 3;
        }
        else if(ch=='^'){
            return 4;
        }
        else if(ch==')'){
            return 5;
        }
        else if(ch=='('){
            return 7;
        }
        else{
            return -1;
        }
    }
    public static int precedence(char ch){
        switch (ch) {
            case '+':
            case'-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s1 = sc.nextLine();
        Stack <Character> s = new Stack<>();
        s.push('(');
        String polish="";
        char next = nextChar(s1);
        int check;
        while (!s.isEmpty() && next!=' ') {
            check=checkInfix(next);
            if(check==1){
                polish=polish+next;
                next=nextChar(s1);
            }
            else if(check==7){
                s.push(next);
                next=nextChar(s1);
            }
            else if(check==5){
                while (!s.isEmpty() && s.peek() != '(') {
                    polish=polish+s.pop();
                    next=nextChar(s1);
                    if(!s.isEmpty() &&s.peek()=='('){
                        s.pop();
                        break;
                    }
                }
            }
            else{
                while(!s.isEmpty() && precedence(s.peek())>=precedence(next)){
                    polish+=s.pop();
                }
                s.push(next);
                next=nextChar(s1);
            }
        }
        while (!s.isEmpty() && s.peek()=='(') {
            polish+=s.pop();
        }
        // s.pop();
        System.out.println("polish = "+polish);
    }
}
