package exception;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class HttpStatusTest {

    private HttpStatus httpStatus;
    private HashMap<Integer, String> map;

    @Before
    public void init() {
        httpStatus= new HttpStatus();
        map = new HashMap<>();
        map.put(200, HttpStatus.HTTP_OK);
        map.put(301, HttpStatus.HTTP_MOVED_PERMANENTLY);
        map.put(302, HttpStatus.HTTP_MOVED_TEMPORARILY);
        map.put(400, HttpStatus.HTTP_BAD_REQUEST);
        map.put(401, HttpStatus.HTTP_UNAUTHORIZED);
        map.put(403, HttpStatus.HTTP_FORBIDDEN);
        map.put(404, HttpStatus.HTTP_NOT_FOUND);
        map.put(406, HttpStatus.HTTP_NOT_ACCEPTABLE);
        map.put(408, HttpStatus.HTTP_TIMEOUT);
        map.put(500, HttpStatus.HTTP_INTERNAL_ERROR);
        map.put(501, HttpStatus.HTTP_NOT_IMPLEMENTED);
        map.put(503, HttpStatus.HTTP_UNAVAILABLE);
        map.put(505, HttpStatus.HTTP_NOT_SUPPORTED);
    }

    @Test
    public void getHttpStatusCodes() {
        Assert.assertEquals(map, httpStatus.getHttpStatusCodes());
    }
}