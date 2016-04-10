package other;

import java.io.IOException;
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuffer out = new StringBuffer("");
		for (int index = 0; index < n; index++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if (a == b && b == c)
				out.append("Equilateral" + "\n");
			else if (a == b || b == c || a == c)
				out.append("Isoceles" + "\n");
			else
				out.append("None of these" + "\n");
		}
		System.out.print(out);
		in.close();

	}
}
