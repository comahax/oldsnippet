/**
 * auto-generated code
 * Sat Feb 02 14:33:50 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrecord.persistent;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>
 * Title: RewardrecordDAO
 * </p>
 * <p>
 * Description: Data Access Object for RewardrecordVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RewardrecordDAO extends BaseDAO {
	private static final Logger log = Logger.getLogger(RewardrecordDAO.class);
	//07开头的特殊业务编码，无号码明细
	private static final String SPECIAL_07= "'0701010100001', '0701010100002', '0701010100003', '0701010100004'," +
			"'0701010100005', '0701010100006', '0701010100007', '0701010100012'," +
			"'0701010100013', '0701020400239', '0702010100001', '0704010100001','0705010100001'";

	/**
	 * default constructor
	 */
	public RewardrecordDAO() {
		super(RewardrecordVO.class);
	}

	public DataPackage doQuery(RewardrecordListVO params,String purview,String countyid,boolean flag)
			throws Exception {
		String paymonth = params.get_se_paymonth();
		if (null == paymonth || "".equals(paymonth)) {
			params.set_se_paymonth(null);
			Session session = SessionUtil.currentSession(getDbFlag());
			SQLQuery query = (SQLQuery) session.getNamedQuery("boss.cms.reward.rewardrecord.NotQueryPaymonth");
			StringBuffer querySql = new StringBuffer(query.getQueryString());
			if("C".equals(purview)){
				querySql.append(" and b.COUNTYID='").append(countyid).append("'");
			}
			if(!flag){
				querySql.append(" and t.batchno in (select batchno from ch_cb_rewardconf where rewardkind = 'AG' and state = 1 and cityid = '"+super.getDbFlag()+"')");
			}
			querySql.append("  order by t.rewardlistid ");
			params.getQueryConditions().put("isbudget", params.get_ne_isbudget());
			params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth());
			params.set_ne_isbudget(null);
			params.set_se_rewardmonth(null);
			return this.queryBySql(querySql.toString(),params,0);
		} else {
			//查找到queryBySql的第二种方式
			params.set_se_paymonth(null);//删去_se_paymonth非动态生成查询字段
			Session session = SessionUtil.currentSession(getDbFlag());
			SQLQuery query = (SQLQuery) session.getNamedQuery("boss.cms.reward.rewardrecord.addQueryPaymonth");
			StringBuffer querySql = new StringBuffer(query.getQueryString());
			params.getQueryConditions().put("paymonth", paymonth);//把_se_paymonth赋予字段paymonth1,paymonth2,paymonth3
			params.getQueryConditions().put("isbudget", params.get_ne_isbudget());
			params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth());
			params.set_ne_isbudget(null);
			params.set_se_rewardmonth(null);
			if("C".equals(purview)){
				querySql.append(" and b.COUNTYID='").append(countyid).append("'");
			}
			if(!flag){
				querySql.append(" and t.batchno in (select batchno from ch_cb_rewardconf where rewardkind = 'AG' and state = 1 and cityid = '"+super.getDbFlag()+"')");
			}
			querySql.append("  order by t.rewardlistid ");
			return this.queryBySql(querySql.toString(),params,0);
		}
	}

	//2012-7-21 史晓龙 注释此方法并重写
	public DataPackage doQuery4Thread(RewardrecordListVO params, User user) throws Exception{
		if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select t.* ");
		sb.append("  from CH_PW_REWARDRECORD t ");
		sb.append(" where not exists (SELECT 1 ");
		sb.append("          from CH_ADT_CITYRECORD c ");
		sb.append("         where (t.REWARDLISTID = c.REWARDLISTID ");
		sb.append("                  and c.SYSTEMFLAG = 2 ");
		sb.append("                  and c.REWARDLISTID IS NOT NULL) ");
		sb.append("               or ");
		sb.append("               (t.opnid = c.opnid ");
		sb.append("                  and t.oprtime = c.oprtime ");
		sb.append("                  and t.rewardtype = c.rewardtype ");
		sb.append("                  and t.rewardmonth = c.rewardmonth ");
		sb.append("                  and c.isflag in (0, 1) ");
		sb.append("                  and ((t.mobile = c.mobile and t.mobile is not null) ");
		sb.append("                     or (t.opnid in ("+SPECIAL_07+") and t.mobile is null)))");
		sb.append("               ) ");
		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
			sb.append("   and exists (select 1 ");
			sb.append("          from ch_pw_operation o ");
			sb.append("         where o.opnlevel = 5 and o.opnid = t.opnid ");
			sb.append("         start with o.opnid = :opnid ");
			sb.append("        connect by prior o.opnid = o.parentid) ");
		}	
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
		}
		
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in (:sinopnid) ");
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = :wayid ");
		}		
		sb.append("   and t.rewardmonth = :rewardmonth ");
		
		String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
    	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
			params.getQueryConditions().put("opnid", params.get_se_opnid().trim());
			params.set_se_opnid(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		params.set_orderby("rewardlistid");//分页查询数据要排序，否则可能出现数据重复和漏检
		params.set_desc("0");
		
		DataPackage dppw = this.queryBySql(sb.toString(), params);
		DataPackage dp = new DataPackage();
		List<CityrecordVO> list = new ArrayList();
		if(null!=dppw && dppw.getDatas().size()>0){
			for(Iterator it = dppw.getDatas().iterator();it.hasNext();){
				RewardrecordVO rrvo = (RewardrecordVO)it.next();
				if((rrvo.getPaymoney2()==null || rrvo.getPaymoney2()==0) && (rrvo.getPaymoney3()==null || rrvo.getPaymoney3()==0)){//不入酬金池的
					CityrecordVO crvo = new CityrecordVO();
					BeanUtils.copyProperties(crvo, rrvo);
					if("0403".equals(rrvo.getOpnid().substring(0, 4))){
						crvo.setMobile(rrvo.getBakinfo());
					}
					crvo.setIsflag((short)2);
					crvo.setSystemflag((short)2);
					crvo.setPaymoney(rrvo.getPaysum());
					crvo.setRewardlistid(rrvo.getRewardlistid());					
					//模拟设置一下，到后面一条处理的就是3条
					crvo.setThreedelegate("3");
					list.add(crvo);
				}else{//入酬金池的
					//第一条记录：
					CityrecordVO crvo1 = new CityrecordVO();
					BeanUtils.copyProperties(crvo1, rrvo);
					crvo1.setIsflag((short)2);
					crvo1.setSystemflag((short)2);					
					crvo1.setRewardmonth(rrvo.getPaymonth1());
					crvo1.setPaymoney(rrvo.getPaymoney1());
					crvo1.setRewardlistid(rrvo.getRewardlistid());					
					//模拟设置一下，到后面一条处理的就是1条
					crvo1.setThreedelegate("1");					
					list.add(crvo1);
					
					//第二条记录：
					CityrecordVO crvo2 = new CityrecordVO();
					BeanUtils.copyProperties(crvo2, rrvo);
					crvo2.setIsflag((short)2);
					crvo2.setSystemflag((short)2);					
					crvo2.setRewardmonth(rrvo.getPaymonth2());
					crvo2.setPaysum((double)0);
					crvo2.setPaymoney(rrvo.getPaymoney2());
					crvo2.setRewardlistid(rrvo.getRewardlistid());					
					//模拟设置一下，到后面一条处理的就是1条
					crvo2.setThreedelegate("1");					
					list.add(crvo2);
					
					if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()!=0){
						//第三条记录：
						CityrecordVO crvo3 = new CityrecordVO();
						BeanUtils.copyProperties(crvo3, rrvo);
						crvo3.setIsflag((short)2);
						crvo3.setSystemflag((short)2);						
						crvo3.setRewardmonth(rrvo.getPaymonth3());
						crvo3.setPaysum((double)0);
						crvo3.setPaymoney(rrvo.getPaymoney3());
						crvo3.setRewardlistid(rrvo.getRewardlistid());
						//模拟设置一下，到后面一条处理的就是1条
						crvo3.setThreedelegate("1");
						list.add(crvo3);
					}
				}
			}
		}
		dp.setDatas(list);//实际大小最大为页大小的三倍
		dp.setPageNo(new Integer(params.get_pageno()));
		dp.setPageSize(new Integer(params.get_pagesize()));
		dp.setRowCount(dppw.getRowCount());
		
		return dp;
	}
	
	//2012-7-21 史晓龙 注释此方法并重写
	public DataPackage doQuery4ThreadTotal(RewardrecordListVO params, User user) throws Exception{
		if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select t.* ");
		sb.append("  from CH_PW_REWARDRECORD t ");
		sb.append(" where not exists (SELECT 1 ");
		sb.append("          from CH_ADT_CITYRECORD c ");
		sb.append("         where (t.REWARDLISTID = c.REWARDLISTID ");
		sb.append("                  and c.SYSTEMFLAG = 2 ");
		sb.append("                  and c.REWARDLISTID IS NOT NULL) ");
		sb.append("               or ");
		sb.append("               (t.opnid = c.opnid ");
		sb.append("                  and t.oprtime = c.oprtime ");
		sb.append("                  and t.rewardtype = c.rewardtype ");
		sb.append("                  and t.rewardmonth = c.rewardmonth ");
		sb.append("                  and c.isflag in (0, 1) ");
		sb.append("                  and ((t.mobile = c.mobile and t.mobile is not null) ");
		sb.append("                     or (t.opnid in ("+SPECIAL_07+") and t.mobile is null)))");
		sb.append("               ) ");
		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
			sb.append("   and exists (select 1 ");
			sb.append("          from ch_pw_operation o ");
			sb.append("         where o.opnlevel = 5 and o.opnid = t.opnid ");
			sb.append("         start with o.opnid = :opnid ");
			sb.append("        connect by prior o.opnid = o.parentid) ");
		}	
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
		}		
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in (:sinopnid) ");
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = :wayid ");
		}		
		sb.append("   and t.rewardmonth = :rewardmonth ");
		
		String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
    	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
			params.getQueryConditions().put("opnid", params.get_se_opnid().trim());
			params.set_se_opnid(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		
		DataPackage dp = queryBySql(sb.toString(),params,QUERY_TYPE_COUNT);
		return dp;
	}
	
	/**
	 * 查询opnid 非0403开头和非07开头特种业务的数据
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 */
	public DataPackage doQueryMainopn(RewardrecordListVO params, User user, int querytype)throws Exception{
		if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("t.rewardlistid,t.operseq,t.opnid,t.wayid,t.wayoprcode,t.slv,t.rewardid,");//--t.rewardtype,
		sb.append(" mm.adtrewardtype rewardtype,");
		sb.append("t.rewardstd,t.rewardmonth,t.isbudget,t.totalsum,t.paysum,t.paymonth1,t.paymoney1, ");
		sb.append("t.paymonth2,t.paymoney2,t.paymonth3,t.paymoney3,t.runtime,t.acctype,t.mobile,t.assegrade, ");
		sb.append("t.opermobile,t.oprtime,t.busivalue,t.rewardflag,t.repairmonth,t.relateid,t.batchno, ");
		sb.append("t.noncyc,t.bakinfo,t.adtremark,t.adtcode,t.rewardstdnew,t.bakinfo2,t.bakinfo3,t.src, ");
		sb.append("t.ruleid,t.startdate ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t ");
		sb.append("  where t.wayid=w.wayid and not exists(select 1 ");//排除地市已经通过文件上传的数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype and t.mobile=c.mobile and t.oprtime=c.oprtime and c.systemflag=1 ) ");
		sb.append("    and not exists(select 1 ");//排除已同步数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.rewardlistid=c.rewardlistid and c.systemflag=2 ) ");
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
		}		
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid ");
		params.getQueryConditions().put("cityid", cityid);
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in (:sinopnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = :wayid ");
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}	
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.mobile = :mobile");
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("   and t.rewardmonth = :rewardmonth ");		
		sb.append("   and t.opnid not like '0403%' and t.opnid not like '0404%' and t.opnid not like '0405%' and t.opnid not in");
		sb.append("    ("+SPECIAL_07+")");		
		sb.append("   and mm.systemflag=2 ");		
		String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
		params.set_orderby("rewardlistid");//分页查询数据要排序，否则可能出现数据重复和漏检
		params.set_desc("0");
		
		DataPackage dp = null;
		switch(querytype){
		case 1:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);
			break;
		case 2:
			dp = queryBySql(sb.toString(),params,QUERY_TYPE_COUNT);
			break;
		case 3:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_ALL);
			break;
		default:
			throw new Exception("操作类型错误，只能为[1查询数据、2统计总数、3查询数据和统计总数].");
		}
		
		return dp;		
	}
	
	/**
	 * 查询opnid 07开头的特种业务
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerySpecialopn07(RewardrecordListVO params, User user, int querytype)throws Exception{
		if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("t.rewardlistid,t.operseq,t.opnid,t.wayid,t.wayoprcode,t.slv,t.rewardid,");//--t.rewardtype,
		sb.append(" mm.adtrewardtype rewardtype,");
		sb.append("t.rewardstd,t.rewardmonth,t.isbudget,t.totalsum,t.paysum,t.paymonth1,t.paymoney1, ");
		sb.append("t.paymonth2,t.paymoney2,t.paymonth3,t.paymoney3,t.runtime,t.acctype,t.mobile,t.assegrade, ");
		sb.append("t.opermobile,t.oprtime,t.busivalue,t.rewardflag,t.repairmonth,t.relateid,t.batchno, ");
		sb.append("t.noncyc,t.bakinfo,t.adtremark,t.adtcode,t.rewardstdnew,t.bakinfo2,t.bakinfo3,t.src, ");
		sb.append("t.ruleid,t.startdate ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t  "); 
		sb.append("  where t.wayid=w.wayid and not exists(select 1 "); //排除地市已经通过文件上传的数据
		sb.append("        from ch_adt_cityrecord c "); 
		sb.append("        where (t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype and t.wayid=c.wayid "); 
		sb.append("             and to_char(t.oprtime,'yyyyMM')=to_char(c.oprtime,'yyyyMM') and c.systemflag=1)) "); 
		sb.append("    and not exists(select 1 "); //排除已同步数据
		sb.append("        from ch_adt_cityrecord c "); 
		sb.append("        where(t.rewardlistid=c.rewardlistid and c.systemflag=2 )) ");
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
		}
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid");
		params.getQueryConditions().put("cityid", cityid);
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in (:sinopnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = :wayid ");
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}		
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.mobile = :mobile");
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("   and t.rewardmonth = :rewardmonth ");		
		sb.append("   and t.opnid in"); 
		sb.append("    ("+SPECIAL_07+")");		
		sb.append("   and mm.systemflag=2 ");
		String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);    	
		
		params.set_orderby("rewardlistid");//分页查询数据要排序，否则可能出现数据重复和漏检
		params.set_desc("0");
		
		DataPackage dp = null;
		switch(querytype){
		case 1:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);
			break;
		case 2:
			dp = queryBySql(sb.toString(),params,QUERY_TYPE_COUNT);
			break;
		case 3:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_ALL);
			break;
		default:
			throw new Exception("操作类型错误，只能为[1查询数据、2统计总数、3查询数据和统计总数].");
		}
		
		return dp;	
	}
	
	/**
	 * 查询opnid 0403开头的特种业务
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerySpecialopn0403(RewardrecordListVO params, User user, int querytype)throws Exception{
		if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder(); 
		sb.append("select ");
		sb.append("t.rewardlistid,t.operseq,t.opnid,t.wayid,t.wayoprcode,t.slv,t.rewardid,");//--t.rewardtype,
		sb.append(" mm.adtrewardtype rewardtype,");
		sb.append("t.rewardstd,t.rewardmonth,t.isbudget,t.totalsum,t.paysum,t.paymonth1,t.paymoney1, ");
		sb.append("t.paymonth2,t.paymoney2,t.paymonth3,t.paymoney3,t.runtime,t.acctype,t.mobile,t.assegrade, ");
		sb.append("t.opermobile,t.oprtime,t.busivalue,t.rewardflag,t.repairmonth,t.relateid,t.batchno, ");
		sb.append("t.noncyc,t.bakinfo,t.adtremark,t.adtcode,t.rewardstdnew,t.bakinfo2,t.bakinfo3,t.src, ");
		sb.append("t.ruleid,t.startdate ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t ");
		sb.append("  where t.wayid=w.wayid and not exists(select 1 ");//排除地市已经通过文件上传的数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype and t.bakinfo=c.mobile and t.oprtime=c.oprtime and c.systemflag=1 )");
		sb.append("    and not exists(select 1 ");//排除已同步数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.rewardlistid=c.rewardlistid and c.systemflag=2 ) ");
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
		}	
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid ");
		params.getQueryConditions().put("cityid", cityid);
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in (:sinopnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = :wayid ");
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}	
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.bakinfo = :mobile");
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("   and t.rewardmonth=:rewardmonth and (t.opnid like '0403%' or t.opnid like '0404%' or t.opnid like '0405%') ");
		sb.append("   and mm.systemflag=2 ");
		String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
		params.set_orderby("rewardlistid");//分页查询数据要排序，否则可能出现数据重复和漏检
		params.set_desc("0");
		
		DataPackage dp = null;
		switch(querytype){
		case 1:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);
			break;
		case 2:
			dp = queryBySql(sb.toString(),params,QUERY_TYPE_COUNT);
			break;
		case 3:
			dp = this.queryBySql(sb.toString(), params, this.QUERY_TYPE_ALL);
			break;
		default:
			throw new Exception("操作类型错误，只能为[1查询数据、2统计总数、3查询数据和统计总数].");
		}
		
		return dp;	
	}
	
	/**
	 * 社会渠道酬金发布 opnid非0403、非07开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */
	public int doInsertMainopn(RewardrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder(); 
		sb.append("insert into ch_adt_cityrecord(recordid,opnid,wayid,rewardtype,rewardmonth,mobile,oprtime,busivalue,paysum,");
		sb.append("approveid,isflag,oprcode,optime,systemflag,rewardlistid,paymoney,taskid)");
		sb.append("select ch_adt_cityrecord_seq.nextval,R.OPNID,R.WAYID,R.REWARDTYPE,R.REWARDMONTH,R.MOBILE,R.OPRTIME,");
		sb.append("  R.BUSIVALUE,R.PAYSUM,NULL,1,?,SYSDATE,2,R.REWARDLISTID,R.PAYMONEY,?");
		sb.append(" from (");
		sb.append("select rownum rownum_,t.opnid,t.wayid,mm.adtrewardtype rewardtype,");
		sb.append(" case ");
		sb.append("   when nvl(t.paymoney1,0) > 0 then t.paymonth1 ");
		sb.append("   when nvl(t.paymoney2,0) > 0 then t.paymonth2 ");
		sb.append("   when nvl(t.paymoney3,0) > 0 then t.paymonth3 ");
		sb.append("   else t.rewardmonth end rewardmonth,");
		sb.append("t.mobile,t.oprtime,t.busivalue,t.paysum,t.rewardlistid,");
		sb.append(" case ");
		sb.append("   when nvl(t.paymoney1,0) > 0 then t.paymoney1 ");
		sb.append("   when nvl(t.paymoney2,0) > 0 then t.paymoney2 ");
		sb.append("   when nvl(t.paymoney3,0) > 0 then t.paymoney3 ");             
		sb.append("   else t.paysum end paymoney ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t  ");
		sb.append("  where t.wayid=w.wayid and not exists(select 1 from ch_adt_cityrecord c ");//排除通过文件上传的数据
		sb.append("        where t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype ");
		sb.append("        and t.mobile=c.mobile and t.oprtime=c.oprtime and c.systemflag=1) ");//
		sb.append("    and not exists(select 1 ");//排除已同步过的数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where c.systemflag=2 and t.rewardlistid=c.rewardlistid ) ");//c.taskid!=? and
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = '"+params.get_se_chainhead().trim()+"' AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = '"+params.get_se_countyid().trim()+"' AND t.WAYID = A.WAYID) ");
		}
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=? ");
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in ("+params.get_sin_opnid().trim()+") ");
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = '"+params.get_se_wayid().trim()+"' ");
		}	
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.mobile = '"+params.get_se_mobile().trim()+"' ");
		}		
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("    and t.rewardmonth=? and t.opnid not like '0403%' and t.opnid not like '0404%' and t.opnid not like '0405%' and t.opnid not in ");
		sb.append("    ("+SPECIAL_07+")");		
		sb.append("   and mm.systemflag=2 ");
		sb.append("   ) R where rownum_<=?");
		
		PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(user.getCityid());
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat = ((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
			pstat.setString(1, user.getOpercode());
			pstat.setBigDecimal(2, new BigDecimal(datestamp));
			pstat.setString(3, cityid);
			pstat.setString(4, params.get_se_rewardmonth());
			pstat.setBigDecimal(5, new BigDecimal(batchsize));
			System.out.println("Insert语句:"+sb.toString());
			System.out.println("批量号taskid:"+datestamp);
			System.out.println("结算月份:"+params.get_se_rewardmonth());	
			log.info("Insert语句:"+sb.toString());
			log.info("批量号taskid:"+datestamp);
			log.info("结算月份:"+params.get_se_rewardmonth());	
			log.info("操作工号:"+user.getOpercode());
			log.info("地市:"+cityid);
			 
			int result = pstat.executeUpdate();
			if(result>=0){
				String retinfo = "批量插入数据成功，操作记录数："+pstat.getUpdateCount();
				System.out.println(retinfo);
				log.info(retinfo);
				System.out.println(pstat.getUpdateCount());
			}
			return result;
		}catch(Exception e){
			System.out.println("批量插入数据失败一次");
			log.info("批量插入数据失败一次");
			log.info(e.getMessage());
			e.printStackTrace();			
			throw e;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
	}
	
	/**
	 * 社会渠道酬金发布 opnid 07开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */
	public int doInsertSpecialopn07(RewardrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder(); 
		sb.append("insert into ch_adt_cityrecord(recordid,opnid,wayid,rewardtype,rewardmonth,mobile,oprtime,busivalue,paysum, "); 
		sb.append("approveid,isflag,oprcode,optime,systemflag,rewardlistid,paymoney,taskid) "); 
		sb.append("select ch_adt_cityrecord_seq.nextval,R.OPNID,R.WAYID,R.REWARDTYPE,R.REWARDMONTH,R.MOBILE,R.OPRTIME,");
		sb.append("  R.BUSIVALUE,R.PAYSUM,NULL,1,?,SYSDATE,2,R.REWARDLISTID,R.PAYMONEY,?");
		sb.append(" from (");
		sb.append("select rownum rownum_,t.opnid,t.wayid,mm.adtrewardtype rewardtype,");
		sb.append(" case ");
		sb.append("   when nvl(t.paymoney1,0) > 0 then t.paymonth1 ");
		sb.append("   when nvl(t.paymoney2,0) > 0 then t.paymonth2 ");
		sb.append("   when nvl(t.paymoney3,0) > 0 then t.paymonth3 ");
		sb.append("   else t.rewardmonth end rewardmonth,");
		sb.append("t.mobile,t.oprtime,t.busivalue,t.paysum,t.rewardlistid,");
		sb.append(" case ");
		sb.append("   when nvl(t.paymoney1,0) > 0 then t.paymoney1 ");
		sb.append("   when nvl(t.paymoney2,0) > 0 then t.paymoney2 ");
		sb.append("   when nvl(t.paymoney3,0) > 0 then t.paymoney3 ");             
		sb.append("   else t.paysum end paymoney ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t  "); 
		sb.append("  where t.wayid=w.wayid and not exists(select 1 "); //排除地市已经通过文件上传的数据
		sb.append("        from ch_adt_cityrecord c "); 
		sb.append("        where t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype and t.wayid=c.wayid"); 
		sb.append("              and to_char(t.oprtime,'yyyyMM')=to_char(c.oprtime,'yyyyMM') and c.systemflag=1) ");//
		sb.append("    and not exists(select 1 "); //排除掉已经同步的数据
		sb.append("        from ch_adt_cityrecord c "); 
		sb.append("        where c.systemflag=2 and t.rewardlistid=c.rewardlistid ) ");//c.taskid!=? and	
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = '"+params.get_se_chainhead().trim()+"' AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = '"+params.get_se_countyid().trim()+"' AND t.WAYID = A.WAYID) ");
		}		
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=?");
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in ("+params.get_sin_opnid().trim()+") ");
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = '"+params.get_se_wayid().trim()+"' ");
		}	
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.mobile = '"+params.get_se_mobile().trim()+"' ");
		}
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("   and t.rewardmonth=? and t.opnid in");  
		sb.append("    ("+SPECIAL_07+")");		
		sb.append("   and mm.systemflag=2 ");
		sb.append("   ) R where rownum_<=?");
		
		PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(user.getCityid());
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat = ((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
			pstat.setString(1, user.getOpercode());
			pstat.setBigDecimal(2, new BigDecimal(datestamp));
			pstat.setString(3, cityid);
			pstat.setString(4, params.get_se_rewardmonth());
			pstat.setBigDecimal(5, new BigDecimal(batchsize));
			System.out.println("Insert语句:"+sb.toString());
			System.out.println("批量号taskid:"+datestamp);
			System.out.println("结算月份:"+params.get_se_rewardmonth());		
			log.info("Insert语句:"+sb.toString());
			log.info("批量号taskid:"+datestamp);
			log.info("结算月份:"+params.get_se_rewardmonth());	
			log.info("操作工号:"+user.getOpercode());
			log.info("地市:"+cityid);
				 
			int result = pstat.executeUpdate();
			if(result>=0){
				String retinfo = "批量插入数据成功，操作记录数："+pstat.getUpdateCount();
				System.out.println(retinfo);
				log.info(retinfo);
				System.out.println(pstat.getUpdateCount());
			}
			return result;
		}catch(Exception e){
			System.out.println("批量插入数据失败一次");
			log.info("批量插入数据失败一次");
			log.info(e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
	}
	
	/**
	 * 社会渠道酬金发布 opnid 0403/0404/0405开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */	
	public int doInsertSpecialopn0403(RewardrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder(); 
		sb.append("insert into ch_adt_cityrecord(recordid,opnid,wayid,rewardtype,rewardmonth,mobile,oprtime,busivalue,paysum, ");
		sb.append("approveid,isflag,oprcode,optime,systemflag,rewardlistid,paymoney,taskid) ");
		sb.append("select ch_adt_cityrecord_seq.nextval,R.OPNID,R.WAYID,R.REWARDTYPE,R.REWARDMONTH,R.MOBILE,R.OPRTIME,");
		sb.append("  R.BUSIVALUE,R.PAYSUM,NULL,1,?,SYSDATE,2,R.REWARDLISTID,R.PAYMONEY,?");
		sb.append(" from (");
		sb.append("select rownum rownum_,t.opnid,t.wayid,mm.adtrewardtype rewardtype,");
		sb.append("t.rewardmonth,t.bakinfo mobile,t.oprtime,t.busivalue,t.paysum,t.rewardlistid,t.paysum paymoney ");
		sb.append("  from ch_pw_way w,ch_adt_rewardtypemap mm,ch_pw_rewardrecord t ");
		sb.append("  where t.wayid=w.wayid and not exists(select 1 ");//排除地市已经通过文件上传的数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.opnid=c.opnid and mm.adtrewardtype=c.rewardtype and t.bakinfo=c.mobile and t.oprtime=c.oprtime and c.systemflag=1) ");//
		sb.append("    and not exists(select 1 ");//排除掉已经同步的数据
		sb.append("        from ch_adt_cityrecord c ");
		sb.append("        where t.rewardlistid=c.rewardlistid and c.systemflag=2 ) ");		
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.CHAINHEAD = '"+params.get_se_chainhead().trim()+"' AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("   and EXISTS (SELECT 1 ");
			sb.append("          FROM CH_PW_WAY A ");
			sb.append("         WHERE A.countyid = '"+params.get_se_countyid().trim()+"' AND t.WAYID = A.WAYID) ");
		}
		sb.append("    and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=?");
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("   and t.opnid in ("+params.get_sin_opnid().trim()+") ");
		}	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("   and t.wayid = '"+params.get_se_wayid().trim()+"' ");
		}	
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("   and t.bakinfo = '"+params.get_se_mobile().trim()+"' ");
		}
		sb.append("   and t.rewardtype=mm.rewardtype  ");
		sb.append("   and t.rewardmonth=? and (t.opnid like '0403%' or t.opnid like '0404%' or t.opnid like '0405%') ");
		sb.append("   and mm.systemflag=2 ");
		sb.append("   ) R where rownum_<=?");
		
		PreparedStatement  pstat = null;
		try{			
			Session session = SessionUtil.currentSession(user.getCityid());
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat = ((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
			pstat.setString(1, user.getOpercode());
			pstat.setBigDecimal(2, new BigDecimal(datestamp));
			pstat.setString(3, cityid);
			pstat.setString(4, params.get_se_rewardmonth());
			pstat.setBigDecimal(5, new BigDecimal(batchsize));
			System.out.println("Insert语句:"+sb.toString());
			System.out.println("批量号taskid:"+datestamp);
			System.out.println("结算月份:"+params.get_se_rewardmonth());
			log.info("Insert语句:"+sb.toString());
			log.info("批量号taskid:"+datestamp);
			log.info("结算月份:"+params.get_se_rewardmonth());
			log.info("操作工号:"+user.getOpercode());
			log.info("地市:"+cityid);
			 
			int result = pstat.executeUpdate();
			if(result>=0){
				String retinfo = "批量插入数据成功，操作记录数："+pstat.getUpdateCount();
				System.out.println(retinfo);
				log.info(retinfo);
				System.out.println(pstat.getUpdateCount());
			}
			return result;
		}catch(Exception e){
			System.out.println("批量插入数据失败一次");
			log.info("批量插入数据失败一次");
			log.info(e.getMessage());
			e.printStackTrace();			
			throw e;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
	}
	
	public DataPackage doQuerycount(RewardrecordListVO params ,User user)throws Exception{
		if(params.get_se_rewardmonth()==null && "".equals(params.get_se_rewardmonth().trim())){
    		throw new Exception("结算月份不能为空");
    	}
		StringBuilder sb = new StringBuilder();
		sb.append(" select t.REWARDLISTID,t.OPERSEQ,t.OPNID,t.WAYID,t.WAYOPRCODE,t.SLV,t.REWARDID,t.REWARDTYPE,t.REWARDSTD,t.REWARDMONTH,");
		sb.append("t.ISBUDGET,t.TOTALSUM,t.PAYSUM,t.PAYMONTH1,t.PAYMONEY1,t.PAYMONTH2,t.PAYMONEY2,t.PAYMONTH3,t.PAYMONEY3,t.RUNTIME,");
		sb.append("t.ACCTYPE,t.MOBILE,t.ASSEGRADE,t.OPERMOBILE,t.OPRTIME,t.BUSIVALUE,t.REWARDFLAG,t.REPAIRMONTH,t.RELATEID,t.BATCHNO,");
		sb.append("t.NONCYC,t.BAKINFO,t.ADTREMARK,t.ADTCODE,t.REWARDSTDNEW,t.BAKINFO2,t.BAKINFO3,t.SRC,t.RULEID,t.STARTDATE");
		sb.append("          from CH_PW_REWARDRECORD t ");
		sb.append("         where not exists (SELECT 1 from CH_ADT_CITYRECORD c ");
		sb.append("                 where t.REWARDLISTID = c.REWARDLISTID and c.SYSTEMFLAG = 2 ) ");
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("           and EXISTS(SELECT 1 FROM CH_PW_WAY A WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("           and EXISTS(SELECT 1 FROM CH_PW_WAY A WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
		}		
		//业务编码（多选）
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("           and t.opnid in (:sinopnid) ");
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("           and t.wayid = :wayid ");
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			sb.append("           and t.rewardtype = :rewardtype ");
		}
		sb.append("           and t.rewardmonth = :rewardmonth ");
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("           and t.mobile = :mobile "); 
		}
		
		params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth().trim());
    	params.set_se_rewardmonth(null);
    	if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
    		params.getQueryConditions().put("wayid", params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}
		//业务编码（多选）
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			params.getQueryConditions().put("rewardtype", params.get_ne_rewardtype().trim());
			params.set_ne_rewardtype(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			 params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			 params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			 params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			 params.set_se_countyid(null);
		}
		
		DataPackage dp = queryBySql(sb.toString(), params, QUERY_TYPE_COUNT);
		
		return dp;
	}

	//社会渠道酬金 COMS明细导出，先查询，然后根据paymoney1/paymoney2/paymoney3将数据拆分成多条写导出文件
	public DataPackage doQuery4Detailexport(RewardrecordListVO params, User user) throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();		
		sb.append("select p.rewardlistid,p.operseq,p.opnid,p.wayid,p.wayoprcode,p.slv,p.rewardid,p.adtflag,p.assegrade2,");                                    
		sb.append("    case when p.rewardtype in (1, 4, 6, 54, 51) then 2");                                                            
		sb.append("         when p.rewardtype in (2, 53) then 3");                                                                      
		sb.append("         else 1 end rewardtype,");                                                                                   
		sb.append("    p.rewardstd,p.rewardmonth,p.isbudget,p.totalsum,p.paysum,p.paymonth1,p.paymoney1,");                             
		sb.append("    p.paymonth2,p.paymoney2,p.paymonth3,p.paymoney3,p.runtime,p.acctype,");                                          
		sb.append("    case when (p.OPNID like '04%') then p.BAKINFO");               
		sb.append("         else p.MOBILE end MOBILE,");                                                                                
		sb.append("    p.assegrade,p.opermobile,p.oprtime,p.busivalue,p.rewardflag,p.repairmonth,p.relateid,p.batchno,p.noncyc,");      
		sb.append("   p.bakinfo,p.adtremark,p.adtcode,p.rewardstdnew,p.bakinfo2,p.bakinfo3,p.src,p.ruleid,p.startdate,p.oid,p.starlev,p.WRAPFEE,");
		sb.append("   p.ADJUSTKIND,prodid,p.bakinfo4,p.bakinfo5,p.bakinfo6,p.bakinfo7,p.bakinfo8,p.bakinfo9,p.bakinfo10");
		sb.append("  FROM CH_PW_REWARDRECORD P,CH_PW_WAY W  "); 
		sb.append("  WHERE not exists(select 1 from ch_adt_cityrecord t where t.rewardlistid=p.rewardlistid and t.systemflag=2) and p.WAYID=W.WAYID ");
		if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND p.WAYID=A.WAYID ) "); 
			params.getQueryConditions().put("chainhead", params.get_se_chainhead());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid=:countyid AND p.WAYID=A.WAYID ) "); 
			params.getQueryConditions().put("countyid", params.get_se_countyid());
			params.set_se_countyid(null);
		}
		if(params.get_se_mobile()!=null && params.get_se_mobile().trim().length()>0){
			sb.append("    and ((p.mobile=:mobile) or (p.opnid like '04%' and p.bakinfo=:mobile)) "); 
			params.getQueryConditions().put("mobile", params.get_se_mobile());
			params.set_se_mobile(null);
		}
		if(params.get_sin_opnid()!=null && params.get_sin_opnid().trim().length()>0){
			sb.append("    and P.OPNID IN(:opnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("opnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
			sb.append("    and p.rewardmonth=:rewardmonth ");
			params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth());
			params.set_se_rewardmonth(null);
		}
		if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
			sb.append("    and p.wayid=:wayid ");
			params.getQueryConditions().put("wayid", params.get_se_wayid());
			params.set_se_wayid(null);
		}
		sb.append(" AND W.WAYSUBTYPE<>'ZJTY' AND W.WAYTYPE='AG' AND W.CITYID=:cityid ");
		params.getQueryConditions().put("cityid", cityid);
		DataPackage dp = this.queryBySql(sb.toString(), params);
		return dp;
	}
}
