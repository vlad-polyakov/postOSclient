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
        fail.put(Header.USER_AGENT, "");
        fail.put(Header.CONTENT_ENCODING, "");
        fail.put(Header.HOST, "");
        map.put(Header.USER_AGENT, "");
        map.put(Header.CONTENT_ENCODING, "");
        map.put(Header.HOST, "");
        map.put(Header.ACCEPT_lANGUAGE, "");
        map.put(Header.ACCEPT_ENCODING, "");
        map.put(Header.CONNECTION, "");
        map.put(Header.ACCEPT, "");
        map.put(Header.COOKIE, "");
    }


    @Test
    public void testSuccessFillingHeaders() {
        Assert.assertEquals("", header.fillingHeaders());
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