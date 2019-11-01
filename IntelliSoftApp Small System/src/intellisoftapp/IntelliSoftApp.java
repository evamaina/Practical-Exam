/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intellisoftapp;

import java.util.UUID;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Employee;

/**
 *
 * @author gorenjaa
 */
public class IntelliSoftApp extends Application {
    public static final ObservableList<Employee>employees = 
        FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        GridPane gridPane = createRegistrationFormPane();
        ListView<Employee> listView = new ListView<>(employees);
        Tab tab1 = new Tab("Add Employee", gridPane);
        Tab tab2 = new Tab("All employees"  , listView);
       addUIControls(gridPane);
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("IntelliSoft");
        
        primaryStage.show();
    }
    
    private GridPane createRegistrationFormPane() {
 
    GridPane gridPane = new GridPane();

    gridPane.setAlignment(Pos.CENTER);

    gridPane.setPadding(new Insets(40, 40, 40, 40));

    gridPane.setHgap(10);

    gridPane.setVgap(10);

    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
    columnOneConstraints.setHalignment(HPos.RIGHT);

    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
    columnTwoConstrains.setHgrow(Priority.ALWAYS);

    gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
    
    return gridPane;
}
    
    private void addUIControls(GridPane gridPane) {
    Label headerLabel = new Label("Employee Registration Form");
    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    gridPane.add(headerLabel, 0,0,2,1);
    GridPane.setHalignment(headerLabel, HPos.CENTER);
    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

    Label nameLabel = new Label("Full Name : ");
    gridPane.add(nameLabel, 0,1);

    TextField nameField = new TextField();
    nameField.setPrefHeight(40);
    gridPane.add(nameField, 1,1);

    Label dateOfBirthLabel = new Label("Date of Birth");
    gridPane.add(dateOfBirthLabel, 0, 2);

    TextField dateOfBirthField = new TextField();
    dateOfBirthField.setPrefHeight(40);
    gridPane.add(dateOfBirthField, 1, 2);

    Label addressLabel = new Label("Address : ");
    gridPane.add(addressLabel, 0, 3);
    
    TextField addressField = new TextField();
    addressField.setPrefHeight(40);
    gridPane.add(addressField, 1, 3);
    
    Label contractInfoLabel = new Label("Contract expires date : ");
    gridPane.add(contractInfoLabel, 0, 4);
    
    TextField contractInfoField = new TextField();
    contractInfoField.setPrefHeight(40);
    gridPane.add(contractInfoField, 1, 4);

    Button submitButton = new Button("Save");
    submitButton.setPrefHeight(40);
    submitButton.setDefaultButton(true);
    submitButton.setPrefWidth(100);
    gridPane.add(submitButton, 0, 5, 2, 1);
    GridPane.setHalignment(submitButton, HPos.CENTER);
    GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
    
    submitButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        if(nameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please enter employee name");
            return;
        }
        if(dateOfBirthField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Form Error!", "Please enter employee date of birth");
            return;
        }
        if(addressField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please enter employee address");
            return;
        }
        
         if(contractInfoField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
            "Registration Error!", "Please enter fill contract expiries date info");
            return;
        }
         Employee newEmployee = new Employee(nameField.getText(),
                 dateOfBirthField.getText(),addressField.getText(),
                 contractInfoField.getText(), new UUID(20, 255).toString() );
         employees.add(newEmployee);
        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), 
        "Registration Successful!", "Welcome " + nameField.getText());
    }
});
}
    
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
