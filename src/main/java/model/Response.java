package model;

public class Response {

    private int statusCode;
    private Header header;
    private String body;

    public  Response(int statusCode, String body, Header header){
        this.body = body;
        this.header = header;
        this.statusCode = statusCode;
    }

    public boolean isSuccess(int code){
        return true;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

}