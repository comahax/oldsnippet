package com.sunrise.boss.ui.cms.resale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;

public class BatchResaleCheck extends BaseCheckFormat {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private WayDelegate wayDelegate;

	WayVO wayVO = new WayVO();

	WayVO wayVO1;

	CntycompanyDelegate cntycompanyDelegate;

	CntycompanyVO cntycompanyVO = new CntycompanyVO();

	CntycompanyVO cntycompanyVO1;

	public BatchResaleCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 50000) {
			throw new Exception("�ļ��������ܳ���50000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");

		// �������
		if (items.length != 5) {
			throw new BusinessException("", "�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}

		// ������¼
		// ���������������items[0]
		if ((items[0] == null || items[0].equals("")) || items[1].length() > 18) {
			throw new BusinessException("", "�����������벻�ԣ�Ӧ��ΪС��18λ���ַ���!");
		} else {
			wayVO.setWayid(items[0]);
			wayDelegate = new WayDelegate();
			wayVO1 = wayDelegate.doFindByPk(wayVO.getWayid(), user);
			if (wayVO1 == null) {
				throw new BusinessException("", "�����������벻����!");
			}
		}
		// ���ֹ�˾����items[1]

		if ((items[1] == null || items[1].equals("")) || items[1].length() > 14) {
			throw new BusinessException("", "�ֹ�˾���벻�ԣ�Ӧ��ΪС��14λ���ַ���!");
		} else {

			cntycompanyDelegate = new CntycompanyDelegate();
			cntycompanyVO.setCountycompid(items[1]);
			cntycompanyVO1 = cntycompanyDelegate.doFindByPk(cntycompanyVO
					.getCountycompid(), user);
			if (cntycompanyVO1 != null) {
				String city = cntycompanyVO1.getCitycompid();
				String city1 = SessionFactoryRouter.conversionCityid(user
						.getCityid());
				if (city1.equals(city)) {
				} else {
					throw new BusinessException("", "�ֹ�˾���벻����!");
				}
			} else {
				throw new BusinessException("", "�ֹ�˾���벻����!");
			}
		}

		// ������items[2]
		if ((items[2] == null || items[2].equals("")) || items[2].length() > 12) {
			throw new BusinessException("", "���벻�ԣ�Ӧ��ΪС��12λ���ַ���!");
		} else {
			try {
				Long temp1 = Long.valueOf(items[2]);
			} catch (Exception e1) {
				throw new BusinessException("", "�ϴ����ݵĺ����������Ͳ���(" + items[2]
						+ "),Ӧ���������ַ���!");
			}
		}
		// ���Ʒ��items[3]
		if ((items[3] == null || items[3].equals(""))) {
			throw new BusinessException("", "Ʒ�Ʋ���Ϊ��!");
		} else if (!items[3].trim().matches("[123]")) {
			throw new Exception("[Ʒ��]��ʽ����:ȡֵӦ��:1(ȫ��ͨ)2(������)3(���еش�)֮һ");
		}

		// �����������items[4]
		if (items[4] != null && !"".equals(items[4])) {
			try {
				sdf.parse(items[4]);
			} catch (ParseException pe) {
				throw new BusinessException("", "�������ڲ���,ӦΪYYYY-MM-DD!");
			}
		}
		if (items[4].length() != 10) {
			throw new BusinessException("", "�������ڲ���,ӦΪYYYY-MM-DD!");
		}

	}    
}
