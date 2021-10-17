package dad.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception {
            
            FlowPane root = new FlowPane();
            root.setHgap(2); // Hueco Horizontal entre componentes
            root.setVgap(15); //Hueco Vertical entre componentes
            root.setAlignment(Pos.TOP_LEFT);
            root.setOrientation(Orientation.VERTICAL);
            root.setPadding(new Insets(5));
            
            for (int i = 0; i < 50; i++) {
                Button b = new Button("" + i);
                b.setStyle("-fx-background-color: lightgreen;");

                root.getChildren().add(b);
            }

            Scene scene = new Scene(root,640,480);

            primaryStage.setTitle("BorderPae Sample");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args);
        }
}
