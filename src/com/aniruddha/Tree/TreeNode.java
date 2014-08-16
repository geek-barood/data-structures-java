package com.aniruddha.Tree;

public class TreeNode<T> {
	private TreeNode<T> left, right;
	private T t;
	
	public TreeNode(T t) {
		this.t = t;
		this.left = null;
		this.right = null;
	}

	public boolean hasLeft() {
		return this.left != null;
	}

	public boolean hasRight() {
		return this.right != null;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public T getData() {
		return t;
	}
	
	public void setData(T t) {
		this.t = t;
	}
	
	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}
	
	public void setRight(TreeNode<T> node) {
		this.right = node;
	}
	

	@Override
	public String toString() {
		return "TreeNode: " + t;
	}

	public boolean isLeaf() {
		if(left==null && right==null) return true;
		return false;
	}
}
