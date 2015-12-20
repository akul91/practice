package practice.queue;

public class QueueLL {

	public class Node {
		private Object data;
		private Node next;

		Node(Object val) {
			data = val;
			next = null;
		}

		public Object getData() {
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

	public void enQueue(Object val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			head = node;
			head.setNext(temp);
		}
	}

	public Object deQueue() {
		if (head == null)
			return null;
		else if (head.getNext() == null) {
			return head;
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

	public void print() {
		Node temp = head;
		if (head == null)
			System.out.print(temp.getData() + " ");
		else {
			System.out.print(temp.getData() + " ");
			while (temp.getNext() != null) {
				temp = temp.getNext();
				System.out.print(temp.getData() + " ");
			}
		}
	}
}
