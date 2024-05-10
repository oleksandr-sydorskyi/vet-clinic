package main.java.com.magicvet.model;

import java.util.Objects;

public abstract class Pet {

    private PetType type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;

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
        this.sex = sex.matches("^(male|m)$") ? "male" :
                sex.matches("^(female|f)$") ? "female" :
                        "UNKNOWN";
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.healthState = Pet.HealthState.valueOf(
                health.matches("^(EXCELLENT|E)$") ? "EXCELLENT" :
                        health.matches("^(GOOD|G)$") ? "GOOD" :
                                health.matches("^(POOR|P)$") ? "POOR" :
                                        health.matches("^(CRITICAL|C)$") ? "CRITICAL" :
                                                "UNKNOWN"
        );
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
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }
}
