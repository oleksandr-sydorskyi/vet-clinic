package main.java.com.magicvet;

import main.java.com.magicvet.model.*;
import main.java.com.magicvet.service.PetService;

public class Sandbox {

    public static void main(String[] args) {
        Pet[] pets = {
                new Dog(PetType.DOG, "Bella", "12", "female", "John Doe", Pet.HealthState.POOR, Dog.Size.S),
                new Dog(PetType.DOG, "Charlie", "4", "male", "Aaron Doe", Pet.HealthState.CRITICAL, Dog.Size.XL),
                new Dog(PetType.DOG, "Daisy", "6", "female", "Aaron Doe", Pet.HealthState.EXCELLENT, Dog.Size.M),
                new Cat(PetType.CAT, "Zorro", "2", "male", "John Doe", Pet.HealthState.EXCELLENT),
                new Cat(PetType.CAT, "Asia", "10", "female", "Daniel Crew", Pet.HealthState.GOOD)
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
