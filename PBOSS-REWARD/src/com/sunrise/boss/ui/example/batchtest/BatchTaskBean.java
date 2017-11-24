package com.sunrise.boss.ui.example.batchtest;

import org.apache.commons.lang.*;

import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {

	private Short oprtype;

	public BatchTaskBean() {
		try {
			// delegate = new OrdinaryTableDelegate(RobnumresVO.class,
			// RobnumreslogVO.class);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		BatchtestForm batchtestForm=(BatchtestForm)form;
		oprtype=batchtestForm.getOprtype();
		//oprtype=new Short(parameterMap.get("oprtype").toString());
		return "��� | ���� | �������� | ������� | ״̬ | ������ | ������Ϣ"+"\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String mobileno;
		String[] items = line.split("\\|");
		mobileno = items[0];
		String channel = items[1];
		Short status = new Short(items[2]);
		try {
			if (oprtype.shortValue() == 0) { // ����
				doInsert(mobileno, channel, status);
			}
			if (oprtype.shortValue() == 3) { // ɾ��
				doDelete(mobileno, channel, status);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
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
		// ����
		resultStr.append(items[0]).append(COMPART);
		// ��������
		if (oprtype.shortValue() == 0) {
			resultStr.append("����");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("ɾ��");
		}
		resultStr.append(COMPART);
		// �������
		resultStr.append(items[1]).append(COMPART);
		// ״̬
		resultStr.append(items[2]).append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void doDelete(String mobileno, String channel, Short status)
			throws Exception {
		// RobnumresVO robnumresVO = (RobnumresVO)
		// delegate.doFindByPk(mobileno,"");
		// if (robnumresVO == null) {
		// throw new Exception("�Ҳ�����Ӧ�ļ�¼,���������������");
		// }
		// robnumresVO = new RobnumresVO();
		// robnumresVO.setMobileno(mobileno);
		// robnumresVO.setChannel(channel);
		// robnumresVO.setStatus(status);
		//
		// RobnumreslogVO logVO = new RobnumreslogVO();
		// logVO.setLogid(new Long(Sequence.getSequence()));
		// logVO.setMobileno(mobileno);
		// logVO.setChannel(channel);
		// logVO.setStatus(status);
		// logVO.setOprcode(user.getOpercode());
		// logVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// logVO.setWayid(user.getWayid());
		// logVO.setOprtype(oprtype);
		// delegate.doRemoveByVO(robnumresVO, logVO, user.getOpercode());
	}

	/**
	 * �����¼
	 * 
	 */
	private void doInsert(String mobileno, String channel, Short status)
			throws Exception {
		if(mobileno.equals("13800138000")){//for test Exception
			throw new Exception("����״̬��Ч");
		}
		// RobnumresVO oldRobnumresVO = (RobnumresVO)
		// delegate.doFindByPk(mobileno,"");
		// RobnumresVO newRobnumresVO = new RobnumresVO();
		// newRobnumresVO.setMobileno(mobileno);
		// newRobnumresVO.setChannel(channel);
		// newRobnumresVO.setStatus(status);
		//		
		// RobnumreslogVO logVO = new RobnumreslogVO();
		// logVO.setLogid(new Long(Sequence.getSequence()));
		// logVO.setMobileno(mobileno);
		// logVO.setChannel(channel);
		// logVO.setStatus(status);
		// logVO.setOprcode(user.getOpercode());
		// logVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// logVO.setWayid(user.getWayid());
		//		
		// if (oldRobnumresVO == null) {//����
		// logVO.setOprtype(new Short(ADD)); //0:����
		// delegate.doCreate(newRobnumresVO, logVO, user.getOpercode()); // ������
		// }else{ //����
		// RobnumreslogVO oldLogVO = new RobnumreslogVO();
		// oldLogVO.setLogid(new Long(Sequence.getSequence()));
		// oldLogVO.setMobileno(oldRobnumresVO.getMobileno());
		// oldLogVO.setChannel(oldRobnumresVO.getChannel());
		// oldLogVO.setStatus(oldRobnumresVO.getStatus());
		// oldLogVO.setOprcode(user.getOpercode());
		// oldLogVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// oldLogVO.setWayid(user.getWayid());
		// oldLogVO.setOprtype(new Short(BEFOREUPDATE));//1:�޸�ǰ
		// logVO.setOprtype(new Short(AFTERUPDATE)); //2:�޸ĺ�
		// delegate.doUpdate2(newRobnumresVO,oldLogVO,logVO,
		// user.getOpercode());
		// }
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}

}
