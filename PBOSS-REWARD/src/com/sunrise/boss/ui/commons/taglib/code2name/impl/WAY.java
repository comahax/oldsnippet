/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * @author baiming
 * ���acctid�����servnum
 */


public class WAY implements Code2name {
	/**  Logger for this class **/
	private static final Logger log = Logger.getLogger(Acctid2Servnum.class);
	public String translate(Object code, User user) throws Exception {
		
		try{
			WayDelegate delegate = new WayDelegate();
			WayVO vo = delegate.doFindByPk(code.toString(),user);
			if (null == vo) {
				log.info("translate name, null to empty !");
				return "";
			}
			return vo.getWayname();
		}catch(Exception ex){			
			log.error("translate(Object, User) - exception error !", ex);			
		}
	
		if (null == code) {
			log.info("translate code, null to empty !");
			return "";
		}
		return code.toString();
	}

}
