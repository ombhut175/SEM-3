import java.util.Scanner;

public class Q25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int l=sc.nextInt();
        int[] arr = new int[l];
        for(int i=0;i<l;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(arr[i]==arr[j]){
                    for(int k=j;k<l-1;k++){
                        arr[k]=arr[k+1];
                    }
                    l--; 
                    j--;
                }
            }
        }
        for(int i=0;i<l;i++){
            System.out.println(arr[i]+" ");
        }
    }  
}
    
