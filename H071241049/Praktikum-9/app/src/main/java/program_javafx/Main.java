package program_javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import program_javafx.view.*;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Photo Gallery - Register");
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(500); //lebar
            primaryStage.setMinHeight(600);//tinggi
            
            RegisterScene registerScene = new RegisterScene(primaryStage);
            primaryStage.setScene(registerScene.getScene());
            
            primaryStage.centerOnScreen(); //posisikan ke tengah layar
            
            primaryStage.show(); //tampilkan ke pengguna
            
        } catch (Exception e) { //deteksi detail error
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args); //method dari application utk luncurkan javafx
    }
}