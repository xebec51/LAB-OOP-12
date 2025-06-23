package program_javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import program_javafx.model.User;

public class RegisterScene {
    private Scene scene;
    private TextField nickNameField, fullNameField, bioField;
    private String selectedImagePath;
    private ImageView profileImageView;
    private Label imageLabel;

    public RegisterScene(Stage primaryStage) {
        createScene(primaryStage);
    }

    private void createScene(Stage primaryStage) {
        VBox mainContainer = new VBox(15);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(25));
        mainContainer.setStyle(
            "-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #E0F7FA, #B2EBF2);"
        );

        Label titleLabel = new Label("Create Your Account");
        titleLabel.setStyle(
            "-fx-font-family: 'Segoe UI', sans-serif; " +
            "-fx-font-size: 32px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #00796B;"
        );
        titleLabel.setEffect(new DropShadow(5, Color.rgb(0, 0, 0, 0.1)));

        VBox formContainer = new VBox(15);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setPadding(new Insets(30));
        formContainer.setMaxWidth(350);
        formContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.9); " +
            "-fx-background-radius: 20; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 10);"
        );

        nickNameField = createStyledTextField("Your Nickname");
        fullNameField = createStyledTextField("Your Full Name");
        bioField = createStyledTextField("A little about yourself");

        VBox imageSection = new VBox(15);
        imageSection.setAlignment(Pos.CENTER);

        double radius = 80;
        profileImageView = new ImageView();
        profileImageView.setFitWidth(radius * 2);
        profileImageView.setFitHeight(radius * 2);
        profileImageView.setPreserveRatio(false);

        Circle clip = new Circle(radius);
        clip.setCenterX(radius);
        clip.setCenterY(radius);
        profileImageView.setClip(clip);

        StackPane profileWrapper = new StackPane(profileImageView);
        profileWrapper.setPrefSize(radius * 2, radius * 2);
     
        profileWrapper.setMaxSize(radius * 2, radius * 2);
        profileWrapper.setStyle(
            "-fx-background-color: #E0F7FA; " +
            "-fx-background-radius: " + radius + "; " +
            "-fx-border-radius: " + radius + "; " +
            "-fx-border-color: #80DEEA; " + 
            "-fx-border-width: 3px;"
        );
        profileWrapper.setEffect(new DropShadow(5, Color.rgb(0, 0, 0, 0.1)));

        Button uploadButton = createStyledButton("Choose Profile Picture", "#26C6DA", "#00BCD4");

        imageLabel = new Label("No image selected");
        imageLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #00796B;");

        uploadButton.setOnAction(e -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            selectedImagePath = selectedFile.toURI().toString();
            Image image = new Image(selectedImagePath);
            
            profileImageView.setImage(image);
            profileImageView.setPreserveRatio(true);
            profileImageView.setSmooth(true);
            profileImageView.setCache(true);

            imageLabel.setText(selectedFile.getName());
        }
    });


        Button submitButton = new Button("Register");
        submitButton.setStyle(
            "-fx-background-color: #00796B; " + 
            "-fx-text-fill: white; -fx-padding: 15 40; -fx-font-size: 18px; " +
            "-fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold;"
        );
        submitButton.setOnMouseEntered(e -> submitButton.setStyle(
            "-fx-background-color: #009688; " + 
            "-fx-text-fill: white; -fx-padding: 15 40; -fx-font-size: 18px; " +
            "-fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold;"
        ));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(
            "-fx-background-color: #00796B; " +
            "-fx-text-fill: white; -fx-padding: 15 40; -fx-font-size: 18px; " +
            "-fx-border-radius: 25; -fx-background-radius: 25; -fx-font-weight: bold;"
        ));

        submitButton.setOnAction(e -> {
            if (validateInput()) {
                User user = new User(nickNameField.getText(), fullNameField.getText(), bioField.getText(), selectedImagePath);
                HomeScene homeScene = new HomeScene(primaryStage, user);
                primaryStage.setScene(homeScene.getScene());
                primaryStage.setTitle("MyMoment - Welcome!");
            }
        });

        imageSection.getChildren().addAll(profileWrapper, uploadButton, imageLabel);
        formContainer.getChildren().addAll(
            createLabel("Nickname"), nickNameField,
            createLabel("Full Name"), fullNameField,
            createLabel("Bio"), bioField,
            imageSection,
            new VBox(20, submitButton) {{ setAlignment(Pos.CENTER); }}
        );
        mainContainer.getChildren().addAll(titleLabel, formContainer);

        scene = new Scene(mainContainer, 800, 650);
    }
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle(
            "-fx-font-family: 'Segoe UI', sans-serif; " +
            "-fx-font-weight: bold; " +
            "-fx-font-size: 16px; " +
            "-fx-text-fill: #009688;" 
        );
        return label;
    }

    private TextField createStyledTextField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setStyle(
            "-fx-padding: 12; " +
            "-fx-border-color: #B2EBF2; " + 
            "-fx-border-width: 2; " +
            "-fx-border-radius: 10; " +
            "-fx-background-radius: 10; " +
            "-fx-font-size: 14px; " +
            "-fx-background-color: #F1FEFF;" 
        );
        textField.setPrefWidth(400);
        return textField;
    }

    private Button createStyledButton(String text, String baseColor, String hoverColor) {
        Button button = new Button(text);
        String style = String.format(
            "-fx-background-color: %s; -fx-text-fill: white; -fx-padding: 12 25; " +
            "-fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-font-weight: bold;",
            baseColor
        );
        String hoverStyle = String.format(
            "-fx-background-color: %s; -fx-text-fill: white; -fx-padding: 12 25; " +
            "-fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-font-weight: bold;",
            hoverColor
        );
        button.setStyle(style);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(style));
        return button;
    }

    private boolean validateInput() {
        if (nickNameField.getText().trim().isEmpty()) {
            showAlert("Please enter a nickname.");
            return false;
        }
        if (fullNameField.getText().trim().isEmpty()) {
            showAlert("Please enter your full name.");
            return false;
        }
        if (selectedImagePath == null || selectedImagePath.isEmpty()) {
            showAlert("Please select a profile picture.");
            return false;
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(
            "-fx-background-color: #E0F7FA; " +
            "-fx-border-color: #B2EBF2; " +
            "-fx-border-width: 2px;"
        );
        dialogPane.lookup(".content.label").setStyle(
            "-fx-text-fill: #00796B; " +
            "-fx-font-size: 14px;"
        );
        dialogPane.lookup(".header-panel").setStyle("-fx-background-color: #B2EBF2;");

        alert.showAndWait();
    }
    
    public Scene getScene() {
        return scene;
    }
}