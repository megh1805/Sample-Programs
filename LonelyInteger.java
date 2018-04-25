package program_challenge;

public class LonelyInteger {
	private static int SIZE = 101;
	static int lonelyinteger(int[] a) {
		int N = a.length;
		int[] C = new int[SIZE];
		for (int i = 0; i < N; C[a[i++]]++){}
		for (int i = 0; i < SIZE; i++){
			if (C[i] == 1){
				return i;
			}
		}
		return -1;
	}
	public void x() {
		System.out.println("megha");
	}

	public static void main(String[] args) {
		int[] a = {0,0,1,3,1,3,2};
		int result = lonelyinteger(a);
		System.out.println(result);
	}
}
