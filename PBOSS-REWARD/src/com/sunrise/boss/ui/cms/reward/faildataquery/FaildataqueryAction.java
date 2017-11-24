package com.sunrise.boss.ui.cms.reward.faildataquery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.faildataoplog.FaildataoplogDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.adtcode.AdtcodeDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
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
 * Title: FaildataqueryAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author	Linli
 * @version 1.0
 */
public class FaildataqueryAction extends BaseDelegateAction {
	
	private ProvincialrightDelegate delegate;
	private String purview = null;
	private static final String PROVINCE_PURVIEW_A = "CH_PW_REWARD_PROVINCIAL";
	private static final String PROVINCE_PURVIEW_A2 = "CH_PW_REWARD";
	private static final String CITY_PURVIEW_B= "CH_PW_REWARD_CIVICEXPOT";
	private static final String COUNTY_PURVIEW_C= "CH_PW_REWARD_COUNTY"; 
	
	public FaildataqueryAction() throws Exception {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(FaildataqueryVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
		delegate = new ProvincialrightDelegate();
	}
	
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		FaildataqueryForm form=(FaildataqueryForm)actionForm;
		form.set_pagesize("20");
//		form.set_se_rewardtype("5");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

//		if (form.getChecked() != null) {
		if (form.getChecked() != null) {
//			form.set_ne_rewardtype("5");
//			request.setAttribute("ischeck", "true");
			if ("mango".equals(form.getChecked())) 
				request.setAttribute("ischeck", "mango");
			if ("apple".equals(form.getChecked())) 
				request.setAttribute("ischeck", "apple");
			if ("orange".equals(form.getChecked())) 
				request.setAttribute("ischeck", "orange");
			if ("banana".equals(form.getChecked())) 
				request.setAttribute("ischeck", "banana");
			if ("lemon".equals(form.getChecked())) 
				request.setAttribute("ischeck", "lemon");
			if ("newtd".equals(form.getChecked())) 
				request.setAttribute("ischeck", "newtd");
		} else if ("TRUE".equals(request.getParameter("UNCHECK"))) {
		} else {
			form.setBackcalmonth(format.format(this.getDefaultDate(-1)));
		}
//		form.set_ne_isbudget("1");
		getPurview(user);
		request.setAttribute("purview", purview);
		return actionMapping.findForward("list");
	}
	
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		FaildataqueryForm form=(FaildataqueryForm)actionForm;
		// ���Ӳ�ѯ_se_calcmonth������ add  by liuchao 
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Integer ii=new Integer(format.format(date));
		getPurview(user);
		request.setAttribute("purview", purview);
//		if(format.format(date).equals(form.getBackcalmonth()))
		form.set_se_calcmonth(form.getBackcalmonth());
		
		if(form.getChecked()!=null)
		{
			
			if ("mango".equals(form.getChecked())) 
				request.setAttribute("ischeck", "mango");
			if ("apple".equals(form.getChecked())) 
				request.setAttribute("ischeck", "apple");
			if ("orange".equals(form.getChecked())) 
				request.setAttribute("ischeck", "orange");
			if ("banana".equals(form.getChecked())) 
				request.setAttribute("ischeck", "banana");
			if ("lemon".equals(form.getChecked())) 
				request.setAttribute("ischeck", "lemon");
			if ("newtd".equals(form.getChecked())) 
				request.setAttribute("ischeck", "newtd");
			StringBuffer sql=new StringBuffer("");
			
			if ("mango".equals(form.getChecked())){ 
				//v13.5.0�޸�
				//sql.append("(opnid like '0403%' or opnid in ('0405040100001','0405040200001') )");
				sql.append("(opnid like '0403%' or opnid like '04050401%' or opnid like '04050402%' )");
				form.set_sql_condition(sql.toString());
			}
			if ("apple".equals(form.getChecked())){
				sql.append("( opnid in ('0405040300001','0405040400001') )");
				form.set_sql_condition(sql.toString());
			}
			if ("orange".equals(form.getChecked())){
				sql.append("( opnid in ('0405040500001','0405040600001','0405040500101','0405040600101','0405040500004','0405040600004','0405040500102','0405040600102') )");
				form.set_sql_condition(sql.toString());
			}
			if ("banana".equals(form.getChecked())){
				sql.append("( opnid in ('0405040500002','0405040600002','0405040500003','0405040600003') )");
				form.set_sql_condition(sql.toString());
			}
			if ("lemon".equals(form.getChecked())){
				sql.append("( opnid like '0405040501%' )");
				form.set_sql_condition(sql.toString());
			} 
			if ("newtd".equals(form.getChecked())){ 
			   sql.append("( opnid like '0407%' )");
			   form.set_sql_condition(sql.toString());
			}
			//sql.append("(opnid like '0403%')");// or opnid like '0404%'
			//form.set_sql_condition(sql.toString());
//			form.set_se_rewardtype("5");
//			request.setAttribute("ischeck", "true");
		}
		getPurview(user);
		request.setAttribute("purview", purview);
		return super.doList(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		FaildataqueryForm form = (FaildataqueryForm) actionForm;
		String adttype = request.getParameter("adttype");
		
		AdtcodeListVO adtlistvo=new AdtcodeListVO();
		try {
			Page.setPageSize(request, form);
			setListVO(adtlistvo, form); // ���ú�listVO����Ϊ��ѯ����
			
			if(StringUtils.isNotEmpty(adttype)){
				ArrayList list = new ArrayList();
				list.add("COMM");
				list.add(adttype);
				adtlistvo.set_sin_adttype(list);
			}
			
			AdtcodeDelegate delegate = new AdtcodeDelegate();
			DataPackage dp = delegate.doQuery(adtlistvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
	
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		FaildataoplogDelegate logDelegate = new FaildataoplogDelegate();
		FaildataoplogVO logVO = new FaildataoplogVO();
		logVO.setOprcode(user.getOpercode());
		logVO.setOprtype("CREATE");
		logVO.setOptime(new Date());
		
		String filename = null;
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("�ù��Ų������κε��У�");
			}
			filename = getFilePath(actionForm, user, request);
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("�ļ�·��Ϊ�գ�");
			}
			FtpInfo ftpInfo =null;
			if("A".equals(purview))
			{
				User user2=new User();
				BeanUtils.copyProperties(user2, user);
				String cityid2=request.getParameter("CITY")==null||"".equals(request.getParameter("CITY"))?SessionFactoryRouter.conversionCityid(user
						.getCityid()):request.getParameter("CITY");
				if(cityid2!=null)
				{
					user2.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid2));
				}
				 ftpInfo = ResPubUtil.getFtpInfo(user2);
			}else
			{
				 ftpInfo = ResPubUtil.getFtpInfo(user);
			}
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
			}
			
			logVO.setSuccess("succ");
			logVO.setFilename(filename);
			logDelegate.doCreate(logVO, user);
			
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			logVO.setSuccess("fail");
			logVO.setFilename(filename);
			logDelegate.doCreate(logVO, user);
			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
	
	/**
	 * A-ʡ��Ȩ�ޣ�B-����Ȩ��,C-�ֹ�˾Ȩ��
	 * 
	 * @param user
	 */
	private void getPurview(User user) throws Exception {
		if (delegate.checkPurview(user, PROVINCE_PURVIEW_A)) {
			purview = "A";
			return;
		}
		if (delegate.checkPurview(user, PROVINCE_PURVIEW_A2)) {
			purview = "A";
			return;
		}
		if (delegate.checkPurview(user, CITY_PURVIEW_B)) {
			purview = "B";
			return;
		}
		if (delegate.checkPurview(user, COUNTY_PURVIEW_C)) {
			purview = "C";
			return;
		}
		purview="";
	}
	
	private String getFilePath(ActionForm actionForm,User user,
			HttpServletRequest request)throws Exception{
		StringBuffer filepath=new StringBuffer("");
		if(purview==null)
		{
			purview=request.getParameter("PURVIEW")==null?"":request.getParameter("PURVIEW");
			if(purview==null)
			{
				getPurview(user);
			}
		}
		String filetype=request.getParameter("FILETYPE")==null?"":request.getParameter("FILETYPE");
		String chCityid=request.getParameter("CITY")==null||"".equals(request.getParameter("CITY"))?SessionFactoryRouter.conversionCityid(user
				.getCityid()):request.getParameter("CITY");
		if("".equals(filetype))
		{
			throw new Exception("�ļ����Ͳ���ȷ!");
		}
//		String chCityid = SessionFactoryRouter.conversionCityid(user
//				.getCityid());
//		Сд���б���/��������/ALL_�ֹ�˾����_���б���_��������.txt.gz
		FaildataqueryForm form = (FaildataqueryForm) actionForm;
		String month=form.getBackcalmonth();
		filepath.append("/appdata/fileftp/faildata/");
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append(month).append("/");
		String countyid=null;
		if("C".equals(purview))
		{
			WayDelegate delegate=new WayDelegate();
			WayVO vo=(WayVO)delegate.doFindByPk(user.getWayid(), user);
			if(vo==null || vo.getCountyid()==null)
			{
				throw new Exception("��¼�����쳣���¼�����ķֹ�˾Ϊ��!");
			}else
			{
				countyid=vo.getCountyid();
			}
		}
		if("total".equals(filetype))
		{
			filepath.append("FAIL_ALL_");
			if("C".equals(purview))
			{
					filepath.append(countyid).append("_");
			}
		}else
		{
			filepath.append("FAIL_NET_");
			if("C".equals(purview))
			{
					filepath.append(countyid).append("_");
			}
		}
		filepath.append(chCityid.toUpperCase()).append("_");
		filepath.append(month);
		if("total".equals(filetype))
		{
			filepath.append(".txt");
		}else{
			filepath.append(".tar");
		}
		filepath.append(".gz");
		return filepath.toString();
	}
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		
		FaildataqueryForm form = (FaildataqueryForm) actionForm;
		String zdcj = form.getChecked();
		if (zdcj == null || "".equals(zdcj)) {
			export.setFileName("��Ч��У��ʧ�����ݲ�ѯ");
		} else {
			String backcalmonth = form.getBackcalmonth();
			String rewardtype = form.get_se_rewardtype();
			if (zdcj.equals("mango") && rewardtype.equals("5")) {
				export.setFileName(backcalmonth + "��Լ�ն˷���ҵ��������ʧ������");
			} else if (zdcj.equals("mango") && rewardtype.equals("6")) {
				export.setFileName(backcalmonth + "��Լ�ն˷���ҵ�񿼺˳��ʧ������");
			} else if (zdcj.equals("apple") && rewardtype.equals("11")) {
				export.setFileName(backcalmonth + "���Լ�ն˷���ҵ��һ�ڳ��ʧ������");
			} else if (zdcj.equals("apple") && rewardtype.equals("22")) {
				export.setFileName(backcalmonth + "���Լ�ն˷���ҵ����ڳ��ʧ������");
			} else if (zdcj.equals("apple") && rewardtype.equals("33")) {
				export.setFileName(backcalmonth + "���Լ�ն˷���ҵ�����ڳ��ʧ������");
			} else if (zdcj.equals("orange") && rewardtype.equals("5")) {
				export.setFileName(backcalmonth + "����ն˷���ҵ��������ʧ������");
			} else if (zdcj.equals("orange") && rewardtype.equals("44")) {
				export.setFileName(backcalmonth + "����ն˷���ҵ�񿼺˳��ʧ������");
			} else if (zdcj.equals("banana") && rewardtype.equals("5")) {
				export.setFileName(backcalmonth + "��ƽ̨����ն˷���ҵ��������ʧ������");
			} else if (zdcj.equals("banana") && rewardtype.equals("44")) {
				export.setFileName(backcalmonth + "��ƽ̨����ն˷���ҵ�񿼺˳��ʧ������");
			} else if (zdcj.equals("lemon") && rewardtype.equals("90")) {
				export.setFileName(backcalmonth + "��������ײͻ���У��ʧ������");
			} else if (zdcj.equals("lemon") && rewardtype.equals("91")) {
				export.setFileName(backcalmonth + "��������ײ�һ�����۳��ʧ������");
			} else if (zdcj.equals("lemon") && rewardtype.equals("92")) {
				export.setFileName(backcalmonth + "��������ײͶ������۳��ʧ������");
			} else if (zdcj.equals("lemon") && rewardtype.equals("93")) {
				export.setFileName(backcalmonth + "��������ײ��������۳��ʧ������");
			} else if (zdcj.equals("newtd") && rewardtype.equals("1")) {
				export.setFileName(backcalmonth + "2014�����ն˳��T��T+1��T+2����У��һ�ڳ��ʧ������");
			} else {
				export.setFileName("��Ч��У��ʧ�����ݲ�ѯ");
			}
		}
		export.addOutputProperty("seq");
		export.addOutputProperty("rewardtype",CommonExportBean.CODE2NAME,"$CH_REWARDTYPE");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("opnid");
		export.addOutputProperty("name");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("creattime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("ruleid");
		export.addOutputProperty("adtflag");
		export.addOutputProperty("adtcode");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("batchno");
		export.addOutputProperty("rewardflag");
		export.addOutputProperty("repairmonth");
		export.addOutputProperty("bakinfo");
		export.addOutputProperty("bakinfo2");
		export.addOutputProperty("bakinfo3");
		export.addOutputProperty("wrapfee");
		export.addOutputProperty("adtflag");
		export.addOutputProperty("bakinfo2", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("prodid");
		export.addOutputProperty("bakinfo4");
		export.addOutputProperty("bakinfo5");
		export.addOutputProperty("bakinfo6",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7");
		export.addOutputProperty("bakinfo8");
		export.addOutputProperty("bakinfo9");
		export.addOutputProperty("bakinfo10" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		
		export.voClassArray = new Class[] { FaildataqueryVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "��ˮ��",
				"�������", "�����·�", "ȫʡҵ�����", "ҵ������", "ҵ������������", "ҵ������������",
				"ҵ��������", "ҵ�����ֻ���", "ҵ����ʱ��", "У��ʱ��", "У��������", "У����",
				"ʧ��ԭ�����", "ʧ��ԭ��", "���κ�", "�����־", "������", "��������(IMEI)", "��ƷID",
				"��ƷЭ���", "��ŵ����", "���˽����ʶ", "��Ʒ����" ,"��ƷID","��׼��" ,"������","�ն���ʽ","����","ARPUֵ","���ʿͻ�","�ն�����"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
	
	// ����Ĭ�����ڷ���,����Ϊ�Ӻ�i����,����Ϊ��ǰi����
	private Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
}
