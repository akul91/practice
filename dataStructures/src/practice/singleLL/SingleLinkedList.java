package practice.singleLL;

public class SingleLinkedList {

	private int data;
	private SingleLinkedList next;

	public SingleLinkedList(int data) {

		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SingleLinkedList getNext() {
		return next;
	}

	public void setNext(SingleLinkedList next) {
		this.next = next;
	}
}
