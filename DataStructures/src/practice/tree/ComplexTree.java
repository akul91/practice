package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Akul-PC
 *
 *         Timmy is trying to ingest a semantic graph into its cognitive
 *         framework to enable a reasoning power similar to that of a human. To
 *         start with, the developers plan to test it by providing a dummy
 *         genealogy (family history) of a single person and to identify people
 *         that belong to that person's generation. Your goal is to develop an
 *         efficient algorithm to perform this task. To keep things simple, they
 *         just use a single relationship "isParentOf" between any two persons.
 *         For example, consider a genealogy represented as a set of triples:
 * 
 *         Mary isParentOf Bob Mary isParentOf Sam Bob isParentOf John Sam
 *         isParentOf Pete Sam isParentOf Katie The persons who belong to Bob's
 *         generation are Bob and Sam. The persons who belong to John's
 *         generation are John, Pete and Katie.
 * 
 *         Assumptions:
 * 
 *         There will be at least two generations (i.e., at least one isParentOf
 *         relationship). There can be a maximum of 15 children to a single
 *         parent No cross relationships would exist i.e., a person can have
 *         only one parent from previous generation No same generation
 *         relationships would exist There can be a maximum of 100 generations
 *         in the genealogy
 * 
 *         Input: R1,R2,R3,R4...Rn,Person
 * 
 *         R1...Rn - A comma separated list of "isParentOf" relationships. Each
 *         relationship being represented by an arrow "Person->Child"
 * 
 *         Person - The name of the person that we are interested in
 * 
 * 
 *         Output: A comma-separated list of names of people belonging to the
 *         specified generation in alphabetical order (single comma and no
 *         spaces between names)
 * 
 *         Note: Please be prepared to provide a video follow-up response to
 *         describe your approach to this exercise.
 * 
 * 
 *         Test 1 Test Input Download Test Input
 *         Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob
 *         Expected Output Download Test Output Bob,Sam Test 2 Test Input
 *         Download Test Input
 *         Sam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob-
 *         >John,Pete Expected Output Download Test Output John,Katie,Pete
 */

public class ComplexTree {

	public static class Tree {
		private String name;
		private List<Tree> child;

		public Tree(String name) {
			this.name = name;
			child = new ArrayList<Tree>();
		}

		public List<Tree> getChildren() {
			return child;
		}

		public void addChildren(Tree node) {
			child.add(node);
		}

		/**
		 * Print nodes level by level
		 * 
		 * @param roots
		 *            list of root nodes
		 */
		public static void printNodes(List<Tree> roots) {
			for (int i = 0; i < roots.size(); i++) {
				System.out.println("Hierarchy 1:" + (i + 1));
				Queue<Tree> queue = new LinkedList<Tree>();
				Tree parent = roots.get(i);
				queue.add(parent);
				while (!queue.isEmpty()) {
					Tree temp = queue.poll();
					System.out.print(temp.name + " ");
					List<Tree> child = temp.getChildren();
					for (int j = 0; j < child.size(); j++) {
						queue.add(child.get(j));
					}
				}
				System.out.println();
			}

		}

		/**
		 * Return parent of the node
		 * 
		 * @param roots
		 *            list of root nodes
		 * @param string
		 *            value to be searched
		 * @return parent node
		 */
		public static Tree checkParent(List<Tree> roots, String string) {
			boolean flag = false;
			Tree node = null;
			for (int i = 0; i < roots.size(); i++) {
				Queue<Tree> queue = new LinkedList<Tree>();
				Tree parent = roots.get(i);
				queue.add(parent);
				while (!queue.isEmpty()) {
					Tree temp = queue.poll();
					if (string.matches(temp.name)) {
						node = temp;
					}
					List<Tree> child = temp.getChildren();
					for (int j = 0; j < child.size(); j++) {
						queue.add(child.get(j));
					}
				}
				if (flag)
					break;
			}
			return node;
		}

		/**
		 * Check whether node is a parent or not.
		 * 
		 * @param roots
		 *            list of root nodes
		 * @param string
		 *            string to be searched
		 * @return boolean value
		 */
		public static boolean hasParent(List<Tree> roots, String string) {
			Tree node = checkParent(roots, string);
			if (node != null)
				return true;
			return false;
		}

		/**
		 * Get all the lists level by level
		 * 
		 * @param roots
		 *            list of root nodes
		 * @return list containing list of nodes at the same level
		 */
		public static List<List<String>> getLists(List<Tree> roots) {
			Queue<Tree> queue = new LinkedList<Tree>();
			List<List<String>> result = new ArrayList<List<String>>();
			if (roots.size() == 0)
				return result;
			queue.offer(roots.get(0));
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<String> list = new ArrayList<String>();
				while (size > 0) {
					Tree temp = queue.poll();
					list.add(temp.name);
					List<Tree> child = temp.getChildren();
					for (int j = 0; j < child.size(); j++) {
						queue.add(child.get(j));
					}
					--size;
				}
				result.add(list);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] parts = str.split(",");
		String input = parts[parts.length - 1];
		List<Tree> roots = null;
		roots = new ArrayList<Tree>();
		for (int i = 0; i < parts.length - 1; i++) {
			String[] names = parts[i].split("->");
			// If there is no root node
			if (roots == null) {
				roots = new ArrayList<Tree>();
				Tree parent = new Tree(names[0]);
				roots.add(parent);
				parent.addChildren(new Tree(names[1]));
			} else {
				if (Tree.hasParent(roots, names[0])) {
					Tree temp = Tree.checkParent(roots, names[0]);
					if (Tree.hasParent(roots, names[1])) {
						Tree node = Tree.checkParent(roots, names[1]);
						temp.addChildren(node);
						roots.remove(node);
					} else
						temp.addChildren(new Tree(names[1]));
				} else if (Tree.hasParent(roots, names[1])) {
					Tree temp = Tree.checkParent(roots, names[1]);
					for (int r = 0; r < roots.size(); r++) {
						if (roots.get(r).name.equals(names[1]))
							roots.remove(roots.get(r));
					}
					Tree parent = new Tree(names[0]);
					roots.add(parent);
					parent.addChildren(temp);
				} else {
					// Completely new node
					Tree parent = new Tree(names[0]);
					roots.add(parent);
					parent.addChildren(new Tree(names[1]));
				}
			}
		}
		// Tree.printNodes(roots);
		List<List<String>> allNodes = Tree.getLists(roots);
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < allNodes.size(); i++) {
			if (allNodes.get(i).contains(input)) {
				for (int j = 0; j < allNodes.get(i).size(); j++) {
					set.add(allNodes.get(i).get(j));
				}
			}
		}
		StringBuffer output = new StringBuffer();
		for (String name : set) {
			output.append(name + ",");
		}
		System.out.println(output.substring(0, output.length() - 1));
		sc.close();
	}
}
