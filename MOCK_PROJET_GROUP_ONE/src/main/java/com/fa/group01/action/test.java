/**
 * 
 */
package com.fa.group01.action;

/**
 * @author DungHN2
 *
 */
public class test {

	public static void main(String[] args) {
		String s = "This is a sample sentence with []s. Hello my name is. I'm a boss";
		String[] words = s.split("\\.+");
		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].trim();
		}
		for(String a: words) {
			System.out.println(a);
		}
	}
	
}
