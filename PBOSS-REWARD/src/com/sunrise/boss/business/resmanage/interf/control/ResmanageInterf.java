package com.sunrise.boss.business.resmanage.interf.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description: 资源管理接口
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version 下午02:18:312006-8-28
 */
public interface ResmanageInterf {
	/**
	 * 
	 * @Description:资源操作接口
	 * @param paramstring
	 * @return 成功失败标志|原因
	 * @throws Exception
	 *             String
	 */
	public String manageRes(String paramstring, Long restype, Long oprtype,
			User user) throws Exception;

	/**
	 * 
	 * @Description:商品类型查询接口
	 * @param Comclassid，user
	 * @return 商品类型集合 Set
	 */
	public Set getComType(Long Comclassid, User user) throws Exception;

	/**
	 * 
	 * @Description:商品标识、价格查询
	 * @param comtype
	 * @return 商品标识、价格
	 * @throws Exception
	 *             Map
	 */
	public List getComId(Long comtype, User user) throws Exception;

	/**
	 * 检查商品渠道及状态是否符合导入撤单要求
	 * 
	 * @param comresid
	 *            商品编号
	 * @param comid
	 *            商品标识
	 * @param wayid
	 *            订单的资源使用渠道
	 * @param user
	 * @throws Exception
	 */
	public void doUnImportComresCheck(String comresid, Long comid,
			String wayid, User user) throws Exception;

	/**
	 * 检查商品渠道及状态是否符合导入要求
	 * 
	 * @param comresid
	 *            商品编号
	 * @param comid
	 *            商品标识
	 * @param wayid
	 *            订单的资源使用渠道
	 * @param user
	 * @throws Exception
	 */
	public void doImportComresCheck(String comresid, Long comid, String wayid,
			User user) throws Exception;

	/**
	 * 单个商品导入撤单，将商品状态修改为可售态，无事务控制
	 * 
	 * @param comresid
	 *            商品编号
	 * @param comid
	 *            商品标识
	 * @param user
	 * @throws Exception
	 */
	public void doUnImportComres(String comresid, Long comid, User user)
			throws Exception;

	/**
	 * 单个商品导入，将商品状态修改为抽取态，无事务控制
	 * 
	 * @param comresid
	 *            商品编号
	 * @param comid
	 *            商品标识
	 * @param user
	 * @throws Exception
	 */
	public void doImportComres(String comresid, Long comid, User user)
			throws Exception;
}
