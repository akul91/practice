package algo.implementation;

import java.util.Scanner;

public class SherlockandSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int count = 0;
			for (int i = (int) Math.floor(Math.sqrt(start)); i <= Math.ceil(Math.sqrt(end)); i++)
				if (start <= i * i && i * i <= end)
					count++;
			System.out.println(count);
		}
		in.close();
	}

}
