package wk1;

public class BigO {

	public static void main(String[] args) {
		 for (int i = 0; i < 10; i++) {
			 System.out.print(quadraticTime(i)+" ");
			 System.out.print(exponentialTime(i)+ "\n");
			 
		 }
	}
	public static int quadraticTime(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				n++;
			}
		}
		return n;
	}
	public static int exponentialTime(int n) {
		return (int) Math.pow(2, n);
	}
	

}
