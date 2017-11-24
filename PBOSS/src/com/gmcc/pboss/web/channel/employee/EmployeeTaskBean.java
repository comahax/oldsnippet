package com.gmcc.pboss.web.channel.employee;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

public class EmployeeTaskBean  extends BaseBatchTaskBean{

	Employee employeeBO = null;
	public EmployeeTaskBean() throws Exception {
		super.setBatchName("渠道经理批量导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		String loginwayid = user.getWayid();
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
			employeeBO.doManagerImport(items,loginwayid);
			line = rowCount + "   " + line + "    成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
