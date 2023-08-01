package com.studying.hw2.arrays;

import java.util.Locale;

public class ArraysHomeWorkClass {

    public Integer sumValues(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public Integer getMaxValue(int[] array) {
        int maximum  = array [0];
        for (int i : array){
            if (i > maximum){
                maximum = i;
            }
        }
        return maximum;
    }

    public Integer getIndexOfMinValue(int[] array) {
        int index = 0;
        int minimum  = array [0];
        for (int i : array){
            if (i < minimum){
                minimum = i;

            }
        }
        for (int i = 0; i < array.length; i++){
            if(array[i] == minimum){
                index = i;
            }
        }
        return index;

    }

    public Integer countLetterAInString(String str) {
        int counter = 0;
        char[] array = str.toCharArray();
        for(char a : array){
            if(a == 'a'){
                counter++;
            }
        }
        return counter;
    }

    public Boolean checkIfPalindromeString(String str) {
        String word = new String();
        String reverse = new String();
        char[] array = str.toLowerCase(Locale.ROOT).toCharArray();

        for (char c : array) {
            if (Character.isLetterOrDigit(c)) {
                word += c;
            }
        }
        for (int j = array.length - 1; j >= 0; j--){
            if (Character.isLetterOrDigit(array[j])) {
                reverse += array[j];
            }

        }
        return word.equals(reverse);
    }
}
