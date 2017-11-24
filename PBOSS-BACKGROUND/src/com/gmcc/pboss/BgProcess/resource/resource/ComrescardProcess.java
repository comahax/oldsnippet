package com.gmcc.pboss.BgProcess.resource.resource;


import org.apache.log4j.Logger;

import com.gmcc.pboss.control.resource.resource.Resource;
import com.gmcc.pboss.control.resource.resource.ResourceBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ≥‰÷µø®»Îø‚
 * @author wefrogll
 * @version 1.0 2009-12-17
 */
public class ComrescardProcess extends BaseProcess{

	private Logger log = Logger.getLogger(ComrescardProcess.class);
	private User user;
	private String comrescardState;
	private String batchNo;
	public ComrescardProcess(User user,String comrescardState,String batchNo){
		this.user = user;
		this.comrescardState = comrescardState;
		this.batchNo = batchNo;
	}
	@Override
	public ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			Resource resourceBO = (ResourceBO)BOFactory.build(ResourceBO.class, user);
			resourceBO.doComrescardDeploy(line, comrescardState,batchNo);
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			log.error(e.getMessage());
			line =  rowCount+"|"+line+"|"+(e.getCause() != null ?e.getCause().getMessage():e.getMessage());
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
