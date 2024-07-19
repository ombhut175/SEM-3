import java.util.Scanner;
import java.util.Stack;

public class Q48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        ConversiontoPrefix c1 = new ConversiontoPrefix(s);
        c1.evaluatePrefix();
        
    }
}

class ConversiontoPrefix{
    String s;
    Stack <Integer> i1 = new Stack<>();
    public ConversiontoPrefix(String s){
        this.s = s;
    }
    public void evaluatePrefix(){
        for(int i=s.length()-1;i>=0;i--){
            char next = s.charAt(i);
            if(Character.isDigit(next)){
                i1.push(Character.getNumericValue(next));
            }
            else{
                int ch1 = i1.pop();
                int ch2 = i1.pop();
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
