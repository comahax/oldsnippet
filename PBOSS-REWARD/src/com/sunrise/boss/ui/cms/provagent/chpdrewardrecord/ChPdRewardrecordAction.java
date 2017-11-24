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
	//装载真实User
	private User realuser;
	
    public ChPdRewardrecordAction() {
            setVoClass(ChPdRewardrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rewardid"; 
    }
    
    //查询
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
    
    //导出excel
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金明细数据查询");   
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("rewardid", "酬金序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodname", "集团产品名称");
		export.addOutputProperty("custid", "集团编码");
		export.addOutputProperty("custname", "集团名称");
		export.addOutputProperty("inbossmonth", "录入BOSS月份");
		export.addOutputProperty("feemonth", "计费月份"); 
		export.addOutputProperty("phase", "期数");
		export.addOutputProperty("rewardmonth", "计酬月份");
		export.addOutputProperty("rewardmoney", "酬金金额");
		export.addOutputProperty("version", "版本号");
		export.addOutputProperty("recalmonth", "补算月份");
		export.addOutputProperty("adcrewardid", "下发ADC酬金序号");
		export.addOutputProperty("caltime", "计酬时间", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("ruledesc", "计酬规则");
		export.addOutputProperty("memo", "备注"); 
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
