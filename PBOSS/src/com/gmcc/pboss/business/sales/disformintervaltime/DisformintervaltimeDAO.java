/**
 * auto-generated code
 * Sat Mar 31 17:39:06 CST 2012
 */
package com.gmcc.pboss.business.sales.disformintervaltime;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.disform.SDisformVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DisformintervaltimeDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformintervaltimeDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public DisformintervaltimeDAO(){
        super(DisformintervaltimeVO.class);
    }
    
    //【分销管理】—>【配送单管理】 ->【配送单超时预警统计查询】
    public DataPackage doDisformStat(DisformintervaltimeDBParam params) throws Exception {
    	int _pagesize = 20, _pageno = 1;
		//String _orderby = null, _desc = null;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,"_pageno"));
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,"_pagesize"));
		} catch (Exception ex) {
			_pageno = 1;
			_pagesize = 20;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		result.setPageSize(new Integer(params.get_pagesize()));
		
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("select allorder.countyid,allorder.mareacode,allorder.starlevel,allorder.total as totalorder,undisover.total as totalovertime");
		sbsql.append("  from (select fx.countyid, fx.mareacode, fx.starlevel, count(*) as total");
		sbsql.append("          from FX_SW_ORDER fx, fx_sw_disform fxform");
		sbsql.append("         where fx.orderid = fxform.orderid and fx.confirmflag = 0");

		StringBuffer sbparams = new StringBuffer();
//		if(StringUtils.isNotEmpty(params.get_se_countyid())){
//			sbparams.append(" and fx.countyid = '").append(params.get_se_countyid()).append("' ");
//		}
//		if(StringUtils.isNotEmpty(params.get_se_mareacode())){
//			sbparams.append(" and fx.mareacode = '").append(params.get_se_mareacode()).append("' ");
//		}
//		if(StringUtils.isNotEmpty(params.get_ne_starlevel())){
//			sbparams.append(" and fx.starlevel =").append(params.get_ne_starlevel()).append(" ");
//		}
//		if(StringUtils.isNotEmpty(params.get_dnl_createtime())){
//			sbparams.append(" and fxform.createtime >= to_date('").append(params.get_dnl_createtime()).append("','yyyy-MM-dd hh24:mi:ss') ");
//		}
//		if(StringUtils.isNotEmpty(params.get_dnm_createtime())){
//			sbparams.append(" and fxform.createtime <= to_date('").append(params.get_dnm_createtime()).append("','yyyy-MM-dd hh24:mi:ss') ");
//		}
		/////////////////////////
		if(StringUtils.isNotEmpty(params.get_se_countyid())){
			sbparams.append(" and fx.countyid = :countyid ");
		}
		if(StringUtils.isNotEmpty(params.get_se_mareacode())){
			sbparams.append(" and fx.mareacode = :mareacode ");
		}
		if(StringUtils.isNotEmpty(params.get_ne_starlevel())){
			sbparams.append(" and fx.starlevel = :starlevel ");
		}
		
		sbparams.append(" and fxform.createtime >= :nldate ");	
		sbparams.append(" and fxform.createtime <= :nmdate ");	
		
		sbsql.append( sbparams.toString() );
		
		sbsql.append("         group by fx.countyid, fx.mareacode, fx.starlevel) allorder");
		sbsql.append("  left outer join (select ff.countyid,ff.mareacode,ff.starlevel,count(*) total");
		sbsql.append("                     from (select fx.orderid,fx.countyid,fx.mareacode,fx.starlevel,");
		sbsql.append("                                  case fx.orderstate");
		sbsql.append("                                      when 'FINISHED' then round(fx.disovertime - fxform.createtime, 0)");
		sbsql.append("                                      else round(sysdate - fxform.createtime, 0)");
		sbsql.append("                                  end  da");		
		//sbsql.append("                                  round(sysdate - fxform.createtime, 0) da");
		sbsql.append("                             From FX_SW_ORDER fx, fx_sw_disform fxform");
		sbsql.append("                            where fx.orderid = fxform.orderid and fx.confirmflag = 0");
		
		sbsql.append( sbparams.toString() );
		
		sbsql.append("                           ) ff");
		sbsql.append("                     left outer join FX_SW_DISFORMINTERVALTIME fs");
		sbsql.append("                       on ff.countyid = fs.countyid and ff.mareacode = fs.mareacode");
		sbsql.append("                      and ff.starlevel = fs.starlevel");
		sbsql.append("                    where fs.intervaltime < ff.da");
		sbsql.append("                    group by ff.countyid, ff.mareacode, ff.starlevel ");
		sbsql.append("                   ) undisover");
		sbsql.append("    on allorder.countyid = undisover.countyid and allorder.mareacode = undisover.mareacode and allorder.starlevel = undisover.starlevel");
		sbsql.append("   order by allorder.countyid,allorder.mareacode,allorder.starlevel");
		
		Session session = SessionUtils.currentSession(getDbFlag());
		
		try{
			// 取总页数
			Query querySel = session.createSQLQuery(sbsql.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar("mareacode", Hibernate.STRING)
					.addScalar("starlevel", Hibernate.LONG).addScalar("totalorder", Hibernate.LONG)
					.addScalar("totalovertime", Hibernate.LONG);
			if(StringUtils.isNotEmpty(params.get_se_countyid())){
				querySel.setString("countyid", params.get_se_countyid());
			}
			if(StringUtils.isNotEmpty(params.get_se_mareacode())){
				querySel.setString("mareacode", params.get_se_mareacode());
			}
			if(StringUtils.isNotEmpty(params.get_ne_starlevel())){
				querySel.setLong("starlevel", new Long(params.get_ne_starlevel()));
				//querySel.setBigDecimal("starlevel", new BigDecimal(params.get_ne_starlevel()));
			}			//to_date(:nldate,'yyyy-MM-dd hh24:mi:ss')
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//querySel.setString("nldate", "to_date('"+params.get_dnl_createtime()+"','yyyy-MM-dd hh24:mi:ss')");
			//querySel.setString("nmdate", "to_date('"+params.get_dnm_createtime()+"','yyyy-MM-dd hh24:mi:ss')");
			querySel.setDate("nldate", fmt.parse(params.get_dnl_createtime()));
			querySel.setDate("nmdate", fmt.parse(params.get_dnm_createtime()));		
			
			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);			
			
			// 取指定页面
			List list = null;
			if(_pagesize != 0){//分页查询
				iter.clear();
				querySel.setMaxResults(_pagesize);
				querySel.setFirstResult(_pagesize * (_pageno - 1));
				list = querySel.list();
			}else{//全量查询，导出用
				list = iter;
			}			
			
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				DisformintervalStatInfo info = new DisformintervalStatInfo();
				Object[] obj = (Object[]) itt.next();
				info.setCountyid(obj[0] == null ? "" : obj[0].toString());
				info.setMareacode(obj[1] == null ? "" : obj[1].toString());
				info.setStarlevel(obj[2] == null ? new Long("0") : new Long(obj[2].toString()));
				info.setTotalorder(obj[3] == null ? new Long("0") : new Long(obj[3].toString()));
				info.setTotalovertime(obj[4] == null ? new Long("0") : new Long(obj[4].toString()));

				list2.add(info);
			}

			result.setDatas(list2);
			list.clear();
			
		}catch(Exception e){
			if (e.getCause() != null) {
				e.printStackTrace();
				throw new Exception(e.getCause());
			} else {
				throw e;
			}
		}		
		return result;
    }
}
