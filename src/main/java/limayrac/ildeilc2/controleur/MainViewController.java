package limayrac.ildeilc2.controleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import limayrac.ildeilc2.modele.Client;
import limayrac.ildeilc2.util.DataGenerator;

import java.io.IOException;
import java.util.List;

/**
 * Contrôleur principal de l'application.
 * Ce contrôleur gère la vue principale où les clients sont affichés et permet
 * d'accéder aux fonctionnalités de modification du stock et de gestion des factures.
 */
public class MainViewController {

    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> clientColumn;

    /**
     * Initialise les colonnes de la table des clients et charge les données.
     * <p>
     * Cette méthode est appelée automatiquement après le chargement du fichier FXML associé.
     * Elle configure les colonnes de la table pour afficher les propriétés des objets Client
     * et charge les clients générés par le DataGenerator.
     * </p>
     */
    @FXML
    public void initialize() {
        // Liaison de la colonne Client à la propriété nom
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));

        // Récupérer des données fictives
        List<Client> clients = DataGenerator.generateClientsAndOrders();

        // Ajout des clients à la table
        clientTable.getItems().setAll(clients);

        // Debugging: vérifier que les clients sont ajoutés à la TableView
        System.out.println("Clients ajoutés à la TableView: " + clientTable.getItems().size());

        clientTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
                if (selectedClient != null) {
                    try {
                        loadClientDetailsView(selectedClient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Charge la vue des détails du client sélectionné.
     * <p>
     * Cette méthode est appelée lorsque l'utilisateur double-clique sur un client dans la table.
     * Elle ouvre une nouvelle fenêtre affichant les détails des commandes du client sélectionné.
     * </p>
     *
     * @param client Le client sélectionné dont les détails doivent être affichés.
     * @throws IOException Si le fichier FXML de la vue des détails du client ne peut pas être chargé.
     */
    private void loadClientDetailsView(Client client) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/limayrac/ildeilc2/ClientDetailsView.fxml"));
        Parent root = loader.load();

        ClientDetailsController controller = loader.getController();
        controller.setClient(client);

        Stage stage = new Stage();
        stage.setTitle("Détails du Client");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Gère l'action de modification du stock.
     * <p>
     * Cette méthode est appelée lorsque l'utilisateur sélectionne l'option
     * "Modifier le Stock" dans le menu. Elle ouvre une nouvelle fenêtre pour
     * permettre la modification du stock des produits.
     * </p>
     */
    @FXML
    public void handleEditStock() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/limayrac/ildeilc2/EditStockView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Modification du Stock");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gère l'action de gestion des factures.
     * <p>
     * Cette méthode est appelée lorsque l'utilisateur sélectionne l'option
     * "Gérer les Factures" dans le menu. Elle ouvre une nouvelle fenêtre pour
     * permettre la gestion des factures.
     * </p>
     */
    @FXML
    public void handleEditInvoices() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/limayrac/ildeilc2/EditFactureView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestion des Factures");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
