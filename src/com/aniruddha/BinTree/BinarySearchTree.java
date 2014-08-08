package com.aniruddha.BinTree;
import com.aniruddha.Tree.*;
public class BinarySearchTree<T> extends BinaryTree {

	private TreeNode<T> root;
	public BinarySearchTree(T t) {
		super((Comparable) t);
		// TODO Auto-generated constructor stub
	}
	
	public <T extends Comparable<T>> void insert(T t) {
		if(t.compareTo((T) root) < 0) {
			if(root.getRight() == null) {
				root.addRight((T)t);
			}
		}
	}

}
