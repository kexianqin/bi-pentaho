package com.yoyohr.client.resource.saiku.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class AbstractSaikuObject implements ISaikuObject, Comparable<ISaikuObject> {

    private String uniqueName;
    private String name;

    AbstractSaikuObject() {
    }

    AbstractSaikuObject(String uniqueName, String name) {
        this.uniqueName = uniqueName;
        this.name = name;
    }

    @Override
    public String getUniqueName() {
        return uniqueName;
    }

    @Override
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uniqueName == null) ? 0 : uniqueName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractSaikuObject other = (AbstractSaikuObject) obj;
        if (uniqueName == null) {
            if (other.uniqueName != null) {
                return false;
            }
        } else if (!uniqueName.equals(other.uniqueName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.uniqueName;
    }

    public int compareTo(ISaikuObject o) {
        return getUniqueName().compareTo(o.getUniqueName());
    }
}
