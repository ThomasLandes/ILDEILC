package limayrac.ildeilc2.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import limayrac.ildeilc2.modele.Produit;
import limayrac.ildeilc2.modele.Client;
import limayrac.ildeilc2.modele.Commande;
import limayrac.ildeilc2.util.DataGenerator;

import java.util.Optional;

/**
 * Contrôleur pour modifier le stock des produits.
 * Ce contrôleur permet de visualiser et de modifier la quantité en stock des produits.
 */
public class EditStockController {

    @FXML
    private TableView<Produit> productTable;
    @FXML
    private TableColumn<Produit, String> productNameCol;
    @FXML
    private TableColumn<Produit, Number> productStockCol;

    /**
     * Initialise les colonnes de la table des produits et charge les données.
     * <p>
     * Cette méthode est appelée automatiquement après le chargement du fichier FXML associé.
     * Elle configure les colonnes de la table pour afficher les propriétés des objets Produit
     * et charge les produits générés par le DataGenerator.
     * </p>
     */
    @FXML
    public void initialize() {
        // Configuration des colonnes
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        productStockCol.setCellValueFactory(new PropertyValueFactory<>("quantiteEnStock"));

        // Charger les produits
        productTable.getItems().setAll(DataGenerator.getProduits());
    }

    /**
     * Gère l'action de modifier le stock d'un produit.
     * <p>
     * Cette méthode est appelée lorsque l'utilisateur sélectionne un produit et clique sur le bouton
     * pour modifier le stock. Elle ouvre une boîte de dialogue pour entrer la nouvelle quantité en stock,
     * met à jour le produit sélectionné avec la nouvelle quantité et met à jour le statut des commandes
     * associées en conséquence.
     * </p>
     */
    @FXML
    public void handleEditStock() {
        Produit selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            TextInputDialog dialog = new TextInputDialog(String.valueOf(selectedProduct.getQuantiteEnStock()));
            dialog.setTitle("Modification du Stock");
            dialog.setHeaderText("Modifier le stock pour " + selectedProduct.getNom());
            dialog.setContentText("Nouveau stock:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(stock -> {
                try {
                    int newStock = Integer.parseInt(stock);
                    selectedProduct.setQuantiteEnStock(newStock);
                    updateOrderStatus(selectedProduct);
                } catch (NumberFormatException e) {
                    // Gérer l'erreur de format de nombre
                }
            });
        }
    }

    /**
     * Met à jour le statut des commandes en fonction du stock du produit.
     * <p>
     * Cette méthode parcourt toutes les commandes et met à jour leur statut
     * en fonction de la nouvelle quantité en stock du produit. Si la quantité en stock
     * est suffisante pour satisfaire la commande, le statut est mis à jour à "en cours",
     * sinon il est mis à jour à "en attente".
     * </p>
     *
     * @param produit Le produit dont le stock a été modifié.
     */
    private void updateOrderStatus(Produit produit) {
        for (Client client : DataGenerator.getClients()) {
            for (Commande commande : client.getCommandes()) {
                if (commande.getProduit().equals(produit)) {
                    if (produit.getQuantiteEnStock() >= commande.getQuantite()) {
                        commande.setStatut("en cours");
                    } else {
                        commande.setStatut("en attente");
                    }
                }
            }
        }
    }
}
