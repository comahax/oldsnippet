package com.gmcc.pboss.business.cms.examine;

import java.util.List;

public interface Examine {
	public List examine(String starttime, String endtime,String cityid) throws Exception;
}
