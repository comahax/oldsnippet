package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsBgManagement;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.gmcc.pboss.business.promotion.daemonreg.DaemonregVO;
import com.gmcc.pboss.control.promotion.daemon.Daemon;
import com.gmcc.pboss.control.promotion.daemon.DaemonBO;
import com.gmcc.pboss.control.promotion.daemonreg.Daemonreg;
import com.gmcc.pboss.control.promotion.daemonreg.DaemonregBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class PromotionsBgManagementBO extends AbstractControlBean implements
		PromotionsBgManagement {

	private Logger log = Logger.getLogger(PromotionsBgManagementBO.class);
	
	public void doProcess() throws Exception {

		Daemon daemonBo = (DaemonBO)BOFactory.build(DaemonBO.class, user);
		Daemonreg daemonregBo = (DaemonregBO)BOFactory.build(DaemonregBO.class, user);
		
		DaemonDBParam dmParam = new DaemonDBParam();
		dmParam.set_pagesize("0");
		dmParam.setDataOnly(true);
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		dmParam.set_dnl_startingdate(today+" 00:00:00");
		dmParam.set_dnm_startingdate(today+" 23:59:59");
		
		try {
			List<DaemonVO> dmVoList = new ArrayList<DaemonVO>(daemonBo.doQuery(dmParam).getDatas());
			for(DaemonVO dmVo : dmVoList) {
				long processId = dmVo.getProcessid();
				DaemonregVO drVo = daemonregBo.doFindByPk(processId);
				if(drVo == null) {
					log.error("CH_CX_DAEMONREG 表中不存在PROCESSID="+processId+"的记录，请核实");
					continue;
				}
				String processor = drVo.getProcessor();
				Class pClass = null;
				try {
					pClass = Class.forName(processor);
				}catch(ClassNotFoundException e) {
					log.error("找不到处理类  \t"+processor+"\t ,请核实");
					continue;
				}
				if(!com.gmcc.pboss.Process.Process.class.isAssignableFrom(pClass)) {
					log.error("处理类"+processor+"不是 接口com.gmcc.pboss.Process.Process的实现类");
					continue;
				}
				String params = dmVo.getParams();
				if(params != null) {
					String[] paramArr = params.split(",");
					List<String> paramList = new ArrayList<String>();
					for(String param : paramArr) {
						paramList.add(param);
					}
					Object obj = pClass.newInstance();
					Method method = pClass.getMethod("handler",java.util.List.class);
					method.invoke(obj, paramList);
				}else {
					log.error("CH_CX_DAEMON表中PROCESSID="+processId+"的PARAMS字段值为空，请核实");
					continue;
				}
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

}
