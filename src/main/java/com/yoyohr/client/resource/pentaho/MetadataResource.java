package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.resource.pentaho.bean.DataSourceList;
import com.yoyohr.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/27.
 */
public class MetadataResource extends BaseResource {
    private static final Logger log = LoggerFactory.getLogger(MetadataResource.class);

    public static final String PENTAHO_API = PLUGIN + "/data-access/api/datasource/metadata/domain";

    public DataSourceList parseDataSourceList() throws IOException {
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),DataSourceList.class);
    }

}
