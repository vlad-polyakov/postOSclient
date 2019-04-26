package controller;

import model.Header;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
    Controller controller;
    Header header;

    @Before
    public void init() {
        header = new Header();
        controller = new Controller();
    }


    @Test
    public void testGetIsNotEmptyResponseInSendRequest() {
        String method = "HEAD / HTTP/1.1";
        String url = "java-online.ru";
        String header = "Host:" + url + "\n";
        String data = "";
        Assert.assertNotEquals("", controller.sendRequest(url,method,header));
    }

    @Test
    public void testSuccessAddHost() {
        String host = "http://java-online.ru/";
        Assert.assertTrue(controller.addHost(host));
    }

    @Test
    public void testSuccessEditHeaders() {
        String[] arr = {"d:sf", "sdf:sdf"};
        Assert.assertTrue(controller.editHeaders(arr));
    }

    @Test
    public void testSuccessGetHeaders() {
        String arr = "sdfjh:sdfsdf; sdfsdf:sdfsd";
        Assert.assertTrue(controller.getHeaders(arr));
    }

    @Test
    public void testFailGetHeaders() {
        String arr = "sdfjhsdfsdf; sdfsdf:sdfsd";
        Assert.assertFalse(controller.getHeaders(arr));
    }

    @Test
    public void testFailEditHeaders() {
        String[] arr = {"d:sf", "sdf:sdf", "sdfs"};
        Assert.assertFalse(controller.editHeaders(arr));
    }

    @Test
    public void testFailAddHost() {
        String host = "httpsdf://java-online.ru/";
        Assert.assertFalse(controller.addHost(host));
    }

    @Test
    public void testSuccessConcatHeader() {
        String header = "Connection: close; Content-Length: 1348";
        String[] answer = {"Connection: close", "Content-Length: 1348"};
        Assert.assertEquals(answer, controller.concatHeader(header));
    }

}

