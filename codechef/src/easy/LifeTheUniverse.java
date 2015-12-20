package easy;

import java.util.Scanner;

public class LifeTheUniverse {

	public static void main(String[] args) throws java.io.IOException {
		int x, y, count = 0;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		for (int i = 0; i < x; i++) {
			if (sc.nextInt() % y == 0)
				++count;
		}
		sc.close();
		System.out.println(count);
	}
}
