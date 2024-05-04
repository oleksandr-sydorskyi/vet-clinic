package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        String age1 = dog1.getAge();
        String age2 = dog2.getAge();
        return age1.compareTo(age2);
    }
}
