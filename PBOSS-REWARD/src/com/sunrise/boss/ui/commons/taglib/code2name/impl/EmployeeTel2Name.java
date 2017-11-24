package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class EmployeeTel2Name implements Code2name {
	private static final Logger log = Logger.getLogger(EmployeeTel2Name.class);

	public String translate(Object code, User user) throws Exception {

		String name = "";

		try {

			EmployeeDelegate delegate = new EmployeeDelegate();
			EmployeeVO vo = delegate.doFindByPk(code.toString(), user);

			if (vo != null) {
				name = vo.getTelephone();
			}

			if (null == name) {
				log.info("translate name, null to empty !");
				return "";
			}
			return name;
		} catch (Exception ex) {
			log.error("translate(Object, User) - exception error !", ex);
		}
		if (null == code) {
			log.info("translate code, null to empty !");
			return "";
		}
		return code.toString();
	}

}
