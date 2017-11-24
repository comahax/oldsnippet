package com.sunrise.boss.ui.rightmanage.rightitem.batchin;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.rightmanage.common.RightInfo;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightVO;
import com.sunrise.boss.delegate.rightmanage.rightitem.RightitemDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class BatchinRightitemTaskBean extends BaseBatchTaskBean{
	protected String doStart() {
		return RightInfo.INSTANCE.getProperty("rightitembatchinfilehead") + "\r\n";
	}
	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {

		ResultVO resultVO = new ResultVO();
		String msg = "";
		String rightid;
		String[] items = StringUtils.split(line, "|");
		rightid = items[0];
		String rightname = items[1];
//		String sql = null;
		try {
			RightitemVO vo = new RightitemVO();
			vo.setRightid(rightid);
			vo.setRightname(rightname);
			vo.setIspublic(new Byte((String)parameterMap.get("ispublic")));
			vo.setNotes((String)parameterMap.get("notes"));
			vo.setRightgroup((String)parameterMap.get("rightgroup"));
			vo.setCreatedate(PublicUtils.UtilStrToDate((String)parameterMap.get("createdate"),"yyyy-MM-dd"));
			vo.setStatus(new Byte((String)parameterMap.get("status")));
			vo.setStatusdate(PublicUtils.UtilStrToDate((String)parameterMap.get("statusdate"),"yyyy-MM-dd"));
			vo.setOperid("creator");
			vo.setOrgid("createCompany");
		
			
			RightitemDelegate delegate = new RightitemDelegate();
			delegate.doBatchin(vo, user);
//			String values = "('"+vo.getItemid()+"','"+vo.getRightid()+"',"+"sysdate"+","+vo.getStatus()+","+vo.getStatusdate()+")";
//			sql ="insert into SA_SR_ROLERIGHT (ITEMID,RIGHTID,CREATEDATE,STATUS, STATUSDATE) values "+values+"\r\n";
//			sql = getSql(vo);
			resultVO.setOk(true);
			resultVO.setInfo(RightInfo.INSTANCE.getProperty("success"));
		} catch (Exception ex) { // 插入失败		
				msg = ex.getMessage();

			resultVO.setOk(false);
			resultVO.setInfo(msg);
		}
		resultVO.setInfo(showInfo(resultVO, line, rowCount));
//		resultVO.setInfo(sql);
		return resultVO;
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO,String line, int rowCount) {
		final String COMPART = " | "; // 分隔
		// String mobileno;
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		
		resultStr.append(line + COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append(RightInfo.INSTANCE.getProperty("success"));
		} else {
			resultStr.append(RightInfo.INSTANCE.getProperty("failed"));
		}
		resultStr.append(COMPART);
		// 信息
		if (null != resultVO.getInfo()) {
			resultStr.append(resultVO.getInfo());
		}
		return resultStr.toString();
	}
	
	private String getSql(RolerightVO vo){
		String sql;
		String values = "('"+vo.getItemid()+"','"+vo.getRightid()+"',"+"sysdate"+","+vo.getStatus()+","+"to_date('2008-09-09','yyyy-mm-dd'))";
		sql ="insert into SA_SR_ROLERIGHT (ITEMID,RIGHTID,CREATEDATE,STATUS, STATUSDATE) values "+values+"\r\n";
		return sql;
	}
}
