package algo.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// Using BigInteger because factorial of number greater than 20
				// will be out of range of long data type
				BigInteger result = (factorial(i).divide(factorial(j))).divide(factorial(i - j));
				System.out.print(result + " ");
			}
			System.out.println();
		}
		in.close();
	}

	private static BigInteger factorial(int n) {
		BigInteger val = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++)
			val = val.multiply(BigInteger.valueOf(i));
		return val;
	}

}
