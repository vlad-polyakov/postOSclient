package client.service;

public class TransformURL {
    public String editHost(String host){
        if(host.contains("http://"))return host.replace("http://","");
        else if(host.contains("https://")) return host.replace("https://","");

        return host;
    }
}
