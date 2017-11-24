/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
 package com.gmcc.pboss.web.resource.comressmp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.web.resource.compack.CompackWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;



/**
 * <p>Title: ComressmpAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComressmpAction extends BaseAction{
	private boolean isQuery;//�Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ
	
	public ComressmpAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComressmpForm());
		this.setParam(new ComressmpWebParam());

        //ָ��VO��
        setClsVO(ComressmpVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"comid","comresid"};
		this.setClsControl(Comressmp.class);
		this.setClsQueryParam(ComressmpDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		try{
			ComressmpDBParam param = (ComressmpDBParam)this.getParam();
			param.set_orderby("comresid");
			param.set_desc("1");
			Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,super.getDBAccessUser());
			DataPackage dp = bo.doQueryBySqlName("com.gmcc.pboss.business.resource.comressmp.doList", this.getParam());
			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doTolist() throws Exception {
		try{//�״ν���ҳ�棬��ʾ��¼�˻������ֹ�˾��Ϣ
			ComressmpDBParam param = (ComressmpDBParam)this.getParam();
			//if( null == param.get_se_countyid()){
				User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
				Way wayBO = (WayBO) BOFactory.build(WayBO.class,super.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				param.set_se_countyid(wayvo.getCountyid());
			//}
//			param.set_orderby("comresid");
//			param.set_desc("1");
//			//this.setParam(param);
//			Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,super.getDBAccessUser());
//			DataPackage dp = bo.doQueryBySqlName("com.gmcc.pboss.business.resource.comressmp.doList", this.getParam());
//			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	//�׿����ͳ��
	public String doStat(){
		try{
			if( this.isQuery){//��Ĭ�Ͻ���ҳ��ʱ��ִ�в�ѯ
				Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,super.getDBAccessUser());
				ComressmpDBParam params = (ComressmpDBParam)super.getParam();
				params.setQueryAll(true);
				DataPackage dp = bo.doStat(params);
				super.setDp(dp);	
			}			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage():e.getCause().getMessage());
		}
		return "stat";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿���Դ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("comresid", "��Ʒ��Դ���");
		export.addOutputProperty("comid", "��Ʒ��ʶ");
		export.addOutputProperty("comid", "��Ʒ����",export.CODE2NAME, "#COM");
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("comstate", "��Ʒ״̬", export.CODE2NAME, "$FX_COMSTATE");
		export.addOutputProperty("wayid", "������ʶ", export.CODE2NAME, "#WAYIDINFO");
		//���ڱ��ʽ�����е��ֶζ��ڣ��Ѿ���Ϊ������ֶβ���Ҫ��������
		HashMap map = new HashMap();
		map.put("price", export.new  PropertyFormat(0,"price",null,null));
		export.hashmap=map;
		
		export.addOutputProperty("price/100", "��Ʒ�۸�(Ԫ)",export.EXPRESSION,null);
		export.addOutputProperty("comactive", "��󼤻���",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("iccid", "SIM����");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME, "$ProductBrand");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("numbertype", "��������", export.CODE2NAME, "#Numtypedef");
		export.addOutputProperty("entertime", "���ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("saletime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		
		//export.addOutputProperty("resuse", "��Դ��;", export.CODE2NAME, "$IM_FXRESUSE");
		//export.addOutputProperty("storarea", "��������", export.CODE2NAME, "$IM_FXSTORAREA");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		ComressmpDBParam params = (ComressmpDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		return super.doExcel();
	}
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿���Դ����");
		export.addOutputProperty("comresid", "��Ʒ��Դ���");
		export.addOutputProperty("comid", "��Ʒ��ʶ");
		export.addOutputProperty("comid", "��Ʒ����",export.CODE2NAME, "#COM");
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("comstate", "��Ʒ״̬", export.CODE2NAME, "$FX_COMSTATE");
		export.addOutputProperty("wayid", "������ʶ", export.CODE2NAME, "#WAYIDINFO");
		//���ڱ��ʽ�����е��ֶζ��ڣ��Ѿ���Ϊ������ֶβ���Ҫ��������
		HashMap map = new HashMap();
		map.put("price", export.new  PropertyFormat(0,"price",null,null));
		export.hashmap=map;
		export.addOutputProperty("price/100", "��Ʒ�۸�(Ԫ)",export.EXPRESSION,null);
		export.addOutputProperty("comactive", "��󼤻���",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("iccid", "SIM����");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME, "$ProductBrand");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("numbertype", "��������", export.CODE2NAME, "#Numtypedef");
		export.addOutputProperty("entertime", "���ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("saletime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("resuse", "��Դ��;", export.CODE2NAME, "$IM_FXRESUSE");
		//export.addOutputProperty("storarea", "��������", export.CODE2NAME, "$IM_FXSTORAREA");
		export.voClassArray = new Class[] { ComressmpVO.class };

		prepareResponse(export.getFileName());
		ComressmpDBParam params = (ComressmpDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��Ʒ��Դ���", "��Ʒ��ʶ", "��Ʒ����", "��Ʒ����", "��Ʒ״̬" ,"������ʶ","��Ʒ�۸�","��󼤻���","SIM����","Ʒ��","����","��������","���ʱ��","����ʱ��"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}

	
	public String doStatExportExcel() throws Exception{
		try{
			
		Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,super.getDBAccessUser());
		ComressmpDBParam params = (ComressmpDBParam)super.getParam();
		DataPackage dp = bo.doStat(params);
		super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "exportexcel";
	}
	
	public String doProductDetail(){
		try{
			super.doList();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "productdetail";
	}
	
	public String doPrintTrunkOrBox() throws Exception {
		String mode = "";
		try {
			ComressmpWebParam param = (ComressmpWebParam) super.getParam();
			String batchno = param.get_se_batchno();
			if(StringUtils.isEmpty(batchno)) {
				throw new Exception("��Ʒ���β���Ϊ��");
			}
			Comressmp crsBO = (Comressmp)BOFactory.build(ComressmpBO.class, super.getDBAccessUser());
			mode = this.getRequest().getParameter("mode");
			DataPackage dp = crsBO.doGetTrunksOrBoxesForPrint(param, mode);
			this.setDp(dp);
			super.getRequest().setAttribute("rowCount", dp.getRowCount());
		}catch(Exception e) {
			e.printStackTrace();
			super.addActionMessage(e.getMessage());
		}
		if("trunk".equals(mode))
			return "trunkprint";
		else if("box".equals(mode))
			return "boxprint";
		return null;
	}
	
	public String doPrintPackage() throws Exception {
		try {
			ComressmpWebParam param = (ComressmpWebParam) super.getParam();
			String batchno = param.get_se_batchno();
			if(StringUtils.isEmpty(batchno)) {
				throw new Exception("��Ʒ���β���Ϊ��");
			}
			Comressmp crsBO = (Comressmp)BOFactory.build(ComressmpBO.class, super.getDBAccessUser());
			DataPackage dp = crsBO.doGetPackagesForPrint(param);
			this.setDp(dp);
			super.getRequest().setAttribute("rowCount", dp.getRowCount());
		}catch(Exception e) {
			e.printStackTrace();
			super.addActionMessage(e.getMessage());
		}
		return "packprint";
	}

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
		
}