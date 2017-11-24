package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;
import com.sunrise.boss.delegate.cms.zjty.chzjtyopendate.ChZjtyOpendateDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8377905096558740961L;

	private ChZjtyOpendateDelegate delegate;

	private int operType = 0;

	public BatchTaskBean() throws Exception {
		super.setBatchName("������������������");
		super.setWriteLog(true);
		delegate = new ChZjtyOpendateDelegate();
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
			ChZjtyOpendateVO newvo = new ChZjtyOpendateVO();
			ChZjtyOpendateVO dbvo = null;
			dbvo=(ChZjtyOpendateVO)delegate.doFindByPk(items[0], user);
			if (this.operType == 0) {
				if(dbvo!=null)
				{
					throw new Exception("��ͬ��¼�Ѵ��ڣ�"+items[0]);
				}
				newvo.setWayid(items[0]);
				SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
				java.util.Date dt=df.parse(items[1]);
				newvo.setOpendate(dt);
				newvo.setMemo(items[2]);
				delegate.doCreate(newvo, user);
			} else {
				if (dbvo==null) {
					throw new Exception("�������Ӧ�ļ�¼���Ҳ�����Ҫ�޸�/ɾ���ļ�¼");
				} else {
					if (this.operType == 1) {
						SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
						java.util.Date dt=df.parse(items[1]);
						dbvo.setOpendate(dt);
						dbvo.setOpendate(dt);
						dbvo.setMemo(items[2]);
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
				e.printStackTrace();
				line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			}
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
