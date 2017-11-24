package com.gmcc.pboss.web.channel.waytype;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.waytype.WaytypeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.waytype.Waytype;
import com.gmcc.pboss.control.channel.waytype.WaytypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class WaytypeTaskBean extends BaseBatchTaskBean {

	public WaytypeTaskBean() throws Exception {
		super.setBatchName("����������������");
		// super.setWriteLog(true);
	}

	protected String doStart() {
		return "������������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Waytype waytype = (Waytype) BOFactory.build(WaytypeBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			WaytypeVO vo = new WaytypeVO();
			vo.setWaytypecode(items[0]);
			vo.setWaytypecode(items[1]);
			vo.setUppercode(items[2]);
			vo.setDesp(items[3]);
			if (waytype.doFindByPk(vo.getWaytypecode()) == null) {
				waytype.doCreate(vo);
			} else {
				waytype.doUpdate(vo);
			}
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

	public static void main(String[] s) {

	}
}
