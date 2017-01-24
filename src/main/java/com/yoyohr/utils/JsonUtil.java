package com.yoyohr.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class JsonUtil {
    private ObjectMapper objectMapper = new ObjectMapper();
    JsonGenerator jsonGenerator;

//    public String xmlToJosn(String xml) throws IOException {
//        XmlMapper xmlMapper = new XmlMapper();
//        StringWriter writer = new StringWriter();
//        JsonParser jsonParser = xmlMapper.getFactory().createParser(xml);
//        try {
//            jsonGenerator = objectMapper.getFactory().createGenerator(writer);
//            while (jsonParser.nextToken() != null) {
//                jsonGenerator.copyCurrentEvent(jsonParser);
//            }
//        } finally {
//            jsonParser.close();
//            jsonGenerator.close();
//        }
//        return writer.toString();
//    }

    public static void main(String[] args) throws IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" " +
                "?><users>\n" +
                "  <user>\n" +
                "    <name>admin</name>\n" +
                "  </user>\n" +
                "  <user>admin</user>\n" +
                "</users>";

//        System.out.println(new JsonUtil().xmlToJosn(xml));
    }


}
