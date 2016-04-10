package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InvertBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		TreeNodeOperations.traverseLevelOrder(invertTree(root));
		sc.close();
	}

	public static TreeNode invertTree(TreeNode root) {
		TreeNode temp = root;
		if (root == null || (root.left == null && root.right == null))
			return root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			TreeNode swap = node.left;
			node.left = node.right;
			node.right = swap;
		}
		return temp;
	}

}
