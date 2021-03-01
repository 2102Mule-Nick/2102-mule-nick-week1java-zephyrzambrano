package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		String acronym = "";
		
		phrase = phrase.toLowerCase();
		
		String[] words = phrase.split("[\\-. ]");
		// String[] words = phrase.split(" ");
		for (int i = 0; i < words.length; i = i + 1) {
			acronym = acronym + words[i].charAt(0);
		}
		acronym = acronym.toUpperCase();
		
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree() && this.getSideOne() == this.getSideTwo()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (this.getSideOne() == this.getSideTwo()) {
				return true;
			}
			else if (this.getSideOne() == this.getSideThree()) {
				return true;
			}
			else if (this.getSideTwo() == this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (this.getSideOne() != this.getSideTwo() && this.getSideOne() != this.getSideThree() && this.getSideOne() != this.getSideTwo()) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		// use hash table?
		
		int score = 0;
		string = string.toUpperCase();
		
		Hashtable<Character, Integer> pointList = new Hashtable<Character, Integer>();
		pointList.put('A', 1);
		pointList.put('B', 3);
		pointList.put('C', 3);
		pointList.put('D', 2);
		pointList.put('E', 1);
		pointList.put('F', 4);
		pointList.put('G', 2);
		pointList.put('H', 4);
		pointList.put('I', 1);
		pointList.put('J', 8);
		pointList.put('K', 5);
		pointList.put('L', 1);
		pointList.put('M', 3);
		pointList.put('N', 1);
		pointList.put('O', 1);
		pointList.put('P', 3);
		pointList.put('Q', 10);
		pointList.put('R', 1);
		pointList.put('S', 1);
		pointList.put('T', 1);
		pointList.put('U', 1);
		pointList.put('V', 4);
		pointList.put('W', 4);
		pointList.put('X', 8);
		pointList.put('Y', 4);
		pointList.put('Z', 10);
		
		for (int i = 0; i < string.length(); i = i + 1) {
			score = score + pointList.get(string.charAt(i));
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration		
		String cleanPhoneNumber = "";
		
		Set<Character> numbers = new HashSet<Character>();
		numbers.add('0');
		numbers.add('1');
		numbers.add('2');
		numbers.add('3');
		numbers.add('4');
		numbers.add('5');
		numbers.add('6');
		numbers.add('7');
		numbers.add('8');
		numbers.add('9');
		
		for (int i = 0; i < string.length(); i = i + 1) {
			if (cleanPhoneNumber.equals("") && string.charAt(i) == '1') {
				// skip country code if it exists
			}
			else if (numbers.contains(string.charAt(i))) {
				cleanPhoneNumber = cleanPhoneNumber + string.charAt(i);
			}
		}
		
		if (cleanPhoneNumber.length() != 10) {
			throw new IllegalArgumentException();
		}
		else {
			return cleanPhoneNumber;
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		String[] words = string.split("[\\-, ]");
		
		for (int i = 0; i < words.length; i = i + 1) {
			words[i] = words[i].replaceAll("\n", "");
			words[i] = words[i].replaceAll("\\n", "");
		}
		
		
		for (int i = 0; i < words.length; i = i + 1) {
			
			if (wordCount.containsKey(words[i])) {
				int occurrences = wordCount.get(words[i]);
				wordCount.put(words[i], occurrences + 1);
			}
			else {
				wordCount.put(words[i], 1);
			}
		}
		
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int start = 0;
			int end = sortedList.size() - 1;
			int mid = (start + end) / 2;
			
			T current = sortedList.get(mid);
			
			// System.out.println("t: " + t);
			// System.out.println("Current: " + current);
			
			while (start < end) {
				
				if (t.compareTo(current) == 0) {
					return mid;
				}
				else if (t.compareTo(current) <= 0) {
					end = mid - 1;
					mid = (start + end) / 2;
					current = sortedList.get(mid);
				}
				else if (t.compareTo(current) >= 0) {
					start = mid + 1;
					mid = (start + end) / 2;
					current = sortedList.get(mid);
				}
			}
			
			if (t.compareTo(current) == 0) {
				// System.out.println("Target found: " + current);
				return mid;
			}
			else {
				return -1;
			}
			
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		Set<Character> consonants = new HashSet<Character>();
		consonants.add('b');
		consonants.add('c');
		consonants.add('d');
		consonants.add('f');
		consonants.add('g');
		consonants.add('h');
		consonants.add('j');
		consonants.add('k');
		consonants.add('l');
		consonants.add('m');
		consonants.add('n');
		consonants.add('p');
		consonants.add('q');
		consonants.add('r');
		consonants.add('s');
		consonants.add('t');
		consonants.add('v');
		consonants.add('w');
		consonants.add('x');
		consonants.add('y');
		consonants.add('z');
			
		String pigLatin = "";
		
		String[] phrase = string.split(" ");
		String[] pigLatinPhrase = new String[phrase.length];
		
		// whole phrase of pig latin
		for (int i = 0; i < phrase.length; i = i + 1) {
			String word = phrase[i];
			
			if (vowels.contains(word.charAt(0))) {
				// vowel sound
				pigLatinPhrase[i] = word + "ay";
			}
			else {
				// consonant sound
				int consonantSoundEnd = 0;
				
				for (int j = 0; j < word.length(); j = j + 1) {
					if (!consonants.contains(word.charAt(j))) {
						consonantSoundEnd = j;
						break;
					}
					
				}
				
				if (word.charAt(consonantSoundEnd) == 'u' && word.charAt(consonantSoundEnd - 1) == 'q') {
					consonantSoundEnd = consonantSoundEnd + 1;
				}
				String consonantSound = word.substring(0, consonantSoundEnd);
				String restOfWord = word.substring(consonantSoundEnd, word.length());
				pigLatinPhrase[i] = restOfWord + consonantSound + "ay";
			}
			
		}
		
		for (int i = 0; i < pigLatinPhrase.length; i = i + 1) {
			if (i + 1 == pigLatinPhrase.length) {
				// if this is the last word in the phrase, don't add a space after it
				pigLatin = pigLatin + pigLatinPhrase[i];
			}
			else {
				// add a space after every word in the phrase
				pigLatin = pigLatin + pigLatinPhrase[i] + " ";
			}
		}
		
		return pigLatin;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String stringInput = Integer.toString(input);
		double power = stringInput.length();
		
		double sum = 0;
		
		for (int i = 0; i < stringInput.length(); i = i + 1) {
			double digit = Character.getNumericValue(stringInput.charAt(i));
			sum = sum + Math.pow(digit, power);
		}
		
		if (sum == input) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		if (l <= 1) {
			throw new IllegalArgumentException();
		}
		
		List<Long> primeFactors = new ArrayList<Long>(); // list of prime factors of l
		
		for (int i = 2; i < l; i = i + 1) {
			while (l % i == 0) {
				primeFactors.add(Long.valueOf(i));
				l = l / i;
			}
		}
		if (l > 1) {
			primeFactors.add(Long.valueOf(l));
		}
		
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			
			Map<Character, Integer> alphabetPlacement = new HashMap<Character, Integer>() {
				{
					put('a', 0);
					put('b', 1);
					put('c', 2);
					put('d', 3);
					put('e', 4);
					put('f', 5);
					put('g', 6);
					put('h', 7);
					put('i', 8);
					put('j', 9);
					put('k', 10);
					put('l', 11);
					put('m', 12);
					put('n', 13);
					put('o', 14);
					put('p', 15);
					put('q', 16);
					put('r', 17);
					put('s', 18);
					put('t', 19);
					put('u', 20);
					put('v', 21);
					put('w', 22);
					put('x', 23);
					put('y', 24);
					put('z', 25);
				}
			};
			
			ArrayList<Character> alphabetLowerCase = new ArrayList<Character>() {
				{
					add('a');
					add('b');
					add('c');
					add('d');
					add('e');
					add('f');
					add('g');
					add('h');
					add('i');
					add('j');
					add('k');
					add('l');
					add('m');
					add('n');
					add('o');
					add('p');
					add('q');
					add('r');
					add('s');
					add('t');
					add('u');
					add('v');
					add('w');
					add('x');
					add('y');
					add('z');
				}
			};
			
			ArrayList<Character> alphabetUpperCase = new ArrayList<Character>() {
				{
					add('A');
					add('B');
					add('C');
					add('D');
					add('E');
					add('F');
					add('G');
					add('H');
					add('I');
					add('J');
					add('K');
					add('L');
					add('M');
					add('N');
					add('O');
					add('P');
					add('Q');
					add('R');
					add('S');
					add('T');
					add('U');
					add('V');
					add('W');
					add('X');
					add('Y');
					add('Z');
				}
			};
			
			// rotate letters
			for (int i = 0; i < key; i = i + 1) {
				char l = alphabetLowerCase.remove(0);
				char u = alphabetUpperCase.remove(0);
				
				alphabetLowerCase.add(l);
				alphabetUpperCase.add(u);
				
				/*char l = alphabetLowerCase.remove(alphabetLowerCase.size() - 1);
				char u = alphabetUpperCase.remove(alphabetUpperCase.size() - 1);
				
				alphabetLowerCase.add(0, l);
				alphabetUpperCase.add(0, u);*/
			}
			
			// encode string
			
			String encodedString = "";
			
			for (int i = 0; i < string.length(); i = i + 1) {
				
				if (alphabetLowerCase.contains(string.charAt(i))) {
					// encode lower case letters
					int letterLocation = alphabetPlacement.get(string.toLowerCase().charAt(i));
					encodedString = encodedString + alphabetLowerCase.get(letterLocation);
				}
				else if (alphabetUpperCase.contains(string.charAt(i))) {
					// encode upper case letters
					int letterLocation = alphabetPlacement.get(string.toLowerCase().charAt(i));
					encodedString = encodedString + alphabetUpperCase.get(letterLocation);
				}
				/*else if (string.charAt(i) == ' ') {
					// add spaces to the encoded string
					encodedString = encodedString + string.charAt(i);
				}
				else if (numbers.contains(string.charAt(i))) {
					// add numbers to the encoded string
					encodedString = encodedString + string.charAt(i);
				}*/
				else {
					// ignore any other type of character
					encodedString = encodedString + string.charAt(i);
				}
			}
			
			return encodedString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if (i == 0) {
			throw new IllegalArgumentException();
		}
		else if (i == 1) {
			return 2;
		}
		else if (i == 2) {
			return 3;
		}
		
		int numberOfPrimesFound = 0; // counts how many prime numbers have been found
		int currentNumber = 2;
		int currentPrime = 2;
		boolean isPrime = true;
		
		while (numberOfPrimesFound < i) {
			
			isPrime = true; // reset this boolean after every loop
			
			if (currentNumber == 2) {
				isPrime = true;
			}
			else if (currentNumber == 3) {
				isPrime = true;
			}
			else {
				for (int y = 2; y < currentNumber; y = y + 1) {
					if (currentNumber % y == 0) {
						isPrime = false;
						break;
					}
				}
			}
			
			if (isPrime == true) {
				currentPrime = currentNumber;
				numberOfPrimesFound = numberOfPrimesFound + 1;
			}
			currentNumber = currentNumber + 1;
		}
		
		return currentPrime;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			String encodedString = "";
			
			string = string.toLowerCase();
			
			Hashtable<Character, Character> encodeTable = new Hashtable<Character, Character>();
			// letters
			encodeTable.put('a', 'z');
			encodeTable.put('b', 'y');
			encodeTable.put('c', 'x');
			encodeTable.put('d', 'w');
			encodeTable.put('e', 'v');
			encodeTable.put('f', 'u');
			encodeTable.put('g', 't');
			encodeTable.put('h', 's');
			encodeTable.put('i', 'r');
			encodeTable.put('j', 'q');
			encodeTable.put('k', 'p');
			encodeTable.put('l', 'o');
			encodeTable.put('m', 'n');
			encodeTable.put('n', 'm');
			encodeTable.put('o', 'l');
			encodeTable.put('p', 'k');
			encodeTable.put('q', 'j');
			encodeTable.put('r', 'i');
			encodeTable.put('s', 'h');
			encodeTable.put('t', 'g');
			encodeTable.put('u', 'f');
			encodeTable.put('v', 'e');
			encodeTable.put('w', 'd');
			encodeTable.put('x', 'c');
			encodeTable.put('y', 'b');
			encodeTable.put('z', 'a');
			// numbers
			encodeTable.put('0', '0');
			encodeTable.put('1', '1');
			encodeTable.put('2', '2');
			encodeTable.put('3', '3');
			encodeTable.put('4', '4');
			encodeTable.put('5', '5');
			encodeTable.put('6', '6');
			encodeTable.put('7', '7');
			encodeTable.put('8', '8');
			encodeTable.put('9', '9');
			
			int addSpace = 0;
			
			for (int i = 0; i < string.length(); i = i + 1) {
				if (encodeTable.contains(string.charAt(i))) {
					encodedString = encodedString + encodeTable.get(string.charAt(i));
					addSpace = addSpace + 1;
					
					if (addSpace == 5) {
						encodedString = encodedString + " ";
						addSpace = 0;
					}
				}
			}
			
			// strip space from the end of the string if there is any
			if (encodedString.charAt(encodedString.length() - 1) == ' ') {
				encodedString = encodedString.substring(0, encodedString.length() - 1);
			}
			
			return encodedString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			
			String decodedString = "";
			
			string = string.toLowerCase();
			
			Hashtable<Character, Character> decodeTable = new Hashtable<Character, Character>();
			// letters
			decodeTable.put('z', 'a');
			decodeTable.put('y', 'b');
			decodeTable.put('x', 'c');
			decodeTable.put('w', 'd');
			decodeTable.put('v', 'e');
			decodeTable.put('u', 'f');
			decodeTable.put('t', 'g');
			decodeTable.put('s', 'h');
			decodeTable.put('r', 'i');
			decodeTable.put('q', 'j');
			decodeTable.put('p', 'k');
			decodeTable.put('o', 'l');
			decodeTable.put('n', 'm');
			decodeTable.put('m', 'n');
			decodeTable.put('l', 'o');
			decodeTable.put('k', 'p');
			decodeTable.put('j', 'q');
			decodeTable.put('i', 'r');
			decodeTable.put('h', 's');
			decodeTable.put('g', 't');
			decodeTable.put('f', 'u');
			decodeTable.put('e', 'v');
			decodeTable.put('d', 'w');
			decodeTable.put('c', 'x');
			decodeTable.put('b', 'y');
			decodeTable.put('a', 'z');
			// numbers
			decodeTable.put('0', '0');
			decodeTable.put('1', '1');
			decodeTable.put('2', '2');
			decodeTable.put('3', '3');
			decodeTable.put('4', '4');
			decodeTable.put('5', '5');
			decodeTable.put('6', '6');
			decodeTable.put('7', '7');
			decodeTable.put('8', '8');
			decodeTable.put('9', '9');
			
			for (int i = 0; i < string.length(); i = i + 1) {
				if (decodeTable.contains(string.charAt(i))) {
					decodedString = decodedString + decodeTable.get(string.charAt(i));
				}
			}
			
			return decodedString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		String isbn = "";
		
		Set<Character> digits = new HashSet<Character>();
		digits.add('0');
		digits.add('1');
		digits.add('2');
		digits.add('3');
		digits.add('4');
		digits.add('5');
		digits.add('6');
		digits.add('7');
		digits.add('8');
		digits.add('9');
		
		// trim all dashes from the string
		for (int i = 0; i < string.length(); i = i + 1) {
			if (i + 1 == string.length() && string.charAt(i) == 'X') {
				isbn = isbn + 'X';
			}
			else if (digits.contains(string.charAt(i))) {
				isbn = isbn + string.charAt(i);
			}
			else if (string.charAt(i) == '-') {
				// skip dashes
			}
			else {
				// invalid ISBN; string includes characters that shouldn't be there
				return false;
			}
		}
		
		if (isbn.length() < 10 || isbn.length() > 10) {
			// invalid ISBN; too many or too few digits
			return false;
		}
		
		int[] numbers = new int[10];
		
		// convert string to ints to do the calculations on
		for (int x = 0; x < isbn.length(); x = x + 1) {
			if (isbn.charAt(x) == 'X') {
				numbers[x] = 10;
			}
			else {
				numbers[x] = Character.getNumericValue(isbn.charAt(x));
			}
		}
		
		int sum = 0;
		int multiplier = 10;
		for (int y = 0; y < 10; y = y + 1) {
			sum = sum + (numbers[y] * multiplier);
			multiplier = multiplier - 1;
		}
		
		if (sum % 11 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		Set<Character> alphabet = new HashSet<Character>();
		alphabet.add('a');
		alphabet.add('b');
		alphabet.add('c');
		alphabet.add('d');
		alphabet.add('e');
		alphabet.add('f');
		alphabet.add('g');
		alphabet.add('h');
		alphabet.add('i');
		alphabet.add('j');
		alphabet.add('k');
		alphabet.add('l');
		alphabet.add('m');
		alphabet.add('n');
		alphabet.add('o');
		alphabet.add('p');
		alphabet.add('q');
		alphabet.add('r');
		alphabet.add('s');
		alphabet.add('t');
		alphabet.add('u');
		alphabet.add('v');
		alphabet.add('w');
		alphabet.add('x');
		alphabet.add('y');
		alphabet.add('z');
		
		Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
		
		string = string.toLowerCase();
		
		for (int i = 0; i < string.length(); i = i + 1) {
			if (alphabet.contains(string.charAt(i))) {
				if (letterCount.containsKey(string.charAt(i))) {
					int occurrences = letterCount.get(string.charAt(i));
					letterCount.put(string.charAt(i), occurrences + 1);
				}
				else {
					letterCount.put(string.charAt(i), 1);
				}
			}
		}
		
		if (letterCount.size() == 26) {
			return true;
		}
		else {
			return false;
		}
		
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		// full time specified
		if (ChronoUnit.HOURS.isSupportedBy(given) && ChronoUnit.MINUTES.isSupportedBy(given) &&
				ChronoUnit.SECONDS.isSupportedBy(given) && ChronoUnit.MICROS.isSupportedBy(given)) {
			
			LocalDateTime dt = LocalDateTime.from(given);
			dt = dt.plus(1000000000, ChronoUnit.SECONDS);
			return dt;
		}
		// only date specified
		else {
			LocalDate d = LocalDate.from(given);
			LocalTime t = LocalTime.of(0, 0, 0, 0);
			LocalDateTime dt = LocalDateTime.of(d, t);
			dt = dt.plus(1000000000, ChronoUnit.SECONDS);
			return dt;
		}

	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		Set<Integer> multiples = new HashSet<Integer>();
		
		for (int x = 1; x < i; x = x + 1) {
			//go through all numbers up to but not including i
			for (int y = 0; y < set.length; y = y + 1) {
				// go through set to see if the current number is a multiple of this number
				if (x % set[y] == 0) { // || set[y] % x == 0) {
					multiples.add(x);
				}
			}
		}
		
		int sum = 0;
		
		for (int z : multiples) {
			sum = sum + z;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
		if (string.length() <= 1) {
			return false;
		}
		
		// allowed characters in a valid number
		ArrayList<Character> digits = new ArrayList<Character>() {
			{
				add('0');
				add('1');
				add('2');
				add('3');
				add('4');
				add('5');
				add('6');
				add('7');
				add('8');
				add('9');
			}
		};
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		// check for invalid characters
		// if it is a valid number, then all digits will be separated in the ArrayList
		for (int i = 0; i < string.length(); i = i + 1) {
			if (digits.contains(string.charAt(i))) {
				numbers.add(Character.getNumericValue(string.charAt(i)));
			}
			else if (string.charAt(i) == ' ') {
				// skip spaces
			}
			else {
				// immediately return false if an invalid character is found
				return false;
			}
		}
		
		// double every second number
		for (int i = numbers.size() - 2; i >= 0; i = i - 2) {
			int num = numbers.get(i);
			num = num * 2;
			if (num > 9) {
				num = num - 9;
			}
			numbers.set(i, num);
		}
		
		int sum = 0;
		for (int num : numbers) {
			sum = sum + num;
		}
		
		// number is valid only if evenly divisible by 10
		if (sum % 10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * array data locations - plus/minus
		 * 0 - What
		 * 1 - is
		 * 2 - first number
		 * 3 - plus/minus
		 * 4 - second number? (strip question mark at the end)
		 * 
		 * array data locations - multiply/divide
		 * 0 - What
		 * 1 - is
		 * 2 - first number
		 * 3 - multiplied/divided
		 * 4 - by
		 * 5 - second number? (strip question mark at the end)
		 * 
		 */
		
		String[] expression = string.split(" ");
		
		if (expression.length == 5) { // addition or subtraction
			
			int num1 = Integer.parseInt(expression[2]);
			int num2 = Integer.parseInt(expression[4].substring(0, expression[4].length() - 1));
			
			if (expression[3].equals("plus")) {
				return num1 + num2;
			}
			else {
				return num1 - num2;
			}
		}
		else { // multiplication or division
			
			int num1 = Integer.parseInt(expression[2]);
			int num2 = Integer.parseInt(expression[5].substring(0, expression[5].length() - 1));
			
			if (expression[3].equals("multiplied")) {
				return num1 * num2;
			}
			else {
				if (num2 < 0 && num1 > 0) {
					// if denominator is negative and numerator is positive
					num1 = num1 * -1;
					num2 = num2 * -1;
				}
				return num1 / num2;
			}
		}
	}

}
