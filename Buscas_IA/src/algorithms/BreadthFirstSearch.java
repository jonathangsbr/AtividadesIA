package algorithms;

import queue.Queue;
import tree.NodeTree;

public class BreadthFirstSearch<T> {
	
	private T value;
	private Queue<NodeTree<T>> queue = new Queue<NodeTree<T>>();
	private Queue<NodeTree<T>> queuePrint = new Queue<NodeTree<T>>();
	private boolean isFound = false;
	
	public BreadthFirstSearch(T value) {
		this.value = value;
		
	}
	
	public String search(NodeTree<T> node) {
		String result = "";
		
		if(this.value.equals(node.value)) {
			this.isFound = true;
			result += node.value;
		}
		if(!isFound) {
			result += node.value + "  ";
			if(node.left != null) {
				queue.enqueue(node.left);
			}
			if(node.right != null) {
				queue.enqueue(node.right);
			}
			if(!queue.isEmpty()) {
				result += this.search(queue.dequeue());
			}
		}
		return isFound ? result : "sem solucao";
	}
	
	public String print(NodeTree<T> node) {
		String result = "";
		
		result += node.value + "  ";
		if(node.left != null) {
			queuePrint.enqueue(node.left);
		}
		if(node.right != null) {
			queuePrint.enqueue(node.right);
		}
		if(!queuePrint.isEmpty()) {
			result += this.print(queuePrint.dequeue());
		}
		return result;
		
	}
}
