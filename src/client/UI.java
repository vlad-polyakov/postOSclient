package client;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI {
    private Label httpReq = new Label("HTTP Request");
    private Label urlLabel = new Label("URL");
    private TextField forReq = new TextField();
    private Button request = new Button("Send");
    private Label methodsLabel = new Label("HTTP Methods");

    ToggleGroup group = new ToggleGroup();
    private RadioButton get = new RadioButton("GET");
    private RadioButton post = new RadioButton("POST");
    private RadioButton head = new RadioButton("HEAD");

    private Label headerLabel = new Label("Header");
    private TextField header = new TextField();

    private Label bodyLabel = new Label("Body Request");
    private TextArea body = new TextArea();

    private Label protocolLabel = new Label("HTTP Protocol");
    private TextArea protocol = new TextArea();

    public UI(){
        BorderPane root = new BorderPane();
        VBox bodyReq = new VBox();
        bodyReq.setSpacing(10);
        HBox urlBody = new HBox();
        urlBody.setSpacing(15);
        ScrollPane scrollForBody = new ScrollPane();
        scrollForBody.setContent(body);
        ScrollPane scrollForProtocol = new ScrollPane();
        scrollForProtocol.setContent(protocol);
        get.setToggleGroup(group);
        post.setToggleGroup(group);
        head.setToggleGroup(group);
        urlBody.getChildren().addAll(urlLabel, forReq, request);
        bodyReq.getChildren().addAll(httpReq, urlBody, methodsLabel, get, post, head, headerLabel, header, bodyLabel, scrollForBody, protocolLabel, scrollForProtocol);
        root.setTop(bodyReq);
        Stage stage = new Stage();
        stage.setTitle("HTTP client");
        stage.setScene(new Scene(root, 950, 900));
        stage.show();
    }

}
