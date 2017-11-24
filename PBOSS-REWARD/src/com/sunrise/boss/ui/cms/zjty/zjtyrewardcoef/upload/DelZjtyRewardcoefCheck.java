package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;


public class DelZjtyRewardcoefCheck extends BaseCheckFormat {

	public DelZjtyRewardcoefCheck() {
		super();
	}
	
	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount, User user) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = line.split("\\|");
		WayDelegate waydelegate = new WayDelegate();

		// �������
		if (items.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//		String effectiblemont = format.format(DelZjtyRewardcoefCheck
//				.getDefaultDate(-1));
//		if (Integer.parseInt(items[0]) < Integer.parseInt(effectiblemont)) {
//			throw new BusinessException("", "�����²���Ϊ��ʷ������");
//		}
		if (StringUtils.isEmpty(items[0]) || items[0].length() > 6) {
			throw new BusinessException("", "�����²���Ϊ���ҳ��Ȳ��ܳ���6λ");
		}
		try {
			format.parse(items[0]);
		} catch (Exception e) {
			throw new BusinessException("", "�����¸�ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}
		//ҵ��������
		if (items[1].trim().equals("0") || items[1].trim().equals("1")
				|| items[1].trim().equals("2") || items[1].trim().equals("3")) {
		} else {
			throw new Exception("[���ϵ��]���ԣ�ֻ��Ϊ0,1,2,3����֮һ");
		}

		//Ӧ�տ��շ����
		if (items[2].trim().equals("")) {
			throw new Exception("[��������]���ԣ�����Ϊ��");
		}
		
		WayVO wayvo = waydelegate.doFindByPk(items[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "�������벻����");
		}
		
		ZjtyRewardcoefVO coefvo = new ZjtyRewardcoefVO();
		ZjtyRewardcoefDelegate coefdelegate = new ZjtyRewardcoefDelegate();
		coefvo.setEffectiblemonth(items[0]);
		coefvo.setCoefid(new Short(items[1]));
		coefvo.setWayid(items[2]);
		if(coefdelegate.doFindByPk(coefvo, user)==null){
			throw new BusinessException("", "�ϴ�ʧ�ܣ���¼��ϵͳ������,�޷�ɾ����");
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 8)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public static void main(String[] args) {

		DelZjtyRewardcoefCheck check = new DelZjtyRewardcoefCheck();

	}
}
