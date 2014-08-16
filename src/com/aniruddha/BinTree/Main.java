package com.aniruddha.BinTree;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		BST<Integer> numberTree = new BST<>(34);
		Random r = new Random();
		for (int i=0; i<99; i++) {
			numberTree.add(Math.abs(r.nextInt()%100));
		}
		
		numberTree.inorder();
		
        BST<String> stringTree = new BST<>("G");
        stringTree.add("A");
        stringTree.add("N");
        stringTree.add("X");
        
        stringTree.inorder();
	}

}
