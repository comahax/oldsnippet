package com.sunrise.jop.infrastructure.db;

import java.io.Serializable;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;


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
public class DBQueryParam implements Serializable {
    
	private static final long serialVersionUID = -4795615512992486279L;  //���л�Ψһ��ʶ

	//��ǰ��ҳ��
    private String _pageno = CoreConfigInfo.DEFAULT_PAGE;
    //ÿҳ������
    private String _pagesize = String.valueOf(CoreConfigInfo.DEFAULT_PAGE_SIZE);

    //�����ֶ�
    private String _orderby;
    //���򣬽���
    private String _desc;
    private boolean ascending = true;
    //���ص�������Ŀ
    private String _datasize;
    private String _firstitems;
    
    //�оٳ�ֻ��Ҫ��ѯ���ֶ�����
    private List selectFields;
    
//  �оٳ�ֻ��Ҫ��ѯ���ֶ�����
    private String selectFieldsString;
    /**
     * hekun ���صĲ����ֶε�java class���ͣ�ֻ������VO��û�е����Ե�����
     * Map fieldClass = new HashMap();
	   fieldClass.put("companystate", Short.class);
	   param.setSelectFieldsClass(fieldClass);
     */
    private Map selectFieldsClass;
    
    /**
     * hekun ���ò����ֶβ�ѯʱ���ص�Ԫ��ʹ��VO���ͣ�Ĭ��ʹ��Map���ͣ��Խ�ʡ��Դ. ע�⣬���뱣֤�����ֶζ���vo�����ԣ�������Ȼ��Map����
     */
    private boolean selectFieldsUseVOType;
    
    //��ѯ����, ��Ҫ���ù̶�������Ҳ���������磺_se_xxx�Ķ�̬����
    private Map queryConditions ;

    //web��ʹ�õ����ԣ���ʶ��ѡ�еĶ���, //hekun: Ϊ��ѡ�еĶ�����������ϣ������ŷָ�
    private String[] _selectitem;
    
    //�Ƿ�ʹ�ÿ��ٲ�ѯ������ѯʱ���������������Ĳ�ѯ(select count(*) from )
    private boolean countOnly;
    
//  �Ƿ�ʹ�ÿ��ٲ�ѯ������ѯʱ���������������Ĳ�ѯ(select count(*) from ),trueʱֻ��ѯ����
    private boolean dataOnly;
    
    //����ҳ����ѯ�������ݣ��ȼ��� _pagesize =0 ��Ĭ���Ƿ�ҳ�ġ�
    private boolean queryAll; 
    
    private String nameSql;
    
    private boolean queryByNameSql = false;
    
    /**
     * hekun ��ʹ�ù̶���������ֻ����named sql query�ж���Ĺ̶�������
     * ����listVO���Ժ� queryConditions����������ֵ��������׷�� _se_xxx �����Ķ�̬����
     */
    private boolean useFixedParamOnly; 
    
    private String _pk;
    
    //BOSS1.5���õķ���,����������1.5��JavaScript,������ʱ���������������������,�Է���̨Ƶ������
    private String goto_page;
    private String _queryexpress;
    
    private String startindex;
	private String endindex;
	
	public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
        this.ascending = !"1".equals(_desc); //��Ϊ�����򶼿�������
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
     * ʹ�ö�̬��ѯ�������﷨���򲻱䡣�������ʱ����Ҫ����������ԣ���Map��ʽ��Ӽ��ɡ�
     * ���磺
     * getQueryConditions.put("_sk_oprcode","example");
     * getQueryConditions.put("_ne_logid",new Long(1232));
     * ������ ��̬����ֵ�����ж�̬����ֵʱ���Ծ�̬Ϊ���ȡ�
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
