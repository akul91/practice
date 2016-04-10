package practice.singleLL;

public class SLLOperations {

	void deleteMiddle(int num, SingleLinkedList head) {

		SingleLinkedList temp = head;
		if (head.getData() == num) {
			deleteFirst(head);
			return;
		}
		while (temp.getNext().getData() != num) {
			temp = temp.getNext();
		}
		SingleLinkedList next = temp.getNext().getNext();
		temp.setNext(next);
	}

	void deleteLast(SingleLinkedList head) {

		SingleLinkedList temp = head;
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
	}

	SingleLinkedList deleteFirst(SingleLinkedList head) {
		head = head.getNext();
		return head;
	}

	void addLast(SingleLinkedList num, SingleLinkedList head) {
		if (head == null)
			head = num;
		else {
			SingleLinkedList temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(num);
		}

	}

	SingleLinkedList addMiddle(SingleLinkedList num, int prev, SingleLinkedList head) {

		if (head == null)
			head = num;
		else {
			SingleLinkedList temp = head;
			while (temp.getNext() != null) {
				if (temp.getData() == prev) {
					num.setNext(temp.getNext());
					temp.setNext(num);
					break;
				} else
					temp = temp.getNext();
			}
		}
		return head;
	}

	void traverse(SingleLinkedList head) {
		SingleLinkedList temp = head;
		System.out.print("List is:" + temp.getData() + " ");
		while (temp.getNext() != null) {
			temp = temp.getNext();
			System.out.print(temp.getData() + " ");
		}
		System.out.println();

	}

	SingleLinkedList addFirst(SingleLinkedList num, SingleLinkedList head) {

		if (head == null)
			head = num;
		else {
			num.setNext(head);
			head = num;
		}
		return head;
	}

	public void reverse(SingleLinkedList head) {
		SingleLinkedList temp = null, rev = null;
		while (head != null) {
			rev = new SingleLinkedList(head.getData());
			rev.setNext(temp);
			temp = rev;
			head = head.getNext();
		}
		while (rev != null) {
			System.out.print(rev.getData() + " ");
			rev = rev.getNext();
		}
	}
}
