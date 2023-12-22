import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientDataReader {

    static Client[] readFile (String fileName) throws FileNotFoundException {
        int howMany = howManyLines(fileName);
        Client [] clients = new Client[howMany];
        Scanner scanner = new Scanner(new File(fileName));
        scanner.nextLine();
        for (int i = 0; i <howMany ; i++) {
            clients[i]= createClientFromCSV(scanner.nextLine());
        }
        return clients;
    }


    static Client mostAmount(Client[] clients){
        Client MostValueClient = clients[0];
        for (Client client1:clients) {
            if (MostValueClient.getValue()<client1.getValue())
                MostValueClient=client1;
        }
        return MostValueClient;
    }

    static void country(Client[] clients, String chooseCountry){
        System.out.println( "Klienci z kraju "+chooseCountry);
        for (Client client:clients) {
            if (client.getCountry().equalsIgnoreCase(chooseCountry))
                System.out.println(client);
        }
    }





    private static Client createClientFromCSV(String csvLine){
        String[] line = csvLine.split(",");
        int id = Integer.parseInt(line[0]);
        String firstName = line[1];
        String lastName = line[2];
        String country = line[3];
        double value = Double.parseDouble(line[4]);
        return new Client(id, firstName, lastName, country, value);
    }

    private static int howManyLines(String fileName) throws FileNotFoundException {
        int counter = 0;
        Scanner scanner = new Scanner(new File(fileName));
        scanner.nextLine();
        while (scanner.hasNextLine()){
            scanner.nextLine();
            counter++;
        }
        return counter;
    }
}
