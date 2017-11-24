/**
* auto-generated code
* Wed Sep 04 21:04:55 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrewardrecord;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;  
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter; 
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdrewardrecord.ChPdRewardrecordDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction; 
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPdRewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardrecordAction extends BaseDelegateAction {
	//װ����ʵUser
	private User realuser;
	
    public ChPdRewardrecordAction() {
            setVoClass(ChPdRewardrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rewardid"; 
    }
    
    //��ѯ
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	
    	ChPdRewardrecordForm Form = (ChPdRewardrecordForm) actionForm;
    	if (Form.isQuery()) { 
    	    ChPdRewardrecordListVO params = new ChPdRewardrecordListVO();
    	    params.set_orderby("rewardmonth");
    	    params.set_desc("1");
			setListVO(params, Form);
			ChPdRewardrecordDelegate delegate = new ChPdRewardrecordDelegate();
			User realuser = new User();
  			BeanUtils.copyProperties(realuser, user);
  			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.get_se_cityid()));
			DataPackage dp = delegate.doQuery(params, realuser);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}
    	return (actionMapping.findForward("list"));
    }
    
    //����excel
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ϸ���ݲ�ѯ");   
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("rewardid", "������");
		export.addOutputProperty("cityid", "���б�ʶ", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "�����̱���");
		export.addOutputProperty("provagentid", "����������", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "���Ų�Ʒ���");
		export.addOutputProperty("prodid", "���Ų�Ʒ��ʶ");
		export.addOutputProperty("prodname", "���Ų�Ʒ����");
		export.addOutputProperty("custid", "���ű���");
		export.addOutputProperty("custname", "��������");
		export.addOutputProperty("inbossmonth", "¼��BOSS�·�");
		export.addOutputProperty("feemonth", "�Ʒ��·�"); 
		export.addOutputProperty("phase", "����");
		export.addOutputProperty("rewardmonth", "�Ƴ��·�");
		export.addOutputProperty("rewardmoney", "�����");
		export.addOutputProperty("version", "�汾��");
		export.addOutputProperty("recalmonth", "�����·�");
		export.addOutputProperty("adcrewardid", "�·�ADC������");
		export.addOutputProperty("caltime", "�Ƴ�ʱ��", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("ruledesc", "�Ƴ����");
		export.addOutputProperty("memo", "��ע"); 
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {ChPdRewardrecordVO.class};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
    
}
