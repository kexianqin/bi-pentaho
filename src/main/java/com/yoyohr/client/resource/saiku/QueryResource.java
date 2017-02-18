package com.yoyohr.client.resource.saiku;

import com.yoyohr.client.resource.saiku.bean.SaikuCube;
import com.yoyohr.client.resource.saiku.query.Query;
import com.yoyohr.client.resource.saiku.query.QueryResult;
import com.yoyohr.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class QueryResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(QueryResource.class);

    public static final String QUERY = "/api/query/";

    public String getUriOfExecuteQuery() {
        return QUERY + "execute";
    }

    public String constructQueryJson(String cubeUniqueName, String mdx) {
        Query query = new Query();
        query.setCube(getSaikuCube(cubeUniqueName));
        query.setMdx(mdx);
        return query.toJson();
    }

    public QueryResult parseQueryResult() {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), QueryResult.class);
    }

    private SaikuCube getSaikuCube(String cubeUniqueName) {
        String[] names = cubeUniqueName.replaceAll("\\[", "").replaceAll("]", "").split("\\.");
        return new SaikuCube(names[0], cubeUniqueName, names[3], null, names[1], names[2]);
    }

}
