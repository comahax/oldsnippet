package com.gmcc.pboss.member.extend.service;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;
import com.gmcc.pboss.member.extend.model.Provincecityadmin;

public interface ProvincecityadminService extends BaseService {

	//¹Ì¶¨ÃÜÂëµÇÂ¼
	public Provincecityadmin getCityadminLogin(Long mobile);
}
