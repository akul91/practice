package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int days = sc.nextInt();
			int breads = sc.nextInt();
			List<Integer> count = new ArrayList<Integer>();
			count.add(breads);
			int[] breadsAte = new int[days];
			for (int j = 0; j < days; j++) {
				breadsAte[j] = sc.nextInt();
			}

			for (int j = 0; j < days; j++) {
				int val = breadsAte[j] - count.get(count.size() - 1);
				while (val > 0) {
					count.set(count.size() - 1, 0);
					count.add(breads);
					val = val - count.get(count.size() - 1);
				}
				count.set(count.size() - 1, Math.abs(val));
				if (val == 0 && j == days - 1) {
					break;
				}
				if (count.get(count.size() - 1) > 1)
					count.set(count.size() - 1, count.get(count.size() - 1) - 1);
				else {
					count.set(count.size() - 1, 0);
					if (j != days - 1)
						count.add(breads);
				}
			}
			sc.close();
			System.out.println(count.size());
		}
	}

}
