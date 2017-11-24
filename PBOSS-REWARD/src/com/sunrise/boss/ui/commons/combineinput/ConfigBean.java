package com.sunrise.boss.ui.commons.combineinput;

import java.io.Serializable;

/**
 * <p>Title: ConfigBean </p>
 * <p>Description: 对应xml配置bean类 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class ConfigBean implements Serializable {
	private String definition; //定义
	private String classname; //对应class
	private String title; //标题
	private String typename1; //类型名
	private String typename2; //类型名
	private String description; //说明
	private boolean relateflag; //类型关联标识
	private String symbol_mid; //分割符 中间
	private String symbol_tail; //分割符 尾部
	private String return_page; //返回页
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSymbol_mid() {
		return symbol_mid;
	}
	public void setSymbol_mid(String symbol_mid) {
		this.symbol_mid = symbol_mid;
	}
	public String getSymbol_tail() {
		return symbol_tail;
	}
	public void setSymbol_tail(String symbol_tail) {
		this.symbol_tail = symbol_tail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypename1() {
		return typename1;
	}
	public void setTypename1(String typename1) {
		this.typename1 = typename1;
	}
	public String getTypename2() {
		return typename2;
	}
	public void setTypename2(String typename2) {
		this.typename2 = typename2;
	}
	public boolean isRelateflag() {
		return relateflag;
	}
	public void setRelateflag(boolean relateflag) {
		this.relateflag = relateflag;
	}
	public String getReturn_page() {
		return return_page;
	}
	public void setReturn_page(String return_page) {
		this.return_page = return_page;
	}
}
