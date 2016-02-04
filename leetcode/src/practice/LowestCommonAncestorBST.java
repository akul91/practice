package practice;

import java.util.Scanner;

public class LowestCommonAncestorBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		System.out.println(lowestCommonAncestor(root, new TreeNode(sc.nextInt()), new TreeNode(sc.nextInt())).val);
		sc.close();
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.val > p.val && root.val > q.val)
			root = lowestCommonAncestor(root.left, p, q);
		if (root.val < p.val && root.val < q.val)
			root = lowestCommonAncestor(root.right, p, q);
		return root;
	}

}
