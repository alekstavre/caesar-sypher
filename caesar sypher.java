package testing;
import java.util.Scanner;

public class TestOne {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String str;
		String key = null;
		int keyVal;

		System.out.println("enter message:");
		str = scan.next();
		System.out.println("enter number_key:");

		key = scan.next();
		try {
			keyVal = Integer.parseInt(key);

		} catch (Exception e) {

			System.out.print("must enter a number!\n");			
			keyVal = Integer.parseInt(scan.next());

		}

		while(true) {

			System.out.print("1.encrypt\n2.decrypt");
			String action = scan.next();
			switch(action) {
			case "1" :
				System.out.println("encrypted message: " + decrypt(encrypt(str, keyVal),keyVal));
				break;

			case "2" :
				System.out.println("decrypted message: " + encrypt(str, keyVal));
				break;

			default:
				System.out.println("None selected!");
			}
		}

	}

	private static String encrypt(String str, int keyVal) {
		String encrypted = "";
		for(int i=0;i<str.length();i++) {
			int letter = str.charAt(i);
			if (Character.isUpperCase(letter)) {
				letter+=(keyVal%26);
				if (letter>'Z') {
					letter+=26;
				}
				else if (Character.isLowerCase(letter)) {
					letter-=(keyVal%26);
					if (letter>'z') {
						letter-=26;
					}
				}

			}
			encrypted+=(char)letter;
		}
		return encrypted;
	}

	private static String decrypt(String str, int keyVal) {
		String decrypted = "";
		for(int i=0;i<str.length();i++) {
			int letter = str.charAt(i);
			if (Character.isUpperCase(letter)) {
				letter-=(keyVal%26);
				if (letter<'A') {
					letter-=26;
				}

			}
			else if (Character.isLowerCase(letter)) {
				letter+=(keyVal%26);
				if (letter<'a') {
					letter+=26;
				}
				decrypted+=(char)letter;
			}
			
		}
		return decrypted;
	}

}

