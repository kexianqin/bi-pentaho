package com.yoyohr.client.resource.pentaho.bean;

import com.yoyohr.util.XmlUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/21.
 */
public class RepositoryFileTreeDtoTest {
    RepositoryFileTreeDto repositoryFileTreeDto;
    @Before
    public void setUp() throws Exception {
        repositoryFileTreeDto=new RepositoryFileTreeDto();
        System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void Test() throws Exception{
        String xmlStr ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<repositoryFileTreeDto>\n" +
            "    <children>\n" +
            "        <children>\n" +
            "            <file>\n" +
            "                <aclNode>false</aclNode>\n" +
            "                <createdDate>1496981360812</createdDate>\n" +
            "                <fileSize>-1</fileSize>\n" +
            "                <folder>true</folder>\n" +
            "                <hidden>false</hidden>\n" +
            "                <id>57052a22-4ddd-4a46-ae99-6dcc087e868b</id>\n" +
            "                <locale>en</locale>\n" +
            "                <locked>false</locked>\n" +
            "                <name>admin</name>\n" +
            "                <owner>admin</owner>\n" +
            "                <ownerType>-1</ownerType>\n" +
            "                <path>/home/admin</path>\n" +
            "                <repositoryFileAclDto>\n" +
            "                    <aces>\n" +
            "                        <modifiable>true</modifiable>\n" +
            "                        <permissions>4</permissions>\n" +
            "                        <recipient>admin</recipient>\n" +
            "                        <recipientType>0</recipientType>\n" +
            "                    </aces>\n" +
            "                    <entriesInheriting>false</entriesInheriting>\n" +
            "                    <id>57052a22-4ddd-4a46-ae99-6dcc087e868b</id>\n" +
            "                    <owner>admin</owner>\n" +
            "                    <ownerType>0</ownerType>\n" +
            "                </repositoryFileAclDto>\n" +
            "                <title>admin</title>\n" +
            "                <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "                <versioned>false</versioned>\n" +
            "                <versioningEnabled>false</versioningEnabled>\n" +
            "            </file>\n" +
            "        </children>\n" +
            "        <children>\n" +
            "            <file>\n" +
            "                <aclNode>false</aclNode>\n" +
            "                <createdDate>1497318719081</createdDate>\n" +
            "                <fileSize>-1</fileSize>\n" +
            "                <folder>true</folder>\n" +
            "                <hidden>false</hidden>\n" +
            "                <id>f2cff2b5-a157-4428-a5fe-37cd4eb5cb13</id>\n" +
            "                <locale>en</locale>\n" +
            "                <locked>false</locked>\n" +
            "                <name>myDashboards</name>\n" +
            "                <owner>admin</owner>\n" +
            "                <ownerType>-1</ownerType>\n" +
            "                <path>/home/myDashboards</path>\n" +
            "                <repositoryFileAclDto>\n" +
            "                    <aces>\n" +
            "                        <modifiable>true</modifiable>\n" +
            "                        <permissions>0</permissions>\n" +
            "                        <recipient>Authenticated</recipient>\n" +
            "                        <recipientType>1</recipientType>\n" +
            "                    </aces>\n" +
            "                    <entriesInheriting>true</entriesInheriting>\n" +
            "                    <id>f2cff2b5-a157-4428-a5fe-37cd4eb5cb13</id>\n" +
            "                    <owner>admin</owner>\n" +
            "                    <ownerType>0</ownerType>\n" +
            "                </repositoryFileAclDto>\n" +
            "                <title>myDashboards</title>\n" +
            "                <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "                <versioned>false</versioned>\n" +
            "                <versioningEnabled>false</versioningEnabled>\n" +
            "            </file>\n" +
            "        </children>\n" +
            "        <children>\n" +
            "            <file>\n" +
            "                <aclNode>false</aclNode>\n" +
            "                <createdDate>1496981360768</createdDate>\n" +
            "                <fileSize>-1</fileSize>\n" +
            "                <folder>true</folder>\n" +
            "                <hidden>false</hidden>\n" +
            "                <id>e9aa9839-1fa0-452b-96e3-eb4167f62529</id>\n" +
            "                <locale>en</locale>\n" +
            "                <locked>false</locked>\n" +
            "                <name>pat</name>\n" +
            "                <owner>pat</owner>\n" +
            "                <ownerType>-1</ownerType>\n" +
            "                <path>/home/pat</path>\n" +
            "                <repositoryFileAclDto>\n" +
            "                    <aces>\n" +
            "                        <modifiable>true</modifiable>\n" +
            "                        <permissions>4</permissions>\n" +
            "                        <recipient>pat</recipient>\n" +
            "                        <recipientType>0</recipientType>\n" +
            "                    </aces>\n" +
            "                    <entriesInheriting>false</entriesInheriting>\n" +
            "                    <id>e9aa9839-1fa0-452b-96e3-eb4167f62529</id>\n" +
            "                    <owner>pat</owner>\n" +
            "                    <ownerType>0</ownerType>\n" +
            "                </repositoryFileAclDto>\n" +
            "                <title>pat</title>\n" +
            "                <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "                <versioned>false</versioned>\n" +
            "                <versioningEnabled>false</versioningEnabled>\n" +
            "            </file>\n" +
            "        </children>\n" +
            "        <children>\n" +
            "            <file>\n" +
            "                <aclNode>false</aclNode>\n" +
            "                <createdDate>1496981360742</createdDate>\n" +
            "                <fileSize>-1</fileSize>\n" +
            "                <folder>true</folder>\n" +
            "                <hidden>false</hidden>\n" +
            "                <id>2d1c5da4-bf4d-4087-9595-7d30e8ee7c28</id>\n" +
            "                <locale>en</locale>\n" +
            "                <locked>false</locked>\n" +
            "                <name>suzy</name>\n" +
            "                <owner>suzy</owner>\n" +
            "                <ownerType>-1</ownerType>\n" +
            "                <path>/home/suzy</path>\n" +
            "                <repositoryFileAclDto>\n" +
            "                    <aces>\n" +
            "                        <modifiable>true</modifiable>\n" +
            "                        <permissions>4</permissions>\n" +
            "                        <recipient>suzy</recipient>\n" +
            "                        <recipientType>0</recipientType>\n" +
            "                    </aces>\n" +
            "                    <entriesInheriting>false</entriesInheriting>\n" +
            "                    <id>2d1c5da4-bf4d-4087-9595-7d30e8ee7c28</id>\n" +
            "                    <owner>suzy</owner>\n" +
            "                    <ownerType>0</ownerType>\n" +
            "                </repositoryFileAclDto>\n" +
            "                <title>suzy</title>\n" +
            "                <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "                <versioned>false</versioned>\n" +
            "                <versioningEnabled>false</versioningEnabled>\n" +
            "            </file>\n" +
            "        </children>\n" +
            "        <children>\n" +
            "            <file>\n" +
            "                <aclNode>false</aclNode>\n" +
            "                <createdDate>1496981360792</createdDate>\n" +
            "                <fileSize>-1</fileSize>\n" +
            "                <folder>true</folder>\n" +
            "                <hidden>false</hidden>\n" +
            "                <id>909634c5-dd72-49f0-a4a0-0d1f69a44bdd</id>\n" +
            "                <locale>en</locale>\n" +
            "                <locked>false</locked>\n" +
            "                <name>tiffany</name>\n" +
            "                <owner>tiffany</owner>\n" +
            "                <ownerType>-1</ownerType>\n" +
            "                <path>/home/tiffany</path>\n" +
            "                <repositoryFileAclDto>\n" +
            "                    <aces>\n" +
            "                        <modifiable>true</modifiable>\n" +
            "                        <permissions>4</permissions>\n" +
            "                        <recipient>tiffany</recipient>\n" +
            "                        <recipientType>0</recipientType>\n" +
            "                    </aces>\n" +
            "                    <entriesInheriting>false</entriesInheriting>\n" +
            "                    <id>909634c5-dd72-49f0-a4a0-0d1f69a44bdd</id>\n" +
            "                    <owner>tiffany</owner>\n" +
            "                    <ownerType>0</ownerType>\n" +
            "                </repositoryFileAclDto>\n" +
            "                <title>tiffany</title>\n" +
            "                <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "                <versioned>false</versioned>\n" +
            "                <versioningEnabled>false</versioningEnabled>\n" +
            "            </file>\n" +
            "        </children>\n" +
            "        <file>\n" +
            "            <aclNode>false</aclNode>\n" +
            "            <createdDate>1496981360613</createdDate>\n" +
            "            <fileSize>-1</fileSize>\n" +
            "            <folder>true</folder>\n" +
            "            <hidden>false</hidden>\n" +
            "            <id>1a0c7d97-53f1-4a3d-95d7-6c43bbc92f86</id>\n" +
            "            <locale>en</locale>\n" +
            "            <localePropertiesMapEntries>\n" +
            "                <locale>default</locale>\n" +
            "                <properties>\n" +
            "                    <key>file.title</key>\n" +
            "                    <value>Home</value>\n" +
            "                </properties>\n" +
            "                <properties>\n" +
            "                    <key>jcr:primaryType</key>\n" +
            "                    <value>nt:unstructured</value>\n" +
            "                </properties>\n" +
            "                <properties>\n" +
            "                    <key>file.description</key>\n" +
            "                    <value></value>\n" +
            "                </properties>\n" +
            "            </localePropertiesMapEntries>\n" +
            "            <locked>false</locked>\n" +
            "            <name>home</name>\n" +
            "            <owner>pentahoRepoAdmin</owner>\n" +
            "            <ownerType>-1</ownerType>\n" +
            "            <path>/home</path>\n" +
            "            <repositoryFileAclDto>\n" +
            "                <aces>\n" +
            "                    <modifiable>true</modifiable>\n" +
            "                    <permissions>0</permissions>\n" +
            "                    <recipient>Authenticated</recipient>\n" +
            "                    <recipientType>1</recipientType>\n" +
            "                </aces>\n" +
            "                <entriesInheriting>false</entriesInheriting>\n" +
            "                <id>1a0c7d97-53f1-4a3d-95d7-6c43bbc92f86</id>\n" +
            "                <owner>pentahoRepoAdmin</owner>\n" +
            "                <ownerType>0</ownerType>\n" +
            "            </repositoryFileAclDto>\n" +
            "            <title>Home</title>\n" +
            "            <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "            <versioned>false</versioned>\n" +
            "            <versioningEnabled>false</versioningEnabled>\n" +
            "        </file>\n" +
            "    </children>\n" +
            "    <file>\n" +
            "        <aclNode>false</aclNode>\n" +
            "        <createdDate>1496981360543</createdDate>\n" +
            "        <fileSize>-1</fileSize>\n" +
            "        <folder>true</folder>\n" +
            "        <hidden>false</hidden>\n" +
            "        <id>221604a1-45be-490b-92ec-a1715a93329b</id>\n" +
            "        <locale>en</locale>\n" +
            "        <locked>false</locked>\n" +
            "        <name></name>\n" +
            "        <owner>pentahoRepoAdmin</owner>\n" +
            "        <ownerType>-1</ownerType>\n" +
            "        <path>/</path>\n" +
            "        <repositoryFileAclDto>\n" +
            "            <aces>\n" +
            "                <modifiable>true</modifiable>\n" +
            "                <permissions>4</permissions>\n" +
            "                <recipient>Administrator</recipient>\n" +
            "                <recipientType>1</recipientType>\n" +
            "            </aces>\n" +
            "            <entriesInheriting>false</entriesInheriting>\n" +
            "            <id>221604a1-45be-490b-92ec-a1715a93329b</id>\n" +
            "            <owner>pentahoRepoAdmin</owner>\n" +
            "            <ownerType>0</ownerType>\n" +
            "        </repositoryFileAclDto>\n" +
            "        <title></title>\n" +
            "        <versionCommentEnabled>false</versionCommentEnabled>\n" +
            "        <versioned>false</versioned>\n" +
            "        <versioningEnabled>false</versioningEnabled>\n" +
            "    </file>\n" +
            "</repositoryFileTreeDto>";
        repositoryFileTreeDto = XmlUtil.converyToJavaBean(xmlStr,RepositoryFileTreeDto.class);
        System.out.println(repositoryFileTreeDto);
        System.out.println(XmlUtil.convertToXml(repositoryFileTreeDto));
    }

}
