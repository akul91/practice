package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class July {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String numbers[] = input.split(" ");

		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(numbers[i]);
			long copy = num;
			long digit = 0;
			boolean flag = false;
			while (copy != 0) {
				digit = copy % 10;
				if (digit == 0) {
					flag = true;
					copy = copy / 10;
				} else
					break;
			}
			if (digit == 5 || flag)
				System.out.println(num * 4);
			else
				System.out.println(num);
		}
	}
}
