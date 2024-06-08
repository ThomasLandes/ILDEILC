package limayrac.ildeilc2.modele;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe représentant un client.
 * Un client a un nom et une liste de commandes.
 */
public class Client {

    private StringProperty nom;
    private List<Commande> commandes;

    /**
     * Constructeur de la classe Client.
     *
     * @param nom Le nom du client.
     */
    public Client(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    /**
     * Retourne le nom du client.
     *
     * @return Le nom du client.
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * Définit le nom du client.
     *
     * @param nom Le nouveau nom du client.
     */
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    /**
     * Retourne la propriété du nom du client.
     *
     * @return La propriété du nom du client.
     */
    public StringProperty nomProperty() {
        return nom;
    }

    /**
     * Retourne la liste des commandes du client.
     *
     * @return La liste des commandes du client.
     */
    public List<Commande> getCommandes() {
        return commandes;
    }

    /**
     * Définit la liste des commandes du client.
     *
     * @param commandes La nouvelle liste des commandes du client.
     */
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
