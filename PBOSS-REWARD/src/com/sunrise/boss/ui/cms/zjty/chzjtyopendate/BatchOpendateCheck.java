package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchOpendateCheck extends BaseCheckFormat {
	private int operType = 0;

	public BatchOpendateCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		/*
		 * ���ݲ�ͬ�Ĳ������ϴ��ļ�������ͬ��
		 */
		if (this.operType != 2 && items.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");

		} else if (this.operType == 2 && items.length != 2) {
			throw new Exception("�ϴ�������������,ӦΪ1��,��鿴˵������!");
		}
		if (StringUtils.isBlank(items[0]) || StringUtils.isBlank(items[1])) {
			if (this.operType != 2) {
				throw new Exception("[��������]��[��������]����Ϊ��");
			}
		}
		// �����������
		WayDelegate delegate = new WayDelegate();
		WayVO vo = delegate.doFindByPk(items[0].trim(), user);
		if (vo == null) {
			throw new Exception("�������в����������������ļ�¼��" + items[0]);
		} else if (!"AG".equals(vo.getWaytype())
				&& !"ZJTY".equals(vo.getWaysubtype())) {
			throw new Exception("���˵�ֻ�ṩ�Խ���Ӫ���͵�����¼����޸�");
		}
		if (items[0].getBytes("GBK").length > 32) {
			throw new Exception("[��������]����Ӧ��С��32λ");
		}
		if (this.operType != 2) {
			// ��齻������
			java.text.SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
			try {
				fmt.parse(items[1]);
			} catch (Exception ex) {
				throw new Exception("[��������]��ʽΪ[YYYYMMDD]");
			}
			// ��� ˵��
			if (items[2].getBytes("GBK").length > 32) {
				throw new Exception("[˵��]�������Ϊ255");
			}
		}

	}

}
