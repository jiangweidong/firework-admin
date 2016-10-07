package cn.fireworkstudio.admin.enums;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Gender
 */
public enum Gender {

    MALE(1, "Male"),
    FEMALE(2, "Female"),;

    /**
     * enum code
     */
    private final Integer code;

    /**
     * enum description
     */
    private final String desc;

    /**
     * Constructor
     */
    Gender(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Get code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Get desc
     */
    public String getDesc() {
        return desc;
    }
}
