package com.gmcc.pboss.web.channel.zjty.employee;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
/**
 * 社会渠道人员导入
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class ZjtyPeopleTaskBean extends BaseBatchTaskBean{

	public ZjtyPeopleTaskBean() throws Exception {
		super.setBatchName("自建他营人员管理批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	protected String doStart() {
		return "自建他营人员管理批量导入结果  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
			employeeBO.doSocietypeopleImport(items);
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
