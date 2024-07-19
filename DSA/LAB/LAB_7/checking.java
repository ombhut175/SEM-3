import java.util.Stack;
import java.util.StringTokenizer;

public class checking {
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
        reversedString+=")";
        return reversedString;
    }
    public static void main(String[] args) {
        // String s =  reverse("a+b)");
        // System.out.println(s);
        // Stack <Character> s1 = new Stack<>();
        // s1.push('a');
        // s1.push('b');
        // s1.push('c');
        // s1.set(0, 'd');
        // String s2=s1.toString();
        // System.out.println(s2);
        // System.out.println(s1.nextElement());
        char ch='9';
        System.out.println(Character.isDigit(ch));        
    }
}
