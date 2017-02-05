package com.yoyohr.client;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;


/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class XmlReader {

    private SAXReader saxReader;
    private Document document;
    private Element root;

    public Document getDocument() {
        return document;
    }

    public Element getRoot() {
        return root;
    }

    public XmlReader(String xml) throws IOException, DocumentException {
        saxReader = new SAXReader();
        document = saxReader.read(new ByteArrayInputStream(xml.getBytes(BaseHttpClient.DEFAULT_CHARSET)));
        root = document.getRootElement();

    }

}
