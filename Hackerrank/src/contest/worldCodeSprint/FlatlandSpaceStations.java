package contest.worldCodeSprint;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c[] = new int[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextInt();
		}
		Arrays.sort(c);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int min=Math.abs(i-c[j]);
				if(min<temp)
					temp=min;
				if(temp==0)
					break;
			}
			if (temp > max)
				max = temp;
		}
		System.out.println(max);
		in.close();

	}

}
