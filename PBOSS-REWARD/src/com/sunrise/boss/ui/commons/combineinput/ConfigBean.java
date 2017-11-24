package com.sunrise.boss.ui.commons.combineinput;

import java.io.Serializable;

/**
 * <p>Title: ConfigBean </p>
 * <p>Description: ��Ӧxml����bean�� </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class ConfigBean implements Serializable {
	private String definition; //����
	private String classname; //��Ӧclass
	private String title; //����
	private String typename1; //������
	private String typename2; //������
	private String description; //˵��
	private boolean relateflag; //���͹�����ʶ
	private String symbol_mid; //�ָ�� �м�
	private String symbol_tail; //�ָ�� β��
	private String return_page; //����ҳ
	
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
