package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.UI;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        setUI();
    }

    public void setUI(){
        UI ui = new UI();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
