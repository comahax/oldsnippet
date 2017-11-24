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

    	//��ȡ��������, ����Ӧ����ֻ����һ����������, Ϊ�˼��ݸ������, ���Զ������.
    	List topWays = (List)wayControl.getFirstLevelWays(user).getDatas();

    	boolean isIntegrity = false;
    	if(topWays.size() > 0) {
    		isIntegrity = checkWays(null,topWays, user);
    	}
    	return isIntegrity;
    }
    
    
    /**
     * ����ĳ���������в�νṹ���
     * @param wayid
     * @param user
     * @return
     * @throws Exception
     */
    public boolean check(String wayid, User user) throws  Exception {
    	
    	if(StringUtils.isBlank(wayid))
    		throw new BusinessException("CMS-10201","����ָ����������/�������������롣");
    	WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);

    	//��ȡ��������, ����Ӧ����ֻ����һ����������, Ϊ�˼��ݸ������, ���Զ������.
    	List subWays = (List)wayControl.getSubways(wayid, user).getDatas();
    	
    	boolean isIntegrity = false;

    	
    	if(subWays.size() > 0) {
    		isIntegrity = checkWays(wayid,subWays, user);
    	}
    	return isIntegrity;   
    }
    
  
    
    /**
     * ���һ������������ֱ���¼�������������α��е�������.
     * @param ways
     * @param user
     * @return

     * @throws Exception
     */
    protected boolean checkWays(String baseWayId,List ways, User user) throws  Exception {
    	return checkOrBuildWays(baseWayId, ways, user, false);
    }
    /**
     * ���һ������������ֱ���¼�������������α��е�������.
     * @param wayVO
     * @param user
     * @param toBuild ��ʧ��ι�ϵʱ��������
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
    			isIntegrity = checkOrBuildWays(baseWayId,subways, user,toBuild); //�ݹ���, ��ʱ�õݹ�,����ջ,�Ժ����Ż�����
    			if(!isIntegrity) return isIntegrity;
    		}
    		isIntegrity = checkOrBuildWayhierarchByWayToDown(way,user,toBuild); //����Ը�����Ϊĩ����������ι�ϵ��������.
    		if(!isIntegrity) {
    			throw new BusinessException("CMS-10201","���¼���ι�ϵ������,��������:" + way.getWayid() + " " + way.getWayname());
//    			return isIntegrity;
    		}
    	}
    	
    	//����� baseWayId Ϊĩ�������Ĳ�ι�ϵ�������ԣ� �����ϼ��
    	isIntegrity = checkOrBuildWayhierarchByWayToTop(baseWayId,user,toBuild); //����Ը�����Ϊĩ����������ι�ϵ��������.
    	if(!isIntegrity) {
			throw new BusinessException("CMS-10201","���ϼ���ι�ϵ������,����:" + baseWayId + " " + wayVO.getWayname());
//			return isIntegrity;
		}
    	return true;
    }

    protected boolean checkOrBuildWayhierarchByWayToTop(String baseWayId, User user, boolean toBuild) throws Exception {
    	WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);    	
    	
    	WayVO wayVO = (WayVO)wayDAO.findByPk(baseWayId);
    	
    	if(wayVO == null)
    		throw new BusinessException("CMS-10202","δ�ҵ�����:" + baseWayId);
    	
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
     * ��wayΪ��ǰ�ڵ�, �������Ϊ�������Ĳ�ι�ϵ��������
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
		waymsg.append("����:").append(wayid).append(" " ).append(subwayVO.getWayname())
			   .append("; ������:").append(parwayid).append(" " ).append(parwayVO.getWayname());
		
		if(retVO==null) {
			if(log.isInfoEnabled())
				log.info("no way hierarchy,wayid " + wayid + " uppperid:" + parwayid +" �����:" + hicyoffset );
			if(toBuild)
				retVO = (WayhierarchyVO)wayhierarchyDAO.create(wayhierarchyVO);
			else	//���ֻ�Ǽ��,���׳��쳣
				throw new BusinessException("CMS-10201","��ι�ϵ������, ȱ�ٲ�ι�ϵ: " + waymsg.toString());
//			return false; //��μ�鲻�Ϸ�
		}
		if( retVO.getHichyoffset().shortValue()!= hicyoffset) {
			if(log.isInfoEnabled())
				log.info("invalid way hierarchy,wayid " +wayid + " uppperid:" + parwayid +" �����:" + retVO.getHichyoffset().shortValue() + ". Ought to be " + hicyoffset +".");
			if(toBuild) {
				wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
				wayhierarchyVO.setCreatetime(new Timestamp(System.currentTimeMillis()));
				wayhierarchyDAO.update(wayhierarchyVO);
				if(log.isInfoEnabled())
					log.info("update invalid way hierarchy," +   waymsg.toString() + " �����:" + retVO.getHichyoffset().shortValue() + ". Ought to be " + hicyoffset +".");
			}else	//���ֻ�Ǽ��,���׳��쳣
				throw new BusinessException("CMS-10202","���������ȷ: " +  waymsg.toString() + " �����:" +  retVO.getHichyoffset().shortValue() +", Ӧ����:" +  hicyoffset);
//			return false; //��μ�鲻�Ϸ�
		}
/*
		//�Ա��������Ĵ���ʱ��Ͳ�ι�ϵ�Ĵ���ʱ��, �����һ��,����
		if( retVO.getCreatetime() != null) {

			WayVO thisWay = (WayVO)wayDAO.findByPk(wayid);
			if(thisWay!=null && thisWay.getCreatetime()!=null) {
				if( !thisWay.getCreatetime().equals(retVO.getCreatetime())) {
					if(toBuild) {

						wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
						wayhierarchyVO.setCreatetime( new Timestamp(thisWay.getCreatetime().getTime()) );
						wayhierarchyDAO.update(wayhierarchyVO);

					}else {  //�״�
						throw new BusinessException("CMS-10202","����ʱ�䲻��ȷ: ��������:" + wayid +" ����������:" + parwayid +" ��ϵ����ʱ��:" +  retVO.getCreatetime() +", Ӧ����:" +  thisWay.getCreatetime());
					}

				}
			}
		}
*/
		if(log.isInfoEnabled())
			log.info("check way hierarchy,wayid " + wayid + " uppperid:" + parwayid +" �����:" + hicyoffset);
    }
    /**
	 * ��ȡ�ϼ�����
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
     * @deprecated Ϊ��֤Ч�ʣ�ʹ��buildWay(String wayid, User user) ����ĳ��������������й�����
	 */
	public void build(User user) throws  Exception {
		WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);
    	
    	//��ȡ��������, ����Ӧ����ֻ����һ����������, Ϊ�˼��ݸ������, ���Զ������.
    	List topWays = (List)wayControl.getFirstLevelWays(user).getDatas();     	
    	if(topWays.size() > 0) {
    		checkOrBuildWays(null,topWays, user, true);
    	}
    }
	
	  /**
     * ����ĳ���������в�νṹ����
     * @param wayid
     * @param user
     * @throws Exception
     */
    public void build(String wayid, User user) throws  Exception {
    	if(StringUtils.isBlank(wayid))
    		throw new BusinessException("CMS-10201","����ָ����������/�������������롣");
    	
    	WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);
    	
    	//��ȡ��������, ����Ӧ����ֻ����һ����������, Ϊ�˼��ݸ������, ���Զ������.
    	List topWays = (List)wayControl.getSubways(wayid, user).getDatas();     	
    	if(topWays.size() > 0) {
    		checkOrBuildWays(wayid,topWays, user, true);
    	}
    }

}
