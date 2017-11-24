package com.sunrise.boss.ui.cms.operation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.AGWayDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private OperationDelegate delegate;
	public BatchTaskBean() {
		try {
			super.setWriteLog(true);
			super.setBatchName("ҵ����������");
			delegate = new OperationDelegate();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "��� | ҵ�����ͱ�ʶ |ҵ���������� | ������Ϣ" + "\r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "����";
		OperationVO vo = new OperationVO();
		try {
			if("0".equals(items[5])){
				vo.setName(items[1]);
				if("".equals(items[2])){
					vo.setParentid("0");
				}else{
					vo.setParentid(items[2]);
				}
				vo.setState(new Short(items[3]));
				vo.setRemark(items[4]);
				delegate.doCreate(vo, user);
			}else if("1".equals(items[5])){
				op = "�޸�";
				vo = delegate.doFindByPk(items[0], user);
				if(!"".equals(items[1])){
					vo.setName(items[1]);
				}
				if(!"".equals(items[2])){
					vo.setParentid(items[2]);
				}
				if(!"".equals(items[3])){
					vo.setState(new Short(items[3]));
				}
				if(!"".equals(items[4])){
					vo.setRemark(items[4]);
				}
				delegate.doUpdate(vo, user);
			}else if("2".equals(items[5])){
				op = "ɾ��";
				vo.setOpnid(items[0]);
				delegate.doRemove(vo, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(op);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
	
	private boolean isNull(String item){
		return "".equals(item)||"null".equals(item)||"��".equals(item);
	}

}
