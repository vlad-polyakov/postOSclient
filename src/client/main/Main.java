package client.main;

import client.view.UI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        setUI();
        //Socket socket = new Socket("redbook.minpriroda.gov.by", 80);

        //System.out.println(socket.isConnected());
    }

    public void setUI(){
        UI ui = new UI();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
