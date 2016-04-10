package algo.implementation;

import java.util.Scanner;

public class CaesarCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		char[] str = sc.next().toCharArray();
		int k = sc.nextInt();
		if (k > 26)
			k = k % 26;
		for (int i = 0; i < len; i++) {
			if (((int) str[i] >= 65 && (int) str[i] <= 90) || ((int) str[i] >= 97 && (int) str[i] <= 122)) {
				if ((((int) str[i] >= 65 && (int) str[i] <= 90) && (((int) str[i] + k) > 90))
						|| ((int) str[i] >= 97 && (int) str[i] <= 122) && ((int) str[i] + k) > 122)
					str[i] = (char) ((int) str[i] - 26 + k);
				else
					str[i] = (char) ((int) str[i] + k);
			}
		}
		System.out.println(str);
		sc.close();
	}
}
