package com.sunrise.boss.ui.cms.kdkhzl.chpwregisterbroad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ChPwRegisterbroadBatchCheck extends BaseCheckFormat {
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		int dd = Integer.parseInt(sdf.format(new Date()));
		if(dd > 4){
			throw new BusinessException("","�����Ǽ����ݵ���ʱ��");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 4) {
			throw new BusinessException("","�ļ���ʽ���ԣ�����ֻ��4��");
		}
		if(		   (content[0] == null || "".equals(content[0]))
				|| (content[1] == null || "".equals(content[1]))
				|| (content[2] == null || "".equals(content[2]))
				|| (content[3] == null || "".equals(content[3]))
		  ){
			throw new BusinessException("","��������ļ���ʽ����");
		}else{
			if(content[0].length() > 15){
				throw new BusinessException("","������ţ��벻�ܳ���15λ");
			}
			
			if(content[1].length() > 15){
				throw new BusinessException("","��ϵ�绰�����ܳ���15λ");
			}
			
			if(content[2].length() > 3){
				throw new BusinessException("","������������ܳ���3λ");
			}else{
				try {
					Integer.parseInt(content[2]);
				} catch (Exception e) {
					throw new BusinessException("","���������ֻ��Ϊ����");
				}
			}
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sdf.parse(content[3]);
			}catch (Exception e) {
				throw new BusinessException("","�Ǽ�ʱ�䣬��ʽ���ԣ�Ӧ��Ϊ��yyyy-MM-dd HH:mm:ss");
			}
			EmployeeDelegate employeeDelegate = new EmployeeDelegate();
			EmployeeListVO employeeListVO = new EmployeeListVO();
			EmployeeVO employeeVO = new EmployeeVO();
			employeeListVO.set_se_officetel(content[0]);
			DataPackage eDataPackage = employeeDelegate.doQuery(employeeListVO, user);
			if(eDataPackage == null || eDataPackage.getDatas() == null
					|| eDataPackage.getDatas().size() <= 0){
				throw new BusinessException("","�������������Ա���в�����");
			}else{
				Iterator iterator =eDataPackage.getDatas().iterator();
				if(iterator.hasNext())
					employeeVO = (EmployeeVO)iterator.next();
			}
			Short empstatus = employeeVO.getEmpstatus();
			Short isnet = employeeVO.getIsnet();
			if((empstatus != null && empstatus.shortValue() != 0) 
					||(isnet != null && isnet.shortValue() == 2) )
			{
				throw new BusinessException("","����������Ӧ����Ա�Ǵ�н����רԱ���ڸ�");
			}
		}
		
	}
}
