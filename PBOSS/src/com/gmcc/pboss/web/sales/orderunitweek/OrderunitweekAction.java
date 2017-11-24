/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderunitweek;

import java.util.LinkedList;
import java.util.List;

import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekDBParam;
import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekVO;
import com.gmcc.pboss.control.sales.orderunitweek.Orderunitweek;
import com.gmcc.pboss.control.sales.orderunitweek.OrderunitweekBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrderunitAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderunitweekAction extends BaseAction{
	private List<OrderunitweekForm> orderunitweekList = new LinkedList<OrderunitweekForm>();
	public OrderunitweekAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderunitweekForm());
		OrderunitweekWebParam param = new OrderunitweekWebParam();
		param.set_se_unitagemode(OrderunitweekConstant.MODE_WEEK);
		this.setParam(param);

        //指定VO类
        setClsVO(OrderunitweekVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderunitweek.class);
		this.setClsQueryParam(OrderunitweekDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderunitweekDBParam param = (OrderunitweekDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
		
		DataPackage dp = getDp();
		List<OrderunitweekVO> list = dp.getDatas();
		for(OrderunitweekVO orderunitweekVO:list)
		{
			OrderunitweekForm orderunitweekForm = new OrderunitweekForm();
			BeanUtils.copyProperties(orderunitweekForm, orderunitweekVO);
			
			String unitage = orderunitweekForm.getUnitage();
			if (null != unitage) {
				String[] unitageArray = unitage.split("\\|");
				String[] tmpArray = {"","","","","","",""};
				for (int i=0; i<unitageArray.length; i++) {
					if (i >= tmpArray.length) {
						break;
					}
					tmpArray[i] = unitageArray[i];
				}
				int i = 0;
				orderunitweekForm.setUnitage1(tmpArray[i++]);
				orderunitweekForm.setUnitage2(tmpArray[i++]);
				orderunitweekForm.setUnitage3(tmpArray[i++]);
				orderunitweekForm.setUnitage4(tmpArray[i++]);
				orderunitweekForm.setUnitage5(tmpArray[i++]);
				orderunitweekForm.setUnitage6(tmpArray[i++]);
				orderunitweekForm.setUnitage7(tmpArray[i++]);
			}

			orderunitweekList.add(orderunitweekForm);
		}
		
		return WEB_RESULT_LIST;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		OrderunitweekVO orderunitweekVO = (OrderunitweekVO) getForm();
		OrderunitweekForm form= new OrderunitweekForm();
		BeanUtils.copyProperties(form, orderunitweekVO);
		if (null != form.getUnitage()) {
			String[] unitageArray = form.getUnitage().split("\\|");
			String[] tmpArray = {"","","","","","",""};
			for (int i=0; i<unitageArray.length; i++) {
				if (i >= tmpArray.length) {
					break;
				}
				tmpArray[i] = unitageArray[i];
			}
			int i = 0;
			form.setUnitage1(tmpArray[i++]);
			form.setUnitage2(tmpArray[i++]);
			form.setUnitage3(tmpArray[i++]);
			form.setUnitage4(tmpArray[i++]);
			form.setUnitage5(tmpArray[i++]);
			form.setUnitage6(tmpArray[i++]);
			form.setUnitage7(tmpArray[i++]);
		}
		
		setForm(form);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderunitweekForm form= (OrderunitweekForm) getForm();
		
		//查询记录是否已经存在
		OrderunitweekDBParam param = new OrderunitweekDBParam();
		param.set_se_cityid(form.getCityid());
		param.set_se_comcategory(form.getComcategory());
		param.set_se_unitagemode(OrderunitweekConstant.MODE_WEEK);
		Orderunitweek orderunitweek = (Orderunitweek)BOFactory.build(OrderunitweekBO.class, getDBAccessUser());
		
		if (WEB_CMD_EDIT.equals(CMD)) {
			param.set_nne_recid(form.getRecid().toString());
		}
		DataPackage dp = orderunitweek.doQuery(param);
		if (dp.getRowCount() > 0) {
			addActionError("相同记录已经存在，请检查。");
			return WEB_RESULT_CONTENT;
		}
		
		//保存
		String unitage = form.getUnitage1() + "|" + form.getUnitage2() + "|" + form.getUnitage3() + "|" + form.getUnitage4() + "|"
							+ form.getUnitage5() + "|" + form.getUnitage6() + "|" + form.getUnitage7() + "|";
		form.setUnitage(unitage);
		form.setUnitagemode(OrderunitweekConstant.MODE_WEEK);
		super.doSave();
		setActionMessage("保存成功!");
		setCMD(WEB_CMD_SAVE);
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderunitweekForm form = (OrderunitweekForm)getForm();
		form.setUnitage1("20");
		form.setUnitage2("20");
		form.setUnitage3("20");
		form.setUnitage4("20");
		form.setUnitage5("20");
		form.setUnitage6("20");
		form.setUnitage7("20");
		return WEB_RESULT_CONTENT;
	}

	public List<OrderunitweekForm> getOrderunitweekList() {
		return orderunitweekList;
	}

	public void setOrderunitweekList(List<OrderunitweekForm> orderunitweekList) {
		this.orderunitweekList = orderunitweekList;
	};	
}