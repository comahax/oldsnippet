/**
 * auto-generated code
 * Thu Oct 15 16:20:00 CST 2009
 */
package com.gmcc.pboss.web.channel.auditwork;

import javax.xml.crypto.Data;

import com.gmcc.pboss.business.channel.auditwork.AuditworkDBParam;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.gmcc.pboss.control.channel.auditwork.Auditwork;
import com.gmcc.pboss.control.channel.auditwork.AuditworkBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: AuditworkAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class AuditworkAction extends BaseAction {

	public AuditworkAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new AuditworkForm());
		this.setParam(new AuditworkWebParam());

		// 指定VO类
		setClsVO(AuditworkVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "seqid" };
		this.setClsControl(Auditwork.class);
		this.setClsQueryParam(AuditworkDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doList() throws Exception {
		setDp(doQuery("EMPLOYEE_"));
		return WEB_RESULT_LIST;
	}

	public String doList2() throws Exception {
		setDp(doQuery("WAY_"));
		return "list2";
	}

	public DataPackage doQuery(String lkCondition) throws Exception {
		DataPackage result = null;
		try {
			Auditwork auditwork = (Auditwork) BOFactory.build(
					AuditworkBO.class, super.getDBAccessUser());
			AuditworkWebParam param = (AuditworkWebParam) getParam();
			if(param.get_ne_auditstatus()==null)
			{
				param.set_ne_auditstatus("0");
			}
			if (param.get_desc() == null) {
				param.set_desc("1");
				param.set_orderby("createtime");
			}
			if("WAY_".equals(lkCondition)){
				param.set_se_oprcode(super.getDBAccessUser().getOprcode());
			}
			
			param.set_sk_worktype(lkCondition);
			param.set_se_oprcode(getDBAccessUser().getOprcode());
			result = auditwork.doQuery(param);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return result;
	}

}