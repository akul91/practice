package practice;

import java.util.Scanner;

public class CountAndSay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(countAndSay(sc.nextInt()));
		sc.close();
	}

	public static String countAndSay(int n) {
		String arr[] = new String[n];
		arr[0] = "1";
		for (int i = 1; i < n; i++) {
			String val = arr[i - 1];
			int count = 1;
			String next = "";
			int j;
			for (j = 1; j < val.length(); j++) {
				int ch = (int) (val.charAt(j)) - 48;
				if (ch == (int) (val.charAt(j - 1)) - 48)
					count++;
				else {
					next += count + "" + val.charAt(j - 1);
					count = 1;
				}
			}
			if (i == 1)
				next = "11";
			else
				next += count + "" + val.charAt(j - 1);
			arr[i] = next;
		}
		return arr[n - 1];
	}
}
