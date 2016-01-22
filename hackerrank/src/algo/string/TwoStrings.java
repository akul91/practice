package algo.string;

import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuffer output = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			String strA = in.next();
			String strB = in.next();
			boolean flag = false;
			for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
				if (strA.contains(new String("" + c)) && strB.contains(new String("" + c))) {
					flag = true;
					break;
				}
			}
			if (flag)
				output.append("YES" + "\n");
			else
				output.append("NO" + "\n");
		}
		System.out.print(output);
		in.close();
	}
}
