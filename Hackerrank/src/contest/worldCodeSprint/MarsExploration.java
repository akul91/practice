package contest.worldCodeSprint;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int len = S.length();
		int seq = len / 3;
		String[] parts = new String[seq];
		for(int i=0;i<seq;i++)
			parts[i]=S.substring(3*i, (3*i)+3);
		int count = 0;
		for (int i = 0; i < seq; i++) {
			char[] sos = parts[i].toCharArray();
			if (sos[0] != 'S')
				++count;
			if (sos[1] != 'O')
				++count;
			if (sos[2] != 'S')
				++count;
		}
		System.out.println(count);
		in.close();
	}
}
