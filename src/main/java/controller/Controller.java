package controller;


import exception.HttpStatus;
import model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Connector;
import service.TransformURL;
import view.UI;

public class Controller {
    private UI ui;
    private TransformURL transformURL;
    private Connector connector;
    private Response response;
    private HttpStatus httpStatus;
    private Logger logger = LogManager.getLogger(Controller.class);

    public Controller(UI ui) {
        this.ui = ui;
        transformURL = new TransformURL();
    }

    public void sendRequest(String url, String method) {
        connector = new Connector();
        httpStatus = new HttpStatus();
        if (transformURL.checkHost(url)) {
            addHost(url);
            String responseStr = connector.sendRequest(transformURL.editHost(url), method, this.ui.getHeaderr().fillingHeaders());
            ui.setResponseInfo(responseStr);
            int code = transformURL.getStatusCodeFromResponse(responseStr);
            //logger.info("FOR HOST " + transformURL.editHost(url) + " RESPONSE: " + code);
            //System.out.println(httpStatus.getHttpStatusCodes().get(code));
        } else ui.showAlert();
    }

    public boolean addHost(String url) {
        String newUrl = transformURL.editHost(url);
        if (!transformURL.checkHost(newUrl))
            return false;
        ui.getHeaderr().changeValueOfHeader("Host", newUrl);
        return true;
    }
}
