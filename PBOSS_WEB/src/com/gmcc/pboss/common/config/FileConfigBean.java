package com.gmcc.pboss.common.config;

import java.io.Serializable;

/**
 * Copyright(C)  广州从兴电子开发有限公司-电子渠道业务部
 *
 * Module: 文件配置的基本信息对象类
 * @author libo
 * @version
 * @see
 * @since 2008-11-17
 * @description: <描述>
 * @log: <重大修改日志，格式：YYYYMMDD 修改内容>
 */
public class FileConfigBean implements Serializable {
    
    private static final long serialVersionUID = 94785321625118001L;
    
    /**
     * 文件编码
     */
    private String code;
    
    /**
     * 文件状态
     */
    private int status;
    
    /**
     * 文件名称
     */
    private String name;
    
    /**
     * 文件路径
     */
    private String path;
    
    /**
     * 文件类型
     */
    private String type;
    
    /**
     * 更新类型
     */
    private String updateType;
    
    /**
     * 更新时间
     */
    private int updateTime;
    
    private int isByBranch;
    
    private int isDefault;
    
    private String defaultBranch;
    
    /**
     * 文件描述
     */
    private String description;
    
    /**
     * 上次修改时间
     */
    private long lastModified;
    
    public FileConfigBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDefaultBranch() {
        return defaultBranch;
    }
    
    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getIsByBranch() {
        return isByBranch;
    }
    
    public void setIsByBranch(int isByBranch) {
        this.isByBranch = isByBranch;
    }
    
    public int getIsDefault() {
        return isDefault;
    }
    
    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public int getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getUpdateType() {
        return updateType;
    }
    
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
    
    public long getLastModified() {
        return lastModified;
    }
    
    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
    
}
