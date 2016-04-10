package practice.tree;

public class QueueTree {

	Node head = null;

	public class Node {
		private Tree data;
		private Node next;

		Node(Tree val) {
			this.data = val;
			this.next = null;
		}

		Node(Node val) {
			this.data = val.getData();
			this.next = val.getNext();
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

	public void enQueue(Tree val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			head = node;
			head.setNext(temp);
		}
	}

	public Node deQueue() {
		if (head == null)
			return null;
		else if (head.getNext() == null) {
			Node temp = new Node(head);
			head = null;
			return temp;
		} else {
			Node temp = head;
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			Node val = temp.getNext();
			temp.setNext(null);
			return val;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public int length() {
		int count = 0;
		if (head == null)
			return count;
		else if (head.getNext() == null)
			return 1;
		else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
				count++;
			}
		}
		return count;
	}

	public Node top() {
		if (head == null)
			return null;
		else if (head.getNext() == null)
			return head;
		else {
			Node temp = head;
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			return temp.getNext();
		}
	}
}
