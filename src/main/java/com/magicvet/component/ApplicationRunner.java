package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();
            if (client != null) {
                System.out.println("Would you like to register а pet immediately? (yes / no): ");
                String input;
                do {
                    input = Main.SCANNER.nextLine().trim().toLowerCase();
                    if (input.equals("yes")) {
                        System.out.println("Adding a new pet.");
                        Pet pet = petService.registerNewPet();
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    } else if (input.equals("no")) {
                        System.out.println("You can register a pet later.");
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                } while (!(input.equals("yes") || input.equals("no")));
            }
        }
    }
}
