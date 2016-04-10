package awesome.questions;

import java.util.Scanner;
import java.util.TreeMap;

public class MaximiseSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			long m = in.nextLong();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextLong();
			}

			long max = Long.MIN_VALUE;
			long pre[] = new long[n];
			pre[0] = arr[0] % m;
			for (int i = 1; i < n; i++) {
				pre[i] = (pre[i - 1] + arr[i]) % m;
			}
			for (int i = 0; i < n; i++) {
				System.out.print(pre[i] + " ");
			}
			System.out.println();
			TreeMap<Long, Integer> treeMap = new TreeMap<Long, Integer>();
			Long diff = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (!treeMap.containsKey(pre[i])) {
					treeMap.put(pre[i], i);
					Long higherKey = treeMap.higherKey(pre[i]);
					System.out.println(i + " " + higherKey);
					if (higherKey != null) {
						Long temp = m + (pre[i] - higherKey);
						System.out.println("Temp:" + temp);
						if (temp > diff) {
							diff = temp;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (max < pre[i])
					max = pre[i];
			}

			max = max > diff ? max : diff;
			System.out.println(max);
		}
		in.close();

	}

	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			long m = in.nextLong();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextLong();
			}

			long max = 0L;
			long pre[] = new long[n];
			pre[0] = arr[0] % m;
			for (int i = 1; i < n; i++) {
				pre[i] = (pre[i - 1] + arr[i]) % m;
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= n - i; j++) {
					long temp = ((pre[j + i - 1] - ((j - 1) >= 0 ? pre[j - 1] : 0) + m) % m);
					max = Math.max(max, temp);
				}
			}
			System.out.println(max);
		}
		in.close();

	}*/
}
