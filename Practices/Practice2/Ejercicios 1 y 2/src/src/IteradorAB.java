package src;

public class IteradorAB {

	public static void main(String[] args) {
		
		//IteradorAB it = new IteradorAB();
		//IteradorAB.iteracionConRecursion(2, 6);
		
		//int[] arr = Multiplos.getMultiplos(4);
		
		//for (int i=0; i < arr.length; i++) {
		//	System.out.println(arr[i]);
		//}
		
		
	}
	
	public static void iteracionConFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void iteracionConWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void iteracionConRecursion(int a, int b) {
		if (b == a) {
			System.out.println(b);
			return;
		}
		iteracionConRecursion(a, b - 1);
		System.out.println(b);
	}
	
	

}
