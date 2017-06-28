package com.yoyohr.client;

import com.yoyohr.AbstractTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2017/6/20.
 */
public class PentahoClientTest extends AbstractTest {
    PentahoClient client;
    @Before
    public void setUp() throws Exception {
        client=new PentahoClient();
    }
    @Test
    public void testReservedCharactersDisplay() throws IOException {
        assertThat(client.getReservedCharacters()).contains("/");
        System.out.println(client.getReservedCharacters());
    }
    @Test
    public void testGetFileACL() throws IOException{
        System.out.println(client.getFileACL("home:pat:pattkk.xml"));
    }

    @After
    public void tearDown() throws Exception {

    }

}
