/**
 * auto-generated code
 * Tue Nov 08 09:56:31 CST 2011
 */
 package com.gmcc.pboss.web.base.limitsms;

import com.gmcc.pboss.business.base.limitsms.LimitsmsVO ;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.limitsms.LimitsmsDBParam;
import com.gmcc.pboss.control.base.limitsms.Limitsms ;

/**
 * <p>Title: LimitsmsAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class LimitsmsAction extends BaseAction{
	
	public LimitsmsAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new LimitsmsForm());
		this.setParam(new LimitsmsDBParam());

        //ָ��VO��
        setClsVO(LimitsmsVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Limitsms.class);
		this.setClsQueryParam(LimitsmsDBParam.class) ;

	}
	
	public String doList() throws Exception{
		LimitsmsDBParam param = (LimitsmsDBParam)this.getParam();
		param.set_desc("0");
		param.set_orderby("seq");
		return super.doList();
	}
}