package ds.array;

import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String strings[] = new String[n];
		for (int index = 0; index < n; index++) {
			strings[index] = in.next();
		}
		int q = in.nextInt();
		String queries[] = new String[q];
		for (int index = 0; index < q; index++) {
			queries[index] = in.next();
		}
		for (int index = 0; index < q; index++) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (queries[index].equals(strings[i]))
					++count;
			}
			System.out.println(count);
		}
		in.close();
	}

}
