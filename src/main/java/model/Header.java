package model;

import java.util.HashMap;
import java.util.Map;

public class Header {
    public static final String USER_AGENT = "User-Agent";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String HOST = "Host";
    public static final String ACCEPT_lANGUAGE = "Accept-Language";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String CONNECTION = "Connection";
    public static final String COOKIE = "Cookie";
    public static final String ACCEPT = "Accept";

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

    public String fillingHeaders(){
        headerForRequest = "";
        for (String key: header.keySet()){
            if (header.get(key)!=""){
                headerForRequest += key + ": " + header.get(key) + "\n";
            }
        }
        return headerForRequest;
    }

    public HashMap<String, String> getAllHeaders() {
        return  header;
    }

    public boolean changeValueOfHeader(String header, String value){
        if (!this.header.containsKey(header))
            return false;
        this.header.put(header,value);
        return true;
    }


}
