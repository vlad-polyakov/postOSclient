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

    Header(){
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

    public void addHeader(String key, String value) {
        getAllHeaders().put(key, value);
    }

    public String getPartOfHeader(String key) {
        return getAllHeaders().get(key);
    }

    public HashMap<String, String> getAllHeaders() {
        return  header;
    }

}
