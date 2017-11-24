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

	// ���pagesizeΪ0����ʾ����ҳ��ֻ��1ҳ
	private final static String NG_PAGESIZE = "0";

	// Ĭ�ϵķ�ҳ��С
	private final static String DEFAULT_PAGESIZE = "20";

	// ���У������ֱ�ʶ
	private final static String ISCHECKED = "CHECKED";
	private final static String NOTCHECKED = "UNCHECKED";

	// ���ص����ֱ�ʶ
	private final static String SWITCH_OPEN = "open";
	private final static String SWITCH_CLOSE = "close";

	// �ѷ���״̬
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
	 * �����˿��ص�״̬
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}

		return amounts;
	}

	public String doList() {
		User user = (User) getDBAccessUser();

		switchflag = checkSwitch(user);

		PaymentDBParam params = (PaymentDBParam) getParam();

		// �����ѯ�����տλ�Ŀո�
		String skPayee = params.get_sk_payee();
		if (StringUtils.isNotEmpty(skPayee)) {
			params.set_sk_payee(skPayee.trim());
		}
		// ����
		String skLtype = params.get_sk_ltype();
		if (StringUtils.isNotEmpty(skLtype)) {
			params.set_sk_ltype(skLtype.trim());
		}
		// С��
		String skStype = params.get_sk_stype();
		if (StringUtils.isNotEmpty(skStype)) {
			params.set_sk_stype(skStype.trim());
		}

		// ���ɾ��ʱ���õ���Ա����ݱ�ʶ�����ֶ�
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
	 * �ѷ��ͻ�����˵����ݶ�����ɾ��
	 */
	public String doDelete() {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Payment payment = null;
		try {
			payment = (Payment) BOFactory.build(PaymentBO.class,
					getDBAccessUser());
		} catch (Exception e) {
			setErrorLog("���� \n" + e.getMessage());
			return doList();
		}

		int chkcount = 0;
		int sendcount = 0;
		StringBuilder checkedStr = new StringBuilder("����˵����ݲ��ܱ�ɾ����");
		StringBuilder sentStr = new StringBuilder("�ѷ��͵����ݲ��ܱ�ɾ����");

		int successNum = 0;

		for (int i = 0; i < selectArray.length; i++) {
			String param = selectArray[i];
			if (StringUtils.isEmpty(param)) {
				continue;
			}

			String seq = "";
			String checkedflag = "";

			// ��ҳ����Ҫ�����趨��ѯ������������˱�ʶ�ֶ�
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
					// �ü�¼�ѷ��ͣ������ظ�����
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
				setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			} catch (Exception e) {
				setErrorLog("�������� \n" + e.getMessage());
			}
		}

		if (sendcount > 0) {
			String error = sentStr.substring(0, sentStr.length() - 1);
			if (chkcount > 0) {
				error = error + ";"
						+ checkedStr.substring(0, checkedStr.length() - 1);
			}
			setErrorLog(error + "������ϵʡ��˾������Ա");
		} else {
			if (chkcount > 0) {
				String error = checkedStr.substring(0, checkedStr.length() - 1)
						+ "������ϵʡ��˾������Ա";
				setErrorLog(error);
			}
		}

		// ���÷�������
		StringBuffer strb = new StringBuffer();
		strb.append("�ύɾ������Ϊ ");
		strb.append(selectArray.length);
		strb.append("���ɹ�ɾ����Ϊ " + successNum);
		setActionMessage(strb.toString());

		return doList();
	}

	/**
	 * ֻ��ɾ��δ���״̬��δ���͵����ݣ����ܵ�ǰ����˿��� <br/>
	 * ����˻��ѷ��͵ľ�����ɾ��
	 * 
	 * @param payment
	 * @param params
	 * @throws Exception
	 */
	private int delPayment(Payment payment, PaymentDBParam params, boolean flag)
			throws Exception {
		params.set_pagesize(NG_PAGESIZE);
		// ���ɾ��ʱ���õ���Ա����ݱ�ʶ�����ֶ�
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

					// ����˻��ѷ��͵ľ�����ɾ��
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
	 * ���ݴ����ѯ��� ֻ��ɾ��δ���״̬��δ���͵����ݣ����ܵ�ǰ����˿��� <br/>
	 * ����˻��ѷ��͵ľ�����ɾ��
	 * 
	 * @param payment
	 * @param params
	 * @throws Exception
	 */
	private int delPaymentInResult(Payment payment, PaymentDBParam params,
			boolean flag, DataPackage dp) throws Exception {
		// ��շ���ʱ���õ���Ա����ݱ�ʶ�����ֶ�
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

					// ����˻��ѷ��͵ľ�����ɾ��
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
	 * ����ɾ��
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
			return doList();
		}

		PaymentDBParam params = (PaymentDBParam) getParam();

		// ��շ���ʱ���õ���Ա����ݱ�ʶ�����ֶ�
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

			// �������ǿ���С��Ϊ�գ����������������С�࣬����С��Ϊ������ɾ��
			if (StringUtils.isNotEmpty(ltypeName)
					&& StringUtils.isEmpty(stypeName)) {
				// ֱ�Ӳ����
				DataPackage dp = payment.doQueryDelByNamedSqlFromLtyle(params,
						flag);
				if (dp.getDatas().size() > 0) {
					successNum = successNum
							+ delPaymentInResult(payment, params, flag, dp);
				}

				// ��������������С�࣬����С��Ϊ������ɾ��
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

					// ����С������
					params.set_sk_stype(stypeName);
					params.set_sk_ltype(null);

					DataPackage stypeDpResult = payment
							.doQueryDelByNamedSqlFromStyle(params, flag);
					// ����С�����ɾ��
					successNum = successNum
							+ delPaymentInResult(payment, params, flag,
									stypeDpResult);
				}

			} else {
				// ����Ϊ�ջ�С��ǿգ�ֱ�Ӹ�������ɾ��
				successNum = successNum + delPayment(payment, params, flag);
			}
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}

		// ����ҳ��ʱ��¼�ղ���ɾ��ʱ������
		params.set_pagesize(DEFAULT_PAGESIZE);

		// ���÷�������
		StringBuffer strb = new StringBuffer();
		strb.append("�ɹ�ɾ�� ");
		strb.append(successNum);
		strb.append(" �����ݣ�");
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
			log.error("ͨ��С�����Ʋ�ѯ�������ƴ��� \n" + e.getMessage());
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
				setErrorLog("�ø����·ݡ�" + payMonth + "����ʽ����,ӦΪyyyyMM");
				this.CMD = getCMD();
				return "content";
			}

			if (!CMD.equals(WEB_CMD_EDIT)) {
				// �ж�ҵ�����͡������¡��տλ��С�����ƣ���Ϊ�գ������Σ���Ϊ�գ��������·ݣ���Ϊ�գ�, �ֹ�˾, �������Ψһ��
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
					setErrorLog("�ü�¼��" + vo.getSeq() + "���Ѵ���");
					this.CMD = WEB_CMD_EDIT;
					return "content";
				}
			}

			if (CMD.equals(WEB_CMD_NEW)) {
				// ����ʱ����Ĭ�ϵ���˱�ʶΪδ���
				paymentForm.setCheckedflag(NOTCHECKED);
				// ����ʱ����Ĭ�ϵĵ�¼����Ϊ�ϴ�����
				paymentForm.setUpoprcode(user.getOprcode());

				PaymentVO paymentVO = new PaymentVO();
				BeanUtils.copyProperties(paymentVO, paymentForm);
				paymentVO.setCheckedflag(NOTCHECKED);
				paymentVO = payment.doCreate(paymentVO);
				BeanUtils.copyProperties(getForm(), paymentVO);

			} else if (CMD.equals(WEB_CMD_EDIT)) {
				// ��ҳ���ϴ���������ʱ��ת��
				String checkedflag = paymentForm.getCheckedflag();
				if (checkedflag.equals("�����")) {
					checkedflag = ISCHECKED;
					paymentForm.setCheckedflag(checkedflag);
				} else if (checkedflag.equals("δ���")) {
					checkedflag = NOTCHECKED;
					paymentForm.setCheckedflag(checkedflag);
				}

				// �ж��Ƿ�Ϊ��������ݣ�������������޸�
				if (checkedflag.equals(ISCHECKED)) {
					setActionMessage("����ʧ�ܣ����ͨ�������ݲ����޸�!");
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}

		this.CMD = WEB_CMD_SAVE;
		setActionMessage("�����ɹ�!");
		return "content";
	}

	public String doExportExcel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("���������ϴ������񲿣�");

		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("optype", "ҵ������");
		export.addOutputProperty("ltype", "������");
		export.addOutputProperty("stype", "���С��");
		export.addOutputProperty("payee", "�տλ����");
		export.addOutputProperty("bkactname", "�����˻�����");
		export.addOutputProperty("bank", "��������");
		export.addOutputProperty("depositbank", "�����У�XX֧�У�");
		export.addOutputProperty("account", "�����˺�");
		export.addOutputProperty("billnumber", "��Ӧ���˵���");
		export.addOutputProperty("countyid", "�ֹ�˾");

		export.addOutputProperty("paymonth", "�����·�");
		export.addOutputProperty("paysum", "ʵ�����");
		export.addOutputProperty("batch", "����");
		export.addOutputProperty("pubpri", "�Թ�/��˽");
		export.addOutputProperty("note", "��ע");
		export.addOutputProperty("calcmonth", "���㣨���ˣ��·�");

		// ����VO��
		export.voClassArray = new Class[] { VPaymentVO.class };

		isSumQuery = false;
		isExportExcel = true;

		// ���ò�ѯ����
		export.queryMethodName = "doList";
		PaymentDBParam params = (PaymentDBParam) getParam();
		// ���ɾ��ʱ���õ���Ա����ݱ�ʶ�����ֶ�
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
			setErrorLog("�������� \n" + e.getMessage());
		}

		isSumQuery = true;
		isExportExcel = false;

		return null;
	}

	/**
	 * ���÷��͵����κ�
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

		// ��ѯ������ͣ� 0 ȫ��, 10 ����, 20����
		int QUERY_TYPE = 20;
		ChCwPaymentsend send = (ChCwPaymentsend) BOFactory.build(
				ChCwPaymentsendBO.class, user);
		DataPackage dp = send.doQuerySbatchBySql(params, QUERY_TYPE);
		List<String> sbatchList = (List<String>) dp.getDatas();
		if (sbatchList != null && sbatchList.size() > 0) {
			for (int i = 0; i < sbatchList.size(); i++) {
				lastSbatch = sbatchList.get(i);
				// ȡ�õ�һ������14λ��ʽ(����8λ+6λ���к�)
				if (lastSbatch.length() == 14) {
					break;
				}
			}
		}

		return lastSbatch;
	}

	/**
	 * ��������SBATCH������ʽ������+��λ���С������硰20150901000001����ÿ�����ε��뱣��һ�£��Ҳ�ͬ�����������
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
		// ͬһ�����Ҫ����
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
		} else {// ����������ֱ�Ӵ�1��ʼ
			newSbatch = curYmd + sbatchSeq;
		}

		return newSbatch;
	}

	public String doSend() {
		User user = (User) getDBAccessUser();
		PaymentDBParam param = ((PaymentDBParam) getParam());

		// Ա����ݱ�ʶ����
		String employeeNum = param.get_se_employeeNum();
		if (StringUtils.isEmpty(employeeNum)) {
			setErrorLog("Ա����ݱ�ʶ���벻��Ϊ��");
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

			setActionMessage("���ͳɹ�!");
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}

		doList();
		param.set_se_employeeNum(employeeNum);

		return "list";
	}

	public String doBatchsend() {
		User user = (User) getDBAccessUser();
		PaymentDBParam params = (PaymentDBParam) getParam();
		// Ա����ݱ�ʶ����
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

			setActionMessage("�������ͳɹ�!");
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
	}

}