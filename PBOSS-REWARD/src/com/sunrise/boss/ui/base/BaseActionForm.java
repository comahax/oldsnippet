package com.sunrise.boss.ui.base;

import org.apache.struts.validator.ValidatorForm;

/**
 * User: JinBo
 * Date: 2006-8-4
 * Time: 9:28:43
 * 
 * 2008-4-2 Huang Baiming 添加_hispageno属性
 * 
 * 2009-3-1 Wang Guangying 添加_ttinfo, _curnodepage, _curnode, isfaward 属性
 * 用于佛山（当前，以后可能会有其他地市）多TimesTen节点的数据查询。
 * 
 */
public class BaseActionForm extends ValidatorForm {
    //ActionForm状态，属性标识。在BaseAction中用于保存Action的操作状态，即新增、删除等
    private String cmdState;
    
    private String _hispageno = "-1"; //history page no 历史库页码
    
    private String _pageno; // 生成库页码
    private String _pagesize;

    private String _orderby;
    private String _desc;

    private String[] _selectitem;

    private String _displaycount;
    
    //添加多TimesTen数据库查询方式  start>>>>>>>
    
    //保存库中的信息：节点名，页数-节点名，页数－。
    //如：TTDB_TEST,2-TTDB_TEST,2-TTDB_TEST,2-TTDB_TEST,2-
    private String _ttinfo; 
    
    //保存当前TimesTen库的数据页数
	private int _curnodepage;
	
	//保存当前的结点序号
	private int _curnode;   
	
	//当前查询的总页数
	private int _totalpage = 1;
	
	//判断是否向前切换TimesTen数据库，如果是，则会将新查到的数据分页数保存到
	//当前库ttcurrentnode对应的ttmultiinfo中，此属性初始值一定要为true。
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
