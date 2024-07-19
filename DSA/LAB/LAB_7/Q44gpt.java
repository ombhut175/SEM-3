import java.util.Scanner;
import java.util.Stack;

public class Q44gpt {
    static int i = -1;

    // Function to fetch the next character from the string
    public static char nextChar(String s) {
        if (i >= s.length() - 1) {
            return '$';
        }
        i++;
        return s.charAt(i);
    }

    // Function to check if a character is a vowel
    public static boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    // Function to reverse a string
    public static String reverse(String s) {
        char[] ch = new char[s.length()];
        int n = s.length() - 1;
        String reversedString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ch[n] = ')';
            } else if (s.charAt(i) == ')') {
                ch[n] = '(';
            } else {
                ch[n] = s.charAt(i);
            }
            n--;
        }
        for (int i = 0; i < s.length(); i++) {
            reversedString += ch[i];
        }
        return reversedString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int tc = sc.nextInt();
        sc.nextLine();

        for (int j = 0; j < tc; j++) {
            i = -1;
            System.out.println("Enter size of string:");
            int size = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter string:");
            String s = sc.nextLine();
            
            // Validate input size
            if (s.length() != size) {
                System.out.println("Size and given string are not the same.");
                return;
            }
            
            Stack<Character> stack = new Stack<>();
            char next = nextChar(s);
            stack.push(next);
            next = nextChar(s);

            while (next != '$') {
                if (isVowel(next)) {
                    // Reverse the stack
                    Stack<Character> tempStack = new Stack<>();
                    while (!stack.isEmpty()) {
                        tempStack.push(stack.pop());
                    }
                    stack = tempStack;
                }
                stack.push(next);
                next = nextChar(s);
            }

            // Build final reversed string
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            // Reverse brackets as per the reverse function requirement
            String finalString = reverse(result.toString());
            System.out.println(finalString);
        }
    }
}
