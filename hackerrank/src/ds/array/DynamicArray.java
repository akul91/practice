package ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
	static List<List<Integer>> sequences = null;
	static int n, lastans;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		sequences = new ArrayList<List<Integer>>(n);
		init(n);
		int q = in.nextInt();
		int queries[][] = new int[q][3];
		for (int index = 0; index < q; index++) {
			queries[index][0] = in.nextInt();
			queries[index][1] = in.nextInt();
			queries[index][2] = in.nextInt();
		}
		for (int index = 0; index < q; index++) {
			if (queries[index][0] == 1)
				insert(queries[index][1], queries[index][2]);
			else
				print(queries[index][1], queries[index][2]);
		}
		in.close();
	}

	private static void init(int n) {
		for (int index = 0; index < n; index++) {
			sequences.add(new ArrayList<Integer>());
		}
	}

	private static void insert(int seq, int num) {
		int sequenceNo = (seq ^ lastans) % n;
		sequences.get(sequenceNo).add(num);
	}

	private static void print(int seq, int num) {
		int sequenceNo = (seq ^ lastans) % n;
		int size = sequences.get(sequenceNo).size();
		int element = num % size;
		lastans = sequences.get(sequenceNo).get(element);
		System.out.println(lastans);
	}
}
