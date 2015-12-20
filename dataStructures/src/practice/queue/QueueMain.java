package practice.queue;

import java.util.Scanner;

public class QueueMain {

	public static void main(String[] args) {

		Queue queue = new Queue(6);

		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Print");
		System.out.println("4.Return Top");
		System.out.println("5.Length");
		System.out.println("6.Exit");

		while (true) {

			Scanner scannerObject = new Scanner(System.in);
			System.out.println("Enter Choice:");
			int ch = scannerObject.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter number to add:");
				int res = queue.enQueue(scannerObject.nextInt());
				System.out.println("Front=" + queue.getFront() + " Rear=" + queue.getRear());
				if (res == -1)
					System.out.println("Queue is full");
				break;
			case 2:
				int val = queue.deQueue();
				if (val == -1)
					System.out.println("Queue is Empty");
				else
					System.out.println(val);
				System.out.println("Front=" + queue.getFront() + " Rear=" + queue.getRear());
				break;
			case 4:
				if (queue.getRear() == -1)
					System.out.println("Empty");
				else
					System.out.println(queue.rear());
				break;
			case 5:
				System.out.println(queue.getRear());
				break;
			case 3:
				for (int i = queue.getFront(); i < queue.getRear() + 1; i++) {
					if (i == -1)
						System.out.println("Empty");
					else {
						System.out.print(queue.front() + " ");
						queue.deQueue();
					}
				}
				break;
			default:
				System.exit(0);
				break;
			}
			scannerObject.close();
		}
	}
}
