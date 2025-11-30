import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		// [1] length() - returns the length of the string, int datatype
		
//		String name = "Spencer";
//		System.out.println("The name " + name + " has " + name.length() + " letters");
		
		
		// [2] equals() - returns a boolean
		
		String name1 = "John";
		String name2 = new String("John");
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1 == name2); 
		
		
		// [3] equalsIgnoreCase() - returns a boolean
		
//		String name1 = "John";
//		String name2 = "john";
//		System.out.println(name1.equalsIgnoreCase(name2)); 
		
		
		// [4] substring()
		
//		String words = "I love philippines";
//		String new_word = words.substring(1);
//		System.out.println(new_word);
		
		
		// [5] indexOf() - finds the first match ;  lastIndexOf() - finds the last match
		
//		String words = "I love philippines";
//		int i = words.indexOf("love");
//		System.out.println(i); 
		
		
		// [6] contains() 
//		String words = "I love philippines";
//		boolean b = words.contains("love");
//		System.out.println(b); 
		
		
		// [7] charAt()
//		String name = "Speed";
//		char c1 = name.charAt(0); // returns the first letter
//		char c2 = name.charAt(name.length() -1); // returns the last letter
//		System.out.println(c2);
		
		
		// [8] replace()
//		String sentence = "The cat is a super cat";
//		String new_sentence = sentence.replace("cat","dog");
//		System.out.println(new_sentence);
		
		
		// [9] toUpperCase(), toLowerCase()
//		String name = "black";
//		System.out.println(name.toUpperCase());
		
		
		// [10] trim() - removes spaces from start and end
//		String name = "        black";
//		System.out.println(name.trim());
		
		
		// [11] startsWith() ; endsWith() - returns boolean
		
		
		
		
		// [13] split() - split strings - returns an array
//		String sentence = "The sky is dark";
//		String[] words = sentence.split(" ");
//		
//		for(int i = 0; i < words.length; i++) {
//			System.out.println(words[i]);
//		}
		
		
		
		
//		Rank	Method			Returns			Parameters
//		1	length()			    int			none
//		2	equals()			    boolean		(String anotherString)
//		3	equalsIgnoreCase()	    boolean		(String anotherString)
//		4	substring()				String	    (int beginIndex) or (int beginIndex, int endIndex)
//		5	charAt()			    char		(int index)
//		6	indexOf()			    int			(String str) or (String str, int fromIndex) or (int ch) or (int ch, int fromIndex)
//		7	lastIndexOf()		    int			Same overloads as indexOf()
//		8	contains()			    boolean		(CharSequence sequence)
//		9	replace()			    String		(char oldChar, char newChar) or (CharSequence target, CharSequence replacement)
//		10	toLowerCase()		    String		none or (Locale locale)
//		11	toUpperCase()		    String		none or (Locale locale)
//		12	trim()				    String		none
//		13	split()				    String[]	(String regex) or (String regex, int limit)
//		14	startsWith()		    boolean		(String prefix) or (String prefix, int toffset)
//		15	endsWith()			    boolean		(String suffix)
//		16	replaceAll()		    String		(String regex, String replacement)
//		17	replaceFirst()		    String		(String regex, String replacement)
//		18	matches()			    boolean		(String regex)
//		19	format()			    String		(String format, Object... args) or (Locale locale, String format, Object... args)
//		20	join()				    String		(CharSequence delimiter, CharSequence... elements) or (CharSequence delimiter, Iterable<? extends CharSequence> elements)
//		21	valueOf()			    String		Many overloads: (boolean b), (char c), (char[] data), (int i), (long l), (float f), (double d), (Object obj)
//		22	toCharArray()		    char[]		none
//		23	isEmpty()			    boolean		none
//		24	compareTo()			    int			(String anotherString)
//		25	compareToIgnoreCase()	int			(String str)
//		26	hashCode()			    int			none
//		27	toString()			    String		none
//		28	contentEquals()		    boolean		(CharSequence cs) or (StringBuffer sb)
//		29	copyValueOf()		    String		(char[] data) or (char[] data, int offset, int count)
//		30	getBytes()			    byte[]		none, (Charset charset), or (String charsetName)
//		31	getChars()			    void		(int srcBegin, int srcEnd, char[] dst, int dstBegin)
//		32	codePointAt()		    int			(int index)
//		33	codePointBefore()	    int			(int index)
//		34	codePointCount()	    int			(int beginIndex, int endIndex)
//		35	intern()			    String		none
//		36	offsetByCodePoints()	int			(int index, int codePointOffset)
//		37	regionMatches()		    boolean		(boolean ignoreCase, int toffset, String other, int ooffset, int len) or (int toffset, String other, int ooffset, int len)
//		38	subSequence()		    CharSequence(int beginIndex, int endIndex)
		
		
		// [1] word counter
		// prompt user to enter a phrase or sentence
		// output the word count in that sentence
		// clue: split() will be used
		
		
		// [2] Contains bad word
//		String[] bad_words = {"banana", "cheesecake"};
		
		// clue: contains() and loop will be used
		
		// [3] vowel and consonant counter
		
		// [4] reverse a string
		
		// [5] find the longest word
		
		// [6] Count Occurrence of a Character
		
		// [7] This code capitalizes the first word of each sentence
		// but input like this ---->    i am VERy HungRY. 
		// becomes like this ----->     I am VERy HungRY.
		// add one line of code to fix it. to make it like this  -----> I am very hungry.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a text:");
//		String text = sc.nextLine();
//		
//		String[] text_arr = text.split("(?<=[.!?])\\s*"); // split into array
//		
//		
//		for(int i = 0; i< text_arr.length; i++) {
//			text_arr[i] = text_arr[i].trim(); // remove white spaces in front and end of sentence
//			// add a code here
//			text_arr[i] = text_arr[i].substring(0, 1).toUpperCase() + text_arr[i].substring(1); // capitalize first letter
//                    
//		}
//		
//		String fixed_text = String.join(" ", text_arr); // combine each array element into one string 
//		
//		System.out.println(fixed_text); // print the string
		
		
		
		

	}

}
