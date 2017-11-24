package com.gmcc.pboss.manager.model;

import java.io.Serializable;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.biz.info.node.model.Contact;
import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;

/**
 * ����һ�������࣬�����е�������Ϣ�����������
 * ����ͨ��HQL��ѯ�������飬Ȼ���ڽ�����չʾ
 */
public class NodeDetail implements Serializable {
	//������Ϣ
	private Way way;
	//�˻���Ϣ
	private WayAccount account;
	//������ϵ��Ϣ
	private Contact contact;
	//����������
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
