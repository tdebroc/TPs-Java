import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		palindrome();
	}
		
		
	public static void palindrome() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisissez une phrase (sans espaces) : ");
		String mot = scan.nextLine();
		scan.close();
		int i=0;
		if (isPalindrome(mot,i)==true) {
			System.out.println( mot + " est un palindrome.");
		} else {
			System.out.println( mot + " n'est pas un palindrome.");
		}
	}
	
	public static boolean isPalindrome(String phrase, int i) {
		if(phrase.length()<2*i) {
			return true;
		}
		if (phrase.charAt(i) != phrase.charAt(phrase.length()-1-i)) {
			return false;
		}
		return isPalindrome(phrase,i+1);
	}
	
}
