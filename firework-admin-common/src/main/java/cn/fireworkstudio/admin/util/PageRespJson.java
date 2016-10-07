package cn.fireworkstudio.admin.util;

import cn.fireworkstudio.admin.constant.StringConstant;
import cn.fireworkstudio.admin.enums.ResponseCode;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Construct Json Response with pagination support
 */
public class PageRespJson extends RespJson {

    /**
     * Request Id used by Datatables
     */
    private long reqId;

    /**
     * Total Records
     */
    private long recordsTotal;

    /**
     * Construct Success Response
     *
     * @param data         Data Field
     * @param reqId        Request ID
     * @param totalRecords Total Records
     */
    public static PageRespJson buildSuccessResponse(Object data, Long reqId, Long totalRecords) {
        PageRespJson respJson = new PageRespJson();
        respJson.setCode(ResponseCode.SUCCESS.getCode());
        respJson.setData(data);
        respJson.setMsg(StringConstant.EMPTY_STRING);
        respJson.setReqId(reqId);
        respJson.setRecordsTotal(totalRecords);
        return respJson;
    }

    /**
     * Construct Failure Response
     *
     * @param errorMsg     Error Message
     * @param reqId        Request ID
     */
    public static PageRespJson buildFailureResponse(String errorMsg, Long reqId) {
        PageRespJson respJson = new PageRespJson();
        respJson.setCode(ResponseCode.FAILURE.getCode());
        respJson.setMsg(errorMsg);
        respJson.setReqId(reqId);
        respJson.setRecordsTotal(0L);
        return respJson;
    }

    /**
     * Get reqId
     */
    public long getReqId() {
        return reqId;
    }

    /**
     * Set reqId
     */
    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    /**
     * Get recordsTotal
     */
    public long getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * Set recordsTotal
     */
    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
