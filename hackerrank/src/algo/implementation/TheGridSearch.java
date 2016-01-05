package algo.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheGridSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String G[] = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String P[] = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			String result[][] = new String[r][R];
			for (int p = 0; p < r; p++) {
				for (int g = 0; g < R; g++) {
					if (G[g].contains(P[p])) {
						String val = new String();
						for (int i = -1; (i = G[g].indexOf(P[p], i + 1)) != -1;)
							val += i + ",";
						result[p][g] = val;
					}
				}
			}
			if (check(result, r, R))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();
	}

	private static boolean check(String[][] result, int pattern, int grid) {
		boolean flag = false;
		for (int g = 0; g < grid; g++) {
			if (result[0][g] != null) {
				List<String> intersect = (List<String>) Arrays.asList(result[0][g].split(","));
				flag = true;
				int val = g;
				for (int p = 1; p < pattern; p++) {
					String value = result[p][++val];
					if (value != null) {
						intersect = checkIntersection(intersect, value);
						if (intersect.size() == 0)
							flag = false;
					} else
						flag = false;
				}
				if (flag)
					return flag;
			}
		}
		return false;
	}

	private static List<String> checkIntersection(List<String> intersect, String newVal) {
		String newArr[] = newVal.split(",");
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < newArr.length; i++)
			if (intersect.contains(newArr[i]))
				newList.add(newArr[i]);
		return newList;
	}
}
