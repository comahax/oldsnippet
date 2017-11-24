/**
 * auto-generated code
 * Fri May 07 16:29:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.ordertimes;

import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDBParam;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesVO;
import com.gmcc.pboss.control.sales.ordertimes.Ordertimes;
import com.gmcc.pboss.control.sales.ordertimes.OrdertimesBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrdertimesAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class OrdertimesAction extends BaseAction{
	private String otlimitType;//��������Լ������
	
	public String getOtlimitType() {
		return otlimitType;
	}

	public void setOtlimitType(String otlimitType) {
		this.otlimitType = otlimitType;
	}

	public OrdertimesAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrdertimesForm());
		this.setParam(new OrdertimesDBParam());

        //ָ��VO��
        setClsVO(OrdertimesVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ordertimes.class);
		this.setClsQueryParam(OrdertimesDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		OrdertimesDBParam params = (OrdertimesDBParam)getParam();
		if ("APPSTAR".equals(this.otlimitType)) {// �Ǽ�
			params.set_se_objtype("APPSTAR");
			super.doList();
			return "list";
		}else{// ����
			params.set_se_objtype("APPWAY");
			super.doList();
			return "list2";
		}
	}

	@Override
	public String doEdit() throws Exception {
		super.doEdit();
		if ("APPSTAR".equals(this.otlimitType)) {// �Ǽ�
			return "content";
		}else{// ����
			return "content2";
		}
	}

	@Override
	public String doNew() throws Exception {
		super.doNew();
		if ("APPSTAR".equals(this.otlimitType)) {// �Ǽ�
			return "content";
		}else{// ����
			return "content2";
		}
	}

	@Override
	public String doSave() throws Exception {
		try {
			Ordertimes control = (Ordertimes)BOFactory.build(OrdertimesBO.class, getDBAccessUser());
			OrdertimesForm form = (OrdertimesForm)getForm();
			OrdertimesDBParam params = new OrdertimesDBParam();
			params.set_se_objtype(form.getObjtype());
			params.set_se_objectcode(form.getObjectcode());
			params.set_ne_isurgent(form.getIsurgent().toString());
			if (WEB_CMD_EDIT.equals(CMD)) {
				params.set_nne_recid(form.getRecid().toString());
			}
			DataPackage dp = control.doQuery(params);
			if(null != dp && dp.getRowCount()>0){
				if("APPSTAR".equals(form.getObjtype())){
					throw new Exception("���Ǽ��������Ѵ��ڣ����顣");
				}else{
					throw new Exception("�ú����̵������Ѵ��ڣ����顣");
				}
			}
			super.doSave();
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		if ("APPSTAR".equals(this.otlimitType)) {// �Ǽ�
			return "content";
		}else{// ����
			return "content2";
		}
	}
	
	
	
	
	
}