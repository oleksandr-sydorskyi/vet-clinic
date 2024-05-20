package main.java.com.magicvet.utils;

import main.java.com.magicvet.Main;

public class StringUtils {

    public static String capitalizeFirstLetter(String input) {
        String[] parts = input.split("-");
        input = capitalizePart(parts[0]);
        return parts.length == 1 ? input : input + "-" + capitalizePart(parts[1]);
    }

    private static String capitalizePart(String part) {
        return Character.toUpperCase(part.charAt(0)) + part.substring(1).toLowerCase();
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return Main.SCANNER.nextLine().trim();
    }
}