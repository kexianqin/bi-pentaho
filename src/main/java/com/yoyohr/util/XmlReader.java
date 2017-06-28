package com.yoyohr.util;

import com.yoyohr.client.BaseHttpClient;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class XmlReader {

    private SAXReader saxReader;
    private Document document;
    private Element root;

    public XmlReader(String xml) throws IOException{
        saxReader = new SAXReader();
        try {
            document = saxReader.read(new ByteArrayInputStream(xml.getBytes(BaseHttpClient.DEFAULT_CHARSET)));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        root = document.getRootElement();
    }

    public Document getDocument() {
        return document;
    }

    public Element getRoot() {
        return root;
    }

}

