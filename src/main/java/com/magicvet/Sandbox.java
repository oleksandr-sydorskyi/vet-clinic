package main.java.com.magicvet;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.model.PetType;
import main.java.com.magicvet.service.PetService;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(PetType.DOG, "Bella", "12", "female", "John Doe", Pet.HealthState.POOR, Dog.Size.S),
                new Dog(PetType.DOG, "Charlie", "4", "male", "John Doe", Pet.HealthState.CRITICAL, Dog.Size.XL),
                new Dog(PetType.DOG, "Daisy", "6", "female", "John Doe", Pet.HealthState.EXCELLENT, Dog.Size.M),
        };

        PetService.sortDogsByField(dogs, "size");
        PetService.sortDogsByField(dogs, "name");
        PetService.sortDogsByField(dogs, "age");
        PetService.sortDogsByField(dogs, "health");
        System.out.println();
        System.out.println(new Client());
    }
}
