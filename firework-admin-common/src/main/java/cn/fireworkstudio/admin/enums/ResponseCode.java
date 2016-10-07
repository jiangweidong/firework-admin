package cn.fireworkstudio.admin.enums;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Response Code
 */
public enum ResponseCode {

    FAILURE("0", "Failure"),
    SUCCESS("1", "Success"),;

    /**
     * enum code
     */
    private final String code;

    /**
     * enum description
     */
    private final String desc;

    /**
     * Constructor
     */
    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Get code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get desc
     */
    public String getDesc() {
        return desc;
    }
}
