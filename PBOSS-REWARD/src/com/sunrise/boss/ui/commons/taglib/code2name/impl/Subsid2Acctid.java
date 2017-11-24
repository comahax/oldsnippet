package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class Subsid2Acctid implements Code2name{

	private static final Logger log = Logger.getLogger(Subsid2Acctid.class);
	
	public String translate(Object code, User user) throws Exception {
		try {
			SubscriberDelegate delegate = new SubscriberDelegate();
			Long acctid = delegate.doFindByPk((Serializable) code, user).getAcctid();
			
			if (null == acctid || acctid.equals(null)) {
				log.info("translate acctid, null to empty !");
				return "";
			}
			return acctid.toString();
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
