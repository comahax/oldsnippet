/**
 * auto-generated code
 * Tue Sep 29 10:19:40 CST 2009
 */
 package com.gmcc.pboss.web.communication.reply;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.business.communication.reply.ReplyVO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.reply.Reply;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ReplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ReplyAction extends BaseAction{
	
	public ReplyAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ReplyForm());
		this.setParam(new ReplyWebParam());

        //指定VO类
        setClsVO(ReplyVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"replyid"};
		this.setClsControl(Reply.class);
		this.setClsQueryParam(ReplyDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doResave() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long advinfoid = null;
		if (!StringUtils.isEmpty(request.getParameter("param._ne_advinfoid"))) {
			advinfoid = new Long(request.getParameter("param._ne_advinfoid"));
		}
		this.setCMD(WEB_CMD_NEW);
		ReplyForm form = (ReplyForm)getForm();
		form.setAdvinfoid(advinfoid);
		form.setReplytime(new java.sql.Timestamp(new Date().getTime()));
		form.setOid("0");
		super.doSave();
		
		Advinfo aiBo = (AdvinfoBO)BOFactory.build(AdvinfoBO.class, getDBAccessUser());
		AdvinfoVO aiVo = aiBo.doFindByPk(advinfoid);
		aiVo.setState(new Short("6"));
		aiBo.doUpdate(aiVo);
		
		return "resave";
	}
	public String doAdvResave() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long advinfoid = null;
		if (!StringUtils.isEmpty(request.getParameter("param._ne_advinfoid"))) {
			advinfoid = new Long(request.getParameter("param._ne_advinfoid"));
		}
		this.setCMD(WEB_CMD_NEW);
		ReplyForm form = (ReplyForm)getForm();
		form.setAdvinfoid(advinfoid);
		form.setReplytime(new java.sql.Timestamp(new Date().getTime()));
		form.setOid("0");
		super.doSave();
		
		
		return "advRresave";
	}
}