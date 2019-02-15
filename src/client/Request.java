package client;

import java.util.ArrayList;

public class Request {

    private String method;
    private String url;
    private Headers header;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Headers getHeader() {
        return header;
    }

    public void setHeader(Headers header) {
        this.header = header;
    }
}
