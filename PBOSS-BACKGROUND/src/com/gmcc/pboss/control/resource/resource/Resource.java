package com.gmcc.pboss.control.resource.resource;

import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface Resource extends AbstractControl {

	public void process() throws Exception;
	public void doComressmDeploy(String line,Map map,String defaultState,String resourceUser,String storage,String batchno,List<NumtyperuleVO> typeruleList) throws Exception;
	public void doComrescardDeploy(String line,String comrescardState,String batchno) throws Exception;
	public void doEmptysimDeploy(String line,String simrescardState,String batchno) throws Exception;
	public void doSimStateProcess(String line) throws Exception;
}
