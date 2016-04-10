package practice.queue;

import java.util.Scanner;

import practice.queue.QueueLL.Node;

public class QueueMainLL {

	public static void main(String[] args) {

		QueueLL queue = new QueueLL();

		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Print");
		System.out.println("6.Exit");

		while (true) {

			Scanner scannerObject = new Scanner(System.in);
			System.out.println("Enter Choice:");
			int ch = scannerObject.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter number to add:");
				queue.enQueue(scannerObject.nextInt());
				break;
			case 2:
				Node val = (Node) queue.deQueue();
				if (val == null)
					System.out.println("Queue is Empty");
				else
					System.out.println(val.getData());
				break;
			case 3:
				System.out.println(queue.isEmpty());
				queue.print();
				break;
			default:
				System.exit(0);
				break;
			}
			scannerObject.close();
		}
	}
}
