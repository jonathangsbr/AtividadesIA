package algorithms;

import tree.NodeTree;

public class DeepFirstSearch<T> {

	private T value;
	public NodeTree<T> root;
	private boolean isFoundPre = false;
	private boolean isFoundIn = false;
	private boolean isFoundPos = false;

	public DeepFirstSearch(T value, NodeTree<T> root) {
		this.value = value;
		this.root = root;
	}

	public String preOrderSearch() {
		String result = this.preOrder(root);
		
		return this.isFoundPre ? result : "sem solucao";
	}
	
	public String preOrderPrint() {
		return this.printPreOrder(root);
	}
	
	public String inOrderSearch() {
		String result = this.inOrder(root);
		return this.isFoundIn ? result : "sem solucao " ;
	}
	
	public String inOrderPrint() {
		return this.printInOrder(root);
	}
	
	public String posOrderSearch() {
		String result = this.posOrder(root);
		return this.isFoundPos ? result : "sem solucao " ;
	}
	
	public String posOrderPrint() {
		return this.printPosOrder(root);
	}
	
	private String preOrder(NodeTree<T> node) {
		String result = "";

		if (this.value.equals(node.value)) {
			this.isFoundPre = true;
			result += node.value;
		}
		if (!this.isFoundPre) {
			result += node.value + "  ";
			result += (node.left != null) ? this.preOrder(node.left) : "";
			result += (node.right != null) ? this.preOrder(node.right) : "";
		}
		return result;

	}

	private String printPreOrder(NodeTree<T> node) {
		String result = "";

		result += node.value + "  ";
		result += (node.left != null) ? this.printPreOrder(node.left) : "";
		result += (node.right != null) ? this.printPreOrder(node.right) : "";

		return result;
	}

	private String inOrder(NodeTree<T> node) {
		String result = "";

		if (!this.isFoundIn) {
			result += (node.left != null) ? this.inOrder(node.left) : "";
			if(this.value.equals(node.value)) {
				this.isFoundIn = true;
				result += node.value;
			}
			result += !this.isFoundIn ? node.value + "  " : "";
			result += (node.right != null) ? this.inOrder(node.right) : "";
		}
		return  result;

	}

	private String printInOrder(NodeTree<T> node) {
		String result = "";

		result += (node.left != null) ? this.printInOrder(node.left) : "";
		result += node.value + "  ";
		result += (node.right != null) ? this.printInOrder(node.right) : "";

		return result;
	}

	private String posOrder(NodeTree<T> node) {
		String result = "";

		if (!this.isFoundPos) {
			result += (node.left != null) ? this.posOrder(node.left) : "";
			result += (node.right != null) ? this.posOrder(node.right) : "";
			if (this.value.equals(node.value)) {
				this.isFoundPos = true;
				result += node.value;
			}
			result += !this.isFoundPos ? node.value + "  " : "";

		}
		return result;

	}

	private String printPosOrder(NodeTree<T> node) {
		String result = "";

		result += (node.left != null) ? this.printPosOrder(node.left) : "";
		result += (node.right != null) ? this.printPosOrder(node.right) : "";
		result += node.value + "  ";

		return result;
	}

}
