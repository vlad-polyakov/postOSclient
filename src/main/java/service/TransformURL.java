package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformURL {
    Pattern hostPattern = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}|localhost:[0-9]{4}");
    Pattern httpPattern = Pattern.compile("^(http://|https://)");
    Pattern responseCodePattern = Pattern.compile("[0-9]{3}");

    public String editHost(String host) {
        Matcher hostMatcher = hostPattern.matcher(host);
        if (hostMatcher.find()) {
            Matcher httpMatcher = httpPattern.matcher(hostMatcher.group());
            host = httpMatcher.replaceAll("");
        }
        return host;
    }

    public boolean checkHost(String host) {
        Matcher hostMatcher = hostPattern.matcher(host);
        if (hostMatcher.find())
            return true;
        else return false;
    }

    public int getStatusCodeFromResponse(String response) {
        int code = 0;
        Matcher codeMatcher = responseCodePattern.matcher(response);
        if (codeMatcher.find()) code = Integer.valueOf(codeMatcher.group());
        return code;
    }

}
