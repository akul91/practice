package practice.doublyLL;

import java.util.Scanner;

public class DLLMain {

	public static void main(String[] args) {

		DoublyLinkedList num;
		DLLOperations opr = new DLLOperations();
		DoublyLinkedList head = null;
		System.out.println("1.Add Infront");
		System.out.println("2.Add Middle");
		System.out.println("3.Add Last");
		System.out.println("4.Delete Infront");
		System.out.println("5.Delete Middle");
		System.out.println("6.Delete Last");
		System.out.println("7.Print");
		System.out.println("8.Reverse");
		System.out.println("9.Exit");

		Scanner scannerObject = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter Choice:");
			int ch = scannerObject.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter number to add:");
				num = new DoublyLinkedList(scannerObject.nextInt());
				head = opr.addFirst(num, head);
				break;
			case 2:
				System.out.println("Enter number to add:");
				num = new DoublyLinkedList(scannerObject.nextInt());
				System.out.println("Enter number before:");
				int prev = scannerObject.nextInt();
				head = opr.addMiddle(num, prev, head);
				break;
			case 3:
				System.out.println("Enter number to add:");
				num = new DoublyLinkedList(scannerObject.nextInt());
				opr.addLast(num, head);
				break;
			case 4:
				head = opr.deleteFirst(head);
				break;
			case 5:
				System.out.println("Enter number to delete:");
				int num1 = scannerObject.nextInt();
				opr.deleteMiddle(num1, head);
				break;
			case 6:
				opr.deleteLast(head);
				break;
			case 7:
				opr.traverse(head);
				break;
			case 8:
				opr.reverse(head);
				break;
			default:
				flag = false;
				break;
			}
		}
		scannerObject.close();
	}

}
