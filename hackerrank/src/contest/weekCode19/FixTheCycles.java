package contest.weekCode19;

import java.util.Scanner;

public class FixTheCycles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		int f = in.nextInt();
		int min = 0;
		if (e + d + a < 0)
			min = 0 - (e + d + a);
		if (b + f + a < 0)
			min = Math.max(min, Math.abs(b + f + a));
		if (b + c + d + a < 0)
			min = Math.max(min, Math.abs(b + c + d + a));
		System.out.println(min);
		in.close();
	}

}
