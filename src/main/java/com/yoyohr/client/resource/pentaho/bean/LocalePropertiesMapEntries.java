package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="localePropertiesMapEntries",propOrder = {})
public class LocalePropertiesMapEntries {

    @XmlElement
    private String locale;

    @XmlElement(name="properties")
    private List<Properties> propertiesList;

    public LocalePropertiesMapEntries() {
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @Override
    public String toString() {
        return "LocalePropertiesMapEntries{" +
            "locale='" + locale + '\'' +
            ", propertiesList=" + propertiesList +
            '}';
    }
}
