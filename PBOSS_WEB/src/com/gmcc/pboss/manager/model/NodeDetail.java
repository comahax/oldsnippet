package com.gmcc.pboss.manager.model;

import java.io.Serializable;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.biz.info.node.model.Contact;
import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;

/**
 * 这是一个帮助类，把所有的渠道信息放在这个类中
 * 用于通过HQL查询渠道详情，然后在界面中展示
 */
public class NodeDetail implements Serializable {
	//渠道信息
	private Way way;
	//账户信息
	private WayAccount account;
	//网点联系信息
	private Contact contact;
	//分销合作商
	private ChDstCooperator cooperator;
	
	public NodeDetail(){
		;
	}
	public NodeDetail(Way w, WayAccount a, Contact c, ChDstCooperator co){
		this.way = w;
		this.account = a;
		this.contact = c;
		this.cooperator = co;
	}
	
	public void setWay(Way way){
		this.way = way;
	}
	public Way getWay(){
		return this.way;
	}
	public void setAccount(WayAccount a){
		this.account =a ;
	}
	public WayAccount getAccount(){
		return this.account;
	}
	public void setContact(Contact c){
		this.contact = c;
	}
	public Contact getContact(){
		return this.contact;
	}
	public void setCooperator(ChDstCooperator co){
		this.cooperator = co;
	}
	public ChDstCooperator getCooperator(){
		return this.cooperator;
	}
}
