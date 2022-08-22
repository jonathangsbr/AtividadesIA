package algorithms;

import tree.NodeTree;

public class DeepLimitedSearch<T> {

	private T value;
	private int levelLimit;
	private boolean isFoundPre = false;
	private boolean isFoundIn = false;
	private boolean isFoundPos = false;

	public DeepLimitedSearch(T value, int levelLimit) {
		this.value = value;
		this.levelLimit = levelLimit;
	}

	public String preOrder(NodeTree<T> node, int level) {
		String result = "";

		if (this.value.equals(node.value)) {
			isFoundPre = true;
			result += node.value;
		}
		if (!isFoundPre) {
			result += node.value + "  ";
			result += (++level <= this.levelLimit && node.left != null) ? this.preOrder(node.left, level) : "";
			result += (level <= this.levelLimit && node.right != null) ? this.preOrder(node.right, level) : "";
		}
		return isFoundPre ? result : "sem solucao ";

	}

	public String printPreOrder(NodeTree<T> node, int level) {
		String result = "";

		result += node.value + "  ";
		result += (++level <= this.levelLimit && node.left != null) ? this.printPreOrder(node.left, level) : "";
		result += (level <= this.levelLimit && node.right != null) ? this.printPreOrder(node.right, level) : "";

		return result;
	}

	public String inOrder(NodeTree<T> node, int level) {
		String result = "";

		if (!isFoundIn) {
			result += (++level <= this.levelLimit && node.left != null) ? this.inOrder(node.left, level) : "";
			if (this.value.equals(node.value)) {
				isFoundIn = true;
				result += node.value;
			}
			result += !isFoundIn ? node.value + "  " : "";
			result += (level <= this.levelLimit && node.right != null) ? this.inOrder(node.right, level) : "";
		}
		return isFoundIn ? result : "sem solucao ";

	}

	public String printInOrder(NodeTree<T> node, int level) {
		String result = "";

		result += (++level <= this.levelLimit && node.left != null) ? this.printInOrder(node.left, level) : "";
		result += node.value + "  ";
		result += (level <= this.levelLimit && node.right != null) ? this.printInOrder(node.right, level) : "";

		return result;
	}

	public String posOrder(NodeTree<T> node, int level) {
		String result = "";

		if (!isFoundPos) {
			result += (++level <= this.levelLimit && node.left != null) ? this.posOrder(node.left, level) : "";
			result += (level <= this.levelLimit && node.right != null) ? this.posOrder(node.right, level) : "";
			if (this.value.equals(node.value)) {
				isFoundPos = true;
				result += node.value;
			}
			result += !isFoundPos ? node.value + "  " : "";
		}
		return isFoundPos ? result : "sem solucao ";
	}

	public String printPosOrder(NodeTree<T> node, int level) {
		String result = "";

		result += (++level <= this.levelLimit && node.left != null) ? this.printPosOrder(node.left, level) : "";
		result += (level <= this.levelLimit && node.right != null) ? this.printPosOrder(node.right, level) : "";
		result += node.value + "  ";

		return result;
	}

}
