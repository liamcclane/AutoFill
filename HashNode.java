package com.autofillproject;
import java.util.HashMap;

public class HashNode {
	
	// attributes
	public HashMap<Character, HashNode> children;
	public boolean isCompleteWord;
	
	
	// constructor
	public HashNode() {
		this.children = new HashMap<Character, HashNode>();
		this.isCompleteWord = false;
	}
	
}
