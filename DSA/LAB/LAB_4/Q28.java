// Suppose you are senior developer for an Relational Database Management System
// named "Array Database" where everything is implemented using only array, today
// your task is to implement aggregate function like sum, min, max, avg. For simplicity,
// assume that your database can only store integers
/**
 * Q28
 */
import java.util.Scanner;
public class Q28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr= {1,5,3,9,7,4};
        System.out.println("enter index 1");
        int index1 = sc.nextInt();
        System.out.println("enter index 2");
        int index2 = sc.nextInt();
        int sum=0,count=0;
        int min=arr[index1];
        int max=arr[index1];
        for(int i=index1;i<=index2;i++){
            sum+=arr[i]; 
            count++;
            if(min>arr[i]){
                min=arr[i];
            }
            else if(max<arr[i]){
                max=arr[i];
            }
        }
        double average = (double)sum/count;
        System.out.println("sum = "+sum);
        System.out.println("average = "+average);
        System.out.println("max = "+max);
        System.out.println("min = "+min);

    }
}