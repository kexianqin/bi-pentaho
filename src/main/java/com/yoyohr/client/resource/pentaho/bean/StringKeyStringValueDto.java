package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="stringKeyStringValueDto")
@XmlRootElement
public class StringKeyStringValueDto {

    @XmlElement
    private String key;
    @XmlElement
    private String value;

    public StringKeyStringValueDto() {
    }

    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
