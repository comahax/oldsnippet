package com.sunrise.boss.business.resmanage.common;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.ui.commons.User;

public interface ICommonMethod {

	/**
	 * 根据资源操作动作和商品状态判断商品是否可以进行操作
	 * 
	 * @param oprtype
	 * @param comstate
	 * @return boolean
	 */
	public boolean chkComstate(Long oprtype, Long comstate);

	/**
	 * 检查起始编号和终止编号间所有资源的渠道是否一致
	 * 
	 * @param outwayid
	 * @param begno
	 * @param endno
	 * @param comid
	 * @param dao
	 * @return 如果渠道不一致，返回-1； 渠道一致，返回可操作资源数量
	 * @throws Exception
	 */
	public int chkWayissame(String outwayid, String begno, String endno,
			Long comid, String batchno, Long comstate, BaseDAO dao)
			throws Exception;

	/**
	 * 登记资源操作日志
	 * 
	 * @param begno
	 * @param batchno
	 * @param comid
	 * @param wayid
	 * @param comstate
	 * @param oprVO
	 * @param user
	 * @return 资源操作日志对象
	 * @throws Exception
	 */
	public Object setOprVO(String begno, String batchno, Long comid,
			String wayid, Long comstate, Object oprVO, User user)
			throws Exception;

	/**
	 * 登记资源请求表
	 * 
	 * @param reqVO
	 * @param user
	 * @throws Exception
	 */
	public void setReqVO(Object reqVO, User user) throws Exception;

}