package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogAgeComparator;
import main.java.com.magicvet.comparator.DogNameComparator;
import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void sortDogsByField(Dog[] dogs, String field) {
        Comparator<Dog> comparator;
        switch (field.toLowerCase()) {
            case "size":
                comparator = new DogSizeComparator();
                break;
            case "name":
                comparator = new DogNameComparator();
                break;
            case "age":
                comparator = new DogAgeComparator();
                break;
            default:
                System.out.println("Unsupported field for sorting: " + field);
                return;
        }
        Arrays.sort(dogs, comparator);
    }

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("Basia", "5", Dog.M),
                new Dog("Patron", "3", Dog.S),
                new Dog("Dollar", "1", Dog.XL),
                new Dog("Reda", "3", Dog.XL),
                new Dog("Angel", "6", Dog.XS),
                new Dog("Sunny", "12", Dog.S),
        };

        sortDogsByField(dogs, "size");
        for (Dog dog : dogs) {
            System.out.print(dog.getSize() + " ");
        }
        System.out.println();

        sortDogsByField(dogs, "name");
        for (Dog dog : dogs) {
            System.out.print(dog.getName() + " ");
        }
        System.out.println();

        sortDogsByField(dogs, "age");
        for (Dog dog : dogs) {
            System.out.print(dog.getAge() + " ");
        }
    }
}
