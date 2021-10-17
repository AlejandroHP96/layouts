package dad.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BorderAndFlowPaneSample extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button("Si");
        b1.setPrefWidth(68);

        Button b2 = new Button("No");
        b2.setPrefWidth(68);

        Button b3 = new Button("Tal vez");
        b3.setPrefWidth(68);

        Button b4 = new Button("Cancelar");
        b4.setPrefWidth(68);

        FlowPane abajo = new FlowPane();
        abajo.setHgap(2);
        abajo.setVgap(5);
        abajo.setAlignment(Pos.BOTTOM_RIGHT);
        abajo.setOrientation(Orientation.HORIZONTAL);
        abajo.setPadding(new Insets(5));
        abajo.getChildren().addAll(b1,b2,b3,b4);

        ImageView centro = new ImageView("https://pbs.twimg.com/profile_images/3185645339/be70264b8b829da7c5037472b805cb95.jpeg");


        BorderPane root = new BorderPane();
        root.setBottom(abajo);
        root.setCenter(centro);
    

        Scene scene = new Scene(root,340,200);

        primaryStage.setTitle("BorderAndFlow");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
