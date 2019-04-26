package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HttpMethodTest {
    private HttpMethod httpMethod;

    @Before
    public void init(){
        httpMethod = new HttpMethod();
    }

    @Test
    public void testSuccessGET() {
        Assert.assertEquals("GET / HTTP/1.1", httpMethod.GET());
    }

    @Test
    public void testSuccessPOST() {
        Assert.assertEquals("POST /add HTTP/1.1", httpMethod.POST());
    }

    @Test
    public void testSuccessHEAD() {
        Assert.assertEquals("HEAD / HTTP/1.1", httpMethod.HEAD());
    }
}