package com.sunrise.jop.ui.struts2;

import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

public class MockUserProvider implements UserProvider {

	public DBAccessUser getUser() {
		 User user = new User();
         user.setCityid("DB_COMMON");
         user.setOprcode("TEST");
         user.setIp("127.0.0.1");
		return user;
	}

}
