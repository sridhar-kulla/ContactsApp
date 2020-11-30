package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<Contact> contacts= new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Contacts Application");

        BorderPane pane= new BorderPane();
        TilePane center = new TilePane(Orientation.VERTICAL);
        BorderPane input = new BorderPane();
        GridPane fields = new GridPane();
        HBox buttons = new HBox();
        VBox vButtons=new VBox();

        Label lblName = new Label("Name: ");
        Label lblNumber = new Label("Number: ");
        Label lblEmail = new Label("Email: ");

        TextField txtName = new TextField();
        TextField txtNumber = new TextField();
        TextField txtEmail = new TextField();

        Button btnSave = new Button("Save");
        btnSave.setOnAction(actionEvent -> addContact(txtName.getText(),txtNumber.getText(),txtEmail.getText()));
        Button btnUpdate = new Button("Update");
        Button btnDelete = new Button("Delete");
        Button btnNext = new Button("Next");
        btnNext.setOnAction(actionEvent ->{
            txtName.setText(contacts.get(0).getName());
            txtNumber.setText(String.valueOf(contacts.get(0).getNumber()));
            txtEmail.setText(contacts.get(0).getEmail());});

        Button btnPrevious = new Button("Previous");

        fields.setPadding(new Insets(10));
        fields.setVgap(4);
        fields.setHgap(4);
        fields.add(lblName,0,0,1,1);
        fields.add(lblNumber, 0,1,1,1);
        fields.add(lblEmail, 0,3,1,1);
        fields.add(txtName, 1,0,3,1);
        fields.add(txtNumber, 1,1,3,1);
        fields.add(txtEmail, 1,3,3,1);

        input.setTop(fields);
        input.setRight(btnNext);
        pane.setCenter(input);


        pane.setTop(new Label("Contact"));
        buttons.setPadding(new Insets(5));
        vButtons.setPadding(new Insets(5));
        buttons.setSpacing(5);
        vButtons.setSpacing(10);
        buttons.getChildren().add(btnSave);
        buttons.getChildren().add(btnUpdate);
        buttons.getChildren().add(btnDelete);
        vButtons.getChildren().add(btnNext);
        vButtons.getChildren().add(btnPrevious);

        pane.setBottom(buttons);
        pane.setRight(vButtons);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void nextContact() {
    }

    private void addContact(String text, String txtNumberText, String txtEmailText) {

      contacts.add(new Contact(text,Long.parseLong(txtNumberText),txtEmailText));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
