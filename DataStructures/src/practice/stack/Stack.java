package practice.stack;

public class Stack {

	int[] arr;
	int top;

	Stack(int n) {
		arr = new int[n];
		top = -1;
	}

	public int push(int val) {
		if (top == arr.length - 1)
			return -1;
		else
			arr[++top] = val;
		return 1;
	}

	public int pop() {
		if (top == -1)
			return -1;
		else
			return arr[top--];
	}

	public int top() {
		return arr[top];
	}

	public int getTop() {
		return top;
	}
}
