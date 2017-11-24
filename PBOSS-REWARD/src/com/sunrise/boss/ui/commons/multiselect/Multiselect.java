package com.sunrise.boss.ui.commons.multiselect;

import java.util.Collection;

import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: Multiselect
 * </p>
 * <p>
 * Description: 多选弹出框数据获取接口
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Sunrise Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2008-08-28
 */
public interface Multiselect {
	/**
	 * 获取初始可选集合
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Collection getInitSource(User user) throws Exception;

	/**
	 * 获取初始已选集合
	 * 
	 * @param codes
	 * @param user
	 * @return
	 * @throws Exception
	 */

	public Collection getInitExist(String[] codes, User user) throws Exception;

	/**
	 * 查询可选集合
	 * 
	 * @param code
	 *            查询条件
	 * @param name
	 *            查询条件
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Collection querySource(String code, String name, User user)
			throws Exception;
}
