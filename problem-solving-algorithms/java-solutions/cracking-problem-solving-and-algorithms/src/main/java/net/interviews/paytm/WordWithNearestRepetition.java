package net.interviews.paytm;

import java.util.HashMap;
import java.util.Map;

/**
 * Part 1 Problem: You are given a text with some words used repeatedly. Write a
 * function to find the first word that has nearest repetition. "He has to
 * conceal what he would most wish to make public, and make public what he would
 * most wish to conceal. I like the word make so much that I use word make to
 * keep on making things. ” - Churchill Repeated words are “he”, “conceal”,
 * “what”, “would”, “most”, “wish”, “to”, “make”, “public" output = "Word is
 * ‘make' and shortest distance is 2”
 * <p>
 * Part 2: Write an API that allows clients to keep calling a next method to
 * return the next such word
 */

public class WordWithNearestRepetition {

	public void printWordWithNearestRepetition(String text) {
		if (text != null)
			printWordWithNearestRepetition(text.split(" "));
		else {
			System.out.printf("Invalid Input");
		}
	}

	private void printWordWithNearestRepetition(String[] words) {
		Map<String, Integer> wordAndDistance = new HashMap<>();
		int minDistance = Integer.MAX_VALUE;
		String minWord = null;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			// remove any special characters from the word
			word = word.replaceAll("[;,.]", "").toUpperCase();
			// store in upper case to avoid case conflict
			if (wordAndDistance.containsKey(word) && (i - wordAndDistance.get(word) < minDistance)) {
				minDistance = i - wordAndDistance.get(word);
				minWord = word;
			}
			wordAndDistance.put(word, i);
		}

		System.out.printf("%s at %d", minWord, minDistance - 1);
		System.out.println();

	}

	public static void main(String args[]) {
		

		        WordWithNearestRepetition wordWithNearestRepetition = new WordWithNearestRepetition();

		        wordWithNearestRepetition.printWordWithNearestRepetition("He has to conceal what he would most wish to make public, and make public what he would most wish to conceal. I like the word make so much that I use word make to keep on making things.");
		        wordWithNearestRepetition.printWordWithNearestRepetition("He has he, to conceal what he would most wish to make public, and make public what he would most wish to conceal. I like the word make so much that I use word make to keep on making things.");
		        wordWithNearestRepetition.printWordWithNearestRepetition("He has HE,, conceal what he would most wish to make public, and make public what he would most wish to conceal. I like the word make so much that I use word make to keep on making things.");
		        wordWithNearestRepetition.printWordWithNearestRepetition("He has to conceal what he would most wish to public make public, and make public what he would most wish to conceal. I like the word make so much that I use word make to keep on making things.");
		    }

}