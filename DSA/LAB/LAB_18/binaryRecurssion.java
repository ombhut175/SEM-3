

public class binaryRecurssion {
    public static void main(String[] args) {
        int[] a = {12,6,3,5,2};
        int[] sorted = bubbleSort(a, 0,0);
        for(int i=0;i<sorted.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    static int[] bubbleSort(int a[],int i,int j){
        if(j==a.length-1){
            return a;
        }
        if(a[i]>a[i+1]){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
        i++;
        if(i==a.length-j-1){
            i=0;
            j++;
        }
        return bubbleSort(a, i,j);
    }
}

