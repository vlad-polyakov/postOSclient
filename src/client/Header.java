package client;

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

    private String getUserAgent;
    private String getContentEncoding;
    private String getHost;
    private String getAcceptlanguage;
    private String getAcceptEncoding;
    private String getConnection;
    private String getCookie;
    private String getAccept;

    private Map<String,String> header = new HashMap<>();

    public String getGetUserAgent() {
        return getUserAgent;
    }

    public void setGetUserAgent(String getUserAgent) {
        this.getUserAgent = getUserAgent;
    }

    public String getGetContentEncoding() {
        return getContentEncoding;
    }

    public void setGetContentEncoding(String getContentEncoding) {
        this.getContentEncoding = getContentEncoding;
    }

    public String getGetHost() {
        return getHost;
    }

    public void setGetHost(String getHost) {
        this.getHost = getHost;
    }

    public String getGetAcceptlanguage() {
        return getAcceptlanguage;
    }

    public void setGetAcceptlanguage(String getAcceptlanguage) {
        this.getAcceptlanguage = getAcceptlanguage;
    }

    public String getGetAcceptEncoding() {
        return getAcceptEncoding;
    }

    public void setGetAcceptEncoding(String getAcceptEncoding) {
        this.getAcceptEncoding = getAcceptEncoding;
    }

    public String getGetConnection() {
        return getConnection;
    }

    public void setGetConnection(String getConnection) {
        this.getConnection = getConnection;
    }

    public String getGetCookie() {
        return getCookie;
    }

    public void setGetCookie(String getCookie) {
        this.getCookie = getCookie;
    }

    public String getGetAccept() {
        return getAccept;
    }

    public void setGetAccept(String getAccept) {
        this.getAccept = getAccept;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}
