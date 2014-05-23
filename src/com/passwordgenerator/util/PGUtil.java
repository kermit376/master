package com.passwordgenerator.util;

public class PGUtil {
	
	public static final char[] PUNCT_CHARS = {'!', '@', '#', '$', '%', '^', '&', '*', '-', '_', '+', '=', '~', ';', ':'};
	
	public class Options {

		public static final int ALPHA_LOWER = 0;
		public static final int ALPHA_UPPER = 1;
		public static final int NUMBERS = 2;
		public static final int PUNCTUATION = 3;
		
		private Options() { }
	}

	public class Ranges {
		
		public static final int LOWER_ALPHA_LOWER = 97;
		public static final int LOWER_ALPHA_UPPER = 122;
		public static final int UPPER_ALPHA_LOWER = 65;
		public static final int UPPER_ALPHA_UPPER = 90;
		public static final int NUMBERS_LOWER = 48;
		public static final int NUMBERS_UPPER = 57;
		
		private Ranges() { }
	}
	
	public class Flags {
		
		public static final int EXIT = 0;
		public static final int CLEAR = 1;
		public static final int GET_PASSWORDS = 2;
		
		private Flags() { } 
	}
	
	private PGUtil() { }
}
