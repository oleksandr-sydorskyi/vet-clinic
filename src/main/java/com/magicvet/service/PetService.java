package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";

    public Pet registerNewPet() {
        Pet pet;
        System.out.print("Type (dog / cat / other: ");
        String type = Main.SCANNER.nextLine();
        if (DOG_TYPE.equals(type)) {
            pet = buildDog();
        } else {
            pet = buildPet(type);
        }
        return pet;
    }

    private Dog buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);
        System.out.print("Size (XS / S / M / L / XXL): ");
        dog.setSize(Main.SCANNER.nextLine().toUpperCase());
        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog = new Dog();
        dog.setType(pet.getType());
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());
        return dog;
    }

    private Pet buildPet(String type) {
        Pet pet = new Pet();
        pet.setType(type);
        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Sex: male (m) / female (f) / unknown (u): ");
        String sex = Main.SCANNER.nextLine();
        pet.setSex(sex.matches("^(male|m)$") ? "male" :
                sex.matches("^(female|f)$") ? "female" :
                        "unknown");
        return pet;
    }
}
