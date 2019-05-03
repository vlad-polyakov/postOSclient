package controller;


import exception.HttpStatus;
import model.Header;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.Connector;
import service.HttpMethod;
import service.TransformURL;
import view.UI;

import java.io.*;
import java.net.URL;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    private UI ui;
    private TransformURL transformURL = new TransformURL();
    private Connector connector;
    private HttpStatus httpStatus;
    private HttpMethod httpMethod = new HttpMethod();
    private static Logger logger = LogManager.getLogger(Controller.class);
    private Header header = new Header();

    public Controller(UI ui) {
        this.ui = ui;
    }

    public Controller() {

    }

    public String sendRequest(String url, String method, String headerStr, String data) {
        String responseStr="";
        String requestBody="";
        method = method.replace("/ ",transformURL.getContentFromUrl(url) + " ");
        connector = new Connector();
        header = new Header();
        getHeaders(headerStr);
        httpStatus = new HttpStatus();
        if (transformURL.checkHost(url)) {
            String hostWithProtocol = transformURL.getHostWithProtocol(url);
            addHost(url);
            if (method.equals(httpMethod.POST())){
                requestBody = data;
                header.addPostHeaders(requestBody);
            }
            ui.setResponseInfo(header.fillingHeaders());
            logger.info(requestBody);
            responseStr = connector.sendRequest(transformURL.editHost(url), method, header.fillingHeaders(), requestBody, getPortFromHost(transformURL.editHost(url)));
            int code = transformURL.getStatusCodeFromResponse(responseStr);
            logger.info(responseStr);
            downloadImages(transformURL.getImageStrFromUrl(responseStr),hostWithProtocol);
            logger.info(responseStr);
        } else {
            ui.showAlert();
        }
        return responseStr;
    }


    public int getPortFromHost(String host){
        int port = 80;
        if(host.contains(":")){
            int start = host.indexOf(":")+1;
            int end = host.length();
            port = Integer.valueOf(host.substring(start, end));
        }
        return port;
    }

    public boolean addHost(String url) {
        if (transformURL.checkHost(url)) {
            String hostik = transformURL.editHost(url);
            String port = String.valueOf(getPortFromHost(hostik));
            header.changeValueOfHeader("Host", transformURL.editHost(hostik.replace(":"+port,"")));
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

    public void downloadImages(List<String> list,String host) {
        try {
            for (int i = 0; i < list.size(); i++) {
                String urlStr = host+"/"+list.get(i);
                URL url = new URL(urlStr);
                InputStream in = new BufferedInputStream(url.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();
                FileOutputStream fos = new FileOutputStream(transformURL.transformToImageName(list.get(i)));
                fos.write(response);
                fos.close();
            }
        }
        catch (IOException ex){logger.error(ex.getMessage());}
    }

}
