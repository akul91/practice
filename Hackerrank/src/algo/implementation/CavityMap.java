package algo.implementation;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String grid[] = new String[n];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			grid[grid_i] = in.next();
		}
		for (int grid_i = 0; grid_i < n; grid_i++) {
			if (grid_i != 0 && grid_i != n - 1) {
				for (int grid_j = 1; grid_j < grid[grid_i].length() - 1; grid_j++) {
					if (grid[grid_i].charAt(grid_j - 1) != 'X' && grid[grid_i - 1].charAt(grid_j) != 'X'
							&& (int) (grid[grid_i].charAt(grid_j)) > (int) (grid[grid_i].charAt(grid_j + 1))
							&& (int) (grid[grid_i].charAt(grid_j)) > (int) (grid[grid_i + 1].charAt(grid_j))
							&& (int) (grid[grid_i].charAt(grid_j)) > (int) (grid[grid_i].charAt(grid_j - 1))
							&& (int) (grid[grid_i].charAt(grid_j)) > (int) (grid[grid_i - 1].charAt(grid_j)))
						grid[grid_i] = grid[grid_i].substring(0, grid_j) + "X"
								+ grid[grid_i].substring(grid_j + 1, grid[grid_i].length());
				}
			}
			System.out.println(grid[grid_i]);
		}
		in.close();
	}
}
