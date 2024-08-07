package LAB_7;

public class Q42_2 {
    public static void main(String[] args) {
        String s = new String();
        StringBuilder sb1 = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='*'){
                if(sb1.length()>0){
                sb1.setLength(sb1.length()-1);
                }
            }
            else{
                sb1.append(ch);
            }
        }
    }
}
