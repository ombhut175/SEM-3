import java.util.*;

public class Checking {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(5);
		a1.add(6);
		a1.add(7);
//		for(int i:a1){
//			System.out.println(a1.get(i));
//		}
//		System.out.println(a1.size());
//		System.out.println(a1.reversed());
//		Collections.reverse(a1);
//		for (Integer integer : a1) {
//			System.out.println(integer);
//		}
//		int a = a1.remove(1);
//		System.out.println(a);
		Queue<Integer> q1 = new LinkedList<>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		System.out.println(q1.remove());
	}
}
