/**
 * auto-generated code
 * Wed Sep 02 16:37:07 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.unvfaildataquery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryListVO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.unvfaildataquery.UnvFaildataqueryDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: UnvFaildataqueryAction
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
 * @author Linli
 * @version 1.0
 */
public class UnvFaildataqueryAction extends BaseDelegateAction {
	private static final String UNVFAIL_PURVIEW = "CH_B2M_REWARD_PROVINCIAL";
	private static final String PROV_AGENT_VIEW ="CH_UNPB_REWARD_PROVINCIAL";
	
	public UnvFaildataqueryAction() {
		setVoClass(UnvFaildataqueryVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[1];
		pkNameArray[0] = "failid";
	}
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//�˵�����flagΪ�գ�ҳ���ѯflag��ֵ����������������Ĭ��ֵ
		String flag = request.getParameter("flag");
		UnvFaildataqueryForm form = (UnvFaildataqueryForm)actionForm;
		if(!StringUtils.isEmpty(flag))
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			String _se_rcmonth = df.format(c.getTime());
			form.set_se_rcmonth(_se_rcmonth);
		}
		
		//�����Ƿ���ȫʡȨ�ޣ�����ʡ��������ص���
		ProvincialrightDelegate delegate = new ProvincialrightDelegate();
		Boolean hasProvAgentView = Boolean.valueOf(delegate.checkPurview(user, PROV_AGENT_VIEW));
		form.setHasProvAgentView(hasProvAgentView);
		request.setAttribute("ProvAgent",hasProvAgentView);
		
		//�����Ƿ���ȫʡȨ��
		Boolean hasPurview = Boolean.valueOf(delegate.checkPurview(user, UNVFAIL_PURVIEW));
		String cityid = "";
		if(!hasPurview.booleanValue()&& !hasProvAgentView.booleanValue()){
			form.set_ne_citycompid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		}
		else if(!hasPurview.booleanValue()){
			cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			request.setAttribute("cityid", cityid);
		}
		form.setHasPurview(hasPurview);
		request.setAttribute("B2MProv", hasPurview);
		
		//���ֵ���
		String citycompid = form.get_ne_citycompid();
		User userNew = null;
		if(!StringUtils.isEmpty(citycompid) && !citycompid.equals("ProvAgent"))
		{
			userNew = new User();
			BeanUtils.copyProperties(userNew, user);
			userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(citycompid));		
		}
		else
		{
			userNew = user;
		}
		
        return super.doList(actionMapping, form, request, response, userNew);
	}
	
	public ActionForward doShow(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		//�˵�����flagΪ�գ�ҳ���ѯflag��ֵ����������������Ĭ��ֵ
//		String flag = request.getParameter("flag");
		UnvFaildataqueryForm form = (UnvFaildataqueryForm)actionForm;
//		if(!StringUtils.isEmpty(flag))
//		{
//			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
//			Calendar c = Calendar.getInstance();
//			c.add(Calendar.MONTH, -1);
//			String _se_rcmonth = df.format(c.getTime());
//			form.set_se_rcmonth(_se_rcmonth);
//		}
		
		//�����Ƿ���ȫʡȨ�ޣ�����ʡ��������ص���
		ProvincialrightDelegate delegate = new ProvincialrightDelegate();
		Boolean hasProvAgentView = Boolean.valueOf(delegate.checkPurview(user, PROV_AGENT_VIEW));
		form.setHasProvAgentView(hasProvAgentView);
		request.setAttribute("ProvAgent",hasProvAgentView);
		
		//�����Ƿ���ȫʡȨ��
		Boolean hasPurview = Boolean.valueOf(delegate.checkPurview(user, UNVFAIL_PURVIEW));
		String cityid = "";
		if(!hasPurview.booleanValue()&& !hasProvAgentView.booleanValue()){
			form.set_ne_citycompid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		}
		else if(!hasPurview.booleanValue()){
			cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			request.setAttribute("cityid", cityid);
		}
		form.setHasPurview(hasPurview);
		request.setAttribute("B2MProv", hasPurview);
		
		//���ֵ���
//		String citycompid = form.get_ne_citycompid();
//		User userNew = null;
//		if(!StringUtils.isEmpty(citycompid) && !citycompid.equals("ProvAgent"))
//		{
//			userNew = new User();
//			BeanUtils.copyProperties(userNew, user);
//			userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(citycompid));		
//		}
//		else
//		{
//			userNew = user;
//		}
		
		return (actionMapping.findForward("list"));
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("ȫԱ����Ƴ���Ƽ�ʧ�ܼ�¼��ѯ");

		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("employeeid");
		export.addOutputProperty("rcno");
		export.addOutputProperty("opnid");
		export.addOutputProperty("mobileno");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("rcmonth");
		export.addOutputProperty("adtcode", CommonExportBean.CODE2NAME,
				"#ADTCODE");
		export.addOutputProperty("reason");
		export.addOutputProperty("ossrc", CommonExportBean.CODE2NAME,
				"#CH_UNV_OSSRC");
		export.addOutputProperty("batchno");

		export.voClassArray = new Class[] { UnvFaildataqueryVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"�����̱���", "����������", "�Ƽ�רԱ����", "�Ƽ�רԱ����", "ҵ�����", "�ͻ�����", "�Ƴ��·�", "�Ƽ��·�",
				"�Ƴ�ʧ��ԭ��", "�Ƽ�ʧ��ԭ��", "ҵ��ƽ̨��Դ", "���κ�" });
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("calcmonth,wayid,opnid,mobileno");
		
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

	/**
	 * �ƹ�רԱ���뵯����, ֻ����������������������'UNPB'������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		UnvFaildataqueryForm form = (UnvFaildataqueryForm) actionForm;
		try {
			Page.setPageSize(request, form);
			UnvFaildataqueryListVO unvlistvo = new UnvFaildataqueryListVO();
			setListVO(unvlistvo, form);
			UnvFaildataqueryDelegate unvdelegate = new UnvFaildataqueryDelegate();
			DataPackage empdp = unvdelegate.doQueryName(unvlistvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, empdp);

		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
	
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			UnvFaildataqueryForm form = (UnvFaildataqueryForm) actionForm;
			//���ֵ���
			String citycompid = form.get_ne_citycompid();
			User userNew = null;
			if(!StringUtils.isEmpty(citycompid) && !citycompid.equals("ProvAgent")){
				userNew = new User();
				BeanUtils.copyProperties(userNew, user);
				userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(citycompid));
			}
			else{
				userNew = user;
			}
			
			SysparamDelegate sysparamDelegate = new SysparamDelegate();
			SysparamListVO listvo= new SysparamListVO();
			listvo.set_ne_systemid("65");
			listvo.set_se_paramtype("channel");
			DataPackage dp = sysparamDelegate.doQuery(listvo, userNew);//user
			if(dp.getRowCount()==0)
			{
				throw new Exception("������·��ϵͳ���������ڣ���˶ԣ�");
			}
			String path = ((SysparamVO)((List)dp.getDatas()).get(0)).getParamvalue();
			path = path + "fail/";
			String filename = "";	
			
			//�����Ƿ���ȫʡȨ��
			Boolean hasPurview = form.getHasPurview();
			String mohthStr = form.get_se_rcmonth();//�Ƽ��·�
			
			//�����Ƿ���ȫʡȨ�ޣ�����ʡ��������ص���
			Boolean hasProvAgentView = form.getHasProvAgentView();	
			
			//ʡ�������̵���
			if(hasProvAgentView.booleanValue() && citycompid!=null && citycompid.equals("ProvAgent")){
				String calmonth = form.get_se_calcmonth();//�Ƴ��·�
				filename = path + "unpbrewardfail_provinAgent_" + calmonth +".tar.gz";
			}
			//ʡ��Ȩ�ޣ�ȫʡ����
			else if(hasPurview.booleanValue()){
				if("".equals(citycompid) || citycompid==null){
					filename = path + "unpbrewardfail_" + mohthStr + ".tar.gz";
				}else{
					filename = path + "unpbrewardfail_" + mohthStr + "_" + citycompid + ".txt.gz";
				}
			}
			//��ַ����
			else{
				filename = path + "unpbrewardfail_" + mohthStr + "_" + SessionFactoryRouter.conversionCityid(user.getCityid()) + ".txt.gz";
			}			
			
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("�ļ�·��Ϊ�գ�");
			}
			
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(userNew);//user
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null){
				throw new Exception("����ʧ�ܣ�"+ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
}
