package com.sunrise.boss.ui.cms.personalbusi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.personalbusi.PersonalbusiDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	PersonalbusiDelegate delegate;
	public BatchTaskBean() {
		try {
			delegate = new PersonalbusiDelegate();
			batchName = "����ҵ����������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "˳���|����|��������|ҵ�������Ϣ����|Ʒ��|����ʱ��|��������|�Ƿ�ɹ�" + "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = line.split("\\|");
		PersonalbusiVO vo = new PersonalbusiVO();
		try {

			vo.setMobile(items[0].trim());
			vo.setWayid(items[1].trim());
			OperationDelegate operationDelegate = new OperationDelegate();
			OperationVO operationVO = operationDelegate.doFindByPk(items[2], user);
			if(operationVO == null){
				throw new Exception("ҵ�������Ϣ���룺" + items[2] + "������");
			}else if(operationDelegate.getParentlevel(operationVO, user) != 4){
				throw new Exception("ҵ�������Ϣ�������ѡ����弶");
			}
			vo.setOpntype(items[2].trim());
			vo.setBrand(new Long(items[3].trim()));
			DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt=fm.parse(items[4].trim());
			vo.setOpntime(dt);
			vo.setOprtype(items[5].trim());
			delegate.doCreate(vo, user);
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]);
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�����ɹ�");
		} else {
			resultStr.append("����ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}

