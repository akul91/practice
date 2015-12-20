package practice.stack;

import java.util.Scanner;

class StackLLMain {

	public static void main(String[] args) {

		StackLL queue = new StackLL();

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
				queue.push(scannerObject.nextInt());
				break;
			case 2:
				int val = queue.pop();
				if (val == -1)
					System.out.println("Stack is Empty");
				else
					System.out.println(val);
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
