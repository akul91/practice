package ds.array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArray {

	static int[] wiggleArrangeArray(int[] intArr) {
		// Creating an output array
		int arr[] = new int[intArr.length];
		// Sorting the array in O(nlogn) time
		Arrays.sort(intArr);
		// Filling even places
		int count = 0;
		for (int j = intArr.length - 1; j > intArr.length / 2 - 1; j--) {
			arr[count] = intArr[j];
			count = count + 2;
		}
		// Filling odd places
		count = 1;
		for (int i = 0; i < intArr.length / 2; i++) {
			arr[count] = intArr[i];
			count = count + 2;
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int intArr[] = new int[n];
		for (int index = 0; index < n; index++) {
			intArr[index] = in.nextInt();
		}
		int arr[] = wiggleArrangeArray(intArr);
		for (int index = 0; index < n; index++) {
			System.out.print(arr[index] + " ");
		}
		in.close();
	}
}
