package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class ResOperator2Name implements Code2name {
	private static final Logger log = Logger.getLogger(ResOperator2Name.class);

	public String translate(Object code, User user) throws Exception {

		String name = "";

		try {
			String codestr = code.toString();

			OperatorDelegate delegate = new OperatorDelegate();
			OperatorVO vo = delegate.doFindByPk(code.toString(), user);

			if ("system".equals(codestr)) {
				name = "";
			} else if (vo != null) {
				name = vo.getOpername();
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
