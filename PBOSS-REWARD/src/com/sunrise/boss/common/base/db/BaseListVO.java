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
 * <p>Description: ListVO基类. 支持动态条件。</p>
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
    
	private static final long serialVersionUID = -4795615512992486279L;  //序列化唯一标识
	
    private String _pageno = SysInfo.getInstance().getPageNo();// WebConstant.DEFAULT_PAGE;
    private String _pagesize = String.valueOf(SysInfo.getInstance().getPageSize());// WebConstant.DEFAULT_LINES_PER_PAGE;

    private String _orderby;
    private String _desc;
    private String _datasize;
    private String _firstitems;
    
    private Map queryConditions = new HashMap(4);
    
    /**
     * hekun 仅使用固定参数。即只按照named sql query中定义的固定参数，
     * 根据listVO属性和 queryConditions参数设置其值，而不会追加 _se_xxx 这样的动态参数
     */
    private boolean useFixedParamOnly; 
    /**
     * 用于设定查询时，只查询哪些字段，注意须设定实际的字段名称
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
     * 使用动态查询参数。语法规则不变。添加条件时不需要给类添加属性，以Map形式添加即可。
     * 例如：
     * getQueryConditions.put("_sk_oprcode","example");
     * getQueryConditions.put("_ne_logid",new Long(1232));
     * 当既有 静态条件值，又有动态条件值时，以静态为优先。
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
     * 用于设定查询时，只查询哪些字段，注意须设定实际的字段名称
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
