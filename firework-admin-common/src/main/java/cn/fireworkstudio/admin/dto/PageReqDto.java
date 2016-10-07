package cn.fireworkstudio.admin.dto;

import java.io.Serializable;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Request with pagination support
 */
public class PageReqDto implements Serializable {

    /**
     * Request Id
     */
    private Integer reqId;

    /**
     * First param of Limit a, b
     */
    private Integer start;

    /**
     * Second param of Limit a, b
     */
    private Integer rows;

    public PageReqDto() {
    }

    public PageReqDto(Integer reqId, Integer start, Integer rows) {
        this.reqId = reqId;
        this.start = start;
        this.rows = rows;
    }

    /**
     * Get reqId
     */
    public Integer getReqId() {
        return reqId;
    }

    /**
     * Set reqId
     */
    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    /**
     * Get start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Set start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * Get rows
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * Set rows
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
