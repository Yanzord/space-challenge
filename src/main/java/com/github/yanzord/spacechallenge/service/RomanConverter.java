package com.github.yanzord.spacechallenge.service;

import com.github.yanzord.spacechallenge.exception.InvalidNumberException;

import java.util.Arrays;
import java.util.List;

public class RomanConverter {

    private static final List<Integer> INTEGERS = Arrays.asList(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000);
    private static final List<String> ROMANS = Arrays.asList("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M");

    public List<String> getROMANS() {
        return ROMANS;
    }

    public int convert(String romanNumber) throws InvalidNumberException {
        if (!isRomanNumber(romanNumber)) {
            throw new InvalidNumberException();
        }

        int integerNumber = treatSpecials(romanNumber);

        if (integerNumber > 0) {
            romanNumber = romanNumber.replaceAll("IV|IX|XL|XC|CD|CM", "");

            if (romanNumber.isEmpty()) {
                return integerNumber;
            }
        }

        String[] romanNumberSplitted = romanNumber.split("");

        for (String letter : romanNumberSplitted) {
            if (ROMANS.contains(letter)) {
                integerNumber += INTEGERS.get(ROMANS.indexOf(letter));
            }
        }
        return integerNumber;
    }

    public int treatSpecials(String romanNumber) {
        if (romanNumber.contains("IV"))
            return 4;

        if (romanNumber.contains("IX"))
            return 9;

        if (romanNumber.contains("XL"))
            return 40;

        if (romanNumber.contains("XC"))
            return 90;

        if (romanNumber.contains("CD"))
            return 400;

        if (romanNumber.contains("CM"))
            return 900;

        return 0;
    }

    public boolean isRomanNumber(String romanNumber) {
        boolean validation = true;

        for (String letter : romanNumber.split("")) {
            if (!validation)
                break;

            validation = letter.equals("I") || letter.equals("V") || letter.equals("X") || letter.equals("L") ||
                    letter.equals("C") || letter.equals("D") || letter.equals("M");
        }

        return validation;
    }
}
