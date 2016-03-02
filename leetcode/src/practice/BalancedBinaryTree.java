package practice;

import java.util.Scanner;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		System.out.println(isBalanced(root));
		sc.close();
	}

	public static boolean isBalanced(TreeNode root) {
		if (getHeight(root, 0) == -1)
			return false;
		return true;
	}

	public static int getHeight(TreeNode root, int height) {
		if (root == null)
			return height;
		int leftHeight = getHeight(root.left, height + 1);
		int rightHeight = getHeight(root.right, height + 1);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight);
	}

}
