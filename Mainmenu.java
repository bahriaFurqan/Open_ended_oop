package task.lab_assighment13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Mainmenu {

    @FXML
    private Button View_items;

    @FXML
    private Button add_items;

public void initialize() {
    add_items.setOnAction(this::ADD_handlers);
    View_items.setOnAction(this::view_handler);
    }
    @FXML
    void ADD_handlers(ActionEvent event) {
        try {
            // Load the specified FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_items.fxml"));
            Parent pageParent = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded FXML
            Scene pageScene = new Scene(pageParent);

            // Set the new scene on the stage
            stage.setScene(pageScene);

            // Show the stage (optional, as setting the scene may implicitly show it)
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
@FXML
    void view_handler(ActionEvent event) {
        try {
            // Load the specified FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view_items.fxml"));
            Parent pageParent = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded FXML
            Scene pageScene = new Scene(pageParent);

            // Set the new scene on the stage
            stage.setScene(pageScene);

            // Show the stage (optional, as setting the scene may implicitly show it)
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}