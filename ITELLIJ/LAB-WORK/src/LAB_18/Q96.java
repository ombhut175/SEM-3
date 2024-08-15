package LAB_18;

public class Q96 {
    public static void main(String[] args) {
            int[] a = {7,20,4,11,8,2};
            MergeSort ms1 = new MergeSort();
            ms1.mergeSort(a,0,a.length-1);
//            for (int i = 0; i < a.length; i++) {
//                System.out.print(a[i]+" ");
//            }
            ms1.display(a);
    }
}
class MergeSort{
    void mergeSort(int[] a,int low,int high){
        if (low>=high){
            return;
        }
        int mid = low+(high-low)/ 2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }
    void merge(int[] a, int low, int mid, int high){
        int n1 = mid - low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i=0,j=0,k=low;
        for (i = 0; i < n1; i++) left[i] = a[low+i];
        for (j=0;j<n2;j++) right[j] = a[mid+1+j];
        i=0;
        j=0;
        k=low;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]) a[k++] = left[i++];
            else a[k++] = right[j++];
        }
        while (i<n1) a[k++] = left[i++];
        while (j<n2) a[k++] = right[j++];
    }
    void display(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}