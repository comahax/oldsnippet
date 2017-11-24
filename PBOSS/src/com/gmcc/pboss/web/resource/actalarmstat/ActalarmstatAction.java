/**
 * auto-generated code
 * Tue Jul 27 15:41:54 CST 2010
 */
 package com.gmcc.pboss.web.resource.actalarmstat;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatDBParam;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.channel.servcent.Servcent;
import com.gmcc.pboss.control.channel.servcent.ServcentBO;
import com.gmcc.pboss.control.resource.actalarmstat.Actalarmstat;
import com.gmcc.pboss.control.resource.actalarmstat.ActalarmstatBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: ActalarmstatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ActalarmstatAction extends BaseAction{
	
	public ActalarmstatAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ActalarmstatForm());
		this.setParam(new ActalarmstatDBParam());

        //ָ��VO��
        setClsVO(ActalarmstatVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"brand","stattype","wayid","yearmonth"};
		this.setClsControl(Actalarmstat.class);
		this.setClsQueryParam(ActalarmstatDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		ActalarmstatForm form = (ActalarmstatForm)getForm();
		//Ĭ�ϱ����У����ڹ��˷ֹ�˾
		form.setCityid(getDBAccessUser().getCityid());
		
		//ȡ�����������
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
		String paramValue = sysparam.doFindByID("54", "pboss_fx");
		if(!StringUtils.isEmpty(paramValue))
		{
			String[] stattypeArray = paramValue.split(",");
			Map<String, String> stattypeMap = new LinkedHashMap<String, String>();
			stattypeMap.put("", "");
			for(String stattype : stattypeArray)
			{
				stattypeMap.put(stattype, stattype);
			}
			form.setStattypeMap(stattypeMap);
		}
		
		Actalarmstat actalarmstat = (Actalarmstat)BOFactory.build(ActalarmstatBO.class,getDBAccessUser());
		ActalarmstatDBParam param = (ActalarmstatDBParam)getParam();
		WayDBParam param2 = new WayDBParam();

		String rate = "";
		BigDecimal bgRate;
		//���ü���������
		if(!StringUtils.isEmpty(param.get_nnl_rate()))
		{
			bgRate = new BigDecimal(param.get_nnl_rate());
			bgRate = bgRate.divide(new BigDecimal(100));
			param.set_nnl_rate(bgRate.toString());
		}
		
		if(!StringUtils.isEmpty(param.get_nnm_rate()))
		{
			bgRate = new BigDecimal(param.get_nnm_rate());
			bgRate = bgRate.divide(new BigDecimal(100));
			param.set_nnm_rate(bgRate.toString());
		}
		
		//���÷ֹ�˾��ѯ����
		if(!StringUtils.isEmpty(param.getCountyid()))
		{
			param2.set_se_countyid(param.getCountyid());
		}
		if(!StringUtils.isEmpty(param.getMareacode()))
		{
			param2.set_se_mareacode(param.getMareacode());
		}
		
		Class[] clazz = new Class[]{ActalarmstatVO.class,WayVO.class};
		Object[] params = new Object[] { param, param2 };
		String[][] joins = new String[][] { { "wayid", "wayid" } };
		
		DataPackage dp = actalarmstat.doUnionQuery(params, clazz, joins);;
		List<Object[]> unionList = dp.getDatas();
		
		List<ActalarmstatVO> actalarmstatList = new ArrayList<ActalarmstatVO>();
		for(int i=0; i<unionList.size(); i++)
		{
			ActalarmstatVO actalarmstatVO = (ActalarmstatVO)unionList.get(i)[0];
			WayVO wayVO = (WayVO)unionList.get(i)[1];
			actalarmstatVO.setId(i+1);
			actalarmstatVO.setCountyid(wayVO.getCountyid());
			actalarmstatVO.setMareacode(wayVO.getMareacode());
			actalarmstatList.add(actalarmstatVO);
		}
		
		//ҳ���б���ʾ
		dp.setDatas(actalarmstatList);
		setDp(dp);
		
		return WEB_RESULT_LIST;
	}
	
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("���㼤����Ԥ����Ϣ");
		export.addOutputProperty("yearmonth", "ͳ����");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������",export.CODE2NAME,"#WAYIDINFO");
		export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME,"$FX_SMPBRAND");
		export.addOutputProperty("stattype", "���������");
		export.addOutputProperty("lhamount", "�����");
		export.addOutputProperty("jhamount", "������");
		export.addOutputProperty("rate", "������","RATE","0.00");

		export.voClassArray = new Class[] { ActalarmstatVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"ͳ����", "�ֹ�˾","΢����", "�����̱���","����������", "Ʒ��" ,"���������","�����","������","������"});
		getParam().set_pagesize("0");
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("���㼤����Ԥ����Ϣ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("yearmonth", "ͳ����");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������",export.CODE2NAME,"#WAYIDINFO");
		export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME,"$FX_SMPBRAND");
		export.addOutputProperty("stattype", "���������");
		export.addOutputProperty("lhamount", "�����");
		export.addOutputProperty("jhamount", "������");
		export.addOutputProperty("rate", "������","RATE","0.00");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		return super.doExcel();
	}
	
	public void doGetMarea() throws Exception{
		String macodeStr = "";
		String countyid = getRequest().getParameter("countyid");
		if(!StringUtils.isEmpty(countyid))
		{
			Servcent servcent = (Servcent)BOFactory.build(ServcentBO.class, getDBAccessUser());
			ServcentDBParam param2 = new ServcentDBParam();
			param2.set_se_countyid(countyid);
			DataPackage dp2 = servcent.doQuery(param2);
			
			Microarea microarea = (Microarea)BOFactory.build(MicroareaBO.class, getDBAccessUser());
			MicroareaDBParam param3 = new MicroareaDBParam();
			
			if(dp2.getRowCount()>0)
			{
				List<ServcentVO> servcentList = dp2.getDatas();
				String svccode = "";
				String macode = "";
				String maname = "";
				DataPackage dp3 = new DataPackage();
				for(ServcentVO servcentVO : servcentList)
				{
					svccode = servcentVO.getSvccode();
					if(!StringUtils.isEmpty(svccode))
					{
						param3.set_se_svccode(svccode);
						dp3 = microarea.doQuery(param3);
						if(dp3.getRowCount()>0)
						{
							List<MicroareaVO> microareaList = dp3.getDatas();
							for(MicroareaVO microareaVO : microareaList)
							{
								macode = microareaVO.getMacode();
								maname = microareaVO.getManame();
								if(!StringUtils.isEmpty(macode)&&!StringUtils.isEmpty(maname))
									macodeStr = macodeStr + macode + "," + maname + ";";
							}
							//ȥ��ĩβ�ָ���
							if(macodeStr.length()>0)
								macodeStr = macodeStr.substring(0,macodeStr.length()-1);
						}
					}
				}
			}
		}
		
		PrintWriter out = getResponse().getWriter();
		out.print(macodeStr);
	}
}