package contest.adInfinitum14;

import java.util.Arrays;
import java.util.Scanner;

public class MostDistant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] points = new int[n][2];
		int i = 0;
		for (int a0 = 0; a0 < n; a0++) {
			points[i][0] = in.nextInt();
			points[i][1] = in.nextInt();
			i++;
		}
		int miny = Integer.MAX_VALUE, maxy = Integer.MIN_VALUE, minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
		for (i = 0; i < n; i++) {
			if (points[i][0] == 0) {
				if (points[i][1] > maxy)
					maxy = points[i][1];
				if (points[i][1] < miny)
					miny = points[i][1];

			} else {
				if (points[i][0] > maxx)
					maxx = points[i][0];
				if (points[i][0] < minx)
					minx = points[i][0];
			}
		}
		in.close();
		double[] distance = new double[6];
		distance[0] = calculateDistance(0, miny, 0, maxy);
		distance[1] = calculateDistance(0, miny, minx, 0);
		distance[2] = calculateDistance(0, miny, maxx, 0);
		distance[3] = calculateDistance(minx, 0, maxx, 0);
		distance[4] = calculateDistance(minx, 0, 0, maxy);
		distance[5] = calculateDistance(maxx, 0, 0, maxy);
		Arrays.sort(distance);
		System.out.printf("%.24f", distance[5]);
	}

	private static double calculateDistance(int x1, int y1, int x2, int y2) {
		double xdiff = Math.pow(x1 - x2, 2);
		double ydiff = Math.pow(y1 - y2, 2);
		return Math.sqrt(xdiff + ydiff);
	}

}
