package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="stringKeyStringValueDtos")
@XmlRootElement
public class StringKeyStringValueDtos {
    @XmlElement
    private List<StringKeyStringValueDto> stringKeyStringValueDto;

    public StringKeyStringValueDtos() {
    }

    public List<StringKeyStringValueDto> getStringKeyStringValueDto() {
        return stringKeyStringValueDto;
    }

    public void setStringKeyStringValueDto(List<StringKeyStringValueDto> stringKeyStringValueDto) {
        this.stringKeyStringValueDto = stringKeyStringValueDto;
    }

    @Override
    public String toString() {
        return "StringKeyStringValueDtos{" +
            "stringKeyStringValueDto=" + stringKeyStringValueDto +
            '}';
    }
}
