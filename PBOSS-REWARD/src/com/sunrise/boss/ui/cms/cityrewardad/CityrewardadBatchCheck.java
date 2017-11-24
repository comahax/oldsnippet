package com.sunrise.boss.ui.cms.cityrewardad;

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

public class CityrewardadBatchCheck extends BaseCheckFormat {

	public CityrewardadBatchCheck() {
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
		if (items.length != 4) {
			throw new Exception("�ϴ�ʧ��,�����������Ϸ�,ӦΪ4��,��鿴˵������!");
		}

		// ����У��
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "�ϴ�ʧ��,��1�е���[��������]����Ϊ��");
		}

		WayVO wayvo = waydelegate.doFindByPk(items[0], user);
		if (wayvo == null) {
			throw new BusinessException("", "�ϴ�ʧ��,��1�е���[��������]������");
		}

		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[0]);
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		//waylistvo.set_se_cityid(user.getCityid());
		waylistvo.set_se_waytype("AG");
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size() <= 0) {
			throw new BusinessException("", "�ϴ�ʧ��,��1��[��������]�Ǳ����е���������򲻴���!");
		}

		// �������
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "�ϴ�ʧ��,��2��[�������]����Ϊ��");
		}

		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "�ϴ�ʧ��,��2��[�������]����Ϊ����");
		}

		if (items[1].trim().equals("3") || items[1].trim().equals("4")) {
		} else {
			throw new Exception("�ϴ�ʧ��,��2��[�������]���Ϸ���ӦΪ 3 ����ҵ�������� �� 4 ����ҵ�������");
		}

		// �����·�
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "�ϴ�ʧ��,��3��[�����·�]���Ϸ�,����Ϊ��!");
		}
		if(items[2].length() != 6){
			throw new BusinessException("", "�ϴ�ʧ��,��3��[�����·�]���Ϸ�,���ȱ���Ϊ6λ!");
		}
		
		if(!NumberUtils.isNumber(items[2])){
			throw new BusinessException("", "�ϴ�ʧ��,��3��[�����·�]���Ϸ�,ֻ��Ϊ����!");
		}
			
		try {
			format.parse(items[2]);
		} catch (Exception e) {
			throw new BusinessException("", "�ϴ�ʧ��,��3��[�����·�]���Ϸ�,ӦΪ6λ��������!");
		}
		
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[2].matches(regex)) {
			throw new BusinessException("", "�ϴ�ʧ��,��3��[�����·�]���Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}

		// ���У��
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "�ϴ�ʧ��,��4��[���]���Ϸ�,ӦΪ����,֧����λС��");
		}
		try {
			if (!(checkAmtFormat(items[3], 10)))
				throw new Exception("�ϴ�ʧ��,��4��[���]���Ϸ�,(" + items[3]
						+ ")ӦΪ����,�����������10λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("�ϴ�ʧ��,��4��[���]���Ϸ�,(" + items[3]
					+ ")ӦΪ����,�����������10λ������С��������һ����2λ!");
		}
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
}
