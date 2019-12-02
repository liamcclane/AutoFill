package com.autofillproject;

public class TrieTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Trie trieObject = new Trie();
		
		trieObject.insertWord("cart");
		trieObject.insertWord("card");
		trieObject.insertWord("car");
		trieObject.insertWord("trun");
		trieObject.insertWord("trie");
		trieObject.insertWord("try");
//		trieObject.insertWord("water");
		System.out.println();
		
		System.out.println("the prefix 'car' is inside the tri object : "+trieObject.isPrefixValid("car"));
		System.out.println();
		
		System.out.println("the prefix 'water' is inside the tri object : "+trieObject.isPrefixValid("water"));
		System.out.println();
		
		System.out.println("the prefix 'te' is inside the tri object : "+trieObject.isPrefixValid("te"));
		System.out.println();
		
		System.out.println("the prefix 'tr' is inside the tri object : "+trieObject.isPrefixValid("tr"));
		System.out.println();
		
		System.out.println("Is the word 'car' inside of the tries object : " + trieObject.isWordValid("car"));
		System.out.println();
		
		System.out.println("Is the word 'try' inside of the tries object : " + trieObject.isWordValid("try"));
		System.out.println();
		
		System.out.println("Is the word 't' inside of the tries object : " + trieObject.isWordValid("t"));
		System.out.println();
		
		System.out.println("Is the word 'poop' inside of the tries object : " + trieObject.isWordValid("poop"));
		System.out.println();
		
		System.out.println();
		System.out.println("All the keys in this terieObject is :");
		trieObject.printAllKeys();
		System.out.println();
	}

}
