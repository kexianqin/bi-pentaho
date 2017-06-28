package com.yoyohr.client.resource.pentaho.bean;

import com.yoyohr.util.XmlUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/21.
 */
public class AcesTest {
    Aces aces;
    @Before
    public void setUp() {
        aces = new Aces();
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void test() {
        String xmlStr="<aces>\n" +
            "<modifiable>true</modifiable>\n" +
            "<permissions>4</permissions>\n" +
            "<permissions>5</permissions>\n" +
            "<recipient>admin</recipient>\n" +
            "<recipientType>0</recipientType>\n" +
            "</aces>";
        aces=XmlUtil.converyToJavaBean(xmlStr,Aces.class);
        System.out.println(aces);
    }
}
