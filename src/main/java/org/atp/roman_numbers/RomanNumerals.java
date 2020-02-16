package org.atp.roman_numbers;

import java.util.HashMap;

public class RomanNumerals extends Roman {
	private HashMap<String, Integer> symbolsValues;
	private int output;
	private String lastRomanDigit;

	public RomanNumerals() {
		symbolsValues = new HashMap<String, Integer>();
		symbolsValues.put(EMPTY, 0);
		symbolsValues.put(I, 1);
		symbolsValues.put(V, 5);
		symbolsValues.put(X, 10);
		symbolsValues.put(L, 50);
		symbolsValues.put(C, 100);
		symbolsValues.put(D, 500);
		symbolsValues.put(M, 1000);
		output = 0;
	}

	public int convert(String romanNumber) throws NotValidSymbolException {
		if(!IsValidFormat(romanNumber)) {
			throw new NotValidSymbolException("The roman number " + romanNumber + " contains not valid symbols");
		}
		
		output = 0;
		lastRomanDigit = EMPTY;
		for (int i = 0; i < romanNumber.length(); i++) {
			String romanDigit = extractRomanDigit(romanNumber, i);
			operate(romanDigit);
			lastRomanDigit = romanDigit;
		}

		return output;
	}

	private boolean IsValidFormat(String romanNumber) {
		String result = romanNumber;
		for(String key: symbolsValues.keySet()) {
			if(!key.equals(EMPTY)) {				
				result = result.replace(key, "");
			}
		}
		
		return result.isEmpty();
	}

	private String extractRomanDigit(String romanNumber, int i) {
		return romanNumber.substring(i, i + 1);
	}

	private void operate(String romanDigit) {
		int value = getValue(romanDigit);

		int lastValue = getValue(lastRomanDigit);

		if (lastValue < value) {

			output = Math.abs(output + value - lastValue * 2);
		} else {
			output += value;
		}
	}

	private int getValue(String character) {
		return symbolsValues.get(character);
	}

}
