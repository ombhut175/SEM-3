import java.util.Scanner;
import java.util.Stack;

public class Q1claude {
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
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter infix expression:");
    String s1 = sc.nextLine();
    
    Stack<Character> s = new Stack<>();
    String postfix = "";
    i = -1; // Reset the global index
    
    char next = nextChar(s1);
    while (next != ' ') {
        int check = checkInfix(next);
        
        if (check == 1) { // Operand
            postfix += next;
        } else if (check == 7) { // Left parenthesis
            s.push(next);
        } else if (check == 5) { // Right parenthesis
            while (!s.isEmpty() && s.peek() != '(') {
                postfix += s.pop();
            }
            if (!s.isEmpty() && s.peek() == '(') {
                s.pop(); // Discard the '('
            } else {
                System.out.println("Error: Unbalanced parentheses");
                return;
            }
        } else if (check >= 2 && check <= 4) { // Operator
            while (!s.isEmpty() && checkInfix(s.peek()) >= check) {
                postfix += s.pop();
            }
            s.push(next);
        } else if (check == -1) {
            System.out.println("Error: Invalid character encountered");
            return;
        }
        
        next = nextChar(s1);
    }
    
    // Pop any remaining operators from the stack
    while (!s.isEmpty()) {
        if (s.peek() == '(') {
            System.out.println("Error: Unbalanced parentheses");
            return;
        }
        postfix += s.pop();
    }
    
    System.out.println("Postfix = " + postfix);
}
}
