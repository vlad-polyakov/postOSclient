package client.controller;

import client.service.Connector;
import client.service.TransformURL;
import client.view.UI;

public class Controller {
    private UI ui;
    private TransformURL transformURL;
    private Connector connector;
    public Controller(UI ui){
        this.ui = ui;
    }
    public void sendRequest(String url, String method){
        connector = new Connector();
        transformURL = new TransformURL();
        String response = connector.sendRequest(transformURL.editHost(url),method);
        ui.setResponseInfo(response);
    }

}
