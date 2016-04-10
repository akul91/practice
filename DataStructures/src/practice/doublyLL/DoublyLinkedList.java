package practice.doublyLL;

public class DoublyLinkedList {

	private int data;
	private DoublyLinkedList next;
	private DoublyLinkedList prev;

	public DoublyLinkedList(int data) {

		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedList getNext() {
		return next;
	}

	public void setNext(DoublyLinkedList next) {
		this.next = next;
	}

	public DoublyLinkedList getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedList prev) {
		this.prev = prev;
	}

}
