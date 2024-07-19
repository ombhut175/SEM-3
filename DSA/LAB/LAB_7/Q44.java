import java.util.Scanner;
import java.util.Stack;
public class Q44 {
    static int i = -1;
    public static char nextChar(String s) {
        if (i >= s.length() - 1) {
            return '$';
        }
        i++;
        return s.charAt(i);
    }
    public static int checkVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return 1;
            default:
                return -1;
        }
    }
    public static String reverse(String s) {

        char[] ch = new char[s.length()];
        int n = s.length() - 1;
        String reversedString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ch[n] = ')';
            }
            else if (s.charAt(i) == ')') {
                ch[n] = '(';
            }
            else {
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
        System.out.println("enter number of test cases");
        int tc = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < tc; j++) {
            i = -1;
            System.out.println("enter size of string");
            int size = sc.nextInt();
            sc.nextLine();
            System.out.println("enter string");
            String s = sc.nextLine();
            if (s.length() != size) {
                System.out.println("size and given string is not same");
                return;
            }
            Stack < Character > s1 = new Stack < > ();
            char next = nextChar(s);
            s1.push(next);
            next = nextChar(s);
            while (next != '$') {
                int check = checkVowel(next);
                int tempM = s1.size() - 1;
                int tempN = 0;
                if (check == 1) {
                    while (tempN < tempM) {
                        char ch1 = s1.elementAt(tempM);
                        char ch2 = s1.elementAt(tempN);
                        s1.setElementAt(ch2, tempM);
                        s1.setElementAt(ch1, tempN);
                        tempM--;
                        tempN++;
                    }
                }
                s1.push(next);
                next = nextChar(s);
            }
            s = "";
            while (!s1.isEmpty()) {
                s += s1.pop();
            }
            s = reverse(s);
            System.out.println(s);
        }
    }
}