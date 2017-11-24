/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * @author baiming
 * 
 */
public class Subsid2Username implements Code2name {
	/** Logger for this class * */
	private static final Logger log = Logger.getLogger(Subsid2Username.class);

	public String translate(Object code, User user) throws Exception {

		try {
			SubscriberDelegate delegate = new SubscriberDelegate();
			String name = delegate.doFindByPk(new Long(Long.parseLong(code.toString())), user).getSubsname();
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
