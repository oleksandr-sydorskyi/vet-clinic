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
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
        return client;
    }

    public void registerPetIfRequested(Client client, PetService petService) {
        System.out.println("Would you like to register а pet immediately? (yes / no): ");
        String input;
        do {
            input = Main.SCANNER.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                System.out.println("Adding a new pet.");
                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            } else if (input.equals("no")) {
                System.out.println("You can register a pet later.");
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        } while (!(input.equals("yes") || input.equals("no")));
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
