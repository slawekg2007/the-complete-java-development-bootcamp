import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    private static final String clients= "clients.csv";

    public static void main(String[] args) throws FileNotFoundException {
        Client[] clients1= ClientDataReader.readFile(clients);
//        printAllClients(clients1);
        System.out.println("Najbardziej wartościowy klient to");
        System.out.println(ClientDataReader.mostAmount(clients1));
        ClientDataReader.country(clients1,readCountryFromUser());
        printAvgValueForCountry(clients1, readCountryFromUser());
    }
    private static void printAllClients(Client[] clients){
        for (Client client:clients) {
            System.out.println(client);
        }
    }
    private static void printAvgValueForCountry(Client[] clients, String country) {
        double totalValue = 0;
        int clientsFromCountryCounter = 0;
        for (Client client : clients) {
            if (country.equalsIgnoreCase(client.getCountry())) {
                totalValue += client.getValue();
                clientsFromCountryCounter++;
            }
        }
        if (totalValue > 0) {
            double avgValue = totalValue / clientsFromCountryCounter;
            System.out.printf("Średnia wartość klienta z %s to %.2f", country, avgValue);
        }
    }
    private static String readCountryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę kraju, z którego klienci Cię interesują:");
        return scanner.nextLine();
    }
}
