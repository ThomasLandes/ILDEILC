package limayrac.ildeilc2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe représentant une commande.
 * Une commande a un numéro, un statut, un produit, une quantité, une facture, et un identifiant de client.
 */
public class Commande {

    private IntegerProperty numeroCommande;
    private StringProperty statut;
    private Produit produit;
    private IntegerProperty quantite;
    private Facture facture;
    private IntegerProperty clientId;

    /**
     * Constructeur de la classe Commande.
     *
     * @param numeroCommande Le numéro de la commande.
     * @param produit Le produit associé à la commande.
     * @param quantite La quantité du produit commandée.
     * @param clientId L'identifiant du client qui a passé la commande.
     */
    public Commande(int numeroCommande, Produit produit, int quantite, int clientId) {
        this.numeroCommande = new SimpleIntegerProperty(numeroCommande);
        this.produit = produit;
        this.quantite = new SimpleIntegerProperty(quantite);
        this.statut = new SimpleStringProperty("en attente");
        this.clientId = new SimpleIntegerProperty(clientId);
    }

    /**
     * Retourne le numéro de la commande.
     *
     * @return Le numéro de la commande.
     */
    public int getNumeroCommande() {
        return numeroCommande.get();
    }

    /**
     * Définit le numéro de la commande.
     *
     * @param numeroCommande Le nouveau numéro de la commande.
     */
    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande.set(numeroCommande);
    }

    /**
     * Retourne la propriété du numéro de la commande.
     *
     * @return La propriété du numéro de la commande.
     */
    public IntegerProperty numeroCommandeProperty() {
        return numeroCommande;
    }

    /**
     * Retourne le statut de la commande.
     *
     * @return Le statut de la commande.
     */
    public String getStatut() {
        return statut.get();
    }

    /**
     * Définit le statut de la commande.
     *
     * @param statut Le nouveau statut de la commande.
     */
    public void setStatut(String statut) {
        this.statut.set(statut);
    }

    /**
     * Retourne la propriété du statut de la commande.
     *
     * @return La propriété du statut de la commande.
     */
    public StringProperty statutProperty() {
        return statut;
    }

    /**
     * Retourne le produit associé à la commande.
     *
     * @return Le produit associé à la commande.
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * Définit le produit associé à la commande.
     *
     * @param produit Le nouveau produit associé à la commande.
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * Retourne la quantité du produit commandée.
     *
     * @return La quantité du produit commandée.
     */
    public int getQuantite() {
        return quantite.get();
    }

    /**
     * Définit la quantité du produit commandée.
     *
     * @param quantite La nouvelle quantité du produit commandée.
     */
    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }

    /**
     * Retourne la propriété de la quantité du produit commandée.
     *
     * @return La propriété de la quantité du produit commandée.
     */
    public IntegerProperty quantiteProperty() {
        return quantite;
    }

    /**
     * Retourne la facture associée à la commande.
     *
     * @return La facture associée à la commande.
     */
    public Facture getFacture() {
        return facture;
    }

    /**
     * Définit la facture associée à la commande.
     *
     * @param facture La nouvelle facture associée à la commande.
     */
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    /**
     * Retourne l'identifiant du client qui a passé la commande.
     *
     * @return L'identifiant du client qui a passé la commande.
     */
    public int getClientId() {
        return clientId.get();
    }

    /**
     * Définit l'identifiant du client qui a passé la commande.
     *
     * @param clientId Le nouvel identifiant du client qui a passé la commande.
     */
    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    /**
     * Retourne la propriété de l'identifiant du client qui a passé la commande.
     *
     * @return La propriété de l'identifiant du client qui a passé la commande.
     */
    public IntegerProperty clientIdProperty() {
        return clientId;
    }
}
