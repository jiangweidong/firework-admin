package cn.fireworkstudio.admin.util;

import cn.fireworkstudio.admin.constant.StringConstant;
import cn.fireworkstudio.admin.enums.ResponseCode;

import java.io.Serializable;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Construct Json Response
 */
public class RespJson implements Serializable {

    /**
     * Response Code
     */
    private String code;

    /**
     * Response Message
     */
    private String msg;

    /**
     * Data Field
     */
    private Object data;

    /**
     * Construct Success Response
     *
     * @param data Data Field
     */
    public static RespJson buildSuccessResponse(Object data) {
        RespJson respJson = new RespJson();
        respJson.setCode(ResponseCode.SUCCESS.getCode());
        respJson.setData(data);
        respJson.setMsg(StringConstant.EMPTY_STRING);
        return respJson;
    }

    /**
     * Construct Failure Response
     *
     * @param errorMsg   Error Message
     */
    public static RespJson buildFailureResponse(String errorMsg) {
        RespJson respJson = new RespJson();
        respJson.setCode(ResponseCode.FAILURE.getCode());
        respJson.setMsg(errorMsg);
        return respJson;
    }

    /**
     * Get code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Set msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Get data
     */
    public Object getData() {
        return data;
    }

    /**
     * Set data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
