package com.perry.di.bean;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 软著专用许可合同等级公告检索
 * 软著等级撤销检索
 * 作品著作权检索
 * <p>
 * Created by lipengjun on 2017/05/05.
 */

public class ExpressionBean extends BaseBean<ExpressionBean> {
    /**
     * "errorCode": "000000",
     * "errorDesc": "",
     * "page_row": "50",
     * "page": "1",
     * "total": "2559",
     * "sort_column": "",
     * "context": {
     * "records": [
     * {
     * "rn": "2011SR054494",
     */
    public String errorCode;
    public String errorDesc;
    public String page_row;
    public String page;
    public String total;
    public String sort_column;
    public Context context;

    @Override
    public String toString() {
        return "ExpressionBean{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", page_row='" + page_row + '\'' +
                ", page='" + page + '\'' +
                ", total='" + total + '\'' +
                ", sort_column='" + sort_column + '\'' +
                ", context=" + context +
                '}';
    }

    public class Context implements Serializable {
        public ArrayList<Record> records;

        @Override
        public String toString() {
            return "Context{" +
                    "records=" + records +
                    '}';
        }
    }

    public class Record implements Serializable {
        /**
         * "tcss": "上海紫光北美信息科技有限公司",
         * "slid": "B442122805A1D3992DA4910E3301B30E",
         * "tcs": "上海天智计算机图形有限公司",
         * <p>
         * <p>
         * "swnm": "金属管件模具设计软件V1.0",
         * "tcs": "原登记者不是著作权人。",
         * "swrn": "河北省盐山县电力管件有限公司",
         * "scid": "94B1F675B8C6D0FE18E6C6B7C5D29506"
         * <p>
         * <p>
         * "fpy": "2014/01/01 00:00:00",
         * "fy": "2014/01/01 00:00:00",
         * "type": "美术",
         * "fd": "2014/04/28 00:00:00",
         * "pd": "2016/05/05 00:00:00",
         * "py": "2016/01/01 00:00:00",
         * "fpd": "2014/05/29 00:00:00",
         * "szid": "5EF7CBA3C90D47B55B32DDC8B5AFE48D",
         * "owner": "广州黄牛牛电器有限公司",
         * "anm": "Niuniu Electricol 牛牛电器 logo",
         */
        public String tcss;//
        public String slid;

        public String swnm;//
        public String tcs;
        public String swrn;
        public String scid;

        public String fpy;//
        public String rn;
        public String fy;
        public String type;
        public String fd;
        public String rd;
        public String pd;
        public String py;
        public String fpd;//
        public String szid;
        public String owner;
        public String anm;
        public String ry;

        @Override
        public String toString() {
            return "Record{" +
                    "tcss='" + tcss + '\'' +
                    ", slid='" + slid + '\'' +
                    ", swnm='" + swnm + '\'' +
                    ", tcs='" + tcs + '\'' +
                    ", swrn='" + swrn + '\'' +
                    ", scid='" + scid + '\'' +
                    ", fpy='" + fpy + '\'' +
                    ", rn='" + rn + '\'' +
                    ", fy='" + fy + '\'' +
                    ", type='" + type + '\'' +
                    ", fd='" + fd + '\'' +
                    ", rd='" + rd + '\'' +
                    ", pd='" + pd + '\'' +
                    ", py='" + py + '\'' +
                    ", fpd='" + fpd + '\'' +
                    ", szid='" + szid + '\'' +
                    ", owner='" + owner + '\'' +
                    ", anm='" + anm + '\'' +
                    ", ry='" + ry + '\'' +
                    '}';
        }
    }

    @Override
    public ExpressionBean parseJSON(JSONObject jsonObj) {
        return null;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public ExpressionBean cursorToBean(Cursor cursor) {
        return null;
    }

    @Override
    public ContentValues beanToValues() {
        return null;
    }
}
