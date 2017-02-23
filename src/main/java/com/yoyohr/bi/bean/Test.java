package com.yoyohr.bi.bean;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.pentaho.di.core.SourceToTargetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static mondrian.server.MondrianServerRegistry.logger;

/**
 * Created by Administrator on 2017/2/18.
 */
public class Test {
    private static String jsonUser ="{\"id\":1,\"name\":\"kexianqin\"}";
    private static String jsonUserArray ="[{\"id\":1,\"name\":\"kexianqin\"},{\"id\":2,\"name\":\"liuchen\"}]";

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {

        logger.info("Test begin........");
         /**
         使用JavaType方法
          */
//        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,UserT.class);
//        List<UserT> userList = objectMapper.readValue(jsonUserArray,javaType);
//        System.out.println(userList);

        /**
         TypeReference：可以把json字符串转换成想要的List.
        注意readValue()方法里的new TypeReference<List<UserT>>() { }写法很关键，写成List.class是不行的，
         */
//         List<UserT> userlist = objectMapper.readValue(jsonUserArray,new TypeReference<List<UserT>>(){});// 若无toString方法：[com.yoyohr.bi.bean.UserT@58651fd0, com.yoyohr.bi.bean.UserT@4520ebad]
//         List userlist2 = objectMapper.readValue(jsonUserArray,new TypeReference<List>() { });// [{id=1, name=kexianqin}, {id=2, name=liuchen}]
//         System.out.println(userlist);
//         System.out.println(userlist2);

        /**
         最普通的
         */
        UserT user=objectMapper.readValue(jsonUser,UserT.class);//json转化为UserT类对象
        System.out.print(user.toString());
//        String jsonString=objectMapper.writeValueAsString(user);//对象转化为json
//        System.out.println(jsonString);


        /**
            类中含类，如cube中包含多个dimension,:{"users":[{"id":3,"name":"kxq"},{"id":4,"name":"lc"}],"dname":"体育经济Q1241"}
         */
//        UserT user1 = new UserT();
//        user1.setId(3);
//        user1.setName("kxq");
//
//        UserT user2 = new UserT();
//        user2.setId(4);
//        user2.setName("lc");
//
//        Department class1=new Department();
//        class1.setDname("体育经济Q1241");
//        List<UserT> listUser=new ArrayList();
//        listUser.add(user1); listUser.add(user2);
//        class1.setUsers(listUser);
//
//        String jsonString = objectMapper.writeValueAsString(class1);
        //System.out.println(jsonString);

//        String jsonString="{\"users\":[{\"id\":3,\"name\":\"kxq\"},{\"id\":4,\"name\":\"lc\"}],\"dname\":\"体育经济Q1241\"}";
//        Department class1=objectMapper.readValue(jsonString,Department.class);
//        System.out.println(class1.getUsers().get(0).getName());

        /**
         * 调用下面的方法<即最终方法>
         */
//        System.out.println(decode(jsonUser,UserT.class));
//        System.out.println(decode(jsonUserArray,new TypeReference<List<UserT>>(){}));//！！！！！！！！！！！！！{ }是干什么用的？？
    }


    /**
     * 将对象序列化
     * @param obj
     * @return
     */
//    public static String encode(Object obj) {
//        try {
//            return objectMapper.writeValueAsString(obj);
//        } catch (JsonGenerationException e) {
//            logger.error("encode(Object)", e); //$NON-NLS-1$
//        } catch (JsonMappingException e) {
//            logger.error("encode(Object)", e); //$NON-NLS-1$
//        } catch (IOException e) {
//            logger.error("encode(Object)", e); //$NON-NLS-1$
//        }
//        return null;
//    }
//    /**
//     * 将json string反序列化成对象
//     *
//     * @param json
//     * @param valueType
//     * @return
//     */
//    public static <T> T decode(String json, Class<T> valueType ) {
//        try {
//            return objectMapper.readValue(json, valueType);
//        } catch (JsonParseException e) {
//            logger.error("decode(String, Department<T>)", e);
//        } catch (JsonMappingException e) {
//            logger.error("decode(String, Department<T>)", e);
//        } catch (IOException e) {
//            logger.error("decode(String, Department<T>)", e);
//        }
//        return null;
//    }
//
//    /**
//     * 将json array反序列化为对象
//     *
//     * @param json
//     * @param jsonTypeReference
//     * @return
//     */
//    public static <T> T decode(String json, TypeReference<T> jsonTypeReference) {
//        try {
//            return (T) objectMapper.readValue(json, jsonTypeReference);
//        } catch (JsonParseException e) {
//            logger.error("decode(String, JsonTypeReference<T>)", e);
//        } catch (JsonMappingException e) {
//            logger.error("decode(String, JsonTypeReference<T>)", e);
//        } catch (IOException e) {
//            logger.error("decode(String, JsonTypeReference<T>)", e);
//        }
//        return null;
//    }

}
