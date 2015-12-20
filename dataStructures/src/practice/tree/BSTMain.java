
package practice.tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BSTMain {

	static Tree root = null;

	static BSTOperations treeOp = new BSTOperations();

	public static void main(String[] args) {

		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Print Level Order");
		System.out.println("4.In Order");
		System.out.println("5.Pre Order");
		System.out.println("6.Post Order");
		System.out.println("7.Height of Tree");
		System.out.println("8.Exit");

		while (true) {

			Scanner scannerObject = new Scanner(System.in);
			System.out.println("\nEnter Choice:");
			int ch = scannerObject.nextInt();
			switch (ch) {
			case 1:
				treeInsertion();
				break;
			case 2:
				System.out.println("Delete With Recursion");
				treeOp.deleteTree(root);
				System.out.println("\nDelete Without Recursion");
				treeOp.deleteTreeWR(root);
				break;
			case 3:
				treeOp.traverseLevelOrder(root);
				break;
			case 4:
				System.out.println("InOrder With Recursion");
				treeOp.traverseInOrder(root);
				System.out.println("\nInOrder Without Recursion");
				treeOp.traverseInOrderWR(root);
				break;
			case 5:
				System.out.println("PreOrder With Recursion");
				treeOp.traversePreOrder(root);
				System.out.println("\nPreOrder Without Recursion");
				treeOp.traversePreOrderWR(root);
				break;
			case 6:
				System.out.println("PostOrder With Recursion");
				treeOp.traversePostOrder(root);
				System.out.println("\nPostOrder Without Recursion");
				treeOp.traversePostOrderWR(root);
				break;
			case 7:
				System.out.print("Height With Recursion is:");
				System.out.println(treeOp.printHeight(root));
				System.out.print("Height Without Recursion is:");
				System.out.println(treeOp.printHeightWR(root));
				break;
			default:
				System.exit(0);
				break;
			}
			scannerObject.close();
		}
	}

	private static void treeInsertion() {
		try {

			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(
					new FileReader("E:\\Pratice\\Data Structures\\src\\resources\\treeInput.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				Tree node = new Tree(Integer.parseInt(line));
				root = treeOp.insert(node, root);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Present");
		} catch (IOException e) {
			System.out.println("File Ended");
		}
	}

}
