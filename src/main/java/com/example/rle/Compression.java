package com.example.rle;

import java.util.ArrayList;

public class Compression {
    public String compress(String input) {
        String compressed = getCompressed(input);

        return compressed + ", " + getRatio(input, compressed);
    }

    private String getCompressed(String input) {
//        return "3A2B4C1D2E1F4G";

        char[] characters = input.toCharArray();
        String compressed = "";
        ArrayList<Character> registeredCharacters = new ArrayList<Character>();
        ArrayList<Integer> registeredCounts = new ArrayList<Integer>();
        int previousIndex = -1;

        for (char character : characters) {
            if (previousIndex == -1 || registeredCharacters.get(previousIndex) != character) {
                registeredCharacters.add(character);
                registeredCounts.add(1);
                previousIndex++;
                continue;
            }

            int count = registeredCounts.get(previousIndex);
            registeredCounts.set(previousIndex, count + 1);
        }

        for (int i = 0; i < previousIndex + 1; i++) {
            compressed = compressed + registeredCounts.get(i) + registeredCharacters.get(i);
        }

        return compressed;
    }

    private double getRatio(String input, String compressed) {
        double raw = input.length() / (double) compressed.length();

        return (double) Math.round(raw * 100d) / 100d;
    }
}
