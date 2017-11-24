/**
 * auto-generated code
 * Thu Dec 29 17:51:44 CST 2011
 */
 package com.gmcc.pboss.web.channel.bondaudit;


import com.gmcc.pboss.business.channel.bondaudit.BondauditDBParam;
import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.control.channel.bondaudit.Bondaudit;
import com.gmcc.pboss.control.channel.bondaudit.BondauditBO;
import com.gmcc.pboss.control.channel.bondform.BondformBO;
import com.gmcc.pboss.web.channel.bondform.BondformForm;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BondauditAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondauditAction extends BaseAction{
	
	
	private	BondformForm bondformForm;
	
	
	
	public BondauditAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BondauditForm());
		this.setParam(new BondauditDBParam());

        //指定VO类
        setClsVO(BondauditVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Bondaudit.class);
		this.setClsQueryParam(BondauditDBParam.class) ;

	}

	@Override
	public String doList() throws Exception {
		
		this.getRequest().setAttribute("user", this.getDBAccessUser().getOprcode());
		return super.doList();
	}

	
	
	
	@Override
	public String doEdit() throws Exception {
		BondauditForm form = (BondauditForm)this.getForm();
		BondauditBO bondauditBO = (BondauditBO) BOFactory.build(BondauditBO.class,getDBAccessUser());
		BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,getDBAccessUser());
		
		BondauditVO bondauditVO = bondauditBO.doFindByPk(form.getSeqid());
		BondformVO  bondformVO = bondformBO.doFindByPk(bondauditVO.getFormid());
		BeanUtils.copyProperties(form, bondauditVO);
		bondformForm = new BondformForm();
		BeanUtils.copyProperties(bondformForm, bondformVO);
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	}

	
	
	
	
	
	@Override
	public String doSave() throws Exception {
		BondauditForm bondauditForm = new BondauditForm();
		BondauditForm form = (BondauditForm)this.getForm();
		BeanUtils.copyProperties(bondauditForm, form);
		BondauditBO bondauditBO1 = (BondauditBO) BOFactory.build(BondauditBO.class,getDBAccessUser());
		BondformBO bondformBO = (BondformBO) BOFactory.build(BondformBO.class,getDBAccessUser());
		
		BondauditVO bondauditVO1 = bondauditBO1.doFindByPk(form.getSeqid());
		BondformVO  bondformVO1 = bondformBO.doFindByPk(bondauditVO1.getFormid());
		
		bondformForm = new BondformForm();
		BeanUtils.copyProperties(bondformForm, bondformVO1);
		
		
		try {
			BondauditBO bondauditBO = (BondauditBO) BOFactory.build(BondauditBO.class,getDBAccessUser());
			
			BondauditVO bondauditVO = new BondauditVO();
			
			BeanUtils.copyProperties(bondauditVO, bondauditForm);
			bondauditBO.doUpdate(bondauditVO);
			BondauditVO bondauditVO2 = bondauditBO1.doFindByPk(form.getSeqid());
			BeanUtils.copyProperties(form, bondauditVO2);
			
			CMD = WEB_CMD_SAVE;
			setForm(form);
			this.addActionError("审核成功!");
		} catch (Exception e) {
			setForm(form);
			CMD = WEB_CMD_EDIT;
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}
		
		return WEB_RESULT_CONTENT;
	}

	public BondformForm getBondformForm() {
		return bondformForm;
	}

	public void setBondformForm(BondformForm bondformForm) {
		this.bondformForm = bondformForm;
	}
	
	
	
	
}