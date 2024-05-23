package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.PetService;

public class Sandbox {

    public static void main(String[] args) {
        Pet[] pets = {
                new Dog("Bella", "12", "female", "John Doe", Pet.HealthState.POOR, Dog.Size.S),
                new Dog("Charlie", "4", "male", "Aaron Doe", Pet.HealthState.CRITICAL, Dog.Size.XL),
                new Dog("Daisy", "UNKNOWN", "female", "Aaron Doe", Pet.HealthState.EXCELLENT, Dog.Size.M),
                new Cat("Zorro", "2", "male", "John Doe", Pet.HealthState.EXCELLENT),
                new Cat("Asia", "10", "female", "Daniel Crew", Pet.HealthState.GOOD)
        };

        PetService.sortPetsByField(pets, "size");
        PetService.sortPetsByField(pets, "name");
        PetService.sortPetsByField(pets, "age");
        PetService.sortPetsByField(pets, "health");
        PetService.sortPetsByField(pets, "owner");
        PetService.sortPetsByField(pets, "type");
        System.out.println();
        System.out.println(new Client());
    }
}
