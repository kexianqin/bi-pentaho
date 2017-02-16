package com.yoyohr.client;

import com.yoyohr.AbstractAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuClientTest extends AbstractAssertions {

    SaikuClient client;

    @Before
    public void setup() throws UnanthenticatedException, IOException, URISyntaxException {
        client = new SaikuClient();
    }

    @Test
    public void test_new_saiku_client() {
        assertThat(client).isInstanceOf(SaikuClient.class);
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }
}
