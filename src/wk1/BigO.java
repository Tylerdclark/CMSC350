package wk1;

public class BigO {

	public static void main(String[] args) {
		compareFunctions(25);

	}

	// this method represents n^2 (ignoring the constant)
	private static int quadratic(int n) {
		return (int) Math.pow(n, 2) + 500;

	}

	// this method represents 2^n
	private static int exponential(int n) {
		return (int) Math.pow(2, n);
	}

	public static void compareFunctions(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("n:" + i + " ");
			System.out.print("f1:" + quadratic(i) + " ");
			System.out.print("f2:" + exponential(i) + " ");
			if (exponential(i) > quadratic(i)) {
				System.out.print("f1 < f2\n");
			} else {
				System.out.print("f1 > f2\n");
			}

		}

	}
}
