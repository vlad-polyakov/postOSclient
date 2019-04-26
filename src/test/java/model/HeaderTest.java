package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class HeaderTest {
    private Header header;
    private HashMap<String, String> map;
    private HashMap<String, String> fail;

    @Before
    public void init() {
        header = new Header();
        map = new HashMap<>();
        fail = new HashMap<>();
        fail.put(Header.USER_AGENT, "Mozilla/5.0" + " (Windows NT 10.0; Win64; x64" + ") AppleWebKit/537.36" + " (KHTML, like Gecko)" + " Chrome/66.0.3359.139" + " Safari/537.36");
        fail.put(Header.CONTENT_ENCODING, "");
        fail.put(Header.HOST, "");
        map.put(Header.USER_AGENT, "Mozilla/5.0" + " (Windows NT 10.0; Win64; x64" + ") AppleWebKit/537.36" + " (KHTML, like Gecko)" + " Chrome/66.0.3359.139" + " Safari/537.36");
        map.put(Header.CONTENT_ENCODING, "");
        map.put(Header.HOST, "");
        map.put(Header.ACCEPT_LANGUAGE, "");
        map.put(Header.ACCEPT_ENCODING, "");
        map.put(Header.CONNECTION, "");
        map.put(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        map.put(Header.COOKIE, "");
        map.put(Header.CONTENT_TYPE, "");
        map.put(Header.CONTENT_LENGTH, "");
    }


    @Test
    public void testSuccessFillingHeaders() {

        Assert.assertEquals("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\n" + "User-Agent: Mozilla/5.0" + " (Windows NT 10.0; Win64; x64" + ") AppleWebKit/537.36" + " (KHTML, like Gecko)" + " Chrome/66.0.3359.139" + " Safari/537.36\r\n", header.fillingHeaders());
    }

    @Test
    public void testFailFillingHeaders() {
        Assert.assertNotEquals("sdfsdg", header.fillingHeaders());
    }

    @Test
    public void testSuccessGetAllHeaders() {
        Assert.assertEquals(map, header.getAllHeaders());
    }

    @Test
    public void testFailGetAllHeaders() {
        Assert.assertNotEquals(fail, header.getAllHeaders());
    }

    @Test
    public void testSuccessChangeValueOfHeader() {
        Assert.assertTrue( header.changeValueOfHeader("Connection", "close"));
    }

    @Test
    public void testFailChangeValueOfHeader() {
        Assert.assertFalse( header.changeValueOfHeader("Acept", "no"));
    }
}