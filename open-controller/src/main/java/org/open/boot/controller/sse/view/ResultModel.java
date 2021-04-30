package org.open.boot.controller.sse.view;

/**
 * @author barnak
 */
public class ResultModel {

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultModel error(String message) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode("-1");
        resultModel.setMessage(message);
        return resultModel;
    }

    public static ResultModel ok() {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode("0");
        resultModel.setMessage("成功");
        return resultModel;
    }
}
