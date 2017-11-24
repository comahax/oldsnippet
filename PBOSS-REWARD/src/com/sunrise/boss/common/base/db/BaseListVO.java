package com.sunrise.boss.common.base.db;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;

/**
 * <p>Title: BaseListVO</p>
 *
 * <p>Description: ListVO����. ֧�ֶ�̬������</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author HuangBaiming
 * @author He Kun
 *
 * @version 1.0
 */
public class BaseListVO implements Serializable {
    
	private static final long serialVersionUID = -4795615512992486279L;  //���л�Ψһ��ʶ
	
    private String _pageno = SysInfo.getInstance().getPageNo();// WebConstant.DEFAULT_PAGE;
    private String _pagesize = String.valueOf(SysInfo.getInstance().getPageSize());// WebConstant.DEFAULT_LINES_PER_PAGE;

    private String _orderby;
    private String _desc;
    private String _datasize;
    private String _firstitems;
    
    private Map queryConditions = new HashMap(4);
    
    /**
     * hekun ��ʹ�ù̶���������ֻ����named sql query�ж���Ĺ̶�������
     * ����listVO���Ժ� queryConditions����������ֵ��������׷�� _se_xxx �����Ķ�̬����
     */
    private boolean useFixedParamOnly; 
    /**
     * �����趨��ѯʱ��ֻ��ѯ��Щ�ֶΣ�ע�����趨ʵ�ʵ��ֶ�����
     */
    private List selectFields = null;

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String get_orderby() {
        return _orderby;
    }

    public void set_orderby(String _orderby) {
        this._orderby = _orderby;
    }

    public String get_pageno() {
        return _pageno;
    }

    public void set_pageno(String _pageno) {
        this._pageno = _pageno;
    }

    public String get_pagesize() {
        return _pagesize;
    }

    public String get_datasize() {
        return _datasize;
    }

    public void set_pagesize(String _pagesize) {
        this._pagesize = _pagesize;
    }

    public void set_datasize(String _datasize) {
        this._datasize = _datasize;
    }

    public void setAscending(boolean ascending)
    {
    	this._desc = ascending ? "0" : "1";
    }
    
    public boolean isAscending()
    {
    	return "0".equals(_desc);
    }
    
    /**
     * ʹ�ö�̬��ѯ�������﷨���򲻱䡣�������ʱ����Ҫ����������ԣ���Map��ʽ��Ӽ��ɡ�
     * ���磺
     * getQueryConditions.put("_sk_oprcode","example");
     * getQueryConditions.put("_ne_logid",new Long(1232));
     * ������ ��̬����ֵ�����ж�̬����ֵʱ���Ծ�̬Ϊ���ȡ�
     * @return
     * @author He Kun
     */
	public Map getQueryConditions() {
		return queryConditions;
	}

	public void setQueryConditions(Map queryConditions) {
		this.queryConditions = queryConditions;
	}

	public String get_firstitems() {
		return _firstitems;
	}

	public void set_firstitems(String _firstitems) {
		this._firstitems = _firstitems;
	}

    /**
     * �����趨��ѯʱ��ֻ��ѯ��Щ�ֶΣ�ע�����趨ʵ�ʵ��ֶ�����
     */
    public List getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List selectFields) {
        this.selectFields = selectFields;
    }

	public boolean isUseFixedParamOnly() {
		return useFixedParamOnly;
	}

	public void setUseFixedParamOnly(boolean useFixedParamOnly) {
		this.useFixedParamOnly = useFixedParamOnly;
	}
}
