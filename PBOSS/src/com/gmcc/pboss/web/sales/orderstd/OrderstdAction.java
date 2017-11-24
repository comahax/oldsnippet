/**
 * auto-generated code
 * Tue Oct 13 14:29:08 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderstd;

import java.util.List;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.orderstd.OrderstdDBParam;
import com.gmcc.pboss.business.sales.orderstd.OrderstdVO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.orderstd.Orderstd;
import com.gmcc.pboss.control.sales.orderstd.OrderstdBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrderstdAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderstdAction extends BaseAction{
	
	public OrderstdAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderstdForm());
		this.setParam(new OrderstdWebParam());

        //ָ��VO��
        setClsVO(OrderstdVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderstd.class);
		this.setClsQueryParam(OrderstdDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		
		OrderstdDBParam param = (OrderstdDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_CONTENT;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		try {
			OrderstdForm form = (OrderstdForm) getForm();
			OrderstdDBParam param = new OrderstdDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_cooptype(form.getCooptype());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_brand(form.getBrand());
			param.set_se_stdtype(form.getStdtype());
			param.set_ne_effective(form.getEffective().toString());
			Orderstd control = (Orderstd) BOFactory.build(
					OrderstdBO.class, getDBAccessUser());
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
		return WEB_RESULT_CONTENT;
	}
}