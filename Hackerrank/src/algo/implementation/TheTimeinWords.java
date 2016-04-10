package algo.implementation;

import java.util.Scanner;

public class TheTimeinWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		String time[] = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
				"Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five", "Twenty Six", "Twenty Seven",
				"Twenty Eight", "Twenty Nine" };
		String message = new String();
		if (m == 00)
			message = time[h - 1] + " o' clock";
		else if (m == 15)
			message = "quarter past " + time[h - 1];
		else if (m == 30)
			message = "half past " + time[h - 1];
		else if (m == 45)
			message = "quarter to " + time[h];
		else if (m == 01)
			message = time[m-1] + " minute past " + time[h - 1];
		else if (m > 01 && m < 30)
			message = time[m-1] + " minutes past " + time[h - 1];
		else if (m == 59)
			message = time[60 - m - 1] + " minute to " + time[h];
		else if (m > 30 && m < 59)
			message = time[60 - m - 1] + " minutes to " + time[h];

		System.out.println(message.toLowerCase());
		in.close();
	}
}
