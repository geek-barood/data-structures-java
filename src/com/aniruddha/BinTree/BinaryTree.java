package com.aniruddha.BinTree;

import com.aniruddha.Tree.TreeNode;

public class BinaryTree<T> {
	protected TreeNode<T> root;

	private void inorder(TreeNode<T> node) {
		if(node == null) return;
		else {
			inorder(node.getLeft());
            System.out.println(node.getData());
            inorder(node.getRight());
		}
	}

	public BinaryTree(T t) {
		root = new TreeNode<T>(t);
	}

	public TreeNode<T> getLeft() {
		return root.getLeft();
	}

	public TreeNode<T> getRight() {
		return root.getRight();
	}

	public void addLeft(T t) {
		root.addLeft(t);
	}

	public void addRight(T t) {
		root.addRight(t);
	}

	public void traverseInorder() {
		if(root == null) return;
		inorder(root);
	}
	
}
