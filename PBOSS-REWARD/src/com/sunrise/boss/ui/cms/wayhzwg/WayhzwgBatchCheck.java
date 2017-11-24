package com.sunrise.boss.ui.cms.wayhzwg;

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

public class WayhzwgBatchCheck extends BaseCheckFormat {

	public WayhzwgBatchCheck() {
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
		if (items.length != 3) {
			throw new Exception("�ϴ�ʧ��,�����������Ϸ�,ӦΪ3��,��鿴˵������!");
		}

		// ����У��
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "�ϴ�ʧ��,��1�е���[��������]����Ϊ��");
		}

		WayVO wayvo = waydelegate.doFindByPk(items[0], user);
		if (wayvo == null) {
			throw new BusinessException("", "�ϴ�ʧ��,��1�е���[��������]������");
		}
		// �ж��Ƿ�Ϊ��ǰ���е������������
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[0]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size() <= 0) {
			throw new BusinessException("", "�ϴ�ʧ��,��1��[��������]�Ǳ����е��������!");
		}

		// ����У��
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "�ϴ�ʧ��,��2��[Υ���·�]���Ϸ�,���벻��Ϊ��!");
		}
		if (items[1].length() != 6){
			throw new BusinessException("", "�ϴ�ʧ��,��2��[Υ���·�]���Ϸ�,���ȱ���Ϊ6λ!");
		}
		if (!NumberUtils.isNumber(items[1])){
			throw new BusinessException("","�ϴ�ʧ��,��2��[Υ���·�]���Ϸ�,����Ϊ����!");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[1].matches(regex)) {
			throw new BusinessException("", "�ϴ�ʧ��,��2��[Υ���·�]���Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}
		try {
			format.parse(items[1]);
		} catch (Exception e) {
			throw new BusinessException("", "�ϴ�ʧ��,��2��[Υ���·�]���Ϸ���ӦΪ6λ��������,ǰ4λΪ�Ϸ���,��2λΪ�Ϸ���!");
		}

		// ��עУ��
		if (StringUtils.isEmpty(items[2]) || items[2].length() > 600) {
			throw new BusinessException("", "�ϴ�ʧ��,��4��[��ע]����Ϊ��!");
		}
	}
}
