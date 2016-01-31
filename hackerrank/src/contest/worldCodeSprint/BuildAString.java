package contest.worldCodeSprint;

import java.util.Scanner;

public class BuildAString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			String str = in.next();
			StringBuffer output = new StringBuffer();
			int cost = 0;
			for (int j = 0; j < n; j++) {
				if (output.equals("")) {
					output.append(str.charAt(j));
					cost = a;
				} else {
					if (output.toString().contains(Character.toString(str.charAt(j)))) {
						int maxLen = -1;
						int start = -1, end = -1, s = -1;
						// System.out.println(output);
						for (int k = -1; (k = output.indexOf(Character.toString(str.charAt(j)), k + 1)) != -1;) {
							s = k;
							int len = 1;
							// System.out.println(s + " " + len);
							for (int l = j + 1; l < n; l++) {
								/*
								 * if (output.length() > s + len)
								 * System.out.println(output.charAt(s + len) +
								 * " " + str.charAt(l));
								 */
								if (output.length() > s + len && output.charAt(s + len) == str.charAt(l)) {
									++len;
								} else {
									break;
								}
							}
							// System.out.println(len);
							if (maxLen < len) {
								maxLen = len;
								start = s;
								end = s + len;
							}
						}
						int temp = j;
						j += maxLen - 1;
						// System.out.println(output);
						// System.out.println(start + " " + end);
						if ((end - start) * a > b) {
							output.append(str.substring(start, end));
							// System.out.println(output);
							cost += b;
						} else {
							j = temp;
							output.append(str.charAt(j));
							cost += a;
						}
					} else {
						output.append(str.charAt(j));
						cost += a;
					}
				}
				// System.out.println(j + 1 + " " + cost);
			}
			System.out.println(cost);
		}
		in.close();
	}

}
