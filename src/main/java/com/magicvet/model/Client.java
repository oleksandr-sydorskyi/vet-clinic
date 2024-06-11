package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    public static final DateTimeFormatter US_AM_PM_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a MM/dd/yyyy");

    private String firstName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registrationDate = LocalDateTime.now();
    private Location location;

    @Override
    public String toString() {
        StringBuilder stringPets = new StringBuilder();
        for (Pet pet : pets) {
            stringPets.append("\n\t").append(pet);
        }
        return "Client {" +
                "\n\tfirstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", location = " + location +
                ", registrationDate = " + registrationDate.format(US_AM_PM_FORMATTER) +
                ",\n\tpets = " + stringPets +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pets);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public enum Location {
        KYIV("K"),
        LVIV("L"),
        ODESA("O"),
        UNKNOWN("U");

        private final String shortForm;

        Location(String shortForm) {
            this.shortForm = shortForm;
        }

        public static String printLocations() {
            String[] array = new String[Location.values().length];
            int i = 0;
            for (Location location : Location.values()) {
                array[i++] = location.name() + " (" + location.shortForm.toLowerCase() + ")";
            }
            return String.join(" / ", array) + ": ";
        }

        public static Location getLocationFromString(String userInput) {
            String input = userInput.toUpperCase();
            for (Location location : Location.values()) {
                if (input.equals(location.name()) || input.equals(location.getShortForm())) {
                    return location;
                }
            }
            System.out.println("Unable to parse value '" + userInput + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }

        public String getShortForm() {
            return shortForm;
        }
    }
}
