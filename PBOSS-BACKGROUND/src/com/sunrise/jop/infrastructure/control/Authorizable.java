package com.sunrise.jop.infrastructure.control;

import com.sunrise.jop.infrastructure.db.*;

/**
 * 
 * @author He Kun
 *
 */
public interface Authorizable {
	
	void setUser(DBAccessUser user);
	
	DBAccessUser getUser();
}
