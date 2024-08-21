// 97. Write a program to implement Quick Sort using Array.

/**
 * Q97
 */
public class Q97 {
    public static void main(String[] args) {
        int a[] ={2,45,33,56,332,5};
        QuickSort q = new QuickSort();
        q.quickSort(a, 0, a.lengt]);
        for(int i =0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }

    }
}

class QuickSort{
    void quickSort(int[] a,int i,int j){
        if(i>=j) {
            return;
        }
        boolean flag = true;
        int key = a[i];
        int tempI = i;
        int tempJ = j;
        while (flag) {
            tempI++;
            while(a[tempI]<key){
                tempI++;
            }
            tempJ--;
            while(a[tempJ]>key){
                tempJ--;
            }
            if(tempI<tempJ){
                int temp = a[tempI];
                a[tempI] = a[tempJ];
                a[tempJ] = temp;
            }else{
                flag=false;
            }
        }
        int temp = a[tempJ];
        a[tempJ] = key;
        key = temp;
        quickSort(a, i, tempJ);
        quickSort(a, tempJ+1, j);
    }
}