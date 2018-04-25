package program_challenge;
//Program to check if Binary Search Tree(BST) contains a particular node.

class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class TreeContains {

	
	public static boolean contains(Node root, int value) {
		if( root.value==value)
	     return true;
	    if(root.value > value && root.left != null && contains(root.left,value)) return true;
	    if(root.value < value && root.right != null && contains(root.right,value)) return true;
	    // no matching node was found
	    return false;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(contains(n2, 3));
	}

}
