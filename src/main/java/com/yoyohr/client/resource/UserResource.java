package com.yoyohr.client.resource;

import com.yoyohr.client.XmlReader;
import com.yoyohr.client.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class UserResource {

    public static final String LIST_USERS = "/users";

    private Response response;

    private ArrayList<String> users;

    public UserResource(Response response) throws IOException, DocumentException {
        this.response = response;
        users = new ArrayList<>();
        if (response.getCode() == 0) {
            XmlReader reader = new XmlReader(this.response.getData());
            for (java.util.Iterator i = reader.getRoot().elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String user = element.getStringValue();
                users.add(user);
            }
        }
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String user : users) {
            stringBuffer.append(user);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
