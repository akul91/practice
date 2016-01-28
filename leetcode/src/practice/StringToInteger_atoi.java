/*Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
package practice;

import java.util.Scanner;

public class StringToInteger_atoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(myAtoi(sc.next()));
		sc.close();
	}

	public static int myAtoi(String str) {
		if (str == null)
			return 0;
		char[] chars = str.toCharArray();
		long val = 0;
		boolean flag = true;
		boolean intg = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '-' || chars[i] == '+') {
				if (i + 1 < chars.length && (chars[i + 1] == '-' || chars[i + 1] == '+')) {
					break;
				}
			}
			if ((int) chars[i] >= 48 && (int) chars[i] <= 57) {
				intg = true;
				if (flag)
					val = val * 10 + ((int) chars[i] - 48);
				else
					val = val * 10 - ((int) chars[i] - 48);
			} else if (val == 0 && chars[i] == '+') {
				if (i + 1 < chars.length && (int) chars[i + 1] >= 48 && (int) chars[i + 1] <= 57) {
				} else
					break;
			} else if (val == 0 && chars[i] == '-') {
				if (i + 1 < chars.length && (int) chars[i + 1] >= 48 && (int) chars[i + 1] <= 57) {
					intg = true;
					val = -((int) chars[i + 1] - 48);
					flag = false;
					++i;
				} else
					break;
			} else if (val != 0 || intg)
				break;
			else if ((int) chars[i] >= 97 && (int) chars[i] <= 123)
				break;
			if (val > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (val < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) val;
	}
}
