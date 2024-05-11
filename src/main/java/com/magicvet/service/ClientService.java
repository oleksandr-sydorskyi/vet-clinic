package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {
        Client client;
        System.out.println("Please provide client details.");
        client = buildClient();
        System.out.println("New client registered:");
        System.out.println("- Name: " + client.getFirstName() + " " + client.getLastName());
        System.out.println("- Email: " + client.getEmail());
        return client;
    }

    private static Client buildClient() {
        Client client = new Client();
        client.setEmail(getValidInput("Email : ", EMAIL_PATTERN, "(e.g. example@example.com)."));
        String nameErrorMessage = """
        Make sure that the name contains 3 or more characters
        and only Latin letters - no Cyrillic, numbers or special characters,
        except for the hyphen, as it is used when writing a double name or surname.
        d""";
        client.setFirstName(getValidInput("First name: ", NAME_PATTERN, nameErrorMessage));
        client.setLastName(getValidInput("Last name: ",NAME_PATTERN, nameErrorMessage));
        return client;
    }

    private static String getValidInput(String prompt, String pattern, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = Main.SCANNER.nextLine().trim();
            if (isValidInput(input, pattern)) {
                return input;
            } else {
                System.out.println("The input '" + input + "' is not valid! Please try again. " + errorMessage);
            }
        }
    }

    private static boolean isValidInput(String input, String pattern) {
        Pattern patternRegex = Pattern.compile(pattern);
        Matcher matcher = patternRegex.matcher(input);
        return matcher.matches();
    }
}
