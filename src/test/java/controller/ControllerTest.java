package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.TransformURL;

public class ControllerTest {
    Controller controller;
    @Before
    public void init() {
        controller = new Controller();
    }

    @Test
    public void testSuccessAddHost() {
        String host = "http://java-online.ru/";
        Assert.assertEquals(true,controller.addHost(host));
    }

    @Test
    public void testSuccessConcatHeader() {
        String header = "Connection: close; Content-Length: 1348";
        String [] answer = {"Connection: close", "Content-Length: 1348"};
        Assert.assertEquals(answer,controller.concatHeader(header));
    }

}
