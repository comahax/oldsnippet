/**
 * auto-generated code
 * Wed Sep 02 15:01:47 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.unvrewardrecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.unvrewardrecord.UnvRewardrecordDelegate;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
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
 * Title: UnvRewardrecordAction
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
public class UnvRewardrecordAction extends BaseDelegateAction {
	private static final String UNVFAIL_PURVIEW = "CH_B2M_REWARD_PROVINCIAL";
	private static final String PROV_AGENT_VIRE ="CH_UNPB_REWARD_PROVINCIAL";
	private static Log log = LogFactory.getLog(UnvRewardrecordAction.class);
	
	public UnvRewardrecordAction() {
		setVoClass(UnvRewardrecordVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[1];
		pkNameArray[0] = "rewardlistid";
	}

	/**
	 * �жϹ����Ƿ���ȫʡ���Ȩ��
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		ProvincialrightListVO rightvo = new ProvincialrightListVO();
		rightvo.set_se_rightid("CH_B2M_REWARDCONF");
		rightvo.set_se_proopr(user.getOpercode());
		ProvincialrightDelegate delegate = new ProvincialrightDelegate();
		DataPackage dp = delegate.doQuery(rightvo, user);
		if (dp.getRowCount()==0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * ���ý����·�Ĭ��Ϊ��ǰ�µ��ϸ�������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

		Calendar ca = Calendar.getInstance(Locale.CHINA);
		ca.add(Calendar.MONTH, -1);
		((UnvRewardrecordForm) actionForm).set_se_rewardmonth(format.format(ca
				.getTime()));
		((UnvRewardrecordForm) actionForm).set_se_batchno(format.format(ca
				.getTime())+"00");
		return doList(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		UnvRewardrecordForm form = (UnvRewardrecordForm) actionForm;
		
		//�����Ƿ���ȫʡȨ�ޣ�����ʡ��������ص���
		ProvincialrightDelegate delegatePR = new ProvincialrightDelegate();
		Boolean hasProvAgentView = Boolean.valueOf(delegatePR.checkPurview(user, PROV_AGENT_VIRE));
		form.setHasProvAgentView(hasProvAgentView);
		request.setAttribute("provAgent",hasProvAgentView);
		
		//�����Ƿ���ȫʡȨ��
		Boolean hasPurview = Boolean.valueOf(delegatePR.checkPurview(user, UNVFAIL_PURVIEW));
		String cityid = "";
		if(!hasPurview.booleanValue() && !hasProvAgentView.booleanValue()){
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
		if(!StringUtils.isEmpty(citycompid) && !citycompid.equals("provAgent"))
		{
			userNew = new User();
			BeanUtils.copyProperties(userNew, user);
			userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(citycompid));
		}
		else
		{
			userNew = user;
		}
		
		DataPackage dp = new DataPackage();
		if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, userNew)) {
			Page.setPageSize(request, form);
    		RewardconfDelegate delegate = new RewardconfDelegate();
    		UnvRewardrecordDelegate recorddelegate = new UnvRewardrecordDelegate();
    		UnvRewardrecordListVO listvo = new UnvRewardrecordListVO();
    		this.setListVO(listvo, form);
    		List list = delegate.doCheckRewardconf(form.get_se_rewardmonth(),
    				"UNPB", userNew);
    		List listAll = delegate.doCheckUnRewardconf(form.get_se_rewardmonth(),
    				"UNPB", userNew);
    		if (listAll.size() > list.size() && list.size()!=0 && listAll.size()!=0) {
    			listvo.set_sin_batchno(list);
        		dp = recorddelegate.doQuery(listvo, userNew);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ������[" + form.get_se_rewardmonth() + "]������в�������δ����ȷ��,δ����ȷ�ϵ����μ�¼���ܲ�ѯ!");
    		}else if(listAll.size()==list.size()&& list.size()!=0 && listAll.size()!=0){
    			listvo.set_sin_batchno(list);
        		dp = recorddelegate.doQuery(listvo, userNew);
        		
    		}else if(list.size()==0){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ������["
    					+ form.get_se_rewardmonth() + "]������β��޳���ȷ��!");
    			return actionMapping.findForward("list");
    		}
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}else{
			super.doList(actionMapping, actionForm, request, response, userNew);
			dp = (DataPackage)request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST);
		}
		
		List unvRewardrecordList = (List)dp.getDatas();
		String wayoprcode = "";
		
		//�ֵ��л�ȡ��Ա�ֻ�����
		EmployeeDelegate delegateEmp = new EmployeeDelegate();
		for(int i=0; i<unvRewardrecordList.size(); i++)
		{
			UnvRewardrecordVO unvRewardrecordVO = (UnvRewardrecordVO)unvRewardrecordList.get(i);
			wayoprcode = unvRewardrecordVO.getWayoprcode();
			EmployeeVO employeeVO = delegateEmp.doFindByPk(wayoprcode, userNew);
			unvRewardrecordVO.setRcno(employeeVO.getTelephone());
		}
		return actionMapping.findForward("list");
	}

	/**
	 * ����
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("ȫԱ�������������ϸ��ѯ");
		export.addOutputProperty("rewardlistid");
		export.addOutputProperty("operseq");
		export.addOutputProperty("datasrc");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME,
				"#BBC_OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("wayoprcode");
		export.addOutputProperty("wayoprcode", CommonExportBean.CODE2NAME, "#CH_EMPLOYEE_TEL");
		export.addOutputProperty("rewardstd");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("runtime", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("totalsum");
		export.addOutputProperty("ossrc", CommonExportBean.CODE2NAME,
				"#CH_UNV_OSSRC");
		export.addOutputProperty("batchno");
		export.addOutputProperty("mobile");

		export.voClassArray = new Class[] { UnvRewardrecordVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export
				.writeTxtTitle(response.getOutputStream(), new String[] {
						"�����ϸ��ʶ", "ҵ����ˮ", "������Դ", "ҵ�����", "ҵ������", "�����̱���",
						"����������", "�ƹ�רԱ����", "�ƹ�רԱ����", " ����׼", "�����·�", "����ʱ��",
						"������", "ҵ��ƽ̨��Դ", "���κ�", "�ͻ�����" });
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("rewardlistid");
		
		if (!this.doCheckRewardMonth(actionMapping, actionForm, request,
				response, user)) {
			this.doList(actionMapping, actionForm, request, response, user);
			super.ExportQuery(actionMapping, actionForm, request, response, user,
					export);
		}else{
			super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		}
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
		UnvRewardrecordForm form = (UnvRewardrecordForm) actionForm;
		try {
			Page.setPageSize(request, form);
			UnvRewardrecordListVO unvlistvo = new UnvRewardrecordListVO();
			setListVO(unvlistvo, form);
			UnvRewardrecordDelegate unvdelegate = new UnvRewardrecordDelegate();
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
			UnvRewardrecordForm form = (UnvRewardrecordForm) actionForm;
			String batchno=form.get_se_batchno();
			//���ֵ���
			String citycompid = form.get_ne_citycompid();
			User userNew = null;
			if(!StringUtils.isEmpty(citycompid) && !citycompid.equals("provAgent")){
				userNew = new User();
				BeanUtils.copyProperties(userNew, user);
				userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(citycompid));
			}
			else{
				userNew = user;
			}
			
			SysparamDelegate sysparamDelegate = new SysparamDelegate();
			SysparamListVO listvo= new SysparamListVO();
			listvo.set_se_paramtype("channel");
			listvo.set_ne_systemid("65");
			DataPackage dp = sysparamDelegate.doQuery(listvo, userNew);//user		
			if(dp.getRowCount()==0)
			{
				throw new Exception("������·��ϵͳ���������ڣ���˶ԣ�");
			}
			String path = ((SysparamVO)((List)dp.getDatas()).get(0)).getParamvalue();
			path = path+"succ/";
			String filename = "";
			
			//�����Ƿ���ȫʡȨ��
			Boolean hasPurview = form.getHasPurview();
			String mohthStr = form.get_se_rewardmonth();//�����·�
			//�����Ƿ���ȫʡȨ�ޣ�����ʡ��������ص���
			Boolean hasProvAgentView = form.getHasProvAgentView();		
			
			//ʡ�������̵���
			if(hasProvAgentView.booleanValue() && citycompid!=null && citycompid.equals("provAgent")){				
				filename = path+"unpbrewardrecord_provinAgent_"+ mohthStr+"_"+batchno+".tar.gz";
			}
			//ʡ��Ȩ�ޣ�ȫʡ����
			else if(hasPurview.booleanValue()){
				if("".equals(citycompid) || citycompid==null){
					filename = path + "unpbrewardrecord_" + mohthStr+"_"+batchno + ".tar.gz";
				}
				else{
					filename = path + "unpbrewardrecord_" + mohthStr + "_" + citycompid+"_"+batchno+ ".txt.gz";
				}
			}
			//��ַ����
			else{
				filename = path + "unpbrewardrecord_" + mohthStr + "_" + SessionFactoryRouter.conversionCityid(user.getCityid()) +"_"+ batchno+".txt.gz";
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
