package com.yoyohr.utils;

import java.io.*;
import java.util.Properties;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PropertiesReader {

    private static String filePath = "env.properties";

    private static Properties properties = new Properties();

    static {
        try {
            if (System.getProperty("config") != null) {
                filePath = System.getProperty("config");
            }
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    /**
     * 读取属性文件中相应键的值
     *
     * @param key 主键
     * @return String
     */
    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    /**
     * 根据主键key读取主键的值value
     *
     * @param filePath 属性文件路径
     * @param key      键名
     */
    public static String readValue(String filePath, String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            String value = props.getProperty(key);
            System.out.println(key + "键的值是：" + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新（或插入）一对properties信息(主键及其键值) 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
     *
     * @param key   键名
     * @param value 键值
     */
    public static void writeProperties(String key, String value) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            properties.load(new BufferedInputStream(fis));
            // 调用 HashTable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 HashTable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filePath);
            properties.setProperty(key, value);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            properties.store(fos, "Update '" + key + "' value");
        } catch (IOException e) {
            System.err.println("属性文件更新错误");
        }
    }

    public static void main(String[] args) {
        System.out.println(properties.toString());
    }

}

