package algo.implementation;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int rows = (int) Math.floor(Math.sqrt(s.length())) + 1;
		int columns = rows;
		int count = 0;
		char[] matrix[] = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (count != s.length())
					matrix[i][j] = s.charAt(count++);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] != '\0')
					System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		String enc = new String();
		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < rows; i++) {
				if (matrix[i][j] != '\0')
					enc += matrix[i][j];
			}
			enc += " ";
		}
		System.out.println(enc);
		in.close();
	}
}
