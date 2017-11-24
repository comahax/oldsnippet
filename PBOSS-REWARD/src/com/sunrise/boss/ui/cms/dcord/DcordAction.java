/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.ui.cms.dcord;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordListVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.dcord.DcordDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.dcord.DcordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: DcordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DcordAction extends BaseAction {
	public static final String CH_ADT_MONITOR_CON ="CH_ADT_MONITOR_CON";//分公司下拉框可见所有分公司
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//分公司下拉框仅所属分公司可见
    public DcordAction() {
            setVoClass(DcordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "id"; 
    }
    
    /**
     * 首次进入页面不查询
     */
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));  
    	try{
    		this.doCheckpermit(actionForm, user);
    		DcordForm form = (DcordForm)actionForm;
    		form.setSupportPaymonth(this.isSupportPaymonth(user));
    	}catch(BusinessException ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	return (actionMapping.findForward("list"));
    }
    
    private void doCheckpermit(ActionForm actionForm, User user)throws Exception{
    	DcordForm form = (DcordForm)actionForm;
    	ACLDelegate acldelegate = new ACLDelegate();    	
    	if(form.getCitypermited()==-1){
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_MONITOR_CON);
	    	if(citypermit){
	    		form.setCitypermited(1);
	    	}else{
	    		form.setCitypermited(0);
	    	}
		}
		if(form.getCountypermited()==-1){
			boolean countypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_ADJUST_COUNTY);
	    	if(countypermit){
	    		form.setCountypermited(1);
	    		OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		if(countyid!=null){
	    			form.set_se_countyid(countyid);
	    		}else{
	    			throw new BusinessException(null, "登录工号无分公司信息");
	    		}
	    	}else{
	    		form.setCountypermited(0);
	    	}
		}
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));    		
    		try{
        		this.doCheckpermit(actionForm, user);
        	}catch(BusinessException ex){
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
        	}
        	
        	VDcordListVO listvo = new VDcordListVO();
    		DcordForm form = (DcordForm)actionForm;
    		this.setListVO(listvo, form);
    		
    		List<String> opnids = new ArrayList<String>();
    		if (form.get_se_opnid() != null && !"".equals(form.get_se_opnid())) {
				String[] opnidandnames = form.get_se_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					opnids.add(opnid.trim());
				}				
			}
    		listvo.set_sin_opnid(opnids);
    		if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
    			listvo.set_orderby("id,wayid,opnid");
    		}    		
    		//listvo.setThreshhold(SysInfo.THRESHHOLD);//设置查询结果集的阀值大小
    		
    		DcordDelegate delegate = new DcordDelegate();
        	DataPackage dp = delegate.doQuery(listvo, user);
        	
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}    	

    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doAdjust(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{    	
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	try{
    		Long id = Long.parseLong((String)request.getParameter("id"));
        	String wayid = (String)request.getParameter("wayid");
        	String rewardmonth = (String)request.getParameter("rewardmonth");
        	Short isflag = Short.parseShort((String)request.getParameter("isflag"));       	
        	
        	DcordDelegate dcorddelegate = new DcordDelegate();
        	DcordVO dvo = dcorddelegate.doFindByPk(id, user);
        	
        	//根据wayid和rewardmonth检查ch_adt_adjustment表是否存在相关记录且batchno为空的记录
        	AdjustmentDelegate adjustdegelete = new AdjustmentDelegate();
        	AdjustmentListVO listvo = new AdjustmentListVO();
        	listvo.set_se_rewardmonth(rewardmonth);
        	listvo.set_se_wayid(wayid);
        	listvo.set_sql_batchno(" batchno is null");
        	listvo.set_pagesize("0");
        	
        	SysparamDelegate sysparamDelegate = new SysparamDelegate();
        	SysparamListVO sysparamListVO = new SysparamListVO();
        	sysparamListVO.set_se_paramtype("channel");
        	sysparamListVO.set_ne_systemid("93");
        	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if (sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0) {
        		SysparamVO sysparamVO = (SysparamVO) sysparamDP.getDatas().iterator().next();
        		if ("1".equals(sysparamVO.getParamvalue())) {
        			listvo.set_se_upperopnid(dvo.getUpperopnid());
        		}
			}
        	
        	DataPackage dp = adjustdegelete.doQuery(listvo, user);
        	if(dp!=null && dp.getDatas().size()>0){
//        		Iterator it = dp.getDatas().iterator();
//        		while(it.hasNext()){
//        			AdjustmentVO vo = (AdjustmentVO)it.next();
//        			if(vo.getBatchno()==null || "".equals(vo.getBatchno().trim())){
        				out.write("该渠道当前结算月份已确认待出付款报表,若需调整请在【付款数据调整管理】中先删除该网点的已核对记录!");
        				return null;
//        			}
//        		}
        	}
        	//调整ISFLAF/ADJUSTOPRCODE/ADJUSTOPTIME
        	if(dvo.getIsflag().shortValue()==isflag.shortValue()){
        		out.write("[结算状态]未发生变化，不处理");
        	}else{
        		dvo.setIsflag(isflag);
            	dvo.setAdjustoprcode(user.getOpercode());
            	dvo.setAdjustoptime(new Date());
            	dcorddelegate.doUpdate(dvo, user);
            	
            	CityrecordDelegate cityrecordDelegate = new CityrecordDelegate();
            	cityrecordDelegate.updateIsflagByDcordid(isflag, dvo.getId(), user);
            	
            	out.write("处理成功");
        	}        	
    	}catch(Exception ex){
    		ex.printStackTrace();
    		out.write("处理失败");
    	}
    	
    	return null;
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金出帐明细查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("id", "序列号");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("starlevel", "渠道星级", export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("opnid", "业务编码");
		export.addOutputProperty("opnid", "业务名称", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("upperopnid", "业务大类", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("subopnid", "业务小类", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("oprmonth", "业务发生月");
		export.addOutputProperty("rewardtype", "酬金期数", export.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("rewardmonth", "结算月份");
		export.addOutputProperty("gotonebusivalue","全球通业务量");
		export.addOutputProperty("gotonemoney","全球通酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("szxbusivalue","神州行业务量");
		export.addOutputProperty("szxmoney","神州行酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("mzonebusivalue","动感地带业务量");
		export.addOutputProperty("mzonemoney","动感地带酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("tdbusivalue","TD业务量");
		export.addOutputProperty("tdmoney","TD酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("otherbusivalue","其他业务量");
		export.addOutputProperty("othermoney","其他业务酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("busivaluesum","总业务量");
		export.addOutputProperty("moneysum","总业务酬金金额",export.NUMBER,"0.00");
		export.addOutputProperty("isflag","结算标识", export.CODE2NAME, "$CH_ISFLAG");
		export.addOutputProperty("batchno","付款批次");
		export.addOutputProperty("abatchno","出帐批次号");
		if(this.isSupportPaymonth(user)){
			export.addOutputProperty("paymonth", "付款月份");
		}

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { VDcordVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	
    	return null;
    }
    
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金出帐明细查询");
		export.addOutputProperty("id", "序列号");
		export.addOutputProperty("countyid", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("starlevel", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("upperopnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("subopnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("oprmonth");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("gotonebusivalue");
		export.addOutputProperty("gotonemoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("szxbusivalue");
		export.addOutputProperty("szxmoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("mzonebusivalue");
		export.addOutputProperty("mzonemoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("tdbusivalue");
		export.addOutputProperty("tdmoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("otherbusivalue");
		export.addOutputProperty("othermoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("busivaluesum");
		export.addOutputProperty("moneysum",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("isflag", CommonExportBean.CODE2NAME, "$CH_ISFLAG");
		export.addOutputProperty("batchno");
		export.addOutputProperty("abatchno");
		String[] title = null;
		if(this.isSupportPaymonth(user)){
			export.addOutputProperty("paymonth");
			title = new String[] {
					"序列号", "分公司", "渠道编码", "渠道名称", "渠道星级", "业务编码", "业务名称", "业务大类",
					"业务小类", "业务发生月", "酬金期数", "结算月份", "全球通业务量", "全球通酬金金额", "神州行业务量",
					"神州行酬金金额", "动感地带业务量", "动感地带酬金金额", "TD业务量", "TD酬金金额", "其他业务量",
					"其他业务酬金金额", "总业务量", "总业务酬金金额", "结算标识", "付款批次", "出帐批次号","付款月份" };
		}else{
			title = new String[] {
					"序列号", "分公司", "渠道编码", "渠道名称", "渠道星级", "业务编码", "业务名称", "业务大类",
					"业务小类", "业务发生月", "酬金期数", "结算月份", "全球通业务量", "全球通酬金金额", "神州行业务量",
					"神州行酬金金额", "动感地带业务量", "动感地带酬金金额", "TD业务量", "TD酬金金额", "其他业务量",
					"其他业务酬金金额", "总业务量", "总业务酬金金额", "结算标识", "付款批次", "出帐批次号" };
		}
		export.voClassArray = new Class[] { VDcordVO.class };
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(),title );
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
    	return null;
    }
    
    public ActionForward doLoadsub(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{    	
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	String upperopnid = request.getParameter("upperopnid");
    	try{
    		OperationDelegate operdelegate = new OperationDelegate();
    		OperationListVO listvo = new OperationListVO();
    		listvo.set_se_parentid(upperopnid);
    		listvo.set_ne_opnlevel("2");
    		listvo.set_pagesize("0");
    		DataPackage dp = operdelegate.doQuery(listvo, user);
    		if(dp!=null && dp.getDatas().size()>0){
    			StringBuilder sb = new StringBuilder();
    			Iterator it = dp.getDatas().iterator();
    			OperationVO vo = null;
    			while(it.hasNext()){
    				vo = (OperationVO)it.next();
    				sb.append(vo.getOpnid()+":"+vo.getName()+",");
    			}
    			out.write(sb.toString().substring(0,sb.toString().length()-1));
    		}else{
    			System.out.println("["+upperopnid+"]不存在相关二级业务编码");
    			out.write("");
    		}
    	}catch(Exception ex){
    		System.out.println("["+upperopnid+"]加载二级业务编码异常退出");
    		ex.printStackTrace();
    		out.write("");
    	}
    	
    	return null;
    }
    
    public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
    
    //是否支持付款月份
    public boolean isSupportPaymonth(User user) throws Exception{
    	SysparamDelegate sysparamDelegate = new SysparamDelegate();
		String value = sysparamDelegate.doFindByID(95L, "channel", user);
		if(value!=null){
			if("1".equals(value)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;//不存在系统参数则设置为假
		}
    }  
}
