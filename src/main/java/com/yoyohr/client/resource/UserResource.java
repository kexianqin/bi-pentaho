package com.yoyohr.client.resource;

import com.yoyohr.client.Response;
import com.yoyohr.client.XmlReader;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class UserResource {

    public static final String LIST_USERS = "/api/users";

    private Response response;

    private List<String> users;

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

    public List<String> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String user : users) {
            stringBuilder.append(user);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
