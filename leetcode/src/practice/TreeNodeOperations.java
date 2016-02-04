package practice;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeOperations {

	public static TreeNode insert(TreeNode root, String[] parts) {
		Queue<TreeNode> queue = null;
		for (int i = 0; i < parts.length; i++) {
			queue = new LinkedList<TreeNode>();
			if (root == null)
				root = new TreeNode(Integer.parseInt(parts[i]));
			else {
				TreeNode node = null;
				if (!parts[i].equals("null"))
					node = new TreeNode(Integer.parseInt(parts[i]));
				else
					node = new TreeNode(Integer.MIN_VALUE);
				queue.add(root);
				while (!queue.isEmpty()) {
					TreeNode temp = queue.poll();
					if (temp.left == null) {
						temp.left = node;
						break;
					} else if (temp.right == null) {
						temp.right = node;
						break;
					} else {
						queue.add(temp.left);
						queue.add(temp.right);
					}
				}
			}
		}
		return root;
	}

	public static void traverseLevelOrder(TreeNode root) {
		Queue<TreeNode> queue;
		if (root == null)
			System.out.print(root);
		else {
			queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.poll();
				System.out.print(temp.val + " ");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				if (temp.right == null && temp.left == null)
					continue;
			}
		}
	}
}
