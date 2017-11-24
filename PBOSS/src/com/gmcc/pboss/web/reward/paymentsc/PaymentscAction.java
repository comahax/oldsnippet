package com.gmcc.pboss.web.reward.paymentsc;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.base.config.ConfigVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscDBParam;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscVO;
import com.gmcc.pboss.business.reward.paymentsc.VPaymentscVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.base.config.Config;
import com.gmcc.pboss.control.base.config.ConfigBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.reward.paymentsc.Paymentsc;
import com.gmcc.pboss.control.reward.paymentsc.PaymentscBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: PaymentscAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class PaymentscAction extends BaseAction {

	private static final long serialVersionUID = -6818370517519651343L;

	private final Logger log = LoggerFactory.getLogger(PaymentscAction.class);

	// 如果pagesize为0，表示不分页，只有1页
	private final static String NG_PAGESIZE = "0";

	// 默认的分页大小
	private final static String DEFAULT_PAGESIZE = "20";

	// 审核校验的两种标识
	private final static String ISCHECKED = "CHECKED";
	private final static String NOTCHECKED = "UNCHECKED";

	// 开关的两种标识
	private final static String SWITCH_OPEN = "open";
	private final static String SWITCH_CLOSE = "close";

	private String switchflag = SWITCH_CLOSE;

	private String amounts;

	private String delFields = "seq,checkedflag";

	private boolean isSumQuery = true;

	public String getSwitchflag() {
		return switchflag;
	}

	public void setSwitchflag(String switchflag) {
		this.switchflag = switchflag;
	}

	public String getAmounts() {
		return amounts;
	}

	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}

	public PaymentscAction() {
		super();

		this.setForm(new PaymentscForm());
		this.setParam(new PaymentscDBParam());

		setClsVO(PaymentscVO.class);
		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Paymentsc.class);
		this.setClsQueryParam(PaymentscDBParam.class);
	}

	private void setErrorLog(String error) {
		log.error(error);
		addActionError(error);
	}

	/**
	 * 检查审核开关的状态
	 * 
	 * @param user
	 * @return
	 */
	private String checkSwitch(User user) {
		String flag = SWITCH_CLOSE;
		try {
			Config config = (Config) BOFactory.build(ConfigBO.class, user);
			ConfigVO vo = config.doFindByPk("PAYMENT_CHK_SWITCH_CITY");
			if (vo.getValue().equalsIgnoreCase("OPEN")) {
				flag = SWITCH_OPEN;
			}
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		return flag;
	}

	private String querySumBySql(User user, PaymentscDBParam params) {
		String amounts = "-1.0";
		boolean flag = false;
		if (switchflag.equals(SWITCH_OPEN)) {
			flag = true;
		}

		Paymentsc paymentsc = null;
		try {
			paymentsc = (Paymentsc) BOFactory.build(PaymentscBO.class, user);
			amounts = paymentsc.doQuerySumByNamedSql(params, flag);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		return amounts;
	}

	public String doList() {
		User user = (User) getDBAccessUser();

		switchflag = checkSwitch(user);

		PaymentscDBParam params = (PaymentscDBParam) getParam();

		String wayid = params.get_se_wayid();
		if (StringUtils.isNotEmpty(wayid)) {
			params.set_se_wayid(wayid.trim());
		}
		// 大类
		String skLtype = params.get_sk_ltype();
		if (StringUtils.isNotEmpty(skLtype)) {
			params.set_sk_ltype(skLtype.trim());
		}
		// 小类
		String skStype = params.get_sk_stype();
		if (StringUtils.isNotEmpty(skStype)) {
			params.set_sk_stype(skStype.trim());
		}

		String mobile = params.get_se_mobile();
		if (StringUtils.isNotEmpty(mobile)) {
			params.set_se_mobile(mobile.trim());
		}

		String imei = params.get_se_imei();
		if (StringUtils.isNotEmpty(imei)) {
			params.set_se_imei(imei.trim());
		}

		params.getQueryConditions().put("cityid", user.getCityid());

		try {
			boolean flag = false;
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			Paymentsc paymentsc = (Paymentsc) BOFactory.build(
					PaymentscBO.class, user);
			DataPackage dp = paymentsc.doQueryBySql(params, flag);
			setDp(dp);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		if (isSumQuery) {
			params.setSelectFieldsString("PAYSUM");
			amounts = querySumBySql(user, params);
		}

		return "list";
	}

	public String doNew() throws Exception {
		User user = (User) getDBAccessUser();
		switchflag = checkSwitch(user);

		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};

	/**
	 * 已审核的数据都不能删除
	 */
	public String doDelete() {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Paymentsc paymentsc = null;
		try {
			paymentsc = (Paymentsc) BOFactory.build(PaymentscBO.class,
					getDBAccessUser());
		} catch (Exception e) {
			setErrorLog("错误 \n" + e.getMessage());
			return doList();
		}

		int chkcount = 0;
		StringBuilder checkedStr = new StringBuilder("已审核的数据不能被删除：");

		int successNum = 0;

		for (int i = 0; i < selectArray.length; i++) {
			String param = selectArray[i];
			if (StringUtils.isEmpty(param)) {
				continue;
			}

			String seq = "";
			String checkedflag = "";

			// 在页面需要事先设定查询条件不包含审核标识字段
			if (!param.contains("_")) {
				seq = param;
			} else {
				String[] array = StringUtils.splitPreserveAllTokens(param, "_");
				seq = array[0];
				checkedflag = array[1];
			}

			try {
				if (StringUtils.isEmpty(checkedflag)
						|| checkedflag.equals(NOTCHECKED)) {
					paymentsc.doRemoveByPK(Long.parseLong(seq));
					++successNum;
				} else {
					++chkcount;
					checkedStr.append(seq);
					checkedStr.append(",");
				}

			} catch (SQLException e) {
				setErrorLog("数据库连接错误 \n" + e.getMessage());
			} catch (Exception e) {
				setErrorLog("其他错误 \n" + e.getMessage());
			}
		}

		if (chkcount > 0) {
			String error = checkedStr.substring(0, checkedStr.length() - 1)
					+ "，请联系省公司酬金管理员";
			setErrorLog(error);
		}

		// 设置返回内容
		StringBuffer strb = new StringBuffer();
		strb.append("提交删除总数为 ");
		strb.append(selectArray.length);
		strb.append("；成功删除数为 " + successNum);
		setActionMessage(strb.toString());

		return doList();
	}

	/**
	 * 只能删除未审核状态的数据，不管当前的审核开关 <br/>
	 * 
	 * @param paymentsc
	 * @param params
	 * @throws Exception
	 */
	private int delPaymentsc(Paymentsc paymentsc, PaymentscDBParam params,
			boolean flag, DataPackage dp) throws Exception {
		params.set_pagesize(NG_PAGESIZE);

		int successNum = 0;
		// VPaymentscVO vo = null;
		try {
			List<Map<String, Object>> list = (List<Map<String, Object>>) dp
					.getDatas();
			if (list != null) {
				int size = list.size();
				for (int i = 0; i < size; i++) {
					Map<String, Object> map = list.get(i);
					// vo = (VPaymentscVO) dp.getDatas().get(i);

					// 已审核的不能删除
					// String checkflag = vo.getCheckedflag();
					String checkflag = (String) map.get("checkedflag");
					if ((StringUtils.isEmpty(checkflag) || !checkflag
							.equals(ISCHECKED))) {
						long seq = (Long) map.get("seq");
						paymentsc.doRemoveByPK(seq);
						++successNum;
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

		return successNum;
	}

	/**
	 * 批量删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doBatchDelete() {
		User user = (User) getDBAccessUser();

		Paymentsc paymentsc = null;
		try {
			paymentsc = (Paymentsc) BOFactory.build(PaymentscBO.class, user);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
			return doList();
		}

		PaymentscDBParam params = (PaymentscDBParam) getParam();
		// String stypeName = params.get_sk_stype();
		// String ltypeName = params.get_sk_ltype();

		int successNum = 0;
		// 如果有大类为条件，因为大类对应多个小类，需要查出对应的小类加入条件
		try {
			boolean flag = false;
			switchflag = checkSwitch(user);
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			params.getQueryConditions().put("cityid", user.getCityid());
			params.setSelectFieldsString(delFields);
			params.setDataOnly(true);
			params.set_pagesize(NG_PAGESIZE);

			DataPackage dp = paymentsc.doQueryDelByNamedSql(params, flag);
			if (dp.getDatas().size() > 0) {
				successNum = successNum
						+ delPaymentsc(paymentsc, params, flag, dp);
			}

		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		// 返回页面时记录刚才做删除时的条件
		params.set_pagesize(DEFAULT_PAGESIZE);

		// 设置返回内容
		StringBuffer strb = new StringBuffer();
		strb.append("成功删除 ");
		strb.append(successNum);
		strb.append(" 条数据！");
		setActionMessage(strb.toString());

		return doList();
	}

	private void setQryParams(User user, PaymentscDBParam params) {
		HttpServletRequest req = this.getRequest();

		String wayid = req.getParameter("wayid");
		if (StringUtils.isNotBlank(wayid)) {
			params.set_se_wayid(wayid);
		}

		String calcmonth = req.getParameter("calcmonth");
		if (StringUtils.isNotBlank(calcmonth)) {
			params.set_se_calcmonth(calcmonth);
		}

		String optype = req.getParameter("optype");
		if (StringUtils.isNotBlank(optype)) {
			params.set_se_optype(optype);
		}

		String ltype = req.getParameter("ltype");
		if (StringUtils.isNotBlank(ltype)) {
			params.set_sk_ltype(ltype);
		}

		String stype = req.getParameter("stype");
		if (StringUtils.isNotBlank(stype)) {
			params.set_sk_stype(stype);
		}

		String paymonth = req.getParameter("paymonth");
		if (StringUtils.isNotBlank(paymonth)) {
			params.set_se_paymonth(paymonth);
		}

		String mobile = req.getParameter("mobile");
		if (StringUtils.isNotBlank(mobile)) {
			params.set_se_mobile(mobile);
		}

		String imei = req.getParameter("imei");
		if (StringUtils.isNotBlank(imei)) {
			params.set_se_imei(imei);
		}

		params.getQueryConditions().put("cityid", user.getCityid());
	}

	public void doBatchDelQry() {
		User user = (User) getDBAccessUser();

		PaymentscDBParam params = new PaymentscDBParam();
		setQryParams(user, params);

		Paymentsc paymentsc = null;

		try {
			boolean flag = false;
			switchflag = checkSwitch(user);
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			params.getQueryConditions().put("cityid", user.getCityid());
			params.setCountOnly(true);
			params.set_pagesize(NG_PAGESIZE);
			params.setSelectFieldsString(delFields);

			paymentsc = (Paymentsc) BOFactory.build(PaymentscBO.class, user);
			String counts = paymentsc.doDelCountByNamedSql(params, flag);

			Map<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("counts", counts);
			JSONArray jsonarray = JSONArray.fromObject(hashmap);
			ajaxUpdate(this.getResponse(), jsonarray);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
	}

	/**
	 * 获取该地市所有的渠道编码 <br />
	 * “业务类型”属于个人业务、数据业务、税金业务中的一种，需要稽核“渠道编码”是否存在渠道表CH_PW_WAY中
	 * 
	 * @return
	 */
	public int checkExistWayid(User user, String wayid) throws Exception {
		int rowCount = 0;
		try {
			Way payee = (Way) BOFactory.build(WayBO.class, user);
			WayVO vo = payee.doFindByPk(wayid);
			if (vo != null) {
				rowCount = 1;
			}
		} catch (Exception e) {
			String msg = "在渠道编码表中检查当前渠道编码是否归属该地市时出错！";
			log.error(msg);
			throw new Exception(msg);
		}

		return rowCount;
	}

	public String doSave() {
		User user = (User) getDBAccessUser();

		PaymentscForm paymentscForm = (PaymentscForm) getForm();
		try {
			Paymentsc paymentsc = (Paymentsc) BOFactory.build(
					PaymentscBO.class, user);

			// 判断组合唯一性
			PaymentscDBParam params = new PaymentscDBParam();
			// 渠道编码
			String wayId = paymentscForm.getWayid();
			params.set_se_wayid(wayId);
			// 结算月份（出账月份）
			String calcMonth = paymentscForm.getCalcmonth();
			boolean flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				setErrorLog("该结算月份（出账月份）【" + calcMonth + "】格式不对,应为yyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			params.set_se_calcmonth(calcMonth);
			// 业务月份（办理月份）
			String payMonth = paymentscForm.getPaymonth();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				setErrorLog("该业务月份（办理月份）【" + payMonth + "】格式不对,应为yyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			params.set_se_paymonth(payMonth);
			// 业务类型
			String optype = paymentscForm.getOptype();
			params.set_se_optype(optype);
			// 酬金大类
			String ltypeName = paymentscForm.getLtype();
			params.set_se_ltype(ltypeName);
			// 酬金小类
			String stypeName = paymentscForm.getStype();
			params.set_se_stype(stypeName);
			// 结算期数（第*期）
			String settleperiods = paymentscForm.getSettleperiods();
			params.set_se_settleperiods(settleperiods);

			String mobile = paymentscForm.getMobile();
			if (StringUtils.isNotBlank(mobile)) {
				params.set_se_mobile(mobile);
			}
			String imei = paymentscForm.getImei();
			if (StringUtils.isNotBlank(imei)) {
				params.set_se_imei(imei);
			}
			double paysum = paymentscForm.getPaysum();
			flag = CheckUtil.checkDouble(String.valueOf(paysum), 14, 4);
			if (!flag) {
				setErrorLog("酬金金额 （出账金额）【 " + paysum
						+ "】格式出错，必须为数字、小数位不超过4位、总长度不超过 18位");
				this.CMD = WEB_CMD_EDIT;
				return "content";
			}
			params.set_se_paysum(String.valueOf(paysum));

			if (!CMD.equals(WEB_CMD_EDIT)) {
				DataPackage dp = paymentsc.doQuery(params);
				if (dp.getRowCount() > 0) {
					PaymentscVO vo = (PaymentscVO) dp.getDatas().get(0);
					setErrorLog("该记录【" + vo.getSeq() + "】已存在");
					this.CMD = WEB_CMD_EDIT;
					return "content";
				}
			}

			// 判断“业务类型”属于个人业务、数据业务、税金业务中的一种，需要稽核渠道编码
			if (optype.equals("个人业务") || optype.equals("数据业务")
					|| optype.equals("税金业务")) {
				int rowCount = checkExistWayid(user, wayId);
				if (rowCount <= 0) {
					StringBuilder strb = new StringBuilder();
					strb.append("业务类型为");
					strb.append(optype);
					strb.append("时，渠道编码须是BOSS渠道编码，请检查渠道编码是否正确：");
					strb.append(wayId);

					setErrorLog(strb.toString());
					this.CMD = getCMD();
					return "content";
				}
			}

			if (CMD.equals(WEB_CMD_NEW)) {
				// 新增时设置默认的审核标识为未审核
				paymentscForm.setCheckedflag(NOTCHECKED);
				// 新增时设置默认的登录工号为上传工号
				paymentscForm.setUpoprcode(user.getOprcode());

				PaymentscVO paymentscVO = new PaymentscVO();
				BeanUtils.copyProperties(paymentscVO, paymentscForm);
				paymentscVO.setCheckedflag(NOTCHECKED);
				paymentscVO = paymentsc.doCreate(paymentscVO);
				BeanUtils.copyProperties(getForm(), paymentscVO);
			} else if (CMD.equals(WEB_CMD_EDIT)) {
				// 对页面上传入是中文时做转义
				String checkedflag = paymentscForm.getCheckedflag();
				if (checkedflag.equals("已审核")) {
					checkedflag = ISCHECKED;
					paymentscForm.setCheckedflag(checkedflag);
				} else if (checkedflag.equals("未审核")) {
					checkedflag = NOTCHECKED;
					paymentscForm.setCheckedflag(checkedflag);
				}

				// 判断是否为已审核数据，已审核则不允许修改
				if (checkedflag.equals(ISCHECKED)) {
					setActionMessage("操作失败，审核通过的数据不能修改!");
					this.CMD = WEB_CMD_SAVE;
					return "content";
				}

				if (StringUtils.isEmpty(paymentscForm.getUpoprcode())) {
					paymentscForm.setUpoprcode(user.getOprcode());
				}

				PaymentscVO vo = paymentsc.doFindByPk(paymentscForm.getSeq());
				BeanUtils.copyProperties(vo, paymentscForm);
				vo = paymentsc.doUpdate(vo);
				BeanUtils.copyProperties(getForm(), vo);
			}
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}

	public String doExportExcel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("出账数据（市场部）上传");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });

		// 渠道编码、结算月份（出账月份） calcmonth、业务月份（办理月份）paymonth、业务类型 otype、
		// 酬金大类 ltype、酬金小类 stype、手机号码 mobile、IMEI号imei、
		// 酬金金额（出账金额）paysum、结算期数（第*期）settleperiods

		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("calcmonth", "结算月份（出账月份）");
		export.addOutputProperty("paymonth", "业务月份（办理月份）");
		export.addOutputProperty("optype", "业务类型");
		export.addOutputProperty("ltype", "酬金大类");
		export.addOutputProperty("stype", "酬金小类");
		export.addOutputProperty("mobile", "手机号码");
		export.addOutputProperty("imei", "IMEI号");
		export.addOutputProperty("paysum", "酬金金额（出账金额）");
		export.addOutputProperty("settleperiods", "结算期数（第*期）");
		export.addOutputProperty("note", "备注");

		// 设置VO类
		export.voClassArray = new Class[] { VPaymentscVO.class };

		isSumQuery = false;

		// 设置查询方法
		export.queryMethodName = "doList";
		PaymentscDBParam params = (PaymentscDBParam) getParam();

		params.set_pagesize(NG_PAGESIZE);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);

		try {
			super.doExcel();
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		isSumQuery = true;

		return null;
	}

}