package model;

import java.util.HashMap;
import java.util.Map;

public class Header {
    private static final String USER_AGENT = "User-Agent";
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String HOST = "Host";
    private static final String ACCEPT_lANGUAGE = "Accept-Language";
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String CONNECTION = "Connection";
    private static final String COOKIE = "Cookie";
    private static final String ACCEPT = "Accept";

    private HashMap<String, String> header;
    private String headerForRequest;

    public Header(){
        header = new HashMap<String, String>();
        header.put(USER_AGENT,"");
        header.put(CONTENT_ENCODING,"");
        header.put(HOST,"");
        header.put(ACCEPT_lANGUAGE,"");
        header.put(ACCEPT_ENCODING,"");
        header.put(CONNECTION,"");
        header.put(ACCEPT,"");
        header.put(COOKIE,"");
    }

    public  String fillingHeaders(){
        for (String key: header.keySet()){
            if (header.get(key)!=null){
                headerForRequest += key + ": " + header.get(key) + "\n";
            }
        }
        return headerForRequest;
    }

    public HashMap<String, String> getAllHeaders() {
        return  header;
    }

    public boolean changeValueOfHeader(String header, String value){
        this.header.put(header,value);
        return true;
    }
}
