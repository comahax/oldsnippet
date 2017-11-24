package com.gmcc.pboss.common.config;

import java.io.Serializable;

/**
 * Copyright(C)  ���ݴ��˵��ӿ������޹�˾-��������ҵ��
 *
 * Module: �ļ����õĻ�����Ϣ������
 * @author libo
 * @version
 * @see
 * @since 2008-11-17
 * @description: <����>
 * @log: <�ش��޸���־����ʽ��YYYYMMDD �޸�����>
 */
public class FileConfigBean implements Serializable {
    
    private static final long serialVersionUID = 94785321625118001L;
    
    /**
     * �ļ�����
     */
    private String code;
    
    /**
     * �ļ�״̬
     */
    private int status;
    
    /**
     * �ļ�����
     */
    private String name;
    
    /**
     * �ļ�·��
     */
    private String path;
    
    /**
     * �ļ�����
     */
    private String type;
    
    /**
     * ��������
     */
    private String updateType;
    
    /**
     * ����ʱ��
     */
    private int updateTime;
    
    private int isByBranch;
    
    private int isDefault;
    
    private String defaultBranch;
    
    /**
     * �ļ�����
     */
    private String description;
    
    /**
     * �ϴ��޸�ʱ��
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
