/**
* auto-generated code
* Mon Sep 03 20:43:09 CST 2012
*/
package com.sunrise.boss.ui.cms.chadtcityrecordhis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisListVO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.chadtcityrecordhis.ChAdtCityrecordhisDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.cityrecord.CityrecordAction;
import com.sunrise.boss.ui.cms.cityrecord.CityrecordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtCityrecordhisAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtCityrecordhisAction extends BaseAction {	
    public ChAdtCityrecordhisAction() {
            setVoClass(ChAdtCityrecordhisVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recordid"; 
    }
    
    private void doCheckpermit (ActionForm actionForm, User user)throws Exception{
    	ChAdtCityrecordhisForm form = (ChAdtCityrecordhisForm) actionForm;
    	//初始时-1，需要设置0市公司，1分公司    	
    	if(form.getIscountyoperid()==-1 ){
			ACLDelegate acldelegate = new ACLDelegate();   
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CityrecordAction.CH_ADT_CITYRECORD_CNTY);
			if(citypermit){
				form.setIscountyoperid(0);//市公司工号
			}else{
				form.setIscountyoperid(1);//分公司工号
				OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		if(countyid!=null){
	    			form.set_se_countyid(countyid);
	    		}else{
	    			throw new Exception("登录工号具有分公司操作权限，但工号分公司为空");
	    		}	    		
			}
		}else if(form.getIscountyoperid()==1){//分公司权限
			if(form.get_se_countyid()==null || "".equals(form.get_se_countyid().trim())){//分公司条件为空
				throw new Exception("登录工号具有分公司操作权限，但工号分公司为空");
			}
		}
    }
    
  //是否支持付款月份
    private boolean isSupportPaymonth(User user) throws Exception{
    	SysparamDelegate sysparamDelegate = new SysparamDelegate();
		String value = sysparamDelegate.doFindByID(95L, "channel", user);
		if(value!=null){
			if("1".equals(value)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;//不存在系统参数则设置为零
		}
    }
    
    /**
	 * 首次进入界面
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
			this.doCheckpermit(actionForm, user);
			ChAdtCityrecordhisForm chadtcityrecordhisForm = (ChAdtCityrecordhisForm) actionForm;
			chadtcityrecordhisForm.setSupportPaymonth(this.isSupportPaymonth(user));
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("list"));
	}
    /**
	 * 酬金明细历史数据查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
			this.doCheckpermit(actionForm, user);
			ChAdtCityrecordhisListVO listVO = new ChAdtCityrecordhisListVO();
			ChAdtCityrecordhisForm chadtcityrecordhisForm = (ChAdtCityrecordhisForm) actionForm;
			setListVO(listVO, chadtcityrecordhisForm);

			if (chadtcityrecordhisForm.get_sin_opnid() != null && !"".equals(chadtcityrecordhisForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = chadtcityrecordhisForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
                listVO.set_sql_opnid("opnid in ("+_sin_opnid+")");
                listVO.set_sin_opnid(""); 
			}
			if (null!= chadtcityrecordhisForm.get_se_oprmonth() && !"".equals(chadtcityrecordhisForm.get_se_oprmonth())) {
				listVO.set_sql_oprtime("to_char(oprtime,'yyyyMM')="+chadtcityrecordhisForm.get_se_oprmonth());
				listVO.set_se_oprmonth("");
			}
			if(listVO.get_orderby()==null || listVO.get_orderby().trim().length()==0){
				listVO.set_orderby("recordid");
    		} 
			ChAdtCityrecordhisDelegate delegate = new ChAdtCityrecordhisDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
//			if (pack.getRowCount() > 1000000){
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"请增加过滤条件,一次性查询结果不能超过100万！");
//			}else{ 
//			   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
//			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return (actionMapping.findForward("list"));
	}    
    
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] titles = new String[] {  
				"酬金明细标识", "业务编码","业务编码名称", "渠道编码","渠道编码名称", "酬金期数", "结算月份",  
				"手机号码或IMEI号","品牌","业务发生时间",
				"业务量或业务发生金额", "应发酬金合计", "本期应发酬金","审批编码","结算状态", "发布/同步工号", 
				"发布/同步时间", "确认工号","确认时间","计酬系统","原酬金明细ID","文件任务号","迁移批号",""};
		CommonExportBean export = new CommonExportBean(user); 
		export.setFileName("酬金明细历史数据查询");  
		export.addOutputProperty("recordid");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid",CommonExportBean.CODE2NAME,"#OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("rewardtype",CommonExportBean.CODE2NAME,"$CH_REWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("mobile"); 
		export.addOutputProperty("brand"); 
		export.addOutputProperty("oprtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("busivalue"); 
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("approveid");
		export.addOutputProperty("isflag",CommonExportBean.CODE2NAME,"$CH_ISFLAG");  
		export.addOutputProperty("oprcode"); 
		export.addOutputProperty("optime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss"); 
		export.addOutputProperty("accountoprcode");
		export.addOutputProperty("accountoptime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("systemflag",CommonExportBean.CODE2NAME,"#SYSTEMFLAG"); 
		export.addOutputProperty("rewardlistid");
		export.addOutputProperty("taskid");
		export.addOutputProperty("mbatchno"); 
		ChAdtCityrecordhisForm form = (ChAdtCityrecordhisForm) actionForm;
		if(form.isSupportPaymonth()){
			export.addOutputProperty("paymonth"); 
			titles[titles.length-1]="付款月份";
		}
		export.voClassArray = new Class[] { ChAdtCityrecordhisVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), titles);
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}
