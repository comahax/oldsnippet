/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
 package com.gmcc.pboss.web.resource.discomres;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.discomres.VDiscomresVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: DiscomresAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class DiscomresAction extends BaseAction{
	
	public DiscomresAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DiscomresForm());
		this.setParam(new DiscomresWebParam());

        //ָ��VO��
        setClsVO(DiscomresVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Discomres.class);
		this.setClsQueryParam(DiscomresDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String infolist() throws Exception {
		try{
			Discomres bo=(Discomres)BOFactory.build(DiscomresBO.class,super.getDBAccessUser());
			DiscomresWebParam param=(DiscomresWebParam)super.getParam();
			param.setSelectFieldsUseVOType(true);
			DataPackage dp = bo.doQueryDiscomresInfo(param);
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "infolist";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿���Դ��ѯ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("disid", "���䵥��");
		export.addOutputProperty("discomcode", "������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("comid", "��Ʒ��ʶ");
		export.addOutputProperty("comresid", "����");
		export.addOutputProperty("comstate", "��Ʒ״̬", export.CODE2NAME, "$IM_COMSTATE");
		export.addOutputProperty("issutime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { VDiscomresVO.class };
		export.queryMethodName = "infolist";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		DiscomresWebParam param=(DiscomresWebParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿���Դ��ѯ����");
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("disid", "���䵥��");
		export.addOutputProperty("discomcode", "������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("comid", "��Ʒ��ʶ");
		export.addOutputProperty("comresid", "����");
		export.addOutputProperty("comstate", "��Ʒ״̬", export.CODE2NAME, "$IM_COMSTATE");
		export.addOutputProperty("issutime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { VDiscomresVO.class };
		export.queryMethodName = "infolist";
		
		prepareResponse(export.getFileName());
		DiscomresWebParam param=(DiscomresWebParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"���","���䵥��","������", "��Ʒ����", "����", "��Ʒ��ʶ" ,"����","��Ʒ״̬","����ʱ��"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
}