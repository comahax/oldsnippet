/**
 * auto-generated code
 * Fri Apr 09 10:08:16 CST 2010
 */
 package com.gmcc.pboss.web.promotion.rewarddetail;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailVO ;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailDBParam;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.promotion.rewarddetail.Rewarddetail ;

/**
 * <p>Title: RewarddetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewarddetailAction extends BaseAction{
	
	public RewarddetailAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RewarddetailForm());
		this.setParam(new RewarddetailWebParam());

        //ָ��VO��
        setClsVO(RewarddetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Rewarddetail.class);
		this.setClsQueryParam(RewarddetailDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��������б�");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("seqid", "���");
		export.addOutputProperty("creatingtime", "����ʱ��");
		export.addOutputProperty("pid", "������ʶ");
		export.addOutputProperty("ruleid", "�����ʶ");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("calcmonth", "�����·�", export.DATE, "yyyyMM");
		export.addOutputProperty("comcategory", "��Ʒ����", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stdamount", "����׼");
		export.addOutputProperty("amount", "���");
		RewarddetailDBParam params = (RewarddetailDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}