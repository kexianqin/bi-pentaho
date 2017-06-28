package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.resource.pentaho.bean.*;

import com.yoyohr.util.JsonUtil;
import com.yoyohr.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/20.
 */
public class FileResouce extends BaseResource{

    private static final Logger log = LoggerFactory.getLogger(FileResouce.class);

    public static final String PENTAHO_API = API+"/repo/files";


    public RepositoryFileDto parseRepositoryFileDto() throws IOException{
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),RepositoryFileDto.class);
    }

    public RepositoryFileDtoes parseRepositoryFileDtoes() throws IOException{
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),RepositoryFileDtoes.class);
    }

    public RepositoryFileTreeDto parseRepositoryFileTreeDto() throws IOException{
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),RepositoryFileTreeDto.class);
    }
    public RepositoryFileAclDto parseRepositoryFileAclDto() throws IOException{
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),RepositoryFileAclDto.class);
    }
    public StringKeyStringValueDtos parseStringKeyStringValueDtos() throws  IOException{
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),StringKeyStringValueDtos.class);
    }

}
