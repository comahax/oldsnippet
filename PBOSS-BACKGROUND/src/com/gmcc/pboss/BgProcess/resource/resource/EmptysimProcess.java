package com.gmcc.pboss.BgProcess.resource.resource;


import org.apache.log4j.Logger;

import com.gmcc.pboss.control.resource.resource.Resource;
import com.gmcc.pboss.control.resource.resource.ResourceBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ¿Õ°×¿¨·¢²¼
 * @author wefrogll
 * @version 1.0 2009-12-17
 */
public class EmptysimProcess  extends BaseProcess{
	private Logger log = Logger.getLogger(EmptysimProcess.class);
	private User user;
	
	private String simrescardState;	
	private String batchNo;
	
	public EmptysimProcess(User user){
		this.user = user;
	}
	
	public EmptysimProcess(User user,String simrescardState,String batchNo){
		this.user = user;
		this.simrescardState = simrescardState;
		this.batchNo = batchNo;
	}
	
	@Override
	public ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			Resource resourceBO = (ResourceBO)BOFactory.build(ResourceBO.class, user);
			resourceBO.doEmptysimDeploy(line,simrescardState,batchNo);
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			System.out.println("======================================"+e.getStackTrace()[0]);
			line =  rowCount+"|"+line+"|"+ (e.getCause() != null ?e.getCause().getMessage():e.getMessage());
			resultVO.setInfo(line);
			resultVO.setOk(false);
			LoggerUtils.error(e, log);
		}
		return resultVO;
	}
}
