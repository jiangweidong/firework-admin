package cn.fireworkstudio.admin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    System menu bean
 */
public class SysMenu implements Serializable {

    /**
     * Module Id
     */
    private Long id;

    /**
     * Module Code
     */
    private String code;

    /**
     * Module Name
     */
    private String name;

    /**
     * Parent Module ID
     */
    private Long parent;

    /**
     * url
     */
    private String url;

    /**
     * AngularJS Controller
     */
    private String controller;

    /**
     * AngularJS Template
     */
    private String template;

    /**
     * Sequence in current module depth
     */
    private Integer orderId;

    /**
     * Sub menu list
     */
    private List<SysMenu> subMenus;

    /**
     * Get id
     */
    @JsonIgnore
    public Long getId() {
        return id;
    }

    /**
     * Set id
     */
    public void setId(Long id) {
        this.id = id;
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
     * Get name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get parent
     */
    public Long getParent() {
        return parent;
    }

    /**
     * Set parent
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * Get url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get controller
     */
    public String getController() {
        return controller;
    }

    /**
     * Set controller
     */
    public void setController(String controller) {
        this.controller = controller;
    }

    /**
     * Get template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Set template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Get orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Set orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Get subMenus
     */
    public List<SysMenu> getSubMenus() {
        return subMenus;
    }

    /**
     * Set subMenus
     */
    public void setSubMenus(List<SysMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
