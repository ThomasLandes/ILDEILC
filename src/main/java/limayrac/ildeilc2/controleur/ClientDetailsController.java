package limayrac.ildeilc2.controleur;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import limayrac.ildeilc2.modele.Client;
import limayrac.ildeilc2.modele.Commande;

/**
 * Contrôleur pour afficher les détails des commandes d'un client.
 * Ce contrôleur permet de visualiser les commandes associées à un client spécifique.
 */
public class ClientDetailsController {

    @FXML
    private TableView<Commande> orderTable;

    @FXML
    private TableColumn<Commande, Number> numCol;
    @FXML
    private TableColumn<Commande, String> statusCol;
    @FXML
    private TableColumn<Commande, String> productCol;
    @FXML
    private TableColumn<Commande, Number> qtyCol;
    @FXML
    private TableColumn<Commande, Number> invoiceCol;
    @FXML
    private TableColumn<Commande, String> invoiceStatusCol;
    @FXML
    private TableColumn<Commande, String> deliveryCol;

    /**
     * Initialise les colonnes de la table des commandes.
     * <p>
     * Cette méthode est appelée automatiquement après le chargement du fichier FXML associé.
     * Elle configure les colonnes de la table pour afficher les propriétés des objets Commande.
     * </p>
     */
    @FXML
    public void initialize() {
        // Configuration des colonnes
        numCol.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("statut"));
        productCol.setCellValueFactory(cellData -> cellData.getValue().getProduit().nomProperty());
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        invoiceCol.setCellValueFactory(cellData -> cellData.getValue().getFacture().numeroFactureProperty());
        invoiceStatusCol.setCellValueFactory(cellData -> cellData.getValue().getFacture().statutProperty());
        deliveryCol.setCellValueFactory(cellData -> cellData.getValue().getStatut().equals("en cours") ? new SimpleStringProperty("Oui") : new SimpleStringProperty("Non"));
    }

    /**
     * Définit le client et met à jour la table des commandes.
     * <p>
     * Cette méthode est appelée pour afficher les commandes d'un client spécifique.
     * Elle vide la table actuelle et ajoute les commandes du client sélectionné.
     * </p>
     *
     * @param client Le client dont les commandes doivent être affichées.
     */
    public void setClient(Client client) {
        orderTable.getItems().clear();
        if (client.getCommandes() != null) {
            orderTable.getItems().addAll(client.getCommandes());
        }
        // Debugging: afficher les commandes du client
        System.out.println("Commandes pour le client " + client.getNom() + ": " + client.getCommandes().size());
    }
}
