import java.util.Scanner;
import java.util.Stack;

public class Q1 {
    static int i=-1;
    public static char nextChar(String s){
        if(i>=s.length()-1){
            return ' ';
        }
        i++;
        return s.charAt(i);
    }
    public static int spf(char s){
        if(s>=65 && s<=90){
            return 8;
        }
        else if(s>=97 && s<=122){
            return 8;
        }
        else if(s=='+'||s=='-'){
            return 2;
        }
        else if(s=='*' || s=='/'){
            return 4;
        }
        else if(s=='^'){
            return 5;
        }
        else if(s=='('){
            return 0;
        }
        else{
            return -1;
        }
    }
    public static int ipf(char s){
        if(s>=65 && s<=90){
            return 7;
        }
        else if(s>=97 && s<=122){
            return 7;
        }
        else if(s=='+'||s=='-'){
            return 1;
        }
        else if(s=='*' || s=='/'){
            return 3;
        }
        else if(s=='^'){
            return 6;
        }
        else if(s=='('){
            return 9;
        }
        else if(s==')'){
            return 0;
        }
        else{
            System.out.println("invalid");
            return -1;
        }
    }
    public static int rank(char s){
        if(s=='+'||s=='-'||s=='*'||s=='/'||s=='^'){
            return -1;
        }
        else if (s>=65||s<=122){
            return 1;
        }
        else{
            System.out.println("invalid");
            return 2;
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter string");
       String s = sc.nextLine();
       String polish="";
       int rank=0;
       char next;
       Stack <Character> s1 = new Stack<>();
       s1.push('(');
       next=nextChar(s);
       if (s1.empty()) {
           System.out.println("empty");
           return;
       }
       while (next!=' ') {
          while (!s1.isEmpty() &&spf(s1.peek())>ipf(next)) {
                char temp=s1.pop();
                polish+=temp;
                rank+=rank(temp);
                if(rank<1){
                    System.out.println("invalid");
                    return;
                }
          }
          if((!s1.isEmpty() && spf(s1.peek())!=ipf(next))){
            s1.push(next);
        }
            else{
            s1.pop();
            }
        next=nextChar(s);
    }   
        if( (s1.isEmpty()==false) ||rank!=1){
        System.out.println("invalid string");
        return;
        }
        else{
        System.out.println("valid");
        }
        System.out.println("polish = "+polish);
    }    
}
