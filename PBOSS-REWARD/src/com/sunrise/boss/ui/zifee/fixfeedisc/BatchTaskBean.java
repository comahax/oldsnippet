package com.sunrise.boss.ui.zifee.fixfeedisc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.fee.woff.acct.AcctDelegate;
import com.sunrise.boss.delegate.zifee.fixfeedisc.FixfeediscDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private static Log log = LogFactory.getLog(BatchTaskBean.class);

	private FixfeediscDelegate delegate;

	private final String SEPARATOR = "|";

	/*
	 * �������ͣ�0������1�޸ġ�2ɾ����
	 */
	private int operType = 0;

	public BatchTaskBean() {
		try {
			delegate = new FixfeediscDelegate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String doStart() {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (log.isDebugEnabled())
			log.debug("=====================�������ͣ�" + this.operType
					+ "��0������1�޸ġ�2ɾ����================");
		if (this.operType == 0)
			return "Ӫ��������ʶ|�ʵ���Ŀ��ʶ|�Żݷ�ʽ|�ۿ�|Ӧ�Żݽ��|״̬|" + "\r\n";
		else
			return "�̶����Żݱ�ʶ|Ӫ��������ʶ|�ʵ���Ŀ��ʶ|�Żݷ�ʽ|�ۿ�|Ӧ�Żݽ��|״̬|" + "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (log.isDebugEnabled())
			log.debug("=====================" + rowCount + "��" + line
					+ "================");
		String[] items = line.split("\\|");
		ResultVO resultVO = new ResultVO();
		String state = "ʧ��";
		resultVO.setOk(false);
		try {
			if (this.operType == 0) {
				if (!isYxPlanIdExist(items, user))
					throw new BusinessException("", "�����ڸ�Ӫ��������ʶ��");
				if (!isAcctIdExist(items, user))
					throw new BusinessException("", "�����ڸ��˵���Ŀ��ʶ��");
				if (isExist(items, user))
					throw new BusinessException("", "�Ѵ�����ͬ��Ӫ���������˵���Ŀ�ļ�¼��");
				PcPsFixfeediscVO vo = new PcPsFixfeediscVO();
				vo.setYxplanid(new Long(items[0].trim()));
				vo.setAcctid(new Long(items[1].trim()));
				vo.setDisctype(new Long(items[2].trim()));
				vo.setRecdisamt(new Float(items[4].trim()));
				vo.setDisccount(new Float(items[3].trim()));
				delegate.doCreate(vo, user);
				resultVO.setOk(true);
				state = "�ɹ�";
			} else if (this.operType == 1) {
				if (!isYxPlanIdExist(items, user))
					throw new BusinessException("", "�����ڸ�Ӫ��������ʶ��");
				PcPsFixfeediscVO vo = delegate.doFindByPk(new Long(items[0].trim()),
						user);
				if (vo == null)
					throw new BusinessException("", "�����ڸù̶����Żݼ�¼��");
				if (!vo.getYxplanid().toString().equals(items[1].trim()))
					throw new BusinessException("", "�޸ļ�¼��Ӫ��������ʶ["
							+ vo.getYxplanid().toString() + "]���ı��ļ��ڵ�Ӫ��������ʶ["
							+ items[1] + "]��һ�£�");
				vo.setAcctid(new Long(items[2].trim()));
				vo.setDisctype(new Long(items[3].trim()));
				vo.setDisccount(new Float(items[4].trim()));
				vo.setRecdisamt(new Float(items[5].trim()));
				delegate.doUpdate(vo, user);
				resultVO.setOk(true);
				state = "�ɹ�";
			}
		} catch (BusinessException be) {
			state = "ʧ�ܣ�" + be.getMessage();
		} catch (Exception e) {
			state = "ʧ��"+e.getMessage();
		}
		StringBuffer sb = genOptInfo(rowCount, items, state);
		resultVO.setInfo(sb.toString());
		return resultVO;
	}

	private StringBuffer genOptInfo(int rowCount, String[] items, String state) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i]);
			sb.append(SEPARATOR);
		}
		sb.append(state);
		sb.append(SEPARATOR);
		return sb;
	}

	/*
	 * ���Ӫ��������ʶ�Ƿ�Ϸ��������ֶ����ͼ��ʹ����Լ�飩
	 */
	private boolean isYxPlanIdExist(String[] items, User user) throws Exception {
		YxPlanDelegate yxPlanDelegate = new YxPlanDelegate();
		Object obj = yxPlanDelegate.doFindByPk(new Long(items[this.operType].trim()),
				user);
		if (obj != null)
			return true;
		else
			return false;
	}

	/*
	 * ����˵���Ŀ��ʶ�Ƿ�Ϸ��������ֶ����ͼ��ʹ����Լ�飩
	 */
	private boolean isAcctIdExist(String[] items, User user) throws Exception {
		AcctDelegate acctDelegate = new AcctDelegate();
		Object obj = acctDelegate.doFindByPk(
				new Long(items[this.operType + 1].trim()), user);
		if (obj != null)
			return true;
		else
			return false;
	}

	/*
	 * ����Ƿ������ͬ��Ӫ���������˵���Ŀ�ļ�¼
	 */
	private boolean isExist(String[] items, User user) throws Exception {
		PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
		listVO.set_pagesize(null);
		listVO.set_pageno(null);
		listVO.set_ne_yxplanid(items[0].trim());
		listVO.set_ne_acctid(items[1].trim());
		DataPackage datas = delegate.doQuery(listVO, user);
		if (datas.getRowCount() > 0)
			return true;
		else
			return false;
	}

}
