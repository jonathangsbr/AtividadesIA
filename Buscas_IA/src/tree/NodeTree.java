package tree;

public class NodeTree<T> {

	public T value;
	public NodeTree<T> left;
	public NodeTree<T> right;

//PreOrder
//A  B  G  M  N  H  I  C  D  E  J  O  K  P  F  G  L  
	
//InOrder
//M  N  G  H  I  B  C  D  O  J  P  K  E  F  L  G  A
	
//PosOrder
//N  M  I  H  G  O  P  K  J  L  G  F  E  D  C  B  A  
	
	public String printInOrder(String v) {
		String str = "";

		if(this.left != null) str += this.left.printInOrder(v);
		str += this.value + "  ";
		if(this.right != null) str += this.right.printInOrder(v);

		return str;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setLeft(NodeTree<T> node) {
		this.left = node;
	}

	public void setRight(NodeTree<T> node) {
		this.right = node;
	}

}