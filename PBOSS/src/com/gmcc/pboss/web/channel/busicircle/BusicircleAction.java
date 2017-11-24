/**
 * auto-generated code
 * Wed Nov 14 09:57:16 CST 2012
 */
 package com.gmcc.pboss.web.channel.busicircle;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.busicircle.BusicircleDBParam;
import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.channel.busicircle.Busicircle;
import com.gmcc.pboss.control.channel.busicircle.BusicircleBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BusicircleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BusicircleAction extends BaseAction{
	
	public BusicircleAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BusicircleForm());
		this.setParam(new BusicircleDBParam());

        //ָ��VO��
        setClsVO(BusicircleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"buscno"};
		this.setClsControl(Busicircle.class);
		this.setClsQueryParam(BusicircleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	private String has_right;//ʡ��˾���й�˾����Ȩ��
	
	public String getHas_right() throws Exception{
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean right_pro = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_BUSICIRCLE_PRO");
		
		boolean right_city = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_BUSICIRCLE_CITY");
		
		if(right_pro || right_city){
			has_right = "true";
		}else{
			has_right = "false";
		}
		
		return has_right;
	}

	public void setHas_right(String has_right) {
		this.has_right = has_right;
	}
	
	public String doList() throws Exception{
		BusicircleDBParam busicircleDBParam = (BusicircleDBParam)getParam();
		
		DBAccessUser user = this.getDBAccessUser();
		busicircleDBParam.set_se_cityid(user.getCityid());
		Busicircle Busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
		DataPackage dP = Busicircle.doQuery(busicircleDBParam);
		this.setDp(dP);
		
		return WEB_RESULT_LIST;
	}

	public String doSave() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		BusicircleForm form = (BusicircleForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		
		String buscelevel = form.getBuscelevel();
				
		Busicircle Busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
		BusicircleVO BusicircleVO = Busicircle.doFindByPk(form.getBuscno());
		if (WEB_CMD_NEW.equals(CMD)) {
			if(BusicircleVO != null && !"".equals(BusicircleVO)){
				super.addActionMessage("��Ȧ�����Ѵ���");
				return WEB_RESULT_CONTENT;
			}
		}
		
		form.setCreatetime(new Date());
		
		super.doSave();
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doNew() throws Exception{
		BusicircleForm form = (BusicircleForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		form.setCityid(user.getCityid());
		
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};
	
	public String doEdit() throws Exception{
		BaseVO vo = findVOFromDB();
		BaseVO form = getForm(); 
		BeanUtils.copyProperties(form, vo);
		
		DBAccessUser user = this.getDBAccessUser();
		((BusicircleForm)form).setCityid(user.getCityid());
		
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	};
}