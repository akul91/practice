package algo.implementation;

import java.util.Scanner;

public class ACMICPCTeam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String topic[] = new String[n];
		for (int topic_i = 0; topic_i < n; topic_i++) {
			topic[topic_i] = in.next();
		}
		int result[][] = new int[n * (n - 1) / 2][3];
		int count = 0;
		for (int topic_i = 0; topic_i < n; topic_i++) {
			for (int topic_j = topic_i + 1; topic_j < n; topic_j++) {
				result[count][0] = topic_i + 1;
				result[count][1] = topic_j + 1;
				int val=0;
				for(int x=0;x<m;x++)
					if((int)topic[topic_i].charAt(x)+(int)topic[topic_j].charAt(x)-96>=1)
						val++;
				result[count++][2] = val;
			}
		}
		int max = 0;
		for (int i = 0; i < n * (n - 1) / 2; i++)
			if (max < result[i][2])
				max = result[i][2];
		count = 0;
		for (int i = 0; i < n * (n - 1) / 2; i++)
			if (result[i][2] == max)
				++count;
		System.out.println(max);
		System.out.println(count);
		in.close();
	}

}
