package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoVO;
import com.sunrise.boss.delegate.cms.reward.batchno.BatchnoDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class Batchno2Name implements Code2name {
	private static final Logger log = Logger.getLogger(Batchno2Name.class);

	public String translate(Object code, User user) throws Exception {

		String name = "";

		try {
			BatchnoVO vo = new BatchnoVO();
			String[] codes = code.toString().split("\\|");
			if (codes.length!=0) {
				vo.setBatchno(codes[0]);
				vo.setBatchtype(codes[1]);

				BatchnoDelegate delegate = new BatchnoDelegate();
				BatchnoVO cvo = delegate.doFindByPk(vo, user);

				if (cvo != null) {
					name = cvo.getName();
				}

				if (null == name) {
					log.info("translate name, null to empty !");
					return "";
				}
				return name;
			}
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
