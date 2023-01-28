package org.example;
import java.util.Scanner;

public class Inputstream {
	private static Scanner ob;
	public static Scanner scanner() {
		if(ob == null)
			ob = new Scanner(System.in);
		return ob;
	}
	
	public static void setdefault() {
		ob = new Scanner(System.in);
	}
}
