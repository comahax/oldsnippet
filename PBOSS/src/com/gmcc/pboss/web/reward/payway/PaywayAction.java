package com.gmcc.pboss.web.reward.payway;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.business.reward.payway.VPaywayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.gmcc.pboss.web.reward.payway.PaywayForm;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: PaywayAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class PaywayAction extends BaseAction {

	private static final long serialVersionUID = -6186028680686219045L;

	private final Logger log = LoggerFactory.getLogger(PaywayAction.class);

	// 默认的分页大小
	private final static String DEFAULT_PAGESIZE = "20";

	public PaywayAction() {
		super();

		this.setForm(new PaywayForm());
		this.setParam(new PaywayDBParam());

		setClsVO(PaywayVO.class);
		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Payway.class);
		this.setClsQueryParam(PaywayDBParam.class);

	}

	public String doList() throws Exception {
		User user = (User) getDBAccessUser();
		Payway payee = (Payway) BOFactory.build(PaywayBO.class, user);
		PaywayDBParam params = (PaywayDBParam) getParam();
		// 清除输入收款单位的空格
		String skPayee = params.get_sk_payee();
		if (StringUtils.isNotEmpty(skPayee)) {
			params.set_sk_payee(skPayee.trim());
		}

		String seWayId = params.get_se_wayid();
		if (StringUtils.isNotEmpty(seWayId)) {
			params.set_se_wayid(seWayId.trim());
		}

		params.set_pagesize(DEFAULT_PAGESIZE);
		params.getQueryConditions().put("cityid", user.getCityid());

		String qrySql = "com.gmcc.pboss.business.reward.payway.doQueryBySql";
		DataPackage dp = payee.doQueryBySql(params, qrySql);
		setDp(dp);
		return "list";
	}

	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Payway payee = (Payway) BOFactory.build(PaywayBO.class,
				getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			payee.doRemoveByPK(getSelectedPK(selectArray[i]));
		}
		return doList();
	}

	/**
	 * 判断是否为本地市或省的渠道编码
	 * 
	 * @param payee
	 * @param cityid
	 * @param wayid
	 * @return
	 */
	private String getWayidBelongCityid(Payway payee, String wayid) {
		String cityid = "";

		// 须检查该渠道编码是否为该地市或省的，因为下拉框供选择的是全部渠道编码
		PaywayDBParam params = new PaywayDBParam();
		params.set_pagesize(DEFAULT_PAGESIZE);
		params.setDataOnly(true);
		params.setSelectFieldsString("cityid");
		params.getQueryConditions().put("wayid", wayid);

		String qrySql = "com.gmcc.pboss.business.reward.payway.doQueryVWayByWayIdSql";
		try {
			DataPackage dp = payee.doQueryBySql(params, qrySql);
			List<String> wayList = (List<String>) dp.getDatas();
			if (wayList != null && wayList.size() > 0) {
				cityid = wayList.get(0);
			}
		} catch (SQLException e) {
			log.error("数据库连接错误 \n" + e.getMessage());
			addActionError("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			log.error("其他错误 \n" + e.getMessage());
			addActionError("其他错误 \n" + e.getMessage());
		}

		return cityid;
	}

	public String doSave() throws Exception {
		User user = (User) getDBAccessUser();
		PaywayForm paywayForm = (PaywayForm) getForm();
		Payway payee = (Payway) BOFactory.build(PaywayBO.class, user);

		// 一个渠道编码只能归属一个收款单位，一个收款单位可以有多个渠道编码
		// 因此只需要判断渠道编码名称唯一性
		PaywayDBParam params = new PaywayDBParam();

		String cityid = user.getCityid();
		String wayid = paywayForm.getWayid();

		params.set_se_cityid(cityid);
		params.set_se_wayid(wayid);
		params.set_pagesize(DEFAULT_PAGESIZE);
		DataPackage dp = payee.doQuery(params);

		int size = dp.getDatas().size();
		if (size > 0 && !CMD.equals("EDIT")) {
			super.addActionError("一个渠道编码只能对应一个收款单位，该渠道编码【" + wayid + "】已存在");
			return "content";
		}

		// 判断是否为本地市或省的渠道编码
		String belongCityid = getWayidBelongCityid(payee, wayid);
		if (StringUtils.isEmpty(belongCityid)) {
			StringBuilder strb = new StringBuilder();
			strb.append("没能在渠道表找到该渠道编码【");
			strb.append(wayid);
			strb.append("】，请返回重新选择");

			super.addActionError(strb.toString());
			return "content";
		} else if (!(belongCityid.equals("GD") || belongCityid.equals(cityid))) {
			StringBuilder strb = new StringBuilder();
			strb.append("该渠道编码【");
			strb.append(wayid);
			strb.append("】属于【");
			strb.append(belongCityid);
			strb.append("】，请返回重新选择");

			super.addActionError(strb.toString());
			return "content";
		}

		if (CMD.equals("NEW")) {
			PaywayVO payeeVO = new PaywayVO();
			BeanUtils.copyProperties(payeeVO, paywayForm);
			payeeVO.setCityid(cityid);

			payeeVO = payee.doCreate(payeeVO);
			BeanUtils.copyProperties(getForm(), payeeVO);
		} else if (CMD.equals("EDIT")) {
			PaywayVO vo = payee.doFindByPk(paywayForm.getSeq());
			BeanUtils.copyProperties(vo, paywayForm);
			vo.setCityid(cityid);
			vo = payee.doUpdate(vo);
			BeanUtils.copyProperties(paywayForm, vo);
		}

		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}

	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("收款单位资料");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("payee", "收款单位");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");

		// 设置VO类
		export.voClassArray = new Class[] { VPaywayVO.class };

		// 设置查询方法
		export.queryMethodName = "doList";
		PaywayDBParam params = (PaywayDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}
