package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.*;

public class PetService {

    public void registerNewPet(Client client) {
        Pet pet;
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
                pet = buildPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            } else if (isNo) {
                System.out.println("You can register a pet later.");
            } else {
                System.out.println("Invalid input. Please enter 'yes' (y) or 'no' (n).");
            }
        } while (!isYes && !isNo);
        System.out.println(client);
    }

    private Pet buildPet() {
        System.out.println("Pet type: dog (d) / cat (c) / unknown (u): ");
        String type = Main.SCANNER.nextLine().trim().toLowerCase();
        Pet pet = type.matches("^(dog|d)$") ? new Dog() : new Cat();
        pet.setType(type.matches("^(dog|d)$") ? PetType.DOG :
                type.matches("^(cat|c)$") ? PetType.CAT : PetType.UNKNOWN);
        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Sex: male (m) / female (f) / unknown (u): ");
        pet.setSex(Main.SCANNER.nextLine().trim().toLowerCase());
        if (pet.getType() == PetType.DOG) {
            System.out.print("Size (XS / S / M / L / XL): ");
            ((Dog) pet).setSize(Main.SCANNER.nextLine().trim().toUpperCase());
        }
        System.out.print("Health (EXCELLENT (e) / GOOD (g) / POOR (p) / CRITICAL (c)): ");
        pet.setHealthState(Main.SCANNER.nextLine().trim().toUpperCase());
        return pet;
    }
}
