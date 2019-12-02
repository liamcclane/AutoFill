package com.autofillproject;
import java.util.*;

public class Trie {
	
	// attributes
	public HashNode root;
	
	// constructors
	public Trie() {
		this.root = new HashNode();
	}
	
	// methods
	public void insertWord(String word) {
		
		// gets the root node
		HashNode currentNode = this.root;
		
		// iterates over every character in the word
		
		for (int i = 0; i< word.length(); i++) {
			
			// current letter is just the character/ letter at the itteration
			Character currentLetter = word.charAt(i);
			
			// ask if the current letter is in the map of the current node
			HashNode child = currentNode.children.get(currentLetter);
			if(child == null) {
				child = new HashNode();
				currentNode.children.put(currentLetter, child);
			}
			
			//step down into the rabbit hole
			currentNode = child;
		}// end of for
		
		currentNode.isCompleteWord = true;
	}
	
	
	/*
	 * boolean isPrefixValid(String prefix): 
	 * Returns a boolean whether the prefix is in the trie or not.
	 */
	public boolean isPrefixValid(String prefix) {
		
		boolean found = true;
		HashNode currentNode = this.root;
		
		// itterate thought the prefix looking for if the keys exist
		for(int i = 0 ; i < prefix.length(); i++) {
			
			// current letter
			Character currentLetter = prefix.charAt(i);
//			System.out.println("the current letter is : "+currentLetter);
//			System.out.println("the map we are checking to see if letter is in : "+ currentNode.children);
			
			/*you find the key in the hashmap*/	
			if (currentNode.children.containsKey(currentLetter)) {
				/* keep moving foward*/
//				System.out.println();
//				System.out.println("inside the if statement");
				currentNode = currentNode.children.get(currentLetter);
//				System.out.println("now the current node is : " + currentNode);
			} else {
				/* letter does not exist
				 * return false and kick out*/
				return false;
			}
			
			
		}
		
		return found;
	}
	
	
	/*
	 * boolean isWordValid(String word): 
	 * Returns a boolean whether the word is in the trie or not.
	 */
	
	public boolean isWordValid(String word) {
		
		HashNode currentNode = this.root;
		
		// itterate thought the word 
		for(int i = 0; i < word.length();i++) {
			
			// current letter
			Character currentLetter = word.charAt(i);
//			System.out.println("the current letter is : "+currentLetter);
//			System.out.println("the map we are checking to see if letter is in : "+ currentNode.children);
			
			if(currentNode.children.containsKey(currentLetter)) {
				/*move down the rabbit hole*/
//				System.out.println();
//				System.out.println("inside the else if statement");
				currentNode = currentNode.children.get(currentLetter);
//				System.out.println("now the current node is : " + currentNode);
			} else {
				/* you can return false the moment the letter is not in the map*/
				return false;
			}
		}
		/* ended the loop successfully and can return true ONLY if isWompleteWord is true*/
		if (currentNode.isCompleteWord==true) {
			return true;			
		}
		return false;
		
	}
	
	/*
	 * void printAllKeys(): 
	 * This method prints all the characters in your trie.
	 * 
	 * WANT the output to look like
	 * 
	 * All the keys inside of this trie is
	 * Level 1 : 'c', 't'
	 * Level 2 : 'a','r'
	 * Level 3 : 'r', 'u','i','y'
	 * Level 4 : 'end of a word','t','d','end of a word','n','e'
	 * Level 5 : 'end of a word', 'end of a word'
	 * 
	 * 
	 * What this method actually does
	 * All the keys inside of this trie is 
	 * 't','c'
	 * 
	 * */
	
	
	public void printAllKeysRoughtDraft() {
		HashNode currentNode = this.root;
		Set<Character> keys = currentNode.children.keySet();
		
		System.out.print("All the keys inside of this trie level are : ");

		for(Character key : keys) {
			System.out.print("'"+key+"'");
		}
		
	}
	
	
	
	/* Maybe I want the output to be
	 * 
	 * 'c' 'a' 'r' 't'
	 * 'c' 'a' 'r' 'd'
	 * 'c' 'a' r'
	 * 't' 'r' 'u' 'n'
	 * 't' 'r' 'i' 'e' 
	 * 't' 'r' 'y'
	 * */
	
	// for this method the user has to input the root
	public void printAllKeysHELP(HashNode node) {		
		Set<Character> keys = node.children.keySet();
		for(Character key : keys) {
			System.out.print(" '"+key+" ',");
			printAllKeysHELP( node.children.get(key) );
			System.out.println();
		}
		
	}
	
	public void printAllKeys() {
		printAllKeysHELP(this.root);
	}
	
}
