package org.atp.roman_numbers;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
	private RomanNumerals sut = new RomanNumerals();

	@Test
	public void itShouldReturnAOneDigitNumber() throws NotValidSymbolException {
		// Arrange
		final String[] oneDigitRomanNumbers = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX" };
		int[] expectedResults = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arrayResult = new int[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(oneDigitRomanNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}

	@Test
	public void itShouldReturnTwoDigitNumber() throws NotValidSymbolException {
		// Arrange
		final String[] twoDigitRomanNumbers = new String[] { "X", "XI", "XII", "XIII", "XIV", "XV", "XX", "XXI", "XXX",
				"XXI", "XXII", "XXXVIII", "XXXIX", "L", "XL", "XLVII", "XCIX" };
		int[] expectedResults = new int[] { 10, 11, 12, 13, 14, 15, 20, 21, 30, 21, 22, 38, 39, 50, 40, 47, 99 };
		int[] arrayResult = new int[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(twoDigitRomanNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}

	@Test
	public void itShouldReturnThreeDigitNumber() throws NotValidSymbolException {
		// Arrange
		final String[] threeDigitRomanNumbers = new String[] { "C", "CI", "CCCV", "CM", "CMXCIX" };
		int[] expectedResults = new int[] { 100, 101, 305, 900, 999 };
		int[] arrayResult = new int[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(threeDigitRomanNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}

	@Test
	public void itShouldReturnFourDigitNumber() throws NotValidSymbolException {
		// Arrange
		final String[] fourDigitRomanNumbers = new String[] { "M", "MI", "MM", "MMMM", "MMMMI" };
		int[] expectedResults = new int[] { 1000, 1001, 2000, 4000, 4001 };
		int[] arrayResult = new int[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(fourDigitRomanNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}

	@Test(expected = NotValidSymbolException.class)
	public void itShouldReturnAnNotValidSymbolException() throws NotValidSymbolException {
		// Arrange
		String notValidSymbol = "SXX";

		// Act
		sut.convert(notValidSymbol);
	}
}
