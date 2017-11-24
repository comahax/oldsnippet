package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class AddZjtyRewarddetailZzCheck extends BaseCheckFormat {

	public AddZjtyRewarddetailZzCheck() {
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
		
		String[] items = line.split("\\|");
		WayDelegate waydelegate = new WayDelegate();
		// �������
		if (items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}
		
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "��1��[ҵ�����]����Ϊ��.");
		}

		if (!doCheckLong(items[0])|| items[0].length()>18) {
			throw new BusinessException("", "��1��[ҵ�����]����Ϊ�����ҳ��Ȳ��ܳ���18λ.");
		}
		
		if(!"6401".equals(items[0].substring(0, 4))){
			throw new BusinessException("", "��1��[ҵ�����]���������ն˳��ҵ�����.");
		}
		
		ZjtyOperationVO vo = new ZjtyOperationVO();
		ZjtyOperationDelegate zodelegate = new ZjtyOperationDelegate();
		vo.setOpnid(items[0]);
		vo = zodelegate.doFindByPk(vo.getOpnid(), user);
		if(vo==null){
			throw new BusinessException("", "��1��[ҵ�����]������.");
		}
		
		
		// ��������
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "��2��[��������]����Ϊ��.");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[1], user);
		if (wayvo == null) {
			throw new BusinessException("", "��2��[��������]������.");
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
		if (dp1.getDatas().size()==0){
			throw new BusinessException("", "�ϴ�ʧ��,��2��["+items[1]+"]���Ǳ����е��Խ���Ӫ����!");
		}
		
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "��3��[�Ƴ귽ʽ]����Ϊ��.");
		}
		if (items[2].trim().equals("0") || items[2].trim().equals("1")) 
		{
		} else {
			throw new Exception("��3��[�Ƴ귽ʽ]���ԣ�ֻ��Ϊ0, 1����֮һ.");
		}
		
		// �����·�
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[3])) {
			throw new BusinessException("", "��4��[������]����Ϊ��.");
		}
		if (items[3].length() != 6){
			throw new BusinessException("", "��4��[������]���ȱ���Ϊ6λ.");
		}
		try {
			format.parse(items[3]);
		} catch (Exception e) {
			throw new BusinessException("", "��4��[������]��ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM.");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[3].matches(regex)) {
			throw new BusinessException("", "���ý����²��Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}

		// ���[Ӧ�����]�Ƿ�Ϊ�Ϸ�
		if (StringUtils.isEmpty(items[4]) || !NumberUtils.isNumber(items[4])) {
			throw new BusinessException("", "��5��[Ӧ�����]����Ϊ�ղ��ұ���Ϊ����");
		}
		try {
			if (!(checkAmtFormat(items[4], 12)))
				throw new Exception("��5��[Ӧ�����]��ʽ����(" + items[4]
						+ "),�����������12λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("��5��[Ӧ�����]��ʽ����(" + items[4]
					+ "),�����������12λ������С��������һ����2λ!");
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


	}

}
