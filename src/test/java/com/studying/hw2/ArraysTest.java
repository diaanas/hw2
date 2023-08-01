package com.studying.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.studying.hw2.arrays.ArraysHomeWorkClass;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    private ArraysHomeWorkClass homeWork;

    @BeforeEach void setUp() {
        homeWork = new ArraysHomeWorkClass();
    }

    /**
     * Return sum of array elements
     */
    @Test void getSumOfElementsAtArray() {
        int[] array = {5, 4, 3, 2, 1, -1, -2, -3, -4};

        assertEquals(5, homeWork.sumValues(array));
    }

    /**
     * Return max value at array
     */
    @Test void getMaxValueAtArray() {
        int[] array = {0, -1, 2, 5, 100, 2, -5};

        assertEquals(100, homeWork.getMaxValue(array));
    }

    /**
     * Return position of min value at array
     */
    @Test void getIndexOfMinValue() {
        int[] array = {0, -1, 2, -3, 5, -2};

        Integer expectedResult =  3;
        Integer actualResult = homeWork.getIndexOfMinValue(array);

        assertEquals(expectedResult, actualResult);
    }

    /**
     * Return count of 'a' char from text
     */
    @Test void countLetterAInString() {
        String str = "Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle) " +
            "and released in 1995 as a core component of Sun Microsystems' Java platform. ";

        Integer expectedResult = 16;
        assertEquals(expectedResult, homeWork.countLetterAInString(str));
    }

    /**
     * Should return true if string is palindrome (ignoring letter case!!!) and false if not
     */
    @Test void checkIfPalindromeString() {
        String str1 = "1001";
        String str2 = "hello-world";
        String str3 = "abbccBBa";   //please note that letter B is in lower and upper cases, but this should be palindrome anyway
        String str4 = "ABBC0CBBA";

        assertEquals(true, homeWork. checkIfPalindromeString(str1));
        assertEquals(false, homeWork. checkIfPalindromeString(str2));
        assertEquals(true, homeWork. checkIfPalindromeString(str3));
        assertEquals(true, homeWork. checkIfPalindromeString(str4));
    }
}
