package com.yoyohr.client.resource.saiku.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface ISaikuObject {

    String getUniqueName();

    void setUniqueName(String uniqueName);

    String getName();

    void setName(String name);

    int hashCode();

    boolean equals(Object obj);

    String toString();
}
