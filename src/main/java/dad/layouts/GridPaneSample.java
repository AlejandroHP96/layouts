package dad.layouts;

import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneSample extends Application {

    //model

    private ObjectProperty<LocalDate> fechaNac = new SimpleObjectProperty<>();
    private IntegerProperty edad = new SimpleIntegerProperty();


    // view

    private TextField nombreText;
    private TextField apellidoText;
    private TextField dniText;
    private DatePicker fechaNacPicker;
    private Label edadLabel;
    private TextField [] ibanText;
    private RadioButton hombreRadio,mujerRadio;
    private TextArea descripcionText;

    @Override
    public void start(Stage primaryStage) throws Exception {

        nombreText = new TextField();
        nombreText.setPromptText("Nombre del alumno");

        apellidoText = new TextField();
        apellidoText.setPromptText("Apellidos del alumno");

        dniText = new TextField();
        dniText.setPromptText("DNI del Alumno");

        fechaNacPicker = new DatePicker();
        fechaNacPicker.setPromptText("Fecha de nacimiento");

        edadLabel = new Label("XXX");
        edadLabel.setMinWidth(Region.USE_PREF_SIZE); // no se puede encoger el label

        ibanText = new TextField[6];
        for (int i = 0; i < ibanText.length; i++) {
            ibanText[i]= new TextField();
            ibanText[i].setPrefColumnCount(4);
        }

        hombreRadio = new RadioButton("Hombre");
        mujerRadio = new RadioButton("Mujer");

        ToggleGroup sexoGroup =new ToggleGroup();
        sexoGroup.getToggles().addAll(hombreRadio,mujerRadio);
        sexoGroup.selectedToggleProperty().addListener((o,ov,nv) -> {
            RadioButton seleccionado = (RadioButton) nv;
            System.out.println(seleccionado.getText());
                
            });

            descripcionText = new TextArea();

        GridPane formPane = new GridPane();
        formPane.setGridLinesVisible(true);
        formPane.setHgap(5);
        formPane.setVgap(5);
        formPane.setPadding(new Insets(5));
        formPane.addRow(0, new Label("Nombre:"), nombreText);
        formPane.addRow(1, new Label("Apellidos:"), apellidoText);
        formPane.addRow(2, new Label("DNI:"), dniText);
        formPane.addRow(3, new Label("Fecha de nacimiento"), fechaNacPicker);
        formPane.addRow(4, new Label("IBAN"),new HBox(5,ibanText));
        formPane.addRow(5, new Label("Sexo"),new HBox(5,hombreRadio,mujerRadio));
        formPane.addRow(6, new Label("Descripción:"), descripcionText);

        ColumnConstraints [] cols = {
            new ColumnConstraints(),
            new ColumnConstraints()
        };

        formPane.getColumnConstraints().setAll(cols);

        RowConstraints[] rows = {
            new RowConstraints(),
            new RowConstraints(),
            new RowConstraints(),
            new RowConstraints(),
            new RowConstraints(),
            new RowConstraints(),
            new RowConstraints()
        };
        formPane.getRowConstraints().setAll(rows);

        //restricciones de la columna 0 (1º columna)
        cols[0].setHalignment(HPos.RIGHT);


        //restricciones para columna 1 (2º columna)

        cols[1].setHgrow(Priority.ALWAYS);

        //restricciones para columna 6 (7º fila)

        rows[6].setVgrow(Priority.ALWAYS);

        //Resricciones

        GridPane.setFillWidth(dniText,false);
        GridPane.setColumnSpan(nombreText,2);
        GridPane.setColumnSpan(apellidoText, 2);
        GridPane.setColumnSpan(descripcionText, 2);
        
        

        //panel inferior

        CheckBox gridLinesCheck = new CheckBox("Mostrar cuadrícula");
        formPane.gridLinesVisibleProperty().bind(gridLinesCheck.selectedProperty());

        //Panel raiz

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));
        root.setCenter(formPane);
        root.setBottom(gridLinesCheck);

        //creamos escena y configuramos ventana

        Scene scene = new Scene(formPane,640,480);

        primaryStage.setTitle("GridPane Sample");
        primaryStage.setScene(scene);
        primaryStage.show();

        //bindeos

        edadLabel.textProperty().bind(edad.asString().concat(" años"));

        fechaNac.bind(fechaNacPicker.valueProperty());
        fechaNac.addListener((o, ov, nv) -> onFechaNacChanged(o,ov,nv));

        edad.addListener((o,ov,nv) -> System.out.println("El alumno tiene"));
    }

    private void onFechaNacChanged(ObservableValue<? extends LocalDate> o, LocalDate ov, LocalDate nv) {
        LocalDate fechaNacimiento = nv;
        LocalDate hoy = LocalDate.now();
        int year = Period.between(fechaNacimiento, hoy).getYears();
        edad.set(year);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
