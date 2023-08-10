
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quel est le nom de l'hôtel ? ");
        String name = sc.nextLine();
        System.out.println(name + " créé avec succès !");

        Hotel h1 = new Hotel();
        h1.createReservation(h1.getClients().get(1));
        h1.createReservation(h1.getClients().get(0));
        h1.createReservation(h1.getClients().get(1));
        h1.createReservation(h1.getClients().get(2));
        h1.createReservation(h1.getClients().get(1));
        int num = -1;

        while(num != 0){
            System.out.println("=== Menu Principal ===");
            System.out.println();
            System.out.println("1. Ajouter un client");
            System.out.println("2. Afficher la liste des clients");
            System.out.println("3. Afficher les réservations d'un client");
            System.out.println("4. Ajouter une reservation");
            System.out.println("5. Annuler une reservation");
            System.out.println("6. Afficher la liste des reservations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            num = sc.nextInt();

            if(num == 1) {
                System.out.println("=== Ajout d'un client ===");
                System.out.println();
                sc.nextLine();
                System.out.println("Quel est le nom du client? ");
                String lastname = sc.nextLine();
                System.out.println("Quel est le prénom du client? ");
                String firstname = sc.nextLine();
                System.out.println("Quel est le numéro de téléphone du client? ");
                String numberfone = sc.nextLine();
                Client client = new Client(lastname, firstname, numberfone);
                h1.getClients().add(client);
                System.out.println("Client ajouté avec succès !");
            }

            if(num == 2) {
                System.out.println("=== Liste des clients ===");
                System.out.println();
                for(int i = 0; i < h1.getClients().size(); i++) {
                    System.out.println(h1.getClients().get(i).toString());
                }
            }

            if(num == 3) {
                System.out.println("=== Réservations par client ===");
                System.out.println();
                System.out.println("Quel est le nom du client dont vous voulez la liste de réservations ?");
                sc.nextLine();
                String lastname = sc.nextLine();
                System.out.println("Quel est le prénom du client dont vous voulez la liste de réservations ?");
                String firstname = sc.nextLine();
                System.out.println(h1.reservationByClient(new Client(lastname, firstname)));
                System.out.println(h1.getChambres());
                System.out.println();
                System.out.println(h1.reservationList());
            }

            if(num == 4) {
                System.out.println("=== Ajouter une réservation ===");
                System.out.println();
                System.out.println("1. Souhaitez-vous ajouter une réservation pour un client déjà enregistré dans l'hôtel");
                System.out.println("2. Souhaitez-vous ajouter une réservation pour un nouveau client ");
                int nb = sc.nextInt();
                if(nb == 1) {
                    sc.nextLine();
                    System.out.println("Quel est le nom du client? ");
                    String lastname = sc.nextLine();
                    System.out.println("Quel est le prénom du client? ");
                    String firstname = sc.nextLine();
                    String str = "";
                    for(int i = 0; i < h1.getClients().size(); i++) {
                        if(h1.getClients().get(i).getLastname().equals(lastname) && h1.getClients().get(i).getFirstname().equals(firstname)){
                            h1.createReservation(h1.getClients().get(i));
                            str = "Réservation effectué avec succès pour " + lastname + " " + firstname;
                            break;
                        }


                    }
                    if(str.equals("")) {
                        System.out.println("Le client demandé n'existe pas dans cette hôtel.");
                        System.out.println("Enregistrez le en tant que nouveau client !");
                    } else {
                        System.out.println(str);
                    }
                }
                if(nb == 2) {
                    sc.nextLine();
                    System.out.println("Quel est le nom du client? ");
                    String lastname = sc.nextLine();
                    System.out.println("Quel est le prénom du client? ");
                    String firstname = sc.nextLine();
                    System.out.println("Quel est le numéro de téléphone du client? ");
                    String numberfone = sc.nextLine();
                    Client client = new Client(lastname, firstname, numberfone);
                    h1.getClients().add(client);
                    h1.createReservation(client);
                    System.out.println("Réservation effectué avec succès pour " + lastname + " " + firstname);
                }
                if(nb != 1 && nb !=2) {
                    System.out.println("vous devez séléctionner une option entre la 1 et la 2.");
                }

            }

            if(num == 5) {
                System.out.println("=== Annuler une réservation ===");
                System.out.println();

                System.out.println("Pour quel client souhaitez-vous annuler une réservation ?");
                System.out.print("Nom du client : ");
                sc.nextLine();
                String lastname = sc.nextLine();
                System.out.print("Prénom du client : ");
                String firstname = sc.nextLine();
                h1.DeleteReservation(new Client(lastname, firstname));
            }

            if(num == 6) {
                System.out.println("=== Liste des réservations de l'hotel ===");
                System.out.println();
                System.out.println(h1.reservationList());
            }
        }
        System.out.println();
        System.out.println("Merci de votre visite");
        System.out.println("***************");
        System.out.println(" A bientot !!!");
        System.out.println("***************");
    }




}
