package com.sunrise.boss.ui.cms.zjty.zjtyddtreward.upload;

import java.text.SimpleDateFormat;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.StringSplit;

public class AddZjtyDdtrewardCheck extends BaseCheckFormat {

	public AddZjtyDdtrewardCheck() {
		super();
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

		String[] items = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();
		// �������
//		if (items.length < 5){
//			if(items.length ==4){
//				
//			}else{
//			throw new Exception("�ϴ�������������,����Ϊ4��,˵���ֶοɲ���!");
//			}
//		}
		//if (items[4].trim().equals(null)){
			
		//}
		if (items.length != 5) {
			throw new Exception("�ϴ�������������,Ӧ��Ϊ5��,��鿴˵������!");
		}

		if (!doCheckLong(items[0]) || items[0].length() > 3) {
			throw new BusinessException("", "��1��[�ۼ�����]����Ϊ�����ҳ��Ȳ��ܴ���3");
		}
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "��1��[�ۼ�����]����Ϊ��");
		}
		if (items[0].trim().equals("1")){
		} else {
			throw new Exception("��1��[�ۼ�����]���ԣ�ֻ��Ϊ 1 - ȫ��ͨ�ۼ�");
		}
		
		// ��������
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "��2��[��������]����Ϊ��");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[1], user);
		if (wayvo == null) {
			throw new BusinessException("", "��2��[��������]������");
		}
		
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[1]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		waylistvo.set_ne_runmode("1");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size()<=0){
			throw new BusinessException("", "�ϴ�ʧ��,��2��["+items[1]+"]���Ǳ����е��Խ���Ӫ����!");
		}
		
		//�����·�У��
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "��3��[������]����Ϊ��.");
		}
		if (items[2].length() != 6){
			throw new BusinessException("", "��3��[������]���ȱ���Ϊ6λ.");
		}
		try {
			format.parse(items[2]);
		} catch (Exception e) {
			throw new BusinessException("", "��3��[������]��ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM.");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[2].matches(regex)) {
			throw new BusinessException("", "���ý����²��Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}
		
		//���[�ۼ����]�Ƿ�Ϊ�Ϸ�
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "��4��[�ۼ����]����Ϊ�ղ��ұ���Ϊ����");
		}
		try {
			if (!(checkAmtFormat(items[3], 14)))
				throw new Exception("��4��[�ۼ����]��ʽ����(" + items[3]
						+ "),�����������14λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("��4��[�ۼ����]��ʽ����(" + items[3]
					+ "),�����������14λ������С��������һ����2λ!");
		}
		
		//˵��У��
		//if (items.length == 4){
		//}else if (items[4].getBytes().length > 255){
		 if (items[4].getBytes().length > 255){
			throw new BusinessException("", "��5��[˵��]���Ȳ��ܳ���255λ. ע����ĸ������ռ����1λ�������ַ�ռ����2λ.");
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

	public boolean doCheckLong(String number) {
		try {
			Long.parseLong(number);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
	}

	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0) {
				return false;
			}
			if (amt.indexOf(".") > length) {
				return false;
			}
			if ((amt.length() - amt.indexOf(".")) != 3) {
				return false;
			}
		} else {
			if (amt.length() > length) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		AddZjtyDdtrewardCheck check = new AddZjtyDdtrewardCheck();

	}

}
