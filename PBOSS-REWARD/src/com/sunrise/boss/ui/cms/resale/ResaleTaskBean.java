package com.sunrise.boss.ui.cms.resale;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.delegate.cms.resale.ResaleDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ResaleTaskBean extends BaseBatchTaskBean {
	private ResaleDelegate delegate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ResaleTaskBean() throws Exception {
		super.setBatchName("���������Դ������Ϣ����������־��ѯ");
		super.setWriteLog(true);
		delegate = new ResaleDelegate();
	}

	protected String doStart() {
		return "���������Դ������Ϣ���������� \r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (null == line || "".equals(line)) {
			return null;
		}
		ResultVO rvo = new ResultVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		ResaleVO resaleVO = new ResaleVO();
		//resaleVO.setItemid(new Long(items[0]));
		try {
			ResaleVO resaleVO1 = null;
//			if (resaleVO1 != null) { // ������ͬ��¼���޸ļ�¼
//				//������������
//				if (items[0] == null || items[0].equals("")) {
//					resaleVO.setWayid(resaleVO.getWayid());
//				} else {
//					resaleVO.setWayid(items[0]);
//				}
//				//�ֹ�˾����
//				if (items[1] == null || items[1].equals("")) {
//
//					resaleVO.setCountyid(resaleVO.getCountyid());
//				} else {
//					resaleVO.setCountyid(items[1]);
//				}
//				//����
//				if (items[2] == null || items[2].equals("")) {
//
//					resaleVO.setMobile(resaleVO.getMobile());
//				} else {
//					resaleVO.setMobile(items[2]);
//				}
//
//				//Ʒ��
//				if (items[3] == null || items[3].equals("")) {
//					resaleVO.setBrand(resaleVO.getBrand());
//				} else {
//					resaleVO.setBrand(new Long(items[3]));
//				}
//				//��������
//				if (items[4] == null || items[4].equals("")) {
//					resaleVO.setDaytime(resaleVO.getDaytime());
//				} else {
//					try {
//						resaleVO.setDaytime(sdf.parse(items[4]));
//					} catch (Exception e) {
//						rvo.setInfo("�滮ʱ���ʽ����!");
//						rvo.setOk(false);
//					}
//				}
//				delegate.doUpdate(resaleVO, user);
//			} else { // ������¼ 
				resaleVO.setItemid(null);
				resaleVO.setWayid(items[0]);
				resaleVO.setCountyid(items[1]);
				resaleVO.setMobile(items[2]);
				resaleVO.setBrand(new Long(items[3]));
				resaleVO.setDaytime(sdf.parse(items[4]));
				delegate.doCreate(resaleVO, user);
//			}
		} catch (Exception e) {
			rvo.setInfo(e.getMessage());
			rvo.setOk(false);
		}

		if (rvo.getInfo() != null) {
			line = rowCount + "   " + line + "    " + rvo.getInfo();
			rvo.setInfo(line);
			return rvo;
		}

		line = rowCount + "   " + line + "    �ɹ�";
		rvo.setInfo(line);
		rvo.setOk(true);
		return rvo;
	}

}