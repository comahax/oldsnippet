package com.gmcc.pboss.web.reward.cardrewdet;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.cardrewdet.Cardrewdet;
import com.gmcc.pboss.control.reward.cardrewdet.CardrewdetBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class CardrewdetTaskBean extends BaseBatchTaskBean {

	public CardrewdetTaskBean() throws Exception {
		super.setBatchName("客户质量发展奖励酬金管理批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "客户质量发展奖励酬金管理批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Cardrewdet cardrewdet=(Cardrewdet)BOFactory.build(CardrewdetBO.class, user);
			CardrewdetVO cardrewdetVO=new CardrewdetVO();
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			cardrewdetVO.setWayid(items[1]);
			cardrewdetVO.setMobile(items[0]);
			cardrewdetVO.setActivetime(Timestamp.valueOf(items[2]));
			cardrewdetVO.setRechargenum(Double.valueOf(items[3]));
			cardrewdetVO.setRechargetime(Timestamp.valueOf(items[4]));
			cardrewdetVO.setRewardnum(Double.valueOf(items[5]));
			cardrewdetVO.setCmonth(items[6]);
			cardrewdetVO.setRewardtype(Long.valueOf(items[7]));
			cardrewdet.doCreate(cardrewdetVO);
			
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}