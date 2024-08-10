package LAB_18;

public class Q96 {
    public static void main(String[] args) {

    }
}
class MergeSort{
    int[] mergeSort(int a[],int low,int high){
        if(low<=high){
        int mid = (low+high)/2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        }
        return a;
    }
}