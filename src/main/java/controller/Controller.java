package controller;


import exception.HttpStatus;
import model.Header;
import model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Connector;
import service.TransformURL;
import view.UI;

public class Controller {
    private UI ui;
    private TransformURL transformURL = new TransformURL();
    private Connector connector;
    private Response response;
    private HttpStatus httpStatus;
    private Logger logger = LogManager.getLogger(Controller.class);
    private Header header = new Header();

    public Controller(UI ui) {
        this.ui = ui;
        //transformURL = new TransformURL();
    }
    public Controller(){

    }

    public void sendRequest(String url, String method, String headerStr) {
        connector = new Connector();
        header = new Header();
        ui.updateTextArea();
        getHeaders(headerStr);
        httpStatus = new HttpStatus();
        if (transformURL.checkHost(url)) {
            addHost(url);
            String responseStr = connector.sendRequest(transformURL.editHost(url), method, header.fillingHeaders());
            ui.setResponseInfo(responseStr);
            int code = transformURL.getStatusCodeFromResponse(responseStr);
            //logger.info("FOR HOST " + transformURL.editHost(url) + " RESPONSE: " + code);
            //System.out.println(httpStatus.getHttpStatusCodes().get(code));
        } else ui.showAlert();
    }

    public boolean addHost(String url) {
        /*String newUrl = transformURL.editHost(url);
        if (!transformURL.checkHost(newUrl))
            return false;
        ui.getHeaderr().changeValueOfHeader("Host", newUrl);
        return true;*/
        if(transformURL.checkHost(url)) {
            header.changeValueOfHeader("Host", transformURL.editHost(url));
            return true;
        }
        else return false;
    }

    public void getHeaders(String strHeader){
        String[] arrs = concatHeader(strHeader);
        editHeaders(arrs);
    }


    public boolean editHeaders(String[] arr){
        for (String str: arr){
            String[] pair;
            pair = str.split(":");
            header.changeValueOfHeader(pair[0],pair[1]);
        }
        return true;
    }

    public static String[] concatHeader(String header){
        String[] headers = header.split(";\\s");
        return headers;
    }

}
