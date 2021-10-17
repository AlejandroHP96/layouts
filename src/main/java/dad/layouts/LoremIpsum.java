package dad.layouts;

import java.io.File;

import org.apache.commons.io.FileUtils;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoremIpsum extends Application {

    // View
    private TextArea contenidoText;
    private Button cargarButton, limpiarButton;

    // Model
    private StringProperty contenido = new SimpleStringProperty();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        contenidoText = new TextArea();
        contenidoText.setWrapText(true);

        cargarButton = new Button("Cargar");
        cargarButton.setOnAction(e -> onCargarButtonAction(e));

        limpiarButton = new Button("Limpiar");
        limpiarButton.setOnAction(e -> onLimpiarButtonAction(e));

        FlowPane botonesPane = new FlowPane(5, 5);
        botonesPane.setPadding(new Insets(5));
        botonesPane.setAlignment(Pos.BASELINE_CENTER);
        botonesPane.getChildren().addAll(cargarButton, limpiarButton);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));
        root.setCenter(contenidoText);
        root.setBottom(botonesPane);

        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Lorem Ipsum");
        primaryStage.setScene(scene);
        primaryStage.show();

        // bindeos

        contenidoText.textProperty().bindBidirectional(contenido);
    }

    private void onLimpiarButtonAction(ActionEvent e) {
        contenido.set("");
    }

    private void onCargarButtonAction(ActionEvent e) {

        File fichero = new File("loremipsim.txt");

        try {
            
            String texto = FileUtils.readFileToString(fichero, "UTF-8");
            contenido.set(texto);
        } catch (Exception e1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(primaryStage);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar datos desde " + fichero.getName());
            alert.setContentText(e1.getMessage());
            alert.showAndWait();
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
