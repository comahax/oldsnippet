/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.web.sales.orderuplimit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: OrderuplimitAction
 * </p>
 * ;
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
 * @author Yedaoe
 * @version 1.0
 */
public class OrderuplimitAction extends BaseAction {

	public OrderuplimitAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new OrderuplimitForm());
		this.setParam(new OrderuplimitWebParam());

		// ָ��VO��
		setClsVO(OrderuplimitVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Orderuplimit.class);
		this.setClsQueryParam(OrderuplimitDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	// ��ת�������������
	public String doImport() throws Exception {
		return "toImport";
	}

	public String doList() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		OrderuplimitDBParam param = (OrderuplimitDBParam)getParam();
		param.set_se_cityid(cityid);
		param.set_se_limitmode("MONDAYLIMIT");//���¶�����ģʽ
		param.set_se_restype("COMRESSMP");//Ĭ���׿�
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		DataPackage dp = orderuplimit.doQuery(param);
		setDp(dp);
		return WEB_RESULT_LIST;
	}
	
	//�հ�SIM�����Ԥ����ѯ
	public String doListforemptysim() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderuplimitDBParam param = (OrderuplimitDBParam)getParam();
		param.set_se_cityid(cityid);
		param.set_se_limitmode("STOCKALARM");//Ĭ��Ԥ�����ģʽ
		param.set_se_restype("EMPTYSIM");//Ĭ�Ͽհ�SIM��
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		DataPackage dp = orderuplimit.doQuery(param);
		if (dp != null && dp.getDatas() != null) {
			List<OrderuplimitForm> list = new ArrayList<OrderuplimitForm>();
			for (OrderuplimitVO vo : (List<OrderuplimitVO>) dp.getDatas()) {
				OrderuplimitForm form = new OrderuplimitForm();
				BeanUtils.copyProperties(vo, form);
				form.setExtendAlarmValue(AlarmUtils.alarmCode2Name(form
						.getAlarmvalue(), super.getDBAccessUser()
						.getCityid()));
//				form.setBrand(AlarmUtils.alarmbrandinterpret(form
//						.getBrand(), (User) this.getDBAccessUser()));
				list.add(form);
			}
			dp.setDatas(list);
		}
		setDp(dp);
		return "listforemptysim";
	}
	
	//�׿���׼�������
	public String doListstock() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		OrderuplimitDBParam param = (OrderuplimitDBParam)getParam();
		param.set_se_cityid(cityid);
		param.set_se_limitmode("STDSTOCK");//��׼���ģʽ
		param.set_se_restype("COMRESSMP");//Ĭ���׿�
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		DataPackage dp = orderuplimit.doQuery(param);
		setDp(dp);
		return "liststock";
	}
	
	//��ֵ������������
	public String doListforcard() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		OrderuplimitDBParam param = (OrderuplimitDBParam)getParam();
		param.set_se_cityid(cityid);
		//param.set_se_limitmode("MONDAYLIMIT");//���¶�����ģʽ
		param.set_se_restype("COMRESCARD");
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		DataPackage dp = orderuplimit.doQuery(param);
		setDp(dp);
		return "listforcard";
	}
	
	public String doNew() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_CONTENT;
	}

	//�׿���׼�������
	public String doNewstock() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentstock";
	}
	
	//��ֵ������������
	public String doNewforcard() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentforcard";
	}
	
	//�հ�SIM�����������ã���ѯ��
	public String doListforemptysimorder() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		//������Ʒ����
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		OrderuplimitDBParam params = new OrderuplimitDBParam();
		List  emptysimtypeList = orderuplimit.doQueryEmptysimtype(params);
		getRequest().setAttribute("emptysimtypeList", emptysimtypeList);
		
		OrderuplimitDBParam param = (OrderuplimitDBParam)getParam();
		param.set_se_cityid(cityid); 
		param.set_se_restype("EMPTYSIM"); 
		DataPackage dp = orderuplimit.doQuery(param);
		setDp(dp);
		return "listforemptysimorder";
	} 
	
	//�հ�SIM�����������ã�������
	public String doNewforemptysimorder() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		//������Ʒ����
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		OrderuplimitDBParam params = new OrderuplimitDBParam();
		List  emptysimtypeList = orderuplimit.doQueryEmptysimtype(params);
		getRequest().setAttribute("emptysimtypeList", emptysimtypeList);
		return "contentforemptysimorder";
	}
	//�հ�SIM�����������ã��༭��
	public String doEditforemptysimorder() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		//������Ʒ����
		Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
		OrderuplimitDBParam params = new OrderuplimitDBParam();
		List  emptysimtypeList = orderuplimit.doQueryEmptysimtype(params);
		getRequest().setAttribute("emptysimtypeList", emptysimtypeList);
		return "contentforemptysimorder";
	} 
	
	//�հ�SIM�����������ã����棩 
	public String doSaveforemptysimorder() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {  
			OrderuplimitForm form = (OrderuplimitForm) getForm();
			form.setLimitmode("MONDAYLIMIT");
			form.setRestype("EMPTYSIM"); 
			if(form.getOncelimit()==null || form.getOncelimit().equals("")){				
				form.setOncelimit(Long.valueOf("0"));
			}			
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_cooptype(form.getCooptype());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_comcategory(form.getComcategory());
			//param.set_se_limitmode("MONDAYLIMIT");//���¶�����ģʽ
			param.set_se_restype("EMPTYSIM");
			Orderuplimit control = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, getDBAccessUser()); 
			//���ú��������б�
			Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
			List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);
			//������Ʒ����
			Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
			OrderuplimitDBParam params = new OrderuplimitDBParam();
			List  emptysimtypeList = orderuplimit.doQueryEmptysimtype(params);
			getRequest().setAttribute("emptysimtypeList", emptysimtypeList); 
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return "contentforemptysimorder";
	} 
	
	
	//�հ�SIM�����Ԥ������
	public String doNewforemptysim() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return "contentforemptysim";
	}
	
	public String doEdit() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_CONTENT;
	}
	
	//�׿���׼�������
	public String doEditstock() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentstock";
	}
	
	//��ֵ������������
	public String doEditforcard() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentforcard";
	}
	
	//�հ�SIM�����Ԥ������
	public String doEditforemptysim() throws Exception {
		super.doEdit();
		OrderuplimitForm form = (OrderuplimitForm) super.getForm();
		String alarmvalue = form.getAlarmvalue();
		if (null != alarmvalue) {
			String tempAlarm = alarmvalue.replaceAll(";&", "");
			String[] types = tempAlarm.split(";");
			for (String type : types) {
				String[] temp = type.trim().split(":");
				if ("REDALARM".equals(temp[0]))
					form.setRedalarm(temp[1]);
				else if ("YELALARM".equals(temp[0]))
					form.setYellowalarm(temp[1]);
			}
		}
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return "contentforemptysim";
	}
	
	public String doSave() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			OrderuplimitForm form = (OrderuplimitForm) getForm();
			form.setLimitmode("MONDAYLIMIT");
			form.setRestype("COMRESSMP");
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_cooptype(form.getCooptype());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_brand(form.getBrand());
			param.set_se_limitmode("MONDAYLIMIT");//���¶�����ģʽ
			param.set_se_restype("COMRESSMP");//Ĭ���׿�
			Orderuplimit control = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_CONTENT;
	}
	
	//�հ�SIM�����Ԥ������	
	/**
	 * @return
	 * @throws Exception
	 */
	public String doSaveforemptysim() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			OrderuplimitForm form = (OrderuplimitForm) getForm();
			form.setLimitmode("STOCKALARM");//Ĭ��Ԥ�����ģʽ
			form.setRestype("EMPTYSIM");//Ĭ�Ͽհ�SIM��
			form.setAlarmvalue("REDALARM:" + form.getRedalarm() + ";YELALARM:" + form.getYellowalarm());
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_comcategory(form.getComcategory());
			param.set_se_limitmode("STOCKALARM");//Ĭ��Ԥ�����ģʽ
			param.set_se_restype("EMPTYSIM");//Ĭ�Ͽհ�SIM��
			Orderuplimit control = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return "contentforemptysim";
	}
	
	//�׿���׼�������
	public String doSavestock() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			OrderuplimitForm form = (OrderuplimitForm) getForm();
			form.setLimitmode("STDSTOCK");
			form.setRestype("COMRESSMP");
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_cooptype(form.getCooptype());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_brand(form.getBrand());
			param.set_se_limitmode("STDSTOCK");//��׼���ģʽ
			param.set_se_restype("COMRESSMP");//Ĭ���׿�
			Orderuplimit control = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentstock";
	}
	
	//��ֵ������������
	public String doSaveforcard() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			OrderuplimitForm form = (OrderuplimitForm) getForm();
			form.setLimitmode("MONDAYLIMIT");
			form.setRestype("COMRESCARD");
			
			if(form.getOncelimit()==null || form.getOncelimit().equals("")){				
				form.setOncelimit(Long.valueOf("0"));
			}			
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_cooptype(form.getCooptype());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_comcategory(form.getComcategory());
			//param.set_se_limitmode("MONDAYLIMIT");//���¶�����ģʽ
			param.set_se_restype("COMRESCARD");
			Orderuplimit control = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return "contentforcard";
	}
	
	public String doExcel() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("�հ�SIM�����Ԥ������");
			export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
			export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
			export.addOutputProperty("recid", "���");
			export.addOutputProperty("cityid", "���й�˾", export.CODE2NAME, "#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("starlevel", "�Ǽ�", export.CODE2NAME, "$CH_STARLEVEL");
			export.addOutputProperty("comcategory", "��Ʒ����", export.CODE2NAME, "$IM_FXCOMCATEGORY");
			export.addOutputProperty("maxstock", "��߿��(��)");
			export.addOutputProperty("extendAlarmValue", "Ԥ����ֵ");
			export.queryMethodName = ("doListforemptysim");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			OrderuplimitDBParam param = (OrderuplimitDBParam) super.getParam();
			param.set_pagesize("0");
			super.setParam(param);
			return super.doExcel();
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	public String doDelete() throws Exception{
		//super.doDelete();
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		if(selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}			
		try{
			Orderuplimit control = (Orderuplimit) BOFactory.build(OrderuplimitBO.class, getDBAccessUser());
			for (int i = 0; i < selectArray.length; i++) {
				if (selectArray[0].indexOf('|') == -1) { // ��һ����
					//executeDlgMethod(METHOD_TYPE_REMOVEBYPK, getSelectedPK(selectArray[i]));
					control.doRemoveByPK(getSelectedPK(selectArray[i]));
				} else { // ��������
					//executeDlgMethod(METHOD_TYPE_REMOVEBYVO, getSelectedPkVO(selectArray[i]));
					control.doRemoveByVO((OrderuplimitVO)getSelectedPkVO(selectArray[i]));
				}
			}
			setActionMessage("�����ɹ�!");
		}catch (Exception e) {
			addActionError(e.getMessage());
		}		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String forwhat = (String) request.getParameter("forwhat");
		//System.out.println(forwhat);
		if(forwhat!=null && !"".equals(forwhat)){
			if("emptysim".equals(forwhat)){
				return doListforemptysim();
			}else if("card".equals(forwhat)){
				return doListforcard();
			}else if("stock".equals(forwhat)){
				return doListstock();
			}else if("emptysimorder".equals(forwhat)){
				return doListforemptysimorder();
			}else{
				return doList();
			}
		}else{
			return doList();
		}
	}
}