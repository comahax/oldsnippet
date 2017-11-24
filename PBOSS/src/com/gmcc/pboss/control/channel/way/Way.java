
/**
 * auto-generated code
 * Wed Jul 08 11:37:50 CST 2009
 */
package com.gmcc.pboss.control.channel.way;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Way </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Way extends AbstractControl {
	public Object doFindByPk3(Serializable pk) throws Exception ;
    public WayVO doCreate(WayVO vo) throws Exception;
    
    public WayVO doCreate(WayVO vo, DBAccessUser user) throws Exception ;

    //public void doRemoveByVO(WayVO vo) throws Exception;

    //public void doRemoveByPK(Serializable pk) throws Exception;
    
    public void doDelete(WayVO vo, DBAccessUser user) throws Exception;
    
    public WayVO doUpdate(WayVO vo) throws Exception;
    
    public WayVO doUpdate(WayVO vo, DBAccessUser user) throws Exception;

    public WayVO doFindByPk(Serializable pk) throws Exception;
    
    public WayVO doFindByPk2(Serializable pk) throws Exception;

    public DataPackage doQuery(WayDBParam params) throws Exception;
    
    /**
     * 根据地市ID,渠道类型查询所有渠道的信息
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayByCityidAndType(String cityid,String waytype) throws Exception ;
    
	public String doQueryWaybyCityid(String cityid) throws Exception;
	
	public WayVO doGetUpperWay(String wayid) throws Exception;
	
	public WayVO doGetCitycomDirectWayByWay(String wayid) throws Exception;
	/**
	 * 验证某渠道是否属于指定渠道类别
	 * @param wayvo
	 * @param waytypeMap	存放类别编码 Key 和 Value 都是waytype
	 * @param waysubtype	存放子类别编码 Key 和 Value 都是waysubtype
	 * @param runmode
	 * @return
	 * @throws Exception
	 */
	public boolean doGetwaytype(WayVO wayvo, Map waytypeMap, Map waysubtype, String runmode) throws Exception;
	
	public boolean doCheckisNetWork(String wayid) throws Exception;
	
	public List doQueryNetWork(String wayid) throws Exception;
	
	public DataPackage doQueryUpperWaysAndMeByIdOrName(String queryText,boolean showDisabled) throws Exception;
	
	public DataPackage doGetWaysOfHeadquarter() throws Exception;
	
	public DataPackage doGetWaysOfCountycom(String countyid) throws Exception;
	
	public DataPackage doGetWaysOfCitycom(String cityid) throws Exception;
	
	public DataPackage doGetWaysOfCenter(String centerid) throws Exception;
	
	public DataPackage doGetSubways(String wayid) throws Exception;
	
	public DataPackage doQuerysaleway(WayDBParam params,User user) throws Exception;
	
	public DataPackage doQuerysalewayWithOfficetel(WayDBParam params,User user) throws Exception;
	
	public DataPackage doQueryLogsway(WayDBParam params, User user)	throws Exception;
	
	public void doRemove(WayVO vo, DBAccessUser user) throws Exception;
	
	/*
	 * 管辖网点查询
	 */
	public DataPackage doQueryEmployee (WayDBParam params, User user)throws Exception;
	
	public DataPackage doQueryByOprcode(WayDBParam params, User user) throws Exception;
	
	public WayVO doEdit(WayVO oldVO, WayVO newVO, DBAccessUser user) throws Exception;
	
	
	//配送商导入
	public void doLogiswayImport(String[] items) throws Exception;
	
	public void doDiswayImport(String[] items) throws Exception;
	/**
	 * 查询是否本地市登录工号相同地市的渠道
	 */
	public WayVO doFindByPkAndCityid(Serializable pk) throws Exception ;
	
	public DataPackage doQuerySubSaleway(WayDBParam params,User user) throws Exception;
	
	public WayVO doUpdateNotCon(WayVO vo) throws Exception;
	
	// 取得渠道编码对应连锁合作商相关数据
	public WayapplyVO doGetageidt(String wayid, DBAccessUser user) throws Exception;
	// 渠道渠道编码对应网点相关数据
	public WayapplyVO doGetsaleeidt(String wayid, DBAccessUser user) throws Exception;
	
	//授权网点申请管理选择申请网点，申请类型为准入申请的时候，查询渠道表限制条件
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params) throws Exception;
	
	//授权网点申请管理选择申请网点，申请类型为退出申请的时候，查询渠道表的限制条件
	public DataPackage doQueryWayinfoForExitway(WayDBParam params) throws Exception;
	 
	public DataPackage doCheckWayState(WayDBParam params) throws Exception;
	//查询渠道网点类型
	public DataPackage doQueryWaytype(WayDBParam params) throws Exception;
	
	//查询入柜商渠道
	public DataPackage doQueryImpWay(WayDBParam params, User user) throws Exception;
	//删除入柜商渠道信息
	public WayVO doRemove(WayVO vo) throws Exception;
	// 按条件查询渠道信息
	public DataPackage doQueryWayByParams(WayDBParam params) throws Exception;
	// 添加入框商渠道信息
	public WayVO doSave(WayVO vo) throws Exception;
	// 修改入框商渠道信息
	public WayVO doUpdateImpWay(WayVO vo) throws Exception;
	
	//查询金融购机渠道
	public DataPackage doQueryFinanceWay(WayDBParam params, User user) throws Exception;
	//删除金融购机渠道信息
	public WayVO doRemoveFinanc(WayVO vo) throws Exception;
	// 添加金融购机渠道信息
	public WayVO doCreateFinance(WayVO vo) throws Exception;
	// 修改金融购机渠道信息
	public WayVO doUpdateFinanceWay(WayVO vo) throws Exception;
	
	//查询互联网渠道
	public DataPackage doQueryNetWay(WayDBParam params, User user) throws Exception;
	//删除互联网渠道信息
	public WayVO doRemoveNetWay(WayVO vo) throws Exception;
	// 添加互联网渠道信息
	public WayVO doCreateNetWay(WayVO vo) throws Exception;
	// 修改互联网渠道信息
	public WayVO doUpdateNetWay(WayVO vo) throws Exception;
	
	// 根据地市ID ，查询该地市和省的编码 
	public DataPackage doQueryWayIdByCityId(WayDBParam params, User user) throws Exception;
}
