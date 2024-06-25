package main.java.com.magicvet.utils;

import main.java.com.magicvet.Main;

public final class StringUtils {
    private StringUtils() {
    }

    public static String capitalizeFirstLetter(String input) {
        String[] parts = input.split("-");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1).toLowerCase();
        }
        return String.join("-", parts);
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return Main.SCANNER.nextLine().trim();
    }
}