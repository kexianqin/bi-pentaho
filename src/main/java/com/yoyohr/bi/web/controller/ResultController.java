package com.yoyohr.bi.web.controller;

import com.yoyohr.bi.bean.Result;
import com.yoyohr.client.SaikuClient;
import com.yoyohr.client.UnanthenticatedException;
import com.yoyohr.client.resource.saiku.query.Cell;
import com.yoyohr.client.resource.saiku.query.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@RestController
public class ResultController {
    private static Logger log= LoggerFactory.getLogger(ResultController.class);


    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public List<Result> index() throws UnanthenticatedException, IOException, URISyntaxException {
        List<Result> results = new ArrayList<>();
        SaikuClient client = new SaikuClient();
        String mdx="WITH\n" +
            "SET [~ROWS] AS\n" +
            "    {[enterprise.enterprise].[enterprise_name].Members}\n" +
            "SELECT\n" +
            "NON EMPTY {[Measures].[action_key]} ON COLUMNS,\n" +
            "NON EMPTY [~ROWS] ON ROWS\n" +
            "FROM [youpin_dwh]\n" +
            "where [operator.operator].[operator_name].[帅建]";
        String cubeUniqueName="[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]";
        QueryResult queryResult= client.executeSaikuQuery( cubeUniqueName,mdx);
        List<Cell[]> cellset=queryResult.getCellset();
        for(int i=0;i<cellset.size();i++) {
            Result result = new Result();
            for (Cell ce : cellset.get(i)) {
                log.info(ce.getType());
                log.info(ce.getValue());
                if(ce.getType().equals(Cell.Type.ROW_HEADER.toString())) {
                    result.setName(ce.getValue());
                }
                if(ce.getType().equals(Cell.Type.DATA_CELL.toString())) {
                    result.setValue(Integer.parseInt(ce.getValue()));
                }
            }
            if(result.getName()!=null){
                results.add(result);
            }
        }
        return results;
    }
}
