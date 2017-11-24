/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
package com.gmcc.pboss.web.resource.orderresstart;

import java.util.List;

import com.gmcc.pboss.business.resource.orderresstart.OrderresstartDBParam;
import com.gmcc.pboss.business.resource.orderresstart.OrderresstartVO;
import com.gmcc.pboss.control.resource.orderresstart.Orderresstart;
import com.gmcc.pboss.control.resource.orderresstart.OrderresstartBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: OrderresstartAction
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
 * @author
 * @version 1.0
 */
public class OrderresstartAction extends BaseAction {
	public OrderresstartAction() {
		super();
		this.setForm(new OrderresstartForm());
	}

	// 订购资源启用查询
	public String doList() {
		OrderresstartForm form = (OrderresstartForm) getForm();
		form.setButtonflag("disable");
		//if (AAUtilsForStruts2.isAjaxRequest()) {
			try {
				if (this.isQuery) {// 当默认进页面时不执行查询
					Orderresstart ors = (Orderresstart) BOFactory.build(
							OrderresstartBO.class, getDBAccessUser());
					String comstate = "30";// 待分配
					String batchno = form.getBatchno();
					OrderresstartDBParam param = new OrderresstartDBParam();
					DataPackage dp = new DataPackage();
					if ("taoka".equals(form.getRestype())) {
						dp = ors.doComresStat(param, comstate, batchno);
					} else if("chongzhika".equals(form.getRestype())){
						dp = ors.doComresCardStat(param, comstate, batchno);
					}else if("kongbaisimka".equals(form.getRestype())){
						dp = ors.doKBSIMStat(param, comstate, batchno);
					}
					setDp(dp);
					if (dp.getRowCount() > 0) {
						form.setButtonflag("able");
					} else {
						form.setButtonflag("disable");
					}
					Long allcount = 0L;
					List<OrderresstartVO> orderresstartlist = dp.getDatas();
					for(OrderresstartVO vo : orderresstartlist){
						Long count = vo.getCount();
						allcount = allcount + count;
					}
					form.setAllcount(allcount);
				}
			} catch (Exception e) {
				e.printStackTrace();
				super.addActionError(e.getCause() == null ? e.getMessage() : e
						.getCause().getMessage());
				AAUtilsForStruts2.addZonesToRefresh("refreshTable");
			}
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		//}
		return "list";
	}

	// 订购资源启用
	public String doStart() {
		try {
			Orderresstart ors = (Orderresstart) BOFactory.build(
					OrderresstartBO.class, getDBAccessUser());
			OrderresstartForm form = (OrderresstartForm) getForm();
			String batchno = form.getBatchno();
			if ("taoka".equals(form.getRestype())) {
				ors.doStartSmlp(batchno);
			}else if("chongzhika".equals(form.getRestype())){
				ors.doStartCard(batchno);
			}else if("kongbaisimka".equals(form.getRestype())){
				ors.doStartEmptyCard(batchno);
			}
			addActionMessage("订购资源已启用.");
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage() : e
					.getCause().getMessage());
		}
		return "list";
	}

	private boolean isQuery;// 是否统计标识，默认不查询

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}

}