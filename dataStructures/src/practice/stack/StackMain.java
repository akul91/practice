package practice.stack;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {

		Stack stack = new Stack(6);

		System.out.println("1.Push");
		System.out.println("2.Pop");
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
				int res = stack.push(scannerObject.nextInt());
				if (res == -1)
					System.out.println("Stack is full");
				break;
			case 2:
				if (stack.getTop() == -1)
					System.out.println("Stack is Empty");
				else
					System.out.println(stack.pop());
				break;
			case 4:
				if (stack.getTop() == -1)
					System.out.println("Empty");
				else
					System.out.println(stack.top());
				break;
			case 5:
				System.out.println(stack.getTop());
				break;
			case 3:
				for (int i = stack.getTop() + 1; i > 0; i--) {
					if (i == -1)
						System.out.println("Empty");
					else {
						System.out.print(stack.top() + " ");
						stack.pop();
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
