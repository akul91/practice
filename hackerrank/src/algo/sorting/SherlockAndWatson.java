package algo.sorting;

import java.util.Scanner;

public class SherlockAndWatson {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = in.nextInt();
		k = k % n;
		/*for (int i = 0; i < k; i++) {
			int temp = ar[n - 1];
			for (int j = n - 2; j >= 0; j--)
				ar[j + 1] = ar[j];
			ar[0] = temp;
		}*/
		StringBuffer  str=new StringBuffer();
		for (int i = 0; i < q; i++) {
			int val=in.nextInt();
			if(val-k >= 0)
				val = val-k;
			   else
				   val = n - (k-val);
			str.append(ar[val]+"\n");
		}
		System.out.print(str);
		in.close();

	}

}
