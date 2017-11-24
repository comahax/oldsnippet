package com.sunrise.boss.business.resmanage.interf.busirules;

import java.util.Map;

import com.sunrise.boss.business.resmanage.interf.param.BaseParam;
import com.sunrise.boss.ui.commons.User;
 /** <p>Title: BOSS1.5</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author Rodney
 * @version обнГ07:24:482006-8-30
 */
public interface BusiRules {
	public String execute(BaseParam param,User user) throws Exception;
}


