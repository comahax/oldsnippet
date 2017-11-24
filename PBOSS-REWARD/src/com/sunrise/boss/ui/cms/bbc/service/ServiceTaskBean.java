package com.sunrise.boss.ui.cms.bbc.service;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceListVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.bbc.service.ServiceDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ServiceTaskBean extends BaseBatchTaskBean {

	public ServiceTaskBean() throws Exception{
		super.setBatchName("数据业务上线设置导入");
		super.setWriteLog(true);
	}

	@Override
	protected String doStart() {
		// TODO Auto-generated method stub
		return "数据业务上线设置导入 \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		
		try {
			BBCoperationDelegate operationDelegate =new BBCoperationDelegate();
			BBCoperationListVO coperationListVO=new BBCoperationListVO();
			coperationListVO.set_se_opnid(content[1]);
			DataPackage dp=operationDelegate.doQuery(coperationListVO, user);
			if(dp.getRowCount()==0){
				throw new Exception("您导入添加的业务编码不正确");
			}
			
			ServiceDelegate serviceDelegate=new ServiceDelegate();
			ServiceListVO serviceListVO=new ServiceListVO();
			serviceListVO.set_se_opnid(content[1]);
			DataPackage dataPackage=serviceDelegate.doQuery(serviceListVO, user);
			
			ServiceVO serviceVO=new ServiceVO();
			serviceVO.setOpnid(content[1]);
			serviceVO.setName(content[0]);
			serviceVO.setBaserewardstd(Float.parseFloat(content[2]));
			serviceVO.setBonusrewardstd(Float.parseFloat(content[3]));
			
			if(dataPackage!=null&&dataPackage.getDatas().size()>0){
				serviceDelegate.doUpdate(serviceVO, user);
				
			}else{
				serviceDelegate.doCreate(serviceVO, user);
			}
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
	
}
