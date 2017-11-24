/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
package com.gmcc.pboss.business.sales.ordercomcate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: OrdercomcateDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdercomcateDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrdercomcateDAO(){
        super(OrdercomcateVO.class);
    }
    
    
    public Long queryOrderamtByAllBrand(String orderid) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("queryOrderamtByAllBrand");
		query.setString("orderid", orderid);
		List list=query.list();
		if(list.size()>0){
			Long orderamt=(Long)list.get(0);
			return orderamt;
		}
		return null;
	}
    
    
   /* //关联查询订单表（FX_SW_ORDER）和订单商品种类（FX_SW_ORDERCOMCATE）统计合作商当月空白卡订购量
    public List<OrdercomcateStocksVO> doQueryEmptySimRealTimeUpdateDayMonthCount(String wayid) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateDayMonthCount");
//		query.setString("wayid", wayid);
//		List list=query.list();
//		if(list.size()>0){
//			Long orderamt=(Long)list.get(0);
//			return orderamt;
//		}
//		return null;
		String sql=query.getQueryString().replaceAll(":wayid", wayid);
		query=session.createSQLQuery(sql).addScalar("comcategory", Hibernate.STRING)
										.addScalar("orderamt", Hibernate.LONG);
		List<Object[]> list=query.list();
		List<OrdercomcateStocksVO> slist=new ArrayList<OrdercomcateStocksVO>();
		OrdercomcateStocksVO vo=null;
		if(list.size()>0){
			for(Object[] obj:list){
				vo=new OrdercomcateStocksVO();
				vo.setComcategory((String)obj[0]);
				vo.setOrderamt((Long)obj[1]);
				slist.add(vo);
			}
			
		}
		return slist;
	}*/
    
    
    /*//关联订单表（FX_SW_ORDER）、订单商品种类表（FX_SW_ORDERCOMCATE）对合作商未订购完成的空白卡进行统计
    public List<OrdercomcateStocksVO> doQueryEmptySimRealTimeUpdateBuyCount(String wayid) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateBuyCount");
//		query.setString("wayid", wayid);
//		List list=query.list();
//		if(list.size()>0){
//			Long orderamt=(Long)list.get(0);
//			return orderamt;
//		}
		String sql=query.getQueryString().replaceAll(":wayid", wayid);
		query=session.createSQLQuery(sql).addScalar("comcategory", Hibernate.STRING)
										.addScalar("orderamt", Hibernate.LONG);
		List<Object[]> list=query.list();
		List<OrdercomcateStocksVO> slist=new ArrayList<OrdercomcateStocksVO>();
		OrdercomcateStocksVO vo=null;
		if(list.size()>0){
			for(Object[] obj:list){
				vo=new OrdercomcateStocksVO();
				vo.setComcategory((String)obj[0]);
				vo.setOrderamt((Long)obj[1]);
				slist.add(vo);
			}
			
		}
		return slist;
//		return null;
	}*/
    
    /**
     *对客户订购空白SIM卡数量进行统计
     * @param orderid
     * @return
     * @throws Exception
     */
    public Long querySimamtByOrderID(String orderid) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("querySimamtByOrderID");
		query.setString("orderid", orderid);
		List list=query.list();
		if(list.size()>0){
			Long orderamt=(Long)list.get(0);
			return orderamt;
		}
		return null;
	}

    
    
    public Long queryOrderamtByBrand(String orderid, String brand) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("queryOrderamtByBrand");
		query.setString("orderid", orderid);
		query.setString("brand", brand);
		List list=query.list();
		if(list.size()>0){
			Long orderamt=(Long)list.get(0);
			return orderamt;
		}
		return null;
	}
	/**
	 * 查询审核库存检查所需的信息
	 * @param orderids
	 * @return
	 * @throws Exception
	 */
	 public List<OrdercomcateStocksVO> doOrdercomcateStocksQuery(String[] orderids ) throws Exception  {
		Session session = SessionUtils.currentSession(getDbFlag());
		String orderidss="";
		for(String s:orderids){
			if("".equals(orderidss)){
				orderidss=s;
			}else{
				orderidss+="','"+s;
			}
		}
		Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.doOrdercomcateStocksQuery");
		String sql=query.getQueryString().replaceAll(":orderids", orderidss);
		query=session.createSQLQuery(sql).addScalar("comcategory", Hibernate.STRING)
										.addScalar("ordercomtype", Hibernate.STRING)
										.addScalar("countyid", Hibernate.STRING)
										.addScalar("svccode", Hibernate.STRING)
										.addScalar("orderamt", Hibernate.LONG);
		List<Object[]> list=query.list();
		List<OrdercomcateStocksVO> slist=new ArrayList<OrdercomcateStocksVO>();
		OrdercomcateStocksVO vo=null;
		if(list.size()>0){
			for(Object[] obj:list){
				vo=new OrdercomcateStocksVO();
				vo.setComcategory((String)obj[0]);
				vo.setOrdercomtype((String)obj[1]);
				vo.setCountyid((String)obj[2]);
				vo.setSvccode((String)obj[3]);
				vo.setOrderamt((Long)obj[4]);
				slist.add(vo);
			}
			
		}
		return slist;
	}
}
