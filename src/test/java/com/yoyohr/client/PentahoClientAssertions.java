package com.yoyohr.client;

import com.yoyohr.AbstractAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PentahoClientAssertions extends AbstractAssertions {

    PentahoClient client;

    @Before
    public void setup() {
        client = new PentahoClient();
    }

    @Test
    public void test_can_administer() {
        try {
            assertThat(client.canAdminister()).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_new_pentaho_client() {

        assertThat(client).isInstanceOf(PentahoClient.class);
    }

    @Test
    public void test_get_users() {
        try {
            assertThat(client.getUsers()).isInstanceOf(ArrayList.class).contains("admin").contains
                    ("jiangwenhua");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }

}
