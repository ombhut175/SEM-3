import java.util.Scanner;
import java.util.Stack;

public class Q47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        Conversion c1 = new Conversion(s);
        c1.evaluatePostfix();
    }
}

class Conversion{
    String s;
    Stack <Integer> i1 = new Stack<>();
    public Conversion(String s){
        this.s = s;
    }
    public void evaluatePostfix(){
        for(int i=0;i<s.length();i++){
            char next = s.charAt(i);
            // if(next=='+' || next=='-' || next=='*' || next=='/'){
            // }
            if(Character.isDigit(next)){
                i1.push(Character.getNumericValue(next));
            }
            else{
                int ch2 = i1.pop();
                int ch1 = i1.pop();
                switch (next) {
                    case '+':
                            i1.push(ch1+ch2);
                            break;
                    case '-':
                            i1.push(ch1-ch2);
                            break;
                    case '*':
                            i1.push(ch1*ch2);
                            break;
                    case '/':
                            i1.push(ch1/ch2);
                            break;
                    case '^':
                            i1.push((int)Math.pow(ch1, ch2));
                    default:
                        break;
            }
            }
        }
        System.out.println(i1.pop());
    }   
}
