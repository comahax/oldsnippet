/**
 * auto-generated code
 * Fri Sep 25 15:08:39 CST 2009
 */
 package com.gmcc.pboss.web.resource.compack;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.compack.ComcategoryInfo;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.NumberTypeInfo;
import com.gmcc.pboss.business.resource.compack.PackResourceInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: CompackAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class CompackAction extends BaseAction{
	private String filepath;
	private Map<String,String> paramMap;
	public CompackAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CompackForm());
		this.setParam(new CompackWebParam());

        //ָ��VO��
        setClsVO(CompackVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"batchno","boxnum"};
		this.setClsControl(Compack.class);
		this.setClsQueryParam(CompackDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception{
		try{
			CompackDBParam param = (CompackDBParam)this.getParam();
			param.set_orderby("batchno,boxnum");
			param.set_desc("1");
			//this.setParam(param);
			Compack bo = (CompackBO)BOFactory.build(CompackBO.class, this.getDBAccessUser());
			DataPackage dp = bo.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doList", this.getParam());
			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doTolist() throws Exception{
		try{//�״ν���ҳ�棬��ʾ��¼�˻������ֹ�˾��Ϣ
			CompackDBParam param = (CompackDBParam)this.getParam();
			//if(null==param.get_se_countyid()){
				User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
				Way wayBO = (WayBO) BOFactory.build(WayBO.class,super.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				param.set_se_countyid(wayvo.getCountyid());
			//}
//			param.set_orderby("batchno,boxnum");
//			param.set_desc("1");
//			//this.setParam(param);
//			Compack bo = (CompackBO)BOFactory.build(CompackBO.class, this.getDBAccessUser());
//			DataPackage dp = bo.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doList", this.getParam());
//			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	//����ΪEXCEL
	public String doExportExcel() throws Exception{
		CompackDBParam compackParm = (CompackDBParam)super.getParam();
		compackParm.setQueryAll(true);
		compackParm.set_pagesize("0");
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��Ʒ����Ϣ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("amount", "��Ʒ����");
		export.addOutputProperty("comcategory", "��Ʒ����",export.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("packstate", "��״̬", export.CODE2NAME, "$FX_PACKSTATE");
		export.addOutputProperty("storarea", "��������", export.CODE2NAME, "$IM_FXSTORAREA");
		export.addOutputProperty("resuse", "��Դ��;", export.CODE2NAME, "$IM_FXRESUSE");
		export.addOutputProperty("nosect", "�����Ŷ�");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("discomcode", "����������", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("packtime", "���ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
	
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();

	}
	
	/*
	 * ��ȷʵ��Դҳ��
	 */
	public String doGoConfirmResource(){
		try{
			User user = (User) super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			CompackForm form = (CompackForm) super.getForm();
			form.setWayid(user.getWayid());
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "confirmresource";
	}
	
	/**
	 * ȷ����Դ
	 * @return
	 */
	public String doConfirmResource(){
		try{
			CompackForm form = (CompackForm) super.getForm();
			Compack bo = (CompackBO) BOFactory.build(CompackBO.class,super.getDBAccessUser());
			DataPackage dp = bo.doConfirmResource(form.getWayid(), form.getBatchno());
			if( null == dp || null == dp.getDatas() || dp.getDatas().size() == 0)
				throw new Exception("�Ҳ�����Ӧ����");
			super.getRequest().getSession().setAttribute("COMCATEGORYINFODP", dp);
			super.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
			return "confirmresource";
		}
		return "setscale";
	}

	/*
	 * �趨����(���������)
	 */
	public String doSetScale(){
		try{
			DataPackage dp = (DataPackage)super.getRequest().getSession().getAttribute("COMCATEGORYINFODP");
			super.getRequest().getSession().removeAttribute("PACKINFO");
			super.setDp(dp);
			List<ComcategoryInfo> list = dp.getDatas();
			String adjustScale = null;
			BigDecimal totalScale = new BigDecimal("0");
			for(ComcategoryInfo info :list){
				totalScale = new BigDecimal("0");
				List<NumberTypeInfo> typeList = info.getNumberTypeInfo();
				for(NumberTypeInfo typeInfo:typeList){
					adjustScale = super.getRequest().getParameter(info.getComcategory()+"@"+typeInfo.getType());
					if(!adjustScale.matches("\\d+|\\d+\\.\\d{0,2}"))
						throw new Exception(" ���������Ҫ��Ϊ���ڵ���������֣������λС������������д");
					typeInfo.setAdjustScale(new BigDecimal(adjustScale).doubleValue());
				}
			}			
			for(ComcategoryInfo info :list){
				if(!info.checkAdjustScale())
					throw new Exception(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", info.getComcategory(),super.getDBAccessUser().getCityid())+"������������ò���ȷ");	
			}
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
			return "setscale";
		}
		
		return "pack";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String doPack(){
		try{
			CompackForm form = (CompackForm) super.getForm();
			super.getRequest().getSession().removeAttribute("PACKINFO");
			DataPackage dp = (DataPackage)super.getRequest().getSession().getAttribute("COMCATEGORYINFODP");
			super.setDp(dp);
			
			List<ComcategoryInfo> list = dp.getDatas();
			Compack bo = (CompackBO) BOFactory.build(CompackBO.class,super.getDBAccessUser());
			
			String fileName = createFilename(super.getDBAccessUser().getOprcode());
			
			PackResourceInfo packInfo = new PackResourceInfo();
			packInfo.setStartTime(new Date());
			packInfo.setFileName(fileName);
			super.getRequest().getSession().setAttribute("PACKINFO", packInfo);
			PackResourceThread packThread = new PackResourceThread(bo,list, form.getWayid(), form.getBatchno(), packInfo, fileName);
			Thread t = new Thread(packThread);
			t.start();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
		}
		return "pack";
	}
	
	/*
	 * ��ȡ���������Ϣ
	 */
	public String doGetPackInfo(){
		try{
			PackResourceInfo info = (PackResourceInfo)super.getRequest().getSession().getAttribute("PACKINFO");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuilder sb = new StringBuilder(200);
			Date startTime = info.getStartTime();
			Date endTime = info.getEndTime();
			//���ظ�ʽ:   ��ʼʱ��|����ʱ��|�ܰ���|��ɰ���|����(�ٷֱ�)|�Ƿ����|�ļ�����
			if( null == startTime){
				sb.append("").append("|");
			}else{
				sb.append(format.format(startTime)).append("|");
			}
			if( null == endTime){
				sb.append("").append("|");
			}else{
				sb.append(format.format(endTime)).append("|");
			}
			sb.append(info.getTotalPack()).append("|");
			sb.append(info.getProcessPack()).append("|");
			sb.append(info.getPercent()).append("|");
			sb.append(info.isFinish()).append("|");
			sb.append(info.getFileName()).append("|");
			sb.append(info.getErrMsg() == null?"":info.getErrMsg());
			super.getResponse().setContentType("text/html;charset=UTF-8");
			super.getResponse().getWriter().write(sb.toString());
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}		
		return null;
	}
	
	/**
	 * �����ļ���
	 */
	protected String createFilename(String opercode) throws Exception {

		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "pboss_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + calendar.get(Calendar.HOUR_OF_DAY)
				+ calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + (new java.util.Random()).nextInt(99);

		// String webappPath = getServlet().getInitParameter("uplocation");
		String location = ServletActionContext.getServletContext().getRealPath("/upload")+"\\";
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			f.createNewFile();
			return file;
		}
	}
	
	
	/**
	 * �������ȷʵ��Դ
	 * @return
	 */
	public String doPackToolConfirm(){
		try{		
			Map<String,List<ComressmpVO>> resourceMap = this.sortByPhoneTypeFromFile(new File(filepath));
			Compack compackBO = (Compack)BOFactory.build(CompackBO.class,super.getDBAccessUser());
			
			DataPackage dp = compackBO.doPackToolConfirmResource(resourceMap, paramMap.get("comcategory"));
			super.setDp(dp);
			super.getRequest().getSession().setAttribute("PACKTOOLCONFIRMRESOURCE", dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
			return "uploadresource";
		}
		return "toolsetscale";
	}

	
	/*
	 * �趨����(���������)
	 */
	public String doToolSetScale(){
		try{
			super.getRequest().getSession().removeAttribute("PACKINFO");
			DataPackage dp = (DataPackage)super.getRequest().getSession().getAttribute("PACKTOOLCONFIRMRESOURCE");
			super.setDp(dp);
			List<ComcategoryInfo> list = dp.getDatas();
			String adjustScale = null;
			BigDecimal totalScale = new BigDecimal("0");
			for(ComcategoryInfo info :list){
				totalScale = new BigDecimal("0");
				List<NumberTypeInfo> typeList = info.getNumberTypeInfo();
				for(NumberTypeInfo typeInfo:typeList){
					adjustScale = super.getRequest().getParameter(info.getComcategory()+"@"+typeInfo.getType());
					if(!adjustScale.matches("\\d+|\\d+\\.\\d{0,2}"))
						throw new Exception(" ���������Ҫ��Ϊ���ڵ���������֣������λС������������д");
					typeInfo.setAdjustScale(new BigDecimal(adjustScale).doubleValue());
				}
			}			
			for(ComcategoryInfo info :list){
				if(!info.checkAdjustScale())
					throw new Exception(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", info.getComcategory(),super.getDBAccessUser().getCityid())+"������������ò���ȷ");	
			}
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
			return "toolsetscale";
		}
		
		return "toolpack";
	}
	
	//�׿�������ߴ��
	public String doPacktoolPack(){
		try{
			super.getRequest().getSession().removeAttribute("PACKINFO");
	
			Map<String,List<ComressmpVO>> resourceMap = this.sortByPhoneTypeFromFile(new File(filepath));
			DataPackage comcategDP = (DataPackage)super.getRequest().getSession().getAttribute("PACKTOOLCONFIRMRESOURCE");
			super.setDp(comcategDP);
			ComcategoryInfo info = (ComcategoryInfo)comcategDP.getDatas().get(0); 
			Compack compackBO = (Compack)BOFactory.build(CompackBO.class,super.getDBAccessUser());
			String fileName = createFilename(super.getDBAccessUser().getOprcode());
			
			PackResourceInfo packInfo = new PackResourceInfo();
			packInfo.setStartTime(new Date());
			packInfo.setFileName(fileName);
			super.getRequest().getSession().setAttribute("PACKINFO", packInfo);
			ToolPackResourceThread packThread = new ToolPackResourceThread(compackBO,info,resourceMap,packInfo,fileName);
			Thread t = new Thread(packThread);
			t.start();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
			return "toolsetscale";
		}
		return "toolpack";
	}
	
	//����Դ�ϴ�ҳ��
	public String doGoUploadresource(){
		return "uploadresource";
	}
	/**
	 * ���ļ��ж�ȡ���벢���������ͷ���
	 * @param resourceFile
	 * @return
	 */
	private Map<String,List<ComressmpVO>> sortByPhoneTypeFromFile(File resourceFile) throws Exception{
		Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,super.getDBAccessUser());
		NumtyperuleDBParam typeruleParam = new NumtyperuleDBParam();
		typeruleParam.setQueryAll(true);
		typeruleParam.setDataOnly(true);
		List<NumtyperuleVO> typeruleList = numtyperuleBO.doGetNumtyperuleList(typeruleParam);

		Map<String,List<ComressmpVO>> result = new HashMap<String,List<ComressmpVO>>();
		BufferedReader br = new BufferedReader(new FileReader(resourceFile));
		String line = null;	
		User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		try{
			while((line = br.readLine()) != null){
				String[] items = StringUtils.split(line, "|");
				Long type = numtyperuleBO.doMatchNumber(items[0].trim(),typeruleList);
				ComressmpVO comressmpVO = new ComressmpVO();
				comressmpVO.setWayid(user.getWayid());
				comressmpVO.setComresid(items[0].trim());
				comressmpVO.setNumbertype(null == type?null:type.toString());
				if(items.length>1)
					comressmpVO.setBoxnum(items[1]);
				if( null == result.get(type.toString()) ){
					List<ComressmpVO> phoneList = new ArrayList<ComressmpVO>();
					
					phoneList.add(comressmpVO);
					result.put(type.toString(), phoneList);
				}else{
					result.get(type.toString()).add(comressmpVO);
				}
			}
		}catch(Exception e){
			throw e;
		}finally{
			br.close();
		}		
		return result;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}



}