package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Header {
    public static final String USER_AGENT = "User-Agent";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String HOST = "Host";
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String CONNECTION = "Connection";
    public static final String COOKIE = "Cookie";
    public static final String ACCEPT = "Accept";

    private HashMap<String, String> header;
    private String headerForRequest;

    public Header() {
        header = new HashMap<String, String>();
        header.put(USER_AGENT, "Mozilla/5.0" + " (Windows NT 10.0; Win64; x64" + ") AppleWebKit/537.36" + " (KHTML, like Gecko)" + " Chrome/66.0.3359.139" + " Safari/537.36" );
        header.put(CONTENT_ENCODING, "");
        header.put(HOST, "");
        header.put(ACCEPT_LANGUAGE, "");
        header.put(ACCEPT_ENCODING, "");
        header.put(CONNECTION, "");
        header.put(ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header.put(COOKIE, "");
        header.put(CONTENT_TYPE, "");
        header.put(CONTENT_LENGTH, "");
    }

    public String fillingHeaders() {
        headerForRequest = "";
        List<String> list = new ArrayList<>();
        for (String key : header.keySet()) {
            if (header.get(key) != "") {
                //headerForRequest += key + ": " + header.get(key) + "\n";
                list.add(key + ": " + header.get(key) + "\r\n");
            }
        }
        int pos=0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).contains("Content-Type")) pos = i;
            if (list.get(i).contains("Host")){
                String str = list.get(i);
                list.remove(i);
                list.add(pos, str);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) headerForRequest+=list.get(i);
        return headerForRequest;
    }

    public  void addPostHeaders(String data){
        header.put(CONTENT_TYPE, "application/x-www-form-urlencoded");
        header.put(CONTENT_LENGTH, String.valueOf(data.length()));
    }

    public HashMap<String, String> getAllHeaders() {
        return header;
    }

    public boolean changeValueOfHeader(String header, String value) {
        if (!this.header.containsKey(header))
            return false;
        this.header.put(header, value);
        return true;
    }


}
