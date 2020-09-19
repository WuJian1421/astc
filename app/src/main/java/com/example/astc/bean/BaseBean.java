package com.example.astc.bean;

/**
 * 基本返回对象类
 * 2020-01-16
 *
 * @author
 */
public class BaseBean {

    /**
     * code : 200
     * message : 成功
     * page : null
     * data : null
     */

    private int code;
    private String message;
    private Object page;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
