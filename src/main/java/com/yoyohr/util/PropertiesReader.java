package com.yoyohr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PropertiesReader {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

    private static String filePath = "env.properties";

    private static Properties properties = new Properties();

    static {
        if (System.getProperty("config") != null) {
            filePath = System.getProperty("config");
        }
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStream inputStream = new BufferedInputStream(fis)) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
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
    public static String readValue(String filePath, String key) throws IOException {
        Properties props = new Properties();
        String value = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStream in = new BufferedInputStream(fis)) {
            props.load(in);
            value = props.getProperty(key);
            logger.info(key + "键的值是：" + value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return value;
    }

    /**
     * 更新（或插入）一对properties信息(主键及其键值) 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
     *
     * @param key   键名
     * @param value 键值
     */
    public static void writeProperties(String key, String value) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            properties.load(new BufferedInputStream(fis));
            // 调用 HashTable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 HashTable 调用 put 的结果。
            properties.setProperty(key, value);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            properties.store(fos, "Update '" + key + "' value");
        } catch (IOException e) {
            logger.error("属性文件更新错误", e);
        }
    }

}

