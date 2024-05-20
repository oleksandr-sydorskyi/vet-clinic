package main.java.com.magicvet.service;

import main.java.com.magicvet.model.*;
import main.java.com.magicvet.utils.StringUtils;

import java.util.Arrays;
import java.util.Comparator;

public class PetService {

    public static void sortPetsByField(Pet[] pets, String field) {
        Comparator<Pet> comparator;
        switch (field.toLowerCase()) {
            case "name" -> comparator = Comparator.comparing(Pet::getName);
            case "age" -> comparator = Comparator.comparing(pet -> Integer.parseInt(pet.getAge()));
            case "health" -> comparator = Comparator.comparing(Pet::getHealthState);
            case "type" -> comparator = Comparator.comparing(Pet::getType);
            case "owner" -> comparator = Comparator.comparing(Pet::getOwnerName);
            case "size" -> comparator = (p1, p2) -> {
                if (p1 instanceof Dog && p2 instanceof Dog) {
                    return ((Dog) p1).getSize().compareTo(((Dog) p2).getSize());
                }
                return 0;
            };
            default -> {
                System.out.println("Unsupported field for sorting: " + field);
                return;
            }
        }
        Arrays.sort(pets, comparator);
        System.out.println("Sorted by " + field + ":");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public void registerNewPet(Client client) {
        String input = StringUtils.getInput("Would you like to register a pet? yes (y) / no (n): ");
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
        pet.setAge(StringUtils.getInput("Age: "));
        pet.setName(StringUtils.getInput("Name: "));
        pet.setSex(StringUtils.getInput("Sex: male (m) / female (f) / unknown (u): "));
        if (pet.getType() == PetType.DOG) {
            ((Dog) pet).setSize(StringUtils.getInput("Size (XS / S / M / L / XL): "));
        }
        pet.setHealthState(StringUtils.getInput("Health (EXCELLENT (e) / GOOD (g) / POOR (p) / CRITICAL (c)): "));
        return pet;
    }

    private PetType getPetType() {
        String type = StringUtils.getInput("Pet type: dog (d) / cat (c) / unknown (u): ");
        return type.matches("^(dog|d)$") ? PetType.DOG :
                type.matches("^(cat|c)$") ? PetType.CAT : PetType.UNKNOWN;
    }
}
