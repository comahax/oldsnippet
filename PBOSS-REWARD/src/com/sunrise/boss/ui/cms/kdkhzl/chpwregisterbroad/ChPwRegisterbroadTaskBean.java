package com.sunrise.boss.ui.cms.kdkhzl.chpwregisterbroad;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.kdkhzl.chpwregisterbroad.ChPwRegisterbroadDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ChPwRegisterbroadTaskBean extends BaseBatchTaskBean {
	
	public ChPwRegisterbroadTaskBean() throws Exception{
		
	}
	
	protected String doStart() {
		
		
		return "公务机号码|联系电话|宽带数量|登记时间|处理信息 \r\n";
	}
	
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		
		try{
			ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
			ChPwRegisterbroadVO chPwRegisterbroadVO = new ChPwRegisterbroadVO();
			chPwRegisterbroadVO.setTelephone(content[0]);
			chPwRegisterbroadVO.setMobile(content[1]);
			chPwRegisterbroadVO.setBroadnum(Short.parseShort(content[2]));
			chPwRegisterbroadVO.setRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(content[3]));
			
			chPwRegisterbroadVO.setState(Short.parseShort("0"));
			chPwRegisterbroadVO.setOpnid("0502010100009");
			
			EmployeeDelegate employeeDelegate = new EmployeeDelegate();
			EmployeeListVO employeeListVO = new EmployeeListVO();
			EmployeeVO employeeVO = new EmployeeVO();
			employeeListVO.set_se_officetel(content[0]);
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.set_nne_isnet("2");
			DataPackage eDataPackage = employeeDelegate.doQuery(employeeListVO, user);
			if(eDataPackage == null || eDataPackage.getDatas() == null
					|| eDataPackage.getDatas().size() <= 0){
				throw new BusinessException("","公务机号码在人员表中不存在");
			}else{
				Iterator iterator =eDataPackage.getDatas().iterator();
				if(iterator.hasNext())
					employeeVO = (EmployeeVO)iterator.next();
				
				String wayid = employeeVO.getWayid();
				if(wayid == null || "".equals(wayid)){
					throw new BusinessException("","公务机号码无对应渠道编码");
				}
				
			}
			
			chPwRegisterbroadDelegate.doCreate(chPwRegisterbroadVO, user);
			
			
			resultVO.setOk(true);
			resultVO.setInfo(rowCount+"|"+line+"成功");
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
