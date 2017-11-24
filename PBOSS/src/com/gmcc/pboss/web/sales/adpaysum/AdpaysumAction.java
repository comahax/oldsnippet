/**
 * auto-generated code
 * Wed Apr 28 12:20:30 CST 2010
 */
 package com.gmcc.pboss.web.sales.adpaysum;

import com.gmcc.pboss.business.sales.adpaysum.AdpaysumDBParam;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.gmcc.pboss.control.sales.adpaysum.Adpaysum;
import com.gmcc.pboss.control.sales.adpaysum.AdpaysumBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AdpaysumAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class AdpaysumAction extends BaseAction{
	
	public AdpaysumAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new AdpaysumForm());
		this.setParam(new AdpaysumDBParam());

        //ָ��VO��
        setClsVO(AdpaysumVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"sumid"};
		this.setClsControl(Adpaysum.class);
		this.setClsQueryParam(AdpaysumDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		if(this.isQuery){ 
			AdpaysumDBParam params =(AdpaysumDBParam)this.getParam();
			Adpaysum bo = (AdpaysumBO)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			DataPackage dp = bo.doQuery(params);
			this.setDp(dp);
		}
		return WEB_RESULT_LIST;
	}
	
	//ִ��ȷ��
	public String doConfirm() throws Exception{
		try {
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			String[] selectItem = param.get_selectitem();
			String sumid = getParam().get_pk();
			adpaysum.doConfirm(sumid);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return super.doList();
	}
	
	//ִ��֧��
	public String doPay() throws Exception{
		try{
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			String sumid = getParam().get_pk();
			adpaysum.doPay(sumid);
			super.addActionMessage("���ܵ�["+sumid+"]֧���ɹ�");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return super.doList();
	}
	
	//�鿴��ϸ
	public String doDetail() throws Exception{
		try {
			Order order = (Order)BOFactory.build(OrderBO.class, getDBAccessUser());
//			String[] selectItem = param.get_selectitem();
//			String[] pk = null;
//			pk = selectItem[0].split("\\|");
//			String _ne_sumid = pk[0];
//			String _ne_sumid = getRequest().getParameter("sumid");
			String _ne_sumid = getParam().get_pk();
			DataPackage dp = order.doQueryAdpaydet(_ne_sumid);
			setDp(dp);
			
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			AdpaysumVO vo = (AdpaysumVO) adpaysum.doFindByPk(new Long(_ne_sumid));
			AdpaysumForm form2 = new AdpaysumForm();
			BeanUtils.copyProperties(form2, vo);
			setForm(form2);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "detail";
	}
	private boolean isQuery;// �Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
}