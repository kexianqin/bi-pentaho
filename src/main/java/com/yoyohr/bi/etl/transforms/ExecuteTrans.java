package com.yoyohr.bi.etl.transforms;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class ExecuteTrans {

    public static void main(String[] args) throws Exception {
        String fileName = "data/count_actions.ktr";

        KettleEnvironment.init();

        TransMeta transMeta = new TransMeta(fileName);
        Trans trans = new Trans(transMeta);
        trans.prepareExecution(null);
        trans.startThreads();
        trans.waitUntilFinished();

        if (trans.getErrors()!=0) {
            System.out.println("Error");
        }
    }
}
