package limayrac.ildeilc2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe représentant un produit.
 * Un produit a un nom et une quantité en stock.
 */
public class Produit {

    private StringProperty nom;
    private IntegerProperty quantiteEnStock;

    /**
     * Constructeur de la classe Produit.
     *
     * @param nom Le nom du produit.
     * @param quantiteEnStock La quantité en stock du produit.
     */
    public Produit(String nom, int quantiteEnStock) {
        this.nom = new SimpleStringProperty(nom);
        this.quantiteEnStock = new SimpleIntegerProperty(quantiteEnStock);
    }

    /**
     * Retourne le nom du produit.
     *
     * @return Le nom du produit.
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * Définit le nom du produit.
     *
     * @param nom Le nouveau nom du produit.
     */
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    /**
     * Retourne la propriété du nom du produit.
     *
     * @return La propriété du nom du produit.
     */
    public StringProperty nomProperty() {
        return nom;
    }

    /**
     * Retourne la quantité en stock du produit.
     *
     * @return La quantité en stock du produit.
     */
    public int getQuantiteEnStock() {
        return quantiteEnStock.get();
    }

    /**
     * Définit la quantité en stock du produit.
     *
     * @param quantiteEnStock La nouvelle quantité en stock du produit.
     */
    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock.set(quantiteEnStock);
    }

    /**
     * Retourne la propriété de la quantité en stock du produit.
     *
     * @return La propriété de la quantité en stock du produit.
     */
    public IntegerProperty quantiteEnStockProperty() {
        return quantiteEnStock;
    }
}
