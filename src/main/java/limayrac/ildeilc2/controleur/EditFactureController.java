package limayrac.ildeilc2.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import limayrac.ildeilc2.modele.Facture;
import limayrac.ildeilc2.modele.Client;
import limayrac.ildeilc2.modele.Commande;
import limayrac.ildeilc2.util.DataGenerator;
/**
 * Contrôleur pour gérer les factures.
 * Ce contrôleur permet de visualiser et de modifier le statut des factures.
 */
public class EditFactureController {

    @FXML
    private TableView<Facture> invoiceTable;
    @FXML
    private TableColumn<Facture, Number> invoiceNumberCol;
    @FXML
    private TableColumn<Facture, String> invoiceStatusCol;

    /**
     * Initialise les colonnes de la table des factures et charge les données.
     * <p>
     * Cette méthode est appelée automatiquement après le chargement du fichier FXML associé.
     * Elle configure les colonnes de la table pour afficher les propriétés des objets Facture
     * et charge les factures générées par le DataGenerator.
     * </p>
     */
    @FXML
    public void initialize() {
        // Configuration des colonnes
        invoiceNumberCol.setCellValueFactory(new PropertyValueFactory<>("numeroFacture"));
        invoiceStatusCol.setCellValueFactory(new PropertyValueFactory<>("statut"));

        // Charger les factures
        for (Client client : DataGenerator.getClients()) {
            for (Commande commande : client.getCommandes()) {
                invoiceTable.getItems().add(commande.getFacture());
            }
        }
    }

    /**
     * Gère l'action de marquer une facture comme payée.
     * <p>
     * Cette méthode est appelée lorsque l'utilisateur clique sur le bouton pour marquer
     * une facture comme payée. Elle met à jour le statut de la facture sélectionnée
     * et rafraîchit la table pour refléter le changement.
     * </p>
     */
    @FXML
    public void handleMarkAsPaid() {
        Facture selectedInvoice = invoiceTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice != null) {
            selectedInvoice.setStatut("payé");
            invoiceTable.refresh();
        }
    }
}
