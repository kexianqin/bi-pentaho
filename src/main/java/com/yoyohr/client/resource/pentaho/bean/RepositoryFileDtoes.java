package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="repositoryFileDtoes",propOrder = {})
public class RepositoryFileDtoes {

    @XmlElement(name="repositoryFileDto")
    private List<RepositoryFileDto> repositoryFileDtoList;

    public RepositoryFileDtoes() {
    }

    public List<RepositoryFileDto> getRepositoryFileDtoList() {
        return repositoryFileDtoList;
    }

    public void setRepositoryFileDtoList(List<RepositoryFileDto> repositoryFileDtoList) {
        this.repositoryFileDtoList = repositoryFileDtoList;
    }

    @Override
    public String toString() {
        return "RepositoryFileDtoes{" +
            "repositoryFileDtoList=" + repositoryFileDtoList +
            '}';
    }
}
