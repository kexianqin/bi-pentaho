package com.yoyohr.bi.olap.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yoyohr.AbstractTest;
import com.yoyohr.client.resource.saiku.query.Query;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class QueryTest extends AbstractTest {

    Query query;

    @Before
    public void setup() {
        query = new Query();
    }

    @Test
    public void testNewQuery() {
        assertThat(query).isInstanceOf(Query.class);
    }

    @Test
    public void testToJson() throws JsonProcessingException {
        query.setMdx("asdas");
        assertThat(query.toJson()).isInstanceOf(String.class);
    }
}
