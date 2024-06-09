package main.java.com.magicvet.service;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{2,}$";

    public Client registerNewClient() {
        System.out.println("Please provide client details.");
        Client client = buildClient();
        System.out.println("New client registered:");
        System.out.println(client);
        return client;
    }

    public Client buildClient() {
        Client client = new Client();
        client.setEmail(getValidInput("Email: ", EMAIL_PATTERN, "(e.g. example@example.com)."));
        String nameErrorMessage = "Name must contain 2 or more Latin letters, hyphen (-) is allowed.";
        client.setFirstName(getValidInput("First name: ", NAME_PATTERN, nameErrorMessage));
        client.setLastName(getValidInput("Last name: ",NAME_PATTERN, nameErrorMessage));
        client.setLocation(StringUtils.getInput("Location: " + Client.Location.printLocations()));
        return client;
    }

    private static String getValidInput(String prompt, String pattern, String errorMessage) {
        while (true) {
            String input = StringUtils.getInput(prompt);
            if (isValidInput(input, pattern)) {
                return input;
            } else {
                System.out.println("Invalid input! Please try again. " + errorMessage);
            }
        }
    }

    private static boolean isValidInput(String input, String pattern) {
        Pattern patternRegex = Pattern.compile(pattern);
        Matcher matcher = patternRegex.matcher(input);
        return matcher.matches();
    }
}
