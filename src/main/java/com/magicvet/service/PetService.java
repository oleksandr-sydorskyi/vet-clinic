package main.java.com.magicvet.service;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.model.PetType;
import main.java.com.magicvet.utils.StringUtils;

import java.util.Comparator;
import java.util.List;

public class PetService {

    public Pet registerNewPet() {
        Pet pet = buildPet(getPetType());
        return pet;
    }

    private PetType getPetType() {
        String type = StringUtils.getInput("Pet type: dog (d) / cat (c): ");
        return type.matches("^(dog|d)$") ? PetType.DOG : PetType.CAT;
    }

    public Pet buildPet(PetType type) {
        Pet pet = type == PetType.DOG ? new Dog() : new Cat();
        pet.setAge(StringUtils.getInput("Age: "));
        pet.setName(StringUtils.getInput("Name: "));
        pet.setSex(StringUtils.getInput("Sex: male (m) / female (f) / unknown (u): "));
        if (pet instanceof Dog) {
            ((Dog) pet).setSize(StringUtils.getInput("Size (XS / S / M / L / XL): "));
        }
        pet.setHealthState(StringUtils.getInput("Health (EXCELLENT (e) / GOOD (g) / POOR (p) / CRITICAL (c)): "));
        return pet;
    }

    public static void sortPetsByField(List<Pet> pets, String field) {
        Comparator<Pet> comparator;
        switch (field.toLowerCase()) {
            case "name" -> comparator = Comparator.comparing(Pet::getName);
            case "age" -> comparator = Comparator.comparing(pet -> pet.getAge().equals("UNKNOWN") ? 0
                    : Integer.parseInt(pet.getAge()));
            case "health" -> comparator = Comparator.comparing(Pet::getHealthState);
            case "type" -> comparator = Comparator.comparing(Pet::getType);
            case "owner" -> comparator = Comparator.comparing(Pet::getOwnerName);
            case "date" -> comparator = Comparator.comparing(Pet::getRegistrationDate);
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
        pets.sort(comparator);
        System.out.println("Sorted by " + field + ":");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
