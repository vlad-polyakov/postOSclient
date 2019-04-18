package service;

public class HttpMethod {

    public String GET(){
        return "GET / HTTP/1.1";
    }

    public String POST(){
        return "POST /add HTTP/1.1";
    }

    public String HEAD(){
        return "HEAD / HTTP/1.1";
    }
}
