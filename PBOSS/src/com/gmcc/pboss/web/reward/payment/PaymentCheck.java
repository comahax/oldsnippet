package com.gmcc.pboss.web.reward.payment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaymentCheck extends BaseCheckFormat {

	private final Logger log = LoggerFactory.getLogger(PaymentCheck.class);

	private User user;

	// ��ѯ������ͣ� 0 ȫ��, 10 ����, 20����
	private final int QUERY_TYPE = 20;
	// ���pagesizeΪ0����ʾ����ҳ��ֻ��1ҳ
	private final String NG_PAGESIZE = "0";

	private Map<String, List<String>> stypeMap;
	private Map<String, List<String>> optypeMap;
	private Map<String, List<String>> ltypeMap;
	private List<String> payWayList;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			String msg = "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ���";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	/**
	 * ��ȡ�õ������е�ҵ���������ƺͳ��������ƣ���ȥ��
	 * 
	 * @return
	 */
	private void getLtypeMap() throws Exception {
		optypeMap = new HashMap<String, List<String>>();
		ltypeMap = new HashMap<String, List<String>>();

		String cityId = user.getCityid();
		if (optypeMap.containsKey(cityId)) {
			return;
		}

		LtypeDBParam ltypeParams = new LtypeDBParam();
		List cityList = new ArrayList();
		cityList.add(cityId);
		cityList.add("GD");
		ltypeParams.set_sin_cityid(cityList);
		ltypeParams.set_pagesize(NG_PAGESIZE);
		ltypeParams.setDataOnly(true);

		// ltypeParams.setSelectFieldsString("optype");
		List fieldList = new ArrayList();
		fieldList.add("optype");
		fieldList.add("ltype");
		ltypeParams.setSelectFields(fieldList);

		try {
			List<String> optypeList = new ArrayList<String>();
			List<String> ltypeList = new ArrayList<String>();

			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			DataPackage dp = ltype.doQuery(ltypeParams);
			List<LtypeVO> allList = (List<LtypeVO>) dp.getDatas();
			if (allList.size() > 0) {
				for (int i = 0; i < allList.size(); i++) {
					// ҵ�������ظ�������ȥ��
					String optype = allList.get(i).getOptype();
					if (!optypeList.contains(optype)) {
						optypeList.add(optype);
					}

					// �������ظ�������ȥ��
					String ltypeName = allList.get(i).getLtype();
					if (!ltypeList.contains(ltypeName)) {
						ltypeList.add(ltypeName);
					}
				}

				optypeMap.put(cityId, optypeList);
				ltypeMap.put(cityId, ltypeList);
			}
		} catch (Exception e) {
			String msg = "��ȡ�õ������е�ҵ�����ͺͳ��������";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	private List<String> getOptypeList() {
		List<String> list = new ArrayList<String>(5);
		list.add("����ҵ��");
		list.add("����ҵ��");
		list.add("����ҵ��");
		list.add("˰��ҵ��");
		list.add("����ҵ��");

		return list;
	}

	/**
	 * ��ȡ�õ��а���ʡ��˾�����г��С������
	 * 
	 * @return
	 */
	private void getStypeMap() throws Exception {
		stypeMap = new HashMap<String, List<String>>();
		String cityId = user.getCityid();
		if (!stypeMap.containsKey(cityId)) {
			StypeDBParam stypeParams = new StypeDBParam();
			List cityList = new ArrayList();
			cityList.add(cityId);
			cityList.add("GD");
			stypeParams.set_sin_cityid(cityList);
			stypeParams.set_pagesize(NG_PAGESIZE);
			stypeParams.setDataOnly(true);
			stypeParams.setSelectFieldsString("stype");

			try {
				Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
				DataPackage stypeDp = stype.doQueryStypeBySql(stypeParams,
						QUERY_TYPE);
				List<String> stypeList = (List<String>) stypeDp.getDatas();
				if (stypeList != null && stypeList.size() > 0) {
					// ֱ�Ӹ�ֵ����Ϊ���а���ʡ��˾�����г��С�಻�ظ�������ȥ��
					stypeMap.put(cityId, stypeList);
				}
			} catch (Exception e) {
				String msg = "��ȡ�õ��а���ʡ��˾�����г��С�����Ƴ���";
				log.error(msg);
				throw new Exception(msg);
			}
		}
	}

	/**
	 * �жϳ��С���Ƿ����
	 * 
	 * @param stypeName
	 * @return
	 */
	private int directChkStype(String stypeName) throws Exception {
		int size = 0;
		try {
			StypeDBParam params = new StypeDBParam();
			List list = new ArrayList();
			list.add(user.getCityid());
			list.add("GD");
			params.set_sin_cityid(list);
			params.set_se_stype(stypeName);
			params.setCountOnly(true);

			Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
			DataPackage dp = stype.doQuery(params);
			size = dp.getRowCount();
		} catch (Exception e) {
			String msg = "��ȡ�õ��а���ʡ��˾�����г��С�����Ƴ���";
			log.error(msg);
			throw new Exception(msg);
		}

		return size;
	}

	/**
	 * ��ȡ�õ������е��տλ��������������<br />
	 * ȡ�������ж� 2016-01-19
	 * 
	 * @return
	 */
	public List<String> getPaywayList() throws Exception {
		payWayList = new ArrayList<String>();
		String cityId = user.getCityid();

		PaywayDBParam params = new PaywayDBParam();
		params.set_se_cityid(cityId);
		params.set_pagesize(NG_PAGESIZE);
		params.setDataOnly(true);

		List fieldList = new ArrayList();
		fieldList.add("payee");
		fieldList.add("wayid");
		params.setSelectFields(fieldList);

		try {
			Payway payee = (Payway) BOFactory.build(PaywayBO.class, user);
			DataPackage payeeDp = payee.doQuery(params);
			List<PaywayVO> payeeList = (List<PaywayVO>) payeeDp.getDatas();

			for (int i = 0; i < payeeList.size(); i++) {
				PaywayVO vo = payeeList.get(i);

				StringBuilder strb = new StringBuilder();
				strb.append(vo.getPayee());
				strb.append("_");
				strb.append(vo.getWayid());

				String str = strb.toString();
				payWayList.add(str);
			}

		} catch (Exception e) {
			String msg = "��ȡ�õ������е��տλ���Ƴ���";
			log.error(msg);
			throw new Exception(msg);
		}

		return payWayList;
	}

	/**
	 * ���븶�����ݸ�ʽУ�� <br />
	 * 
	 * ҵ������|�����<br />
	 * ������|���С��|<br />
	 * �տλ����|�����˻�����|��������|�����У�XX֧�У�|�����˺�|�����<br />
	 * ��Ӧ���˵���|�ֹ�˾|<br />
	 * �����·�|ʵ�����|�����<br />
	 * ����|�Թ�/��˽|��ע|���㣨���ˣ��·�|<br />
	 * 
	 */
	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// String cityId = user.getCityid();
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 17) {
			String msg = "�ϴ���������ȷ��ӦΪ16��!����Ϊ��"
					+ String.valueOf(content.length - 1);
			log.error(msg);
			throw new Exception(msg);
		}

		boolean flag = true;

		// ҵ������ content[0]
		String optype = content[0];
		if (StringUtils.isBlank(optype)) {
			throw new Exception("[ҵ������]����Ϊ���ҳ��Ȳ��ܴ���16��");
		} else {
			optype = optype.trim();
			if (optype.getBytes("GBK").length > 16) {
				String msg = "[ҵ������]����Ϊ���ҳ��Ȳ��ܴ���16: " + optype;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ���в�ѯ����ʼ���õ��е�ҵ�����ͺͳ�����Map
		// if (optypeMap == null) {
		// getLtypeMap();
		// }

		// �ж�ҵ�������Ƿ����ڸõ������е�����
		// if (optypeMap.size() > 0) {
		// List<String> optypeList = optypeMap.get(cityId);
		// if (!(optypeList.size() > 0 && optypeList.contains(optype))) {
		// String msg = "[ҵ������]�������ڸõ������е����ͣ�";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }

		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[ҵ������]ֻ���ǡ�����ҵ�񡱡�������ҵ�񡱡�������ҵ�񡱡���˰��ҵ�񡱡�������ҵ���е�һ�֣�");
		}

		// ҵ������|������|���С��|�տλ����|�����˻�����|��������|�����У�XX֧�У�|
		// �����˺�|��Ӧ���˵���|�ֹ�˾|�����·�|ʵ�����|����|�Թ�/��˽|��ע|���㣨���ˣ��·�|
		
		// ������ content[1] ��Ϊ��
		String ltypeName = content[1];
		if (StringUtils.isNotBlank(ltypeName)) {
			ltypeName = ltypeName.trim();
			if (ltypeName.getBytes("GBK").length > 128) {
				String msg = "[������]����ǿ��򳤶Ȳ��ܴ���128" + ltypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �жϳ����������Ƿ����ڸõ������е�����
		// if (ltypeMap.size() > 0) {
		// List<String> ltypeList = ltypeMap.get(cityId);
		// if (!(ltypeList.size() > 0 && ltypeList.contains(ltypeName))) {
		// String msg = "������[" + ltypeName + "]�����ڣ�����ӳ���������ϴ���";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }

		// ���С�� content[2] ��Ϊ��
		String stypeName = content[2];
		if (StringUtils.isNotBlank(stypeName)) {
			stypeName = stypeName.trim();
			if (stypeName.getBytes("GBK").length > 128) {
				String msg = "[���С��]����Ϊ���ҳ��Ȳ��ܴ���128: " + stypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �״���Ҫִ�иõ��еĳ��С�����ݲ�ѯ
		// if (stypeMap == null) {
		// getStypeMap();
		// }

		// �жϳ��С�������Ƿ����ڸõ������е�����
		// int size = stypeMap.size();
		// if (size > 0) {
		// List<String> stypeList = stypeMap.get(cityId);
		// if (!(stypeList.size() > 0 && stypeList.contains(stypeName))) {
		// // �����MAP �鲻����ֱ����С�������ٲ�һ��
		// size = directChkStype(stypeName);
		// if (size == 0) {
		// String msg = "���С��[" + stypeName + "]�����ڣ�����ӳ��С������ϴ���";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }
		// }

		// �տλ���� content[3]
		String payeeName = content[3];
		if (StringUtils.isBlank(payeeName)) {
			throw new Exception("[�տλ����]����Ϊ���ҳ��Ȳ��ܴ���128��");
		} else {
			payeeName = payeeName.trim();
			if (payeeName.getBytes("GBK").length > 128) {
				String msg = "[�տλ����]����Ϊ���ҳ��Ȳ��ܴ���128: " + payeeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����˻����� content[4] BKACTNAME
		String bankactname = content[4];
		if (StringUtils.isBlank(bankactname)) {
			throw new Exception("[ �����˻�����]����Ϊ���ҳ��Ȳ��ܴ���256��");
		} else {
			bankactname = bankactname.trim();
			if (bankactname.getBytes("GBK").length > 256) {
				String msg = "[ �����˻�����]����Ϊ���ҳ��Ȳ��ܴ���256: " + bankactname;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �������� content[5]
		String bank = content[5];
		if (StringUtils.isBlank(bank)) {
			throw new Exception("[��������]����Ϊ���ҳ��Ȳ��ܴ���256��");
		} else {
			bank = bank.trim();
			if (bank.getBytes("GBK").length > 256) {
				String msg = "[��������]����Ϊ���ҳ��Ȳ��ܴ���256: " + bank;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����У�XX֧�У�content[6]
		String depostbank = content[6];
		if (StringUtils.isBlank(depostbank)) {
			throw new Exception("[�����У�XX֧�У�]����Ϊ���ҳ��Ȳ��ܴ���256��");
		} else {
			depostbank = depostbank.trim();
			if (depostbank.getBytes("GBK").length > 256) {
				String msg = "[�����У�XX֧�У�]����Ϊ���ҳ��Ȳ��ܴ���256: " + depostbank;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����˺� content[7]
		String account = content[7];
		if (StringUtils.isBlank(account)) {
			throw new Exception("[�����˺�]����Ϊ���ҳ��Ȳ��ܴ���64��");
		} else {
			account = account.trim();
			if (account.getBytes("GBK").length > 64) {
				String msg = "[�����˺�]����Ϊ���ҳ��Ȳ��ܴ���64: " + account;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ��Ӧ���˵��� content[8] ��Ϊ��
		String billnumber = content[8];
		if (StringUtils.isNotBlank(billnumber)) {
			billnumber = billnumber.trim();
			if (billnumber.getBytes("GBK").length > 80) {
				String msg = "[��Ӧ���˵���]����ǿ��򳤶Ȳ��ܴ���80: " + billnumber;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �ֹ�˾ content[9] ��Ϊ��
		String countyid = content[9];
		if (StringUtils.isNotBlank(countyid)) {
			countyid = countyid.trim();
			if (countyid.getBytes("GBK").length > 32) {
				String msg = "[�ֹ�˾]����ǿ��򳤶Ȳ��ܴ���32: " + countyid;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����·� content[10]
		String payMonth = content[10];
		if (StringUtils.isBlank(payMonth)) {
			throw new Exception("[�����·�]����Ϊ����ֻ��Ϊ6λ��yyyyMM��ʽ��");
		} else {
			payMonth = payMonth.trim();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				String msg = "[�����·�]��ʽ����,ӦΪyyyyMM: " + payMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ʵ����� content[11] ���ӷǸ��������ж� 18,4
		String paySum = content[11];
		if (StringUtils.isBlank(paySum)) {
			throw new Exception("[ʵ�����]����Ϊ���ҳ��Ȳ��ܴ���18��");
		} else {
			paySum = paySum.trim();
			flag = CheckUtil.checkDouble(paySum, 14, 4);
			if (!flag || paySum.getBytes("GBK").length > 18) {
				String msg = "[ʵ�����]����Ϊ���֡�С��λ������4λ���ܳ��Ȳ����� 18λ�� " + paySum;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ���� content[12] ��Ϊ��
		String batch = content[12];
		if (StringUtils.isNotBlank(batch)) {
			batch = batch.trim();
			if (batch.getBytes("GBK").length > 32) {
				String msg = "[����]���Ȳ��ܴ���32: " + batch;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �Թ�/��˽ content[13] ��Ϊ��
		String pubpri = content[13];
		if (StringUtils.isNotBlank(pubpri)) {
			pubpri = pubpri.trim();
			if (!"�Թ�".equals(pubpri) && !"��˽".equals(pubpri)) {
				String msg = "[�Թ�/��˽]ֻ��Ϊ�Թ�����˽��һ��: " + pubpri;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ��ע content[14] clob ��Ϊ��
		String note = content[14];
		if (StringUtils.isNotBlank(note)) {
			note = note.trim();
			if (note.getBytes("GBK").length > 4000) {
				String msg = "[��ע]���Ȳ��ܴ���32: " + note;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����·� content[15]
		String calcMonth = content[15];
		if (StringUtils.isNotBlank(calcMonth)) {
			calcMonth = calcMonth.trim();
			flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				String msg = "[�����·�]����ǿ����ʽӦΪyyyyMM: " + calcMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}
	}

}
