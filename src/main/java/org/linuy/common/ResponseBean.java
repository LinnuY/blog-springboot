package org.linuy.common;

/**
 * @author LongTeng
 * @date 2022/06/07
 **/
public class ResponseBean {
    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MESSAGE = "OK";
    private static final String ERROR_CODE = "-1";
    private static final String ERROR_MESSAGE = "ERROR";

    String code;
    String message;
    Object data;

    public ResponseBean() {
    }

    public ResponseBean(String code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseBean addSuccess() {
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
        return this;
    }

    public ResponseBean addSuccess(Object data) {
        this.data = data;
        return this.addSuccess();
    }

    public ResponseBean addError() {
        this.code = ERROR_CODE;
        this.message = ERROR_MESSAGE;
        return this;
    }

    public ResponseBean addError(String message) {
        this.code = ERROR_CODE;
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
