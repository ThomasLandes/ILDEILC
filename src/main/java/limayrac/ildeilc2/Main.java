package limayrac.ildeilc2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale de l'application JavaFX.
 * Cette classe initialise et lance l'interface utilisateur.
 */
public class Main extends Application {

    /**
     * Point d'entrée de l'application.
     * Cette méthode est appelée lorsque l'application JavaFX est lancée.
     * Elle charge la vue principale à partir du fichier FXML et affiche la fenêtre principale.
     *
     * @param primaryStage La scène principale de l'application.
     * @throws Exception Si le fichier FXML ne peut pas être chargé.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/limayrac/ildeilc2/MainView.fxml"));
        primaryStage.setTitle("Gestion du Stock");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Méthode principale pour lancer l'application.
     * Cette méthode appelle `launch`, qui démarre l'application JavaFX.
     *
     * @param args Les arguments de ligne de commande.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
