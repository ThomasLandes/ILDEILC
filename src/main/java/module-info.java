module limayrac.ildeilc2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens limayrac.ildeilc2 to javafx.fxml;
    opens limayrac.ildeilc2.util to javafx.base;
    opens limayrac.ildeilc2.controleur to javafx.fxml;
    opens limayrac.ildeilc2.modele to javafx.base;


    exports limayrac.ildeilc2;
}
