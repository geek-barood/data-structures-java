package com.aniruddha.BinTree;
import com.aniruddha.Tree.*;

public class BST extends BinaryTree {

	public BST(Comparable t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	public void add(Comparable t) {
		TreeNode node = root;
		TreeNode parent = null;
		while(true) {
			if(node == null) {
				break;
			}
			if(node.getData().compareTo(t) >= 0) {
				parent = node;
				node = node.getLeft();
			} else {
				parent = node;
				node = node.getRight();
			}
		}
		
		if(parent.getData().compareTo(t) < 0) {
			parent.addRight(t);
		} else {
			parent.addLeft(t);
		}
	}
	
	public TreeNode getMin() {
		TreeNode node = root;
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
	
	public TreeNode getMax() {
		TreeNode node = root;
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}
	
	public TreeNode find(Comparable t) {
		TreeNode node = root;
		while(node!=null && !t.equals(node.getData())) {
			if(t.compareTo(node.getData()) >= 0) {
				node = node.getRight();
			} else {
				node = node.getLeft();
			}
		}
		return node;
	}
	
	public TreeNode findParent(Comparable t) {
		TreeNode node = root;
		while(!node.isLeaf() && (node.getLeft().equals(t) || node.getRight().equals(t))) {
			if(node.getLeft().getData().compareTo(t) >= 0) {
				node = node.getRight();
			} else {
				node = node.getLeft(); //check here
			}
		}
		return node;
	}
	public void remove(Comparable t) {
		TreeNode node = find(t);
		if(node != null) {
			if(node.getLeft() != null && node.getRight() != null) {
			// if it is an internal node having 2 children
				
			}
		}
	}
	public static void main(String args[]) {
		BST root = new BST("Hello");
		root.add("Mr.");
		root.add("Record");
		root.add("Aniruddha");
		root.traverseInorder();
		System.out.println(root.getMax().getData());
		System.out.println(root.getMin().getData());
		System.out.println(root.find("Mr.sf"));
	}

}
