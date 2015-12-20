package practice.tree;

public class Tree {

	private int data;
	private Tree leftNode;
	private Tree rightNode;

	Tree(int val) {
		data = val;
		leftNode = null;
		rightNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Tree getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Tree leftNode) {
		this.leftNode = leftNode;
	}

	public Tree getRightNode() {
		return rightNode;
	}

	public void setRightNode(Tree rightNode) {
		this.rightNode = rightNode;
	}
}
