package main.java.com.magicvet.model;

public enum PetType {
    DOG("D"),
    CAT("C");

    private final String shortForm;

    PetType(String shortForm) {
        this.shortForm = shortForm;
    }

    public static String printPetTypes() {
        String[] array = new String[PetType.values().length];
        int i = 0;
        for (PetType petType : PetType.values()) {
            array[i++] = petType.name() + " (" + petType.shortForm.toLowerCase() + ")";
        }
        return String.join(" / ", array) + ": ";
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
