/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.web.sales.disform;

import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date; 
import java.util.List; 
import javax.servlet.http.HttpServletRequest; 
import org.apache.struts2.ServletActionContext; 
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO; 
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disform.GDisformVO;
import com.gmcc.pboss.business.sales.disform.PDisformVO;
import com.gmcc.pboss.business.sales.disform.SDisformVO;
import com.gmcc.pboss.business.sales.disform.VDisformVO; 
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam; 
import com.gmcc.pboss.common.export.CommonExportBean;  
import com.gmcc.pboss.control.channel.employee.EmployeeBO; 
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO; 
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: DisformAction
 * </p>;
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class DisformAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DISFORM_WAIT_OUT = "WAITOUT";

	public static final String DISFORM_WATT_DIS = "WAITDIS";

	public static final String DISFORM_DIS_ING = "DISING";

	public static final String DISFORM_DIS_OVER = "DISOVER";

	public static final String DISFORM_CANCEL = "CANCEL";

	public static final String DISFORM_WAIT_SIGN = "WAITSIGN";

	public static final String DISFORM_SIGNED = "SIGNED";

	public static final String DISFORM_REFUSE = "REFUSE";

	private boolean isValid = true;

	public DisformAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new DisformForm());
		this.setParam(new DisformDBParam());

		// 指定VO类
		setClsVO(DisformVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Disform.class);
		this.setClsQueryParam(DisformDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 设置界面默认配送单状态为待发货
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doShow() throws Exception {
		DisformDBParam params = (DisformDBParam) getParam();
		User user = (User) super.getRequest().getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Way wayBO = (WayBO) BOFactory.build(WayBO.class, super
				.getDBAccessUser());
		WayVO wayvo = wayBO.doFindByPk(user.getWayid());

		if (null != wayvo.getCountyid() && !"".equals(wayvo.getCountyid())) {
			params.set_se_countyid(wayvo.getCountyid());
		}

		/**
		 * 修改创建时间为默认显示为当天的00:00:00至23:59:59 modify by wangsheng 
		 * modified by LiZhaoLiang 2010-9-16
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		params.set_dnl_createtime(currentDate + " 00:00:00");
		params.set_dnm_createtime(currentDate + " 23:59:59");

		params.set_se_disstate(DISFORM_WAIT_OUT);

		return this.doList();
	}

	/**
	 * 关联分销资源配送单(FX_SW_DISFORM)和订单表(FX_SW_ORDER)进行查询，并按照界面格式进行展示。
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try {
			DisformDBParam params = (DisformDBParam) getParam();
			DisformBO disbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			DataPackage dp = disbo.doQuerydp(params);
			if (dp != null && dp.getDatas().size() > 0) {
				List<VDisformVO> list = dp.getDatas();
				for (VDisformVO vo : list) {
					// doGetOrderInfo()将同商品种类的订购数量进行累加，并按照“商品种类A（数量），商品种类B（数量）”进行组合。
					vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
					if (vo.getRecordtime() == null) {
						vo.setIsrecord("否");
					} else {
						vo.setIsrecord("是");
					}
				}
			}
			super.getRequest().getSession().setAttribute("DISFORMPARAMS",
					params);
			this.setDp(dp);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return WEB_RESULT_LIST;
	}

	/**
	 * 仓管发货-处理配送单为待配送状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doConsignment() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			// 遍历勾选的记录, 判断状态是否为待发货
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (dfvo != null) {
					if (!DISFORM_WAIT_OUT.equals(dfvo.getDisstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			// 通过则处理数据
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_WATT_DIS);
						updatevo.setStoresman(getDBAccessUser().getOprcode());
						updatevo.setOuttime(new Date());
						dfbo.doUpdateOrder(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("操作成功！");
			} else {
				setActionMessage("只有当配送单状态为待发货时，才允许执行发货操作，配送单 " + faildislist
						+ "状态非待发货！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * 启动配送-处理配送单为配送中状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doStartdis() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			// 遍历勾选的记录, 判断状态是否为待配送
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (dfvo != null) {
					if (!DISFORM_WATT_DIS.equals(dfvo.getDisstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			// 通过则处理数据
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_DIS_ING);
						dfbo.doUpdate(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("操作成功！");
			} else {
				setActionMessage("只有当配送单状态为待配送时，才允许启动配送操作，配送单 " + faildislist
						+ "状态非待配送！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * 完成配送-处理配送单为配送完成状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doDisover() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			// 遍历勾选的记录, 判断状态是否为配送中
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (!DISFORM_DIS_ING.equals(dfvo.getDisstate())) {
					isValid = false;
					faildisform = "[" + selectArray[i] + "]";
					faildislist = faildislist + faildisform + " ";
				}
			}
			// 通过则处理数据
			if (isValid) {				
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_DIS_OVER);
						dfbo.doUpdate(updatevo);
						OrderVO ordervo = orderbo.doFindByPk(updatevo
								.getOrderid());
						if (ordervo != null) {
							ordervo.setDisovertime(new Date());
							orderbo.doUpdate(ordervo);
						} 
						dfbo.dosSendMsg(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("操作成功！");
			} else {
				setActionMessage("只有当配送单状态为配送中时，才允许完成配送操作，配送单 " + faildislist
						+ "状态非配送中！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * 确认签收
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doComfirmSign() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			if (selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
				if (ordervo != null) {
					if (!DISFORM_WAIT_SIGN.equals(ordervo.getSignstate())
							&& !DISFORM_REFUSE.equals(ordervo.getSignstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if (ordervo != null) {
						ordervo.setSignstate(DISFORM_SIGNED);
						ordervo.setSigntime(new Date());
						ordervo.setSigntype("SYS");
						orderbo.doUpdate(ordervo);
						
						dfbo.doUpdateWayassistant(ordervo);
					}
				} 
				dfbo.doDealOrderBySys(selectArray);
			}   
			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("操作成功！");
			} else {
				setActionMessage("只有待签收或拒绝签收状态才允许确认签收，配送单[" + faildislist
						+ "] 状态有误。请检查！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * 配送单导出
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("分销资源配送单");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "配送单编号");
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("paytype", "缴费方式", export.CODE2NAME,
				"$FX_PAYTYPE");
		export.addOutputProperty("discomcode", "配送商名称", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("recewayid", "收货网点", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("recewayid", "网点编码");
		export.addOutputProperty("recename", "收货人姓名");
		export.addOutputProperty("recetel", "收货人电话");
		export.addOutputProperty("receadd", "收货人地址");
		export.addOutputProperty("createtime", "创建时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("arrivetime", "要求送达时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disstate", "配送单状态", export.CODE2NAME,
				"$FX_DISFORMSTATE");
		export.addOutputProperty("signstate", "签收状态", export.CODE2NAME,
				"$FX_SIGNSTATE");
		export.addOutputProperty("orderinfo", "订单信息");
		export.addOutputProperty("actamt", "金额");
		export.addOutputProperty("disovertime", "配送完成时间");
		export.addOutputProperty("isrecord", "是否入账");
		export.addOutputProperty("memo", "备注");

		export.voClassArray = new Class[] { VDisformVO.class };
		DisformDBParam params = (DisformDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	/**
	 * 配送单明细导出
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExportExcel() throws Exception {
		DisformForm form = (DisformForm) getForm();
		DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
				getDBAccessUser());
		DisformDBParam dfParam = new DisformDBParam();
		OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
				getDBAccessUser());
		OrderresdetDBParam odparam = new OrderresdetDBParam();
		OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, getDBAccessUser());
		String pk = getParam().get_pk();
		dfParam.set_ne_recid(pk);
		dfParam.set_pageno("1");
		DataPackage dp = dfBo.doQuerydp(dfParam);
		if (dp != null && dp.getDatas().size() > 0) {
			List<VDisformVO> list = dp.getDatas();
			for (VDisformVO vo : list) {
				// doGetOrderInfo()将同商品种类的订购数量进行累加，并按照“商品种类A（数量），商品种类B（数量）”进行组合。
				vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
			}
		}
		VDisformVO dfvo = (VDisformVO) dp.getDatas().get(0);
		BeanUtils.copyProperties(form, dfvo);

		odparam.set_se_orderid(form.getOrderid());
		odparam.set_pageno(super.getParam().get_pageno());
		// 全量导出
		odparam.setQueryAll(true);
		DataPackage detdp = odbo.doQuery(odparam);
		this.setForm(form);
		this.setDp(detdp);
		return "excelexport";
	}

	/**
	 * 显示/编辑对应配送单信息及其对应的明细记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doEdit() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam dfParam = (DisformDBParam) getParam();
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			OrderresdetDBParam odparam = new OrderresdetDBParam();
			OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, getDBAccessUser());
			String pk = getParam().get_pk();
			dfParam.set_ne_recid(pk);
			DataPackage dp = dfBo.doQuerydp(dfParam);
			if (dp != null && dp.getDatas().size() > 0) {
				List<VDisformVO> list = dp.getDatas();
				for (VDisformVO vo : list) {
					// doGetOrderInfo()将同商品种类的订购数量进行累加，并按照“商品种类A（数量），商品种类B（数量）”进行组合。
					vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
				}
			}
			if (dp.getDatas().size() > 0) {
				VDisformVO dfvo = (VDisformVO) dp.getDatas().get(0);
				BeanUtils.copyProperties(form, dfvo);
			}

			dfParam.set_ne_recid(null);

			odparam.set_se_orderid(form.getOrderid());
			odparam.set_pageno(super.getParam().get_pageno());
			odparam.set_pagesize("10");
			DataPackage detdp = odbo.doQuery(odparam);
			// 配送单信息显示
			this.setForm(form);
			// 保留查询条件,从Session中取出DBParam的值
			DisformDBParam temparam = (DisformDBParam) request.getSession()
					.getAttribute("DISFORMPARAMS");
			BeanUtils.copyProperties(dfParam, temparam);
			// 设定分页信息
			dfParam.set_pageno(odparam.get_pageno());
			dfParam.set_pagesize(odparam.get_pagesize());
			// 配送单明细显示
			this.setDp(detdp);
			this.setCMD(WEB_CMD_EDIT);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	/**
	 * 根据配送单编号将界面内容（收货人姓名、收货人电话、收货人地址、备注） 更新到分销资源配送单(FX_SW_DISFORM)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doSave() throws Exception {
		try {
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderresdetDBParam odparam = new OrderresdetDBParam();
			OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, getDBAccessUser());

			DisformVO vo = dfBo.doFindByPk(form.getRecid());
			if (vo != null) {
				vo.setMemo(form.getMemo());
				vo.setReceadd(form.getReceadd());
				vo.setRecename(form.getRecename());
				vo.setRecetel(form.getRecetel());
				vo.setLogisticsno(form.getLogisticsno());
				vo = dfBo.doUpdate(vo);
				// 返回页面显示
				BeanUtils.copyProperties(form, vo);
				odparam.set_se_orderid(form.getOrderid());
				odparam.set_pageno(super.getParam().get_pageno());
				DataPackage detdp = odbo.doQuery(odparam);
				// 配送单信息显示
				this.setForm(form);
				// 配送单明细显示
				this.setDp(detdp);
				this.setCMD(WEB_CMD_SAVE);
				setActionMessage("保存成功!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "content";
	}

	/**
	 * 单个打印页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doPrint() throws Exception {
		try {
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam params = new DisformDBParam();
			params.set_se_orderid(form.getOrderid());
			DataPackage dp = dfBo.doQueryPrint(params);
			PDisformVO dfvo = (PDisformVO) dp.getDatas().get(0);
			// 页面显示
			BeanUtils.copyProperties(form, dfvo);
			DataPackage printdp = dfBo.doQueryPrintDp(params);
			List<PDisformVO> list = printdp.getDatas();
			for (PDisformVO vo : list) {
				if ("COMRESSMP".equals(vo.getRestype())
						&& "CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetBatchnoBoxnum(vo));
				} else if ("COMRESSMP".equals(vo.getRestype())
						&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
					vo.setMemo(vo.getOrdercomtype());
				} else if ("COMRESCARD".equals(vo.getRestype())
						&& "CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
				} else if ("COMRESCARD".equals(vo.getRestype())
						&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
					vo.setMemo(vo.getOrdercomtype());
				}
			}
			this.setDp(printdp);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "print";
	}

	/**
	 * 批量打印功能
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doBatchPrint() throws Exception {
		try {
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam params = new DisformDBParam();
			List plist = (List) new ArrayList();
			if (selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}

			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				params.set_se_orderid(dfvo.getOrderid());
				DataPackage dp = dfbo.doQueryPrint(params);
				PDisformVO pdfvo = (PDisformVO) dp.getDatas().get(0);
				DataPackage printdp = dfbo.doQueryPrintDp(params);
				List<PDisformVO> list = printdp.getDatas();
				for (PDisformVO vo : list) {
					// 对查询结果集赋值
					vo.setOrderid(pdfvo.getOrderid());
					vo.setRecid(pdfvo.getRecid());
					vo.setDiscomcode(pdfvo.getDiscomcode());
					vo.setOrdercreatetime(pdfvo.getOrdercreatetime());
					vo.setDiscreatetime(pdfvo.getDiscreatetime());
					vo.setArrivetime(pdfvo.getArrivetime());
					vo.setRecewayid(pdfvo.getRecewayid());
					vo.setRecename(pdfvo.getRecename());
					vo.setRecetel(pdfvo.getRecetel());
					vo.setReceadd(pdfvo.getReceadd());
					vo.setStoresman(pdfvo.getStoresman());
					vo.setOuttime(pdfvo.getOuttime());
					vo.setTotalorderamt(pdfvo.getTotalorderamt());
					vo.setAllprice(pdfvo.getAllprice());
					if ("COMRESSMP".equals(vo.getRestype())
							&& "CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetBatchnoBoxnum(vo));
					} else if ("COMRESSMP".equals(vo.getRestype())
							&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
						vo.setMemo(vo.getOrdercomtype());
					} else if ("COMRESCARD".equals(vo.getRestype())
							&& "CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
					} else if ("COMRESCARD".equals(vo.getRestype())
							&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
						vo.setMemo(vo.getOrdercomtype());
					}
				}
				plist.add(printdp);
			}

			DataPackage printdata = new DataPackage();
			// 批量打印总结果集
			printdata.setDatas(plist);
			super.getRequest().setAttribute("dp2", printdata);
			super.getRequest().setAttribute("isPrint", true);

		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * 配送汇总单查询条件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doGather() throws Exception {
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(new Date());
			DisformDBParam params = (DisformDBParam) getParam();
			params.set_de_createtime(date+" 00:00:00");
			params.set_de_createtime1(date+" 23:59:59");

			User user = (User) super.getRequest().getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			if(params.get_se_countyid()==null || "".equals(params.get_se_countyid())){ 
				Way wayBO = (WayBO) BOFactory.build(WayBO.class, super
						.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				params.set_se_countyid(wayvo.getCountyid());
			}
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		return "gather";
	}

	/**
	 * 配送汇总单打印
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doGatherPrint() throws Exception {
		try {
			Long totalnum = new Long(0);
			Long totalorincomprice = new Long(0);
			Double totalorinsellprice = new Double(0);
			User user = (User) super.getRequest().getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			DisformDBParam params = (DisformDBParam) super.getParam();
			DisformForm form = (DisformForm) getForm();
			
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			if (null == params.get_se_countyid()
					|| "".equals(params.get_se_countyid())) {
				setActionMessage("分公司信息为空，不允许执行打印操作。");
				return "gather";
			}/*else{
					if(params.get_se_countyid().length()>0 && params.get_se_countyid().indexOf(",")!=-1){
						    int pos=params.get_se_countyid().lastIndexOf(",");
							params.set_se_countyid(params.get_se_countyid().substring(pos+1));
							params.set_se_countyid(params.get_se_countyid().trim());
					}
			}*/
			// 分公司
			form.setCountyid(params.get_se_countyid());
			// 配送商
			form.setDiscomcode(params.get_se_discomcode());
			// 设定当前日期范围
			if (params.get_de_createtime().equals(params.get_de_createtime1())) {
				form.setGathercreatetime(params.get_de_createtime());
				params.set_dnm_createtime(params.get_de_createtime1().trim());
				params.set_dnl_createtime(params.get_de_createtime().trim());
				params.set_de_createtime(null);
				params.set_de_createtime1(null);
			} else {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_de_createtime());
				mdate = myformat.parse(params.get_de_createtime1());
				Long day = (mdate.getTime() - ldate.getTime())
						/ (1000 * 60 * 60 * 24);
				if (day >30) {
					setActionMessage("创建时间间隔不能超过30天。");
					return "gather";
				} else {
					form.setGathercreatetime(params.get_de_createtime() + " 至 "
							+ params.get_de_createtime1());
					params.set_dnm_createtime(params.get_de_createtime1().trim());
					params.set_dnl_createtime(params.get_de_createtime().trim());
					params.set_de_createtime(null);
					params.set_de_createtime1(null);
				}
			}

			DataPackage dp = dfbo.doGatherPrintDp(params);
			if (dp != null && dp.getDatas().size() > 0) {
				List<GDisformVO> list = dp.getDatas();
				for (GDisformVO vo : list) {
					String comid = vo.getComid().toString();
					totalnum = totalnum + vo.getNum();
					vo.setComprice(dfbo.getQueryComprice(comid));
					vo.setOrincomprice(vo.getComprice() * vo.getNum());
					totalorincomprice = totalorincomprice
							+ vo.getOrincomprice();
//					vo.setSellprice(new Double(dfbo.doQuerySellingprice(vo)));
					vo.setOrinsellprice(vo.getSellprice() * vo.getNum());
					totalorinsellprice = totalorinsellprice
							+ vo.getOrinsellprice();
					vo.setMemo("");
				}
				this.setDp(dp);
			}
			EmployeeBO empbo = (EmployeeBO) BOFactory.build(EmployeeBO.class,
					getDBAccessUser());
			EmployeeDBParam empparams = new EmployeeDBParam();
			empparams.set_se_wayid(form.getDiscomcode());
			empparams.set_ne_isnet("3");
			empparams.set_ne_empstatus("0");
			DataPackage empdp = empbo.doQuery(empparams);
			if (empdp != null && empdp.getDatas().size() > 0) {
				EmployeeVO empvo = (EmployeeVO) empdp.getDatas().get(0);
				// 发货人姓名
				form.setStoresman(Code2NameUtils.code2Name("#OPERATOR", user
						.getOprcode(), user.getCityid()));
				// 收货人姓名
				form.setRecename(empvo.getEmployeename());
			}
			// 合计数量
			form.setTotalnum(totalnum);
			// 合计原价金额
			form.setTotalorincomprice(totalorincomprice);
			// 合计销售价金额
			form.setTotalorinsellprice(totalorinsellprice);
			// 发货时间为当前默认时间
			form.setOuttime(new Date());

		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return "gatherprint";
	}

	/**
	 * 配送单状态统计
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doDisstateList() throws Exception {
		try {
			Long totalDisformNum = new Long(0);
			Long totalSignNum = new Long(0);
			Long totalUnsignNum = new Long(0);
			DisformForm form = (DisformForm) getForm();
			DisformDBParam params = (DisformDBParam) getParam();
			DisformDBParam signparams = new DisformDBParam();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = format.format(new Date());
			if (StringUtils.isEmpty(params.get_dnl_createtime())
					&& StringUtils.isEmpty(params.get_dnm_createtime())) {
				params.set_dnl_createtime(currentDate + " 00:00:00");
				params.set_dnm_createtime(currentDate + " 23:59:59");
			} else {
				// 创建时间检查, 范围不允许超过30天
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_createtime());
				mdate = myformat.parse(params.get_dnm_createtime());
				Long day = (mdate.getTime() - ldate.getTime())
						/ (1000 * 60 * 60 * 24);
				if (day > 30) {
					setActionMessage("创建时间间隔不能超过30天。");
					return "disstatelist";
				}
			}
			Disform dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			params.set_pagesize("0");
			DataPackage dp = dfbo.doQueryDisState(params);
			List<SDisformVO> list = dp.getDatas();
			if (dp.getDatas().size() > 0) {
				BeanUtils.copyProperties(signparams, params);
				for (SDisformVO vo : list) {
					signparams.set_se_countyid(vo.getCountyid());
					signparams.set_se_svccode(vo.getSvccode());
					signparams.set_se_mareacode(vo.getMareacode());
					signparams.set_se_disstate(vo.getDisstate());
					signparams.set_se_signstate("SIGNED");
					// 获取已签收数
					DataPackage signdp = dfbo.doQuerySignnum(signparams);
					Long signnum = (Long) signdp.getDatas().get(0);
					vo.setSignnum(signnum);
					// 得到未签收数
					vo.setUnsignnum(vo.getNum() - signnum);
					totalDisformNum = totalDisformNum + vo.getNum();
					totalSignNum = totalSignNum + signnum;
					totalUnsignNum = totalUnsignNum + vo.getUnsignnum();
				}
				form.setTotaldisformnum(totalDisformNum);
				form.setTotalsignnum(totalSignNum);
				form.setTotalunsignnum(totalUnsignNum);
			}
			this.setForm(form);
			this.setDp(dp);
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return "disstatelist";
	}

	/**
	 * 配送单状态统计-导出EXCEL
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExcelDisstate() throws Exception {
		try{
		Long totalDisformNum = new Long(0);
		Long totalSignNum = new Long(0);
		Long totalUnsignNum = new Long(0);
		Disform dfbo = (DisformBO) BOFactory.build(DisformBO.class,
				getDBAccessUser());
		DisformForm form = (DisformForm) getForm();
		DisformDBParam params = (DisformDBParam) getParam();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		if (StringUtils.isEmpty(params.get_dnl_createtime())
				&& StringUtils.isEmpty(params.get_dnm_createtime())) {
			params.set_dnl_createtime(currentDate + " 00:00:00");
			params.set_dnm_createtime(currentDate + " 23:59:59");
		} else {
			// 创建时间检查, 范围不允许超过30天
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_createtime());
			mdate = myformat.parse(params.get_dnm_createtime());
			Long day = (mdate.getTime() - ldate.getTime())
					/ (1000 * 60 * 60 * 24);
			if (day > 30) {
				return this.doDisstateList();
			}
		}
		params.set_pagesize("0");
		DataPackage dp = dfbo.doQueryDisState(params);
		List<SDisformVO> list = dp.getDatas();
		if (dp.getDatas().size() > 0) {
			for (SDisformVO vo : list) {
				params.set_se_countyid(vo.getCountyid());
				params.set_se_svccode(vo.getSvccode());
				params.set_se_mareacode(vo.getMareacode());
				params.set_se_disstate(vo.getDisstate());
				params.set_se_signstate("SIGNED");
				DataPackage signdp = dfbo.doQuerySignnum(params);
				Long signnum = (Long) signdp.getDatas().get(0);
				vo.setSignnum(signnum);
				vo.setUnsignnum(vo.getNum() - signnum);
				totalDisformNum = totalDisformNum + vo.getNum();
				totalSignNum = totalSignNum + signnum;
				totalUnsignNum = totalUnsignNum + vo.getUnsignnum();
			}
			form.setTotaldisformnum(totalDisformNum);
			form.setTotalsignnum(totalSignNum);
			form.setTotalunsignnum(totalUnsignNum);
		}
		this.setForm(form);
		this.setDp(dp);
		}catch(Exception e){
			setActionMessage(e.getMessage());
		}
		return "exceldisstate";
	}
}