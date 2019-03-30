package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformURLTest {
    private TransformURL transformURL;

    @Before
    public void init() {
        transformURL = new TransformURL();
    }

    @Test
    public void testSuccessEditHost() {
        String host = "http://java-online.ru/";
        Assert.assertEquals("java-online.ru",transformURL.editHost(host));
    }

    @Test
    public void testSuccessCheckHost() {
        String host = "java-online.ru";
        Assert.assertTrue(transformURL.checkHost(host));
    }

    @Test
    public void testFailCheckHost() {
        String host = "\\l;kl;\\java-online.ru^";
        Assert.assertFalse(transformURL.checkHost(host));
    }

    @Test
    public void testSuccessGetStatusCodeFromResponse() {
        String response = "HTTP/1.1 200 OK";
        Assert.assertEquals(200, transformURL.getStatusCodeFromResponse(response));
    }
}