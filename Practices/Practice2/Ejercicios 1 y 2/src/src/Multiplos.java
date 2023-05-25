package src;

public class Multiplos {
	
	public static int[] getMultiplos(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = n * (i+1);
		}
		return arr;
	}
}
