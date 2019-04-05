package controller;


import exception.HttpStatus;
import model.Header;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Connector;
import service.TransformURL;
import view.UI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private UI ui;
    private TransformURL transformURL = new TransformURL();
    private Connector connector;
    private HttpStatus httpStatus;
    private Logger logger = LogManager.getLogger(Controller.class);
    private Header header = new Header();

    public Controller(UI ui) {
        this.ui = ui;
        //transformURL = new TransformURL();
    }

    public Controller() {

    }

    public String sendRequest(String url, String method, String headerStr) {
        String responseStr="";
        connector = new Connector();
        header = new Header();
        getHeaders(headerStr);
        httpStatus = new HttpStatus();
        if (transformURL.checkHost(url)) {
            addHost(url);
            responseStr = connector.sendRequest(transformURL.editHost(url), method, header.fillingHeaders());
            int code = transformURL.getStatusCodeFromResponse(responseStr);
            //logger.info("FOR HOST " + transformURL.editHost(url) + " RESPONSE: " + code);
            //System.out.println(httpStatus.getHttpStatusCodes().get(code));
        } else {
            ui.showAlert();
        }
        return responseStr;
    }

    public boolean addHost(String url) {
        /*String newUrl = transformURL.editHost(url);
        if (!transformURL.checkHost(newUrl))
            return false;
        ui.getHeaderr().changeValueOfHeader("Host", newUrl);
        return true;*/
        if (transformURL.checkHost(url)) {
            header.changeValueOfHeader("Host", transformURL.editHost(url));
            return true;
        } else return false;
    }

    public boolean getHeaders(String strHeader) {
        Pattern pattern = Pattern.compile(("([A-za-z]+:\\s?[A-za-z]+;\\s?)+"));
        Matcher matcher = pattern.matcher(strHeader);
        if (!matcher.find()) return false;
        String[] arrs = concatHeader(strHeader);
        editHeaders(arrs);
        return true;
    }


    public boolean editHeaders(String[] arr) {
        if (arr.length % 2 == 1)
            return false;
        for (String str : arr) {
            String[] pair;
            pair = str.split(":");
            header.changeValueOfHeader(pair[0], pair[1]);
        }
        return true;
    }

    public static String[] concatHeader(String header) {
        String[] headers = header.split(";\\s");
        return headers;
    }

}
