package main.java.com.magicvet.model;

import main.java.com.magicvet.utils.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter US_AM_PM_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a MM/dd/yyyy");

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
        this.firstName = StringUtils.capitalizeFirstLetter(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = StringUtils.capitalizeFirstLetter(lastName);
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

    public String getRegistrationDate() {
        return registrationDate.format(US_AM_PM_FORMATTER);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = Location.getLocationFromString(location.toUpperCase());
    }

    public enum Location {
        KYIV("K"), LVIV("L"), ODESA("O"), UNKNOWN("U");

        private final String location;

        Location(String shortForm) {
            this.location = shortForm;
        }

        public static Location getLocationFromString(String userInput) {
            for (Location location : Location.values()) {
                if (userInput.equals(location.name()) || userInput.equals(location.getShortForm())) {
                    return location;
                }
            }
            return Location.UNKNOWN;
        }

        public String getShortForm() {
            return location;
        }
    }
}
