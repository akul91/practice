package practice.queue;

public class Queue {

	int[] arr;
	int front, rear;

	public Queue(int n) {
		arr = new int[n];
		front = -1;
		rear = 0;
	}

	public int enQueue(int val) {
		if (rear == arr.length - 1)
			return -1;
		else if (front == -1 && rear == -1) {
			front = 0;
			arr[front] = val;
		} else
			arr[++rear] = val;
		return 1;
	}

	public int deQueue() {
		if (front == -1 || front == rear) {
			front = rear = -1;
			return -1;
		} else
			return arr[front++];
	}

	public int rear() {
		return arr[rear];
	}

	public int front() {
		return arr[front];
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}
}
