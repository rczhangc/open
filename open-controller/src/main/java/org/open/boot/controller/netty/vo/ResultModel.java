package org.open.boot.controller.netty.vo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author barnak
 */
public class ResultModel {

    private String errorCode;
    private String message;
    private Object data;

    public ResultModel() {

    }

    public ResultModel(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultModel(String errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String geterrorCode() {
        return errorCode;
    }

    public void seterrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultModel ok() {
        return new ResultModel("0000","成功");
    }

    public static ResultModel ok(Object data) {
        return new ResultModel("0000","成功", data);
    }

    public static ResultModel error() {
        return new ResultModel("1111","失败");
    }

    public static ResultModel error(String msg) {
        return new ResultModel("1111","失败", msg);
    }

    public static ResultModel error(String msg, Object data) {
        return new ResultModel("1111", msg, data);
    }

    public static void main(String[] args) {
        int x;
        int y;
        List<S> sList = new ArrayList<>();
        for (x = 0; x<1000;x++) {
            for (y = 0 ; y < 1000 ; y++) {
                if (x*7 - y*11 - 2 == 0) {
                    S s = new S();
                    s.setX(x);
                    s.setY(y);
                    sList.add(s);
                }
            }
        }
        for (S s: sList) {
            System.out.println(JSON.toJSONString(s));
        }

    }

    static class S {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
