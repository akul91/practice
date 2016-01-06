package algo.implementation;

import java.util.Scanner;

public class MatrixRotationOptimized {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int t = in.nextInt();
		int matrix[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = in.nextInt();
		int levels = Math.min(m, n) / 2;
		int rotations[] = new int[levels];
		int tempm = m, tempn = n;
		for (int l = 0; l < levels; l++) {
			rotations[l] = t % (2 * (tempm + tempn) - 4);
			tempm -= 2;
			tempn -= 2;
		}
		int imax = m - 1, imin = 0, jmin = 0, jmax = n - 1;
		for (int l = 0; l < levels; l++) {
			for (int r = 0; r < rotations[l]; r++) {
				matrix = singleRotation(matrix, imin, imax, jmin, jmax);
			}
			imin++;
			imax--;
			jmin++;
			jmax--;
		}
		printMatrix(matrix, m, n);
		in.close();
	}

	private static int[][] singleRotation(int[][] matrix, int imin, int imax, int jmin, int jmax) {
		for (int toprow = jmin; toprow < jmax; toprow++)
			matrix = swap(matrix, imin, toprow, imin, toprow + 1);
		for (int rightcol = imin; rightcol < imax; rightcol++)
			matrix = swap(matrix, rightcol, jmax, rightcol + 1, jmax);
		for (int bottomrow = jmax; bottomrow > jmin; bottomrow--)
			matrix = swap(matrix, imax, bottomrow, imax, bottomrow - 1);
		for (int leftcol = imax; leftcol > imin + 1; leftcol--)
			matrix = swap(matrix, leftcol, jmin, leftcol - 1, jmin);
		return matrix;
	}

	private static int[][] swap(int[][] matrix, int i, int j, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = temp;
		return matrix;
	}

	private static void printMatrix(int[][] matrix, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
