package LAB_17;

public class Q17 {
	public static void main(String[] args) {
		Hashing h1 = new Hashing();
		int[] a = new int[20];
		int[] b = {
				298078, -1, 727146, 537895, 877772, 883515, 202646, 923512,
				583200, 797425, 805091, 723897, 198279, -1, -1, -1,
				-1, 199167, 565216, 236481
		};
		for (int i = 0; i < 20; i++) {
			h1.insert(a,b[i]);
		}
		h1.displayArr(a);
	}
}

class Hashing{
	int hashFunction(int value){
		int key = (value %18) + 2;
		return key;
	}
	void insert(int[] a,int value){
		int key = hashFunction(value);
		int i=1;
		while (a[key]!=0){
			key = linearProbing(key,i);
			i++;
		}
		
		a[key] = value;
	}
	void getElement(int[] a,int value){
		int key = hashFunction(value);
		System.out.println(a[key]);
	}
	void displayArr(int[] a){
		for(int val:a){
			System.out.print(val+" ");
		}
	}
	int linearProbing(int key,int i){
		int newKey = (key+i) % 20;
		return newKey;
	}
}