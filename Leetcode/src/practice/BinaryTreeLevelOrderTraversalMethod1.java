package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeLevelOrderTraversalMethod1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split("\\s+");
		TreeNode root = TreeNodeOperations.insert(null, parts);

		List<List<Integer>> result=levelOrder(root);
		System.out.println(result);
		sc.close();
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        queue.offer(root);
        List<Integer> list=new ArrayList<Integer>();
        queue.offer(new TreeNode(-1000));
        while(queue.peek()!=null){
            TreeNode temp=queue.poll();
            if(temp.val==-1000 && queue.peek()!=null){
                result.add(list);
                list=new ArrayList<Integer>();
            }
            else{
                list.add(temp.val);
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
                if(queue.peek()!=null && queue.peek().val==-1000)
                    queue.offer(new TreeNode(-1000));
            }
        }
        return result;
        
    }

}
