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
	public static final String CH_ADT_CITYRECORD_CNTY ="CH_ADT_CITYRECORD_CNTY";//�ֹ�˾����������
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
		if(form.getIscountyoperid()==-1){//��ʼʱ-1����Ҫ����0�й�˾��1�ֹ�˾
			ACLDelegate acldelegate = new ACLDelegate();   
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_CITYRECORD_CNTY);
			if(citypermit){
				form.setIscountyoperid(0);//�й�˾����
			}else{
				form.setIscountyoperid(1);//�ֹ�˾����
				OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		if(countyid!=null){
	    			form.set_se_countyid(countyid);
	    		}else{
	    			throw new Exception("��¼���ž��зֹ�˾����Ȩ�ޣ������ŷֹ�˾Ϊ��");
	    		}	    		
			}
		}else if(form.getIscountyoperid()==1){//�ֹ�˾Ȩ��
			if(form.get_se_countyid()==null || "".equals(form.get_se_countyid().trim())){//�ֹ�˾����Ϊ��
				throw new Exception("��¼���ž��зֹ�˾����Ȩ�ޣ������ŷֹ�˾Ϊ��");
			}
		}		
	}
	
	public CityrecordAction() {
		setVoClass(CityrecordVO.class);
		// TODO: ������������������
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
	 * ��ѯ
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
			if("1".equals(cityrecordForm.get_pageno())){//�״β�ѯʱ����������⣬��ҳʱ���������
				setListVO(listVO, cityrecordForm);
				listVO.set_sin_opnid(_sin_opnid);
				DataPackage count = delegate.doThreeQueryEhanceCount(listVO, user);
				if(count.getRowCount()>MILLION){
					throw new BusinessException(null,"�漰��ϸ����������"+(MILLION/10000)+"�����������ӽ����޶�����");
				}
			}			
			
			setListVO(listVO, cityrecordForm);
			listVO.set_sin_opnid(_sin_opnid);
			DataPackage pack = delegate.doThreeQueryEhance(listVO, user);
			// ����@ʾopnname
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
		System.out.println("ͳ�Ʋ�ѯ��ʱ��"+interval);
		return (actionMapping.findForward("list"));
	}
	
	/**
	 * COMS��ϸ������ѯ���ݣ�����Ӧ�κν���
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
				throw new Exception("ֻ����[����������]��[�������˳��]��\"��ȷ��\"���ݽ���COMS��ϸ��������");
			}
			if(!"2".equals(cityrecordForm.get_ne_systemflag()) && !"3".equals(cityrecordForm.get_ne_systemflag())){
				throw new Exception("ֻ����[����������]��[�������˳��]��\"��ȷ��\"���ݽ���COMS��ϸ��������");
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
		export.setFileName("COMS��ϸ����");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("opnid", "ҵ�����");
		export.addOutputProperty("rewardtype", "�������");
		export.addOutputProperty("mobile", "�ֻ�����ֵ�������IMEI��");
		export.addOutputProperty("rewardmonth", "�����·�");
		export.addOutputProperty("oprtime", "ҵ����ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("busivalue", "ҵ������ҵ�������");
		export.addOutputProperty("paysum", "Ӧ�����ϼ�");
		
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
			"��������","ҵ�����","�������","�ֻ�����ֵ�������IMEI��",
			"�����·�","ҵ����ʱ��","ҵ������ҵ�������","Ӧ�����ϼ�"});
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
		// ��ѯ�������,��ҳ��ѯ
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
					if(pwvo.getPaymoney1()!=null && pwvo.getPaymoney1()!=0){//��һ�ڲ�Ϊ��
						VCityrecord4VO vo1 = new VCityrecord4VO();
						BeanUtils.copyProperties(vo1, pwvo);
						vo1.setSeq(++seq);
						vo1.setRewardmonth(pwvo.getPaymonth1());
						vo1.setPaysum(pwvo.getPaymoney1());
						listmulti.add(vo1);
					}
					if(pwvo.getPaymoney2()!=null && pwvo.getPaymoney2()!=0){//�ڶ��ڲ�Ϊ��
						VCityrecord4VO vo2 = new VCityrecord4VO();
						BeanUtils.copyProperties(vo2, pwvo);
						vo2.setSeq(++seq);
						vo2.setRewardmonth(pwvo.getPaymonth2());
						vo2.setPaysum(pwvo.getPaymoney2());
						listmulti.add(vo2);
					}					
					if(pwvo.getPaymoney3()!=null && pwvo.getPaymoney3()!=0){//�����ڲ�Ϊ��
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
						|| ((dp.getRowCount()+CommonExportBean.EXCELOUT_PAGE_SIZE-1)/CommonExportBean.EXCELOUT_PAGE_SIZE)<=startindex) {// �������һҳ
					break;
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}

	/**
	 * �����ϸ��ѯ--�״ν������
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
	 * �����ϸ��ѯ
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
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"�����ӹ�������,һ���Բ�ѯ������ܳ���100��");
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
	 * ȫ��ɾ��
	 */
	public ActionForward doDeleteall(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			CityrecordForm cityrecordForm = (CityrecordForm) actionForm;
			String isflag = cityrecordForm.get_ne_isflag();
			if(!"1".equals(isflag)){
				throw new BusinessException("","ֻ��ɾ������ȷ�ϡ�״̬�ĳ����ϸ��¼!");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ����ȷ������"+num+"��");
			request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		}catch(BusinessException ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
		}catch(Exception ex){
			
		}
		return (actionMapping.findForward("detaillist"));
	}
	
	/**
	 * ɾ��
	 */
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
			String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
			CommonDelegate delegate = new CommonDelegate(voClass);
			String isflag = "1";//��ȷ��
			for (int i = 0; i < selectArray.length; i++) {
				String[] keys = selectArray[i].split("\\|");
				if(!isflag.equals(keys[1])){
					throw new BusinessException("","ֻ��ɾ������ȷ�ϡ�״̬�ĳ����ϸ��¼!");
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
	 * �����ϴ�
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
	 * ɾ��
	 * 20120914 ���ù��ܴ�[���г����ϸ�ϴ�����]Ǩ�Ƶ�[�����ϸ���ݲ�ѯ]�˵�
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
//					throw new BusinessException("","����ɾ����ȷ�ϵĳ����ϸ��¼!");
//				}else if( "2".equals(isflag) && "2".equals(systemflag) ){
//					throw new BusinessException("","����ɾ�����������ȷ�ϵĳ����ϸ��¼!");
//				}else if( "2".equals(isflag) && "3".equals(systemflag) ){
//					throw new BusinessException("","����ɾ���������˴�ȷ�ϵĳ����ϸ��¼!");
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
	 * ȫ��ɾ��
	 * 20120914 ���ù��ܴ�[���г����ϸ�ϴ�����]Ǩ�Ƶ�[�����ϸ���ݲ�ѯ]�˵�
	 * <input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="ȫ��ɾ��"
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
//				throw new BusinessException("","����ɾ����ȷ�ϵĳ����ϸ��¼!");
//			}else if( "2".equals(isflag) && "2".equals(systemflag) ){
//				throw new BusinessException("","����ɾ�����������ȷ�ϵĳ����ϸ��¼!");
//			}else if( "2".equals(isflag) && "3".equals(systemflag) ){
//				throw new BusinessException("","����ɾ���������˴�ȷ�ϵĳ����ϸ��¼!");
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
	 * ͬ�� 
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"��̨���ڴ����ϴ��ļ�����ͬ����");
			return doList(actionMapping, actionForm, request, response, user);
		}

		// ����Ƿ��з�����������ֹ����һ��thread������һ��������CH_ADT_DICTPARAM����
		// thread_ch_pw_Rewardrecord,thread_ch_bbc_Rewardrecord,dvalue��ֵΪ1�Ͳ����ڽ�����
		ChAdtDictparamDelegate de = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		if ("2".equals(cityrecordForm.get_ne_systemflag())) {
			listvo.set_se_dkey("thread_ch_pw_rewardrecord");
			DataPackage dp = de.doQuery(listvo, user);
			Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
			if (it.hasNext()) {
				if ("1".equals(it.next().getDvalue())) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"��������������ͬ������ȴ���ɺ�������");
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
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"��н���˳����ͬ������ȴ���ɺ�������");
					return doList(actionMapping, actionForm, request, response,	user);
				}
			}
		}

		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();

		int successflag = 0;// δͬ���ɹ�
		try {
			CityrecordDelegate delegate = new CityrecordDelegate();
			CityrecordListVO cityrecordListVO = new CityrecordListVO();
			setListVO(cityrecordListVO, cityrecordForm);			

			// ��ֹ����һ��thread������һ��������CH_ADT_DICTPARAM����
			// thread_ch_pw_Rewardrecord,thread_ch_bbc_Rewardrecord,dvalue��ֵΪ1�Ͳ����ڽ�����
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
			
			//ͬ��
			int failnum = 0;//ͬ��ʧ�ܼ�¼��
			String errmsg= "";//������Ϣ
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
				successflag = 1;// �����ɹ�
			}else{
				successflag = 0;// δ�����ɹ�
				if(errmsg.length()>=256){
					errmsg = errmsg.substring(0,256);
				}
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, errmsg);
			}
		}catch (Exception e) {
			successflag = 0;// δ�����ɹ�
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			e.printStackTrace();
		}finally {
			// ��ֹ����һ��thread������һ��������CH_ADT_DICTPARAM����
			// thread_ch_pw_Rewardrecord
			// ,thread_ch_bbc_Rewardrecord,dvalue��ֵΪ1�Ͳ����ڽ�����
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ͬ���ɹ�");
		}
		return doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * ȫ������
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
		int successflag = 0;// δ�����ɹ�
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
			successflag = 1;// �����ɹ�
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
			successflag = 0;// δ�����ɹ�
		} catch (Exception e) {
			successflag = 0;// δ�����ɹ�
			throw e;
		}
		if (successflag == 1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ȫ�������ɹ�");
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	// ����ȷ��
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
	 * �й�˾���ȷ�ϲ�ѯͳ�Ʒ���
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
			//ȡ��ÿ�β�ѯ�漰���ݲ�����һ����������
//			if("1".equals(cityrecordForm.get_pageno().trim())){//ֻ�ڲ�ѯ��һҳʱ���
//				//ͳ�Ƹ��ݽ��������漰����ϸ������ ��������趨�ķ�ֵ���������û����Ӳ�ѯ�޶�����
//				setListVO(listVO, cityrecordForm);
//				listVO.set_sin_opnid(_sin_opnid);
//				ret = delegate.doListstatcount(listVO, user);			
//				if(ret.getRowCount()>MILLION){
//					throw new BusinessException(null,"�漰��ϸ����������"+(MILLION/10000)+"�����������ӽ����޶�����");
//				}
//			}	
//			if(!"1".equals(cityrecordForm.get_pageno().trim()) || ret.getRowCount()!=0){
				//�ǵ�һҳ���߼�¼��������ʱ����ѯ����
				setListVO(listVO, cityrecordForm);	
				listVO.set_sin_opnid(_sin_opnid);
				ret = delegate.doListstat(listVO, user);
//			}			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ret);
			long interval = System.currentTimeMillis()-start;
			System.out.println("���β�ѯ��ʱ��"+interval);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return (actionMapping.findForward("issueconfirm"));
	}

	// ֻ����ҳ�棬������ѯ
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
	 * �й�˾��𷢲�ȷ��ҳ��֮ȫ��ȷ��
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
//2012-08-27 ȡ��ʱ������
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
//				if (dlimitdate.compareTo(sysdate) < 0) {// �ϴ���ֹʱ��yyyymmddС��ϵͳ��ǰ����
//					if (rewardmonth.compareTo(drewardmonth) <= 0) {// ������ԡ������·ݡ�ΪYYYYMM���·ݼ�֮ǰ�·����ݽ��в���
//						request.setAttribute(
//								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//								"�Ѿ���ֹ��ǰ�·�����ȷ�ϲ�����");
//						return this.doListstat(actionMapping, actionForm,
//								request, response, user);
//					}
//				} else {// �ϴ���ֹʱ��yyyymmdd���ڵ���ϵͳ��ǰ����
//					if (rewardmonth.compareTo(drewardmonth) < 0) {// ������ԡ������·ݡ�ΪYYYYMM���·�֮ǰ�·����ݽ��в���
//						request.setAttribute(
//								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//								"�Ѿ���ֹ��ǰ�·�����ȷ�ϲ�����");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�ܼ�ȷ��"+result+"����ϸ");
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
				rootName = "ҵ������";
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
				showtext = "��ѡ��ҵ������";
			}
			// ���Ҫ������ļ�������û����ڵļ�������ʾ�������Ϣ

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
	 * �й�˾��𷢲�ȷ�Ϲ��� -->�鿴��ϸ
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

			// ����鿴��ϸ����-��������
			if (request.getParameter("flg") != null	&& "false".equals(request.getParameter("flg"))) {
				cityrecordForm.set_pageno("1");
				// �����ϸ�����ʱ��opnid2��rewardtype��oprmonth��isflag������һ����ϸ���ݴ�������
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
				// �����ϸ����һҳ��һҳ��ʱ����õ�
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

	// ����ȷ��
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ȷ��"+result+"����ϸ");
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
			// ����鿴��ϸ����-��������
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
			cityrecordListVO.set_se_countyid(null);//��ϸ��ѯ�Ѿ��޶����������룬����ֹ�˾����
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
	
	// ȫ��ͬ��
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ҵ����루��ѡ������ѡ����࣬�����ѡ���ҵ���������");
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
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ͬ������ţ�" + vo.getTaskid());
		request.setAttribute("disable", true);
		return actionMapping.findForward("list");
	}

	// ȫ��ͬ��
	public ActionForward doAssiuepage_back(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {		
		RewarduploadDelegate rewarduploaddelegate = new RewarduploadDelegate();
		RewarduploadListVO listVO = new RewarduploadListVO();
		listVO.set_nne_taskstate("0");
		DataPackage dp0 = rewarduploaddelegate.doQuery(listVO, user);
		if (null != dp0 && dp0.getDatas().size() > 0) {
			// throw new Exception("��̨���ڴ����ϴ��ļ����ܷ�����");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"��̨���ڴ����ϴ��ļ�����ͬ����");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"�漰��ϸ����������"+(MILLION/10000)+"�����������ӽ����޶�����");
			return (actionMapping.findForward("list"));
		}
		
		request.setAttribute("systemflag", cityrecordForm.get_ne_systemflag());
		request.setAttribute("rewardmonth", cityrecordForm.get_se_rewardmonth());
		request.setAttribute("isflag", cityrecordForm.get_ne_isflag());
		// ����Ĳ���
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
	 * ����Excel�ļ�,�ϴ��������
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CityrecordForm cityrecordForm = (CityrecordForm) actionForm;

		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�й�˾�����ϸ�ϴ���������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��:",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "������ʶ");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAY");
		export.addOutputProperty("opnid", "ҵ�����");
		export.addOutputProperty("opnid", "ҵ������", export.CODE2NAME,
				"#OPERATION");
		export.addOutputProperty("rewardtypename", "�������");
		export.addOutputProperty("rewardmonth", "�����·�");
		export.addOutputProperty("sumbusivalue", "ҵ������ҵ�������");
		export.addOutputProperty("sumpaysum", "Ӧ�����ϼ�");
		export.addOutputProperty("sumpaymoney", "����Ӧ�����");

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
	 * ����Excel�ļ�,�й�˾���ȷ�Ϲ���
	 */
	public ActionForward doExcelissue(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�й�˾���ȷ�Ϲ���");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("opnid1", "ҵ������", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("opnid2", "ҵ�����", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("rewardtype", "�������", export.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("oprmonth", "ҵ������");
		export.addOutputProperty("sumbusivalue", "ҵ������ҵ�������",export.NUMBER,"0.00");
		export.addOutputProperty("sumpaymoney", "��Ӧ����",export.NUMBER,"0.00");
		export.addOutputProperty("sumconfirmmoney", "��ȷ��",export.NUMBER,"0.00");
		export.addOutputProperty("sumnotconfirmmoney", "������ȷ��",export.NUMBER,"0.00");

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
	 * �й�˾���ȷ�ϲ�ѯͳ�Ʒ���
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
			// ���һ��ͳ�Ƶ�dp
			// DataPackage dp = delegate.doOnlysum(listVO, user);
			
			double sumpaymoney= 0.0;
			double sumconfirmmoney = 0.0;
			double sumnotconfirmmoney = 0.0;
			if(pack!=null && pack.getDatas().size()>0){//�ӻ����л�ȡ������ͣ����ڷ���
				for(Iterator<VCityrecordVO> iter = pack.getDatas().iterator();iter.hasNext();){
					VCityrecordVO vo = iter.next();
					sumpaymoney = sumpaymoney+vo.getSumpaymoney();
					sumconfirmmoney = sumconfirmmoney + vo.getSumconfirmmoney();
					sumnotconfirmmoney = sumnotconfirmmoney + vo.getSumnotconfirmmoney();
					try{
						String name = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), vo.getDictname());
						vo.setDictname(name);
					}catch(Exception ex){
						System.out.println("ChrewardtypeCacheUtil���������⣬������");//���������⣬������
					}
				}
			}
			
			VCityrecordVO total = new VCityrecordVO();
			total.setOprmonth("Ӧ�����");
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

	// �����ϴ���������-�����س�����-���й�˾�����ϸ�ϴ���������-������ʷ�������������������
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
		System.out.println("=======�������==========" + maxdate);

		// String localFileName="D:/ZS/ZS/pboss_39125149312113.txt";
		// String remotePath="/ZS";
		// boolean genFileName=false;
		// String succ = ftp.uploadFile(localFileName, remotePath, genFileName);

		return (actionMapping.findForward("null"));
	}

	// ��������-�����س�����-���й�˾�����ϸ�ϴ���������-������ʷ�������������������
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String filename = null;
		try {
			// filename ʵ������ remoteFilePath ���ļ�������·�� ,
			// /ZS/pboss_3912542572735.txt
			// filename = getFilePath(actionForm, user, request);
			// filename = "/zs/ZS_pboss_2012-06-18-19-50-56.txt";
			FtpInfo ftpInfo = null;
			ftpInfo = ResPubUtil.getFtpInfo(user);

			FtpAccess ftp = new FtpAccess(ftpInfo);

			// ���ȫʡ�������еĴ�ŵĹ���Ŀ¼��eg"/appdatas/"
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
				throw new Exception("û�����ý���ļ���ŵ�Ŀ¼������ϵcmosά����Ա����һ�¡�");
			}

			String ftppath = location
					+ SessionFactoryRouter.conversionCityid(user.getCityid())
							.toLowerCase() + "/";

			String[] str = ftp.getFileList(ftppath);

			// ȡ��ftp��������Ŀ¼������ļ�
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
				throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
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
			throw new Exception("����ļ�·������,û�����ý���ļ���ŵ�Ŀ¼������ϵcmosά����Ա����һ��!");
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



	// �����е�load�������ŵ���ѡ����б�ˢ��zoneSource����
	public ActionForward doAllfifthopnids(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			CityrecordForm form = (CityrecordForm) actionForm;
			OperationListVO listVO = new OperationListVO();
			// String str = request.getParameter("str");
			setListVO(listVO, form); // ���ú�listVO����Ϊ��ѯ����
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

	// ��ȡ��ѡ���ѡ���б�
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
		export.setFileName("�����ϸ���ݲ�ѯ");  
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
				"�����ϸ��ʶ", "����״̬", "ҵ�����","ҵ���������", "������ʶ","��������", "�������", 
				"�����·�", "ҵ����ʱ��", "�ֻ������IMEI��","Ʒ��",
				"ҵ������ҵ�������", "Ӧ�����ϼ�", "����Ӧ�����", "�ϴ�/��������", "�ϴ�/����ʱ��", 
				"ȷ�Ϲ���","ȷ��ʱ��","������������","��������ʱ��","ԭ�����ϸID","�ļ������","��������","�����·�"});
		}else{
	    	export.writeTxtTitle(response.getOutputStream(), new String[] {
				"�����ϸ��ʶ", "����״̬", "ҵ�����","ҵ���������", "������ʶ","��������", "�������", 
				"�����·�", "ҵ����ʱ��", "�ֻ������IMEI��","Ʒ��",
				"ҵ������ҵ�������", "Ӧ�����ϼ�", "����Ӧ�����", "�ϴ�/��������", "�ϴ�/����ʱ��", 
				"ȷ�Ϲ���","ȷ��ʱ��","������������","��������ʱ��","ԭ�����ϸID","�ļ������","��������"});
		}
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
	
	   //�Ƿ�֧�ָ����·�
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
			return false;//������ϵͳ����������Ϊ��
		}
    }
	
	
}
