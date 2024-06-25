package main.java.com.magicvet.component;

import main.java.com.magicvet.utils.StringUtils;

public class Authenticator {
    private static final String PASSWORD = "d";
    public static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            String input = StringUtils.getInput("Password: ");
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }
}
