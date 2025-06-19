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
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import program_javafx.model.Post;
import program_javafx.model.User;

public class HomeScene {
    private Scene scene;
    private ImageView profileImageView;
    private User currentUser;
    private List<Post> posts;
    private GridPane postsContainer;

    public HomeScene(Stage primaryStage, User user) {
        this.currentUser = user;
        this.posts = new ArrayList<>();
        createScene(primaryStage);
    }

    private void createScene(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #E0F7FA, #B2EBF2);");

        VBox header = createHeader(primaryStage);
        mainLayout.setTop(header);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        postsContainer = new GridPane();
        postsContainer.setHgap(25);
        postsContainer.setVgap(25);
        postsContainer.setPadding(new Insets(30));
        postsContainer.setAlignment(Pos.CENTER);

        scrollPane.setContent(postsContainer);
        mainLayout.setCenter(scrollPane);

        scene = new Scene(mainLayout, 800, 600);
    }

    private VBox createHeader(Stage primaryStage) {
        VBox header = new VBox();
        header.setPadding(new Insets(15, 30, 15, 30));
        header.setStyle(
            "-fx-background-color: white; " +
            "-fx-border-color: #B2EBF2; " +
            "-fx-border-width: 0 0 2 0;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);"
        );

        HBox userInfo = new HBox(20);
        userInfo.setAlignment(Pos.CENTER_LEFT);

        double radius = 50;
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

        if (currentUser.getProfileImage() != null) {
            try {
                profileImageView.setImage(new Image(currentUser.getProfileImage()));
            } catch (Exception e) {
                // Handle the exception if the image cannot be loaded
                System.err.println("Failed to load profile image: " + e.getMessage());
            }
        }

        VBox userDetails = new VBox(5);
        Label nicknameLabel = new Label(currentUser.getNickName());
        nicknameLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #00796B;");

        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #009688;");

        Label bioLabel = new Label(currentUser.getBio());
        bioLabel.setStyle("-fx-font-size: 14px; -fx-font-style: italic; -fx-text-fill: #26C6DA;");

        userDetails.getChildren().addAll(nicknameLabel, fullNameLabel, bioLabel);

        Button addPostButton = createStyledButton("Add Post", "#26C6DA", "#00BCD4");
        addPostButton.setOnAction(e -> showAddPostDialog(primaryStage));

        userInfo.getChildren().addAll(profileWrapper, userDetails);

        HBox headerContent = new HBox();
        headerContent.setAlignment(Pos.CENTER_LEFT);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        headerContent.getChildren().addAll(userInfo, spacer, addPostButton);

        header.getChildren().add(headerContent);
        return header;
    }
    private void showAddPostDialog(Stage primaryStage) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Add New Post");

        VBox dialogLayout = new VBox(20);
        dialogLayout.setPadding(new Insets(30));
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.setStyle("-fx-background-color: #E0F7FA;");

        Label titleLabel = new Label("Create New Post");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #00796B;");

        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(300);
        postImageView.setFitHeight(250);
        postImageView.setPreserveRatio(true);
        postImageView.setStyle("-fx-border-color: #80DEEA; -fx-border-width: 2; -fx-border-style: dashed; -fx-background-color: white;");

        Button selectImageButton = createStyledButton("Select Image", "#009688", "#00796B");
        Label selectedImageLabel = new Label("No image selected");
        selectedImageLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #00796B;");

        final String[] selectedImagePath = {null};

        selectImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Post Image");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(dialog);
            if (selectedFile != null) {
                selectedImagePath[0] = selectedFile.toURI().toString();
                try {
                    postImageView.setImage(new Image(selectedImagePath[0]));
                } catch (Exception ex) {
                    System.err.println("Failed to load selected image: " + ex.getMessage());
                    showAlert("Error", "Could not load the selected image.");
                    selectedImagePath[0] = null; // Reset if loading fails
                }
                selectedImageLabel.setText(selectedFile.getName());
            }
        });

        VBox imageSection = new VBox(10, postImageView, selectImageButton, selectedImageLabel);
        imageSection.setAlignment(Pos.CENTER);
        
        Label captionLabel = new Label("Caption:");
        captionLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #00796B;");

        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Write a caption...");
        captionArea.setPrefRowCount(3);
        captionArea.setStyle(
            "-fx-border-color: #B2EBF2; -fx-border-width: 2; -fx-border-radius: 10; " +
            "-fx-background-radius: 10; -fx-font-size: 14px; -fx-background-color: white;"
        );

        Button postButton = createStyledButton("Post", "#00796B", "#00695C");
        Button cancelButton = createStyledButton("Cancel", "#9E9E9E", "#757575");
        
        HBox buttonBox = new HBox(15, postButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        postButton.setOnAction(e -> {
            if (selectedImagePath[0] != null && !captionArea.getText().trim().isEmpty()) {
                posts.add(new Post(captionArea.getText().trim(), selectedImagePath[0]));
                refreshPostsDisplay();
                dialog.close();
            } else {
                showAlert("Missing Information", "Please select an image and enter a caption.");
            }
        });
        cancelButton.setOnAction(e -> dialog.close());

        dialogLayout.getChildren().addAll(titleLabel, imageSection, captionLabel, captionArea, buttonBox);
        Scene dialogScene = new Scene(dialogLayout, 450, 550);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }
    
    private void refreshPostsDisplay() {
        postsContainer.getChildren().clear();
        for (int i = 0; i < posts.size(); i++) {
            postsContainer.add(createPostCard(posts.get(i)), i % 3, i / 3);
        }
    }

    private StackPane createPostCard(Post post) {
        StackPane postCard = new StackPane();
        postCard.setPrefSize(250, 250);
        postCard.setStyle("-fx-cursor: hand; -fx-background-radius: 15; -fx-background-color: #E0F7FA;"); // Added background color for empty areas

        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(250);
        postImageView.setFitHeight(250);
        postImageView.setPreserveRatio(false); // Set to false to fill the area, then use clip for rounded corners

        // Create a rounded rectangle clip for the ImageView
        javafx.scene.shape.Rectangle clipRect = new javafx.scene.shape.Rectangle(250, 250);
        clipRect.setArcWidth(15);
        clipRect.setArcHeight(15);
        postImageView.setClip(clipRect);
        
        try {
            Image image = new Image(post.getPostImage());
            if (image.isError()) {
                throw new Exception("Image loading error: " + image.exceptionProperty().get().getMessage());
            }
            postImageView.setImage(image);
        } catch (Exception e) {
            System.err.println("Failed to load post image for card: " + e.getMessage());
            // Optionally, set a placeholder image or style if image fails to load
            postImageView.setStyle("-fx-background-color: #CCCCCC;"); // Gray placeholder
        }

        Label captionOverlay = new Label(post.getCaption());
        captionOverlay.setStyle(
            "-fx-background-color: rgba(0, 121, 107, 0.8); -fx-text-fill: white; " +
            "-fx-padding: 15; -fx-font-size: 14px; -fx-wrap-text: true; -fx-alignment: center;"
        );
        captionOverlay.setMaxWidth(250);
        captionOverlay.setMaxHeight(250);
        captionOverlay.setVisible(false);

        postCard.getChildren().addAll(postImageView, captionOverlay);

        postCard.setOnMouseEntered(e -> {
            postCard.setScaleX(1.05);
            postCard.setScaleY(1.05);
            captionOverlay.setVisible(true);
            postImageView.setEffect(new DropShadow(20, Color.BLACK));
        });
        postCard.setOnMouseExited(e -> {
            postCard.setScaleX(1.0);
            postCard.setScaleY(1.0);
            captionOverlay.setVisible(false);
            postImageView.setEffect(null);
        });
        postCard.setOnMouseClicked(e -> showPostDetailDialog(post));
        
        return postCard;
    }

    private void showPostDetailDialog(Post post) {
        Stage detailStage = new Stage();
        detailStage.initModality(Modality.APPLICATION_MODAL);
        detailStage.setTitle("Post Detail");

        VBox detailLayout = new VBox(20);
        detailLayout.setPadding(new Insets(20));
        detailLayout.setAlignment(Pos.CENTER);
        detailLayout.setStyle("-fx-background-color: rgba(0,0,0,0.7);");

        ImageView detailImageView = new ImageView();
        detailImageView.setPreserveRatio(true);
        detailImageView.setSmooth(true);

        try {
            Image postImage = new Image(post.getPostImage());
            if (postImage.isError()) {
                throw new Exception("Image loading error: " + postImage.exceptionProperty().get().getMessage());
            }
            detailImageView.setImage(postImage);
            double maxSize = Screen.getPrimary().getVisualBounds().getHeight() * 0.7;
            detailImageView.setFitHeight(Math.min(postImage.getHeight(), maxSize));
        } catch (Exception e) {
            System.err.println("Failed to load image for detail dialog: " + e.getMessage());
            // Optionally set a placeholder image or text
            Label errorLabel = new Label("Could not load image.");
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 18px;");
            detailLayout.getChildren().add(0, errorLabel); // Add error message at the top
        }

        Label captionLabel = new Label(post.getCaption());
        captionLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-padding: 10; -fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 10;");
        captionLabel.setWrapText(true);
        captionLabel.setMaxWidth(detailImageView.getFitWidth()); // Ensure caption respects image width
        
        Button closeButton = createStyledButton("Close", "#26C6DA", "#00BCD4");
        closeButton.setOnAction(e -> detailStage.close());

        detailLayout.getChildren().addAll(detailImageView, captionLabel, closeButton);

        Scene detailScene = new Scene(detailLayout);
        detailScene.setFill(Color.TRANSPARENT);
        detailStage.setScene(detailScene);
        detailStage.showAndWait();
    }
    
    private Button createStyledButton(String text, String baseColor, String hoverColor) {
        Button button = new Button(text);
        String style = String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-padding: 10 25; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-font-weight: bold;", baseColor);
        String hoverStyle = String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-padding: 10 25; -fx-font-size: 14px; -fx-border-radius: 20; -fx-background-radius: 20; -fx-font-weight: bold;", hoverColor);
        button.setStyle(style);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(style));
        return button;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #E0F7FA; -fx-border-color: #B2EBF2; -fx-border-width: 2px;");
        dialogPane.lookup(".content.label").setStyle("-fx-text-fill: #00796B; -fx-font-size: 14px;");
        dialogPane.lookup(".header-panel").setStyle("-fx-background-color: #B2EBF2;");
        alert.showAndWait();
    }

    public Scene getScene() {
        return scene;
    }
}