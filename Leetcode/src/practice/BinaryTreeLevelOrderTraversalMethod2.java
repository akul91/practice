package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeLevelOrderTraversalMethod2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		List<List<Integer>> result = levelOrderBottom(root);
		System.out.println(result);
		sc.close();
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			while (size > 0) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
				--size;
			}
			result.add(0,list);
		}

		return result;
	}

}
