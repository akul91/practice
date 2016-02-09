package algo.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleOpt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> prev = null;
		for (int i = 0; i < n; i++) {
			List<Integer> current = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					current.add(1);
					continue;
				}
				if (prev != null) {
					current.add(prev.get(j - 1) + prev.get(j));
				}
			}
			prev = current;
			list.add(current);
		}
		for (List<Integer> x : list) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
		in.close();
	}

}
