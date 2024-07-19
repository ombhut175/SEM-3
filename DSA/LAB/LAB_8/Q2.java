import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    static int i=-1;
    public static char nextChar(String s1){
        if(i>=s1.length()-1){
            return ' ';
        }
        i++;
        return s1.charAt(i);
    }
    public static int checkInfix(char ch){
        if(ch>=97 && ch<=122 || ch>=65 && ch<=90){
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
    public static int rank(char ch){
        if(ch>=65 && ch<=90 || ch>=97 && ch<=122){
            return 1;
        }
        // else if(ch==')'||ch=='('){
        //     return 0;
        // }
        else if(ch>=42 && ch<=47 || ch=='^'){
            return -1;
        }
        else{
            return 0;
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
    public static String reverse(String s){
        char[] ch = new char[s.length()];
        int n=s.length()-1;
        String reversedString = "";
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='('){
                ch[n]=')';
            }
            else if(s.charAt(i)==')'){
                ch[n]='(';
            }
            else{
                ch[n]=s.charAt(i);
            }
            n--;
        }
        for(int i=0;i<s.length();i++){
            reversedString+=ch[i];
        }
        return reversedString;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s1 = sc.nextLine();
        s1 = reverse(s1);
        s1+=")";
        System.out.println("s1 = "+s1);
        System.out.println(s1);
        Stack <Character> s = new Stack<>();
        s.push('(');
        String polish="";
        int rank=0;
        char next = nextChar(s1);
        rank+=rank(next);
        // System.out.println("next at starting = "+next);
        // System.out.println("rank at starting = "+rank);
        int check;
        while (!s.isEmpty() && next!=' ') {
            check=checkInfix(next);
            if(check==1){
                polish=polish+next;
            }
            else if(check==7){
                s.push(next);
            }
            else if(check==5){
                while (!s.isEmpty() && s.peek() != '(') {
                    polish=polish+s.pop();
                }
                if(!s.isEmpty() &&s.peek()=='('){
                    s.pop();
                }
            }
            else if(check==4){
                if(precedence(next)==precedence(s.peek())){
                    polish+=s.pop();
                }
                s.push(next);
            }
            else{
                while(!s.isEmpty() && precedence(s.peek())>precedence(next)){
                    polish+=s.pop();
                }
                s.push(next);
            }
            rank+=rank(next);
            // System.out.println("next = "+next);
            // System.out.println("rank = "+rank);
            // System.out.println("rank of next char  = "+rank(next));
            next=nextChar(s1);
        }
        // System.out.println(s.size());
        // System.out.println("rank = "+rank);
        if(s.size()!=0 || rank!=1){
            System.out.println("invalid string");
        }
        else{
            System.out.println("polish = "+reverse(polish));
        }
    }
}
