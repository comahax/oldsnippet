/**
 * auto-generated code
 * Fri Sep 25 15:08:38 CST 2009
 */
package com.gmcc.pboss.business.resource.compack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CompackDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class CompackDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CompackDAO(){
        super(CompackVO.class);
    }
    public DataPackage doQueryCompackResdraw(CompackDBParam param,String countyid,String svccode,String mareacode) throws Exception {
    	Map conditionMap = new HashMap();
    	if(countyid!=null){
    		conditionMap.put("countyid", countyid);
    		param.setQueryConditions(conditionMap);
    		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.compack.doQueryCompackResdrawByCountyid", param);
    	}else if (svccode!=null){ 
    		conditionMap.put("svccode", svccode);
    		param.setQueryConditions(conditionMap);
    		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.compack.doQueryCompackResdrawBySvccode", param);
    	}else{
    		conditionMap.put("mareacode", mareacode);
    		param.setQueryConditions(conditionMap);
    		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.compack.doQueryCompackResdrawByMareacode", param);
    	}    	
    }

    
    //根据数量分组统计查询散包map    
    public DataPackage querySanMapByCount(CompackDBParam param,Long brandamt,String countyid,String svccode,String mareacode) throws Exception {
    	Session session = SessionUtils.currentSession(getDbFlag());
    	StringBuffer sqlstring = new StringBuffer(1000);
    	if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
    		sqlstring = new StringBuffer("select c.AMOUNT, count(*) NUM from IM_PR_COMPACK c");
        	if(null!=brandamt)
        		sqlstring.append(" where c.amount <"+brandamt);
        	if(null!=param.get_se_comcategory())
        		sqlstring.append(" and c.comcategory ='"+param.get_se_comcategory()+"'");
        	if(null!=param.get_se_discomcode()){
        		sqlstring.append(" and c.discomcode ='"+param.get_se_discomcode()+"'");
        	}
        	if(null!=param.get_se_nosect())
        		sqlstring.append(" and c.nosect ='"+param.get_se_nosect()+"'");
        	if(null!=param.get_se_packstate())
        		sqlstring.append(" and c.packstate ='"+param.get_se_packstate()+"'");
        	if(null!=param.get_se_resuse())
        		sqlstring.append(" and c.resuse ='"+param.get_se_resuse()+"'");
        	if(null!=param.get_se_storarea())
        		sqlstring.append(" and c.storarea ='"+param.get_se_storarea()+"'");
        	if(null!=param.get_se_wayid())
        		sqlstring.append(" and c.wayid ='"+param.get_se_wayid()+"'");
        	sqlstring.append( " group by c.amount");
		}else{//限定分公司资源查询商品包
			sqlstring = new StringBuffer("select c.AMOUNT, count(*) NUM from IM_PR_COMPACK c, CH_PW_WAY t2 where c.wayid=t2.wayid");
        	if(null!=brandamt)
        		sqlstring.append(" and c.amount <"+brandamt);
        	if(null!=param.get_se_comcategory())
        		sqlstring.append(" and c.comcategory ='"+param.get_se_comcategory()+"'");
        	if(null!=param.get_se_discomcode()){
        		sqlstring.append(" and c.discomcode ='"+param.get_se_discomcode()+"'");
        	}
        	if(null!=param.get_se_nosect())
        		sqlstring.append(" and c.nosect ='"+param.get_se_nosect()+"'");
        	if(null!=param.get_se_packstate())
        		sqlstring.append(" and c.packstate ='"+param.get_se_packstate()+"'");
        	if(null!=param.get_se_resuse())
        		sqlstring.append(" and c.resuse ='"+param.get_se_resuse()+"'");
        	if(null!=param.get_se_storarea())
        		sqlstring.append(" and c.storarea ='"+param.get_se_storarea()+"'");
        	if(null!=param.get_se_wayid())
        		sqlstring.append(" and c.wayid ='"+param.get_se_wayid()+"'");
        	
        	if(countyid!=null){
        		sqlstring.append(" and t2.countyid='"+countyid+"'");
        	}else if (svccode!=null){ 
        		sqlstring.append(" and t2.svccode='"+svccode+"'");
        	}else{
        		sqlstring.append(" and t2.mareacode='"+mareacode+"'");
        	}
        	sqlstring.append( " group by c.amount");
		}
    	
    	SQLQuery query = session.createSQLQuery(sqlstring.toString());
    	query.addScalar("AMOUNT", Hibernate.STRING);
    	query.addScalar("NUM", Hibernate.STRING);
    	List list = query.list();
    	List list0 = new ArrayList(list.size());
    	for (int i = 0; i < list.size(); i++) {
    		Object[] objects = (Object[]) list.get(i);
    		list0.add( convert2Map(objects, Arrays.asList("AMOUNT","NUM")));
    	}
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list0);
    	dp.setRowCount(list0.size());
    	return dp;
    }
    
    /**
	 * 将一条 Object[] 型的记录转化为Map
	 * @param objects
	 * @param selectFields
	 * @return
	 */
	private Map convert2Map(Object[] objects,List selectFields) {
		Map map = new HashMap((int)(objects.length * 1.34));
		for (int i = 0; i < objects.length; i++) {
			map.put( (String)selectFields.get(i), objects[i]);
		}
		return map;
	}
    
}
