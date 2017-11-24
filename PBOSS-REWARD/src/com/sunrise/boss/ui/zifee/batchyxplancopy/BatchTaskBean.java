package com.sunrise.boss.ui.zifee.batchyxplancopy;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * @author zengjianxin
 */
public class BatchTaskBean extends BaseBatchTaskBean {
	YxPlanDelegate delegate;

	public BatchTaskBean() {
		try {
			delegate = new YxPlanDelegate();
			batchName = "Ӫ��������������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		BatchYxplanCopyForm batchyxplancopyForm = (BatchYxplanCopyForm) form;
		return "��� | ģ��Ӫ��������ʶ | ��Ӫ��������ʶ | ��Ӫ���������� | ����ʱ�� | ͣ��ʱ�� | Ӫ������˵�� | ��Ҫ���Ƶ���ϸ�� | �������� | ������� | �����������"
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "����";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		YxPlanVO vo = new YxPlanVO();
		try {
			vo = delegate.doFindByPk(new Long(items[0]), user);
			if (vo == null) {
				throw new Exception("ģ��Ӫ��������ʶ������!");
			}
			if (user.getCityid() == null || "".equals(user.getCityid())) {
				throw new Exception("��ǰ��½���ŵ������ʶΪ�գ�Ҫ����Ϊ��!");
			}
			String yxplanid=null;
			if (isNull(items[1].trim())) {
//				String seq = delegate.getYxplanSeq(user).toString();
//				yxplanid = user.getCityid()+ StringUtils.repeat("0", 11 - seq.length()) + seq;
				yxplanid=delegate.doGetYxplanID(user).toString();
			}else{
				yxplanid = items[1];
			}
			vo.setYxplanid(new Long(yxplanid));
			vo.setYxplanname(items[2]);// Ӫ����������
			vo.setAreacode(user.getCityid());// �����ʶ
			vo.setOperatorcode(user.getOpercode());// ��������
			vo.setCheckercode(user.getOpercode());// ��˹���
			vo.setStartdate(isNull(items[3].trim()) ? null : format
					.parse(items[3]));// ����ʱ��
			vo.setStopdate(isNull(items[4].trim()) ? null : format
					.parse(items[4]));// ͣ��ʱ��
			vo.setRemark(items[5]);// Ӫ������˵��

			String list = "";
			AuditUtils auditutils = new AuditUtils();

			if ("*".equals(items[6].trim())) {
				CommonDelegate dictitemDelegate = new CommonDelegate(
						DictitemVO.class);
				DictitemListVO listvo = new DictitemListVO();
				listvo.set_se_groupid("PC_YXPLANCOPYITEM");
				listvo.set_pagesize("");
				DataPackage dataPack = dictitemDelegate.doQuery(listvo, user);
				dataPack.setPageSize(40);
				if (dataPack.getRowCount() >= 0) {
					Collection col = dataPack.getDatas();
					Iterator it = col.iterator();
					for (int i = 0; i < dataPack.getRowCount(); i++) {
						list = list + ((DictitemVO) it.next()).getDictid()
								+ ",";
					}
					list = list.substring(0, list.length() - 1);
				}
			} else {
				String[] lists = StringUtils.splitPreserveAllTokens(items[6],
						",");
				for (int i = 0; i < lists.length; i++) {
					if (!auditutils.doCheckSystemParam("PC_YXPLANCOPYITEM",
							lists[i], user)) {
						throw new Exception("������ϸ���ִ��к����޷�ƥ��ĸ�����ϸ" + lists[i]);
					}
				}
				list = items[6];
			}

			delegate.doSinglecopy(items[0], list, vo, false,filename, user);

			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op,yxplanid));
			return resultVO;

		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op , "") + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op,String newyxplanid) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(newyxplanid).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);

		resultStr.append(op);
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

	private boolean isNull(String item) {
		return "".equals(item) || "null".equals(item) || "��".equals(item);
	}
}
