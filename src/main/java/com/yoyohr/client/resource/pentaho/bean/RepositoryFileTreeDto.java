package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="repositoryFileTreeDto",propOrder = {})
public class RepositoryFileTreeDto {

    @XmlElement(name="children")
    private List<Children> childrenList;

    @XmlElement(name="file")
    private File file;

    public RepositoryFileTreeDto() {
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "RepositoryFileTreeDto{" +
            "childrenList=" + childrenList +
            ", file=" + file +
            '}';
    }
}
