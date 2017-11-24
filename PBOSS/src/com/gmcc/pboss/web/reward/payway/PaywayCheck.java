package com.gmcc.pboss.web.reward.payway;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaywayCheck extends BaseCheckFormat {
	private User user;

	private List<String> wayIdList;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * ��ȡ�����а���ʡ��������������ID
	 * 
	 * @return
	 */
	public List<String> getWayIdList() throws Exception {
		wayIdList = new ArrayList<String>();

		PaywayDBParam params = new PaywayDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		params.setSelectFieldsString("wayid");
		params.getQueryConditions().put("cityid", user.getCityid());

		try {
			Payway payway = (Payway) BOFactory.build(PaywayBO.class, user);

			String qrySql = "com.gmcc.pboss.business.reward.payway.doQueryVWayBySql";
			DataPackage paywayDp = payway.doQueryVWayBySql(params, qrySql);
			wayIdList = (List<String>) paywayDp.getDatas();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("��ȡ�õ��а���ʡ���е������������Ƴ���");
		}

		return wayIdList;
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("�ϴ���������ȷ��ӦΪ2��!");
		}

		if (StringUtils.isBlank(content[0])
				|| content[0].trim().getBytes("GBK").length > 128) {
			throw new Exception("�տλ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���128");
		}

		String wayid = content[1];
		if (StringUtils.isBlank(wayid)
				|| wayid.trim().getBytes("GBK").length > 18) {
			throw new Exception("�������벻��Ϊ���ҳ��Ȳ��ܴ���18");
		}

		// �״���Ҫִ�иõ��е��տλ���ݲ�ѯ
		if (wayIdList == null) {
			getWayIdList();
		}

		if (!(wayIdList.size() > 0 && wayIdList.contains(wayid))) {
			throw new Exception("��������[" + wayid + "]�����������ڣ�����������������ϴ�");
		}
	}
}
