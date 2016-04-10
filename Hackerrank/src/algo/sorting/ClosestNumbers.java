package algo.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = in.nextInt();
		int min = Integer.MAX_VALUE;
		/*for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(ar[i] - ar[j]) < min)
					min = Math.abs(ar[i] - ar[j]);
			}
		}*/
		Arrays.sort(ar);
		for (int i = 1; i < n; i++) {
			if (Math.abs(ar[i-1] - ar[i]) < min)
				min = Math.abs(ar[i-1] - ar[i]);
		}
		for (int i = 1; i < n; i++) {	
			if (Math.abs(ar[i-1] - ar[i]) == min)
				System.out.print(ar[i-1] + " " + ar[i] + " ");
		}
		in.close();

	}

}
