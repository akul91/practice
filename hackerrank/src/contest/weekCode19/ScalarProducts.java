package contest.weekCode19;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScalarProducts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		long len = ((long) n * 2) + 2;
		long[][] vec = new long[n][2];
		long first = 0;
		long second = (long) c;
		int j = 0;
		for (int i = 2; i < len; i++) {
			long third = (first + second) % m;
			if (i % 2 == 0)
				vec[j][0] = third;
			else {
				vec[j][1] = third;
				j++;
			}
			first = second;
			second = third;
		}
		Set<Long> set = new TreeSet<Long>();
		for (int i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				long sum = vec[i][0] * vec[j][0] + vec[i][1] * vec[j][1];
				set.add(sum % m);
			}
		}
		System.out.println(set.size());
		in.close();
	}
}
