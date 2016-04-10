package practice.tree;

public class BSTOperations {

	QueueTree deleteTree = null;

	Tree insert(Tree node, Tree root) {
		QueueTree queue;
		if (root == null)
			root = node;
		else {
			queue = new QueueTree();
			queue.enQueue(root);
			while (!queue.isEmpty()) {
				Tree temp = queue.deQueue().getData();
				if (temp.getData() > node.getData()) {
					if (temp.getLeftNode() == null)
						temp.setLeftNode(node);
					else
						queue.enQueue(temp.getLeftNode());
				} else {
					if (temp.getRightNode() == null)
						temp.setRightNode(node);
					else
						queue.enQueue(temp.getRightNode());
				}
			}
		}

		return root;
	}

	public void traverseInOrder(Tree root) {
		if (root == null)
			return;
		traverseInOrder(root.getLeftNode());
		System.out.print(root.getData() + " ");
		traverseInOrder(root.getRightNode());
	}

	public void traverseInOrderWR(Tree root) {
		if (root == null)
			return;
		StackTree stack = new StackTree();
		stack.push(root);
		stack.push(root);
		while (true) {
			Tree temp = stack.pop();

			while (temp.getLeftNode() != null) {
				temp = temp.getLeftNode();
				stack.push(temp);
			}
			while (!stack.isEmpty()) {
				temp = stack.pop();
				System.out.print(temp.getData() + " ");
				if (temp.getRightNode() != null) {
					stack.push(temp.getRightNode());
					stack.push(temp.getRightNode());
					break;
				}
			}
			if (stack.isEmpty())
				break;
		}
	}

	public void traversePreOrder(Tree root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		traversePreOrder(root.getLeftNode());
		traversePreOrder(root.getRightNode());
	}

	public void traversePreOrderWR(Tree root) {
		if (root == null)
			return;
		StackTree stack = new StackTree();
		stack.push(root);
		stack.push(root);
		System.out.print(root.getData() + " ");
		while (true) {
			Tree temp = stack.pop();
			while (temp.getLeftNode() != null) {
				temp = temp.getLeftNode();
				stack.push(temp);
				System.out.print(temp.getData() + " ");
			}
			while (!stack.isEmpty()) {
				temp = stack.pop();
				if (temp.getRightNode() != null) {
					System.out.print(temp.getRightNode().getData() + " ");
					stack.push(temp.getRightNode());
					stack.push(temp.getRightNode());
					break;
				}
			}
			if (stack.isEmpty())
				break;
		}
	}

	public void traversePostOrder(Tree root) {
		if (root == null)
			return;
		traversePostOrder(root.getLeftNode());
		traversePostOrder(root.getRightNode());
		System.out.print(root.getData() + " ");
	}

	public void traversePostOrderWR(Tree root) {
		if (root == null)
			return;
		deleteTree = new QueueTree();
		StackTree stack = new StackTree();
		if (root.getRightNode() != null)
			stack.push(null);
		stack.push(root);
		stack.push(root);
		StackTree stackPrint = new StackTree();
		while (true) {
			Tree temp = stack.pop();

			while (temp.getLeftNode() != null) {
				temp = temp.getLeftNode();
				if (temp.getRightNode() != null) {
					stack.push(null);
				}
				stack.push(temp);
			}
			while (!stack.isEmpty()) {
				temp = stack.pop();
				if (temp != null) {
					if (temp.getRightNode() == null) {
						deleteTree.enQueue(temp);
						System.out.print(temp.getData() + " ");
					} else if (temp.getRightNode() != null) {
						stackPrint.push(temp);
						stack.push(temp.getRightNode());
						stack.push(temp.getRightNode());
						break;
					}
				} else
					while (stackPrint.top() != null) {
						if (stackPrint.top().getRightNode() == stack.top()
								|| checkPrintValue(stackPrint.top(), stack.top()))
							break;
						else {
							deleteTree.enQueue(stackPrint.top());
							System.out.print(stackPrint.pop().getData() + " ");
						}
					}
			}
			if (stack.isEmpty()) {
				while (stackPrint.top() != null) {
					deleteTree.enQueue(stackPrint.top());
					System.out.print(stackPrint.pop().getData() + " ");
				}
				break;
			}
		}
	}

	private boolean checkPrintValue(Tree stackPrintNode, Tree stackNode) {
		if (stackPrintNode.getRightNode().getLeftNode() == stackNode)
			return true;
		else {
			Tree node = stackPrintNode.getRightNode().getLeftNode();
			while (node != null) {
				if (node.getLeftNode() != null && node.getLeftNode() == stackNode)
					return true;
				node = node.getLeftNode();
			}
		}
		return false;
	}

	public int traverseLevelOrder(Tree root) {
		QueueTree queue;
		if (root == null)
			return -1;
		else {
			queue = new QueueTree();
			queue.enQueue(root);
			while (!queue.isEmpty()) {
				Tree temp = queue.deQueue().getData();
				System.out.print(temp.getData() + " ");
				if (temp.getLeftNode() != null) {
					queue.enQueue(temp.getLeftNode());
				}
				if (temp.getRightNode() != null) {
					queue.enQueue(temp.getRightNode());
				}
				if (temp.getRightNode() == null && temp.getLeftNode() == null)
					continue;
			}
		}
		return 1;
	}

	public Tree deleteTree(Tree root) {
		if (root == null)
			return null;
		deleteTree(root.getLeftNode());
		deleteTree(root.getRightNode());
		System.out.print(root.getData() + " ");
		root = null;
		return null;
	}

	public void deleteTreeWR(Tree root) {

		traversePostOrderWR(root);
		System.out.println("\n");
		while (!deleteTree.isEmpty())
			System.out.print(deleteTree.deQueue().getData().getData() + " ");

	}

	public int printHeight(Tree root) {
		if (root == null)
			return 0;
		else
			return Math.max(printHeight(root.getLeftNode()), printHeight(root.getRightNode())) + 1;
	}

	public int printHeightWR(Tree root) {
		QueueTree queue;
		int height = 1;
		if (root == null)
			return -1;
		else {
			queue = new QueueTree();
			queue.enQueue(root);
			queue.enQueue(null);
			while (!queue.isEmpty()) {
				Tree temp = queue.deQueue().getData();
				if (temp != null) {
					if (temp.getLeftNode() != null)
						queue.enQueue(temp.getLeftNode());
					if (temp.getRightNode() != null)
						queue.enQueue(temp.getRightNode());
				} else {
					if (queue.top() == null)
						break;
					++height;
					queue.enQueue(null);
				}

			}
		}
		return height;
	}
}
