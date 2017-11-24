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
		super.setBatchName("�հ�SIM�����Ԥ�����ã���������������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�հ�SIM�����Ԥ�����ã�����������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Simstockalarm simstockalarm = (Simstockalarm) BOFactory.build(SimstockalarmBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			
			//���������������󳤶�10λ�� 
			try{
				Long.valueOf(items[2]);
				if(items[1].length()>10){
					throw new Exception("��߿�����ݳ��ȴ���");
				}
			}catch(Exception e){
				throw new Exception("��߿���������ʹ���");
			}
			//���������������󳤶�10λ�� 
			try{
				Long.valueOf(items[3]);
				if(items[2].length()>10){
					throw new Exception("��ɫԤ�����ݳ��ȴ���");
				}
			}catch(Exception e){
				throw new Exception("��ɫԤ���������ʹ���");
			}
			//���������������󳤶�10λ�� 
			try{
				Long.valueOf(items[4]);
				if(items[3].length()>10){
					throw new Exception("��ɫԤ�����ݳ��ȴ���");
				}
			}catch(Exception e){
				throw new Exception("��ɫԤ���������ʹ���");
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
}