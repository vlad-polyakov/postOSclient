package client.view;

import client.service.Connector;
import client.model.Header;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI {
    private Label httpReq = new Label("HTTP Request");
    private Label urlLabel = new Label("URL");
    private TextField forReq = new TextField();
    private Button request = new Button("Send");
    private Label methodsLabel = new Label("HTTP Methods");
    private Connector connector = new Connector();
    private Header headerr = new Header();

    ToggleGroup group = new ToggleGroup();
    private RadioButton get = new RadioButton("GET");
    private RadioButton post = new RadioButton("POST");
    private RadioButton head = new RadioButton("HEAD");

    private Label headerLabel = new Label("Header");
    private TextField header = new TextField();

    private Label bodyLabel = new Label("Body Request");
    private TextArea body = new TextArea();

    private Label responseLabel = new Label("HTTP Response");
    private TextArea response = new TextArea();

    private  ScrollPane scrollForBody = new ScrollPane();
    private ScrollPane scrollForResponse = new ScrollPane();

    public UI(){
        BorderPane root = new BorderPane();
       // System.out.println(connector.sendRequest("https://webgyry.info/http-zapros-metodom-get",80,"GET / HTTP/1.0"));
        connector.sendRequest("redbook.minpriroda.gov.by",80,"GET / HTTP/1.0");
        VBox bodyReq = new VBox();
        bodyReq.setSpacing(10);
        HBox urlBody = new HBox();
        urlBody.setSpacing(15);
        scrollForBody.setContent(body);
        scrollForResponse.setContent(response);
        get.setToggleGroup(group);
        post.setToggleGroup(group);
        head.setToggleGroup(group);
        request.setOnAction(event -> {
            getInfo();

        });
        urlBody.getChildren().addAll(urlLabel, forReq, request);
        bodyReq.getChildren().addAll(httpReq, urlBody, methodsLabel, get, post, head, headerLabel, header, bodyLabel, scrollForBody, responseLabel, scrollForResponse);
        root.setTop(bodyReq);
        Stage stage = new Stage();
        stage.setTitle("HTTP client");
        stage.setScene(new Scene(root, 950, 900));
        stage.show();
    }

    public void getInfo(){
        String strUrl = forReq.getText();
        String strHeader = header.getText();
        String strbody = body.getText();
        String[] arrs = concatHeader(strHeader);
        editHeaders(arrs);
    }

    public String editUrl(String url){
        String finalUrl="";

        return finalUrl;
    }

    public boolean editHeaders(String[] arr){
        for (String str: arr){
            String[] pair;
            pair = str.split(":");
            headerr.setHeader(pair[0],pair[1]);
        }
        return true;
    }

    public static String[] concatHeader(String header){
        String[] headers = header.split(";\\s");
        return headers;
    }

    public String getRequest(){
        String request="";
        return request;
    }
}
