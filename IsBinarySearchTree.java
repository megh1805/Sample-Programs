package program_challenge;

import java.util.ArrayList;
import java.util.List;
//binary search tree using inroder
public class IsBinarySearchTree {

	static class Node{
		int value;
		Node left,right=null;

		Node(int value,Node left,Node right){
			this.value=value;
			this.left=left;
			this.right=right;
		}
	}

	static List<Node> list= new ArrayList<>();

	public static void inorder(Node n) {
		if (n!=null) {
			inorder(n.left);
			list.add(n);
			inorder(n.right);
		}
	}

	public static boolean isBST(Node n) {
		if (n==null)
			return true;
		if (n.left!=null &&n.left.value>=n.value)
			return false;
		if (n.right!=null&&n.right.value<=n.value)
			return false;
		if (!isBST(n.left)||!isBST(n.right))
			return false;

		return true;

	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);
		inorder(n2);
		int max = list.get(0).value;
		for (int i=0;i<list.size();i++) {
			if (i!=0&& list.get(i).value<=max) {
				System.out.println("not BST");
				return;
			}else {
				max=list.get(i).value;
			}
		}
		System.out.println("BST");

	}

}
