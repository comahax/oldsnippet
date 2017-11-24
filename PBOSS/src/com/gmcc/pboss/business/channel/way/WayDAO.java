/**
 * auto-generated code
 * Wed Jul 08 11:37:50 CST 2009
 */
package com.gmcc.pboss.business.channel.way;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WayDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WayDAO(){
        super(WayVO.class);
    }
    /**
     * 根据地市ID,渠道类型查询所有渠道的信息
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayByCityidAndType(String cityid,String waytype) throws Exception {
    	WayDBParam param = new WayDBParam();
    	//param.setSelectFieldsString("exmnid,exmnname,exmnstdid,exmnmark,adtype,starlevel,state,isvoted");
    	param.getQueryConditions().put("waytype", waytype);
		param.getQueryConditions().put("cityid", cityid);
		
		param.setQueryAll(true);
		return queryByNamedSqlQuery("com.sunrise.pboss.business.channel.way.QueryWayByCityidAndTypet", param);
	}
    
	public WayVO queryWaybyCityid(String cityid) throws Exception{
		Session session = SessionUtils.currentSession(WayVO.class,getDbFlag());
		Query query=session.getNamedQuery("getwaybycityid");
		query.setString("cityid", cityid);
		List list= query.list();
		if(list.size()>0){
			return (WayVO)list.get(0);
		}
		return null;
	}
	
	public boolean checkisNetWork(String wayid) throws Exception{
		Session session = SessionUtils.currentSession(WayVO.class,getDbFlag());
		Query query = session.getNamedQuery("checkisnetwork");
		query.setString("basewayid", wayid);
		List list=query.list();
		if(list.size()>0){
			Long number=(Long)list.get(0);
			if(number.intValue()>0){
				return true;
			}
		}
		return false;
	}
	
	public List queryNetWork(String wayid) throws Exception{
		Session session = SessionUtils.currentSession(WayVO.class,getDbFlag());
		Query query = session.getNamedQuery("querynetwork");
		query.setString("basewayid", wayid);
		List list=query.list();
		return list;
	}
	
	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled) {
		Session session = SessionUtils.currentSession(WayVO.class,getDbFlag());

		Query query = session.getNamedQuery("queryUpperWaysAndMeByIdOrName");

		query.setParameter("idorname", "%" + queryText + "%");
		if (!showDisabled)
			query.setParameter("waystate", new Short((short) 1));
		else
			query.setParameter("waystate", new Short((short) 0));

		List list = query.list();

		DataPackage dataPack = new DataPackage();
		dataPack.setDatas(list);
		dataPack.setPageNo(0);
		dataPack.setPageSize(0);
		dataPack.setRowCount(list.size());
		return dataPack;
	}
	
	/**
	 * 查询零售渠道信息管理
	 * 
	 * @param params
	 * @param baseWayid
	 * @return
	 * @throws Exception
	 */
	public DataPackage querySaleway(WayDBParam params, String baseWayid)
			throws Exception {
		params.getQueryConditions().put("basewayid", baseWayid);
		return queryByNamedSqlQuery("boss.cms.querySaleway", params, 0);
	}
	
	public DataPackage querySubSaleway(WayDBParam params, String baseWayid)
			throws Exception {
		params.getQueryConditions().put("basewayid", baseWayid);
		//queryByNamedSqlQuery("com.gmcc.pboss.business.sales.order.OrderDisformList1", params);
		return queryByNamedSqlQuery("boss.cms.querySubSaleway", params);
	}
	
	/**
	 * 社会渠道查询，查询操作员可以浏览的记录 
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByOprcode(WayDBParam params, String baseWayid)
			throws Exception {
		params.getQueryConditions().put("basewayid", baseWayid);
		return queryByNamedSqlQuery("boss.cms.queryWayByUser", params, 0);
	}
	
	public DataPackage queryAllZJTYWay(Collection col,DBAccessUser user)throws Exception {
		
		Collection coll = col;
		Iterator iter = coll.iterator();
//		WayprovinceDelegate wayprovincedelegate = new WayprovinceDelegate();
		Wayprovince  wayprovincedelegate=(Wayprovince)BOFactory.build(WayprovinceBO.class,user);
//		BchcontactDelegate bchcontactDelegate = new BchcontactDelegate();
		Bchcontact  bchcontactDelegate=(Bchcontact)BOFactory.build(BchcontactBO.class,user);
//		WaycompactDelegate waycompactDelegate = new WaycompactDelegate();
		Waycompact  waycompactDelegate=(Waycompact)BOFactory.build(WaycompactBO.class,user);
		
		DataPackage returndp = new DataPackage();
		Collection cl = new ArrayList();
		
		while(iter.hasNext()){
//			ZjtywayinfoForm zjtywayinfoform = new ZjtywayinfoForm();
			ZjtywayinfoVO zjtywayinfoVO=new ZjtywayinfoVO();
			WayVO wayvo = (WayVO)iter.next();
			WayprovinceVO wayprovincevo = wayprovincedelegate.doFindByPk(wayvo.getWayid());
			BchcontactVO bchcontactVO = bchcontactDelegate.doFindByPk(wayvo.getWayid());
			WaycompactVO waycompactVO = waycompactDelegate.doFindByPk(wayvo.getWayid());
			if(wayprovincevo!=null){
			if(wayprovincevo.getUniquewayid()!=null)
			zjtywayinfoVO.setUniquewayid(wayprovincevo.getUniquewayid());
			if(wayprovincevo.getTown()!=null)
			zjtywayinfoVO.setTown(wayprovincevo.getTown());
			if(wayprovincevo.getProvtype()!=null)
			zjtywayinfoVO.setProvtype(wayprovincevo.getProvtype());
			if(wayprovincevo.getFrontarea()!=null)
			zjtywayinfoVO.setFrontarea(wayprovincevo.getFrontarea());
			if(wayprovincevo.getMobilemall()!=null)
			zjtywayinfoVO.setMobilemall(wayprovincevo.getMobilemall());
			if(wayprovincevo.getHaswaitmach()!=null)
			zjtywayinfoVO.setHaswaitmach(wayprovincevo.getHaswaitmach());
			if(wayprovincevo.getHasposmach()!=null)
			zjtywayinfoVO.setHasposmach(wayprovincevo.getHasposmach());
			if(wayprovincevo.getHas24mall()!=null)
			zjtywayinfoVO.setHas24mall(wayprovincevo.getHas24mall());
			if(wayprovincevo.getHasvipseat()!=null)
			zjtywayinfoVO.setHasvipseat(wayprovincevo.getHasvipseat());
			if(wayprovincevo.getHasviproom()!=null)
			zjtywayinfoVO.setHasviproom(wayprovincevo.getHasviproom());
			if(wayprovincevo.getG3area()!=null)
			zjtywayinfoVO.setG3area(wayprovincevo.getG3area());
			if(wayprovincevo.getUniquewayid()!=null)
				zjtywayinfoVO.setUniquewayid(wayprovincevo.getUniquewayid());
			}
			if(bchcontactVO!=null){
			if(bchcontactVO.getBusnum()!=null)
			zjtywayinfoVO.setBusnum(bchcontactVO.getBusnum());
			if(bchcontactVO.getPrincipal()!=null)
			zjtywayinfoVO.setPrincipal(bchcontactVO.getPrincipal());
			if(bchcontactVO.getCertinum()!=null)
			zjtywayinfoVO.setCertinum(bchcontactVO.getCertinum());
			if(bchcontactVO.getCompany()!=null)
			zjtywayinfoVO.setCompany(bchcontactVO.getCompany());
			if(bchcontactVO.getPrincipaltel()!=null)
			zjtywayinfoVO.setPrincipaltel(bchcontactVO.getPrincipaltel());
			}
			if(waycompactVO!=null){
			if(waycompactVO.getCompactno()!=null)
			zjtywayinfoVO.setCompactno(waycompactVO.getCompactno());
			if(waycompactVO.getBegintime()!=null)
			zjtywayinfoVO.setBegintime(waycompactVO.getBegintime());
			if(waycompactVO.getEndtime()!=null)
			zjtywayinfoVO.setEndtime(waycompactVO.getEndtime());
			if(waycompactVO.getSigntime()!=null)
			zjtywayinfoVO.setSigntime(waycompactVO.getSigntime());
			if(waycompactVO.getCompactname()!=null)
			zjtywayinfoVO.setCompactname(waycompactVO.getCompactname());
			}
			
			BeanUtils.copyProperties(zjtywayinfoVO, wayvo);
			cl.add(zjtywayinfoVO);
		}
		
		returndp.setDatas((List)cl);
		return returndp;
		}
	
}
