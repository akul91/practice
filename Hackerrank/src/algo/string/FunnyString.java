package algo.string;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int k = 0; k < n; k++) {
			String st = sc.next();
			char str[] = st.toCharArray();
			char rev[] = new String(new StringBuffer(st).reverse()).toCharArray();
			boolean flag = true;
			for (int i = 1; i < str.length; i++)
				if (Math.abs((int) str[i] - (int) str[i - 1]) != Math.abs((int) rev[i] - (int) rev[i - 1])) {
					flag = false;
					break;
				}
			if (flag)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
			sc.close();
		}
	}

}
