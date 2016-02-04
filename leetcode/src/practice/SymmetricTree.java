package practice;

import java.util.Scanner;

public class SymmetricTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		System.out.println(isSymmetric(root));
		sc.close();
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null || (root.right == null && root.left == null))
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		boolean flag = checkSymmetric(left, right);
		return flag;
	}

	public static boolean checkSymmetric(TreeNode left, TreeNode right) {
		if ((left == null && right != null) || (left != null && right == null))
			return false;
		if (left == null && right == null)
			return true;
		if (left.val != right.val)
			return false;
		boolean flag = checkSymmetric(left.left, right.right);
		if (flag)
			flag = checkSymmetric(left.right, right.left);
		return flag;
	}
}
