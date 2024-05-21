package main.java.com.magicvet.utils;

import main.java.com.magicvet.Main;

public class StringUtils {

    public static String capitalizeFirstLetter(String input) {
        String[] parts = input.split("-");
        input = Character.toUpperCase(parts[0].charAt(0)) + parts[0].substring(1).toLowerCase();
        return parts.length == 1 ? input : input + "-" + capitalizeFirstLetter(parts[1]);
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return Main.SCANNER.nextLine().trim();
    }
}