package contest.worldCodeSprint;

import java.util.Scanner;

public class EmaSupercomputerModified {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] matrix = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = in.next();
			matrix[i] = str.toCharArray();
		}
		int num = 49;
		int rmin, rmax, cmin, cmax;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				boolean flag = false;
				char ch = matrix[i][j];
				if (matrix[i][j] == 'G' || (char) matrix[i][j] < 58) {
					matrix[i][j] = (char) num;
					rmin = i;
					rmax = i;
					cmin = j;
					cmax = j;
					while (true) {
						if (rmin - 1 >= 0 && matrix[rmin - 1][j] == 'G' && cmin - 1 >= 0 && matrix[i][cmin - 1] == 'G'
								&& rmax + 1 <= n - 1 && matrix[rmax + 1][j] == 'G' && cmax + 1 <= m - 1
								&& matrix[i][cmax + 1] == 'G') {
							flag = true;
							rmin -= 1;
							rmax += 1;
							cmin -= 1;
							cmax += 1;
							matrix[rmin][j] = (char) num;
							matrix[rmax][j] = (char) num;
							matrix[i][cmin] = (char) num;
							matrix[i][cmax] = (char) num;
						} else
							break;
					}
				}
				if (!flag)
					matrix[i][j] = ch;
				else
					num++;
			}
		}
		int prod;
		boolean flag = false;
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < m; j++) {
				if (matrix[k][j] == 'G') {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		if (flag)
			prod = 1;
		else
			prod = 0;
		for (int i = num - 1; i > 48; i--) {
			int count = 0;
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < m; j++) {
					if (matrix[k][j] == i)
						++count;
				}
			}
			prod *= count;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(prod);
		in.close();
	}

}
