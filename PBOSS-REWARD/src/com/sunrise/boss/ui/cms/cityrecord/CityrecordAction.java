/**
 * auto-generated code
 * Thu Dec 15 07:12:07 GMT 2011
 */
package com.sunrise.boss.ui.cms.cityrecord;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.VBbcRewardrecord2VO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecord4VO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordVO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.VRewardrecordVO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.ChrewardtypeCacheUtil;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.chadtrewardsyninfo.ChAdtRewardsyninfoDelegate;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.rewardupload.RewarduploadDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page; 
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: CityrecordAction
 * </p>
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
 * @author
 * @version 1.0
 */
public class CityrecordAction extends BaseAction {
	public static final String CH_ADT_CITYRECORD_CNTY ="CH_ADT_CITYRECORD_CNTY";//分公司下拉框令牌
	private static int MILLION;	
	static{
		try{
			ResourceBundle rs = ResourceBundle.getBundle("sysinfo");
			int uplimit = Integer.parseInt(rs.getString("cityrecord.related.query.uplimit"));
			MILLION = uplimit*10000;			
		}catch(Exception ex){
			MILLION = 1000000;
		}		
	}
	
	private void doCheckpermit (ActionForm actionForm, User user)throws Exception{
		CityrecordForm form = (CityrecordForm) actionForm;
		if(form.getIscountyoperid()==-1){//初始时-1，需要设置0市公司，1分公司
			ACLDelegate acldelegate = new ACLDelegate();   
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_CITYRECORD_CNTY);
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
	
	public CityrecordAction() {
		setVoClass(CityrecordVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "recordid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		try{
			this.doCheckpermit(actionForm, user);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * 查询
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		long starttime = System.currentTimeMillis();
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			this.doCheckpermit(actionForm, user);
			
			CityrecordListVO listVO = new CityrecordListVO();
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			String _sin_opnid = "";
			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {				
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
			}
			CityrecordDelegate delegate = new CityrecordDelegate();
			if("1".equals(cityrecordForm.get_pageno())){//首次查询时做数据量检测，翻页时不再做检测
				setListVO(listVO, cityrecordForm);
				listVO.set_sin_opnid(_sin_opnid);
				DataPackage count = delegate.doThreeQueryEhanceCount(listVO, user);
				if(count.getRowCount()>MILLION){
					throw new BusinessException(null,"涉及明细数据量超过"+(MILLION/10000)+"万条，请增加界面限定条件");
				}
			}			
			
			setListVO(listVO, cityrecordForm);
			listVO.set_sin_opnid(_sin_opnid);
			DataPackage pack = delegate.doThreeQueryEhance(listVO, user);
			// 頁面顯示opnname
			// cityrecordForm.set_sin_opnid(sin_opnid);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		long interval = System.currentTimeMillis()-starttime;
		System.out.println("统计查询耗时："+interval);
		return (actionMapping.findForward("list"));
	}
	
	/**
	 * COMS明细导出查询数据，不对应任何界面
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doListtxtdetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			CityrecordListVO listVO = new CityrecordListVO();
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;			
			if(!"1".equals(cityrecordForm.get_ne_isflag())){
				throw new Exception("只允许[社会渠道酬金]和[创新联盟酬金]的\"待确认\"数据进行COMS明细导出操作");
			}
			if(!"2".equals(cityrecordForm.get_ne_systemflag()) && !"3".equals(cityrecordForm.get_ne_systemflag())){
				throw new Exception("只允许[社会渠道酬金]和[创新联盟酬金]的\"待确认\"数据进行COMS明细导出操作");
			}			
			setListVO(listVO, cityrecordForm);

			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);

				listVO.set_sin_opnid(_sin_opnid);
			}
			CityrecordDelegate delegate = new CityrecordDelegate();
			DataPackage pack = delegate.doQueryexceldetail(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return (actionMapping.findForward("list"));
	}
	
	public ActionForward doTxtdetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("COMS明细导出");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("opnid", "业务编码");
		export.addOutputProperty("rewardtype", "酬金期数");
		export.addOutputProperty("mobile", "手机、充值卡号码或IMEI号");
		export.addOutputProperty("rewardmonth", "结算月份");
		export.addOutputProperty("oprtime", "业务发生时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("busivalue", "业务量或业务发生金额");
		export.addOutputProperty("paysum", "应发酬金合计");
		
		export.voClassArray = new Class[] { VCityrecord4VO.class };
		export.queryMethodName = "doListtxtdetail";
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitleNoseq(response.getOutputStream(), new String[] {
			"渠道编码","业务编码","酬金期数","手机、充值卡号码或IMEI号",
			"结算月份","业务发生时间","业务量或业务发生金额","应发酬金合计"});
		//BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		//baseActionForm.set_orderby("wayid,opnid,rewardtype,oprtime");
		//baseActionForm.set_desc("0");
		
		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;		
		if("2".equals(cityrecordForm.get_ne_systemflag())){
			this.ExportQueryNoseqPW(actionMapping, actionForm, request, response, user,export);
		}else{//"3".equals(cityrecordForm.get_ne_systemflag())
			super.ExportQueryNoseq(actionMapping, actionForm, request, response, user,export);
		}		
		
		return actionMapping.findForward(null);
	}	
	public void ExportQueryNoseqPW(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// 查询数据输出,分页查询
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		for (int startindex = 1;; startindex++) {
			baseActionForm.set_pageno(String.valueOf(startindex));
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList(actionMapping, actionForm, request, response, user);
			} else {
				Method queryMethod = this.getClass().getMethod(commonExportBean.queryMethodName, types);
				queryMethod.invoke(this, new Object[] { actionMapping, actionForm, request, response, user });
			}
			DataPackage dp=(DataPackage) request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
			list = (ArrayList) dp.getDatas();
			if (list != null && !list.isEmpty()) {				
				ArrayList listmulti = new ArrayList<VCityrecord4VO>();
				Long seq =0L;
				for(Iterator ite = list.iterator();ite.hasNext();){
					RewardrecordVO pwvo = (RewardrecordVO)ite.next();
					if(pwvo.getPaymoney1()!=null && pwvo.getPaymoney1()!=0){//第一期不为零
						VCityrecord4VO vo1 = new VCityrecord4VO();
						BeanUtils.copyProperties(vo1, pwvo);
						vo1.setSeq(++seq);
						vo1.setRewardmonth(pwvo.getPaymonth1());
						vo1.setPaysum(pwvo.getPaymoney1());
						listmulti.add(vo1);
					}
					if(pwvo.getPaymoney2()!=null && pwvo.getPaymoney2()!=0){//第二期不为零
						VCityrecord4VO vo2 = new VCityrecord4VO();
						BeanUtils.copyProperties(vo2, pwvo);
						vo2.setSeq(++seq);
						vo2.setRewardmonth(pwvo.getPaymonth2());
						vo2.setPaysum(pwvo.getPaymoney2());
						listmulti.add(vo2);
					}					
					if(pwvo.getPaymoney3()!=null && pwvo.getPaymoney3()!=0){//第三期不为零
						VCityrecord4VO vo3 = new VCityrecord4VO();
						BeanUtils.copyProperties(vo3, pwvo);
						vo3.setSeq(++seq);
						vo3.setRewardmonth(pwvo.getPaymonth3());
						vo3.setPaysum(pwvo.getPaymoney3());
						listmulti.add(vo3);
					}					
				}
				commonExportBean.writeNoseq(os, listmulti.iterator(), commonExportBean.voClassArray);
				//commonExportBean.writeNoseq(os, list.iterator(), commonExportBean.voClassArray);				
				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
					break;
				}
			} else {// 该页没有数据
				break;
			}
			list.clear();
		}
	}

	/**
	 * 酬金明细查询--首次进入界面
	 */
	public ActionForward doShowdetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		try{
			this.doCheckpermit(actionForm, user);
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			cityrecordForm.setSupportPaymonth(this.isSupportPaymonth(user));
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("detaillist"));
	}
	/**
	 * 酬金明细查询
	 */
	public ActionForward doDetaillist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
			this.doCheckpermit(actionForm, user);
			CityrecordListVO listVO = new CityrecordListVO();
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			setListVO(listVO, cityrecordForm);

			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
                listVO.set_sql_opnid("opnid in ("+_sin_opnid+")");
                listVO.set_sin_opnid("");
				//listVO.set_sin_opnid(_sin_opnid);
			}
			if (null!= cityrecordForm.get_se_oprmonth() && !"".equals(cityrecordForm.get_se_oprmonth())) {
				listVO.set_sql_oprtime("to_char(oprtime,'yyyyMM')="+cityrecordForm.get_se_oprmonth());
				listVO.set_se_oprmonth("");
			}
			if(listVO.get_orderby()==null || listVO.get_orderby().trim().length()==0){
				listVO.set_orderby("recordid");
    		} 
			 
			CityrecordDelegate delegate = new CityrecordDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			if (pack.getRowCount() > 1000000){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"请增加过滤条件,一次性查询结果不能超过100万！");
			}else{ 
			   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			}			
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return (actionMapping.findForward("detaillist"));
	}
	
	/**
	 * 全部删除
	 */
	public ActionForward doDeleteall(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			String isflag = cityrecordForm.get_ne_isflag();
			if(!"1".equals(isflag)){
				throw new BusinessException("","只能删除“待确认”状态的酬金明细记录!");
			}
			CityrecordListVO listVO = new CityrecordListVO();
			setListVO(listVO, cityrecordForm);
			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
				listVO.set_sin_opnid(_sin_opnid);
			}
			
			CityrecordDelegate delegate = new CityrecordDelegate();
			int num = delegate.doDeleteall(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除待确认数据"+num+"条");
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		}catch(BusinessException ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
		}catch(Exception ex){
			
		}
		return (actionMapping.findForward("detaillist"));
	}
	
	/**
	 * 删除
	 */
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
			String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
			CommonDelegate delegate = new CommonDelegate(voClass);
			String isflag = "1";//待确认
			for (int i = 0; i < selectArray.length; i++) {
				String[] keys = selectArray[i].split("\\|");
				if(!isflag.equals(keys[1])){
					throw new BusinessException("","只能删除“待确认”状态的酬金明细记录!");
				}else{
					delegate.doRemoveByPK(getDeletePK(keys[0]), user);
				}
			}
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			throw e;
		}
		
		return doDetaillist(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 批量上传
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return actionMapping.findForward("batch");
	}

	/**
	 * 删除
	 * 20120914 将该功能从[地市酬金明细上传管理]迁移到[酬金明细数据查询]菜单
	 * <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doCityrecorddel('/cms/cityrecord.do')">

	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
//	public ActionForward doCityrecorddel(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user) throws Exception {
//		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
//		try {
//			CityrecordDelegate delegate = new CityrecordDelegate();
//			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
//			CityrecordListVO cityrecordListVO = new CityrecordListVO();
//			setListVO(cityrecordListVO, cityrecordForm);
//
//			for (int i = 0; i < selectArray.length; i++) {
//				String[] pkValueArray = selectArray[i].split("\\|");
//				String isflag = pkValueArray[4];
//				String systemflag = pkValueArray[5];
//				if("0".equals(isflag)){
//					throw new BusinessException("","不能删除已确认的酬金明细记录!");
//				}else if( "2".equals(isflag) && "2".equals(systemflag) ){
//					throw new BusinessException("","不能删除社会渠道待确认的酬金明细记录!");
//				}else if( "2".equals(isflag) && "3".equals(systemflag) ){
//					throw new BusinessException("","不能删除创新联盟待确认的酬金明细记录!");
//				}
//				cityrecordListVO.set_se_wayid(pkValueArray[0]);
//				cityrecordListVO.set_se_opnid(pkValueArray[1]);
//				cityrecordListVO.set_ne_rewardtype(pkValueArray[2]);
//				cityrecordListVO.set_se_rewardmonth(pkValueArray[3]);
//				cityrecordListVO.set_ne_isflag(isflag);
//				cityrecordListVO.set_ne_systemflag(systemflag);
//				delegate.doDeletepart(cityrecordListVO, user);
//
//			}
//		} catch (BusinessException e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
//					.toString());
//		} catch (Exception e) {
//			throw e;
//		}
//		return doList(actionMapping, actionForm, request, response, user);
//	}

	/**
	 * 全部删除
	 * 20120914 将该功能从[地市酬金明细上传管理]迁移到[酬金明细数据查询]菜单
	 * <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="全部删除"
										onClick="doDelall('/cms/cityrecord.do');" />
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
//	public ActionForward doAlldel(ActionMapping actionMapping,
//			ActionForm actionForm, HttpServletRequest request,
//			HttpServletResponse response, User user) throws Exception {
//		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
//		try {
//			CityrecordDelegate delegate = new CityrecordDelegate();
//			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
//			String isflag = cityrecordForm.get_ne_isflag();
//			String systemflag = cityrecordForm.get_ne_systemflag();
//			if("0".equals(isflag)){
//				throw new BusinessException("","不能删除已确认的酬金明细记录!");
//			}else if( "2".equals(isflag) && "2".equals(systemflag) ){
//				throw new BusinessException("","不能删除社会渠道待确认的酬金明细记录!");
//			}else if( "2".equals(isflag) && "3".equals(systemflag) ){
//				throw new BusinessException("","不能删除创新联盟待确认的酬金明细记录!");
//			}			
//			
//			CityrecordListVO cityrecordListVO = new CityrecordListVO();
//			setListVO(cityrecordListVO, cityrecordForm);
//			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
//				String _sin_opnid = "";
//				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
//				for (int i = 0; i < opnidandnames.length; i++) {
//					String[] opnidandname = opnidandnames[i].split("-");
//					String opnid = opnidandname[0];
//					_sin_opnid += "'" + opnid.trim() + "',";
//				}
//				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
//				cityrecordListVO.set_sin_opnid(_sin_opnid);
//			}
//			
//			delegate.doDeleteall(cityrecordListVO, user);
//
//		} catch (BusinessException e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
//					.toString());
//		} catch (Exception e) {
//			throw e;
//		}
//		return doList(actionMapping, actionForm, request, response, user);
//
//	}

	/**
	 * 同步 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doIssue(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {			
		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
		RewarduploadDelegate rewarduploaddelegate = new RewarduploadDelegate();
		RewarduploadListVO listVO = new RewarduploadListVO();
		listVO.set_nne_taskstate("0");
		DataPackage dp0 = rewarduploaddelegate.doQuery(listVO, user);
		if (null != dp0 && dp0.getDatas().size() > 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"后台正在处理上传文件不能同步！");
			return doList(actionMapping, actionForm, request, response, user);
		}

		// 检查是否有发布操作，防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
		// thread_ch_pw_Rewardrecord,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
		ChAdtDictparamDelegate de = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		if ("2".equals(cityrecordForm.get_ne_systemflag())) {
			listvo.set_se_dkey("thread_ch_pw_rewardrecord");
			DataPackage dp = de.doQuery(listvo, user);
			Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
			if (it.hasNext()) {
				if ("1".equals(it.next().getDvalue())) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"社会渠道酬金正在同步，请等待完成后再做！");
					return doList(actionMapping, actionForm, request, response, user);
				}
			}
		}
		if ("3".equals(cityrecordForm.get_ne_systemflag())) {
			listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
			DataPackage dp = de.doQuery(listvo, user);
			Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
			if (it.hasNext()) {
				if ("1".equals(it.next().getDvalue())) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"创薪联盟酬金正同步，请等待完成后再做！");
					return doList(actionMapping, actionForm, request, response,	user);
				}
			}
		}

		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();

		int successflag = 0;// 未同步成功
		try {
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO cityrecordListVO = new CityrecordListVO();
			setListVO(cityrecordListVO, cityrecordForm);			

			// 防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
			// thread_ch_pw_Rewardrecord,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
			try {
				ChAdtDictparamDelegate de11 = new ChAdtDictparamDelegate();
				ChAdtDictparamListVO chadtlistvo = new ChAdtDictparamListVO();
				ChAdtDictparamVO vo = new ChAdtDictparamVO();
				if ("2".equals(cityrecordForm.get_ne_systemflag())) {
					listvo.set_se_dkey("thread_ch_pw_rewardrecord");
					DataPackage ictparamdp = de11.doQuery(chadtlistvo, user);
					Iterator<ChAdtDictparamVO> it = ictparamdp.getDatas().iterator();
					if (it.hasNext()) {
						vo = it.next();
						vo.setDvalue("1");
						de11.doUpdate(vo, user);
					}
				}
				if ("3".equals(cityrecordForm.get_ne_systemflag())) {
					listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
					DataPackage ictparamdp = de11.doQuery(chadtlistvo, user);
					Iterator<ChAdtDictparamVO> it = ictparamdp.getDatas().iterator();
					if (it.hasNext()) {
						vo = it.next();
						vo.setDvalue("1");
						de11.doUpdate(vo, user);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//同步
			int failnum = 0;//同步失败记录数
			String errmsg= "";//错误信息
			for (int i = 0; i < selectArray.length; i++) {
				String[] pkValueArray = StringUtils.splitPreserveAllTokens(selectArray[i], "|");
				cityrecordListVO.set_se_wayid(pkValueArray[0]);
				cityrecordListVO.set_se_opnid(pkValueArray[1]);
				cityrecordListVO.set_ne_rewardtype(pkValueArray[2]);
				cityrecordListVO.set_se_rewardmonth(pkValueArray[3]);
				cityrecordListVO.set_sin_opnid(null);
				cityrecordListVO.set_pagesize("0");

				String[] ret = delegate.doIssue(cityrecordListVO, user);
				
				failnum += Integer.parseInt(ret[0]);
				errmsg += ret[1];
			}
			
			if(failnum==0){
				successflag = 1;// 发布成功
			}else{
				successflag = 0;// 未发布成功
				if(errmsg.length()>=256){
					errmsg = errmsg.substring(0,256);
				}
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, errmsg);
			}
		}catch (Exception e) {
			successflag = 0;// 未发布成功
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			e.printStackTrace();
		}finally {
			// 防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
			// thread_ch_pw_Rewardrecord
			// ,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
			try {
				ChAdtDictparamDelegate chde = new ChAdtDictparamDelegate();
				ChAdtDictparamListVO chlistvo = new ChAdtDictparamListVO();
				ChAdtDictparamVO vo = new ChAdtDictparamVO();
				if ("2".equals(cityrecordForm.get_ne_systemflag())) {
					listvo.set_se_dkey("thread_ch_pw_rewardrecord");
					DataPackage dp = de.doQuery(chlistvo, user);
					Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
					if (it.hasNext()) {
						vo = it.next();
						vo.setDvalue("0");
						de.doUpdate(vo, user);
					}
				}
				if ("3".equals(cityrecordForm.get_ne_systemflag())) {
					listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
					DataPackage dp = de.doQuery(chlistvo, user);
					Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
					if (it.hasNext()) {
						vo = it.next();
						vo.setDvalue("0");
						de.doUpdate(vo, user);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (successflag == 1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同步成功");
		}
		return doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 全部发布
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAllissue(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		int successflag = 0;// 未发布成功
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO listVO = new CityrecordListVO();
			setListVO(listVO, cityrecordForm);
			if ("1".equals(listVO.get_ne_isflag())
					&& "1".equals(listVO.get_ne_systemflag())) {
				delegate.doOnlyissue(listVO, user);
			} else {
				delegate.doAllissue(listVO, user);
			}
			successflag = 1;// 发布成功
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
			successflag = 0;// 未发布成功
		} catch (Exception e) {
			successflag = 0;// 未发布成功
			throw e;
		}
		if (successflag == 1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "全部发布成功");
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	// 汇总确认
	public ActionForward doAffirmgather(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// CityrecordForm form = (CityrecordForm)actionForm;
		// form.setRewardmonth(request.getParameter("rewardmonth"));
		// form.setWayid(request.getParameter("wayid"));
		// form.setOpnid(request.getParameter("opnid"));
		return (actionMapping.findForward("frame"));
	}

	/**
	 * 市公司酬金确认查询统计方法
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doListstat(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			long start = System.currentTimeMillis();
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
			Page.setPageSize(request, (BaseActionForm) actionForm);
			this.doCheckpermit(actionForm, user);
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			CityrecordListVO listVO = new CityrecordListVO();						
			String _sin_opnid = "";
			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {				
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
			}
			
			DataPackage ret = new DataPackage();
			//取消每次查询涉及数据不超过一百万条限制
//			if("1".equals(cityrecordForm.get_pageno().trim())){//只在查询第一页时检查
//				//统计根据界面条件涉及的明细数量， 如果超过设定的阀值，则提醒用户增加查询限定条件
//				setListVO(listVO, cityrecordForm);
//				listVO.set_sin_opnid(_sin_opnid);
//				ret = delegate.doListstatcount(listVO, user);			
//				if(ret.getRowCount()>MILLION){
//					throw new BusinessException(null,"涉及明细数据量超过"+(MILLION/10000)+"万条，请增加界面限定条件");
//				}
//			}	
//			if(!"1".equals(cityrecordForm.get_pageno().trim()) || ret.getRowCount()!=0){
				//非第一页或者记录数大于零时，查询数据
				setListVO(listVO, cityrecordForm);	
				listVO.set_sin_opnid(_sin_opnid);
				ret = delegate.doListstat(listVO, user);
//			}			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ret);
			long interval = System.currentTimeMillis()-start;
			System.out.println("本次查询耗时："+interval);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return (actionMapping.findForward("issueconfirm"));
	}

	// 只进入页面，而不查询
	public ActionForward doListstatshow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		CityrecordListVO listVO = new CityrecordListVO();
		Page.setPageSize(request, (BaseActionForm) actionForm);
		setListVO(listVO, actionForm);
		return (actionMapping.findForward("issueconfirm"));
	}

	public ActionForward doListwithtree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		try{
			this.doCheckpermit(actionForm, user);	
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			cityrecordForm.setSupportPaymonth(this.isSupportPaymonth(user));
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
					
		return (actionMapping.findForward("issueconfirm"));
	}

	/**
	 * 市公司酬金发布确认页面之全部确认
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAllconfirm(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
//2012-08-27 取消时间限制
//			String rewardmonth = cityrecordForm.get_se_rewardmonth();
//			ChAdtDictparamDelegate dictdelegate = new ChAdtDictparamDelegate();
//			ChAdtDictparamVO dictvo = dictdelegate.doFindByPk("CONFIRMTIME",
//					user);
//			if (dictvo != null) {
//				String[] dvalues = dictvo.getDvalue().split(",");
//				String drewardmonth = dvalues[0];
//				String dlimitdate = dvalues[1];
//				String sysdate = new SimpleDateFormat("yyyyMMdd")
//						.format(new Date());
//				if (dlimitdate.compareTo(sysdate) < 0) {// 上传截止时间yyyymmdd小于系统当前日期
//					if (rewardmonth.compareTo(drewardmonth) <= 0) {// 不允许对‘结算月份’为YYYYMM的月份及之前月份数据进行操作
//						request.setAttribute(
//								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//								"已经截止当前月份数据确认操作！");
//						return this.doListstat(actionMapping, actionForm,
//								request, response, user);
//					}
//				} else {// 上传截止时间yyyymmdd大于等于系统当前日期
//					if (rewardmonth.compareTo(drewardmonth) < 0) {// 不允许对‘结算月份’为YYYYMM的月份之前月份数据进行操作
//						request.setAttribute(
//								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//								"已经截止当前月份数据确认操作！");
//						return this.doListstat(actionMapping, actionForm,
//								request, response, user);
//					}
//				}
//			}
			Page.setPageSize(request, (BaseActionForm) actionForm);
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO listVO = new CityrecordListVO();
			setListVO(listVO, cityrecordForm);
			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
				listVO.set_sin_opnid(_sin_opnid);
			}
			int result = delegate.doAllConfirm(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "总计确认"+result+"条明细");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			throw e;
		}
		return this.doListstat(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doSelectopntree3(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			String contextPath = request.getContextPath();
			String showtext = "";
			String opnid = (StringUtils.equals("undefined", request
					.getParameter("opnid")) || StringUtils.isEmpty(request
					.getParameter("opnid"))) ? "0" : request
					.getParameter("opnid");
			String topChildrenURI = "selectOperationXml.jsp";
			String opnproxy = "";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			OperationDelegate delegate = new OperationDelegate();
			OperationVO operationVO = delegate.doFindByPk(opnid, user);
			if (operationVO == null && "0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
				opnproxy = "1";
			} else {
				rootName = operationVO.getName();
				rootAdaId = operationVO.getOpnid().toString();
				if ("0".equals(operationVO.getParentid())) {
					opnproxy = "2";
				} else {
					opnproxy = (delegate.getParentlevel(operationVO, user) + 1)
							+ "";
				}
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/operation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=opn").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/operation/").append(
							topChildrenURI).append("&opnproxy=").append(
							opnproxy).append("&opntype=5").append("&times=")
					.append((new Date()).getTime());
			if (!"1".equals(opnproxy)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			// 如果要求输入的级别大于用户所在的级别，则提示下面的信息

			if (Integer.valueOf(opnproxy).intValue() > 6) {
				rootAdaId = operationVO.getOpnid().toString();
				rootName = operationVO.getName();
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			}

			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("opnproxy", opnproxy);
			request.setAttribute("parentType", "opn");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			// log.error(e);
			request.setAttribute("rootAdaId", null);
		}
		return actionMapping.findForward("selectopntree3");
	}

	/*
	 * 市公司酬金发布确认管理 -->查看明细
	 */
	public ActionForward doListdetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm)actionForm);
		try {
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO listVO = new CityrecordListVO();
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			setListVO(listVO, cityrecordForm);

			String opnid2 = "";
			String rewardtype = "";
			String oprmonth = "";
			String isflag = "";

			// 点击查看明细进入-参数处理
			if (request.getParameter("flg") != null	&& "false".equals(request.getParameter("flg"))) {
				cityrecordForm.set_pageno("1");
				// 点击明细进入的时候，opnid2，rewardtype，oprmonth，isflag是由那一条明细数据带进来的
				opnid2 = request.getParameter("opnid2");
				rewardtype = request.getParameter("rewardtype");
				oprmonth = request.getParameter("oprmonth");
				isflag = request.getParameter("isflag");

				if (cityrecordForm.get_sin_opnid() != null	&& !"".equals(cityrecordForm.get_sin_opnid())) {
					String _sin_opnid_bak = "";
					String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
					for (int i = 0; i < opnidandnames.length; i++) {
						String[] opnidandname = opnidandnames[i].split("-");
						String opnid = opnidandname[0];
						_sin_opnid_bak += "'" + opnid.trim() + "',";
					}
					_sin_opnid_bak = _sin_opnid_bak.substring(0, _sin_opnid_bak.length() - 1);

					listVO.set_sin_opnid(_sin_opnid_bak);
					cityrecordForm.set_sin_opnid(_sin_opnid_bak);
				}
			} else {
				// 点击明细的上一页下一页的时候调用的
				opnid2 = cityrecordForm.getOpnid2();
				rewardtype = cityrecordForm.getRewardtype().toString();
				oprmonth = cityrecordForm.getOprmonth();
				isflag = request.getParameter("isflag");
			}
			DataPackage pack = delegate.doListdetail(listVO, opnid2, rewardtype, oprmonth,isflag,user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			throw e;
		}
		return actionMapping.findForward("detail");
	}

	// 单条确认
	public ActionForward doConfirmone(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try {
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO listVO = new CityrecordListVO();			
			setListVO(listVO, cityrecordForm);
			if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
				listVO.set_sin_opnid(_sin_opnid);
			}			
			String opnid2 = request.getParameter("opnid2");
			String rewardtype = request.getParameter("rewardtype");
			String oprmonth = request.getParameter("oprmonth");
			int result = delegate.doConfirmone(listVO, opnid2, rewardtype, oprmonth, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "确认"+result+"条明细");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			throw e;
		}
		return this.doListstat(actionMapping, actionForm, request, response,user);
	}

	public ActionForward doSelectlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			// 点击查看明细进入-参数处理
			if (request.getParameter("flg") != null
					&& "false".equals(request.getParameter("flg"))) {
				cityrecordForm.setPrePageno(cityrecordForm.get_pageno());
				cityrecordForm.set_pageno("1");
				if (request.getParameter("wayid") != null) {
					cityrecordForm.setPreWayid(cityrecordForm.get_se_wayid());
					cityrecordForm.set_se_wayid(request.getParameter("wayid"));
				}
				if (request.getParameter("opnid") != null) {
					cityrecordForm.setPreOpnid(cityrecordForm.get_se_opnid());
					cityrecordForm.set_se_opnid(request.getParameter("opnid"));
				}
				if (request.getParameter("rewardtype") != null) {
					cityrecordForm.setPreRewardtype(cityrecordForm
							.get_ne_rewardtype());
					cityrecordForm.set_ne_rewardtype(request
							.getParameter("rewardtype"));
				}
				if (request.getParameter("rewardmonth") != null) {
					cityrecordForm.setPreRewardmonth(cityrecordForm
							.get_se_rewardmonth());
					cityrecordForm.set_se_rewardmonth(request
							.getParameter("rewardmonth"));
				}
			}

			CityrecordListVO cityrecordListVO = new CityrecordListVO();
			setListVO(cityrecordListVO, cityrecordForm);
			cityrecordListVO.set_se_countyid(null);//明细查询已经限定了渠道编码，无需分公司条件
			CityrecordDelegate delegate = new CityrecordDelegate();
			DataPackage pack = delegate.doQueryDetail(cityrecordListVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}		
		return (actionMapping.findForward("selectlist"));
	}

	public ActionForward doAllissue2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return null;
	}
	
	// 全部同步
	public ActionForward doAssiuepage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
		String _sin_opnid_bak = "";
		if(cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid().trim())){
			String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
			for (int i = 0; i < opnidandnames.length; i++) {
				_sin_opnid_bak += opnidandnames[i].split("-")[0].trim() + ",";
			}
			_sin_opnid_bak = _sin_opnid_bak.substring(0, _sin_opnid_bak.length() - 1);
		}
		if(_sin_opnid_bak.length() > 300){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "业务编码（多选）条件选择过多，请减少选择的业务编码数量");
			return (actionMapping.findForward("list"));
		}
		
		ChAdtRewardsyninfoVO vo = new ChAdtRewardsyninfoVO();
		vo.setRewardmonth(cityrecordForm.get_se_rewardmonth());
		vo.setSystemflag(Short.parseShort(cityrecordForm.get_ne_systemflag()));
		if (cityrecordForm.get_se_countyid() != null) {
			vo.setCountyid(cityrecordForm.get_se_countyid());
		}
		if (cityrecordForm.get_se_wayid() != null) {
			vo.setWayid(cityrecordForm.get_se_wayid());
		}
		if (cityrecordForm.get_se_chainhead() != null) {
			vo.setChainhead(cityrecordForm.get_se_chainhead());
		}
		if (cityrecordForm.get_se_mobile() != null) {
			vo.setMobile(cityrecordForm.get_se_mobile());
		}
		vo.setOpnids(_sin_opnid_bak);
		vo.setTaskstate(new Byte("2"));
		vo.setOperid(user.getOpercode());
		vo.setOptime(new Date());
		
		ChAdtRewardsyninfoDelegate delegate = new ChAdtRewardsyninfoDelegate();
		vo = delegate.doCreate(vo, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同步任务号：" + vo.getTaskid());
		request.setAttribute("disable", true);
		return actionMapping.findForward("list");
	}

	// 全部同步
	public ActionForward doAssiuepage_back(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {		
		RewarduploadDelegate rewarduploaddelegate = new RewarduploadDelegate();
		RewarduploadListVO listVO = new RewarduploadListVO();
		listVO.set_nne_taskstate("0");
		DataPackage dp0 = rewarduploaddelegate.doQuery(listVO, user);
		if (null != dp0 && dp0.getDatas().size() > 0) {
			// throw new Exception("后台正在处理上传文件不能发布！");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"后台正在处理上传文件不能同步！");
			return doList(actionMapping, actionForm, request, response, user);
		}
		
		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
		CityrecordListVO clistVO = new CityrecordListVO();
		setListVO(clistVO, cityrecordForm);
		if (cityrecordForm.get_sin_opnid() != null && !"".equals(cityrecordForm.get_sin_opnid())) {
			String _sin_opnid = "";
			String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
			for (int i = 0; i < opnidandnames.length; i++) {
				String[] opnidandname = opnidandnames[i].split("-");
				String opnid = opnidandname[0];
				_sin_opnid += "'" + opnid.trim() + "',";
			}
			_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);

			clistVO.set_sin_opnid(_sin_opnid);
		}
		CityrecordDelegate delegate = new CityrecordDelegate();
		DataPackage count = delegate.doThreeQueryEhanceCount(clistVO, user);
		if(count.getRowCount()>MILLION){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"涉及明细数据量超过"+(MILLION/10000)+"万条，请增加界面限定条件");
			return (actionMapping.findForward("list"));
		}
		
		request.setAttribute("systemflag", cityrecordForm.get_ne_systemflag());
		request.setAttribute("rewardmonth", cityrecordForm.get_se_rewardmonth());
		request.setAttribute("isflag", cityrecordForm.get_ne_isflag());
		// 另外的参数
		request.setAttribute("wayid", cityrecordForm.get_se_wayid());
		request.setAttribute("chainhead", cityrecordForm.get_se_chainhead());
		request.setAttribute("mobile", cityrecordForm.get_se_mobile());
		request.setAttribute("countyid", cityrecordForm.get_se_countyid());
		request.setAttribute("taskid", cityrecordForm.get_ne_taskid());		
		if(cityrecordForm.get_sin_opnid()!=null && !"".equals(cityrecordForm.get_sin_opnid().trim())){
			String _sin_opnid_bak = "";
			String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
			for (int i = 0; i < opnidandnames.length; i++) {
				String[] opnidandname = opnidandnames[i].split("-");
				String opnid = opnidandname[0];
				_sin_opnid_bak += "'" + opnid.trim() + "',";
			}
			_sin_opnid_bak = _sin_opnid_bak.substring(0, _sin_opnid_bak.length() - 1);
			request.setAttribute("sin_opnid", _sin_opnid_bak);
		}else{
			request.setAttribute("sin_opnid", "");
		}

		request.setAttribute("disable", "false");
		return actionMapping.findForward("batchissue");
	}

	/**
	 * 导出Excel文件,上传管理界面
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;

		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("市公司酬金明细上传发布管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间:",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道标识");
		export.addOutputProperty("wayid", "渠道名称", export.CODE2NAME, "#WAY");
		export.addOutputProperty("opnid", "业务编码");
		export.addOutputProperty("opnid", "业务名称", export.CODE2NAME,
				"#OPERATION");
		export.addOutputProperty("rewardtypename", "酬金期数");
		export.addOutputProperty("rewardmonth", "结算月份");
		export.addOutputProperty("sumbusivalue", "业务量或业务发生金额");
		export.addOutputProperty("sumpaysum", "应发酬金合计");
		export.addOutputProperty("sumpaymoney", "本期应发酬金");

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		// if("2".equals(params.get_ne_isflag()) &&
		// "2".equals(params.get_ne_systemflag())){
		if ("3".equals(cityrecordForm.get_ne_systemflag())
				&& "1".equals(cityrecordForm.get_ne_isflag())) {
			export.voClassArray = new Class[] { VBbcRewardrecord2VO.class };
		} else if ("2".equals(cityrecordForm.get_ne_systemflag())
				&& "1".equals(cityrecordForm.get_ne_isflag())) {
			export.voClassArray = new Class[] { VRewardrecordVO.class };
		} else {
			export.voClassArray = new Class[] { CityrecordtotalVO.class };
		}
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response,
				user, this);

		return null;
	}

	/**
	 * 导出Excel文件,市公司酬金确认管理
	 */
	public ActionForward doExcelissue(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("市公司酬金确认管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("opnid1", "业务类型", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("opnid2", "业务归属", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("rewardtype", "酬金期数", export.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("oprmonth", "业务发生月");
		export.addOutputProperty("sumbusivalue", "业务量或业务发生金额",export.NUMBER,"0.00");
		export.addOutputProperty("sumpaymoney", "总应结酬金",export.NUMBER,"0.00");
		export.addOutputProperty("sumconfirmmoney", "已确认",export.NUMBER,"0.00");
		export.addOutputProperty("sumnotconfirmmoney", "待发布确认",export.NUMBER,"0.00");

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] { VCityrecordVO.class };

		//export.queryMethodName = "doListstatexcel";
		export.queryMethodName = "doListstat";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return null;
	}

	/**
	 * 市公司酬金确认查询统计方法
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doListstatexcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			CityrecordDelegate delegate = new CityrecordDelegate();
			Page.setPageSize(request, (BaseActionForm) actionForm);
			CityrecordListVO listVO = new CityrecordListVO();
			Page.setPageSize(request, (BaseActionForm) actionForm);

			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			
			if(cityrecordForm.get_sin_opnid()!=null && !"".equals(cityrecordForm.get_sin_opnid().trim())){
				String _sin_opnid_bak = "";
				String[] opnidandnames = cityrecordForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid_bak += "'" + opnid.trim() + "',";
				}
				_sin_opnid_bak = _sin_opnid_bak.substring(0, _sin_opnid_bak.length() - 1);

				listVO.set_sin_opnid(_sin_opnid_bak);
				cityrecordForm.set_sin_opnid(_sin_opnid_bak);
			}			

			setListVO(listVO, actionForm);
			listVO.set_pagesize("9999");
			DataPackage pack = delegate.doListstatexcel(listVO, user);
			// 最后一行统计的dp
			// DataPackage dp = delegate.doOnlysum(listVO, user);
			
			double sumpaymoney= 0.0;
			double sumconfirmmoney = 0.0;
			double sumnotconfirmmoney = 0.0;
			if(pack!=null && pack.getDatas().size()>0){//从缓存中获取酬金类型，用于翻译
				for(Iterator<VCityrecordVO> iter = pack.getDatas().iterator();iter.hasNext();){
					VCityrecordVO vo = iter.next();
					sumpaymoney = sumpaymoney+vo.getSumpaymoney();
					sumconfirmmoney = sumconfirmmoney + vo.getSumconfirmmoney();
					sumnotconfirmmoney = sumnotconfirmmoney + vo.getSumnotconfirmmoney();
					try{
						String name = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), vo.getDictname());
						vo.setDictname(name);
					}catch(Exception ex){
						System.out.println("ChrewardtypeCacheUtil缓存有问题，不翻译");//缓存有问题，不翻译
					}
				}
			}
			
			VCityrecordVO total = new VCityrecordVO();
			total.setOprmonth("应付酬金");
			total.setSumpaymoney(sumpaymoney);
			total.setSumconfirmmoney(sumconfirmmoney);
			total.setSumnotconfirmmoney(sumnotconfirmmoney);
			total.setOpnid1("");
			total.setOpnid2("");
			total.setDictname("");
			
			pack.getDatas().add(total);			
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			// request.setAttribute("dp", dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("issueconfirm"));
	}

	// 测试上传【酬金管理】-【本地酬金管理】-【市公司酬金明细上传发布管理】-增加历史发布’结果导出‘功能
	public ActionForward doDownload2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		FtpInfo ftpInfo = null;
		ftpInfo = ResPubUtil.getFtpInfo(user);

		FtpAccess ftp = new FtpAccess(ftpInfo);
		String[] str = ftp.getFileList("/zs");
		for (int i = 0; i < str.length; i++) {

			System.out.println("==================" + str[i]);

		}
		String maxdate = str[0];
		for (int j = 0; j < str.length; j++) {

			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd-HH-mm-ss");
			Date startdate;
			Date enddate;
			try {
				startdate = format.parse(getFormatStr(maxdate));
				enddate = format.parse(getFormatStr(str[j]));
				System.out.println("++++"
						+ ((getMillis(startdate) - getMillis(enddate)) / 1000)
						+ "-----");
				if ((getMillis(startdate) - getMillis(enddate)) / 1000 < 0) {
					maxdate = str[j];
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("=======最大的序号==========" + maxdate);

		// String localFileName="D:/ZS/ZS/pboss_39125149312113.txt";
		// String remotePath="/ZS";
		// boolean genFileName=false;
		// String succ = ftp.uploadFile(localFileName, remotePath, genFileName);

		return (actionMapping.findForward("null"));
	}

	// 【酬金管理】-【本地酬金管理】-【市公司酬金明细上传发布管理】-增加历史发布’结果导出‘功能
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String filename = null;
		try {
			// filename 实际上是 remoteFilePath ，文件名包括路径 ,
			// /ZS/pboss_3912542572735.txt
			// filename = getFilePath(actionForm, user, request);
			// filename = "/zs/ZS_pboss_2012-06-18-19-50-56.txt";
			FtpInfo ftpInfo = null;
			ftpInfo = ResPubUtil.getFtpInfo(user);

			FtpAccess ftp = new FtpAccess(ftpInfo);

			// 获得全省各个地市的存放的公共目录，eg"/appdatas/"
			ChAdtDictparamDelegate de = new ChAdtDictparamDelegate();
			ChAdtDictparamListVO chadtlistvo = new ChAdtDictparamListVO();
			chadtlistvo.set_se_dkey("thread_result_path");
			DataPackage dp = de.doQuery(chadtlistvo, user);
			String location = "";
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
				if (it.hasNext()) {
					location = it.next().getDvalue();
				}
			} else {
				throw new Exception("没有配置结果文件存放的目录，请联系cmos维护人员配置一下。");
			}

			String ftppath = location
					+ SessionFactoryRouter.conversionCityid(user.getCityid())
							.toLowerCase() + "/";

			String[] str = ftp.getFileList(ftppath);

			// 取得ftp服务器的目录下面的文件
			String maxdate = str[0];
			for (int j = 0; j < str.length; j++) {

				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd-HH-mm-ss");
				Date startdate;
				Date enddate;
				try {
					startdate = format.parse(getFormatStr(maxdate));
					enddate = format.parse(getFormatStr(str[j]));
					// System.out.println("++++"+((getMillis(startdate)-getMillis(enddate))/1000)+"-----");
					if ((getMillis(startdate) - getMillis(enddate)) / 1000 < 0) {
						maxdate = str[j];
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			filename = ftppath + maxdate;

			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			//ftp.ftp.setFileTransferMode(ftp.ftp.BLOCK_TRANSFER_MODE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
			}

			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());

			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}

	private String getFilePath(ActionForm actionForm, User user,
			HttpServletRequest request) throws Exception { 
		String location = "/";
		location += SessionFactoryRouter.conversionCityid(user.getCityid())
				.toLowerCase()
				+ "/";

		System.out.println("333");
		location = "D:\\ZS\\ZS";
		java.io.File f = new java.io.File(location);

		File[] files = f.listFiles();

		if (files.length == 0) {
			throw new Exception("存放文件路径错误,没有配置结果文件存放的目录，请联系cmos维护人员配置一下!");
		}
		String maxdate = files[0].getName();
		for (int j = 0; j < files.length; j++) {

			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd-HH-mm-ss");
			Date startdate;
			Date enddate;
			try {
				startdate = format.parse(getFormatStr(maxdate));
				enddate = format.parse(getFormatStr(files[j].getName()));
				System.out.println("++++"
						+ ((getMillis(startdate) - getMillis(enddate)) / 1000)
						+ "-----");
				if ((getMillis(startdate) - getMillis(enddate)) / 1000 < 0) {
					maxdate = files[j].getName();
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return location + maxdate;

	}

	public static String getFormatStr(String s) {
		// String s="zs_pboss_2012-06-18-10-35-38.txt";
		return s.substring((s.lastIndexOf("_") + 1), s.lastIndexOf("."));
	}

	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}



	// 把所有的load出来，放到可选项的列表，刷新zoneSource数据
	public ActionForward doAllfifthopnids(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			CityrecordForm form = (CityrecordForm) actionForm;
			OperationListVO listVO = new OperationListVO();
			// String str = request.getParameter("str");
			setListVO(listVO, form); // 设置好listVO，作为查询条件
			OperationDelegate de = new OperationDelegate();
			listVO.set_ne_opnlevel("5");
			listVO.set_pagesize("0");
			DataPackage dp = de.doQuery(listVO, user);
			request.setAttribute("objList", dp);
			form.set_pageno("1");
			form.set_pagesize("9999");
			AAUtils.addZonesToRefresh(request, "zoneData");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionMapping.findForward("toselect");
	}

	// 获取已选择的选项列表
	public ActionForward doAllfifthopnidssel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			CityrecordForm form = (CityrecordForm) actionForm;
			DataPackage dp = new DataPackage();
			List<OperationVO> list = new ArrayList<OperationVO>();
			if (!StringUtils.isEmpty(form.getSelectedStr())) {
				String[] opercodeArray = form.getSelectedStr().split(",");
				for (int i = 0; i < opercodeArray.length; i++) {
					OperationVO vOperationVO = new OperationVO();
					String[] id = opercodeArray[i].split("-");
					for (int j = 0; j < id.length - 1; j++) {
						vOperationVO.setOpnid(id[0]);
						vOperationVO.setName(id[1]);
					}
					list.add(vOperationVO);
				}
			}
			dp.setDatas(list);
			request.setAttribute("dataList", dp);

			AAUtils.addZonesToRefresh(request, "zoneResource");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionMapping.findForward("toselect");
	}
	
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金明细数据查询");  
		export.addOutputProperty("recordid");
		export.addOutputProperty("isflag",CommonExportBean.CODE2NAME,"$CH_ISFLAG");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid",CommonExportBean.CODE2NAME,"#OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("rewardtype",CommonExportBean.CODE2NAME,"$CH_REWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("oprtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile"); 
		export.addOutputProperty("brand"); 
		export.addOutputProperty("busivalue"); 
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("oprcode"); 
		export.addOutputProperty("optime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("systemflag",CommonExportBean.CODE2NAME,"#SYSTEMFLAG"); 
		export.addOutputProperty("accountoprcode");
		export.addOutputProperty("accountoptime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adjustoprcode");
		export.addOutputProperty("adjustoptime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("rewardlistid");
		export.addOutputProperty("taskid");
		export.addOutputProperty("batchno"); 
		if (this.isSupportPaymonth(user)){
		     export.addOutputProperty("paymonth");
			}
		export.voClassArray = new Class[] { CityrecordVO.class };
		export.queryMethodName = "doDetaillist";
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		if (this.isSupportPaymonth(user)){
			export.writeTxtTitle(response.getOutputStream(), new String[] {
				"酬金明细标识", "结算状态", "业务代码","业务代码名称", "渠道标识","渠道名称", "酬金期数", 
				"结算月份", "业务发生时间", "手机号码或IMEI号","品牌",
				"业务量或业务发生金额", "应发酬金合计", "本期应发酬金", "上传/发布工号", "上传/发布时间", 
				"确认工号","确认时间","调整操作工号","调整操作时间","原酬金明细ID","文件任务号","付款批号","付款月份"});
		}else{
	    	export.writeTxtTitle(response.getOutputStream(), new String[] {
				"酬金明细标识", "结算状态", "业务代码","业务代码名称", "渠道标识","渠道名称", "酬金期数", 
				"结算月份", "业务发生时间", "手机号码或IMEI号","品牌",
				"业务量或业务发生金额", "应发酬金合计", "本期应发酬金", "上传/发布工号", "上传/发布时间", 
				"确认工号","确认时间","调整操作工号","调整操作时间","原酬金明细ID","文件任务号","付款批号"});
		}
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
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
			return false;//不存在系统参数则设置为零
		}
    }
	
	
}
