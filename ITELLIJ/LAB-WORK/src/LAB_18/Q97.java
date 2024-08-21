package LAB_18;

// 97. Write a program to implement Quick Sort using Array.

/**
 * Q97
 */
public class Q97 {
	public static void main(String[] args) {
		int[] a ={42,23,74,11,65,58,94,36,99,87};
		QuickSort q = new QuickSort();
		q.quickSort(a);
		for (int j : a) {
			System.out.print(j + " ");
		}
	}
}

class QuickSort{
	void quickSort(int[] a){
		quickSort(a,0,a.length-1);
	}
	private void quickSort(int[] a,int i,int j){
		if(!(i<j)) return;
		boolean flag = true;
		int tempI = i;
		int tempJ = j+1;
		int key = a[i];
		while (flag) {
			do tempI++;
			 while (tempI != a.length - 1 && a[tempI] < key);
			do tempJ--;
			while (tempJ != 0 && a[tempJ] > key);
			if(tempI<tempJ){
				int temp = a[tempI];
				a[tempI] = a[tempJ];
				a[tempJ] = temp;
			}else flag=false;
		}
		int temp = a[tempJ];
		a[tempJ] = a[i];
		a[i] = temp;
		quickSort(a, i, tempJ-1);
		quickSort(a, tempJ+1, j);
	}
}
