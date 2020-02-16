package org.atp.roman_numbers;

public class ReverseRomanNumerals extends Roman {
	private static final String IV = "IV";
	private static final String IX = "IX";
	private static final String LX = "LX";
	private static final String XC = "XC";
	private static final String CD = "CD";
	private static final String CM = "CM";
	private String[] symbols = new String[] { M, CM, D, CD, C, XC, L, LX, X, IX, V, IV, I, EMPTY };
	private int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, 0 };

	public String convert(int number) throws OutOfRangeException {
		if(number < 0 || number > 3999) {
			throw new OutOfRangeException(String.format("The correct range for the conversion of numbers is [%d,%d]",0,3999));
		}
		
		if (number == 0) {
			return EMPTY;
		}

		int remaining = number;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			if (remaining >= values[i]) {
				result.append(symbols[i]);
				remaining -= values[i];
				return result.append(convert(remaining)).toString();
			}
		}

		result.append(I);
		result.append(convert(remaining - 1));
		return result.toString();
	}

}
