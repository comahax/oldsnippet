/**
* auto-generated code
* Mon Jan 09 12:05:49 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.control.DictitemControl;
import com.sunrise.boss.business.admin.dictitem.control.DictitemControlBean;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameDAO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecord2DAO</p>
 * <p>Description: Data Access Object for BbcRewardrecord2VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BbcRewardrecord2DAO extends BaseDAO {

    /**
     * default constructor
     */
    public BbcRewardrecord2DAO(){
        super(BbcRewardrecord2VO.class);
    }
 
    //2012-7-21 史晓龙 注释此方法并重写
    public DataPackage doQuery4Thread(BbcRewardrecord2ListVO params, User user) throws Exception{
    	if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
//select t.rewardlistid,t.operseq,t.datasrc,t.opnid,t.wayid,t.wayoprcode,
//    case when t.rewardtype in (10) then 2 else 1 end rewardtype,
//    t.rewardstd,t.rewardmonth,t.totalsum,t.paysum,t.runtime,t.oprtime,
//    t.noncyc,t.ossrc,t.mobile,t.batchno,t.rewardid
//	from CH_BBC_REWARDRECORD t,ch_pw_way w
//	where not exists (SELECT 1 from CH_ADT_CITYRECORD c
//	      where t.REWARDLISTID = c.REWARDLISTID and c.rewardmonth = :rewardmonth
//	        and c.SYSTEMFLAG = 3)-- and c.REWARDLISTID IS NOT NULL
//	and EXISTS (SELECT 1 FROM CH_PW_WAY A WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID)
//	and EXISTS (SELECT 1 FROM CH_PW_WAY A WHERE A.countyid = :countyid AND t.WAYID = A.WAYID)
//	and t.wayid=w.wayid
//	and substr(t.batchno,7)='00'
//	and t.opnid in (:sinopnid)
//	and t.ossrc in (3, 4, 5)
//	and t.wayid = :wayid
//	and t.mobile = :mobile
//	and t.rewardmonth = :rewardmonth
//	and w.wayid<>:u_00000 and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid
//	order by t.rewardlistid;
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	StringBuilder sb = new StringBuilder();
    	sb.append("select ");
    	sb.append("t.rewardlistid,t.operseq,t.datasrc,t.opnid,t.wayid,t.wayoprcode,");//--t.rewardtype, 
    	sb.append("case ");
    	sb.append(" when t.rewardtype in(10) then 2 ");
    	sb.append(" else 1 ");
    	sb.append("end rewardtype, ");
    	sb.append("t.rewardstd,t.rewardmonth,t.totalsum,t.paysum,t.runtime,t.oprtime,");
    	sb.append("t.noncyc,t.ossrc,t.mobile,t.batchno,t.rewardid ");
    	sb.append("  from CH_BBC_REWARDRECORD t,CH_PW_WAY w ");
    	sb.append(" where not exists (SELECT 1 ");
    	sb.append("          from CH_ADT_CITYRECORD c ");
    	sb.append("         where t.REWARDLISTID = c.REWARDLISTID ");
    	sb.append("           and c.rewardmonth = :rewardmonth ");
    	sb.append("           and c.SYSTEMFLAG = 3 ) ");//and c.REWARDLISTID IS NOT NULL
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
    	sb.append(" and t.wayid = w.wayid");
    	sb.append(" and substr(t.batchno,7)='00' ");
    	if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){//业务编码（多选）
    		sb.append("   and t.opnid in (:sinopnid) ");
    		List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
    	sb.append("   and ossrc in (3, 4, 5) ");
    	if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
    		sb.append("   and t.wayid = :wayid ");
    		params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}   
    	if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
    		sb.append("   and t.mobile = :mobile");
    		params.getQueryConditions().put("mobile", params.get_se_mobile());
    		params.set_se_mobile(null);
    	}
    	sb.append("   and t.rewardmonth = :rewardmonth ");
    	sb.append("   and w.wayid<>:u_00000 and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid");
    	sb.append("	order by t.rewardlistid");    	
    	String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
    	params.getQueryConditions().put("u_00000", cityid+"U_00000");
    	params.getQueryConditions().put("cityid", cityid);
				
		DataPackage dpbbc = this.queryBySql(sb.toString(), params, QUERY_TYPE_DATA);
		
		DataPackage dp = new DataPackage();
		List<CityrecordVO> list = new ArrayList();
		if(null!=dpbbc && dpbbc.getDatas().size()>0){
			for(Iterator it = dpbbc.getDatas().iterator();it.hasNext();){
				BbcRewardrecord2VO rrvo = (BbcRewardrecord2VO)it.next();
				CityrecordVO crvo = new CityrecordVO();
				BeanUtils.copyProperties(crvo, rrvo);
				crvo.setIsflag((short)1);
				crvo.setSystemflag((short)3);
				crvo.setBusivalue((double)1);
				crvo.setPaymoney(rrvo.getPaysum());
				//模拟设置一下，到后面一条处理的就是1条
				crvo.setThreedelegate("1");
				list.add(crvo);
			}
		}
		dp.setDatas(list);
		dp.setPageNo(new Integer(params.get_pageno()));
		dp.setPageSize(new Integer(params.get_pagesize()));
		//dp.setRowCount(dpbbc.getRowCount());
		return dp;
    }

    //2012-7-21 史晓龙 注释此方法并重写
    public DataPackage doQuery4ThreadTotal(BbcRewardrecord2ListVO params, User user) throws Exception{
    	if(params.get_se_rewardmonth()==null || "".equals(params.get_se_rewardmonth().trim())){
			throw new Exception("查询条件[结算月份]不能为空");
		}
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	StringBuilder sb = new StringBuilder();
    	sb.append("select t.* ");
    	sb.append("  from CH_BBC_REWARDRECORD t,CH_PW_WAY w ");
    	sb.append(" where not exists (SELECT 1 ");
    	sb.append("          from CH_ADT_CITYRECORD c ");
    	sb.append("         where t.REWARDLISTID = c.REWARDLISTID ");
    	sb.append("           and c.rewardmonth = :rewardmonth ");
    	sb.append("           and c.SYSTEMFLAG = 3 ");
    	sb.append("           ) ");//and c.REWARDLISTID IS NOT NULL
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
    	sb.append(" and t.wayid = w.wayid");
    	sb.append(" and substr(t.batchno,7)='00' ");
    	if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
    		sb.append("   and t.opnid in (:sinopnid) ");
		}
    	sb.append("   and ossrc in (3, 4, 5) ");
    	if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
    		sb.append("   and t.wayid = :wayid ");
		} 
    	if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
    		sb.append("   and t.mobile = :mobile");
    	}

    	sb.append("   and t.rewardmonth = :rewardmonth ");
    	sb.append("   and w.wayid<>:u_00000 and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid"); 
    	String rewardmonth = params.get_se_rewardmonth().trim();		
    	params.getQueryConditions().put("rewardmonth", rewardmonth);
    	params.set_se_rewardmonth(null);
    	params.getQueryConditions().put("u_00000", cityid+"U_00000");
    	params.getQueryConditions().put("cityid", cityid);
    	
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			params.getQueryConditions().put("wayid",params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
//		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
//			params.getQueryConditions().put("opnid", params.get_se_opnid().trim());
//			params.set_se_opnid(null);
//		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			params.set_se_countyid(null);
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
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
    		params.getQueryConditions().put("mobile", params.get_se_mobile());
    		params.set_se_mobile(null);
    	}
		
		DataPackage dp = queryBySql(sb.toString(),params,QUERY_TYPE_COUNT);
		return dp;
    }
    
}
