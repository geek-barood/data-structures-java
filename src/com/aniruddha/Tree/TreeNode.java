package com.aniruddha.Tree;

public class TreeNode<T> {
	private TreeNode<T> left, right;
	private T t;
	
	public TreeNode() {
		
	}
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
	
	public void addLeft(T t) {
		this.left = new TreeNode<T>(t);
	}
	
	public void addRight(T t) {
		this.right = new TreeNode<T>(t);
	}
	
	public boolean isLeaf() {
		if(left==null && right==null) return true;
		return false;
	}
}
