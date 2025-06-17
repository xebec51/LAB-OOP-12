import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.stage.Modality;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class MyMomentApp extends Application {

    private Stage primaryStage;
    private User currentUser;
    private List<Post> posts = new ArrayList<>();
    private FlowPane postsContainer;
    private ScrollPane scrollPane;
    private StackPane rootPane;

    private ImageView profileImageViewRegister = new ImageView();
    private File selectedProfileImageFile;

    private static final double ASPECT_RATIO = 2.0 / 3.0;
    private double currentUploadRotation = 0;

    private final String cardStyle = "-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-radius: 8; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);";
    private final String titleStyle = "-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #333333;";
    private final String headerStyle = "-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10; -fx-background-color: #E9ECEF; -fx-text-fill: #333;";
    private final String subTitleStyle = "-fx-font-size: 16px; -fx-text-fill: #555555;";
    private final String textFieldStyle = "-fx-padding: 8; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 4; -fx-background-radius: 4;";
    private final String buttonPrimaryStyle = "-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20; -fx-cursor: hand;";
    private final String buttonSecondaryStyle = "-fx-background-color: #6c757d; -fx-text-fill: white; -fx-padding: 8 15; -fx-cursor: hand;";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Image appIcon = new Image(getClass().getResourceAsStream("logo.png"));
        primaryStage.getIcons().add(appIcon);
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MOMENT V1.0");

        rootPane = new StackPane();

        VBox startScreen = createStartScreen();
        VBox registerScreen = createRegisterScreen();
        BorderPane homeScreen = createHomeScene();

        startScreen.setVisible(true);
        registerScreen.setVisible(false);
        homeScreen.setVisible(false);

        rootPane.getChildren().addAll(startScreen, registerScreen, homeScreen);

        Scene scene = new Scene(rootPane, 650, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void switchScreen(Node screenToShow) {
        for (Node screen : rootPane.getChildren()) {
            screen.setVisible(false);
        }
        screenToShow.setVisible(true);
        if (screenToShow instanceof BorderPane && ((BorderPane) screenToShow).getCenter() == scrollPane) {
             updatePostsDisplay();
             javafx.application.Platform.runLater(() -> resizeImages(scrollPane.getWidth()));
        }
    }

    private VBox createStartScreen() {
        ImageView logoView = new ImageView();
        Image logoImage = loadLogoImage(); 

        Node displayElement; 

        if (logoImage != null) {
            logoView.setImage(logoImage);
            logoView.setPreserveRatio(true);
            logoView.setFitWidth(400); 
            displayElement = logoView; // Gunakan logo jika berhasil dimuat
        } else {
            Label titleLabel = new Label("MyMoment");
            titleLabel.setStyle(titleStyle);
            Label nameLabel = new Label("Bagikan Momen Indahmu!");
            nameLabel.setStyle(subTitleStyle);
            VBox textLogo = new VBox(5, titleLabel, nameLabel);
            textLogo.setAlignment(Pos.CENTER);
            displayElement = textLogo; 
            showAlert("Peringatan", "File 'logo.png' tidak ditemukan. Pastikan file logo ada di direktori yang benar.");
        }

        Button startButton = new Button("MULAI SEKARANG ✨");
        startButton.setStyle(buttonPrimaryStyle);
        startButton.setOnAction(e -> switchScreen(rootPane.getChildren().get(1)));

        // Menggunakan displayElement (logo atau teks)
        VBox startScreenLayout = new VBox(-30, displayElement, startButton); // Spasi antara logo/teks dan tombol
        startScreenLayout.setAlignment(Pos.CENTER);
        startScreenLayout.setStyle("-fx-background-color: #F8F9FA; -fx-padding: 50;");
        startScreenLayout.setPrefSize(650, 750);

        return startScreenLayout;
    }
 
    // Metode untuk memuat gambar logo
    private Image loadLogoImage() {
        String logoFilename = "logo.png"; 
        try {
            // Coba muat dari resources (jika Anda pakai Maven/Gradle)
            InputStream stream = getClass().getResourceAsStream("/" + logoFilename);
            if (stream != null) {
                System.out.println("Logo loaded from resources.");
                return new Image(stream);
            } else {
                // Jika tidak ada di resources, coba muat dari file system (root directory)
                File logoFile = new File(logoFilename);
                if (logoFile.exists()) {
                    System.out.println("Logo loaded from file system.");
                    return new Image(new FileInputStream(logoFile));
                } else {
                   System.err.println("Logo image '" + logoFilename + "' not found!");
                   return null; 
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading logo image: " + e.getMessage());
            return null; // Kembalikan null jika ada error
        }
    }


    // Membuat Layar Register
    private VBox createRegisterScreen() {
        VBox registerLayout = new VBox(25);
        registerLayout.setPadding(new Insets(30));
        registerLayout.setAlignment(Pos.TOP_CENTER);
        registerLayout.setStyle("-fx-background-color: #F5F5F5;");
        registerLayout.setPrefSize(650, 750);

        Label headerLabel = new Label("SIGN UP");
        headerLabel.setStyle(headerStyle + " -fx-alignment: center; -fx-min-width: 580;");
        headerLabel.setAlignment(Pos.CENTER);

        VBox inputCard = new VBox(18);
        inputCard.setStyle(cardStyle);
        inputCard.setAlignment(Pos.CENTER);
        inputCard.setMaxWidth(450);

        Label titleLabel = new Label("MyMoment");
        titleLabel.setFont(new Font("Arial", 24));

        TextField nickNameField = new TextField();
        nickNameField.setPromptText("Input User Account (Nick Name)");
        nickNameField.setStyle(textFieldStyle);
        nickNameField.setMaxWidth(300);

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");
        fullNameField.setStyle(textFieldStyle);
        fullNameField.setMaxWidth(300);

        Button uploadProfileButton = new Button("Upload Foto Profil 🖼️");
        uploadProfileButton.setStyle(buttonSecondaryStyle);
        profileImageViewRegister.setFitHeight(100);
        profileImageViewRegister.setFitWidth(100);
        Circle clip = new Circle(50, 50, 50);
        profileImageViewRegister.setClip(clip);
        profileImageViewRegister.setImage(loadPlaceholderImage());

        uploadProfileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Profil");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            selectedProfileImageFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedProfileImageFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedProfileImageFile));
                    profileImageViewRegister.setImage(image);
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "File tidak ditemukan.");
                }
            }
        });

        inputCard.getChildren().addAll(
                titleLabel,
                nickNameField,
                fullNameField,
                uploadProfileButton,
                profileImageViewRegister
        );

        Button submitButton = new Button("SUBMIT & MASUK ➡️");
        submitButton.setStyle(buttonPrimaryStyle);
        submitButton.setMaxWidth(450);
        submitButton.setOnAction(e -> {
            String nickName = nickNameField.getText();
            String fullName = fullNameField.getText();

            if (nickName.isEmpty() || fullName.isEmpty() || selectedProfileImageFile == null) {
                showAlert("Input Error", "Mohon isi semua field dan upload foto profil.");
                return;
            }

            try {
                Image profileImage = new Image(new FileInputStream(selectedProfileImageFile));
                currentUser = new User(nickName, fullName, profileImage);
                BorderPane home = (BorderPane) rootPane.getChildren().get(2);
                HBox topBar = (HBox) home.getTop();
                ImageView profileView = (ImageView) topBar.getChildren().get(0);
                profileView.setImage(currentUser.getProfileImage());
                VBox userInfo = (VBox) topBar.getChildren().get(1);
                ((Label)userInfo.getChildren().get(0)).setText(currentUser.getNickName());
                ((Label)userInfo.getChildren().get(1)).setText(currentUser.getFullName());

                switchScreen(rootPane.getChildren().get(2));
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat foto profil.");
            }
        });

        registerLayout.getChildren().addAll(headerLabel, inputCard, submitButton);

        return registerLayout;
    }

    // Membuat Home Screen (Tidak ada perubahan)
    private BorderPane createHomeScene() {
        BorderPane homeLayout = new BorderPane();
        homeLayout.setPadding(new Insets(20));
        homeLayout.setStyle("-fx-background-color: #FFFFFF;");
        homeLayout.setPrefSize(650, 750);

        HBox topBar = new HBox(20);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #F8F9FA; -fx-border-color: #DEE2E6; -fx-border-width: 0 0 1 0;");

        Image initialImage = (currentUser != null) ? currentUser.getProfileImage() : loadPlaceholderImage();
        ImageView profileImageViewHome = new ImageView(initialImage);
        profileImageViewHome.setFitHeight(60);
        profileImageViewHome.setFitWidth(60);
        Circle clip = new Circle(30, 30, 30);
        profileImageViewHome.setClip(clip);

        VBox userInfo = new VBox(5);
        String initialNick = (currentUser != null) ? currentUser.getNickName() : "User";
        String initialFull = (currentUser != null) ? currentUser.getFullName() : "Nama Lengkap";
        Label nickNameLabel = new Label(initialNick);
        nickNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Label fullNameLabel = new Label(initialFull);
        fullNameLabel.setStyle("-fx-font-size: 14px;");
        userInfo.getChildren().addAll(nickNameLabel, fullNameLabel);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button addPostButton = new Button("➕ Add Post");
        addPostButton.setStyle(buttonPrimaryStyle);
        addPostButton.setOnAction(e -> showUploadPostWindow());

        topBar.getChildren().addAll(profileImageViewHome, userInfo, spacer, addPostButton);
        homeLayout.setTop(topBar);

        postsContainer = new FlowPane(15, 15);
        postsContainer.setPadding(new Insets(20));
        postsContainer.setAlignment(Pos.TOP_LEFT);
        postsContainer.setStyle("-fx-background-color: #F5F5F5;");

        scrollPane = new ScrollPane(postsContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
        homeLayout.setCenter(scrollPane);

        scrollPane.widthProperty().addListener((obs, oldVal, newVal) -> resizeImages(newVal.doubleValue()));

        return homeLayout;
    }


    // --- Helper Methods (Load Placeholder) ---

    private Image loadPlaceholderImage() {
        try {
            InputStream stream = getClass().getResourceAsStream("/aplaceholder.png");
            if (stream != null) {
                return new Image(stream);
            } else {
                File placeholderFile = new File("aplaceholder.png");
                if (placeholderFile.exists()) {
                    return new Image(new FileInputStream(placeholderFile));
                } else {
                   System.err.println("Placeholder image not found!");
                   return null;
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading placeholder image: " + e.getMessage());
            return null;
        }
    }


    // Window buat Upload Post 
    private void showUploadPostWindow() {
        currentUploadRotation = 0;

        Stage uploadStage = new Stage();
        uploadStage.initModality(Modality.APPLICATION_MODAL);
        uploadStage.initOwner(primaryStage);
        uploadStage.setTitle("Upload Postingan Baru");

        VBox uploadLayout = new VBox(20);
        uploadLayout.setPadding(new Insets(30));
        uploadLayout.setAlignment(Pos.CENTER);
        uploadLayout.setStyle("-fx-background-color: #F8F9FA;");

        VBox uploadCard = new VBox(15);
        uploadCard.setStyle(cardStyle);
        uploadCard.setAlignment(Pos.CENTER);
        uploadCard.setPadding(new Insets(25));

        ImageView postImageView = new ImageView();
        postImageView.setFitHeight(200);
        postImageView.setFitWidth(200);
        postImageView.setPreserveRatio(true);
        postImageView.setImage(loadPlaceholderImage());
        postImageView.setStyle("-fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-background-color: #E0E0E0;");
        postImageView.setRotate(currentUploadRotation);

        final File[] selectedPostImageFile = {null};

        Button uploadImageButton = new Button("Pilih Gambar...");
        uploadImageButton.setStyle(buttonSecondaryStyle);
        uploadImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Gambar Postingan");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );



            
            selectedPostImageFile[0] = fileChooser.showOpenDialog(uploadStage);
            if (selectedPostImageFile[0] != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedPostImageFile[0]));
                    postImageView.setImage(image);
                    currentUploadRotation = 0;
                    postImageView.setRotate(currentUploadRotation);
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "File tidak ditemukan.");
                }
            }
        });

        Button rotateButton = new Button("Putar 🔄");
        rotateButton.setStyle(buttonSecondaryStyle + " -fx-font-size: 12px;");
        rotateButton.setOnAction(e -> {
            currentUploadRotation = (currentUploadRotation + 90) % 360;
            postImageView.setRotate(currentUploadRotation);
        });

        HBox imageControls = new HBox(15, uploadImageButton, rotateButton);
        imageControls.setAlignment(Pos.CENTER);

        TextField captionField = new TextField();
        captionField.setPromptText("Tulis Caption Anda...");
        captionField.setStyle(textFieldStyle);
        captionField.setMaxWidth(300);

        Button submitPostButton = new Button("SUBMIT POST ✔️");
        submitPostButton.setStyle(buttonPrimaryStyle);
        submitPostButton.setOnAction(e -> {
            String caption = captionField.getText();
            if (selectedPostImageFile[0] == null) {
                showAlert("Input Error", "Mohon upload gambar postingan.");
                return;
            }

            try {
                Image originalImage = new Image(new FileInputStream(selectedPostImageFile[0]));
                Image imageToPost = originalImage;

                if (currentUploadRotation != 0) {
                    ImageView tempView = new ImageView(originalImage);
                    tempView.setRotate(currentUploadRotation);
                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    Group tempGroup = new Group(tempView);
                    imageToPost = tempGroup.snapshot(params, null);
                }

                posts.add(new Post(caption, imageToPost));
                updatePostsDisplay();
                resizeImages(scrollPane.getWidth());
                uploadStage.close();
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat gambar postingan.");
            }
        });

        uploadCard.getChildren().addAll(postImageView, imageControls, captionField, submitPostButton);
        uploadLayout.getChildren().add(uploadCard);

        Scene uploadScene = new Scene(uploadLayout, 450, 550);
        uploadStage.setScene(uploadScene);
        uploadStage.showAndWait();
    }


    // resizeImages
    private void resizeImages(double containerWidth) {
        if (postsContainer == null || containerWidth <= 0) return;

        double padding = postsContainer.getPadding().getLeft() + postsContainer.getPadding().getRight();
        double hgap = postsContainer.getHgap();
        double effectiveWidth = containerWidth - padding - 20;

        int columns = 3;
        double newWidth = (effectiveWidth - (columns - 1) * hgap) / columns;

        if (newWidth <= 10) {
            newWidth = 150;
             columns = (int) ((effectiveWidth + hgap) / (newWidth + hgap));
             if (columns < 1) columns = 1;
             newWidth = (effectiveWidth - (columns - 1) * hgap) / columns;
        }

        double newHeight = newWidth / ASPECT_RATIO;

        for (Node node : postsContainer.getChildren()) {
            if (node instanceof StackPane) {
                StackPane pane = (StackPane) node;
                ImageView imageView = null;

                for(Node child : pane.getChildren()){
                    if(child instanceof ImageView){
                        imageView = (ImageView) child;
                        break;
                    }
                }

                if (imageView == null) continue;

                Post post = (Post) pane.getUserData();
                Image image = post.getPostImage();
                if (image == null) continue;

                pane.setPrefSize(newWidth, newHeight);
                pane.setMinSize(newWidth, newHeight);
                pane.setMaxSize(newWidth, newHeight);

                Rectangle clip = new Rectangle(newWidth, newHeight);
                pane.setClip(clip);

                imageView.setPreserveRatio(true);
                imageView.setViewport(null);
                imageView.setFitWidth(0);
                imageView.setFitHeight(0);

                double imgWidth = image.getWidth();
                double imgHeight = image.getHeight();

                if (imgWidth <= 0 || imgHeight <= 0) continue;

                double imgRatio = imgWidth / imgHeight;
                double targetRatio = newWidth / newHeight;

                if (imgRatio > targetRatio) {
                    imageView.setFitHeight(newHeight);
                } else {
                    imageView.setFitWidth(newWidth);
                }

                 for(Node child : pane.getChildren()){
                    if (child.getStyleClass().contains("overlay-pane")) {
                        ((StackPane) child).setPrefSize(newWidth, newHeight);
                        break;
                    }
                }
            }
        }
    }


    // update lama postt
    private void updatePostsDisplay() {
        if (postsContainer == null) return;

        postsContainer.getChildren().clear();
        if (posts.isEmpty()) {
            Label noPostsLabel = new Label("Your magical MOMENT Starts Here!");
            noPostsLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #888;");
            postsContainer.getChildren().add(noPostsLabel);
            return;
        }

        for (Post post : posts) {
            ImageView postView = new ImageView(post.getPostImage());

            StackPane imageContainer = new StackPane();
            imageContainer.setUserData(post);
            imageContainer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 0); " +
                                  "-fx-background-color: black;");
            imageContainer.setAlignment(Pos.CENTER);

            StackPane overlayPane = new StackPane();
            overlayPane.setAlignment(Pos.CENTER);
            overlayPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
            overlayPane.setVisible(false);
            overlayPane.getStyleClass().add("overlay-pane");

            Label captionLabel = new Label(post.getCaption());
            captionLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
            captionLabel.setWrapText(true);
            captionLabel.setAlignment(Pos.CENTER);
            captionLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            captionLabel.setPadding(new Insets(10));

            overlayPane.getChildren().add(captionLabel);

            imageContainer.getChildren().addAll(postView, overlayPane);

            Duration animationDuration = Duration.millis(200);

            ScaleTransition zoomIn = new ScaleTransition(animationDuration, imageContainer);
            zoomIn.setToX(1.1);
            zoomIn.setToY(1.1);

            ScaleTransition zoomOut = new ScaleTransition(animationDuration, imageContainer);
            zoomOut.setToX(1.0);
            zoomOut.setToY(1.0);


            imageContainer.setOnMouseEntered(e -> {
                zoomIn.play();
                if (!post.getCaption().isEmpty()) {
                    overlayPane.setVisible(true);
                }
            });

            imageContainer.setOnMouseExited(e -> {
                zoomOut.play();
                overlayPane.setVisible(false);
            });

            imageContainer.setCursor(Cursor.HAND);
            imageContainer.setOnMouseClicked(e -> showPostDetailsWindow(post));

            postsContainer.getChildren().add(imageContainer);
        }
        javafx.application.Platform.runLater(() -> resizeImages(scrollPane.getWidth()));
    }


    //showPostDetailsWindow
    private void showPostDetailsWindow(Post post) {
        Stage detailStage = new Stage();
        detailStage.initModality(Modality.APPLICATION_MODAL);
        detailStage.initOwner(primaryStage);
        detailStage.setTitle("Detail Postingan");

        VBox detailLayout = new VBox(15);
        detailLayout.setPadding(new Insets(20));
        detailLayout.setAlignment(Pos.CENTER);
        detailLayout.setStyle("-fx-background-color: #FFFFFF;");

        ImageView postImageView = new ImageView(post.getPostImage());
        postImageView.setPreserveRatio(true);
        postImageView.setFitWidth(550);

        Label captionLabel = new Label(post.getCaption());
        captionLabel.setFont(new Font("Arial", 16));
        captionLabel.setWrapText(true);
        captionLabel.setMaxWidth(550);
        captionLabel.setAlignment(Pos.CENTER_LEFT);
        captionLabel.setStyle("-fx-padding: 10px 0 0 0;");

        detailLayout.getChildren().addAll(postImageView, captionLabel);

        ScrollPane detailScrollPane = new ScrollPane(detailLayout);
        detailScrollPane.setFitToWidth(true);
        detailScrollPane.setFitToHeight(true);
        detailScrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");

        Scene detailScene = new Scene(detailScrollPane, 600, 700);
        detailStage.setScene(detailScene);
        detailStage.showAndWait();
    }

    //Alerta
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Kelas User dan Post 
    public class User {
        private String nickName;
        private String fullName;
        private Image profileImage;

        public User(String nickName, String fullName, Image profileImage) {
            this.nickName = nickName;
            this.fullName = fullName;
            this.profileImage = profileImage;
        }
        public String getNickName() { return nickName; }
        public String getFullName() { return fullName; }
        public Image getProfileImage() { return profileImage; }
    }

    public class Post {
        private String caption;
        private Image postImage;

        public Post(String caption, Image postImage) {
            this.caption = caption;
            this.postImage = postImage;
        }
        public String getCaption() { return caption; }
        public Image getPostImage() { return postImage; }
    }
}