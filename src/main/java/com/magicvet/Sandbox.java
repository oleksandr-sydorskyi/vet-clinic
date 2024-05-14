package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void sortDogsByField(Dog[] dogs, String field) {
        System.out.println("Sorting dogs by: " + field);
        Comparator<Dog> comparator;
        switch (field.toLowerCase()) {
            case "size":
                comparator = new Comparator<Dog>() {
                    @Override
                    public int compare(Dog o1, Dog o2) {
                        return o1.getSize().getValue() - o2.getSize().getValue();
                    }
                };
                break;
            case "name":
                comparator = new Comparator<Dog>() {
                    @Override
                    public int compare(Dog o1, Dog o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                };
                break;
            case "age":
                comparator = new Comparator<Dog>() {
                    @Override
                    public int compare(Dog o1, Dog o2) {
                        return Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
                    }
                };
                break;
            case "health":
                comparator = new Comparator<Dog>() {
                    @Override
                    public int compare(Dog o1, Dog o2) {
                        return o1.getHealthState().getValue() - o2.getHealthState().getValue();
                    }
                };
                break;
            default:
                System.out.println("Unsupported field for sorting: " + field);
                return;
        }
        Arrays.sort(dogs, comparator);
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("Basia", "5", Dog.Size.M, Dog.HealthState.GOOD),
                new Dog("Patron", "3", Dog.Size.S, Dog.HealthState.EXCELLENT),
                new Dog("Dollar", "1", Dog.Size.XL, Dog.HealthState.UNKNOWN),
                new Dog("Reda", "3", Dog.Size.XL, Dog.HealthState.CRITICAL),
                new Dog("Angel", "6", Dog.Size.XS, Dog.HealthState.POOR),
                new Dog("Sunny", "12", Dog.Size.S, Dog.HealthState.GOOD),
        };

        sortDogsByField(dogs, "size");
        sortDogsByField(dogs, "name");
        sortDogsByField(dogs, "age");
        sortDogsByField(dogs, "health");

        System.out.println(new Cat());
    }
}
