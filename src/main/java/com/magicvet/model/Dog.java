package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() {
        super.setType(PetType.DOG);
    }

    public Dog(String name, String age, Sex sex, String ownerName, HealthState healthState, Size size) {
        super(PetType.DOG, name, age, sex, ownerName, healthState);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "type = " + getType() +
                ", name = " + getName() +
                ", sex = " + getSex() +
                ", age = " + getAge() +
                ", size = " + getSize() +
                ", health = " + getHealthState() +
                ", ownerName = " + getOwnerName() +
                ", registrationDate = " + getRegistrationDate().format(FORMATTER) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size {
        XS, S, M, L, XL, UNKNOWN;

        public static String printSizes() {
            String[] array = new String[Size.values().length];
            int i = 0;
            for (Size size : Size.values()) {
                array[i++] = size.name();
            }
            return String.join(" / ", array) + ": ";
        }

        public static Size getSizeFromString(String userInput) {
            String input = userInput.toUpperCase();
            try {
                return Size.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to parse value '" + userInput + "'. Using default value: " + UNKNOWN);
            }
            return UNKNOWN;
        }
    }
}
