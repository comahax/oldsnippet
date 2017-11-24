package com.gmcc.pboss.BgProcess.resource.simcard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import com.gmcc.pboss.BgProcess.resource.resource.BaseProcess;
import com.gmcc.pboss.BgProcess.resource.resource.ResultVO;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileVO;
import com.gmcc.pboss.control.resource.resource.Resource;
import com.gmcc.pboss.control.resource.resource.ResourceBO;
import com.gmcc.pboss.control.resource.simnoactinfofile.Simnoactinfofile;
import com.gmcc.pboss.control.resource.simnoactinfofile.SimnoactinfofileBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

public class StateImportProcess extends BaseProcess{
	private User user;
	
	public StateImportProcess(User user){
		this.user = user;
	}
	
	public void processFile(File file,String errorDir) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		int rowCount = 0;
		
		ResultVO resultVO = null;
		Date begintime = new Date();
		while((line = reader.readLine()) != null){
			try{
				rowCount++;
				
				resultVO = processLine(line,rowCount);
				
				if(!resultVO.isOk()){//
					fail++;
				}else{
					success++;
				}				
				
				//记录文件处理情况
				
			}catch(Exception e){
				fail++;
				//writer.write(rowCount+"|"+line+"|"+e.getCause() != null ?e.getCause().getMessage():e.getMessage()+"\n");
				//LoggerUtils.error(e, log);				
			}
		}
		Date overtime = new Date();
		
		Simnoactinfofile simnoactinfofileBO = (SimnoactinfofileBO)BOFactory.build(SimnoactinfofileBO.class, user);
		SimnoactinfofileVO simnoactinfofileVO = new SimnoactinfofileVO();
		simnoactinfofileVO.setFilename(file.getName());
		simnoactinfofileVO.setBegintime(begintime);
		simnoactinfofileVO.setOvertime(overtime);
		simnoactinfofileVO.setTotalamt((long)rowCount);
		simnoactinfofileVO.setActualamt((long)rowCount);
		simnoactinfofileVO.setSuccessamt((long)success);
		simnoactinfofileVO.setFailamt((long)fail);
		simnoactinfofileBO.doCreate(simnoactinfofileVO);
	}

	public DBAccessUser getUser() {
		
		return null;
	}

	public void setUser(DBAccessUser user) {
		

	}

	@Override
	public ResultVO processLine(String line, int rowCount){
		ResultVO resultVO = new ResultVO();
		try {
			Resource resourceBO = (ResourceBO)BOFactory.build(ResourceBO.class, user);
			resourceBO.doSimStateProcess(line);
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			e.printStackTrace();
			line =  rowCount+"|"+line+"|"+e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}

}
