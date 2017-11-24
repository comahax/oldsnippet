/**
* auto-generated code
* Fri Dec 09 10:35:29 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.allsalesday.control;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayDAO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayListVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.VAllsalesdayDAO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.VBusistatisticDAO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.VWaybusistatisticDAO;

/**
 * <p>Title: AllsalesdayControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/allsalesday/control/AllsalesdayControlBean"
 name="AllsalesdayControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AllsalesdayControlBean extends AbstractControlBean
    implements AllsalesdayControl {

    public AllsalesdayVO doCreate(AllsalesdayVO vo, User user)
        throws Exception {
        try{
			AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
            // TODO  set the pk */
            return (AllsalesdayVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AllsalesdayVO vo, User user)
        throws Exception {
        try{
			AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AllsalesdayVO doUpdate(AllsalesdayVO vo, User user)
        throws Exception {
        try{
			AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
            return (AllsalesdayVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AllsalesdayVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
        return (AllsalesdayVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AllsalesdayListVO params, User user)
        throws Exception {
			AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQueryWithEmpinfo(AllsalesdayListVO params, User user) 
		throws Exception {
    	VAllsalesdayDAO dao = (VAllsalesdayDAO) DAOFactory.build(VAllsalesdayDAO.class, user);
		String oprcode = user.getOpercode();//登录工号
		AllsalesdayListVO listvo = new AllsalesdayListVO();
		listvo.getQueryConditions().put("oprcode", oprcode);
		Integer cityAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCityAdmin", listvo, Integer.class);
		if(cityAdmin!=null && cityAdmin>0){//不为空，登录工号为市公司管理员
			return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.vallsalesday.queryAllsalesdayCityAdmin",params);
		}else{
			listvo = new AllsalesdayListVO();
			listvo.getQueryConditions().put("oprcode", oprcode);
			String upperwayid = "TD"+SessionFactoryRouter.conversionCityid(user.getCityid())+"-----";//市公司对应渠道编码
			listvo.getQueryConditions().put("upperwayid", upperwayid);
			Integer countyAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCountyAdmin", listvo, Integer.class);
			if(countyAdmin!=null && countyAdmin>0){//不为空，登录工号为分公司管理员
				params.getQueryConditions().put("wayid", user.getWayid());
				return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.vallsalesday.queryAllsalesdayCountyAdmin", params);
			}else{//登陆工号不是市公司管理员或分公司管理员，不允许使用该功能
				throw new Exception("登陆工号不是市公司管理员或分公司管理员，不允许使用该功能");
			}
		}		
    }
    
    /*
     * 统计业务总量、有推广的网点数、有推广的渠道数
     */
    public Map doStatistic(AllsalesdayListVO params, User user)
		throws Exception{
    	Map<String,Long> map = new HashMap<String,Long>();
    	Long busi= null;
    	Long way = null;
    	Long opr = null;    	
    	AllsalesdayDAO dao = (AllsalesdayDAO) DAOFactory.build(AllsalesdayDAO.class, user);
    	String oprcode = user.getOpercode();//登录工号
		AllsalesdayListVO listvo = new AllsalesdayListVO();
		listvo.getQueryConditions().put("oprcode", oprcode);
		Integer cityAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCityAdmin", listvo, Integer.class);
		if(cityAdmin!=null && cityAdmin>0){//不为空，登录工号为市公司管理员
			busi = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.city.busiTotalStatistic", params, Long.class);
			way  = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.city.wayTotalStatistic", params, Long.class);
			opr  = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.city.oprTotalStatistic", params, Long.class);
		}else{
			listvo = new AllsalesdayListVO();
			listvo.getQueryConditions().put("oprcode", oprcode);
			String upperwayid = "TD"+SessionFactoryRouter.conversionCityid(user.getCityid())+"-----";//市公司对应渠道编码
			listvo.getQueryConditions().put("upperwayid", upperwayid);
			Integer countyAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCountyAdmin", listvo, Integer.class);
			if(countyAdmin!=null && countyAdmin>0){//不为空，登录工号为分公司管理员
				params.getQueryConditions().put("wayid", user.getWayid());
				busi = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.county.busiTotalStatistic", params, Long.class);
				way  = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.county.wayTotalStatistic", params, Long.class);
				opr  = (Long)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.county.oprTotalStatistic", params, Long.class);
			}else{
				throw new Exception("登陆工号不是市公司管理员或分公司管理员，不允许使用该功能");
			}
		}
		map.put("业务总量", busi);
		map.put("有推广的渠道数", way);
		map.put("有推广的专员人数", opr);
    	return map;
    }
    
    /*
     *统计各业务对应的业务量 
     */
    public DataPackage doStatisticBusiDetail(AllsalesdayListVO params, User user)
		throws Exception{ 
    	DataPackage dp = new DataPackage();
    	VBusistatisticDAO dao = (VBusistatisticDAO)DAOFactory.build(VBusistatisticDAO.class, user);
    	String oprcode = user.getOpercode();//登录工号
		AllsalesdayListVO listvo = new AllsalesdayListVO();
		listvo.getQueryConditions().put("oprcode", oprcode);
		Integer cityAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCityAdmin", listvo, Integer.class);
		if(cityAdmin!=null && cityAdmin>0){//不为空，登录工号为市公司管理员			
			dp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.city.busiDetailTotalStatistic", params);
		}else{
			listvo = new AllsalesdayListVO();
			listvo.getQueryConditions().put("oprcode", oprcode);
			String upperwayid = "TD"+SessionFactoryRouter.conversionCityid(user.getCityid())+"-----";//市公司对应渠道编码
			listvo.getQueryConditions().put("upperwayid", upperwayid);
			Integer countyAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCountyAdmin", listvo, Integer.class);
			if(countyAdmin!=null && countyAdmin>0){//不为空，登录工号为分公司管理员
				params.getQueryConditions().put("wayid", user.getWayid());
				dp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.county.busiDetailTotalStatistic", params);				
			}else{
				throw new Exception("登陆工号不是市公司管理员或分公司管理员，不允许使用该功能");
			}
		}
    	
    	return dp;
    }
    
    /*
     * 统计汇总各渠道办理的各业务总量
     */
    public DataPackage doStatisticWayBusiDetail(AllsalesdayListVO params, User user)
    	throws Exception{
    	DataPackage dp = new DataPackage();
    	VWaybusistatisticDAO dao = (VWaybusistatisticDAO)DAOFactory.build(VWaybusistatisticDAO.class, user);
    	String oprcode = user.getOpercode();//登录工号
		AllsalesdayListVO listvo = new AllsalesdayListVO();
		listvo.getQueryConditions().put("oprcode", oprcode);
		Integer cityAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCityAdmin", listvo, Integer.class);
		if(cityAdmin!=null && cityAdmin>0){//不为空，登录工号为市公司管理员			
			dp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.city.wayBusiDetailTotalStatistic", params);
		}else{
			listvo = new AllsalesdayListVO();
			listvo.getQueryConditions().put("oprcode", oprcode);
			String upperwayid = "TD"+SessionFactoryRouter.conversionCityid(user.getCityid())+"-----";//市公司对应渠道编码
			listvo.getQueryConditions().put("upperwayid", upperwayid);
			Integer countyAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCountyAdmin", listvo, Integer.class);
			if(countyAdmin!=null && countyAdmin>0){//不为空，登录工号为分公司管理员
				params.getQueryConditions().put("wayid", user.getWayid());
				dp = dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.allsalesday.county.wayBusiDetailTotalStatistic", params);				
			}else{
				throw new Exception("登陆工号不是市公司管理员或分公司管理员，不允许使用该功能");
			}
		}
    	return dp;
    }
}
