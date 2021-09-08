package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	// Given an array of strings words and a width maxWidth, format the text such
	// that each line has exactly maxWidth characters and is fully (left and right)
	// justified.

	// You should pack your words in a greedy approach; that is, pack as many words
	// as you can in each line. Pad extra spaces ' ' when necessary so that each
	// line has exactly maxWidth characters.

	// Extra spaces between words should be distributed as evenly as possible. If
	// the number of spaces on a line does not divide evenly between words, the
	// empty slots on the left will be assigned more spaces than the slots on the
	// right.

	// For the last line of text, it should be left-justified and no extra space is
	// inserted between words.

	// A word is defined as a character sequence consisting of non-space characters
	// only.

	// Each word's length is guaranteed to be greater than 0 and not exceed
	// maxWidth.

	// The input array words contains at least one word.

	// efficient solution.
	public List<String> fullJustifySimple(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < words.length) {
			List<String> line = new ArrayList<>();
			int widthAvailable = maxWidth;
			int j = i;
			while (j < words.length) {
				if (words[j].length() <= widthAvailable) {
					line.add(words[j]);
					widthAvailable = widthAvailable - words[j].length() - 1;
					j++;
				} else {
					break;
				}
			}
			i = j;
			String lineText = "";
			if (i != words.length) {
				lineText = processLine(line, widthAvailable + 1, false, maxWidth);
			} else {
				lineText = processLine(line, widthAvailable + 1, true, maxWidth);
			}
			result.add(lineText);
		}
		return result;
	}

	private String processLine(List<String> line, int extraSpaces, boolean isLastLine, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		sb.append(line.get(0));
		int slots = line.size() - 1;
		int evenSpaces = (slots == 0) ? extraSpaces : extraSpaces / slots;
		int es = (slots == 0) ? 0 : extraSpaces % slots;
		String evenSpaceText = generateSpaces(evenSpaces);
		if (isLastLine) {
			evenSpaceText = "";
			es = 0;
		}
		for (int i = 1; i < line.size(); i++) {
			sb.append(" ");
			sb.append(evenSpaceText);
			if (es != 0) {
				sb.append(" ");
				es--;
			}
			sb.append(line.get(i));
		}
		if (slots == 0) {
			sb.append(evenSpaceText);
		}
		if (isLastLine) {
			int rem = sb.length();
			String last = generateSpaces(maxWidth - rem);
			sb.append(last);
		}
		return sb.toString();
	}

	private String generateSpaces(int spaces) {
		StringBuilder spaceText = new StringBuilder();
		while (spaces > 0) {
			spaceText.append(" ");
			spaces--;
		}
		return spaceText.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification tj = new TextJustification();
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> result = tj.fullJustifySimple(words, 16);
		System.out.println("Formatted string is:");
		for (String line : result) {
			System.out.println(line);
		}
	}

}
