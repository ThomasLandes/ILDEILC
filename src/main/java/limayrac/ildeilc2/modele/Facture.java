package limayrac.ildeilc2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe représentant une facture.
 * Une facture a un numéro et un statut.
 */
public class Facture {

    private IntegerProperty numeroFacture;
    private StringProperty statut;

    /**
     * Constructeur de la classe Facture.
     *
     * @param numeroFacture Le numéro de la facture.
     */
    public Facture(int numeroFacture) {
        this.numeroFacture = new SimpleIntegerProperty(numeroFacture);
        this.statut = new SimpleStringProperty("en cours");
    }

    /**
     * Retourne le numéro de la facture.
     *
     * @return Le numéro de la facture.
     */
    public int getNumeroFacture() {
        return numeroFacture.get();
    }

    /**
     * Définit le numéro de la facture.
     *
     * @param numeroFacture Le nouveau numéro de la facture.
     */
    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture.set(numeroFacture);
    }

    /**
     * Retourne la propriété du numéro de la facture.
     *
     * @return La propriété du numéro de la facture.
     */
    public IntegerProperty numeroFactureProperty() {
        return numeroFacture;
    }

    /**
     * Retourne le statut de la facture.
     *
     * @return Le statut de la facture.
     */
    public String getStatut() {
        return statut.get();
    }

    /**
     * Définit le statut de la facture.
     *
     * @param statut Le nouveau statut de la facture.
     */
    public void setStatut(String statut) {
        this.statut.set(statut);
    }

    /**
     * Retourne la propriété du statut de la facture.
     *
     * @return La propriété du statut de la facture.
     */
    public StringProperty statutProperty() {
        return statut;
    }
}
