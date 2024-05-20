package main.java.com.magicvet.model;

public class Cat extends Pet {

    public Cat() {
    }

    public Cat(PetType type, String name, String age, String sex, String ownerName, HealthState healthState) {
        super(type, name, age, sex, ownerName, healthState);
    }
}
