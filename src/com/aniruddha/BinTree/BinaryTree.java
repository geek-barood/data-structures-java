package com.aniruddha.BinTree;

import com.aniruddha.Tree.*;
public class BinaryTree<T> {
	private TreeNode<T> root;

	private void inorder(TreeNode<T> root) {
		if(root == null) return;

		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}

	public BinaryTree(T t) {
		this.root = new TreeNode(t);
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

	public void TraverseInorder() {
		if(this.root == null) return;
		inorder(this.root);
	}
	
	public static void main(String args[]) {
		BinaryTree<String> tree = new BinaryTree<String>("Root_node");
		tree.addLeft("Work");
		tree.addRight("Hard");
		tree.getRight().addLeft("Very");
		tree.TraverseInorder();
	}
	
}
