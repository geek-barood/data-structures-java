package com.aniruddha.BinTree;
import com.aniruddha.Tree.*;

public class BST<T extends Comparable<T>> extends BinaryTree<T> {

	public BST(T t) {
		super(t);
	}
	
	public void add(T t) {
		TreeNode<T> node = root;
		TreeNode<T> parent = null;
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
	
	public TreeNode<T> getMin() {
		TreeNode<T> node = root;
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
	
	public TreeNode<T> getMax() {
		TreeNode<T> node = root;
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}
	
	public TreeNode<T> find(T t) {
		TreeNode<T> node = root;
		while(node!=null && !t.equals(node.getData())) {
			if(t.compareTo(node.getData()) >= 0) {
				node = node.getRight();
			} else {
				node = node.getLeft();
			}
		}
		return node;
	}
	
	public TreeNode<T> findParent(TreeNode<T> t) {
		TreeNode<T> parent = null;
		TreeNode<T> node = root;
		
		// check if given node is root, return null if it is the case
		if (t.getData().equals(root.getData())) {
			return parent; // check here
		}
		
		while (true) {
			if (node.getData().equals(t.getData())) 
				break;
			
			if (node.hasLeft()) {
				if (node.getLeft().getData().compareTo(t.getData()) >= 0) {
					parent = node;
					node = node.getLeft();
				}
			}
			
			if(node.hasRight()) {
				if (node.getRight().getData().compareTo(t.getData()) < 0) {
					parent = node;
					node = node.getRight();
				}
			}
			
		}
		
		if (node.isLeaf() && !node.equals(t)) {
			return null;
		}
		return parent;
		
	}

	public void remove(T t) {
		TreeNode<T> node = find(t);
		if(node != null) {
			if(node.getLeft() != null && node.getRight() != null) {
			// if it is an internal node having 2 children
				
			}
		}
	}

	public static void main(String args[]) {
		BST<String> root = new BST<>("Hello");
		root.add("Mr.");
		root.add("Record");
		root.add("Aniruddha");
		root.traverseInorder();
		System.out.println(root.getMax().getData());
		System.out.println(root.getMin().getData());
		TreeNode<String> node = root.find("Mr.sf");
		TreeNode<String> parent = root.findParent(node);
		System.out.println(parent);
	}

}
