/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
 package com.gmcc.pboss.web.sales.ordercomcate;

import java.util.List;

import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanVO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate ;
import com.gmcc.pboss.control.sales.saleplan.Saleplan;
import com.gmcc.pboss.control.sales.saleplan.SaleplanBO;

/**
 * <p>Title: OrdercomcateAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdercomcateAction extends BaseAction{
	
	public OrdercomcateAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrdercomcateForm());
		this.setParam(new OrdercomcateWebParam());

        //指定VO类
        setClsVO(OrdercomcateVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ordercomcate.class);
		this.setClsQueryParam(OrdercomcateDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			super.doList();
			DataPackage tmpDP = this.getDp();
			if (null != tmpDP && null != tmpDP.getDatas()) {
				List<OrdercomcateVO> list = tmpDP.getDatas();
				//int location = 0;
				for (OrdercomcateVO vo : list) {
					if(vo.getPlanCode() != null && !"".equals(vo.getPlanCode())){
						Saleplan saleplanBO = (SaleplanBO)BOFactory.build(SaleplanBO.class,getDBAccessUser());
						SaleplanDBParam saleplanDBParam = new SaleplanDBParam();
						saleplanDBParam.set_se_cityid(getDBAccessUser().getCityid());
						saleplanDBParam.set_se_plancode(vo.getPlanCode());
						DataPackage saleplanDP = saleplanBO.doQuery(saleplanDBParam);
						if (null != saleplanDP && null != saleplanDP.getDatas() 
								&& saleplanDP.getDatas().size()>0) {
							SaleplanVO saleplanVO = (SaleplanVO)saleplanDP.getDatas().get(0);
							
							vo.setPlanName(saleplanVO.getPlanname());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
}