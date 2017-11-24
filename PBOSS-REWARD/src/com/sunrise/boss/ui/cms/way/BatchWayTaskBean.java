package com.sunrise.boss.ui.cms.way;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchWayTaskBean extends BaseBatchTaskBean {
	private static WayDelegate delegate = null;

	private String flag = "";

	private static WayDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new WayDelegate();
		} else {
			return delegate;
		}
	}

	public BatchWayTaskBean() {
		try {
			delegate = new WayDelegate();
			batchName = "������Ϣ����";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "���|��������|��������|�ϼ�����|Ӫҵ���ʶ|�Ƿ���|�������|���������|�ֹ�˾�Զ�������������|���м���|�����ȼ�|����MIS����|��ҵ��Դ����|�Ƿ�����|������ʽ|��Ӫģʽ|�Ƿ���������|�Ǽ�|������|�����ܵ����|ǩԼ״̬|Ӫҵ��Ա����|������Ա����|�ն�����|γ��|����|����״̬|�����м����|��Ӫ��־"
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = line.split("\\|");
		// ȥ�ո�

		WayVO wayVO = new WayVO();
		try {
			// �������������Ϣ
			wayVO = getDelegate().doFindByPk(items[0].trim(), user);
			if (wayVO == null) {
				// ����
				wayVO = new WayVO();
				flag = "����";
				buildVO(wayVO, items);
				getDelegate().doCreate(wayVO, user);
			} else {
				// �޸�
				flag = "�޸�";
				buildVO(wayVO, items);
				delegate.doUpdate(wayVO, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			ex.printStackTrace();
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
		resultStr.append(items[15]).append(COMPART);
		resultStr.append(items[16]).append(COMPART);
		resultStr.append(items[17]).append(COMPART);
		resultStr.append(items[18]).append(COMPART);
		resultStr.append(items[19]).append(COMPART);
		resultStr.append(items[20]).append(COMPART);
		resultStr.append(items[21]).append(COMPART);
		resultStr.append(items[22]).append(COMPART);
		resultStr.append(items[23]).append(COMPART);
		resultStr.append(items[24]).append(COMPART);
		resultStr.append(items[25]).append(COMPART);
		resultStr.append(items[26]).append(COMPART);
		resultStr.append(items[27]).append(COMPART).append(flag);
		// ������
		if (resultVO.isOk()) {
			resultStr.append(" �ɹ�");
		} else {
			resultStr.append(" ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void buildVO(WayVO wayVO, String[] items) throws Exception {
		// \��������0
		if (!isEmpty(items[0]))
			wayVO.setWayid(items[0].trim());
		// \��������1
		if (!isEmpty(items[1]))
			wayVO.setWayname(items[1].trim());
		// �ϼ���������2 �ϼ������������޸�
		if (!isEmpty(items[2]) && "����".equals(flag)) {
			wayVO.setUpperwayid(items[2].trim());
			WayVO tempVO = getDelegate().doFindByPk(items[2].trim(), user);
			if (tempVO != null) {
				if (tempVO.getCenterid() != null) {
					wayVO.setCenterid(tempVO.getCenterid());
				}
				if (tempVO.getCityid() != null) {
					wayVO.setCityid(tempVO.getCityid());
				}
				if (tempVO.getCountyid() != null) {
					wayVO.setCountyid(tempVO.getCountyid());
				}
			}
		} else if (!isEmpty(items[2]) && "�޸�".equals(flag)
				&& !items[2].trim().equals(wayVO.getUpperwayid())) {
			throw new Exception("�����ϼ������ݲ��ṩ�޸�");
		}
		// Ӫҵ���ʶ3
		if (!isEmpty(items[3]))
			wayVO.setBusicode(items[3].trim());
		// \�Ƿ���4??
		if (!isEmpty(items[4]))
			wayVO.setIsshare(items[4].trim());
		// \ �������5
		if (!isEmpty(items[5]))
			wayVO.setWaytype(items[5].trim());
		// \ ���������6
		if (!isEmpty(items[6]))
			wayVO.setWaysubtype(items[6].trim());
		// �ֹ�˾�Զ�������������7
		if (!isEmpty(items[7]))
			wayVO.setCusttype(items[7].trim());
		// // \ ��������8
		// if (!isEmpty(items[8]))
		// wayVO.setCenterid(items[8].trim());
		// // \ �й�˾9
		// if (!isEmpty(items[9]))
		// wayVO.setCityid(items[9].trim());
		// // �ع�˾10
		// if (!isEmpty(items[10]))
		// wayVO.setCountyid(items[10].trim());
		// ���м���11
		if (!isEmpty(items[8]))
			wayVO.setCitylevel(new Short(items[8].trim()));
		// ��������12
		// if (!isEmpty(items[12]))
		// wayVO.setWaylevel(new Short(items[12].trim()));
		// �����ȼ�9
		if (!isEmpty(items[9]))
			wayVO.setBchlevel(items[9].trim());
		// ����MIS����10
		if (!isEmpty(items[10]))
			wayVO.setMiscode(items[10].trim());
		// ��ҵ��Դ����11
		if (!isEmpty(items[11]))
			wayVO.setPrtsource(new Long(items[11].trim()));
		// �Ƿ�����12---------------------------------------------------------------------
		if (!isEmpty(items[12]))
			wayVO.setIsconnected(new Long(items[12].trim()));
		// ������ʽ13
		if (!isEmpty(items[13]))
			wayVO.setConnecttype(new Long(items[13].trim()));
		// ��Ӫģʽ14
		if (!isEmpty(items[14]))
			wayVO.setRunmode(new Long(items[14].trim()));
		// �Ƿ���������15
		if (!isEmpty(items[15]))
			wayVO.setIscoreway(new Long(items[15].trim()));
		// �Ǽ�16
		if (!isEmpty(items[16]))
			wayVO.setStarlevel(new Long(items[16].trim()));
		// ������17
		if (!isEmpty(items[17]))
			wayVO.setPt(new Long(items[17].trim()));
		// �����ܵ����18
		if (!isEmpty(items[18]))
			wayVO.setChainhead(items[18].trim());
		// ǩԼ״̬19
		if (!isEmpty(items[19]))
			wayVO.setSignstatus(new Long(items[19].trim()));
		// Ӫҵ��Ա����20------------------------------------------------------
		if (!isEmpty(items[20]))
			wayVO.setEmpnumber(new Long(items[20].trim()));
		// ������Ա����21
		if (!isEmpty(items[21]))
			wayVO.setMagnumber(new Long(items[21].trim()));
		// �ն�����22
		if (!isEmpty(items[22]))
			wayVO.setTerminumber(new Long(items[22].trim()));
		// \ γ��23
		if (!isEmpty(items[23]))
			wayVO.setLatitude(items[23].trim());
		// \ ����24
		if (!isEmpty(items[24]))
			wayVO.setLongtitude(items[24].trim());
		// \ ����״̬25
		if (!isEmpty(items[25]))
			wayVO.setWaystate(new Short(items[25].trim()));
		if (isEmpty(items[25]) && "����".equals(flag)) {
			wayVO.setWaystate(new Short("1"));
		}
		// �����м����26
		if (!isEmpty(items[26]))
			wayVO.setDepotdet(items[26].trim());
		// \ ��Ӫ��־31
		if (!isEmpty(items[27])) {
			wayVO.setRunbyself(items[27].trim());
		}
	}

	private boolean isEmpty(String item) throws Exception {
		return StringUtils.isEmpty(item.trim());
	}
}
