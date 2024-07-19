import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
   private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } 
            catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            String s = reader.nextLine();
            char[] fin = new char[n];
            int start = 0, end = n-1;
            int ptr = n-1;
            boolean from_last = true;
            char c;
            while(ptr>=0){
                c = s.charAt(ptr);
                ptr--;
                if(from_last){
                    fin[end] = c;
                    end--;
                }
                else{
                    fin[start] = c;
                    start++;
                }
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    from_last = !from_last;
                }
            }
            for(char e: fin){
                sb.append(e);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}