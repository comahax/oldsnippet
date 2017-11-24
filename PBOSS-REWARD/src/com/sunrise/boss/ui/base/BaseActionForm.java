package com.sunrise.boss.ui.base;

import org.apache.struts.validator.ValidatorForm;

/**
 * User: JinBo
 * Date: 2006-8-4
 * Time: 9:28:43
 * 
 * 2008-4-2 Huang Baiming ���_hispageno����
 * 
 * 2009-3-1 Wang Guangying ���_ttinfo, _curnodepage, _curnode, isfaward ����
 * ���ڷ�ɽ����ǰ���Ժ���ܻ����������У���TimesTen�ڵ�����ݲ�ѯ��
 * 
 */
public class BaseActionForm extends ValidatorForm {
    //ActionForm״̬�����Ա�ʶ����BaseAction�����ڱ���Action�Ĳ���״̬����������ɾ����
    private String cmdState;
    
    private String _hispageno = "-1"; //history page no ��ʷ��ҳ��
    
    private String _pageno; // ���ɿ�ҳ��
    private String _pagesize;

    private String _orderby;
    private String _desc;

    private String[] _selectitem;

    private String _displaycount;
    
    //��Ӷ�TimesTen���ݿ��ѯ��ʽ  start>>>>>>>
    
    //������е���Ϣ���ڵ�����ҳ��-�ڵ�����ҳ������
    //�磺TTDB_TEST,2-TTDB_TEST,2-TTDB_TEST,2-TTDB_TEST,2-
    private String _ttinfo; 
    
    //���浱ǰTimesTen�������ҳ��
	private int _curnodepage;
	
	//���浱ǰ�Ľ�����
	private int _curnode;   
	
	//��ǰ��ѯ����ҳ��
	private int _totalpage = 1;
	
	//�ж��Ƿ���ǰ�л�TimesTen���ݿ⣬����ǣ���Ὣ�²鵽�����ݷ�ҳ�����浽
	//��ǰ��ttcurrentnode��Ӧ��ttmultiinfo�У������Գ�ʼֵһ��ҪΪtrue��
	private boolean isfaward = true;
    
	
	
	public int get_curnode() {
		return _curnode;
	}

	public void set_curnode(int _curnode) {
		this._curnode = _curnode;
	}

	public int get_curnodepage() {
		return _curnodepage;
	}

	public void set_curnodepage(int _curnodepage) {
		this._curnodepage = _curnodepage;
	}

	public String get_ttinfo() {
		return _ttinfo;
	}

	public void set_ttinfo(String _ttinfo) {
		this._ttinfo = _ttinfo;
	}

	public boolean isIsfaward() {
		return isfaward;
	}

	public void setIsfaward(boolean isfaward) {
		this.isfaward = isfaward;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>end
	public String get_displaycount() {
		return this._displaycount;
	}

	public void set_displaycount(String _displaycount) {
		this._displaycount = _displaycount;
	}

	public String getCmdState() {
        return cmdState;
    }

    public void setCmdState(String cmdState) {
        this.cmdState = cmdState;
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

    public void set_pagesize(String _pagesize) {
        this._pagesize = _pagesize;
    }

    public String get_orderby() {
        return _orderby;
    }

    public void set_orderby(String _orderby) {
        this._orderby = _orderby;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String[] get_selectitem() {
        return _selectitem;
    }

    public void set_selectitem(String[] _selectitem) {
        this._selectitem = _selectitem;
    }

	public String get_hispageno() {
		return _hispageno;
	}

	public void set_hispageno(String _hispageno) {
		this._hispageno = _hispageno;
	}

	public int get_totalpage() {
		return _totalpage;
	}

	public void set_totalpage(int _totalpage) {
		this._totalpage = _totalpage;
	}
}
