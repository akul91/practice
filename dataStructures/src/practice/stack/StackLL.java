package practice.stack;

public class StackLL {

	class Node {
		private int data;
		private Node next;

		Node(int val) {
			data = val;
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
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

	public void push(int val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			head = node;
			head.setNext(temp);
		}
	}

	public int pop() {
		if (head == null)
			return -1;
		else if (head.getNext() == null) {
			int val = head.getData();
			head = null;
			return val;
		} else {
			int val = head.getData();
			head = head.getNext();
			return val;
		}
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
