package com.gmcc.pboss.control.examine.gradegather;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.cms.examine.examine.control.ExamineControl;
import com.gmcc.pboss.business.cms.examine.examine.control.ExamineBO;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineListVO;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineVO;
import com.gmcc.pboss.business.cms.examine.examinestd.control.Examinestd;
import com.gmcc.pboss.business.cms.examine.examinestd.control.ExaminestdBO;
import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.control.Exmnrslt;
import com.gmcc.pboss.business.cms.examine.exmnrslt.control.ExmnrsltBO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.control.Exmnstddtl;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.control.ExmnstddtlBO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlVO;
import com.gmcc.pboss.business.cms.way.control.Way;
import com.gmcc.pboss.business.cms.way.control.WayControlBO;
import com.gmcc.pboss.business.cms.way.persistent.WayListVO;
import com.gmcc.pboss.business.cms.way.persistent.WayVO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class GradeGatherBO extends AbstractControlBean implements GradeGather{
	private Log log = LogFactory.getLog(GradeGatherBO.class);

	public void process(String stateTime) throws Exception {
		// TODO Auto-generated method stub
//		1、	获取所有与目前应用于程序启动地市的考核（包括该地市新增的考核或者省公司新增应用于该地市，且考核状态为生效的考核）
//		，并统计其考核项（通过“考核标识[EXMNID]”从“考核项[CH_PW_EXMNITEM]”表中统计“分数[EXMNSCORE]”）
	//	Session session = SessionUtil.currentSession(cityID);
		ExamineControl examineControl = (ExamineBO)BOFactory.build(ExamineBO.class,user);
		Exmnstddtl exmnstddtlBO = (ExmnstddtlBO)BOFactory.build(ExmnstddtlBO.class,user);
		Exmnrslt exmnrsltControl = (ExmnrsltBO)BOFactory.build(ExmnrsltBO.class,user);
		Examinestd examinestdBO = (ExaminestdBO)BOFactory.build(ExaminestdBO.class,user);

		StringBuffer sql = new StringBuffer(100);
		sql.append("select e.EXMNID, sum(i.EXMNSCORE) EXMNSCORE ");
		sql.append(" from CH_PW_EXAMINE e,CH_PW_EXMNITEM i ");
		sql.append(" where ");
		sql.append(" i.EXMNID = e.EXMNID ");
		sql.append(" and e.STATE = '1' ");
		sql.append(" and ( e.CITYID = '").append(user.getCityid()).append("'");
		sql.append(" or e.APPLYCITYID like '%").append(user.getCityid()).append("%')");
		sql.append(" group by e.EXMNID");
		
		log.info(sql.toString());
		ExamineListVO params = new ExamineListVO();
		params.set_pagesize("0");
		List list = new ArrayList();
		list.add("EXMNID");
		list.add("EXMNSCORE");
		params.setSelectFields(list);
		DataPackage examineScoreDP = examineControl.doQueryBySql(sql.toString(), params);
		
		if(examineScoreDP == null || examineScoreDP.getDatas() == null || examineScoreDP.getDatas().isEmpty()){
			log.info("++++++++++++++未找到满足条件的考核++++++++++++++++++++++");
			return;
		}

//		2、	获取当前地市所有社会渠道的信息，如“渠道代码[WAYID]”、“区域类型[ADTYPECODE]”及“星级[STARLEVEL]”
//		（从“渠道[CH_PW_WAY]”中获取“渠道类型[WAYTYPE]”=’AG’，“地市标识[CITYID]”为当前地市标识）；
		
		
		Way wayControl = (WayControlBO) BOFactory.build(WayControlBO.class,user);
		WayListVO wayParams = new WayListVO();
		wayParams.setQueryAll(true);
		wayParams.setDataOnly(true);
		wayParams.set_se_waytype("AG");
		wayParams.set_ne_waystate(new Short("1"));
		wayParams.set_se_cityid(user.getCityid());
		DataPackage wayDP = wayControl.doQuery(wayParams);
		
		if(null == wayDP || null == wayDP.getDatas() || wayDP.getDatas().isEmpty()){
			log.info("++++++++++++++未找到满足条件的渠道++++++++++++++++++++++");
			return;
		}
//		3、	遍历第1步骤获取的考核集合：
		Iterator examineList = examineScoreDP.getDatas().iterator();
		while(examineList.hasNext()){
			try{
				Map examineMap = (Map)examineList.next();
				ExamineVO examineVO = examineControl.doFindByPk(new Long((String)examineMap.get("EXMNID")));
				Iterator wayList = wayDP.getDatas().iterator();
//				a)	遍历第2步骤获取的渠道信息集合：
				while(wayList.hasNext()){
					try{
						WayVO wayVO = (WayVO)wayList.next();
//						i.	判断“渠道代码[WAYID]”是否符合考核设定的条件：“区域类型[ADTYPE]”和“星级[STARLEVEL]”
//						(即判断该考核是否应用于该“区域类型[ADTYPE]”、“星级[STARLEVEL]”的渠道)，不符合则跳过，继续下一渠道；
						if(null != wayVO.getAdtypecode() && -1 != examineVO.getAdtype().indexOf(""+wayVO.getAdtypecode()) 
								&& -1 != examineVO.getStarlevel().indexOf(""+wayVO.getStarlevel())){
//							ii.	根据“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期[EXMNPERIOD]”处理年月
//							（格式为yyyymm，）、“状态[STATE]”为“已审核[1]”、
//							关联查找“考核项评分[CH_PW_ITEMGRADED]”和“考核项[CH_PW_EXMNITEM]”表；
							
							log.info(sql.toString());
							ExamineListVO examineParam = new ExamineListVO();
							Map conditionMAP = new HashMap();
							conditionMAP.put("EXMNID", (String)examineMap.get("EXMNID"));
							conditionMAP.put("EXMNPERIOD", stateTime);
							conditionMAP.put("WAYID", wayVO.getWayid());
							examineParam.setQueryConditions(conditionMAP);
							examineParam.setQueryAll(true);
							examineParam.setDataOnly(true);
							List selectList = new ArrayList();
							selectList.add("EXMNID");
							selectList.add("EXMNSTDID");
							selectList.add("EXMNSCORE");
							selectList.add("PENALMARK");
							examineParam.setSelectFields(selectList);
							DataPackage tempDP = examineControl.doQueryBySqlName("com.gmcc.pboss.business.cms.examine.examinestd.persistent.query1", examineParam);
							
//							iii.	计算考核指标得分（指标分数-指标扣罚分数），将结果保存于“考核项得分明细[CH_PW_EXMNSTDDTL]”。
							boolean canExamine = true;//如果该渠道考核的考核指标有否决项得分为0的情况，则其考核分数相应清零
							
							
							if(tempDP != null && tempDP.getDatas()!= null && !tempDP.getDatas().isEmpty()){
								Iterator penalmarkIterator = tempDP.getDatas().iterator();
								double totalCore = 0.0;//考核总分
								while(penalmarkIterator.hasNext()){
									Map penalmarkMap = (Map)penalmarkIterator.next();
									Double penalmark = new Double((String)penalmarkMap.get("PENALMARK"));
									Double exmnscore = new Double((String)penalmarkMap.get("EXMNSCORE"));
									Double resultScore = exmnscore-penalmark;
									if("1".equals((String)penalmarkMap.get("ISVOTED")) && 0 == resultScore ){
										canExamine = false;
									}
									ExaminestdVO examinestdVO =  examinestdBO.doFindByPk(new Long((String)penalmarkMap.get("EXMNSTDID")));
									ExmnstddtlVO exmnstddtlVO = new ExmnstddtlVO();
									exmnstddtlVO.setExmnid(examineVO.getExmnid().intValue());
									exmnstddtlVO.setExmnname(examineVO.getExmnname());
									exmnstddtlVO.setExmnstdid(new Integer((String)penalmarkMap.get("EXMNSTDID")));
									if( null == examinestdVO){
										exmnstddtlVO.setExmnstdname("");	
									}else{
										exmnstddtlVO.setExmnstdname(examinestdVO.getExmnstdname());
									}
									exmnstddtlVO.setExmnperiod(stateTime);
									exmnstddtlVO.setWayid(wayVO.getWayid());
									exmnstddtlVO.setExmnmark(resultScore);
									exmnstddtlBO.doCreate(exmnstddtlVO);
								}
//								iv.	根据“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期[EXMNPERIOD]”分组汇总“考核项得分明细[CH_KH_EXMNSTDDTL]”表
//								，并将结果保存到“考核结果[CH_PW_EXMNRSLT]”表中（注：如果该渠道考核的考核指标有否决项得分为0的情况，则其考核分数相应清零）	
								ExmnrsltVO exmnrsltVO = new ExmnrsltVO();
								exmnrsltVO.setExmnid(examineVO.getExmnid().intValue());
								exmnrsltVO.setWayid(wayVO.getWayid());
								exmnrsltVO.setExmnperiod(stateTime);
								if(!canExamine){
									exmnrsltVO.setExmnmark(0.0);
									exmnrsltControl.doCreate(exmnrsltVO);
								}else{
									ExmnstddtlListVO param = new ExmnstddtlListVO();
									Map conditionMap = new HashMap();
									conditionMap.put("wayid", wayVO.getWayid());
									conditionMap.put("exmnid", examineVO.getExmnid());
									conditionMap.put("exmnperiod", stateTime);
									param.setQueryConditions(conditionMap);
									param.setDataOnly(true);
									param.setQueryAll(true);
									param.setSelectFieldsString("SCORE");

									DataPackage scoreDP = exmnstddtlBO.doQueryByNameSql("com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.sumQuery", param);
									if( null != scoreDP && null != scoreDP.getDatas() && !scoreDP.getDatas().isEmpty()){
										 String score = (String)scoreDP.getDatas().get(0);
										exmnrsltVO.setExmnmark(Double.valueOf(score));
										exmnrsltControl.doCreate(exmnrsltVO);
									}
								}	
							}	
						}
					}catch(Exception e){
						e.printStackTrace();
						LoggerUtils.error(e, log);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				LoggerUtils.error(e, log);
			}				
		}
	}

}
