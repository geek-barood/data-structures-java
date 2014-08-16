package com.aniruddha.BinTree;
import com.aniruddha.Tree.*;

public class BST<T extends Comparable<T>> {

	private TreeNode<T> root;
	private int size;
	private static boolean first;
	
	public BST(T t) {
		root = new TreeNode<T>(t);
		++size;
	}
	
	public BST(TreeNode<T> node) {
		root = node;
		++size;
	}

	public int size() {
		return size;
	}

	public TreeNode<T> find(T t) {
		TreeNode<T> node = root;
		while (node != null && node.getData().equals(t)) {
			if (t.compareTo(node.getData()) < 0)
				node = node.getLeft();
			else
				node = node.getRight();
		}
		return node;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void inorder() {
		first = true;
		System.out.print("[ ");
		if (root != null) inorderHelper(root);
		first = false;
		System.out.println(" ]");
	}

	public void add(TreeNode<T> node) {
		addHelper(root, node);
		++size;
	}
	
	public void add(T t) {
		addHelper(root, new TreeNode<T>(t));
		++size;
	}

	public void remove(T t) {
		if (this.size() == 1) 
			return;
		
		if (root.getData().equals(t)) {
			if (root.hasLeft()) {
				T data = root.getLeft().getData();
				remove(data);
				root.setData(data);
			} else {
				T data = root.getRight().getData();
				remove(data);
				root.setData(data);
			}
		} else {
			int child = 0;
			TreeNode<T> parent = null;
			// first find the parent of the node
			TreeNode<T> cur = root;
			while (cur != null && !cur.getData().equals(t)) {
				parent = cur;
				if (t.compareTo(cur.getData()) < 0) {
					cur = cur.getLeft();
					child = 0;
				} else {
					cur = cur.getRight();
					child = 1;
				}
			}
			removeHelper(cur, parent, child);
		}
	}

	private void inorderHelper(TreeNode<T> node) {
		if (node.hasLeft()) 
			inorderHelper(node.getLeft());
		if (!first) 
			System.out.print(", ");
		else
			first = false;
		System.out.print(node.getData());

		if (node.hasRight())
			inorderHelper(node.getRight());
	}
	
	private void addHelper(TreeNode<T> curr, TreeNode<T> node) {
		if (node.getData().compareTo(curr.getData()) < 0) {
			if (!curr.hasLeft()) {
				curr.setLeft(node);
			} else {
				addHelper(curr.getLeft(), node);
			}
		} else {
			if (!curr.hasRight()) {
				curr.setRight(node);
			} else {
				addHelper(curr.getRight(), node);
			}
		}
	}

	private TreeNode<T> findMax(TreeNode<T> node) {
		while (node.hasRight()) {
			node = node.getRight();
		}
		return node;
	}

	private void removeHelper(TreeNode<T> node, TreeNode<T> parent, int child) {
		// if node is a leaf then set the parent to point to null instead of node
		if (node.isLeaf()) {
			if (child == 0) 
				parent.setLeft(null);
			else 
				parent.setRight(null);
		} else if (node.hasLeft() && node.hasRight()) {
		// if the node has two children
			TreeNode<T> inorderPredecessor = findMax(node.getLeft());
			if (child == 0) {
				T data = inorderPredecessor.getData();
				remove(inorderPredecessor.getData());
				parent.getLeft().setData(data);
			} else {
				T data = inorderPredecessor.getData();
				remove(inorderPredecessor.getData());
				parent.getRight().setData(data);
			}
		} else {
			if (child == 0) {
				if (node.hasLeft()) {
					parent.setLeft(node.getLeft());
				} else {
					parent.setLeft(node.getRight());
				}
			} else {
				if (node.hasLeft()) {
					parent.setRight(node.getLeft());
				} else {
					parent.setRight(node.getRight());
				}
			}
		}
		--size;
	}

}
