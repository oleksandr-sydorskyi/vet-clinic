package main.java.com.magicvet.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum PetType {
    DOG("D"),
    CAT("C");

    private final String shortForm;

    PetType(String shortForm) {
        this.shortForm = shortForm;
    }

    public static String printPetTypes() {
        return Arrays.stream(PetType.values())
                .map(petType -> petType.name() + " (" + petType.shortForm.toLowerCase() + ")")
                .collect(Collectors.joining(" / ")) + ": ";
    }

    public static PetType getPetTypeFromString(String userInput) {
        String input = userInput.toUpperCase();
        for (PetType petType : PetType.values()) {
            if (input.equals(petType.name()) || input.equals(petType.getShortForm())) {
                return petType;
            }
        }
        System.out.println("Unable to parse value '" + userInput + "'. Using default value: " + CAT);
        return CAT;
    }

    public String getShortForm() {
        return shortForm;
    }
}
