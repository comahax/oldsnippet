/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.business.cms.wayhierarchy.control;

import java.io.Serializable;
import java.rmi.*;
import java.sql.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.*;

import com.sunrise.boss.common.base.control.*;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.way.control.*;
import com.sunrise.boss.business.cms.way.persistent.*;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyDAO;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyListVO;

/**
 * <p>Title: WayhierarchyControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/wayhierarchy/control/WayhierarchyControlBean"
*    name="WayhierarchyControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WayhierarchyControlBean extends AbstractControlBean
    implements WayhierarchyControl {

	private static Log log = LogFactory.getLog(WayControlBean.class);

    public WayhierarchyVO doCreate(WayhierarchyVO vo, User user)
        throws Exception {
        try{
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user );
            // TODO  set the pk */
            return (WayhierarchyVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayhierarchyVO vo, User user)
        throws Exception {
        try{
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhierarchyVO doUpdate(WayhierarchyVO vo, User user)
        throws Exception {
        try{
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user );
            return (WayhierarchyVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhierarchyVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user );
        return (WayhierarchyVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayhierarchyListVO params, User user)
        throws Exception {
			WayhierarchyDAO dao = (WayhierarchyDAO) DAOFactory.build(WayhierarchyDAO.class, user );
			if(params.get_orderby()==null) {
				params.set_orderby("createtime");
				params.set_desc("0");
			}

        return dao.query(params);
    }
    
 

	/**
	 * 
	 * * @deprecated 
	 */
    public boolean check(User user) throws  Exception {
    	WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);

    	//获取顶级渠道, 需求应该是只允许一个顶级渠道, 为了兼容复杂情况, 先以多个处理.
    	List topWays = (List)wayControl.getFirstLevelWays(user).getDatas();

    	boolean isIntegrity = false;
    	if(topWays.size() > 0) {
    		isIntegrity = checkWays(null,topWays, user);
    	}
    	return isIntegrity;
    }
    
    
    /**
     * 基于某个渠道进行层次结构检查
     * @param wayid
     * @param user
     * @return
     * @throws Exception
     */
    public boolean check(String wayid, User user) throws  Exception {
    	
    	if(StringUtils.isBlank(wayid))
    		throw new BusinessException("CMS-10201","必须指定基于其检查/构建的渠道编码。");
    	WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);

    	//获取顶级渠道, 需求应该是只允许一个顶级渠道, 为了兼容复杂情况, 先以多个处理.
    	List subWays = (List)wayControl.getSubways(wayid, user).getDatas();
    	
    	boolean isIntegrity = false;

    	
    	if(subWays.size() > 0) {
    		isIntegrity = checkWays(wayid,subWays, user);
    	}
    	return isIntegrity;   
    }
    
  
    
    /**
     * 检查一个渠道的所有直属下级渠道在渠道层次表中的完整性.
     * @param ways
     * @param user
     * @return

     * @throws Exception
     */
    protected boolean checkWays(String baseWayId,List ways, User user) throws  Exception {
    	return checkOrBuildWays(baseWayId, ways, user, false);
    }
    /**
     * 检查一个渠道的所有直属下级渠道在渠道层次表中的完整性.
     * @param wayVO
     * @param user
     * @param toBuild 丢失层次关系时立即创建
     * @return

     * @throws Exception
     */
    protected boolean checkOrBuildWays(String baseWayId,List ways, User user,boolean toBuild) throws  Exception {
    	WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
    	WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);   
    	
    	WayVO wayVO = (WayVO)wayDAO.findByPk(baseWayId);
    	//Stack stack = new Stack();
    	boolean isIntegrity = false;
    	for(int i=0;i<ways.size() ; i++) {
    		WayVO way = (WayVO)ways.get(i);
/*
    		WayListVO wayListVO = new WayListVO();
    		wayListVO.set_se_upperwayid( way.getWayid());
    		wayListVO.set_pagesize("0");
    		
    		List subways = (List)dao.query( wayListVO).getDatas();
    		*/
    		
    		//stack.push(subway.getWayid());
    		List subways = dao.getSubways(way.getWayid());
    		if(subways.size() > 0) {
    			isIntegrity = checkOrBuildWays(baseWayId,subways, user,toBuild); //递归检查, 暂时用递归,不用栈,以后考虑优化问题
    			if(!isIntegrity) return isIntegrity;
    		}
    		isIntegrity = checkOrBuildWayhierarchByWayToDown(way,user,toBuild); //检查以该渠道为末级的渠道层次关系的完整性.
    		if(!isIntegrity) {
    			throw new BusinessException("CMS-10201","向下检查层次关系不完整,渠道编码:" + way.getWayid() + " " + way.getWayname());
//    			return isIntegrity;
    		}
    	}
    	
    	//检查以 baseWayId 为末级渠道的层次关系的完整性， 即向上检查
    	isIntegrity = checkOrBuildWayhierarchByWayToTop(baseWayId,user,toBuild); //检查以该渠道为末级的渠道层次关系的完整性.
    	if(!isIntegrity) {
			throw new BusinessException("CMS-10201","向上检查层次关系不完整,渠道:" + baseWayId + " " + wayVO.getWayname());
//			return isIntegrity;
		}
    	return true;
    }

    protected boolean checkOrBuildWayhierarchByWayToTop(String baseWayId, User user, boolean toBuild) throws Exception {
    	WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);    	
    	
    	WayVO wayVO = (WayVO)wayDAO.findByPk(baseWayId);
    	
    	if(wayVO == null)
    		throw new BusinessException("CMS-10202","未找到渠道:" + baseWayId);
    	
    	String pWayId = wayVO.getUpperwayid();
    	
    	short hicyoffset = 1;
    	while( pWayId !=null ) {
    		checkOrBuild(pWayId, baseWayId, hicyoffset, toBuild, user);
    		
    		hicyoffset++;
    		
    		WayVO pWayVO = getUpperWay(pWayId , user);
    		if(pWayVO ==null)
    			pWayId = null;
			else
				pWayId = pWayVO.getWayid();
    	}
		return true;
	}
	/**
     * 以way为当前节点, 检查以它为子渠道的层次关系的完整性
     * @param way
     * @param user

     * @throws Exception
     */
    protected boolean checkOrBuildWayhierarchByWayToDown(WayVO wayVO, User user,boolean toBuild) throws  Exception{
    	if(log.isInfoEnabled()) log.info("prepare to check way hierarchy of way, wayid " + wayVO.getWayid());
	
		String pWayId = wayVO.getUpperwayid();
		if(pWayId == null) {
			if(log.isInfoEnabled())
				log.info("way with no upperway,exit. wayid " + wayVO.getWayid());
				return true;
		}
		String wayid = wayVO.getWayid();

		short hicyoffset = 1;
		while(pWayId!=null) {

			checkOrBuild(pWayId, wayid, hicyoffset, toBuild, user);

			hicyoffset++;

			String thiswayid = pWayId;
			wayVO = getUpperWay(thiswayid , user);
			if(wayVO ==null)
				pWayId = null;
			else
				pWayId = wayVO.getWayid();
		}
		return true;
	}
    
    private void checkOrBuild(String parwayid,String wayid, short hicyoffset,  boolean toBuild,User user) throws Exception {
    	
    	WayhierarchyDAO wayhierarchyDAO = (WayhierarchyDAO)DAOFactory.build(WayhierarchyDAO.class,user);
		WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);
		
		WayVO subwayVO = (WayVO)wayDAO.findByPk(wayid);
		WayVO parwayVO = (WayVO)wayDAO.findByPk(parwayid);
		
    	WayhierarchyVO wayhierarchyVO = new WayhierarchyVO();
		wayhierarchyVO.setParwayid( parwayid );
		wayhierarchyVO.setSubwayid( wayid  );
		wayhierarchyVO.setHichyoffset( new Short(hicyoffset));
		wayhierarchyVO.setCreatetime(new Timestamp(System.currentTimeMillis()));

		WayhierarchyVO retVO = (WayhierarchyVO)wayhierarchyDAO.findByPk(wayhierarchyVO);
		
		StringBuffer waymsg = new StringBuffer(30);
		waymsg.append("渠道:").append(wayid).append(" " ).append(subwayVO.getWayname())
			   .append("; 父渠道:").append(parwayid).append(" " ).append(parwayVO.getWayname());
		
		if(retVO==null) {
			if(log.isInfoEnabled())
				log.info("no way hierarchy,wayid " + wayid + " uppperid:" + parwayid +" 相差层次:" + hicyoffset );
			if(toBuild)
				retVO = (WayhierarchyVO)wayhierarchyDAO.create(wayhierarchyVO);
			else	//如果只是检查,则抛出异常
				throw new BusinessException("CMS-10201","层次关系不完整, 缺少层次关系: " + waymsg.toString());
//			return false; //层次检查不合法
		}
		if( retVO.getHichyoffset().shortValue()!= hicyoffset) {
			if(log.isInfoEnabled())
				log.info("invalid way hierarchy,wayid " +wayid + " uppperid:" + parwayid +" 相差层次:" + retVO.getHichyoffset().shortValue() + ". Ought to be " + hicyoffset +".");
			if(toBuild) {
				wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
				wayhierarchyVO.setCreatetime(new Timestamp(System.currentTimeMillis()));
				wayhierarchyDAO.update(wayhierarchyVO);
				if(log.isInfoEnabled())
					log.info("update invalid way hierarchy," +   waymsg.toString() + " 相差层次:" + retVO.getHichyoffset().shortValue() + ". Ought to be " + hicyoffset +".");
			}else	//如果只是检查,则抛出异常
				throw new BusinessException("CMS-10202","层次数不正确: " +  waymsg.toString() + " 相差层次:" +  retVO.getHichyoffset().shortValue() +", 应该是:" +  hicyoffset);
//			return false; //层次检查不合法
		}
/*
		//对比子渠道的创建时间和层次关系的创建时间, 如果不一致,报错
		if( retVO.getCreatetime() != null) {

			WayVO thisWay = (WayVO)wayDAO.findByPk(wayid);
			if(thisWay!=null && thisWay.getCreatetime()!=null) {
				if( !thisWay.getCreatetime().equals(retVO.getCreatetime())) {
					if(toBuild) {

						wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
						wayhierarchyVO.setCreatetime( new Timestamp(thisWay.getCreatetime().getTime()) );
						wayhierarchyDAO.update(wayhierarchyVO);

					}else {  //抛错
						throw new BusinessException("CMS-10202","创建时间不正确: 渠道编码:" + wayid +" 父渠道编码:" + parwayid +" 关系创建时间:" +  retVO.getCreatetime() +", 应该是:" +  thisWay.getCreatetime());
					}

				}
			}
		}
*/
		if(log.isInfoEnabled())
			log.info("check way hierarchy,wayid " + wayid + " uppperid:" + parwayid +" 相差层次:" + hicyoffset);
    }
    /**
	 * 获取上级渠道
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private WayVO getUpperWay(String wayid,User user ) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayVO = (WayVO)dao.findByPk(wayid);
		if(wayVO.getUpperwayid()==null)
			return null;
		else
			return (WayVO)dao.findByPk(wayVO.getUpperwayid());
	}
	
	/**
	 * @param user
     * @throws Exception
     * @deprecated 为保证效率，使用buildWay(String wayid, User user) 基于某个具体的渠道进行构建。
	 */
	public void build(User user) throws  Exception {
		WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);
    	
    	//获取顶级渠道, 需求应该是只允许一个顶级渠道, 为了兼容复杂情况, 先以多个处理.
    	List topWays = (List)wayControl.getFirstLevelWays(user).getDatas();     	
    	if(topWays.size() > 0) {
    		checkOrBuildWays(null,topWays, user, true);
    	}
    }
	
	  /**
     * 基于某个渠道进行层次结构构建
     * @param wayid
     * @param user
     * @throws Exception
     */
    public void build(String wayid, User user) throws  Exception {
    	if(StringUtils.isBlank(wayid))
    		throw new BusinessException("CMS-10201","必须指定基于其检查/构建的渠道编码。");
    	
    	WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);
    	
    	//获取顶级渠道, 需求应该是只允许一个顶级渠道, 为了兼容复杂情况, 先以多个处理.
    	List topWays = (List)wayControl.getSubways(wayid, user).getDatas();     	
    	if(topWays.size() > 0) {
    		checkOrBuildWays(wayid,topWays, user, true);
    	}
    }

}
