package service;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformURL {
    Pattern hostPattern = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}|localhost");
    Pattern httpPattern = Pattern.compile("^(http://|https://)");
    Pattern responseCodePattern = Pattern.compile("[0-9]{3}");
    Pattern imageTagPattern = Pattern.compile("<img[^>]+>");
    Pattern imageValuePattern = Pattern.compile(".*(jpg|jpeg|png|gif|svg)");

    public String editHost(String host) {
            Matcher httpMatcher = httpPattern.matcher(getHostWithProtocol(host));
            host = httpMatcher.replaceAll("");
        return host;
    }

    public String getHostWithProtocol(String host){
        Matcher hostMatcher = hostPattern.matcher(host);
        if (hostMatcher.find()) host = hostMatcher.group();
        return host;
    }
    public String getContentFromUrl(String host){
        String content = "";
        Matcher hostMatcher = hostPattern.matcher(host);
        if (hostMatcher.find()) {
            content = host.replace(hostMatcher.group(),"");
        }
        return content;
    }
    public boolean checkHost(String host) {
        Matcher hostMatcher = hostPattern.matcher(host);
        if (hostMatcher.find())
            return true;
        else return false;
    }
    public List<String> getImageStrFromUrl(String response){;
        List<String> imagesList = new ArrayList<>();
        Matcher imageStrMatcher = imageTagPattern.matcher(response);

        while(imageStrMatcher.find()) {
            String tag = imageStrMatcher.group();
            Matcher imageValueMatcher = imageValuePattern.matcher(tag);
            if(imageValueMatcher.find()){
                String name = imageValueMatcher.group();
                imagesList.add(name);
            }
        }
        return imagesList;
    }
    public boolean isFileName(String name){
        Matcher imageValueMatcher = imageValuePattern.matcher(name);
        if(imageValueMatcher.find()) return true;
        else return false;
    }
    public String transformToImageName(String name){
        return name.replace("/",".");
    }

    public int getStatusCodeFromResponse(String response) {
        int code = 0;
        Matcher codeMatcher = responseCodePattern.matcher(response);
        if (codeMatcher.find()) code = Integer.valueOf(codeMatcher.group());
        return code;
    }

}
