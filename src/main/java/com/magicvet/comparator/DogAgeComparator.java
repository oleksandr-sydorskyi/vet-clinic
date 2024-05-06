package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return Integer.parseInt(dog1.getAge()) - Integer.parseInt(dog2.getAge());
    }
}
