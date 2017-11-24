package com.gmcc.pboss.web.reward.paymentsc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaymentscCheck extends BaseCheckFormat {

	private final Logger log = LoggerFactory.getLogger(PaymentscCheck.class);

	private User user;

	// ��ѯ������ͣ� 0 ȫ��, 10 ����, 20����
	private final int QUERY_TYPE = 20;
	// ���pagesizeΪ0����ʾ����ҳ��ֻ��1ҳ
	private final String NG_PAGESIZE = "0";

	private List<String> optypeList;
	private List<String> ltypeList;
	private List<String> stypeList;
	private List<String> wayList;

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
		optypeList = new ArrayList<String>();
		ltypeList = new ArrayList<String>();

		String cityId = user.getCityid();

		LtypeDBParam ltypeParams = new LtypeDBParam();
		List cityList = new ArrayList();
		cityList.add(cityId);
		cityList.add("GD");
		ltypeParams.set_sin_cityid(cityList);
		ltypeParams.set_pagesize(NG_PAGESIZE);
		ltypeParams.setDataOnly(true);

		List fieldList = new ArrayList();
		fieldList.add("optype");
		fieldList.add("ltype");
		ltypeParams.setSelectFields(fieldList);

		try {
			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			DataPackage dp = ltype.doQuery(ltypeParams);
			List<LtypeVO> list = (List<LtypeVO>) dp.getDatas();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					// ҵ�������ظ�������ȥ��
					String optype = list.get(i).getOptype();
					if (!optypeList.contains(optype)) {
						optypeList.add(optype);
					}

					// �������ظ�������ȥ��
					String ltypeName = list.get(i).getLtype();
					if (!ltypeList.contains(ltypeName)) {
						ltypeList.add(ltypeName);
					}
				}
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
	private void getStypeList() throws Exception {
		stypeList = new ArrayList<String>();
		String cityId = user.getCityid();

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
			// ֱ�Ӹ�ֵ����Ϊ���а���ʡ��˾�����г��С�಻�ظ�������ȥ��
			stypeList = (List<String>) stypeDp.getDatas();
		} catch (Exception e) {
			String msg = "��ȡ�õ��а���ʡ��˾�����г��С�����Ƴ���";
			log.error(msg);
			throw new Exception(msg);
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
	 * ��ȡ�õ������е��������� <br />
	 * ��ҵ�����͡����ڸ���ҵ������ҵ��˰��ҵ���е�һ�֣���Ҫ���ˡ��������롱�Ƿ����������CH_PW_WAY��
	 * 
	 * @return
	 */
	public void getWayList() throws Exception {
		String cityId = user.getCityid();
		wayList = new ArrayList<String>();

		WayDBParam params = new WayDBParam();
		params.set_pagesize(NG_PAGESIZE);
		params.setDataOnly(true);
		params.setSelectFieldsString("wayid");
		params.getQueryConditions().put("cityid", cityId);

		try {
			Way way = (Way) BOFactory.build(WayBO.class, user);
			DataPackage wayDp = way.doQueryWayIdByCityId(params, user);
			wayList = (List<String>) wayDp.getDatas();
		} catch (Exception e) {
			String msg = "��ȡ�õ������е������������";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	/**
	 * ������������ϴ����г�������ʽУ�� <br />
	 * 
	 * ��������|�����·ݣ������·ݣ�|ҵ���·ݣ������·ݣ�|ҵ������|������|���С��|�����<br />
	 * �ֻ�����|IMEI��|<br />
	 * �������˽�|������������*�ڣ�|�����|��ע|<br />
	 * 
	 */
	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 12) {
			String msg = "�ϴ���������ȷ��ӦΪ11��!����Ϊ��"
					+ String.valueOf(content.length - 1);
			log.error(msg);
			throw new Exception(msg);
		}

		boolean flag = true;

		// �������� content[0]
		String wayId = content[0];
		if (StringUtils.isBlank(wayId)) {
			throw new Exception("[��������]����Ϊ���ҳ��Ȳ��ܴ���18λ��");
		} else {
			wayId = wayId.trim();
			if (wayId.getBytes("GBK").length > 18) {
				String msg = "[��������]���Ȳ��ܴ���18λ" + wayId;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �����·ݣ������·ݣ� content[1]
		String calcMonth = content[1];
		if (StringUtils.isBlank(calcMonth)) {
			throw new Exception("[�����·ݣ������·ݣ�]����Ϊ����ֻ��Ϊ6λ��yyyyMM��ʽ��");
		} else {
			calcMonth = calcMonth.trim();
			flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				String msg = "[�����·ݣ������·ݣ�]��ʽ����,ӦΪyyyyMM: " + calcMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ҵ���·ݣ������·ݣ� content[2]
		String payMonth = content[2];
		if (StringUtils.isBlank(payMonth)) {
			throw new Exception("[ҵ���·ݣ������·ݣ�]����Ϊ����ֻ��Ϊ6λ��yyyyMM��ʽ��");
		} else {
			payMonth = payMonth.trim();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				String msg = "[ҵ���·ݣ������·ݣ�]��ʽ����,ӦΪyyyyMM: " + payMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ҵ������ content[3]
		String optype = content[3];
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

		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[ҵ������]ֻ���ǡ�����ҵ�񡱡�������ҵ�񡱡�������ҵ�񡱡���˰��ҵ�񡱡�������ҵ���е�һ�֣�");
		}

		// �жϡ�ҵ�����͡����ڸ���ҵ������ҵ��˰��ҵ���е�һ�֣���Ҫ����
		if (optype.equals("����ҵ��") || optype.equals("����ҵ��")
				|| optype.equals("˰��ҵ��")) {
			// �״���Ҫִ�иõ������е���������
			if (wayList == null) {
				getWayList();
			}

			if (wayList != null && wayList.size() > 0) {
				if (!wayList.contains(wayId)) {
					StringBuilder strb = new StringBuilder();
					strb.append("ҵ������Ϊ");
					strb.append(optype);
					strb.append("ʱ��������������BOSS�������룬�������������Ƿ���ȷ��");
					strb.append(wayId);

					throw new Exception(strb.toString());
				}
			}
		}

		// ������ content[4]
		String ltypeName = content[4];
		if (StringUtils.isBlank(ltypeName)) {
			throw new Exception("[������]����Ϊ���ҳ��Ȳ��ܴ���128��");
		} else {
			ltypeName = ltypeName.trim();
			if (ltypeName.getBytes("GBK").length > 128) {
				String msg = "[������]����Ϊ���ҳ��Ȳ��ܴ���128: " + ltypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ���С�� content[5]
		String stypeName = content[5];
		if (StringUtils.isBlank(stypeName)) {
			throw new Exception("[���С��]����Ϊ���ҳ��Ȳ��ܴ���128��");
		} else {
			stypeName = stypeName.trim();
			if (stypeName.getBytes("GBK").length > 128) {
				String msg = "[���С��]����Ϊ���ҳ��Ȳ��ܴ���128: " + stypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// �ֻ����� content[6]
		String mobile = content[6];
		if (StringUtils.isNotBlank(mobile)) {
			mobile = mobile.trim();
			if (mobile.getBytes("GBK").length > 20) {
				String msg = "[�ֻ�����]����ǿ��򳤶Ȳ��ܴ���20: " + mobile;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// IMEI�� content[7]
		String imei = content[7];
		if (StringUtils.isNotBlank(imei)) {
			imei = imei.trim();
			if (imei.getBytes("GBK").length > 15) {
				String msg = "[IMEI��]���ܷǿ��򳤶Ȳ��ܴ���15: " + imei;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ����� �����˽�content[8] ��ֵ�ж� 18,4
		String paySum = content[8];
		if (StringUtils.isBlank(paySum)) {
			throw new Exception("[�������˽�]����Ϊ���ҳ��Ȳ��ܴ���18��");
		} else {
			paySum = paySum.trim();
			flag = CheckUtil.checkDouble(paySum, 14, 4);
			if (!flag || paySum.getBytes("GBK").length > 18) {
				String msg = "[�������˽�]����Ϊ���֡�С��λ������4λ���ܳ��Ȳ����� 18λ�� " + paySum;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ������������*�ڣ�content[9]
		String settleperiods = content[9];
		if (StringUtils.isBlank(settleperiods)) {
			throw new Exception("[��������]����Ϊ���ҳ��Ȳ��ܴ���400��");
		} else {
			settleperiods = settleperiods.trim();
			if (settleperiods.getBytes("GBK").length > 400) {
				String msg = "[��������]����Ϊ���ҳ��Ȳ����� 400�� " + settleperiods;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// ��ע content[10] note
		String note = content[10];
		if (StringUtils.isNotBlank(note)) {
			note = note.trim();
			if (note.getBytes("GBK").length > 4000) {
				String msg = "[��ע]����ǿ��򳤶Ȳ��ܴ���4000: " + note;
				log.error(msg);
				throw new Exception(msg);
			}
		}
	}
}
