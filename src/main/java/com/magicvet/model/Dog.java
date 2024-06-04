package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() {
        super.setType(PetType.DOG);
    }

    public Dog(String name, String age, String sex, String ownerName, HealthState healthState, Size size) {
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
                ", registrationDate = " + getRegistrationDate() +
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

    public void setSize(String size) {
        size = size.toUpperCase();
        this.size = size.matches("^(XS|S|M|L|XL)$") ? Size.valueOf(size) : Size.UNKNOWN;
    }

    public enum Size {
        UNKNOWN, XS, S, M, L, XL
    }
}
