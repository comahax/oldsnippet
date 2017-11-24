package com.gmcc.pboss.control.channel.way;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>
 * Title: WayDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class WayDelegate {

	private static Way control;

	public WayDelegate() throws Exception {
		control = (Way) BOFactory.build(WayBO.class);
		if (null == control) {
			throw new Exception(this.getClass() + " initialize failed");
		}
	}



	public DataPackage doQueryEmployee(WayDBParam params, User user)
			throws Exception {
		DataPackage dp = new DataPackage();
		DataPackage dataPackage = control.doQueryEmployee(params, user);
		List list = (List) dataPackage.getDatas();
		List collection = new ArrayList();
		Employee employeeControl = (EmployeeBO) BOFactory
				.build(EmployeeBO.class,user);
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator employee = employeeControl.doQueryEmployee(listVO, user)
					.getDatas().iterator();
			if (employee.hasNext()) {
				AGWayVO employeevo = (AGWayVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas(collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}

}
