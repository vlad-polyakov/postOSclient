package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.UI;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main extends Application {
    private UI ui = new UI();
    @Override
    public void start(Stage primaryStage) throws Exception{

        Stage stage = new Stage();
        stage.setTitle("HTTP client");
        Scene scene = new Scene(ui.createUI(), 950, 900);
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}


