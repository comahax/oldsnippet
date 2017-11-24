package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.zjty.chzjtyempltotal.ChZjtyEmpltotalDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {

	private int operType = 0;

	public BatchTaskBean() throws Exception {
		super.setBatchName("��Ա�˶�������������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		return "���������� \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		String[] propertyname = new String[] { "yearmonth", "wayid", "amount",
				"memo" };
		ResultVO resultVO = new ResultVO();
		try {
			// resultVO.setInfo(line);
			String[] items = StringUtils.splitPreserveAllTokens(line, "|");
			for (int i = 0; i < items.length; i++) {
				items[i] = items[i].trim();
			}
			ChZjtyEmpltotalDelegate delegate = new ChZjtyEmpltotalDelegate();
			ChZjtyEmpltotalVO newvo = new ChZjtyEmpltotalVO();
			ChZjtyEmpltotalVO dbvo = new ChZjtyEmpltotalVO();
			ChZjtyEmpltotalVO listvo = new ChZjtyEmpltotalVO();
			listvo.setYearmonth(items[0]);
			listvo.setWayid(items[1]);
			dbvo = delegate.doFindByPk(listvo, user);

			if (this.operType == 0) {
				newvo.setYearmonth(items[0]);
				newvo.setWayid(items[1]);
				newvo.setAmount(new Double(items[2]));
				newvo.setMemo(items[3]);
				if(dbvo==null)
				{
				 delegate.doCreate(newvo, user);
				}
				else
				{
				 this.operType=1;
				 delegate.doUpdate(newvo, user);
				}
			} else {
				if (dbvo==null) {
					throw new Exception("�������Ӧ�ļ�¼���Ҳ�����Ҫ����/�޸�/ɾ���ļ�¼");
				} else {
					if (this.operType == 1) {
						dbvo.setMemo(items[3]);
						dbvo.setAmount(new Double(items[2]));
						delegate.doUpdate(dbvo, user);
					} else if (this.operType == 2) {
						delegate.doRemove(dbvo, user);
					}
				}
			}
			if(this.operType==0)
			{
			line = rowCount + " " + line + "  �����ɹ�";
			}else if(this.operType==1)
			{
				line = rowCount + " " + line + "    �޸ĳɹ�";
			}
			else if(this.operType==2)
			{
				line = rowCount + " " + line + "    ɾ���ɹ�";
			}
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage()
						+ "Ӧ��������";
			} else {
				line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			}
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
