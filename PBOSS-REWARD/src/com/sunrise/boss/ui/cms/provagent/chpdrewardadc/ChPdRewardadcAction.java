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
        // TODO: 给出主键的名字数组
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
		export.setFileName("下发ADC酬金数据查询");  
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) }); 
		export.addOutputProperty("rewardid", "酬金序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodid", "集团产品名称", export.CODE2NAME, "#CH_PD_ENTPRODUCT"); 
		export.addOutputProperty("custid", "集团编码");
		export.addOutputProperty("custname", "集团名称");
		export.addOutputProperty("phase", "期数");
		export.addOutputProperty("rewardmonth", "计酬月份");
		export.addOutputProperty("rewardmoney", "结算酬金"); 
		export.addOutputProperty("rpmoney", "奖罚金额");
		export.addOutputProperty("supplemoney", "补算酬金"); 
		export.addOutputProperty("inbossmonth", "BOSS入库月份");
		export.addOutputProperty("version", "酬金版本号"); 
		export.addOutputProperty("reason", "补算原因");  
		export.addOutputProperty("ruledesc", "计酬规则");
		export.addOutputProperty("isreleaseadc", "是否下发ADC", export.CODE2NAME, "#PD_YESORNO"); 
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
