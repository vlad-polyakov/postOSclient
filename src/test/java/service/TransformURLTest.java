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
    public void testSuccessgetHostWithProtocol() {
        String host = "http://java-online.ru/aaaaaaa";
        Assert.assertEquals("http://ava-online.ru",transformURL.getHostWithProtocol(host));
    }


    @Test
    public void testSuccessGetContentFromUrl() {
        String host = "http://java-online.ru/aaaaaaa";
        Assert.assertEquals("aaaaaaa",transformURL.getContentFromUrl(host));
    }
    @Test
    public void testSuccessCheckHost() {
        String host = "java-online.ru";
        Assert.assertTrue(transformURL.checkHost(host));
    }

    @Test
    public void testSuccessCheckLocalHost() {
        String host = "localhost:51265";
        Assert.assertTrue(transformURL.checkHost(host));
    }
    @Test
    public void testGetImageStrFromUrlIsNotEmpty() {
        String response = "td align='center' valign='top' style='background:URL(/gfx3/bgb.gif) bottom left repeat-x #9d0a0e;'><div class='tdmain'>\n" +
                "\t\t\t<div class='logo'><a href='/' title='На главную'><img src='gfx3/logo.gif' border='0'></a></div>";
        Assert.assertNotEquals("", transformURL.getImageStrFromUrl(response));
    }
    @Test
    public void testSuccessTransformToImageName() {
        String name = "a/b/c";
        Assert.assertEquals("a.b.c", transformURL.transformToImageName(name));
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