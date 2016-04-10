package algo.greedy;

import java.util.Scanner;

public class LargestPermutation {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int k = stdin.nextInt();
		int arr[] = new int[n];
		int index[]=new int[n+1];
		for (int i = 0; i < n; i++){
			arr[i] = stdin.nextInt();
			index[arr[i]]=i;
		}
		for (int i = 0; i < k; i++) {
			if (i > n - 1)
				break;
			int pos = index[n-i];
			if (pos != i) {
				int temp = arr[pos];
				index[arr[i]]=pos;
				arr[pos]=arr[i];
				arr[i]=temp;
				index[n-i]=i;
			}
			else
				++k;
		}

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		stdin.close();
	}

}
