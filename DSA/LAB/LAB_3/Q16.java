import java.util.Scanner;
public class Q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int min = arr[0],max=arr[size-1];
        int min_index=0,max_index=0;
        for(int i=1;i<size;i++){
            if(min>arr[i]){
                min = arr[i];
                min_index = i;
            }
            else if(max<arr[i]){
                max = arr[i];
                max_index = i;
            }
        }
        System.out.println("minimum index= "+min_index+"\nmin number = "+min);
        System.out.println("maximum index= "+max_index+"\nmax number = "+max);
        }
}
