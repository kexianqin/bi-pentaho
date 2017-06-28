package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.resource.pentaho.bean.DataSourceList;
import com.yoyohr.client.resource.pentaho.bean.DatabaseConnectionJ;
import com.yoyohr.client.resource.pentaho.bean.DatabaseConnectionX;
import com.yoyohr.util.JsonUtil;
import com.yoyohr.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/26.
 */
public class JdbcResource extends BaseResource {
    private static final Logger log = LoggerFactory.getLogger(JdbcResource.class);

    public static final String PENTAHO_API = PLUGIN + "/data-access/api/datasource/jdbc/connection";

    public DataSourceList parseDataSourceList() throws IOException {
        log.info(response.getData());
        return XmlUtil.converyToJavaBean(response.getData(),DataSourceList.class);
    }

    public DatabaseConnectionJ parseDatabaseConnection() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),DatabaseConnectionJ.class);
    }

}

