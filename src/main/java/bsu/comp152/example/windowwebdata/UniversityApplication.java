package bsu.comp152.example.windowwebdata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class UniversityApplication extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(UniversityApplication.class.getResource("main.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        }
        catch(IOException e){
            System.out.println("Error loading FXML or exception in the controller class");
        }
        stage.setTitle("Showing University Data");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}