package com.adanac.tool.supertool.j2se.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexDemo {
	@Test
	public void test1() {
		String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
		String pattern = ".*http://.*";
		boolean matches = Pattern.matches(pattern, text);
		System.out.println("matches = " + matches);
	}

	@Test
	public void test2() {
		String text = "This is the text to be searched " + "for occurrences of the pattern.";
		String pattern = ".*is.*";
		boolean matches = Pattern.matches(pattern, text);
		System.out.println("matches = " + matches);
	}

	@Test
	public void test3() {
		String text = "A sep Text sep With sep Many sep Separators";
		String patternString = "sep";
		Pattern pattern = Pattern.compile(patternString);
		String[] split = pattern.split(text);
		System.out.println("split.length = " + split.length);
		for (String element : split) {
			System.out.println("element = " + element);
		}
	}

	/**
	 * lookingAt()方法对文本的开头匹配正则表达式；而
	 * matches() 对整个文本匹配正则表达式
	 */
	@Test
	public void test4() {
		String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
		String patternString = "This is the";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		System.out.println("lookingAt = " + matcher.lookingAt());
		System.out.println("matches   = " + matcher.matches());
	}

	@Test
	public void test5() {
		String text = "John writes about this, and John Doe writes about that, and John Wayne writes about everything.";
		String patternString1 = "((John) (.+?)) ";
		Pattern pattern = Pattern.compile(patternString1);
		Matcher matcher = pattern.matcher(text);
		StringBuffer stringBuffer = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(stringBuffer, "Joe Blocks ");
			System.out.println(stringBuffer.toString());
		}
		matcher.appendTail(stringBuffer);
		System.out.println(stringBuffer.toString());
	}
}
