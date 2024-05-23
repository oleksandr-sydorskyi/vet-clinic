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

    public void setFirstName(String firstName) {
        this.firstName = StringUtils.capitalizeFirstLetter(firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = StringUtils.capitalizeFirstLetter(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public String getRegistrationDate() {
        return registrationDate.format(US_AM_PM_FORMATTER);
    }

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
}
