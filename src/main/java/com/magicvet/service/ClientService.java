package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {
        Client client = null;
        String email;
        do {
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        email = Main.SCANNER.nextLine().trim();
            if (email.equalsIgnoreCase("exit") || email.equalsIgnoreCase("e")) {
                System.out.println("Exiting program.");
                break;
            }
        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client registered:");
            System.out.println("- Name: " + client.getFirstName() + " "
                    + client.getLastName());
            System.out.println("- Email: " + client.getEmail());
        } else {
            System.out.println("Provided email is invalid. " + "Try again or type 'exit' (e) to exit the program: ");
        }
        } while (!isEmailValid(email));
        return client;
    }

    public void registerPetIfRequested(Client client, PetService petService) {
        String input;
        boolean isYes;
        boolean isNo;
        do {
            System.out.print("Would you like to register a pet? yes (y) / no (n): ");
            input = Main.SCANNER.nextLine().trim().toLowerCase();
            isYes = input.matches("^(yes|y)$");
            isNo = input.matches("^(no|n)$");
            if (isYes) {
                System.out.println("Adding a new pet.");
                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added: " + pet);
            } else if (isNo) {
                System.out.println("You can register a pet later.");
            } else {
                System.out.println("Invalid input. Please enter 'yes' (y) or 'no' (n).");
            }
        } while (!isYes && !isNo);
        System.out.println(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(getValidName("First name: "));
        client.setLastName(getValidName("Last name: "));
        return client;
    }

    private static String getValidName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = Main.SCANNER.nextLine();
            if (isNameValid(name)) {
                return name;
            } else {
                System.out.println("""
                    Invalid input. Please enter a valid name. Make sure that the name contains 3 or more characters
                    and only Latin letters - no Cyrillic, numbers or special characters,
                    except for the hyphen, as it is used when writing a double name or surname.
                    """);
            }
        }
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
