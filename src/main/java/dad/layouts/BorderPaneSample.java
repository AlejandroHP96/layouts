package dad.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneSample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // norte
        HBox norte = new HBox(5, new Label("Etiqueta"), new Button("Botón"));
        norte.setAlignment(Pos.BASELINE_CENTER);
        norte.setStyle(" -fx-background-color: red;");
        norte.setPadding(new Insets(5));

        // Right

        Button este = new Button("Este");
        BorderPane.setAlignment(este, Pos.CENTER);

        // left

        Button b1 = new Button("Botón 1");
        b1.setMaxWidth(Double.MAX_VALUE);

        Button b2 = new Button("Botón 2222");
        b2.setMaxWidth(Double.MAX_VALUE);

        Button b3 = new Button("Botón 3333333333");
        b3.setMaxWidth(Double.MAX_VALUE);

        VBox oeste = new VBox(5, b1, b2, b3);
        oeste.setPadding(new Insets(5));
        oeste.setStyle("-fx-background-color: blue;");


        //South

        Button b4 = new Button("Botón 4");
        Button b5 = new Button("Botón 5");
        Button b6 = new Button("Botón 6");

        HBox sur = new HBox(5,b4,b5,b6);
        sur.setPadding(new Insets(5));
        sur.setStyle("-fx-background-color: yellow;");

        // center

        ImageView centro = new ImageView("https://pbs.twimg.com/profile_images/3185645339/be70264b8b829da7c5037472b805cb95.jpeg");

        BorderPane root = new BorderPane();
        root.setTop(norte);
        root.setBottom(sur);
        root.setCenter(centro);
        root.setRight(este);
        root.setLeft(oeste);

        Scene scene = new Scene(root,640,480);

            primaryStage.setTitle("BorderPae Sample");
            primaryStage.setScene(scene);
            primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
