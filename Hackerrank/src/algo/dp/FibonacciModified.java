package algo.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger first = sc.nextBigInteger();
		BigInteger second = sc.nextBigInteger();
		int nth = sc.nextInt();
		BigInteger arr[] = new BigInteger[nth];
		arr[0] = first;
		arr[1] = second;
		for (int i = 2; i < nth; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1].multiply(arr[i - 1]));
		}
		System.out.println(arr[nth - 1]);
		sc.close();
	}
}
