package algo.implementation;

import java.util.Scanner;

public class TaumAndBday {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int b = in.nextInt();
			int w = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			if (x > y + z)
				x = y + z;
			else if (y > z + x)
				y = z + x;
			System.out.println((long) b * (long) x + (long) w * (long) y);
		}
		in.close();
	}

}
