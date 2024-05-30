package task.lab_assighment13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class View_itemsController {
    @FXML
    private TilePane tile_pane;
    @FXML
    private Button back_page;

    @FXML
    public void initialize() {
        // Call method to display products when the controller is initialized
        displayProductsInTilePane();
        back_page.setOnAction(this::back_page_handler);
    }

    private void displayProductsInTilePane() {
        tile_pane.getChildren().clear();

        // Retrieve products from the database and add to tilePane
        List<Product> products = getProductsFromDatabase();
        if (products.isEmpty()) {
            System.out.println("No products found in the database.");
        } else {
            for (Product product : products) {
                VBox productBox = new VBox();
                productBox.setAlignment(Pos.CENTER);
                productBox.setSpacing(5);

                Label nameLabel = new Label(product.getName());
                Label priceLabel = new Label(String.format("$%.2f", product.getPrice()));

                ImageView imageView = new ImageView();
                if (product.getImagelink() != null) {
                    try {
                        imageView.setImage(new Image(product.getImagelink()));
                    } catch (Exception e) {
                        System.out.println("Error loading image: " + e.getMessage());
                    }
                }
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);

                productBox.getChildren().addAll(imageView, nameLabel, priceLabel);
                tile_pane.getChildren().add(productBox);
            }
        }
    }

    private List<Product> getProductsFromDatabase() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, product_name, price, link FROM products";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                String imagelink = rs.getString("link");

                products.add(new Product(id, name, price, imagelink));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @FXML
    void back_page_handler(ActionEvent event) {
        try {
            // Load the specified FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
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
