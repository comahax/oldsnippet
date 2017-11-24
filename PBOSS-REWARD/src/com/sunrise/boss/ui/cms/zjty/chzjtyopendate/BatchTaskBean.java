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
		super.setBatchName("服务厅交接日期设置");
		super.setWriteLog(true);
		delegate = new ChZjtyOpendateDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		return "批量导入结果 \r\n";
	}

	/**
	 * 处理一条记录
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
					throw new Exception("相同记录已存在："+items[0]);
				}
				newvo.setWayid(items[0]);
				SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
				java.util.Date dt=df.parse(items[1]);
				newvo.setOpendate(dt);
				newvo.setMemo(items[2]);
				delegate.doCreate(newvo, user);
			} else {
				if (dbvo==null) {
					throw new Exception("根据相对应的记录查找不到需要修改/删除的记录");
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
			line = rowCount + " " + line + "  新增成功";
			}else if(this.operType==1)
			{
				line = rowCount + " " + line + "    修改成功";
			}
			else if(this.operType==2)
			{
				line = rowCount + " " + line + "    删除成功";
			}
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				line = rowCount + "   " + line + "    错误信息:" + e.getMessage()
						+ "应该是数字";
			} else {
				e.printStackTrace();
				line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			}
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
