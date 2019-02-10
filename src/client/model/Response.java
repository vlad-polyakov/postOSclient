package client.model;

public class Response {

    private String header;
    private String body;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header + "\r\n";
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
