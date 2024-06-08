package limayrac.ildeilc2.util;

import limayrac.ildeilc2.modele.Client;
import limayrac.ildeilc2.modele.Commande;
import limayrac.ildeilc2.modele.Facture;
import limayrac.ildeilc2.modele.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour générer des données fictives pour l'application.
 * Elle crée des clients, des produits et des commandes.
 */
public class DataGenerator {

    private static List<Client> clients;
    private static List<Produit> produits;

    /**
     * Génère des clients, des produits et des commandes fictifs pour les tests.
     * <p>
     * Cette méthode crée :
     * <ul>
     *     <li>15 produits avec des quantités en stock aléatoires.</li>
     *     <li>10 clients avec des listes de commandes vides.</li>
     *     <li>12 commandes aléatoires associées aux clients et aux produits.</li>
     *     <li>Une commande spécifique "en attente" pour s'assurer qu'il y a toujours au moins une commande en attente.</li>
     * </ul>
     * Les commandes sont associées à des factures, et leur statut est déterminé par la quantité en stock du produit.
     * Si la quantité commandée est supérieure à la quantité en stock, le statut est "en attente", sinon il est "en cours".
     *
     * @return La liste des clients générés avec leurs commandes.
     */
    public static List<Client> generateClientsAndOrders() {
        clients = new ArrayList<>();
        produits = new ArrayList<>();
        Random random = new Random();

        // Créer des produits fictifs
        for (int i = 1; i <= 15; i++) {
            produits.add(new Produit("Produit " + i, random.nextInt(50) + 1));
        }

        // Créer des clients fictifs
        for (int i = 1; i <= 10; i++) {
            Client client = new Client("Client " + i);
            client.setCommandes(new ArrayList<>());
            clients.add(client);
        }

        // Créer des commandes fictives et les assigner aux clients
        for (int i = 1; i <= 12; i++) {
            Produit produit = produits.get(random.nextInt(produits.size()));
            int quantite = random.nextInt(10) + 1;
            int clientId = random.nextInt(clients.size());
            Commande commande = new Commande(i, produit, quantite, clientId);
            Facture facture = new Facture(1000 + i);

            commande.setFacture(facture);
            commande.setStatut(quantite <= produit.getQuantiteEnStock() ? "en cours" : "en attente");

            // Assigner des commandes aux clients
            clients.get(clientId).getCommandes().add(commande);
        }

        // Ajouter une commande "en attente"
        Produit produitInsuffisant = produits.get(0);
        produitInsuffisant.setQuantiteEnStock(1);  // Assurons-nous que le stock est insuffisant
        Client clientPourCommandeAttente = clients.get(0);
        Commande commandeAttente = new Commande(13, produitInsuffisant, 10, 0); // Utilisation de l'index du client
        Facture factureAttente = new Facture(1013);
        commandeAttente.setFacture(factureAttente);
        commandeAttente.setStatut("en attente");
        clientPourCommandeAttente.getCommandes().add(commandeAttente);

        return clients;
    }

    /**
     * Retourne la liste des clients générés.
     *
     * @return La liste des clients.
     */
    public static List<Client> getClients() {
        return clients;
    }

    /**
     * Retourne la liste des produits générés.
     *
     * @return La liste des produits.
     */
    public static List<Produit> getProduits() {
        return produits;
    }
}
