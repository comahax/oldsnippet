package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: HangbillDAO</p>
 * <p>Description: Data Access Object for HangbillVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class HangbillDAO extends BaseDAO {

    
    public HangbillDAO(){
        super(HangbillVO.class);
    }
    
    public List getMWBusType(String portid) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	StringBuffer buf = new StringBuffer("select b.bustype,b.busname,a.portid ")
    		.append(" from MwCodeVO a ,MwBusTypeVO b ")
	    	.append(" where a.portid = :portid and a.bustype = b.bustype")
	    	.append(" and a.begintime <=:current and a.endtime >:current");
    	
    	Query query = session.createQuery(buf.toString());
    	query.setString("portid", portid);
    	query.setDate("current", new Date(System.currentTimeMillis()));
    	return query.list();
    }
    
    
    public List getBusTypeByPortid(String portid) throws Exception {
    	
    	StringBuffer buf = new StringBuffer("").append("from MwCodeVO this ")
	    	.append(" where this.portid = :portid ")
	    	.append(" and this.begintime <= :current and this.endtime > :current");
    	
    	Session session = SessionUtil.currentSession(getDbFlag());
    	Query query = session.createQuery(buf.toString());
    	
    	query.setString("portid", portid);
    	query.setDate("current", new Date(System.currentTimeMillis()));
    	return query.list();
    }
    

    /** 此函数已经不用了，用到请写个注释
     * @deprecated
     **/
    public DataPackage getHangBILL(String mobileno ,HangbillListVO vo) throws Exception {
    	if (mobileno == null ) return null;
    	StringBuffer countHQL = new StringBuffer("SELECT count(*) from SubscriberVO a ,HangbillVO b")
    	.append(" where a.servnumber = :callno and a.subsid = b.subsid");
    	if (vo.getAcctid() != null && vo.getAcctid().longValue() != 0) {
    		countHQL.append(" and b.acctid = :acctid ");
		}
		if (vo.getValidbillcyc() != null && vo.getValidbillcyc().intValue() != 0) {
			countHQL.append(" and b.validbillcyc = :validbillcyc ");
		}

		if (vo.getHangstate() != null && vo.getHangstate().intValue() != -1)
		countHQL.append(" and b.hangstate = :hangstate ");
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
        	query.setString("callno", mobileno);
        	if (vo.getAcctid() != null && vo.getAcctid().longValue() != 0) {
				query.setLong("acctid", vo.getAcctid().longValue());
			}
        	if (vo.getValidbillcyc() != null && vo.getValidbillcyc().intValue() != 0) {
				query.setInteger("validbillcyc", vo.getValidbillcyc().intValue());
			}
     
        	if (vo.getHangstate() != null && vo.getHangstate().intValue() != -1)
			query.setInteger("hangstate", vo.getHangstate().intValue());
            Iterator iter = query.iterate(); // hibernate3的写法
            if (iter != null && iter.hasNext()) {
            	result.setRowCount(((Integer) iter.next()).intValue());
            } else {
            	result.setRowCount(0);
            }
            StringBuffer sqlbuf = new StringBuffer("select a.servnumber,b.hangid,b.eboxid,b.subsid,b.acctid,b.validbillcyc,")
    		.append(" b.hangoprcode,b.hangtime,b.hangamt,b.hangstate,b.lrsncode,b.srsncode,b.isicp,b.checkdecr,b.unite,b.portid,b.icptype,b.lodge,b.isaward ")
    		.append("from SubscriberVO a ,HangbillVO b")
    		.append(" where a.servnumber = :callno and  a.subsid = b.subsid");
            if (vo.getAcctid() != null && vo.getAcctid().longValue() != 0) {
            	sqlbuf.append(" and b.acctid = :acctid ");
    		}
    		if (vo.getValidbillcyc() != null && vo.getValidbillcyc().intValue() != 0) {
    			sqlbuf.append(" and b.validbillcyc = :validbillcyc ");
    		}
    	
    		if (vo.getHangstate() != null && vo.getHangstate().intValue() != -1)
    		sqlbuf.append(" and b.hangstate = :hangstate ");
    		
    		/** add by mys  start**/
    		sqlbuf.append(getOrderByStr(vo));
    		/** add by mys  end**/
    		
    		Query query1 = session.createQuery(sqlbuf.toString());
            if (_pagesize != 0) {
            	query1.setMaxResults(_pagesize);
            	query1.setFirstResult(_pagesize * (_pageno - 1));
            }
            query1.setString("callno", mobileno);
            if (vo.getAcctid() != null && vo.getAcctid().longValue() != 0) {
				query1.setLong("acctid", vo.getAcctid().longValue());
			}
        	if (vo.getValidbillcyc() != null && vo.getValidbillcyc().intValue() != 0) {
				query1.setInteger("validbillcyc", vo.getValidbillcyc().intValue());
			}
       
        	if (vo.getHangstate() != null && vo.getHangstate().intValue() != -1)
			query1.setInteger("hangstate", vo.getHangstate().intValue());
            result.setDatas(query1.list());
        } catch (HibernateException ex) {
        	throw ex;
        }
        return result;
    }
    
    /** 添加排序的sql语句 add by mys  默认按 帐务周期降序 **/
    private String getOrderByStr(BaseListVO listvo){
    	String _orderby = listvo.get_orderby();
    	String _desc = listvo.get_desc(); 
    	
    	if((null == _desc || "".equals(_desc)) && (null == _orderby || "".equals(_orderby))){
    		_desc = "1";
    		_orderby = "validbillcyc";
    	}
    	
    	if((null == _desc || "".equals(_desc)) && (null != _orderby && !"".equals(_orderby))){
    		_desc = "0";
    	}
    	if(null == _orderby || "".equals(_orderby)){
    		_orderby = "validbillcyc";
    	}
    	return " order by b." + _orderby + ("0".equals(_desc) ? " asc" : " desc");
    	    	
    }
}