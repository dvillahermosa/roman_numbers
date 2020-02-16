package org.atp.roman_numbers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseRomanNumeralsTest {
	private ReverseRomanNumerals sut = new ReverseRomanNumerals();
	
	@Test
	public void itShouldReturnOneDigitRomanNumber() throws OutOfRangeException {
		// Arrange

		final int[] oneDigitArabicNumbers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		String[] expectedResults = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] arrayResult = new String[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(oneDigitArabicNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}
	
	@Test
	public void itShouldReturnTwoDigitRomanNumber() throws OutOfRangeException {
		// Arrange
		final int[] twoDigitArabicNumbers = new int[] { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,20, 21, 34, 50, 55, 90, 99, 100 };
		String[] expectedResults = new String[] { "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXXIV", "L", "LV", "XC","XCIX","C" };
		String[] arrayResult = new String[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(twoDigitArabicNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}
	
	@Test
	public void itShouldReturnThreeDigitRomanNumber() throws OutOfRangeException {
		// Arrange
		final int[] twoDigitArabicNumbers = new int[] { 100, 110, 212, 313, 314, 315, 516, 617, 718, 819,920, 121, 634, 350, 555, 900, 999 };
		String[] expectedResults = new String[] {"C","CX","CCXII" ,"CCCXIII", "CCCXIV", "CCCXV", "DXVI", "DCXVII","DCCXVIII", "DCCCXIX", "CMXX", "CXXI", "DCXXXIV","CCCL", "DLV","CM","CMXCIX"};
		String[] arrayResult = new String[expectedResults.length];

		// Act
		for (int i = 0; i < expectedResults.length; i++) {
			arrayResult[i] = sut.convert(twoDigitArabicNumbers[i]);
		}

		// Assert
		Assert.assertArrayEquals(expectedResults, arrayResult);
	}
	

	@Test(expected = OutOfRangeException.class)
	public void itShouldReturnAnOutOfRangeExceptionWithANegativeNumber() throws OutOfRangeException {
		sut.convert(-1);
	}
	
	@Test(expected = OutOfRangeException.class)
	public void itShouldReturnAnOutOfRangeExceptionWithANumberUp3999() throws OutOfRangeException {
		sut.convert(4000);
	}
}
