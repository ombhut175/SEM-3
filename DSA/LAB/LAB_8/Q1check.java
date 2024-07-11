import java.util.Scanner;
import java.util.Stack;

public class Q1check {
    static int i = -1;

    public static char nextChar(String s1) {
        if (i >= s1.length() - 1) {
            return ' ';
        }
        i++;
        return s1.charAt(i);
    }

    public static int checkInfix(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return 1;  // Operand
        } else if (ch == '+' || ch == '-') {
            return 2;  // + or -
        } else if (ch == '/' || ch == '*') {
            return 3;  // * or /
        } else if (ch == '^' || ch == '$') {
            return 4;  // ^ or $
        } else if (ch == ')') {
            return 5;  // Right parenthesis
        } else if (ch == '(') {
            return 6;  // Left parenthesis
        } else {
            return -1;  // Invalid character
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix expression:");
        String s1 = sc.nextLine() + ")";  // Add ')' at the end
        Stack<Character> s = new Stack<>();
        s.push('(');  // Push '(' onto the stack initially
        String postfix = "";
        char next = nextChar(s1);
        int check;

        while (next != ' ') {
            check = checkInfix(next);
            if (check == 1) {  // Operand
                postfix += next;
                next = nextChar(s1);
            } else if (check == 6) {  // Left parenthesis
                s.push(next);
                next = nextChar(s1);
            } else if (check == 5) {  // Right parenthesis
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix += s.pop();
                }
                if (!s.isEmpty()) {
                    s.pop();  // Discard the '('
                }
                next = nextChar(s1);
            } else {  // Operator
                while (!s.isEmpty() && precedence(s.peek()) >= precedence(next)) {
                    postfix += s.pop();
                }
                s.push(next);
                next = nextChar(s1);
            }
        }

        while (!s.isEmpty() && s.peek() != '(') {
            postfix += s.pop();
        }

        System.out.println("Postfix = " + postfix);
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
            case '$':
                return 3;
            default:
                return -1;
        }
    }
}
