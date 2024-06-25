package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Pet {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private PetType type;
    private Sex sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() { }

    public Pet(PetType type, String name, String age, Sex sex, String ownerName, HealthState healthState) {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setHealthState(HealthState health) {
        this.healthState = health;
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

    public enum Sex {
        MALE("M"),
        FEMALE("F"),
        UNKNOWN("U");

        private final String shortForm;

        Sex(String shortForm) {
            this.shortForm = shortForm;
        }

        public static String printSexes() {
            return Arrays.stream(Sex.values())
                    .map(sex -> sex.name() + " (" + sex.shortForm.toLowerCase() + ")")
                    .collect(Collectors.joining(" / ")) + ": ";
        }

        public static Sex getSexFromString(String userInput) {
            String input = userInput.toUpperCase();
            for (Sex sex : Sex.values()) {
                if (sex.name().equals(input) || sex.getShortForm().equals(input)) {
                    return sex;
                }
            }
            System.out.println("Unable to parse value '" + userInput + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }

        public String getShortForm() {
            return shortForm;
        }
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public enum HealthState {
        EXCELLENT("E"),
        GOOD("G"),
        POOR("P"),
        CRITICAL("C"),
        UNKNOWN("U");

        private final String shortForm;

        HealthState(String shortForm) {
            this.shortForm = shortForm;
        }

        public static String printHealth() {
            return Arrays.stream(HealthState.values())
                    .map(health -> health.name() + " (" + health.shortForm.toLowerCase() + ")")
                    .collect(Collectors.joining(" / ")) + ": ";
        }

        public static HealthState getHealthFromString(String userInput) {
            String input = userInput.toUpperCase();
            for (HealthState state : HealthState.values()) {
                if (state.name().equals(input) || state.getShortForm().equals(input)) {
                    return state;
                }
            }
            System.out.println("Unable to parse value '" + userInput + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }

        public String getShortForm() {
            return shortForm;
        }
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
