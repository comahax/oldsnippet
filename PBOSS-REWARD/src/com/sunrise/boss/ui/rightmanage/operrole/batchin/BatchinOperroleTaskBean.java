package com.sunrise.boss.ui.rightmanage.operrole.batchin;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.rightmanage.common.RightInfo;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.boss.delegate.rightmanage.operrole.OperroleDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class BatchinOperroleTaskBean extends BaseBatchTaskBean{
	
	protected String doStart() {
		return RightInfo.INSTANCE.getProperty("operrolebatchinfilehead") + "\r\n";
	}
	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {

		ResultVO resultVO = new ResultVO();
		String msg = "";
		String operid;
		String[] items = StringUtils.split(line, "|");
		operid = items[0];
		String roleid = items[1];
		String sql = null;
		try {
			OperroleVO vo = new OperroleVO();
			vo.setOperid(operid);
			vo.setRoleid(roleid);
			vo.setCreatedate(PublicUtils.UtilStrToDate((String)parameterMap.get("createdate"),"yyyy-MM-dd"));
			vo.setStatus(new Byte((String)parameterMap.get("status")));
			vo.setStatusdate(PublicUtils.UtilStrToDate((String)parameterMap.get("statusdate"),"yyyy-MM-dd"));
			
			OperroleDelegate delegate = new OperroleDelegate();
			delegate.doBatchin(vo, user);
			sql = getSql(vo);
			resultVO.setOk(true);
			resultVO.setInfo(RightInfo.INSTANCE.getProperty("success"));
		} catch (Exception ex) { // ����ʧ��		
				msg = ex.getMessage();

			resultVO.setOk(false);
			resultVO.setInfo(msg);
		}
//		resultVO.setInfo(showInfo(resultVO, line, rowCount));
		resultVO.setInfo(sql);
		return resultVO;
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO,String line, int rowCount) {
		final String COMPART = " | "; // �ָ�
		// String mobileno;
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		
		resultStr.append(line + COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append(RightInfo.INSTANCE.getProperty("success"));
		} else {
			resultStr.append(RightInfo.INSTANCE.getProperty("failed"));
		}
		resultStr.append(COMPART);
		// ��Ϣ
		if (null != resultVO.getInfo()) {
			resultStr.append(resultVO.getInfo());
		}
		return resultStr.toString();
	}

	private String getSql(OperroleVO vo){
		String sql;
		String values = "('"+vo.getOperid()+"','"+vo.getRoleid()+"',"+"sysdate"+","+vo.getStatus()+","+"to_date('2008-09-09','yyyy-mm-dd'))";
		sql ="insert into SA_SR_OPERROLE(OPERID,ROLEID,CREATEDATE,STATUS,STATUSDATE) values "+values+"\r\n";
		return sql;
	}
}
