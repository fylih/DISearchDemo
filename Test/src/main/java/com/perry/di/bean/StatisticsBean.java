package com.perry.di.bean;

import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 软著等级撤销分类统计查询
 * Created by lipengjun on 2017/05/05.
 */

public class StatisticsBean extends BaseBean<StatisticsBean> {
    /**
     * "errorCode": "000000",
     * "errorDesc": "",
     * "context": {
     * "ry": [
     */
    public String errorCode;
    public String errorDesc;
    public Context context;

    @Override
    public String toString() {
        return "StatisticsBean{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", context=" + context +
                '}';
    }

    public class Context implements Serializable {
        public ArrayList<VC> ry;//撤销年   ，登记年
        public ArrayList<VC> tcs;//撤销原因  ， 转让方
        public ArrayList<VC> swrn;//原登记者
        public ArrayList<VC> tcss;//受让方

        @Override
        public String toString() {
            return "Context{" +
                    "ry=" + ry +
                    ", tcs=" + tcs +
                    ", swrn=" + swrn +
                    ", tcss=" + tcss +
                    '}';
        }
    }

    public class VC implements Serializable {
        public String title;//
        /**
         * {
         * "value": "2012/01/01",
         * "count": "511"
         * }
         */
        public String value;//
        public String count;

        @Override
        public String toString() {
            return "VC{" +
                    "title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    ", count='" + count + '\'' +
                    '}';
        }
    }

    @Override
    public StatisticsBean parseJSON(JSONObject jsonObj) {
        return null;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public StatisticsBean cursorToBean(Cursor cursor) {
        return null;
    }

    @Override
    public ContentValues beanToValues() {
        return null;
    }
}
