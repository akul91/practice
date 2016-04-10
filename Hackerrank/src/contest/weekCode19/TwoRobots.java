package contest.weekCode19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoRobots {

	static int arr[][];
	static int distance;

	static class Tree {
		private int r1Pos;
		private int r2Pos;
		private int value;
		private Tree r1;
		private Tree r2;

		Tree() {
			r1Pos = -1;
			r2Pos = -1;
			value = Integer.MIN_VALUE;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			if (n > 1) {
				arr = new int[n][2];
				Tree root = makeTree(n);
				for (int j = 0; j < n; j++) {
					arr[j][0] = in.nextInt();
					arr[j][1] = in.nextInt();
				}
				distance = Integer.MAX_VALUE;
				getMinimum(root, 1, 0);
			} else
				distance = Math.abs(in.nextInt() - in.nextInt());
			System.out.println(distance);
		}
		in.close();
	}

	private static void getMinimum(Tree root, int robot, int i) {
		if (root.value > distance)
			return;
		if (i == 0) {
			root.value = Math.abs(arr[0][1] - arr[0][0]);
			root.r1Pos = arr[0][1];
			root.r1.value = root.value;
			root.r1.r1Pos = root.r1Pos;
			root.r2.value = root.value;
			root.r2.r1Pos = root.r1Pos;
		} else {
			if (robot == 1) {
				root.value += Math.abs(root.r1Pos - arr[i][0]) + Math.abs(arr[i][1] - arr[i][0]);
				root.r1Pos = arr[i][1];
				if (root.r1 != null && root.r2 != null) {
					root.r1.value = root.value;
					root.r1.r1Pos = root.r1Pos;
					root.r1.value = root.value;
					root.r1.r2Pos = root.r2Pos;
					root.r2.value = root.value;
					root.r2.r1Pos = root.r1Pos;
					root.r2.value = root.value;
					root.r2.r2Pos = root.r2Pos;

				}
			} else {
				if (root.r2Pos == -1) {
					root.value += Math.abs(arr[i][1] - arr[i][0]);
				} else {
					root.value += Math.abs(root.r2Pos - arr[i][0]) + Math.abs(arr[i][1] - arr[i][0]);
				}
				root.r2Pos = arr[i][1];
				if (root.r1 != null && root.r2 != null) {
					root.r1.value = root.value;
					root.r1.r1Pos = root.r1Pos;
					root.r1.value = root.value;
					root.r1.r2Pos = root.r2Pos;
					root.r2.value = root.value;
					root.r2.r1Pos = root.r1Pos;
					root.r2.value = root.value;
					root.r2.r2Pos = root.r2Pos;
				}
			}
		}
		if (root.r1 == null && root.r2 == null) {
			distance = Math.min(distance, root.value);
			return;
		}
		if (root.r1 != null && i + 1 < arr.length)
			getMinimum(root.r1, 1, i + 1);
		if (root.r2 != null && i < arr.length)
			getMinimum(root.r2, 2, i + 1);
	}

	private static Tree makeTree(int n) {
		Tree struct = new Tree();
		List<Tree> list = new ArrayList<Tree>();
		if (n > 0)
			list.add(struct);
		for (int i = 1; i < n; i++) {
			List<Tree> copy = new ArrayList<Tree>();
			for (int j = 0; j < list.size(); j++) {
				Tree temp = list.get(j);
				temp.r1 = new Tree();
				copy.add(temp.r1);
				temp.r2 = new Tree();
				copy.add(temp.r2);
			}
			list = copy;
		}
		return struct;
	}
}
