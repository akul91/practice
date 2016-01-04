package practice.doublyLL;

public class DLLOperations {

	void deleteMiddle(int num, DoublyLinkedList head) {

		DoublyLinkedList temp = head;
		if (head.getData() == num) {
			deleteFirst(head);
			return;
		}
		while (temp.getNext().getData() != num) {
			temp = temp.getNext();
		}
		DoublyLinkedList next = temp.getNext().getNext();
		temp.setNext(next);
		if (next != null)
			next.setPrev(temp);
	}

	void deleteLast(DoublyLinkedList head) {

		DoublyLinkedList temp = head;
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
	}

	DoublyLinkedList deleteFirst(DoublyLinkedList head) {
		head = head.getNext();
		return head;
	}

	void addLast(DoublyLinkedList num, DoublyLinkedList head) {
		if (head == null)
			head = num;
		else {
			DoublyLinkedList temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(num);
			num.setPrev(temp);
		}

	}

	DoublyLinkedList addMiddle(DoublyLinkedList num, int prev, DoublyLinkedList head) {

		if (head == null)
			head = num;
		else {
			DoublyLinkedList temp = head;
			while (temp.getNext() != null) {
				if (temp.getData() == prev) {
					num.setNext(temp.getNext());
					num.setPrev(temp);
					temp.setNext(num);
					temp.getNext().setPrev(num);
					break;
				} else
					temp = temp.getNext();
			}
		}
		return head;
	}

	void traverse(DoublyLinkedList head) {
		DoublyLinkedList temp = head;
		System.out.print("List is:" + temp.getData() + " ");
		while (temp.getNext() != null) {
			temp = temp.getNext();
			System.out.print(temp.getData() + " ");
		}
		System.out.println();

	}

	DoublyLinkedList addFirst(DoublyLinkedList num, DoublyLinkedList head) {

		if (head == null)
			head = num;
		else {
			num.setNext(head);
			head.setPrev(num);
			head = num;
		}
		return head;
	}

	public void reverse(DoublyLinkedList head) {
		System.out.print("Reversed List is:");
		if (head == null);	
		else if(head.getNext() == null)
			System.out.print(head.getData());
		else {
			DoublyLinkedList temp = null;
			while (head != null) {
				temp = head.getPrev();
				head.setPrev(head.getNext());
				head.setNext(temp);
				head = head.getPrev();
			}
			temp = temp.getPrev();
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
		System.out.println();
	}
}
