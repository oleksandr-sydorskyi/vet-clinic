package main.java.com.magicvet.model;

public class Cat extends Pet {

    public Cat() {
        super.setType(PetType.CAT);
    }

    public Cat(String name, String age, Sex sex, String ownerName, HealthState healthState) {
        super(PetType.CAT, name, age, sex, ownerName, healthState);
    }
}
