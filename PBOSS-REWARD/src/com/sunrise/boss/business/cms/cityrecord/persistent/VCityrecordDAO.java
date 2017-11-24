/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.util.ArrayList;
import java.util.List;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.cms.cityrecord.CityrecordAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CityrecordDAO</p>
 * <p>Description: Data Access Object for CityrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VCityrecordDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VCityrecordDAO(){
        super(VCityrecordVO.class);
    }
    
    /**
     * 2013-05-03 确认管理查询  ch_adt_cityrecord 增加upperopnid,subopnid冗余字段，简化查询语句，提高查询效率
     * @param params
     * @param user
     * @return
     * @throws Exception
     */
    public DataPackage liststatenhance(VCityrecordListVO params,User user) throws Exception{
    	String wayid = params.get_se_wayid();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	String sin_opnid = params.get_sin_opnid();
    	String isflag = params.get_ne_isflag();
    	String taskid = params.get_ne_taskid();
    	String countyid = params.get_se_countyid();
    	String opnid = params.get_se_opnid();
    	String opnid2 = params.get_se_opnid2();
    	String paymonth = params.get_se_paymonth();
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("SELECT ROWNUM AS SEQID, T.opnid1,T.opnid2,T.rewardtype,T.dictname,T.oprmonth,T.isflag,");
    	sb.append("       T.sumbusivalue,T.sumpaymoney,T.sumnotconfirmmoney,T.sumconfirmmoney");
    	sb.append("  FROM (select r.upperopnid opnid1,r.subopnid opnid2,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) dictname,");
    	sb.append("               to_char(r.oprtime, 'yyyymm') oprmonth,r.isflag,sum(r.busivalue) sumbusivalue, sum(r.paymoney) sumpaymoney,");
    	sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney,");
    	sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney");
    	sb.append("          from ch_adt_cityrecord r,ch_pw_way w");
    	sb.append("         where r.wayid = w.wayid and r.isflag in (0, 1) ");
    	if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append("           and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1, op.length()-1));
			}
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
    	if(isflag!=null && !"".equals(isflag.trim())){
			sb.append("           and r.isflag = :isflag");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
    	if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("           and r.systemflag = :systemflag");
			params.getQueryConditions().put("systemflag", systemflag.trim());
			params.set_ne_systemflag(null);
		}
    	if(opnid!=null && !"".equals(opnid.trim())){
    		sb.append("           and r.upperopnid=:upperopnid");
    		params.getQueryConditions().put("upperopnid", opnid);
    		params.set_se_opnid(null);
    			
    	}
    	if(opnid2!=null && !"".equals(opnid2.trim())){
    		sb.append("           and r.subopnid=:subopnid");
    		params.getQueryConditions().put("subopnid", opnid2);
    		params.set_se_opnid2(null);
    	}
    	if(month!=null && !"".equals(month.trim())){
			sb.append("           and r.rewardmonth = :rewardmonth");
			params.getQueryConditions().put("rewardmonth", month.trim());
			params.set_se_rewardmonth(null);
		}
    	if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("           and r.taskid = :taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
    	if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("           and w.countyid = :countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
    	if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("           and r.wayid = :wayid");
			params.getQueryConditions().put("wayid", wayid.trim());
			params.set_se_wayid(null);
		}
    	 //新增付款月份
    	if (new CityrecordAction().isSupportPaymonth(user)){
    		if(paymonth!=null && !"".equals(paymonth.trim())){
    			sb.append("           and r.paymonth = :paymonth");
    			params.getQueryConditions().put("paymonth", paymonth.trim());
    			params.set_se_paymonth(null);
    		}
    	}
    	
    	sb.append("         group by r.upperopnid, r.subopnid, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T");
    	
    	return this.queryBySql(sb.toString(), params);
    }
    
    /**
     * 2012-07-16 史晓龙 改造
     * 2013-04-03 何晋文 修改(页面未选定业务类型时查询)
     * 2013-05-03 史晓龙 该方法不再使用，改用上面的liststatenhance()方法
     * @param params
     * @param user
     * @return
     * @throws Exception
     */
    @Deprecated
    public DataPackage liststatenhanceWithoutopnid(VCityrecordListVO params,User user) throws Exception{
    	String wayid = params.get_se_wayid();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	String sin_opnid = params.get_sin_opnid();
    	String isflag = params.get_ne_isflag();
    	String taskid = params.get_ne_taskid();
    	String countyid = params.get_se_countyid();
    	String paymonth = params.get_se_paymonth();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ROWNUM AS SEQID, T.opnid1, T.opnid2, T.rewardtype, T.dictname, T.oprmonth, ");
		sb.append("       T.isflag, T.sumbusivalue, T.sumpaymoney, T.sumnotconfirmmoney, T.sumconfirmmoney");
		sb.append("  FROM (select o.opnid1 opnid1, o.opnid2 opnid2, to_char(r.rewardtype) rewardtype,");
		sb.append("           to_char(r.rewardtype) dictname, to_char(r.oprtime, 'yyyymm') oprmonth, r.isflag,");
		sb.append("           sum(r.busivalue) sumbusivalue, sum(r.paymoney) sumpaymoney,");
		sb.append("           sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney,");
		sb.append("           sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney");
		sb.append("          from (select o1.opnid opnid1, o2.opnid opnid2, o5.opnid opnid5");
		sb.append("                  from ch_pw_operation o1, ch_pw_operation o2, ch_pw_operation o3,");
		sb.append("                       ch_pw_operation o4, ch_pw_operation o5");
		sb.append("                 where o2.parentid = o1.opnid and o3.parentid = o2.opnid");
		sb.append("                   and o4.parentid = o3.opnid and o5.parentid = o4.opnid");
		sb.append("                   and o1.opnlevel = 1 and o2.opnlevel = 2");
		sb.append("                   and o3.opnlevel = 3 and o4.opnlevel = 4");
		sb.append("                   and o5.opnlevel = 5) o, ch_adt_cityrecord r, ch_pw_way w");
		sb.append("         where r.opnid = o.opnid5 and r.wayid = w.wayid");
		
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append("           and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1, op.length()-1));
			}
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("           and w.countyid = :countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(isflag!=null && !"".equals(isflag.trim())){
			sb.append("           and r.isflag = :isflag");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("           and r.wayid = :wayid");
			params.getQueryConditions().put("wayid", wayid.trim());
			params.set_se_wayid(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("           and r.systemflag = :systemflag");
			params.getQueryConditions().put("systemflag", systemflag.trim());
			params.set_ne_systemflag(null);
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("           and r.rewardmonth = :month");
			params.getQueryConditions().put("month", month.trim());
			params.set_se_rewardmonth(null);
		}
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("           and r.taskid = :taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		//新增付款月份
		if (new CityrecordAction().isSupportPaymonth(user)){
			if(paymonth!=null && !"".equals(paymonth.trim())){
				sb.append("       and r.paymonth =:paymonth"); 
				params.getQueryConditions().put("paymonth", paymonth);
    			params.set_se_paymonth(null);
			}
		}
		
		sb.append("         group by o.opnid1, o.opnid2, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T");
		
		/*sb.append("SELECT ROWNUM AS SEQID, T.opnid1,T.opnid2,T.rewardtype,T.dictname,T.oprmonth,T.isflag, ");
		sb.append("       T.sumbusivalue,T.sumpaymoney,T.sumnotconfirmmoney,T.sumconfirmmoney ");
		sb.append("  FROM (select o.opnid1 opnid1,o.opnid2 opnid2,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) dictname, ");
		sb.append("               to_char(r.oprtime, 'yyyymm') oprmonth,r.isflag,sum(r.busivalue) sumbusivalue, sum(r.paymoney) sumpaymoney, ");
		sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney, ");
		sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney ");
		sb.append("          from (select o1.opnid opnid1, o2.opnid opnid2, o5.opnid opnid5 ");
		sb.append("                  from ch_pw_operation o1, ch_pw_operation o2, ch_pw_operation o3, ch_pw_operation o4, ch_pw_operation o5 ");
		sb.append("                 where o2.parentid = o1.opnid and o3.parentid = o2.opnid and o4.parentid = o3.opnid and o5.parentid = o4.opnid ");
		sb.append("                   and o1.opnlevel = 1 and o2.opnlevel = 2 and o3.opnlevel = 3 and o4.opnlevel = 4 and o5.opnlevel = 5) o, ");
		sb.append("               ch_pw_way w,ch_adt_cityrecord r ");
		sb.append("         where r.opnid = o.opnid5 and r.wayid = w.wayid ");
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append(" and r.opnid in ( :sinopnid )");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			sb.append("   and w.wayname like :waylike");
			params.getQueryConditions().put("waylike", "%"+waylike.trim()+"%");
			params.set_se_waylike(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("	  and w.countyid=:countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(isflag!=null && !"".equals(isflag.trim())){
			sb.append(" and r.isflag=:isflag ");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
			params.getQueryConditions().put("wayid", wayid.trim());
			params.set_se_wayid(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");
			params.getQueryConditions().put("systemflag", systemflag.trim());
			params.set_ne_systemflag(null);
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:month");
			params.getQueryConditions().put("month", month.trim());
			params.set_se_rewardmonth(null);
		}
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("   and r.taskid=:taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		sb.append("         group by o.opnid1, o.opnid2, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T ");

		//return this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);*/
		
		return this.queryBySql(sb.toString(), params);
    }
    
    /**
     * 2012-07-16 史晓龙 改造
     * 2013-04-03 何晋文 修改(页面查询条件有选择业务大类但未选择业务小类时查询)
     * 2013-05-03 史晓龙 该方法不再使用，改用上面的liststatenhance()方法
     */
    @Deprecated
    public DataPackage liststatenhanceWithonelevelopnid(VCityrecordListVO params,User user) throws Exception{
    	String wayid = params.get_se_wayid();
		String month = params.get_se_rewardmonth();
		String systemflag = params.get_ne_systemflag();
		String opnid = params.get_se_opnid();
		String sin_opnid = params.get_sin_opnid();
		String isflag = params.get_ne_isflag();
		String taskid = params.get_ne_taskid();
		String countyid = params.get_se_countyid();
		StringBuilder sb = new StringBuilder();
		String paymonth = params.get_se_paymonth();
		
		sb.append("SELECT ROWNUM AS SEQID, T.opnid1, T.opnid2, T.rewardtype, T.dictname, T.oprmonth,");
		sb.append("       T.isflag, T.sumbusivalue, T.sumpaymoney, T.sumnotconfirmmoney, T.sumconfirmmoney");
		sb.append("  FROM (select o.opnid1 opnid1, o.opnid2 opnid2, to_char(r.rewardtype) rewardtype,");
		sb.append("               to_char(r.rewardtype) DICTNAME, to_char(r.oprtime, 'yyyymm') oprmonth,");
		sb.append("               r.isflag, sum(r.busivalue) sumbusivalue, sum(r.paymoney) sumpaymoney,");
		sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney,");
		sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney");
		sb.append("          from (select o1.opnid opnid1, o2.opnid opnid2, o5.opnid opnid5");
		sb.append("                  from ch_pw_operation o1, ch_pw_operation o2, ch_pw_operation o3,");
		sb.append("                       ch_pw_operation o4, ch_pw_operation o5");
		sb.append("                 where o1.opnlevel = 1 and o2.opnlevel = 2 and o3.opnlevel = 3");
		sb.append("                   and o4.opnlevel = 4 and o5.opnlevel = 5 and o5.parentid = o4.opnid");
		sb.append("                   and o4.parentid = o3.opnid and o3.parentid = o2.opnid");
		sb.append("                   and o2.parentid = o1.opnid and o1.opnid = :opnid) o,");
		sb.append("               ch_adt_cityrecord r, ch_pw_way w");
		sb.append("         where r.opnid = o.opnid5 and w.wayid = r.wayid");
		
		if(isflag!=null && !"".equals(isflag.trim())){
			sb.append("           and r.isflag = :isflag");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append("           and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("           and w.countyid = :countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("           and r.wayid = :wayid");
			params.getQueryConditions().put("wayid", wayid);
			params.set_se_wayid(null);
		}		
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("           and r.systemflag = :systemflag");
			params.getQueryConditions().put("systemflag", systemflag);
			params.set_ne_systemflag(null);
		}		
		if(month!=null && !"".equals(month.trim())){
			sb.append("           and r.rewardmonth = :month");
			params.getQueryConditions().put("month", month);
			params.set_se_rewardmonth(null);
		}	
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("           and r.taskid = :taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		//新增付款月份
		if (new CityrecordAction().isSupportPaymonth(user)){
			if(paymonth!=null && !"".equals(paymonth.trim())){
				sb.append("       and r.paymonth =:paymonth"); 
				params.getQueryConditions().put("paymonth", paymonth);
    			params.set_se_paymonth(null);
			}
		}
		sb.append("         group by o.opnid1, o.opnid2, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T");
		params.getQueryConditions().put("opnid", opnid);
		params.set_se_opnid(null);
		
		/*sb.append("SELECT ROWNUM AS SEQID, T.opnid1,T.opnid2,T.rewardtype,T.dictname,T.oprmonth,T.isflag, ");
		sb.append("       T.sumbusivalue,T.sumpaymoney,T.sumnotconfirmmoney,T.sumconfirmmoney  ");
		sb.append("  FROM (select o.opnid1 opnid1,o.opnid2 opnid2,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) DICTNAME, ");
		sb.append("               to_char(r.oprtime, 'yyyymm') oprmonth,r.isflag,sum(r.busivalue) sumbusivalue,sum(r.paymoney) sumpaymoney, ");
		sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney, ");
		sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney ");
		sb.append("          from (select o1.opnid opnid1, o2.opnid opnid2, o5.opnid opnid5 ");
		sb.append("                  from ch_pw_operation o1,ch_pw_operation o2,ch_pw_operation o3,ch_pw_operation o4,ch_pw_operation o5 ");
		sb.append("                 where o1.opnlevel = 1 and o2.opnlevel = 2 and o3.opnlevel = 3 and o4.opnlevel = 4 and o5.opnlevel = 5 ");
		sb.append("                   and o5.parentid = o4.opnid and o4.parentid = o3.opnid and o3.parentid = o2.opnid and o2.parentid = o1.opnid");
		sb.append("                   and o1.opnid = :opnid ) o, ");
		sb.append("               ch_pw_way w,ch_adt_cityrecord r ");
		sb.append("         where  r.opnid = o.opnid5 and w.wayid = r.wayid  ");//and r.isflag in (0, 1) 
			
		if(isflag!=null && !"".equals(isflag.trim())){
			sb.append(" and r.isflag=:isflag ");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append(" and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(waylike!=null && !"".equals(waylike.trim())){			
			sb.append("   and w.wayname like :waylike");
			params.getQueryConditions().put("waylike", "%"+waylike+"%");
			params.set_se_waylike(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("	  and w.countyid=:countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
			params.getQueryConditions().put("wayid", wayid);
			params.set_se_wayid(null);
		}		
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");
			params.getQueryConditions().put("systemflag", systemflag);
			params.set_ne_systemflag(null);
		}		
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:month");
			params.getQueryConditions().put("month", month);
			params.set_se_rewardmonth(null);
		}	
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("   and r.taskid=:taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		sb.append("         group by o.opnid1,o.opnid2,r.rewardtype,to_char(r.oprtime, 'yyyymm'),r.isflag) T ");				
		params.getQueryConditions().put("opnid", opnid);
		params.set_se_opnid(null);
		
		//return this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);*/
		
		return this.queryBySql(sb.toString(), params);
    }
	
    /**
     * 2012-07-16 史晓龙 变更
     * 2013-04-03 何晋文 修改(页面查询条件有选择业务小类时查询)
     * 2013-05-03 史晓龙 该方法不再使用，改用上面的liststatenhance()方法
     * @param params
     * @param user
     * @return
     * @throws Exception
     */
    @Deprecated
    public DataPackage liststatenhanceWithtwolevelopnid(VCityrecordListVO params,User user) throws Exception{
    	String wayid = params.get_se_wayid();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	String opnid2 = params.get_se_opnid2();
    	String sin_opnid = params.get_sin_opnid();
    	String isflag = params.get_ne_isflag();
    	String taskid = params.get_ne_taskid();
    	String countyid = params.get_se_countyid();
    	StringBuilder sb = new StringBuilder();
    	String paymonth = params.get_se_paymonth();
		
    	sb.append("SELECT ROWNUM AS SEQID, T.opnid1, T.opnid2, T.rewardtype, T.dictname, T.oprmonth,");
    	sb.append("       T.isflag, T.sumbusivalue, T.sumpaymoney, T.sumnotconfirmmoney, T.sumconfirmmoney");
    	sb.append("  FROM (select o2.parentid opnid1, o2.opnid opnid2, to_char(r.rewardtype) rewardtype,");
    	sb.append("               to_char(r.rewardtype) DICTNAME, to_char(r.oprtime, 'yyyymm') oprmonth,");
    	sb.append("               r.isflag, sum(r.busivalue) sumbusivalue, sum(r.paymoney) sumpaymoney,");
    	sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney,");
    	sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney");
    	sb.append("          from (select o.opnid from ch_pw_operation o where o.opnlevel = 5");
    	sb.append("                 start with o.opnid = :opnid connect by prior o.opnid = o.parentid) o1,");
    	sb.append("               (select o.opnid, o.parentid from ch_pw_operation o where o.opnlevel = 2");
    	sb.append("                 start with o.opnid = :opnid connect by prior o.parentid = o.opnid) o2,");
    	sb.append("               ch_adt_cityrecord r, ch_pw_way w");
    	sb.append("         where r.opnid = o1.opnid and w.wayid = r.wayid");
    	
    	if(isflag!=null && !"".equals(isflag.trim())){
    		sb.append("           and r.isflag = :isflag");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append("           and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("           and w.countyid = :countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("           and r.systemflag = :systemflag");
			params.getQueryConditions().put("systemflag", systemflag);
			params.set_ne_systemflag(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("           and r.wayid = :wayid");
			params.getQueryConditions().put("wayid", wayid);
			params.set_se_wayid(null);
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("           and r.rewardmonth = :month");
			params.getQueryConditions().put("month", month);
			params.set_se_rewardmonth(null);
		}		
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("           and r.taskid = :taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		//新增付款月份
		if (new CityrecordAction().isSupportPaymonth(user)){
			if(paymonth!=null && !"".equals(paymonth.trim())){
				sb.append("       and r.paymonth =:paymonth"); 
				params.getQueryConditions().put("paymonth", paymonth);
    			params.set_se_paymonth(null);
			}
		}
    	sb.append("         group by o2.parentid, o2.opnid, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T");
    	params.getQueryConditions().put("opnid", opnid2);
    	params.set_se_opnid(null);
    	params.set_se_opnid2(null);
    	
    	/*sb.append("SELECT ROWNUM AS SEQID, T.opnid1,T.opnid2,T.rewardtype,T.dictname,T.oprmonth,T.isflag, ");
    	sb.append("       T.sumbusivalue,T.sumpaymoney,T.sumnotconfirmmoney,T.sumconfirmmoney ");
    	sb.append("  FROM (select o2.parentid opnid1,o2.opnid opnid2,to_char(r.rewardtype) rewardtype,to_char(r.rewardtype) DICTNAME, ");
    	sb.append("               to_char(r.oprtime, 'yyyymm') oprmonth,r.isflag,sum(r.busivalue) sumbusivalue,sum(r.paymoney) sumpaymoney, ");
    	sb.append("               sum(case when r.isflag = 1 then r.paymoney else 0 end) sumnotconfirmmoney, ");
    	sb.append("               sum(case when r.isflag = 0 then r.paymoney else 0 end) sumconfirmmoney ");
    	sb.append("          from (select o.opnid from ch_pw_operation o where o.opnlevel = 5 ");
    	sb.append("                 start with o.opnid = :opnid ");
    	sb.append("                connect by prior o.opnid = o.parentid) o1, ");
    	sb.append("               (select o.opnid, o.parentid  from ch_pw_operation o  where o.opnlevel = 2 ");
    	sb.append("                 start with o.opnid = :opnid ");
    	sb.append("                connect by prior o.parentid = o.opnid) o2, ");
    	sb.append("                ch_pw_way w,ch_adt_cityrecord r ");
    	sb.append("         where  r.opnid = o1.opnid and w.wayid = r.wayid ");//and r.rewardmonth = :month     	//r.isflag in (0, 1) and

    	if(isflag!=null && !"".equals(isflag.trim())){
			sb.append(" and r.isflag=:isflag ");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append(" and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			sb.append("   and w.wayname like :waylike");
			params.getQueryConditions().put("waylike", waylike);
			params.set_se_waylike(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("	  and w.countyid=:countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");
			params.getQueryConditions().put("systemflag", systemflag);
			params.set_ne_systemflag(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
			params.getQueryConditions().put("wayid", wayid);
			params.set_se_wayid(null);
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:month");	
			params.getQueryConditions().put("month", month);
			params.set_se_rewardmonth(null);
		}		
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("   and r.taskid=:taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
    	sb.append("         group by o2.parentid, o2.opnid, r.rewardtype, to_char(r.oprtime, 'yyyymm'), r.isflag) T ");    	
    	params.getQueryConditions().put("opnid", opnid);
    	params.set_se_opnid(null);
    	
		//return this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);*/
    	
		return this.queryBySql(sb.toString(), params);
    }
}