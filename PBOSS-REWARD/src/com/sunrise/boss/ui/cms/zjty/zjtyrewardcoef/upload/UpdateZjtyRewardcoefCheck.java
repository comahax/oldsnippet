package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class UpdateZjtyRewardcoefCheck extends BaseCheckFormat {

	public UpdateZjtyRewardcoefCheck() {
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
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = line.split("\\|");
		WayDelegate waydelegate = new WayDelegate();

		// �������
		if (items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//		String effectiblemont = format.format(UpdateZjtyRewardcoefCheck
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
		// ���ϵ��
		if (items[1].trim().equals("0") || items[1].trim().equals("1")
				|| items[1].trim().equals("2") || items[1].trim().equals("3")) {

		} else {
			throw new Exception("[���ϵ��]���ԣ�ֻ��Ϊ0,1,2,3����֮һ");
		}
		
		if (items[1].trim().equals("0")){
			if(Double.parseDouble(items[3])<=1.2 && Double.parseDouble(items[3])>=0){
			}else{
				throw new BusinessException("", "������ϵ������Ϊ0��1.2");
			}
		}
		if (items[1].trim().equals("1")){
			if(Double.parseDouble(items[3])<=1.3 && Double.parseDouble(items[3])>=1){
			}else{
				throw new BusinessException("", "�ۺ�����ϵ������Ϊ1��1.3");
			}
		}
		if (items[1].trim().equals("2")){
			if(Double.parseDouble(items[3])==1 || Double.parseDouble(items[3])==0){
			}else{
				throw new BusinessException("", "���ϵ������Ϊ0��1");
			}
		}
		if (items[1].trim().equals("3")){
			if(Double.parseDouble(items[3])<=1 && Double.parseDouble(items[3])>=0.5){
			}else{
				throw new BusinessException("", "����ϵ������Ϊ0.5-1");
			}
		}

		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "�������벻��Ϊ��");
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
			throw new BusinessException("", "�ϴ�ʧ�ܣ���¼��ϵͳ������,�޷��޸ġ�");
		}

		// if(content.length == 5){
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "����ϵ������Ϊ�ղ��ұ���Ϊ����");
		}
		if (items[3].substring(items[3].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "����ϵ��������Χ,ֻ֧�ֵ�С�������λ");
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

		UpdateZjtyRewardcoefCheck check = new UpdateZjtyRewardcoefCheck();

	}

}
