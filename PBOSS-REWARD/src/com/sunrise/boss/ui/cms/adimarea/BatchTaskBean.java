package com.sunrise.boss.ui.cms.adimarea;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BatchTaskBean extends BaseBatchTaskBean {
	AdimareaDelegate delegate;

	public BatchTaskBean() {
		try {
			delegate = new AdimareaDelegate();
			batchName = "������������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "������������ | ������������ | �����������ͱ��� | ��������������� | �ϼ������������� | ����ͳ����� | Ͻ���˿��� | ��ס�˿��� | �����˿��� | Ͻ����� | Ͻ���˾���֧������ | Ͻ���ƶ��û��� | Ͻ����ͨ�û��� | Ͻ�������û��� | Ͻ���ƶ��绰�û���"
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		AdimareaVO vo = new AdimareaVO();

		try {
			AdimareaVO oldvo = delegate.doFindByPk(items[0], user);
			if (oldvo == null) {// ����

				vo.setAdacode(items[0]);
				vo.setAdaname(items[1]);
				if (items[2] != null && !"".equals(items[2])) {
					vo.setAdatype(new Short(items[2]));
				}
				if (items[3] != null && !"".equals(items[3])) {
					vo.setAdalevel(new Short(items[3]));
				}
				vo.setUppercode(items[4]);
				vo.setDatayear(items[5]);
				vo.setStatus(new Byte("1"));
				if (items[6] != null && !"".equals(items[6])) {
					vo.setTotalppn(new Long(items[6]));
				}
				if (items[7] != null && !"".equals(items[7])) {
					vo.setResippn(new Long(items[7]));
				}
				if (items[8] != null && !"".equals(items[8])) {
					vo.setNonresippn(new Long(items[8]));
				}
				if (items[9] != null && !"".equals(items[9])) {
					vo.setAdarea(new Long(items[9]));
				}
				if (items[10] != null && !"".equals(items[10])) {
					vo.setAvgincome(new Long(items[10]));
				}
				if (items[11] != null && !"".equals(items[11])) {
					vo.setGmccusers(new Long(items[11]));
				}
				if (items[12] != null && !"".equals(items[12])) {
					vo.setCucusers(new Long(items[12]));
				}
				if (items[13] != null && !"".equals(items[13])) {
					vo.setCtcusers(new Long(items[13]));
				}
				if (items[14] != null && !"".equals(items[14])) {
					vo.setHandphones(new Long(items[14].trim()));
				}

				delegate.doCreate(vo, user);
			} else {// �޸�
//				if (items[0] != null && !items[0].equals("")) {
//					oldvo.setAdacode(items[0]);
//				}
//				if (items[1] != null && !items[1].equals("") && !"null".equals(items[1]) && !"��".equals(items[1])) {
//					oldvo.setAdaname(items[1]);
//				}else if ("null".equals(items[1]) || "��".equals(items[1])) {
//					oldvo.setAdaname(null);
//				}
//				if (items[2] != null && !items[2].equals("") && !"null".equals(items[2]) && !"��".equals(items[2])) {
//					oldvo.setAdatype(new Short(items[2]));
//				}else if ("null".equals(items[2]) || "��".equals(items[2])) {
//					oldvo.setAdatype(null);
//				}
//				if (items[3] != null && !items[3].equals("") && !"null".equals(items[3]) && !"��".equals(items[3])) {
//					oldvo.setAdalevel(new Short(items[3]));
//				}else if ("null".equals(items[3]) || "��".equals(items[3])) {
//					oldvo.setAdalevel(null);
//				}
//				if (items[4] != null && !items[4].equals("") && !"null".equals(items[4]) && !"��".equals(items[4])) {
//					oldvo.setUppercode(items[4]);
//				}else if ("null".equals(items[4]) || "��".equals(items[4])) {
//					oldvo.setUppercode(null);
//				}
//				if (items[5] != null && !items[5].equals("") && !"null".equals(items[5]) && !"��".equals(items[5])) {
//					oldvo.setDatayear(items[5]);
//				}else if ("null".equals(items[5]) || "��".equals(items[5])) {
//					oldvo.setDatayear(null);
//				}
//				if (items[6] != null && !items[6].equals("") && !"null".equals(items[6]) && !"��".equals(items[6])) {
//					oldvo.setTotalppn(new Long(items[6]));
//				}else if ("null".equals(items[6]) || "��".equals(items[6])) {
//					oldvo.setTotalppn(null);
//				}
//				if (items[7] != null && !items[7].equals("") && !"null".equals(items[7]) && !"��".equals(items[7])) {
//					oldvo.setResippn(new Long(items[7]));
//				}else if ("null".equals(items[7]) || "��".equals(items[7])) {
//					oldvo.setResippn(null);
//				}
//				if (items[8] != null && !items[8].equals("") && !"null".equals(items[8]) && !"��".equals(items[8])) {
//					oldvo.setNonresippn(new Long(items[8]));
//				}else if ("null".equals(items[8]) || "��".equals(items[8])) {
//					oldvo.setNonresippn(null);
//				}
//				if (items[9] != null && !items[9].equals("") && !"null".equals(items[9]) && !"��".equals(items[9])) {
//					oldvo.setAdarea(new Long(items[9]));
//				}else if ("null".equals(items[9]) || "��".equals(items[9])) {
//					oldvo.setAdarea(null);
//				}
//				if (items[10] != null && !items[10].equals("") && !"null".equals(items[10]) && !"��".equals(items[10])) {
//					oldvo.setAvgincome(new Long(items[10]));
//				}else if ("null".equals(items[10]) || "��".equals(items[10])) {
//					oldvo.setAvgincome(null);
//				}
//				if (items[11] != null && !items[11].equals("") && !"null".equals(items[11]) && !"��".equals(items[11])) {
//					oldvo.setGmccusers(new Long(items[11]));
//				}else if ("null".equals(items[11]) || "��".equals(items[11])) {
//					oldvo.setGmccusers(null);
//				}
//				if (items[12] != null && !items[12].equals("") && !"null".equals(items[12]) && !"��".equals(items[12])) {
//					oldvo.setCucusers(new Long(items[12]));
//				}else if ("null".equals(items[12]) || "��".equals(items[12])) {
//					oldvo.setCucusers(null);
//				}
//				if (items[13] != null && !items[13].equals("") && !"null".equals(items[13]) && !"��".equals(items[13])) {
//					oldvo.setCtcusers(new Long(items[13]));
//				}else if ("null".equals(items[13]) || "��".equals(items[13])) {
//					oldvo.setCtcusers(null);
//				}
//				if (items[14] != null && !items[14].equals("") && !"null".equals(items[14]) && !"��".equals(items[14])) {
//					oldvo.setHandphones(new Long(items[14].trim()));
//				}else if ("null".equals(items[14]) || "��".equals(items[14])) {
//					oldvo.setHandphones(null);
//				}
//				delegate.doUpdate(oldvo, user);
				/**
				 *  ��ʱ��ֹ�޸� by xy
				 */
				
				throw new BusinessException("","�������������ظ���Ŀǰ�����������޸�.");
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
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);
		resultStr.append(items[7]).append(COMPART);
		resultStr.append(items[8]).append(COMPART);
		resultStr.append(items[9]).append(COMPART);
		resultStr.append(items[10]).append(COMPART);
		resultStr.append(items[11]).append(COMPART);
		resultStr.append(items[12]).append(COMPART);
		resultStr.append(items[13]).append(COMPART);
		resultStr.append(items[14]).append(COMPART);

		resultStr.append("����");
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}
