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

    public static void main(String[] args) throws IOException, DocumentException {


        String xmlStr = "<users><user>admin</user><user>jiangwenhua</user></users>";
        XmlReader reader = new XmlReader(xmlStr);
        //iterate through child elements of root
        for (Iterator i = reader.root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println("element.getName(): " + element.getName() + "element.getStringValue(): " + element.getStringValue());
        }
    }
}
