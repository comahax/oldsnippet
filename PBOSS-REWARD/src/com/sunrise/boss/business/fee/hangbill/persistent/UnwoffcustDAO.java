/**
* auto-generated code
* Wed Aug 16 09:58:20 CST 2006
*/
package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;



/**
 * <p>Title: UnwoffcustDAO</p>
 * <p>Description: Data Access Object for UnwoffcustVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class UnwoffcustDAO extends BaseDAO {

    /**
     * default constructor
     */
    public UnwoffcustDAO(){
        super(UnwoffcustVO.class);
    }
    
    public DataPackage getWoffCustByCallno(UnwoffcustListVO vo) throws Exception {
    	if (vo.getMoblieno() == null ) return null;
    	
    	StringBuffer countHQL = new StringBuffer("SELECT count(*) from SubscriberVO a ,UnwoffcustVO b")
    	.append(" where a.servnumber = :callno and a.subsid = b.subsid");
    	if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
    		countHQL.append(" and b.acctid = :acctid ");
		}
		if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
			countHQL.append(" and b.validbillcyc = :validbillcyc ");
		}
		int _pagesize = 20, _pageno = 1;
        try { 
            _pageno = Integer.parseInt((String) BeanUtils.getProperty(vo,
                    "_pageno"));
        } catch (Exception ex) {
            _pageno = 1;
        }
        
        DataPackage result = new DataPackage();
        result.setPageNo(_pageno);
        result.setPageSize(_pagesize);
        Session session = SessionUtil.currentSession(this.getDbFlag());

        try {
        	Query query = session.createQuery(countHQL.toString());
        	query.setString("callno", vo.getMoblieno());
			if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
				query.setString("acctid", vo.get_ne_acctid());
			}
			if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
				query.setString("validbillcyc", vo.get_ne_validbillcyc());
			}
            Iterator iter = query.iterate(); // hibernate3的写法
            if (iter != null && iter.hasNext()) {
            	result.setRowCount(((Integer) iter.next()).intValue());
            } else {
            	result.setRowCount(0);
            }
            StringBuffer sqlbuf = new StringBuffer("select a.servnumber,b.eboxid,b.subsid,b.acctid,b.validbillcyc,")
    		.append(" b.recamt,b.state  from SubscriberVO a ,UnwoffcustVO b")
    		.append(" where a.servnumber = :callno and a.subsid = b.subsid");
    		if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
    			sqlbuf.append(" and b.acctid = :acctid ");
    		}
    		if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
    			sqlbuf.append(" and b.validbillcyc = :validbillcyc ");
    		}
    		
    		/** add by mys  start**/
    		sqlbuf.append(getOrderByStr(vo));
    		/** add by mys  end**/
    		

    		Query query1 = session.createQuery(sqlbuf.toString());
            if (_pagesize != 0) {
            	query1.setMaxResults(_pagesize);
            	query1.setFirstResult(_pagesize * (_pageno - 1));
            }
            query1.setString("callno", vo.getMoblieno());
			if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
				query1.setString("acctid", vo.get_ne_acctid()); 
			}
			if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
				query1.setString("validbillcyc", vo.get_ne_validbillcyc());
			}
            result.setDatas(query1.list());
        } catch (HibernateException ex) {
        	throw ex;
        }
        return result;
    }
    
    public List getWoffCust(UnwoffcustListVO vo) throws Exception {
    	if (vo.getMoblieno() == null ) return null;
    	Session session = SessionUtil.currentSession(this.getDbFlag());
    	StringBuffer sqlbuf = new StringBuffer("select a.servnumber,b.eboxid,b.subsid,b.acctid,b.validbillcyc,")
		.append(" b.recamt,b.state  from SubscriberVO a ,UnwoffcustVO b")
		.append(" where a.servnumber = :callno and a.subsid = b.subsid "); 
    	if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
			sqlbuf.append(" and b.acctid = :acctid ");
		}
		if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
			sqlbuf.append(" and b.validbillcyc = :validbillcyc ");
		}
		
		/** add by mys  start**/
		sqlbuf.append(getOrderByStr(vo));
		/** add by mys  end**/
		
		Query query = session.createQuery(sqlbuf.toString());
		query.setString("callno", vo.getMoblieno());
		if (vo.get_ne_acctid() != null && !vo.get_ne_acctid().equals("")) {
			query.setString("acctid", vo.get_ne_acctid()); 
		}
		if (vo.get_ne_validbillcyc() != null && !vo.get_ne_validbillcyc().equals("")) {
			query.setString("validbillcyc", vo.get_ne_validbillcyc());
		}

		query.toString();
		return query.list();
    }
      
    /** 添加排序的sql语句 add by mys  默认按 帐务周期降序 **/
    private String getOrderByStr(BaseListVO listvo){
    	
    	String default_orderby = " b.eboxid asc, b.subsid asc, b.acctid asc, b.validbillcyc desc ";
    	String _orderby = listvo.get_orderby();
    	String _desc = null != listvo.get_desc() && "1".equals(listvo.get_desc().trim()) 
						? " desc, " : " asc, ";    	    	
        
        StringBuffer orderby = new StringBuffer(" order by ");
        orderby.append(null == _orderby || "".equals(_orderby.trim()) 
        			? default_orderby :  " b." + _orderby + _desc +  default_orderby);      	    	
    
    	return orderby.toString();    	    	
    }
    
    
}