package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.*;

public class PetService {

    public void registerNewPet(Client client) {
        String input = getInput("Would you like to register a pet? yes (y) / no (n): ");
        switch (input) {
            case "y":
                System.out.println("Adding a new pet.");
                Pet pet = buildPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
                break;
            case "n":
                System.out.println("You can register a pet later.");
                break;
            default:
                System.out.println("Invalid input! Please try again. ");
                registerNewPet(client); // Re-prompt for input
                return;
        }
        System.out.println(client);
    }
    private Pet buildPet() {
        PetType petType = getPetType();
        Pet pet = petType == PetType.DOG ? new Dog() : new Cat();
        pet.setType(petType);
        pet.setAge(getInput("Age: "));
        pet.setName(getInput("Name: "));
        pet.setSex(getInput("Sex: male (m) / female (f) / unknown (u): "));
        if (pet.getType() == PetType.DOG) {
            ((Dog) pet).setSize(getInput("Size (XS / S / M / L / XL): "));
        }
        pet.setHealthState(getInput("Health (EXCELLENT (e) / GOOD (g) / POOR (p) / CRITICAL (c)): "));
        return pet;
    }

    private PetType getPetType() {
        String type = getInput("Pet type: dog (d) / cat (c) / unknown (u): ");
        return type.matches("^(dog|d)$") ? PetType.DOG :
                type.matches("^(cat|c)$") ? PetType.CAT : PetType.UNKNOWN;
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return Main.SCANNER.nextLine().trim();
    }
}
