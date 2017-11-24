/**
 * auto-generated code
 * Fri Oct 23 15:56:45 CST 2009
 */
package com.gmcc.pboss.web.sales.actrepair;

import java.util.Date;
import java.util.Iterator;

import com.gmcc.pboss.business.sales.actrepair.ActrepairVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.sales.actrepair.ActrepairDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.actrepair.Actrepair;
import com.gmcc.pboss.control.sales.actrepair.ActrepairBO;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;
import com.gmcc.pboss.control.sales.noactinfo.NoactinfoBO;
import com.gmcc.pboss.web.sales.noactinfo.NoactinfoWebParam;

/**
 * <p>
 * Title: ActrepairAction
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
public class ActrepairAction extends BaseAction {

	public ActrepairAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ActrepairForm());
		this.setParam(new ActrepairWebParam());

		// ָ��VO��
		setClsVO(ActrepairVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Actrepair.class);
		this.setClsQueryParam(ActrepairDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doSave() throws Exception {
		// ���ݺ����ѯ���뼤���¼��FX_SN_NOACTINFO��������޼�¼���������ݣ���������ȡ����¼�����ݣ�¼��ʱ��Ϊ��ǰʱ�䣬��עΪǰ̨��¼��
		// ����м�¼�����Ȳ�ѯϵͳ�������ȡ������ʱ�䲨����Χ����������ʱĬ��Ϊ3��Ȼ����ݲ�ѯ���������
		// һ����¼��������ļ���ʱ�����ѯ����ļ���ʱ����жԱȣ��������ʱ��Ĳ���ڲ�����Χ�ڣ�����ʾ���ú���ļ����¼�Ѿ����ڣ����顣�������أ������������ݣ���������ȡ����¼�����ݣ�¼��ʱ��Ϊ��ǰʱ�䣬��עΪǰ̨��¼��
		// ����һ����¼��������ļ���ʱ�����ѯ����ļ���ʱ������Աȣ��������ʱ��Ĳ���ڲ�����Χ�ڣ�����ʾ���ú���ļ����¼�Ѿ����ڣ����顣�������أ����������һ������������н�����ݵĲ�඼���ڲ�����Χ�����������ݣ���������ȡ����¼�����ݣ�¼��ʱ��Ϊ��ǰʱ�䣬��עΪǰ̨��¼��
		// ������¼�����뼤�¼��(FX_SN_ACTREPAIR)�����ȡ���У�FX_SN_ACTREPAIR_SEQ������¼ʱ��ȡ��ǰʱ�䣬��¼����ȡ��ǰ����Ա���ţ������ֶ�ȡֵ��Ӧ����¼������ݡ�

		
		ActrepairForm actrepairForm = (ActrepairForm) this.getForm();
		actrepairForm.setRepairtime(new Date(System.currentTimeMillis()));
		actrepairForm.setOprcode(this.getDBAccessUser().getOprcode());
		String mobileno = actrepairForm.getMobileno();
		
		NoactinfoWebParam noactinfoWebParam = new NoactinfoWebParam();	
		noactinfoWebParam.set_se_mobileno(mobileno);
		Actrepair actrepair = (Actrepair) BOFactory.build(ActrepairBO.class,
				getDBAccessUser());		
		Noactinfo noactinfo = (Noactinfo) BOFactory.build(NoactinfoBO.class,
				getDBAccessUser());
		
		DataPackage dp = noactinfo.doQuery(noactinfoWebParam);
		NoactinfoVO noactinfoVO = new NoactinfoVO();//������뼤�����Ϣ
		noactinfoVO.setActivedate(actrepairForm.getActivedate());
		noactinfoVO.setMemo("ǰ̨��¼");
		noactinfoVO.setCreattime(new Date(System.currentTimeMillis()));
		noactinfoVO.setMobileno(actrepairForm.getMobileno());
		Sysparam sys = (Sysparam) BOFactory.build(SysparamBO.class,this.getDBAccessUser());
		String day = sys.doFindByID("75", "pboss_fx");
		if (day == null || day.equals("")) {
			day = "3";
		}
		boolean bo = actrepair.doCheckDate(mobileno, noactinfoVO.getActivedate(),day);
		if (bo) {
			try{
				noactinfo.doCreate(noactinfoVO);//��Ӽ�������
				return super.doSave();
			}catch(Exception e){
				this.addActionMessage(e.getMessage());
				return WEB_RESULT_CONTENT;
			}			
		} else {
			this.addActionError("�ú���ļ����¼�Ѿ����ڣ����顣");
			return WEB_RESULT_CONTENT;
		}
		

	}

}