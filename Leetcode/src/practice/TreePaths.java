package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreePaths {
	static List<List<Integer>> paths = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		paths(root, new ArrayList<Integer>());
		System.out.println(paths);
		List<String> result=new ArrayList<String>();
		for(int i=0;i<paths.size();i++){
			List<Integer> list=paths.get(i);
			String singlePath="";
			for(Integer node:list)
				singlePath+="->"+node;
			result.add(singlePath.substring(2, singlePath.length()));
		}
		System.out.println(result);
		sc.close();
	}

	private static List<Integer> paths(TreeNode root, List<Integer> list) {
		if (root == null)
			return list;
		if (root != null && root.left == null && root.right == null) {
			list.add(root.val);
			paths.add(list);
			List<Integer> copy = new ArrayList<Integer>(list);
			copy.remove(list.size() - 1);
			return copy;
		}
		list.add(root.val);
		list = paths(root.left, list);
		list = paths(root.right, list);
		list.remove(list.size() - 1);
		return list;
	}

}
