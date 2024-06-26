package main.java.com.magicvet.service;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.utils.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{2,}$";

    public Optional<Client> registerNewClient() {
        System.out.println("Please provide client details.");
        Client client = buildClient();
        System.out.println("New client registered:");
        System.out.println(client);
        return Optional.ofNullable(client);
    }

    public Client buildClient() {
        Client client = new Client();
        client.setEmail(getValidInput("Email: ", EMAIL_PATTERN, "(e.g. example@example.com)."));
        String nameErrorMessage = "Name must contain 2 or more Latin letters, hyphen (-) is allowed.";
        String firstName = getValidInput("First name: ", NAME_PATTERN, nameErrorMessage);
        client.setFirstName(StringUtils.capitalizeFirstLetter(firstName));
        String lastName = getValidInput("Last name: ", NAME_PATTERN, nameErrorMessage);
        client.setLastName(StringUtils.capitalizeFirstLetter(lastName));
        String location = StringUtils.getInput("Location: " + Client.Location.printLocations());
        client.setLocation(Client.Location.getLocationFromString(location));
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
