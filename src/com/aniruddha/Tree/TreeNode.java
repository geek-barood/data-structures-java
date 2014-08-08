package com.aniruddha.Tree;

public class TreeNode<T> {
	private TreeNode left, right;
	private T t;
	
	public TreeNode() {
		
	}
	public TreeNode(T t) {
		this.t = t;
		this.left = null;
		this.right = null;
	}
	public TreeNode getLeft() {
		return left;
	}
	public TreeNode getRight() {
		return right;
	}
	public T getData() {
		return t;
	}
	
	public void addLeft(T t) {
		this.left = new TreeNode(t);
	}
	
	public <T extends Comparable<T>>void addRight(T t) {
		this.right = new TreeNode(t);
	}
}
