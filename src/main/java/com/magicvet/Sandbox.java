package main.java.com.magicvet;

import main.java.com.magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void sortDogsByField(Dog[] dogs, String field) {
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
            default:
                System.out.println("Unsupported field for sorting: " + field);
                return;
        }
        Arrays.sort(dogs, comparator);
    }

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("Basia", "5", Dog.Size.M),
                new Dog("Patron", "3", Dog.Size.S),
                new Dog("Dollar", "1", Dog.Size.XL),
                new Dog("Reda", "3", Dog.Size.XL),
                new Dog("Angel", "6", Dog.Size.XS),
                new Dog("Sunny", "12", Dog.Size.S),
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
