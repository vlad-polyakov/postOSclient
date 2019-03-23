package exception;

import java.util.HashMap;

public class HttpStatus {

    public static final String HTTP_OK = "200 OK\n";
    public static final String HTTP_MOVED_PERMANENTLY = "301 Moved Permanently\n" ;
    public static final String HTTP_MOVED_TEMPORARILY = "302 Found, Moved Temporarily\n";
    public static final String HTTP_BAD_REQUEST = "400 Bad Request\n";
    public static final String HTTP_UNAUTHORIZED = "401 Unauthorized\n";
    public static final String HTTP_FORBIDDEN = "403 Forbidden\n";
    public static final String HTTP_NOT_FOUND = "404 Not Found\n";
    public static final String HTTP_NOT_ACCEPTABLE = "406 Not Acceptable\n";
    public static final String HTTP_TIMEOUT = "408 Request Timeout\n";
    public static final String HTTP_INTERNAL_ERROR = "500 Internal Server Error\n";
    public static final String HTTP_NOT_IMPLEMENTED = "501 Not Implemented\n";
    public static final String HTTP_UNAVAILABLE = "503 Service Unavailable\n";
    public static final String HTTP_NOT_SUPPORTED = "505 HTTP Version Not Supported\n";
    private static HashMap<Integer, String> httpStatusCodes;

    public HttpStatus(){
        httpStatusCodes = new HashMap<Integer, String>();
        httpStatusCodes.put(200, HTTP_OK);
        httpStatusCodes.put(301, HTTP_MOVED_PERMANENTLY);
        httpStatusCodes.put(302, HTTP_MOVED_TEMPORARILY);
        httpStatusCodes.put(400, HTTP_BAD_REQUEST);
        httpStatusCodes.put(401, HTTP_UNAUTHORIZED);
        httpStatusCodes.put(403, HTTP_FORBIDDEN);
        httpStatusCodes.put(404, HTTP_NOT_FOUND);
        httpStatusCodes.put(406, HTTP_NOT_ACCEPTABLE);
        httpStatusCodes.put(408, HTTP_TIMEOUT);
        httpStatusCodes.put(500, HTTP_INTERNAL_ERROR);
        httpStatusCodes.put(501, HTTP_NOT_IMPLEMENTED);
        httpStatusCodes.put(503, HTTP_UNAVAILABLE);
        httpStatusCodes.put(505, HTTP_NOT_SUPPORTED);
    }

    public HashMap<Integer, String> getHttpStatusCodes() { return httpStatusCodes; }

    public static void setHttpStatusCodes(HashMap<Integer, String> httpStatusCodes) {
        HttpStatus.httpStatusCodes = httpStatusCodes;
    }
}
