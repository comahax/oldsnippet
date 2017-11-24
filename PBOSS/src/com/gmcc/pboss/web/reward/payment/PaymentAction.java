package com.gmcc.pboss.web.reward.payment;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendDBParam;
import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.payment.PaymentVO;
import com.gmcc.pboss.business.reward.payment.VPaymentVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.base.config.Config;
import com.gmcc.pboss.control.base.config.ConfigBO;
import com.gmcc.pboss.control.reward.chcwpaymentsend.ChCwPaymentsend;
import com.gmcc.pboss.control.reward.chcwpaymentsend.ChCwPaymentsendBO;
import com.gmcc.pboss.control.reward.payment.Payment;
import com.gmcc.pboss.control.reward.payment.PaymentBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: PaymentAction
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
public class PaymentAction extends BaseAction {

	private static final long serialVersionUID = -6818370517519651343L;

	private final Logger log = LoggerFactory.getLogger(PaymentAction.class);

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

	// 已发送状态
	private final String ISSENT = "SENT";

	private String switchflag = SWITCH_CLOSE;

	private String selFields = "seq,optype,ltype,stype,payee,bkactname,bank,depositbank,account,billnumber,countyid,paymonth,paysum,batch,pubpri,note,upoprcode,checkedflag,calcmonth,sendstate";

	private String delFields = "seq,checkedflag,sendstate";

	private String amounts;

	private boolean isSumQuery = true;

	private boolean isExportExcel = false;

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

	public PaymentAction() {
		super();

		this.setForm(new PaymentForm());
		this.setParam(new PaymentDBParam());

		setClsVO(PaymentVO.class);
		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Payment.class);
		this.setClsQueryParam(PaymentDBParam.class);
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

	private String querySumBySql(User user, PaymentDBParam params) {
		String amounts = "-1.0";

		boolean flag = false;
		switchflag = checkSwitch(user);
		if (switchflag.equals(SWITCH_OPEN)) {
			flag = true;
		}

		Payment payment = null;
		try {
			payment = (Payment) BOFactory.build(PaymentBO.class, user);
			amounts = payment.doQuerySumByNamedSql(params, flag);
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

		PaymentDBParam params = (PaymentDBParam) getParam();

		// 清除查询条件收款单位的空格
		String skPayee = params.get_sk_payee();
		if (StringUtils.isNotEmpty(skPayee)) {
			params.set_sk_payee(skPayee.trim());
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

		// 清空删除时才用到的员工身份标识号码字段
		String employeeNum = params.get_se_employeeNum();
		if (StringUtils.isNotEmpty(employeeNum)) {
			params.set_se_employeeNum(null);
		}

		params.getQueryConditions().put("cityid", user.getCityid());

		try {
			boolean flag = false;
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			Payment payment = (Payment) BOFactory.build(PaymentBO.class, user);
			DataPackage dp = null;

			if (isExportExcel) {
				dp = payment.doExportBySql(params, flag);
			} else {
				params.setSelectFieldsString(selFields);
				dp = payment.doQueryBySql(params, flag);
			}

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
	 * 已发送或已审核的数据都不能删除
	 */
	public String doDelete() {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Payment payment = null;
		try {
			payment = (Payment) BOFactory.build(PaymentBO.class,
					getDBAccessUser());
		} catch (Exception e) {
			setErrorLog("错误 \n" + e.getMessage());
			return doList();
		}

		int chkcount = 0;
		int sendcount = 0;
		StringBuilder checkedStr = new StringBuilder("已审核的数据不能被删除：");
		StringBuilder sentStr = new StringBuilder("已发送的数据不能被删除：");

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
				PaymentVO vo = payment.doFindByPk(Long.parseLong(seq));
				String sendstate = vo.getSendstate();
				if (StringUtils.isNotEmpty(sendstate)
						&& sendstate.equalsIgnoreCase(ISSENT)) {
					// 该记录已发送，不可重复发送
					++sendcount;
					sentStr.append(seq);
					sentStr.append(",");
					continue;
				}

				if (StringUtils.isEmpty(checkedflag)
						|| checkedflag.equals(NOTCHECKED)) {
					payment.doRemoveByPK(Long.parseLong(seq));
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

		if (sendcount > 0) {
			String error = sentStr.substring(0, sentStr.length() - 1);
			if (chkcount > 0) {
				error = error + ";"
						+ checkedStr.substring(0, checkedStr.length() - 1);
			}
			setErrorLog(error + "，请联系省公司酬金管理员");
		} else {
			if (chkcount > 0) {
				String error = checkedStr.substring(0, checkedStr.length() - 1)
						+ "，请联系省公司酬金管理员";
				setErrorLog(error);
			}
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
	 * 只能删除未审核状态、未发送的数据，不管当前的审核开关 <br/>
	 * 已审核或已发送的均不能删除
	 * 
	 * @param payment
	 * @param params
	 * @throws Exception
	 */
	private int delPayment(Payment payment, PaymentDBParam params, boolean flag)
			throws Exception {
		params.set_pagesize(NG_PAGESIZE);
		// 清空删除时才用到的员工身份标识号码字段
		String employeeNum = params.get_se_employeeNum();
		if (StringUtils.isNotEmpty(employeeNum)) {
			params.set_se_employeeNum(null);
		}

		int successNum = 0;
		try {
			DataPackage dp = payment.doQueryDelByNamedSql(params, flag);
			List<Map<String, Object>> list = (List<Map<String, Object>>) dp
					.getDatas();
			if (list != null) {
				int size = list.size();
				for (int i = 0; i < size; i++) {
					Map<String, Object> map = list.get(i);

					// 已审核或已发送的均不能删除
					String checkflag = (String) map.get("checkedflag");
					String sendstate = (String) map.get("sendstate");

					if ((StringUtils.isEmpty(checkflag) || checkflag
							.equals(NOTCHECKED))
							&& (StringUtils.isEmpty(sendstate) || !sendstate
									.equalsIgnoreCase(ISSENT))) {
						long seq = (Long) map.get("seq");
						payment.doRemoveByPK(seq);
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
	 * 根据大类查询结果 只能删除未审核状态、未发送的数据，不管当前的审核开关 <br/>
	 * 已审核或已发送的均不能删除
	 * 
	 * @param payment
	 * @param params
	 * @throws Exception
	 */
	private int delPaymentInResult(Payment payment, PaymentDBParam params,
			boolean flag, DataPackage dp) throws Exception {
		// 清空发送时才用到的员工身份标识号码字段
		String employeeNum = params.get_se_employeeNum();
		if (StringUtils.isNotEmpty(employeeNum)) {
			params.set_se_employeeNum(null);
		}

		int successNum = 0;
		try {
			List<Map<String, Object>> list = (List<Map<String, Object>>) dp
					.getDatas();
			if (list != null) {
				int size = list.size();
				for (int i = 0; i < size; i++) {
					Map<String, Object> map = list.get(i);

					// 已审核或已发送的均不能删除
					String checkflag = (String) map.get("checkedflag");
					String sendstate = (String) map.get("sendstate");

					if ((StringUtils.isEmpty(checkflag) || !checkflag
							.equals(ISCHECKED))
							&& (StringUtils.isEmpty(sendstate) || !sendstate
									.equalsIgnoreCase(ISSENT))) {
						long seq = (Long) map.get("seq");
						payment.doRemoveByPK(seq);
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

		Payment payment = null;
		try {
			payment = (Payment) BOFactory.build(PaymentBO.class, user);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
			return doList();
		}

		PaymentDBParam params = (PaymentDBParam) getParam();

		// 清空发送时才用到的员工身份标识号码字段
		String employeeNum = params.get_se_employeeNum();
		if (StringUtils.isNotEmpty(employeeNum)) {
			params.set_se_employeeNum(null);
		}

		String stypeName = params.get_sk_stype();
		String ltypeName = params.get_sk_ltype();

		int successNum = 0;
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

			// 如果大类非空且小类为空，则查大类关联的所有小类，并以小类为条件做删除
			if (StringUtils.isNotEmpty(ltypeName)
					&& StringUtils.isEmpty(stypeName)) {
				// 直接查大类
				DataPackage dp = payment.doQueryDelByNamedSqlFromLtyle(params,
						flag);
				if (dp.getDatas().size() > 0) {
					successNum = successNum
							+ delPaymentInResult(payment, params, flag, dp);
				}

				// 查大类关联的所有小类，并以小类为条件做删除
				Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
				StypeDBParam stypeDbParam = new StypeDBParam();
				stypeDbParam.set_sk_ltype(ltypeName);

				List list = new ArrayList();
				list.add(user.getCityid());
				list.add("GD");
				stypeDbParam.set_sin_cityid(list);
				stypeDbParam.set_pagesize(NG_PAGESIZE);
				stypeDbParam.set_orderby("seq");
				stypeDbParam.setDataOnly(true);

				DataPackage stypeDp = stype.doQuery(stypeDbParam);
				int rowCount = stypeDp.getDatas().size();

				while (rowCount > 0) {
					StypeVO stypeVO = (StypeVO) stypeDp.getDatas().get(
							rowCount - 1);
					stypeName = stypeVO.getStype();
					rowCount--;

					// 设置小类条件
					params.set_sk_stype(stypeName);
					params.set_sk_ltype(null);

					DataPackage stypeDpResult = payment
							.doQueryDelByNamedSqlFromStyle(params, flag);
					// 根据小类逐个删除
					successNum = successNum
							+ delPaymentInResult(payment, params, flag,
									stypeDpResult);
				}

			} else {
				// 大类为空或小类非空，直接根据条件删除
				successNum = successNum + delPayment(payment, params, flag);
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

	private void setQryParams(User user, PaymentDBParam params) {
		HttpServletRequest req = this.getRequest();

		String optype = req.getParameter("optype");
		if (StringUtils.isNotBlank(optype)) {
			params.set_se_optype(optype);
		}

		String payee = req.getParameter("payee");
		if (StringUtils.isNotBlank(payee)) {
			params.set_sk_payee(payee);
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

		String checkedflag = req.getParameter("checkedflag");
		if (StringUtils.isNotBlank(checkedflag)) {
			params.set_se_checkedflag(checkedflag);
		}

		String upoprcode = req.getParameter("upoprcode");
		if (StringUtils.isNotBlank(upoprcode)) {
			params.set_se_upoprcode(upoprcode);
		}

		String calcmonth = req.getParameter("calcmonth");
		if (StringUtils.isNotBlank(calcmonth)) {
			params.set_se_calcmonth(calcmonth);
		}

		params.getQueryConditions().put("cityid", user.getCityid());
	}

	public void doBatchDelQry() {
		User user = (User) getDBAccessUser();

		PaymentDBParam params = new PaymentDBParam();
		setQryParams(user, params);

		Payment payment = null;

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

			payment = (Payment) BOFactory.build(PaymentBO.class, user);
			String counts = payment.doDelCountByNamedSql(params, flag);

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

	private String getLtypeByStype(String stypeName) {
		String ltype = null;
		StypeDBParam stypeparams = new StypeDBParam();
		stypeparams.set_se_stype(stypeName);
		stypeparams.setDataOnly(true);
		try {
			Stype stype = (Stype) BOFactory.build(StypeBO.class,
					getDBAccessUser());
			DataPackage stypedp = stype.doQuery(stypeparams);
			List list = stypedp.getDatas();
			if (list != null && list.size() > 0) {
				ltype = ((StypeVO) list.get(0)).getLtype();
			}

		} catch (Exception e) {
			log.error("通过小类名称查询大类名称错误 \n" + e.getMessage());
		}

		return ltype;
	}

	public String doEdit() throws Exception {
		PaymentVO vo = (PaymentVO) findVOFromDB();
		if (StringUtils.isBlank(vo.getLtype())) {
			String ltype = getLtypeByStype(vo.getStype());
			if (StringUtils.isNotEmpty(ltype)) {
				vo.setLtype(ltype);
			}
		}

		BaseVO form = getForm();
		BeanUtils.copyProperties(form, vo);
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	};

	public String doSave() {
		User user = (User) getDBAccessUser();

		PaymentForm paymentForm = (PaymentForm) getForm();
		try {
			Payment payment = (Payment) BOFactory.build(PaymentBO.class, user);

			String payMonth = paymentForm.getPaymonth();
			boolean flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				setErrorLog("该付款月份【" + payMonth + "】格式不对,应为yyyyMM");
				this.CMD = getCMD();
				return "content";
			}

			if (!CMD.equals(WEB_CMD_EDIT)) {
				// 判断业务类型、付款月、收款单位、小类名称（可为空）、批次（可为空）、结算月份（可为空）, 分公司, 金额的组合唯一性
				PaymentDBParam params = new PaymentDBParam();

				params.set_se_optype(paymentForm.getOptype());
				params.set_se_paymonth(payMonth);
				params.set_se_payee(paymentForm.getPayee());

				String stypeName = paymentForm.getStype();
				if (StringUtils.isNotBlank(stypeName)) {
					params.set_se_stype(stypeName);
				}

				String batch = paymentForm.getBatch();
				if (StringUtils.isNotBlank(batch)) {
					params.set_se_batch(batch);
				}

				String calcMonth = paymentForm.getCalcmonth();
				if (StringUtils.isNotBlank(calcMonth)) {
					params.set_se_calcmonth(calcMonth);
				}

				String countryId = paymentForm.getCountyid();
				if (StringUtils.isNotBlank(countryId)) {
					params.set_se_countyid(countryId);
				}

				Double paysum = paymentForm.getPaysum();
				if (paysum != null) {
					params.set_ne_paysum(paysum + "");
				}

				DataPackage dp = payment.doQuery(params);
				if (dp.getDatas() != null && dp.getDatas().size() > 0) {
					PaymentVO vo = (PaymentVO) dp.getDatas().get(0);
					setErrorLog("该记录【" + vo.getSeq() + "】已存在");
					this.CMD = WEB_CMD_EDIT;
					return "content";
				}
			}

			if (CMD.equals(WEB_CMD_NEW)) {
				// 新增时设置默认的审核标识为未审核
				paymentForm.setCheckedflag(NOTCHECKED);
				// 新增时设置默认的登录工号为上传工号
				paymentForm.setUpoprcode(user.getOprcode());

				PaymentVO paymentVO = new PaymentVO();
				BeanUtils.copyProperties(paymentVO, paymentForm);
				paymentVO.setCheckedflag(NOTCHECKED);
				paymentVO = payment.doCreate(paymentVO);
				BeanUtils.copyProperties(getForm(), paymentVO);

			} else if (CMD.equals(WEB_CMD_EDIT)) {
				// 对页面上传入是中文时做转义
				String checkedflag = paymentForm.getCheckedflag();
				if (checkedflag.equals("已审核")) {
					checkedflag = ISCHECKED;
					paymentForm.setCheckedflag(checkedflag);
				} else if (checkedflag.equals("未审核")) {
					checkedflag = NOTCHECKED;
					paymentForm.setCheckedflag(checkedflag);
				}

				// 判断是否为已审核数据，已审核则不允许修改
				if (checkedflag.equals(ISCHECKED)) {
					setActionMessage("操作失败，审核通过的数据不能修改!");
					this.CMD = WEB_CMD_SAVE;
					return "content";
				}

				if (StringUtils.isEmpty(paymentForm.getUpoprcode())) {
					paymentForm.setUpoprcode(user.getOprcode());
				}

				PaymentVO vo = payment.doFindByPk(paymentForm.getSeq());
				BeanUtils.copyProperties(vo, paymentForm);
				vo = payment.doUpdate(vo);
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
		export.setFileName("付款数据上传（财务部）");

		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("optype", "业务类型");
		export.addOutputProperty("ltype", "酬金大类");
		export.addOutputProperty("stype", "酬金小类");
		export.addOutputProperty("payee", "收款单位名称");
		export.addOutputProperty("bkactname", "银行账户名称");
		export.addOutputProperty("bank", "银行名称");
		export.addOutputProperty("depositbank", "开户行（XX支行）");
		export.addOutputProperty("account", "银行账号");
		export.addOutputProperty("billnumber", "对应报账单号");
		export.addOutputProperty("countyid", "分公司");

		export.addOutputProperty("paymonth", "付款月份");
		export.addOutputProperty("paysum", "实发金额");
		export.addOutputProperty("batch", "批次");
		export.addOutputProperty("pubpri", "对公/对私");
		export.addOutputProperty("note", "备注");
		export.addOutputProperty("calcmonth", "结算（出账）月份");

		// 设置VO类
		export.voClassArray = new Class[] { VPaymentVO.class };

		isSumQuery = false;
		isExportExcel = true;

		// 设置查询方法
		export.queryMethodName = "doList";
		PaymentDBParam params = (PaymentDBParam) getParam();
		// 清空删除时才用到的员工身份标识号码字段
		String employeeNum = params.get_se_employeeNum();
		if (StringUtils.isNotEmpty(employeeNum)) {
			params.set_se_employeeNum(null);
		}

		params.setQueryAll(true);
		// params.set_pagesize(NG_PAGESIZE);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);

		try {
			super.doExcel();
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		isSumQuery = true;
		isExportExcel = false;

		return null;
	}

	/**
	 * 设置发送的批次号
	 * 
	 * @param user
	 * @return
	 */
	private String getLastSbatch(User user) throws Exception {
		String lastSbatch = "";
		ChCwPaymentsendDBParam params = new ChCwPaymentsendDBParam();
		params.set_orderby("sbatch");
		params.set_desc("1");
		params.setSelectFieldsString("sbatch");
		params.set_pagesize(NG_PAGESIZE);

		// 查询结果类型： 0 全部, 10 总数, 20数据
		int QUERY_TYPE = 20;
		ChCwPaymentsend send = (ChCwPaymentsend) BOFactory.build(
				ChCwPaymentsendBO.class, user);
		DataPackage dp = send.doQuerySbatchBySql(params, QUERY_TYPE);
		List<String> sbatchList = (List<String>) dp.getDatas();
		if (sbatchList != null && sbatchList.size() > 0) {
			for (int i = 0; i < sbatchList.size(); i++) {
				lastSbatch = sbatchList.get(i);
				// 取得第一个符合14位格式(年月8位+6位序列号)
				if (lastSbatch.length() == 14) {
					break;
				}
			}
		}

		return lastSbatch;
	}

	/**
	 * 发送批次SBATCH，入库格式“日期+六位序列”，例如“20150901000001”（每个批次的须保持一致，且不同批次须递增）
	 * 
	 * @param lastSbatch
	 * @return
	 */
	private String setNewSbatch(String lastSbatch) {
		String newSbatch = "";
		String sbatchSeq = "000001";
		String curYmd = DateUtil.getDateYMD();

		if (StringUtils.isEmpty(lastSbatch) || lastSbatch.length() != 14) {
			return curYmd + sbatchSeq;
		}

		String sbatchYmd = lastSbatch.substring(0, 8);
		// 同一天才需要递增
		if (sbatchYmd.equals(curYmd)) {
			sbatchSeq = lastSbatch.substring(8, 14);
			int seq = Integer.parseInt(sbatchSeq);
			++seq;
			sbatchSeq = String.valueOf(seq);
			int len = sbatchSeq.length();

			StringBuffer strb = new StringBuffer();
			strb.append(curYmd);
			for (int i = 0; i < 6 - len; i++) {
				strb.append("0");
			}
			strb.append(sbatchSeq);
			newSbatch = strb.toString();
		} else {// 其他天的序号直接从1开始
			newSbatch = curYmd + sbatchSeq;
		}

		return newSbatch;
	}

	public String doSend() {
		User user = (User) getDBAccessUser();
		PaymentDBParam param = ((PaymentDBParam) getParam());

		// 员工身份标识号码
		String employeeNum = param.get_se_employeeNum();
		if (StringUtils.isEmpty(employeeNum)) {
			setErrorLog("员工身份标识号码不能为空");
			return "list";
		}

		try {
			String lastSbatch = getLastSbatch(user);
			String newSbatch = setNewSbatch(lastSbatch);

			String[] selectArray = param.get_selectitem();

			boolean flag = false;
			switchflag = checkSwitch(user);
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
			}

			Payment payment = (Payment) BOFactory.build(PaymentBO.class, user);
			payment.doSend(selectArray, flag, employeeNum, newSbatch);

			setActionMessage("发送成功!");
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		doList();
		param.set_se_employeeNum(employeeNum);

		return "list";
	}

	public String doBatchsend() {
		User user = (User) getDBAccessUser();
		PaymentDBParam params = (PaymentDBParam) getParam();
		// 员工身份标识号码
		String employeeNum = params.get_se_employeeNum();
		params.set_se_employeeNum(null);

		try {
			String lastSbatch = getLastSbatch(user);
			String newSbatch = setNewSbatch(lastSbatch);

			boolean flag = false;
			switchflag = checkSwitch(user);
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			params.setSelectFieldsString(selFields);
			params.getQueryConditions().put("cityid", user.getCityid());

			// params.setQueryAll(true);
			params.setDataOnly(true);
			params.set_pagesize(NG_PAGESIZE);

			Payment payment = (Payment) BOFactory.build(PaymentBO.class, user);
			payment.doBatchsend(params, flag, employeeNum, newSbatch);

			setActionMessage("批量发送成功!");
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}

		doList();
		params.set_se_employeeNum(employeeNum);

		return "list";
	}

	public void doBatchSendQry() {
		User user = (User) getDBAccessUser();

		PaymentDBParam params = new PaymentDBParam();
		setQryParams(user, params);

		Payment payment = null;
		try {
			payment = (Payment) BOFactory.build(PaymentBO.class, user);

			boolean flag = false;
			switchflag = checkSwitch(user);
			if (switchflag.equals(SWITCH_OPEN)) {
				flag = true;
				params.getQueryConditions().put("oprcode", user.getOprcode());
			}

			params.getQueryConditions().put("cityid", user.getCityid());

			// params.setQueryAll(true);
			params.setCountOnly(true);
			params.set_pagesize(NG_PAGESIZE);
			params.setSelectFieldsString(selFields);

			String counts = payment.doSendCountByNamedSql(params, flag);
			ajaxUpdate(this.getResponse(), counts);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
	}

}