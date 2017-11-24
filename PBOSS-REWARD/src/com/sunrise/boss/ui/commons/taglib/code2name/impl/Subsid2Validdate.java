package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;
import com.sunrise.pub.tools.PublicUtils;

public class Subsid2Validdate implements Code2name{
	
	private static final Logger log = Logger.getLogger(Subsid2Validdate.class);
	
	public String translate(Object code, User user) throws Exception {
		try {
			SubscriberDelegate delegate = new SubscriberDelegate();
			Date validdate = delegate.doFindByPk((Serializable) code, user).getInvaliddate();
			
			if (null == validdate || validdate.equals(null)) {
				log.info("translate validdate, null to empty !");
				return "";
			}
			return PublicUtils.formatUtilDate(validdate, "yyyy-MM-dd");
		} catch (Exception ex) {
			log.error("translate(Object, User) - exception error !", ex);
			
		}

		if (null == code) {
			log.info("translate code, null to empty !");
			return "";
		}
		return "";
	}

}
