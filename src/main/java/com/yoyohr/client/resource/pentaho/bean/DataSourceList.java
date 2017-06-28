package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@XmlRootElement(name="List")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class DataSourceList {
    @XmlElement(name="Item")
    private List<String> itemList;

    public DataSourceList() {
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "DataSourceList{" +
            "itemList=" + itemList +
            '}';
    }
}
