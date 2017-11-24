package com.gmcc.pboss.biz.info.reward.payment.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.common.util.arithmetic.BigDecimalConverter;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwPayment;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentConfigService;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentManageService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentManageQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.util.CityId;
import com.gmcc.pboss.biz.info.reward.payment.util.Optype;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

/**
 * <p>
 * Title: PaymentManageAction
 * </p>
 * <p>
 * Description:���ҵĳ��-�����һ�廯��-�����һ�廯����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class PaymentManageAction extends AbstractAction {

	// 21�����У������ѡ������ѯ���е���
	private String cityid;
	private String optype;
	private String pubpri;
	private String checkedflag;
	private String payee;
	private String wayid;
	private String ltype;
	private String stype;
	private String paymonth;
	private String batch;

	private PaymentManageService service;
	private PaymentManageService manageService;
	private PaymentConfigService configService;

	private Map<String, String> cityMap;

	private Map<String, String> optypeMap;

	private String rewardmonth;// �����·�

	private PaymentManageQueryParameter parameter;

	private final String key = "PAYMENT_CHK_SWITCH";

	private String pageTitle = PageLoction.GD_REWARD_PAYMENT_MANAGE;

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getPubpri() {
		return pubpri;
	}

	public void setPubpri(String pubpri) {
		this.pubpri = pubpri;
	}

	public String getCheckedflag() {
		return checkedflag;
	}

	public void setCheckedflag(String checkedflag) {
		this.checkedflag = checkedflag;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public PaymentManageService getService() {
		return service;
	}

	public void setService(PaymentManageService service) {
		this.service = service;
	}

	public PaymentConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(PaymentConfigService configService) {
		this.configService = configService;
	}

	public PaymentManageService getManageService() {
		return manageService;
	}

	public void setManageService(PaymentManageService manageService) {
		this.manageService = manageService;
	}

	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = CityId.getCityMap();
	}

	public void setOptypeMap(Map<String, String> optypeMap) {
		this.optypeMap = Optype.getOptypeMap();
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public Map<String, String> getOptypeMap() {
		return optypeMap;
	}

	public PaymentManageAction() {
		this.setTitle(pageTitle);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.MONTH, -1);
		format.format(objCalendar.getTime());
		rewardmonth = (format.format(objCalendar.getTime()));

		setCityMap(null);
		setOptypeMap(null);
	}

	public QueryParameter getParameter() {
		if (parameter == null) {
			parameter = new PaymentManageQueryParameter();
		}

		// ����ҳ��
		if (this.getPageNo() != null) {
			parameter.setNo(getPageNo().intValue());
		}
		// ���ô�С
		if (this.getPageSize() != null) {
			parameter.setSize(getPageSize().intValue());
		}

		if (StringUtils.isNotBlank(this.getCityid())) {
			parameter.setCityid(this.getCityid());
		}

		if (StringUtils.isNotBlank(this.getOptype())) {
			parameter.setOptype(this.getOptype());
		}
		if (StringUtils.isNotBlank(this.getPubpri())) {
			parameter.setPubpri(this.getPubpri());
		}

		if (StringUtils.isNotBlank(this.getCheckedflag())) {
			parameter.setCheckedflag(this.getCheckedflag());
		}
		if (StringUtils.isNotBlank(this.getPayee())) {
			parameter.setPayee(this.getPayee());
		}
		if (StringUtils.isNotBlank(this.getWayid())) {
			parameter.setWayid(this.getWayid());
		}

		if (this.getLtype() != null) {
			parameter.setLtype(this.getLtype());
		}
		if (StringUtils.isNotBlank(this.getStype())) {
			parameter.setStype(this.getStype());
		}
		if (StringUtils.isNotBlank(this.getPaymonth())) {
			parameter.setPaymonth(this.getPaymonth());
		}
		if (StringUtils.isNotBlank(this.getBatch())) {
			parameter.setBatch(this.getBatch());
		}

		return parameter;
	}

	/**
	 * ��鵱ǰ����˿���
	 * 
	 * @return
	 */
	private boolean chkSwitchFlag() {
		boolean flag = false;
		ChCwConfig config = configService.getConfigByQuery(key);
		String value = config.getValue();
		if (StringUtils.isNotBlank(value) && value.equalsIgnoreCase("OPEN")) {
			flag = true;
		}

		return flag;
	}

	private void setSwitchFlag() {
		HttpServletRequest request = getRequest();
		boolean switchflag = chkSwitchFlag();
		if (switchflag) {
			request.setAttribute("switchflag", "1");
		} else {
			request.setAttribute("switchflag", "0");
		}
	}

	public String doList() {
		setSwitchFlag();

		return SUCCESS;
	}

	public String doCheck() {
		System.out.println("doCheck");

		return SUCCESS;
	}

	public String doBatchCheck() {
		System.out.println("doBatchCheck");

		return SUCCESS;
	}

	public String doRollback() {
		System.out.println("doRollback");

		return SUCCESS;
	}

	public String doBatchRollback() {
		System.out.println("doBatchRollback");

		return SUCCESS;
	}

	private Map<Integer, List<ChCwPayment>> queryCurCityid(LoginMember member) {
		Map<Integer, List<ChCwPayment>> map = new HashMap<Integer, List<ChCwPayment>>();

		parameter.setCityid("ZS");

		ServiceResult result = manageService.transact(member, parameter,
				ServiceType.QUERY);
		if (result != null) {
			QueryResult rtn = result.getRetResult();
			if (rtn != null) {
				Integer rows = Integer.valueOf(rtn.getPage().getRows());
				List<ChCwPayment> paymentList = new ArrayList<ChCwPayment>();

				List<Object[]> list = (List<Object[]>) rtn.getData();
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[]) list.get(i);
					ChCwPayment payment = new ChCwPayment();

					payment.setOptype((String) obj[0]);
					payment.setPaymonth((String) obj[1]);
					payment.setStype((String) obj[2]);
					payment.setPayee((String) obj[3]);

					payment.setPaysum(BigDecimalConverter
							.convertToDouble(obj[4]));

					payment.setDeduction((String) obj[5]);
					payment.setBatch((String) obj[6]);

					payment.setSeq(BigDecimalConverter.convertToLong(obj[7]));

					payment.setWayid((String) obj[8]);
					payment.setBank((String) obj[9]);
					payment.setDepositbank((String) obj[10]);
					payment.setAccount((String) obj[11]);
					payment.setBillnumber((String) obj[12]);
					payment.setCountyid((String) obj[13]);
					payment.setPubpri((String) obj[14]);

					payment.setRate(BigDecimalConverter.convertToFloat(obj[15]));

					payment.setUpoprcode((String) obj[16]);
					payment.setCheckedflag((String) obj[17]);

					paymentList.add(payment);
				}

				map.put(rows, paymentList);
			}
		}

		return map;
	}

	/**
	 * ����һ�����е�ChCwPayment�б�ӵ���һ��List
	 * 
	 * @param srcList
	 * @param cityList
	 * @return
	 */
	private List<ChCwPayment> listAdd(List<ChCwPayment> srcList,
			List<ChCwPayment> cityList) {

		if (srcList == null || srcList.size() == 0) {
			return cityList;
		}

		if (cityList == null || cityList.size() == 0) {
			return srcList;
		}

		for (int i = 0; i < cityList.size(); i++) {
			srcList.add(cityList.get(i));
		}

		return srcList;
	}

	/**
	 * ����һ�����е�MAP �ӵ����еĵ���MAP ��ȥ��������ѯ21������
	 * 
	 * @param srcMap
	 * @param cityidMap
	 * @return
	 */
	private Map<Integer, List<ChCwPayment>> mapAdd(
			Map<Integer, List<ChCwPayment>> srcMap,
			Map<Integer, List<ChCwPayment>> cityidMap) {

		if (srcMap == null || srcMap.size() == 0) {
			return cityidMap;
		}

		if (cityidMap == null || cityidMap.size() == 0) {
			return srcMap;
		}

		int srcRows = 0;
		List<ChCwPayment> srcList = null;
		Iterator<Integer> iterater = srcMap.keySet().iterator();
		if (iterater.hasNext()) {
			srcRows = (int) iterater.next();
			srcList = srcMap.get(srcRows);
		}

		int cityRows = 0;
		List<ChCwPayment> cityList = null;
		iterater = cityidMap.keySet().iterator();
		if (iterater.hasNext()) {
			cityRows = (int) iterater.next();
			cityList = cityidMap.get(cityRows);
		}

		srcRows = srcRows + cityRows;

		srcList = listAdd(srcList, cityList);

		Map<Integer, List<ChCwPayment>> allMap = new HashMap<Integer, List<ChCwPayment>>();
		allMap.put(srcRows, srcList);

		return allMap;
	}

	/**
	 * �жϵ�ǰ��ѡ�ĵ��У��粻ѡ����ѭ��21������
	 * 
	 * @param member
	 * @param parameter
	 * @return
	 */
	private Map<Integer, List<ChCwPayment>> cycleCityid(LoginMember member) {
		Map<Integer, List<ChCwPayment>> srcMap = new HashMap<Integer, List<ChCwPayment>>();

		String cityid = parameter.getCityid();
		if (StringUtils.isEmpty(cityid)) {
			String key = null;
			Iterator<String> iterater = cityMap.keySet().iterator();
			while (iterater.hasNext()) {
				key = (String) iterater.next();
				if (!key.equals("")) {
					parameter.setCityid(key);

					Map<Integer, List<ChCwPayment>> cityidMap = queryCurCityid(member);
					// ��һ�����л�����Ϊ��
					if (srcMap.size() == 0) {
						srcMap = cityidMap;
					} else {// map ���
						srcMap = mapAdd(srcMap, cityidMap);
					}
				}
			}
		} else {
			srcMap = queryCurCityid(member);
		}

		return srcMap;
	}

	private QueryResult setQryResult(Map<Integer, List<ChCwPayment>> map) {
		QueryResult qr = null;
		for (Map.Entry<Integer, List<ChCwPayment>> entry : map.entrySet()) {
			int rows = (int) entry.getKey();
			int size = 20;
			int currentPage = 1;
			Integer pageNo = getPageNo();
			if (pageNo != null) {
				currentPage = pageNo.intValue();
			}

			Page page = new Page(rows, size, currentPage);

			List<ChCwPayment> list = (List<ChCwPayment>) entry.getValue();
			qr = new QueryResult(page, list);
		}

		return qr;
	}

	private ServiceResult setServiceResult(ServiceResult result, boolean flag,
			int retCode, QueryResult qryResult) {
		result.setSuccess(flag);
		result.setRetCode(retCode);
		result.setRetObject(null);
		result.setRetResult(qryResult);

		return result;
	}

	public String doAjax() {
		setSwitchFlag();

		LoginMember member = getMember();

		// System.out.println(member.getEmployeeid() + "--" +
		// member.getOprcode());

		ServiceResult result = isLogin();
		if (result.isSuccess()) {
			// result = service.transact(member, getParameter(),
			// ServiceType.QUERY);

			setServiceResult(result, false, ServiceRetCode.FAIL, null);
			getParameter();
			Map<Integer, List<ChCwPayment>> map = cycleCityid(member);
			QueryResult qryResult = setQryResult(map);

			setServiceResult(result, true, ServiceRetCode.SUCCESS, qryResult);
		}

		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	private boolean savePaymentLog(String key, String value, String explain) {
		boolean flag = false;
		ChCwConfiglog configlog = new ChCwConfiglog();
		configlog.setOprcode(getMember().getOprcode());
		configlog.setOprtype("create");
		configlog.setSuccess("success");
		configlog.setKey(key);
		configlog.setValue(value);
		configlog.setExplain(explain);
		try {
			// service.saveConfiglog(configlog);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * ��ñ�ͷ
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		// ҵ������ ���С�� �տλ���� �������� ������ �����˺� ��Ӧ���˵��� �ֹ�˾
		// �����·� ʵ����� ���� �Թ�/��˽ ��˽�����۴���˰�� ����׼ У����� �ۼ���� ��ע
		// �������� �ϴ����� ��˱�ʶ
		// P.OPTYPE,P.PAYMONTH,P.STYPE,P.PAYEE,P.PAYSUM, P.DEDUCTION,
		// P.BATCH,P.SEQ,P.WAYID,P.BANK,P.DEPOSITBANK, P.ACCOUNT,
		// P.BILLNUMBER,P.COUNTYID,P.PUBPRI,P.RATE,P.UPOPRCODE,P.CHECKEDFLAG

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("optype", "ҵ������"));
		// setCols.add(new ColumnSet("LTYPE", "������"));
		setCols.add(new ColumnSet("stype", "���С��"));
		setCols.add(new ColumnSet("payee", "�տλ����"));
		setCols.add(new ColumnSet("bank", "��������"));
		setCols.add(new ColumnSet("depositbank", "������"));
		setCols.add(new ColumnSet("account", "�����˺�"));
		setCols.add(new ColumnSet("billnumber", "��Ӧ���˵���"));
		setCols.add(new ColumnSet("countyid", "�ֹ�˾"));

		setCols.add(new ColumnSet("paymonth", "�����·�"));
		setCols.add(new ColumnSet("paysum", "ʵ�����"));
		setCols.add(new ColumnSet("batch", "����"));
		setCols.add(new ColumnSet("pubpri", "�Թ���˽"));
		setCols.add(new ColumnSet("rate", "���۴���˰��"));
		// setCols.add(new ColumnSet("rewardstd", "����׼"));
		// setCols.add(new ColumnSet("rule", "У�����"));
		setCols.add(new ColumnSet("deduction", "�ۼ����"));
		// setCols.add(new ColumnSet("note", "��ע"));
		setCols.add(new ColumnSet("wayid", "��������"));
		// setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("upoprcode", "�ϴ�����"));
		setCols.add(new ColumnSet("checkedflag", "��˱�ʶ"));
		return setCols;
	}

	/**
	 * ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {
		return JSONArray.fromObject(getsetCols()).toString();
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
}
