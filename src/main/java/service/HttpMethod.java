package service;

public class HttpMethod {

    public String GET(){
        return "GET / HTTP/1.0";
    }

    public String POST(){
        return "POST / HTTP/1.0";
    }

    public String HEAD(){
        return "HEAD / HTTP/1.0";
    }
}
