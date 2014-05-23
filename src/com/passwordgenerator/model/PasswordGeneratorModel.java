package com.passwordgenerator.model;

import java.util.Random;

import com.passwordgenerator.util.PGUtil;



public class PasswordGeneratorModel implements IPasswordGeneratorModel {

	private Random rand;
	
	public PasswordGeneratorModel() {
		this.rand = new Random(System.currentTimeMillis());;
	}

	@Override
	public String[] getPasswords(int numNeeded, int length, Integer[] options) {
		String password;
		String passwords[] = new String[numNeeded];
		
		int numOptions = options.length;
		int option;
		
		for (int i = 0; i < numNeeded; ++i) {
			password = "";
			while (password.length() < length) {				
				option = options[rand.nextInt(numOptions)];
				password += getRandomChar(option);
			}
			passwords[i] = password;
		}
		
		return passwords;
	}
	
	private char getRandomChar(int option) {
		char c;

		switch (option) {
		case PGUtil.Options.ALPHA_LOWER:
			c = getRandomChar(PGUtil.Ranges.LOWER_ALPHA_LOWER, PGUtil.Ranges.LOWER_ALPHA_UPPER);
			break;
		case PGUtil.Options.ALPHA_UPPER:
			c = getRandomChar(PGUtil.Ranges.UPPER_ALPHA_LOWER, PGUtil.Ranges.UPPER_ALPHA_UPPER);
			break;
		case PGUtil.Options.NUMBERS:
			c = getRandomChar(PGUtil.Ranges.NUMBERS_LOWER, PGUtil.Ranges.NUMBERS_UPPER);
			break;
		case PGUtil.Options.PUNCTUATION:
			c = getRandomPunctuationChar();
			break;
		default:
			c = '*';
			break;
		}
		
		return c;
	}
	
	private char getRandomChar(int lower, int upper) {
		int offset = rand.nextInt(upper - lower);
		return (char) (lower + offset);
	}
	
	private char getRandomPunctuationChar() {
		int offset = rand.nextInt(PGUtil.PUNCT_CHARS.length);
		return PGUtil.PUNCT_CHARS[offset];
	}
	
}
