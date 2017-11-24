package com.sunrise.boss.ui.zifee.minconsume;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.zifee.minconsume.MinconsumeDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	MinconsumeDelegate delegate;

	private boolean isNew = true;

	private int batchaction = 0;

	public BatchTaskBean() {
		try {
			batchName = "��������Ż���������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	private MinconsumeDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new MinconsumeDelegate();
		} else {
			return delegate;
		}
	}

	public String doStart() {
		this.batchaction = Integer.parseInt(parameterMap.get("batchaction")
				.toString());
		if(this.batchaction!=2)
		{
		return "˳���|Ӫ��������ʶ|��Чʱ����|������ѿ�Խ����|�������������|���������Ч����|������Ѷ�|�Ƿ�ɹ�"
				+ "\r\n";
		}else
		{
			return "";
		}
	}

	/**
	 * �����ļ���Ͻ��еĲ���
	 * 
	 * @throws Exception
	 */
	public String doEnd() throws Exception {
			return "";
	}

	/*
	 * yxplanid=Ӫ��������ʶ effectiveinterval=��Чʱ���� consumecycle=������ѿ�Խ����
	 * cyclecount=������������� effectivetype=���������Ч���� minconsume=������Ѷ�
	 * Ӫ��������ʶ|��Чʱ����|������ѿ�Խ����|�������������|���������Ч����|������Ѷ�
	 * 
	 */
	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			if (rowCount == 1 && this.batchaction == 2) {
				resultVO.setInfo("�Զ����ļ�ͷ:" + line);
				resultVO.setOk(true);
				ok--;
				countrecord--;
				return resultVO;
			}
			MinconsumeVO vo = new MinconsumeVO();
			MinconsumeVO oldVO = findByPK(items);
			this.isNew = oldVO == null;
			if (batchaction == 0) {
				if (!isNew) {
					throw new Exception("�ü�¼�Ѿ�����,����������!");
				}
				vo.setYxplanid(CheckUtil.setLong(items[0]));
				vo.setEffectiveinterval(CheckUtil.setInteger(items[1]));
				vo.setConsumecycle(CheckUtil.setLong(items[2]));
				vo.setCyclecount(CheckUtil.setInteger(items[3]));
				vo.setEffectivetype(CheckUtil.dealString(items[4]));
				vo.setMinconsume(CheckUtil.setDouble(items[5]));
				getDelegate().doCreate(vo, user);
			} else if (batchaction == 1) {
				if (isNew) {
					throw new Exception("�ü�¼������,���ܽ����޸�!");
				}
				MinconsumeVO newVO = buildVO(items);
				BeanUtils.copyProperties(oldVO, newVO, false);
				getDelegate().doUpdate(oldVO, user);
			} else if (batchaction == 2) {
				if (isNew) {
					throw new Exception("�ü�¼������,���ܽ����޸�!");
				}
				items = CheckUtil.checkLines(items, user);
				MinconsumeVO newVO = buildVO(items);
				BeanUtils.copyProperties(oldVO, newVO, false);
				getDelegate().doUpdate(oldVO, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	private MinconsumeVO buildVO(String[] items) throws Exception {
		MinconsumeVO newVO = new MinconsumeVO();
		newVO.setYxplanid(CheckUtil.setNullLong(items[0]));
		newVO.setEffectiveinterval(CheckUtil.setNullInteger(items[1]));
		newVO.setConsumecycle(CheckUtil.setNullLong(items[2]));
		newVO.setCyclecount(CheckUtil.setNullInteger(items[3]));
		newVO.setEffectivetype(CheckUtil.dealString(items[4]));
		newVO.setMinconsume(CheckUtil.setNullDouble(items[5]));
		return newVO;
	}

	private MinconsumeVO findByPK(String[] items) throws Exception {
		MinconsumeVO pkVO = new MinconsumeVO();
		pkVO.setYxplanid(CheckUtil.setLong(items[0]));
		pkVO.setEffectiveinterval(CheckUtil.setInteger(items[1]));
		return getDelegate().doFindByPk(pkVO, user);
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		if (batchaction != 2) {
			for (int i = 0; i < 6; i++) {
				if (items[i] != null) {
					resultStr.append(items[i]).append(COMPART);
				}
			}
		}
		else if(batchaction==2)
		{
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null) {
					resultStr.append(items[i]).append(COMPART);
				}
			}
		}
		// ������
		if (resultVO.isOk()) {
			if (batchaction==0) {
				resultStr.append("�����ɹ�");
			} else {
				resultStr.append("�޸ĳɹ�");
			}
		} else {
			if (batchaction==0) {
				resultStr.append("����ʧ��");
			} else {
				resultStr.append("�޸�ʧ��");
			}
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}
