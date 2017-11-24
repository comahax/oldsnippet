/**
 * auto-generated code
 * Sat Aug 13 12:50:41 CST 2011
 */
package com.gmcc.pboss.business.sales.disformprint;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * <p>Title: DisformprintDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformprintDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public DisformprintDAO(){
        super(DisformprintVO.class);//注意：此处为配送单表，不是虚表
    }
    
    /*
     * 根据分公司、商品类型获取配送单汇总统计信息
     */
    public DataPackage getCountyComStat(DisformprintDBParam params){
    	Session session = SessionUtils.currentSession(getDbFlag());
    	StringBuffer sqlstring = new StringBuffer(1000);
    	sqlstring.append("select b.countyid, c.comid, count(*) num");
    	sqlstring.append(" from FX_SW_DISFORM a, FX_SW_ORDER b, FX_SW_ORDERRESDET c");
    	sqlstring.append(" where a.ORDERID = b.ORDERID");
    	sqlstring.append(" and b.ORDERID = c.ORDERID");
    	sqlstring.append(" and b.ORDERSTATE <> 'CANCEL'");
    	if(StringUtils.isNotEmpty(params.get_dnl_ordcreatetime()) 
    			&& StringUtils.isNotEmpty(params.get_dnm_ordcreatetime())){
    		sqlstring.append(" and b.CREATETIME >= to_date('"+params.get_dnl_ordcreatetime()+"','yyyy-MM-dd hh24:mi:ss')");//订单起始创建时间
    		sqlstring.append(" and b.CREATETIME <= to_date('"+params.get_dnm_ordcreatetime()+"','yyyy-MM-dd hh24:mi:ss')");//订单终止创建时间
    	}    	
    	if(StringUtils.isNotEmpty(params.get_dnl_createtime()) 
    			&& StringUtils.isNotEmpty(params.get_dnm_createtime())){
    		sqlstring.append(" and a.CREATETIME >= to_date('"+params.get_dnl_createtime()+"','yyyy-MM-dd hh24:mi:ss')");//配送单起始创建时间
        	sqlstring.append(" and a.CREATETIME <= to_date('"+params.get_dnm_createtime()+"','yyyy-MM-dd hh24:mi:ss')");//配送单终止创建时间
    	}
    	if(StringUtils.isNotEmpty(params.get_se_countyid())){
    		sqlstring.append(" and b.COUNTYID = '"+params.get_se_countyid().trim()+"'");//分公司
    	}
    	if(StringUtils.isNotEmpty(params.get_se_recewayid())){
    		sqlstring.append(" and a.RECEWAYID = '"+params.get_se_recewayid().trim()+"'");//合作商编码
    	}
    	if(StringUtils.isNotEmpty(params.get_se_discomcode())){
    		sqlstring.append(" and a.DISCOMCODE = '"+params.get_se_discomcode().trim()+"'");//配送商编码
    	}
    	if(StringUtils.isNotEmpty(params.get_se_disstate())){
    		sqlstring.append(" and a.DISSTATE = '"+params.get_se_disstate().trim()+"'");//配送单状态
    	}
    	sqlstring.append(" group by b.COUNTYID, c.COMID");
    	sqlstring.append(" order by b.COUNTYID, c.COMID");
    	
    	SQLQuery query = session.createSQLQuery(sqlstring.toString());
    	query.addScalar("countyid", Hibernate.STRING);
    	query.addScalar("comid", Hibernate.STRING);
    	query.addScalar("num", Hibernate.LONG);
    	List list = query.list();
    	List list0 = new ArrayList(list.size());
    	for (int i = 0; i < list.size(); i++) {
    		Object[] objects = (Object[]) list.get(i);
    		CountyComInfo info = new CountyComInfo((String)objects[0],(String)objects[1],(Long)objects[2]);
    		list0.add(info);
    	}
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list0);
    	dp.setRowCount(list0.size());
    	return dp;
    }
        
    /*
     * 根据给定订单编号，关联订单资源明细表和套卡资源明细表，获取商品标识和SIM卡号
     */
    public DataPackage getComIccInfo(String orderid)throws Exception{
    	DataPackage dp = new DataPackage();
    	Session session = SessionUtils.currentSession(this.getDbFlag());
    	Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.disformprint.getComIcc");
    	query.setString("ORDERID", orderid);
    	List list = query.list();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
    }
    
    /*
     * 根据给定订单编号，查询订单资源明细表，获取充值卡数据
     */
    public DataPackage getComCardResis(String orderid)throws Exception{
    	DataPackage dp = new DataPackage();
    	Session session = SessionUtils.currentSession(this.getDbFlag());
    	Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.disformprint.getComCardResid");
    	query.setString("ORDERID", orderid);
    	List list = query.list();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
    }
}
