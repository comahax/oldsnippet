/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrewardadc;

import java.text.SimpleDateFormat;
import java.util.Date; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 

import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcVO; 
import com.sunrise.boss.common.base.db.DataPackage; 
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdrewardadc.ChPdRewardadcDelegate; 
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPdRewardadcAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardadcAction extends BaseAction {
 
    public ChPdRewardadcAction() {
            setVoClass(ChPdRewardadcVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rewardid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	
    	ChPdRewardadcForm Form = (ChPdRewardadcForm) actionForm;
    	if (Form.isQuery()) {
    		ChPdRewardadcListVO params = new ChPdRewardadcListVO();
  			setListVO(params, Form);
  			ChPdRewardadcDelegate delegate = new ChPdRewardadcDelegate();
  			User realuser = new User();
  			BeanUtils.copyProperties(realuser, user);
  			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.get_se_cityid()));
  			DataPackage dp = delegate.doQuery(params, realuser);
  			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}
    	return (actionMapping.findForward("list"));
    }
    
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�·�ADC������ݲ�ѯ");  
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) }); 
		export.addOutputProperty("rewardid", "������");
		export.addOutputProperty("cityid", "���б�ʶ", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "�����̱���");
		export.addOutputProperty("provagentid", "����������", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "���Ų�Ʒ���");
		export.addOutputProperty("prodid", "���Ų�Ʒ��ʶ");
		export.addOutputProperty("prodid", "���Ų�Ʒ����", export.CODE2NAME, "#CH_PD_ENTPRODUCT"); 
		export.addOutputProperty("custid", "���ű���");
		export.addOutputProperty("custname", "��������");
		export.addOutputProperty("phase", "����");
		export.addOutputProperty("rewardmonth", "�Ƴ��·�");
		export.addOutputProperty("rewardmoney", "������"); 
		export.addOutputProperty("rpmoney", "�������");
		export.addOutputProperty("supplemoney", "������"); 
		export.addOutputProperty("inbossmonth", "BOSS����·�");
		export.addOutputProperty("version", "���汾��"); 
		export.addOutputProperty("reason", "����ԭ��");  
		export.addOutputProperty("ruledesc", "�Ƴ����");
		export.addOutputProperty("isreleaseadc", "�Ƿ��·�ADC", export.CODE2NAME, "#PD_YESORNO"); 
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {ChPdRewardadcVO.class};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
}
