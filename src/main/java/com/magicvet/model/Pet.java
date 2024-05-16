package main.java.com.magicvet.model;

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

    public Pet(String name, String age, HealthState healthState) {
        this.name = name;
        this.age = age;
        this.healthState = healthState;
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
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public enum HealthState {
        EXCELLENT(1),
        GOOD(2),
        POOR(3),
        CRITICAL(4),
        UNKNOWN(0);

        private final int value;

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(String health) {
        health = health.toUpperCase();
        this.healthState = Pet.HealthState.valueOf(
                health.matches("^(EXCELLENT|E)$") ? "EXCELLENT" :
                        health.matches("^(GOOD|G)$") ? "GOOD" :
                                health.matches("^(POOR|P)$") ? "POOR" :
                                        health.matches("^(CRITICAL|C)$") ? "CRITICAL" :
                                                "UNKNOWN"
        );
    }

    public String getRegistrationDate() {
        return registrationDate.format(FORMATTER);
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
}
