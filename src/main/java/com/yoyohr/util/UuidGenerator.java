package com.yoyohr.util;

import java.util.UUID;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class UuidGenerator {

    /**
     * 随机生成UUID
     *
     * @return
     */
    public static String generate() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(UuidGenerator.generate());
    }
}
