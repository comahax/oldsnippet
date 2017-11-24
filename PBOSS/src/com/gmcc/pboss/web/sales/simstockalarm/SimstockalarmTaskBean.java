package com.gmcc.pboss.web.sales.simstockalarm;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.simstockalarm.Simstockalarm;
import com.gmcc.pboss.control.sales.simstockalarm.SimstockalarmBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SimstockalarmTaskBean extends BaseBatchTaskBean {

	public SimstockalarmTaskBean() throws Exception {
		super.setBatchName("空白SIM卡库存预警设置（渠道）批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "空白SIM卡库存预警设置（渠道）批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Simstockalarm simstockalarm = (Simstockalarm) BOFactory.build(SimstockalarmBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			//大于零的整数，最大长度10位。 
			try{
				Long.valueOf(items[2]);
				if(items[1].length()>10){
					throw new Exception("最高库存数据长度错误");
				}
			}catch(Exception e){
				throw new Exception("最高库存数据类型错误");
			}
			//大于零的整数，最大长度10位。 
			try{
				Long.valueOf(items[3]);
				if(items[2].length()>10){
					throw new Exception("红色预警数据长度错误");
				}
			}catch(Exception e){
				throw new Exception("红色预警数据类型错误");
			}
			//大于零的整数，最大长度10位。 
			try{
				Long.valueOf(items[4]);
				if(items[3].length()>10){
					throw new Exception("黄色预警数据长度错误");
				}
			}catch(Exception e){
				throw new Exception("黄色预警数据类型错误");
			}
		
			SimstockalarmVO simstockalarmVO = new SimstockalarmVO();
			simstockalarmVO.setWayid(items[0]);
			simstockalarmVO.setComcategory(items[1]);
			simstockalarmVO.setMaxstock(Long.valueOf(items[2]));
			simstockalarmVO.setAlarmvalue("REDALARM:" + items[3] + ";YELALARM:" + items[4]);
			
			SimstockalarmDBParam param1 = new SimstockalarmDBParam();
			param1.set_se_wayid(simstockalarmVO.getWayid());
			param1.set_se_comcategory(simstockalarmVO.getComcategory());
			DataPackage dp1 = simstockalarm.doQuery(param1);
			if (dp1.getRowCount() == 0) {
				simstockalarm.doCreate(simstockalarmVO);
			} else {
				SimstockalarmVO vo = (SimstockalarmVO) dp1.getDatas().get(0);
				BeanUtils.copyProperties(vo, simstockalarmVO);
				simstockalarm.doUpdate(vo);
			}
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