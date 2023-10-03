package com.qa.orangehrm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StringUtil {

	/**
	 * Convert By to String
	 * 
	 * @param by
	 * @return
	 * 
	 * @author spaliwal
	 */
	public static String convertByToString(By by) {
		if (by == null) {
			return "null";
		}
		StringBuilder toString = new StringBuilder();
		String str = by.toString();
		String pat1 = "(By.)(.*)(:)( )(.*)";
		Pattern pattern = Pattern.compile(pat1);
		Matcher matcher = pattern.matcher(str);

		if (matcher.find()) {
//			toString.append("'");
//			toString.append(matcher.group(2)).append(": ");
			toString.append(matcher.group(5));
//			toString.append("'");
		}
		return toString.toString();
	}

	/**
	 * Convert WebElement to String
	 * 
	 * @param element
	 * @return
	 * 
	 * @author spaliwal
	 */
	public static String convertWebElementToString(WebElement element) {
		if (element == null) {
			return "null";
		}
		try {
			String[] parts = element.toString().split("->");
			String[] xpath = parts[parts.length - 1].split(" ");
			String path = xpath[xpath.length - 1].trim();
			return path.substring(0, path.length() - 1);
//			return parts[parts.length - 2].replaceFirst("(?s)(.*)\\]", "$1" + "");
		} catch (ArrayIndexOutOfBoundsException e) {
			return element.toString();
		}
	}

}
