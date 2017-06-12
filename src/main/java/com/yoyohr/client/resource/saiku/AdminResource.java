package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yoyohr.client.resource.saiku.bean.SaikuAdminDatasource;
import com.yoyohr.client.resource.saiku.bean.SaikuAdminMondrianSchema;
import com.yoyohr.client.resource.saiku.bean.SaikuAdminUser;
import com.yoyohr.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public class AdminResource extends BaseResource{
    private static final Logger log = LoggerFactory.getLogger(AdminResource.class);

    public static final String ADMIN ="/admin/";

    public AdminResource() {
        super();
    }

    public String getUriOfGetAvailableDataSources(){
        return ADMIN + "datasources";
    }

    public String getUriOfGetAvailableAdminMondrianSchemas(){
        return ADMIN+"schema";
    }

    public String getUriOfGetSavedSchema(String id){
        return ADMIN + "schema"+"/"+id;
    }

    public String getUriOfGetExistingAdminUsers(){
        return ADMIN + "users";
    }
    public String getUriOfGetUserDetails(int id){
        return ADMIN + "users" +"/"+id;
    }

    public List<SaikuAdminDatasource> parseSaikuAdminDatasources(){
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),new TypeReference<List<SaikuAdminDatasource>>() {
        });
    }
    public List<SaikuAdminMondrianSchema> parseSaikuAdminMondrianSchemas(){
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuAdminMondrianSchema>>() {
        });
    }
    public List<SaikuAdminUser> parseSaikuAdminUsers(){
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuAdminUser>>() {
        });
    }
    public SaikuAdminUser parseSaikuAdminUser(){
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),SaikuAdminUser.class);
    }

}
