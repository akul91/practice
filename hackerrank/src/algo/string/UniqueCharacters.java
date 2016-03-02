package algo.string;

import java.util.Scanner;

public class UniqueCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int checker = 0;
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println(1 << val);
			if ((checker & (1 << val)) > 0) {
				flag = true;
				break;
			}
			checker |= (1 << val);
		}
		if (flag)
			System.out.println("false");
		else
			System.out.println("true");
		sc.close();
	}

}
