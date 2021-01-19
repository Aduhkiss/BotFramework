package me.atticuszambrana.discord.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;

public class StringUtil {
	
//	public static String[] toArray(String string) {
//		String[] splitArray = null;
//		try {
//			splitArray = string.split("\\\\s+");
//		} catch(PatternSyntaxException ex) {
//		}
//		return splitArray;
//	}
	
	/**
	 * Convert a string separated by spaces to a String[]
	 * @param in
	 * @return
	 */
	public static String[] toArray(String in) {
		return in.split(" ");
	}
	/**
	 * Do the exact same thing, but completely ignore the first item in the array, better for getting arguments from a command executed
	 * @param in
	 * @return
	 */
	public static String[] toArrayWithoutFirst(String in) {
		String[] first = in.split(" ");
		return Arrays.copyOfRange(first, 1, first.length);
	}
	
	public static String combine(String[] arr, int startPos) {
        StringBuilder str = new StringBuilder();

        for(int i = startPos; i < arr.length; ++i) {
           str = str.append(arr[i] + " ");
        }
        return str.toString();
	}
	
	public static String realBalance(String value) {
		int v = value.indexOf(".");
		if(value.substring(v, value.length()).length() > 2) {
			return value.substring(0, v + 3);
		}
		//System.out.println(value.substring(v).length());
		if(v == 3) {
			value = value + "0";
		}
		return value;
	}
	
	public static String realBalance(double value) {
		String valuee = String.valueOf(value);
		int v = valuee.indexOf(".");
		if(valuee.substring(v, valuee.length()).length() > 2) {
			return valuee.substring(0, v + 3);
		}
		if(v == 3) {
			valuee = valuee + "0";
		}
		return valuee;
	}
	
	public static String removeLeadingZeroes(String str) {
	      String strPattern = "^0+(?!$)";
	      str = str.replaceAll(strPattern, "");
	      return str;
	}
	
	public static String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
