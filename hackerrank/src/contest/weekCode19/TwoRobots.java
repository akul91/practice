package contest.weekCode19;

import java.util.Scanner;

public class TwoRobots {

	static int[][] arr;
	static int[] min;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int r1 = -1, r2 = -1;
			int dist = 0;
			for (int j = 0; j < n; j++) {
				int s = in.nextInt();
				int d = in.nextInt();
				if (r1 == -1) {
					dist += Math.abs(d - s);
					r1 = d;
				} else {
					if (r1 == d) {
						dist += Math.abs(r1 - s) + Math.abs(d - s);
						r1 = d;
					} else if (r2 == d) {
						dist += Math.abs(r2 - s) + Math.abs(d - s);
						r2 = d;
					} else if (r2 == -1) {
						dist += Math.abs(d - s);
						r2 = d;
					} else if (Math.abs(r1 - s) > Math.abs(r2 - s)) {
						dist += Math.abs(r2 - s) + Math.abs(d - s);
						r2 = d;
					} else {
						dist += Math.abs(r1 - s) + Math.abs(d - s);
						r1 = d;
					}
				}
				// System.out.println(r1 + " " + r2 + " " + dist);
			}
			System.out.println(dist);
		}
	}
}
