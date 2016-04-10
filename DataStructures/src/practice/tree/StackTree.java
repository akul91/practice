package practice.tree;

public class StackTree {

	class Node {
		private Tree data;
		private Node next;

		Node(Tree val) {
			data = val;
			next = null;
		}

		public Tree getData() {
			return data;
		}

		public void setData(Tree data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	Node head = null;

	public void push(Tree val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			node.setNext(head);
			head = node;
		}
	}

	public Tree pop() {
		if (head == null)
			return null;
		else if (head.getNext() == null) {
			Tree val = head.getData();
			head = null;
			return val;
		} else {
			Tree val = head.getData();
			head = head.getNext();
			return val;
		}
	}

	public Tree top() {
		if (head == null)
			return null;
		else
			return head.getData();
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void print() {
		Node temp = head;
		if (head != null)
			System.out.print(temp.getData() + " ");
		else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
				System.out.print(temp.getData() + " ");
			}
		}
	}
}
