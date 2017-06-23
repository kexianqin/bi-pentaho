package com.yoyohr.client.resource.pentaho.bean;

import com.yoyohr.util.XmlUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/21.
 */
public class repositoryFileAclDtoTest {
    RepositoryFileAclDto repositoryFileAclDto;
    @Before
    public void setUp() {
        repositoryFileAclDto = new RepositoryFileAclDto();
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void test() {
        String xmlStr="<repositoryFileAclDto>\n" +
            "                        <aces>\n" +
            "                            <modifiable>true</modifiable>\n" +
            "                            <permissions>4</permissions>\n" +
            "                            <permissions>5</permissions>\n" +
            "                            <recipient>admin</recipient>\n" +
            "                            <recipientType>0</recipientType>\n" +
            "                        </aces>\n" +
            "                        <entriesInheriting>true</entriesInheriting>\n" +
            "                        <id>7e79ac8b-5054-4bf6-9f35-48f9cb754abb</id>\n" +
            "                        <owner>admin</owner>\n" +
            "                        <ownerType>0</ownerType>\n" +
            "                    </repositoryFileAclDto>";
        repositoryFileAclDto= XmlUtil.converyToJavaBean(xmlStr,RepositoryFileAclDto.class);
        System.out.println(repositoryFileAclDto);
        System.out.println(XmlUtil.convertToXml(repositoryFileAclDto));
    }
}

