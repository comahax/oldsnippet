package com.sunrise.jop.infrastructure.db;

import java.io.Serializable;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;


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
public class DBQueryParam implements Serializable {
    
	private static final long serialVersionUID = -4795615512992486279L;  //序列化唯一标识

	//当前是页码
    private String _pageno = CoreConfigInfo.DEFAULT_PAGE;
    //每页多少行
    private String _pagesize = String.valueOf(CoreConfigInfo.DEFAULT_PAGE_SIZE);

    //排序字段
    private String _orderby;
    //升序，降序
    private String _desc;
    private boolean ascending = true;
    //返回的数据数目
    private String _datasize;
    private String _firstitems;
    
    //列举出只需要查询的字段名称
    private List selectFields;
    
//  列举出只需要查询的字段名称
    private String selectFieldsString;
    /**
     * hekun 返回的部分字段的java class类型，只需设置VO中没有的属性的类型
     * Map fieldClass = new HashMap();
	   fieldClass.put("companystate", Short.class);
	   param.setSelectFieldsClass(fieldClass);
     */
    private Map selectFieldsClass;
    
    /**
     * hekun 设置部分字段查询时返回的元素使用VO类型，默认使用Map类型，以节省资源. 注意，必须保证部分字段都是vo的属性，否则仍然会Map类型
     */
    private boolean selectFieldsUseVOType;
    
    //查询条件, 主要设置固定参数，也可设置形如：_se_xxx的动态参数
    private Map queryConditions ;

    //web层使用的属性，标识已选中的对象, //hekun: 为所选中的对象的主键集合，按逗号分隔
    private String[] _selectitem;
    
    //是否使用快速查询，即查询时不进行数据总数的查询(select count(*) from )
    private boolean countOnly;
    
//  是否使用快速查询，即查询时不进行数据总数的查询(select count(*) from ),true时只查询数据
    private boolean dataOnly;
    
    //不分页，查询所有数据，等价于 _pagesize =0 。默认是分页的。
    private boolean queryAll; 
    
    private String nameSql;
    
    private boolean queryByNameSql = false;
    
    /**
     * hekun 仅使用固定参数。即只按照named sql query中定义的固定参数，
     * 根据listVO属性和 queryConditions参数设置其值，而不会追加 _se_xxx 这样的动态参数
     */
    private boolean useFixedParamOnly; 
    
    private String _pk;
    
    //BOSS1.5无用的方法,但是引入了1.5的JavaScript,所以暂时加上无意义的这两个属性,以防后台频繁报错
    private String goto_page;
    private String _queryexpress;
    
    private String startindex;
	private String endindex;
	
	public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
        this.ascending = !"1".equals(_desc); //不为降序则都看作升序。
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
    	this.ascending = ascending;
    }
    
    public boolean isAscending()
    {
    	return ascending;
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
		if(this.queryConditions == null)
			this.queryConditions = new LinkedHashMap();
		return this.queryConditions;
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

	public List getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(List selectFields) {
		this.selectFields = selectFields;
		if(selectFields!=null) {
			StringBuffer buffer = new StringBuffer(32);
			for (int i = 0; i < selectFields.size(); i++) {
				buffer.append(selectFields.get(i));
				if(i < selectFields.size() - 1)
					buffer.append(",");
			}
			this.selectFieldsString = buffer.toString();
		}
	}    
	

	
    public String[] get_selectitem() {
        return _selectitem;
    }

    public void set_selectitem(String[] _selectitem) {
        this._selectitem = _selectitem;
    }

    public String get_pk() {
		return _pk;
	}

	public void set_pk(String _pk) {
		this._pk = _pk;
	}

	public boolean isCountOnly() {
		return countOnly;
	}

	public void setCountOnly(boolean countOnly) {
		this.countOnly = countOnly;
	}

	public boolean isQueryAll() {
		return queryAll;
	}

	public void setQueryAll(boolean queryAll) {
		if(queryAll) 
			_pagesize = "0";
		this.queryAll = queryAll;
	}

	public boolean isUseFixedParamOnly() {
		return useFixedParamOnly;
	}

	public void setUseFixedParamOnly(boolean useFixedParamOnly) {
		this.useFixedParamOnly = useFixedParamOnly;
	}

	public Map getSelectFieldsClass() {
		return selectFieldsClass;
	}

	public void setSelectFieldsClass(Map selectFieldsClass) {
		this.selectFieldsClass = selectFieldsClass;
	}

	public String getSelectFieldsString() {	
		return selectFieldsString;
	}

	public void setSelectFieldsString(String selectFieldsString) {
		
		if( selectFieldsString == null) return ;
		this.selectFieldsString = selectFieldsString;
		String[] fields = selectFieldsString.split(",");
		if(fields.length >  0) {
			List list = new ArrayList(fields.length );
			
			for (int i = 0; i < fields.length; i++) {
				list.add( StringUtils.trim(fields[i]) );
			}
			this.selectFields = list;
		}
	}

	public boolean isSelectFieldsUseVOType() {
		return selectFieldsUseVOType;
	}

	public void setSelectFieldsUseVOType(boolean selectFieldsUseVOType) {
		this.selectFieldsUseVOType = selectFieldsUseVOType;
	}

	public boolean isDataOnly() {
		return dataOnly;
	}

	public void setDataOnly(boolean dataOnly) {
		this.dataOnly = dataOnly;
	}

	public String getGoto_page() {
		return goto_page;
	}

	public void setGoto_page(String goto_page) {
		this.goto_page = goto_page;
	}

	public String get_queryexpress() {
		return _queryexpress;
	}

	public void set_queryexpress(String _queryexpress) {
		this._queryexpress = _queryexpress;
	}

	public String getNameSql() {
		return nameSql;
	}

	public void setNameSql(String nameSql) {
		this.nameSql = nameSql;
	}

	public boolean isQueryByNameSql() {
		return queryByNameSql;
	}

	public void setQueryByNameSql(boolean queryByNameSql) {
		this.queryByNameSql = queryByNameSql;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}
	
	
}
