package practice;

import java.util.Scanner;

public class SameTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String[] parts1 = str1.split("\\s+");
		TreeNode root1 = TreeNodeOperations.insert(null, parts1);
		String str2 = sc.nextLine();
		String[] parts2 = str2.split("\\s+");
		TreeNode root2 = TreeNodeOperations.insert(null, parts2);
		System.out.println(isSameTree(root1, root2));
		sc.close();
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		boolean status1, status2;
		if ((p == null && q != null) || (p != null && q == null))
			return false;
		if (p == null && q == null)
			return true;
		if (p.val != q.val)
			return false;
		status1 = isSameTree(p.left, q.left);
		status2 = isSameTree(p.right, q.right);
		return status1 && status2;
	}

}
