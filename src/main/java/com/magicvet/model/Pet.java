package main.java.com.magicvet.model;

import main.java.com.magicvet.utils.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private PetType type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() { }

    public Pet(PetType type, String name, String age, String sex, String ownerName, HealthState healthState) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.ownerName = ownerName;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "type = " + type +
                ", name = " + name +
                ", sex = " + sex +
                ", age = " + age +
                ", health = " + healthState +
                ", ownerName = " + ownerName +
                ", registrationDate = " + registrationDate.format(FORMATTER) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        sex = sex.toLowerCase();
        this.sex = sex.matches("^(male|m)$") ? "male" :
                sex.matches("^(female|f)$") ? "female" :
                        "UNKNOWN";
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age.matches("\\d+") ? age : "UNKNOWN";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.capitalizeFirstLetter(name);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public enum HealthState {
        UNKNOWN,
        EXCELLENT,
        GOOD,
        POOR,
        CRITICAL
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(String health) {
        health = health.toUpperCase();
        this.healthState =
                health.matches("^(EXCELLENT|E)$") ? HealthState.EXCELLENT :
                        health.matches("^(GOOD|G)$") ? HealthState.GOOD :
                                health.matches("^(POOR|P)$") ? HealthState.POOR :
                                        health.matches("^(CRITICAL|C)$") ? HealthState.CRITICAL :
                                                HealthState.UNKNOWN;
    }

    public String getRegistrationDate() {
        return registrationDate.format(FORMATTER);
    }
}
