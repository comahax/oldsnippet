package com.sunrise.boss.ui.cms.costcard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.costcard.CostcardDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.personalbusi.PersonalbusiDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	CostcardDelegate delegate;

	private boolean isNew = true;

	public BatchTaskBean() {
		try {
			batchName = "���������ֵ��������������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	private CostcardDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new CostcardDelegate();
		} else {
			return delegate;
		}
	}

	public String doStart() {
		return "˳���|��������|�����·ݣ�YYYYMM��|ҵ����|��������(��)|�Ƿ�ɹ�" + "\r\n";
	}
	   /**
     * �����ļ���Ͻ��еĲ���
     * @throws Exception
     */
    public String doEnd() throws Exception {
        return "";
    }
	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount,User user) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		CostcardVO vo = new CostcardVO();
		try {
			vo.setWayid(items[0].trim());
			vo.setCalcmonth(items[1].trim());
			OperationDelegate operationDelegate = new OperationDelegate();
			OperationVO operationVO = operationDelegate.doFindByPk(items[2],
					user);
			if (operationVO == null) {
				throw new Exception("ҵ�������Ϣ���룺" + items[2] + "������");
			} else if (operationDelegate.getParentlevel(operationVO, user) != 4) {
				throw new Exception("ҵ�������Ϣ�������ѡ����弶");
			}
			vo.setOpnid(items[2].trim());

			vo.setSalenum(new Integer(items[3].trim()));
			isNew = findByUPK(items[0].trim(), items[1].trim(),
					items[2].trim(), user);
			if (isNew) {
				getDelegate().doCreate(vo, user);
			} else {
				getDelegate().doUpdate(vo, user);
			}
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
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			if(isNew){
				resultStr.append("�����ɹ�");
			}else
			{
				resultStr.append("�޸ĳɹ�");
			}
		} else {
			resultStr.append("����ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private boolean findByUPK(String wayid, String calcmonth, String opnid,
			User user) throws Exception {
		CostcardListVO listVO = new CostcardListVO();
		listVO.set_se_wayid(wayid);
		listVO.set_se_calcmonth(calcmonth);
		listVO.set_se_opnid(opnid);
		return (getDelegate().doQuery(listVO, user).getRowCount() <= 0);
	}
}
