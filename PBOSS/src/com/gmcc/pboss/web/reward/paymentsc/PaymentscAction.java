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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
	 * ����˵����ݶ�����ɾ��
	 */
	public String doDelete() {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Paymentsc paymentsc = null;
		try {
			paymentsc = (Paymentsc) BOFactory.build(PaymentscBO.class,
					getDBAccessUser());
		} catch (Exception e) {
			setErrorLog("���� \n" + e.getMessage());
			return doList();
		}

		int chkcount = 0;
		StringBuilder checkedStr = new StringBuilder("����˵����ݲ��ܱ�ɾ����");

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
				setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			} catch (Exception e) {
				setErrorLog("�������� \n" + e.getMessage());
			}
		}

		if (chkcount > 0) {
			String error = checkedStr.substring(0, checkedStr.length() - 1)
					+ "������ϵʡ��˾������Ա";
			setErrorLog(error);
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
	 * ֻ��ɾ��δ���״̬�����ݣ����ܵ�ǰ����˿��� <br/>
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

					// ����˵Ĳ���ɾ��
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
	 * ����ɾ��
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
			return doList();
		}

		PaymentscDBParam params = (PaymentscDBParam) getParam();
		// String stypeName = params.get_sk_stype();
		// String ltypeName = params.get_sk_ltype();

		int successNum = 0;
		// ����д���Ϊ��������Ϊ�����Ӧ���С�࣬��Ҫ�����Ӧ��С���������
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
	}

	/**
	 * ��ȡ�õ������е��������� <br />
	 * ��ҵ�����͡����ڸ���ҵ������ҵ��˰��ҵ���е�һ�֣���Ҫ���ˡ��������롱�Ƿ����������CH_PW_WAY��
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
			String msg = "������������м�鵱ǰ���������Ƿ�����õ���ʱ����";
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

			// �ж����Ψһ��
			PaymentscDBParam params = new PaymentscDBParam();
			// ��������
			String wayId = paymentscForm.getWayid();
			params.set_se_wayid(wayId);
			// �����·ݣ������·ݣ�
			String calcMonth = paymentscForm.getCalcmonth();
			boolean flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				setErrorLog("�ý����·ݣ������·ݣ���" + calcMonth + "����ʽ����,ӦΪyyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			params.set_se_calcmonth(calcMonth);
			// ҵ���·ݣ������·ݣ�
			String payMonth = paymentscForm.getPaymonth();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				setErrorLog("��ҵ���·ݣ������·ݣ���" + payMonth + "����ʽ����,ӦΪyyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			params.set_se_paymonth(payMonth);
			// ҵ������
			String optype = paymentscForm.getOptype();
			params.set_se_optype(optype);
			// ������
			String ltypeName = paymentscForm.getLtype();
			params.set_se_ltype(ltypeName);
			// ���С��
			String stypeName = paymentscForm.getStype();
			params.set_se_stype(stypeName);
			// ������������*�ڣ�
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
				setErrorLog("����� �����˽��� " + paysum
						+ "����ʽ��������Ϊ���֡�С��λ������4λ���ܳ��Ȳ����� 18λ");
				this.CMD = WEB_CMD_EDIT;
				return "content";
			}
			params.set_se_paysum(String.valueOf(paysum));

			if (!CMD.equals(WEB_CMD_EDIT)) {
				DataPackage dp = paymentsc.doQuery(params);
				if (dp.getRowCount() > 0) {
					PaymentscVO vo = (PaymentscVO) dp.getDatas().get(0);
					setErrorLog("�ü�¼��" + vo.getSeq() + "���Ѵ���");
					this.CMD = WEB_CMD_EDIT;
					return "content";
				}
			}

			// �жϡ�ҵ�����͡����ڸ���ҵ������ҵ��˰��ҵ���е�һ�֣���Ҫ������������
			if (optype.equals("����ҵ��") || optype.equals("����ҵ��")
					|| optype.equals("˰��ҵ��")) {
				int rowCount = checkExistWayid(user, wayId);
				if (rowCount <= 0) {
					StringBuilder strb = new StringBuilder();
					strb.append("ҵ������Ϊ");
					strb.append(optype);
					strb.append("ʱ��������������BOSS�������룬�������������Ƿ���ȷ��");
					strb.append(wayId);

					setErrorLog(strb.toString());
					this.CMD = getCMD();
					return "content";
				}
			}

			if (CMD.equals(WEB_CMD_NEW)) {
				// ����ʱ����Ĭ�ϵ���˱�ʶΪδ���
				paymentscForm.setCheckedflag(NOTCHECKED);
				// ����ʱ����Ĭ�ϵĵ�¼����Ϊ�ϴ�����
				paymentscForm.setUpoprcode(user.getOprcode());

				PaymentscVO paymentscVO = new PaymentscVO();
				BeanUtils.copyProperties(paymentscVO, paymentscForm);
				paymentscVO.setCheckedflag(NOTCHECKED);
				paymentscVO = paymentsc.doCreate(paymentscVO);
				BeanUtils.copyProperties(getForm(), paymentscVO);
			} else if (CMD.equals(WEB_CMD_EDIT)) {
				// ��ҳ���ϴ���������ʱ��ת��
				String checkedflag = paymentscForm.getCheckedflag();
				if (checkedflag.equals("�����")) {
					checkedflag = ISCHECKED;
					paymentscForm.setCheckedflag(checkedflag);
				} else if (checkedflag.equals("δ���")) {
					checkedflag = NOTCHECKED;
					paymentscForm.setCheckedflag(checkedflag);
				}

				// �ж��Ƿ�Ϊ��������ݣ�������������޸�
				if (checkedflag.equals(ISCHECKED)) {
					setActionMessage("����ʧ�ܣ����ͨ�������ݲ����޸�!");
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
		export.setFileName("�������ݣ��г������ϴ�");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });

		// �������롢�����·ݣ������·ݣ� calcmonth��ҵ���·ݣ������·ݣ�paymonth��ҵ������ otype��
		// ������ ltype�����С�� stype���ֻ����� mobile��IMEI��imei��
		// �������˽�paysum��������������*�ڣ�settleperiods

		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("calcmonth", "�����·ݣ������·ݣ�");
		export.addOutputProperty("paymonth", "ҵ���·ݣ������·ݣ�");
		export.addOutputProperty("optype", "ҵ������");
		export.addOutputProperty("ltype", "������");
		export.addOutputProperty("stype", "���С��");
		export.addOutputProperty("mobile", "�ֻ�����");
		export.addOutputProperty("imei", "IMEI��");
		export.addOutputProperty("paysum", "�������˽�");
		export.addOutputProperty("settleperiods", "������������*�ڣ�");
		export.addOutputProperty("note", "��ע");

		// ����VO��
		export.voClassArray = new Class[] { VPaymentscVO.class };

		isSumQuery = false;

		// ���ò�ѯ����
		export.queryMethodName = "doList";
		PaymentscDBParam params = (PaymentscDBParam) getParam();

		params.set_pagesize(NG_PAGESIZE);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);

		try {
			super.doExcel();
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}

		isSumQuery = true;

		return null;
	}

}