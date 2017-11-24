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
//		1��	��ȡ������ĿǰӦ���ڳ����������еĿ��ˣ������õ��������Ŀ��˻���ʡ��˾����Ӧ���ڸõ��У��ҿ���״̬Ϊ��Ч�Ŀ��ˣ�
//		����ͳ���俼���ͨ�������˱�ʶ[EXMNID]���ӡ�������[CH_PW_EXMNITEM]������ͳ�ơ�����[EXMNSCORE]����
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
			log.info("++++++++++++++δ�ҵ����������Ŀ���++++++++++++++++++++++");
			return;
		}

//		2��	��ȡ��ǰ�������������������Ϣ���硰��������[WAYID]��������������[ADTYPECODE]�������Ǽ�[STARLEVEL]��
//		���ӡ�����[CH_PW_WAY]���л�ȡ����������[WAYTYPE]��=��AG���������б�ʶ[CITYID]��Ϊ��ǰ���б�ʶ����
		
		
		Way wayControl = (WayControlBO) BOFactory.build(WayControlBO.class,user);
		WayListVO wayParams = new WayListVO();
		wayParams.setQueryAll(true);
		wayParams.setDataOnly(true);
		wayParams.set_se_waytype("AG");
		wayParams.set_ne_waystate(new Short("1"));
		wayParams.set_se_cityid(user.getCityid());
		DataPackage wayDP = wayControl.doQuery(wayParams);
		
		if(null == wayDP || null == wayDP.getDatas() || wayDP.getDatas().isEmpty()){
			log.info("++++++++++++++δ�ҵ���������������++++++++++++++++++++++");
			return;
		}
//		3��	������1�����ȡ�Ŀ��˼��ϣ�
		Iterator examineList = examineScoreDP.getDatas().iterator();
		while(examineList.hasNext()){
			try{
				Map examineMap = (Map)examineList.next();
				ExamineVO examineVO = examineControl.doFindByPk(new Long((String)examineMap.get("EXMNID")));
				Iterator wayList = wayDP.getDatas().iterator();
//				a)	������2�����ȡ��������Ϣ���ϣ�
				while(wayList.hasNext()){
					try{
						WayVO wayVO = (WayVO)wayList.next();
//						i.	�жϡ���������[WAYID]���Ƿ���Ͽ����趨������������������[ADTYPE]���͡��Ǽ�[STARLEVEL]��
//						(���жϸÿ����Ƿ�Ӧ���ڸá���������[ADTYPE]�������Ǽ�[STARLEVEL]��������)����������������������һ������
						if(null != wayVO.getAdtypecode() && -1 != examineVO.getAdtype().indexOf(""+wayVO.getAdtypecode()) 
								&& -1 != examineVO.getStarlevel().indexOf(""+wayVO.getStarlevel())){
//							ii.	���ݡ���������[WAYID]���������˱�ʶ[EXMNID]��������������[EXMNPERIOD]����������
//							����ʽΪyyyymm��������״̬[STATE]��Ϊ�������[1]����
//							�������ҡ�����������[CH_PW_ITEMGRADED]���͡�������[CH_PW_EXMNITEM]����
							
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
							
//							iii.	���㿼��ָ��÷֣�ָ�����-ָ��۷�������������������ڡ�������÷���ϸ[CH_PW_EXMNSTDDTL]����
							boolean canExamine = true;//������������˵Ŀ���ָ���з����÷�Ϊ0����������俼�˷�����Ӧ����
							
							
							if(tempDP != null && tempDP.getDatas()!= null && !tempDP.getDatas().isEmpty()){
								Iterator penalmarkIterator = tempDP.getDatas().iterator();
								double totalCore = 0.0;//�����ܷ�
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
//								iv.	���ݡ���������[WAYID]���������˱�ʶ[EXMNID]��������������[EXMNPERIOD]��������ܡ�������÷���ϸ[CH_KH_EXMNSTDDTL]����
//								������������浽�����˽��[CH_PW_EXMNRSLT]�����У�ע��������������˵Ŀ���ָ���з����÷�Ϊ0����������俼�˷�����Ӧ���㣩	
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
