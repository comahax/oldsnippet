package com.gmcc.pboss.control.examine.autograde;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.cms.examine.Examine;
import com.gmcc.pboss.business.cms.examine.examine.control.ExamineBO;
import com.gmcc.pboss.business.cms.examine.examine.control.ExamineControl;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.control.Exmnitemdtl;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.control.ExmnitemdtlBO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.gmcc.pboss.business.cms.examine.itemgraded.control.Itemgraded;
import com.gmcc.pboss.business.cms.examine.itemgraded.control.ItemgradedBO;
import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.gmcc.pboss.business.cms.way.control.Way;
import com.gmcc.pboss.business.cms.way.control.WayControlBO;
import com.gmcc.pboss.business.cms.way.persistent.WayVO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class AutogradeBO extends AbstractControlBean implements Autograde{
	private Log log = LogFactory.getLog(AutogradeBO.class);
	
	public void process(String stateTime) throws Exception {
		// TODO Auto-generated method stub
//		1.	获取所有与目前应用于程序启动地市的考核（包括该地市新增的考核或者省公司新增应用于该地市，
//		考核状态为生效的考核，且无设置考核周期或者考核周期的“终止月[ENDMONTH]”处理年月）；
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date stateDate = null;
		try{
			stateDate = format.parse(stateTime);
		}catch(Exception e){
			System.out.println("===============参数：处理年月["+stateTime+"]  格式 不正确（yyyyMM)");
			return;
		}
		String stateMonth = stateTime.substring(4);
		int lastMonth = Integer.parseInt(stateMonth);
		ExamineControl  examineControl = (ExamineBO)BOFactory.build(ExamineBO.class,user);
		StringBuffer sql = new StringBuffer(200);
		sql.append("select distinct e.EXMNID,e.CITYID,e.APPLYCITYID,e.ADTYPE,e.STARLEVEL,p.BEGINMONTH,p.ENDMONTH ");
		sql.append("from CH_PW_EXAMINE e left join CH_PW_EXMNPERIOD p ");
		sql.append(" on e.EXMNID = p.EXMNID ");
		sql.append(" where 1=1 ");
		sql.append(" and (e.cityid ='").append(user.getCityid());
		sql.append("' or e.applycityid like '%").append(user.getCityid()).append("%') ");
		sql.append(" and state = '1' "); 
		sql.append(" and (p.ENDMONTH is null ");
		sql.append(" or p.ENDMONTH= ").append(lastMonth).append(")");
		log.info(sql.toString());
		ExamineListVO examineParam = new ExamineListVO();
		examineParam.set_pagesize("0");

		try {
			DataPackage examineDP = examineControl.doQueryBySql(sql.toString(), examineParam);

			if( null != examineDP && null != examineDP.getDatas() && !examineDP.getDatas().isEmpty()){
				Iterator examineIterator = examineDP.getDatas().iterator();
//				2.	遍历每一考核：				
				while(examineIterator.hasNext()){
					try{
						AutogradeBO bo = (AutogradeBO)BOFactory.build(AutogradeBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
						Map examineMap = (Map)examineIterator.next();
						bo.doAutoGrade(examineMap,stateTime);						
					}catch(Exception e){
						e.printStackTrace();
						LoggerUtils.error(e, log);		
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated 
			e.printStackTrace();
		}
	}	
	
	public void doAutoGrade(Map examineMap,String stateTime) throws Exception{		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String adtype = examineMap.get("ADTYPE") == null? null :(String)examineMap.get("ADTYPE");
		String startLevel = examineMap.get("STARLEVEL") == null? null :(String)examineMap.get("STARLEVEL");
//		1)	根据“考核标识[EXMNID]”和“终止月[ENDMONTH]”处理年月”（注：格式为yyyymm，默认考核月为程序运行当前时间的上一个月份）
//		从“考核周期[CH_PW_EXMNPERIOD]”表中获取该考核的最近一个考核周期；
		
		/*************************在第一步取考核时已经满足了1）的取值条件*******************************/
		
//		2)	如果没有设置考核周期，则该考核的考核周期为自然月（例如处理年月为200911，
//          则该考核的当前考核周期为20091001000000到20091031235959
//		           否则，该考核的考核周期为“考核周期[CH_PW_EXMNPERIOD]”记录中的“起始月[BEGINMONTH]”和“终止月[ENDMONTH]”；
		String startTime = null;//考核周期开始时间
		String endTime = null;//考核周期结束时间
		if(null == examineMap.get("ENDMONTH") || "".equals((String)examineMap.get("ENDMONTH"))
				|| null == examineMap.get("BEGINMONTH") || "".equals((String)examineMap.get("BEGINMONTH"))){
//			String[] lastMonthDay = PublicUtils.getLastMonthDay(new Date());
//			startTime = lastMonthDay[0]+"000000";
//			endTime = lastMonthDay[1]+"235959";
			//设计变动，2011-8-2号
			java.util.Date datetemp = PublicUtils.UtilStrToDate(stateTime, "yyyyMM");
			java.util.Date[] resultDate = new java.util.Date[2];
			resultDate = PublicUtils.getMonthPeriod(datetemp,0);
			startTime = PublicUtils.formatUtilDate(resultDate[0],"yyyyMMddHHmmss");
			endTime = PublicUtils.formatUtilDate(resultDate[1],"yyyyMMddHHmmss");
		}else{						
			int startMonth = Integer.parseInt((String)examineMap.get("BEGINMONTH"));
			int endMonth = Integer.parseInt((String)examineMap.get("ENDMONTH"));
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format.parse(stateTime));
			calendar.set(Calendar.MONTH, endMonth);
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			endTime = PublicUtils.formatUtilDate(calendar.getTime(), "yyyy-MM-dd")+" 23:59:59";
			
			int betwenMonth = 0;
			if(endMonth<startMonth)//跨年
				calendar.set(Calendar.YEAR, -1);
			calendar.set(Calendar.MONTH, startMonth-1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startTime = PublicUtils.formatUtilDate(calendar.getTime(), "yyyy-MM-dd")+" 00:00:00";
		}
		startTime = startTime.replaceAll("-", "").replaceAll("\\s+", "").replaceAll(":", "");//
		endTime = endTime.replaceAll("-", "").replaceAll("\\s+", "").replaceAll(":", "");
		log.info("********************startTime="+startTime+"******************endTime="+endTime);
		
//		3)	根据“考核标识[EXMNID]”从“指标[CH_PW_EXAMINESTD]”和“考核项[CH_PW_EXMNITEM]”
//		表中关联查询出“评分方式[MARKMODE]”为“系统[1]”的考核指标。遍历所有考核指标：

		ExamineListVO examineParam = new ExamineListVO();
		ExamineControl  examineControl = (ExamineBO)BOFactory.build(ExamineBO.class,user);
		examineParam.setQueryAll(true);
		examineParam.setDataOnly(true);
		examineParam.setSelectFieldsString("EXMNID,EXMNSCORE,EXMNSTDID,SYSLOGIC");
		Map conditionMap = new HashMap();
		conditionMap.put("EXMNID", (String)examineMap.get("EXMNID"));
		examineParam.setQueryConditions(conditionMap);
		DataPackage estdPackage = examineControl.doQueryBySqlName("com.gmcc.pboss.business.cms.examine.examinestd.persistent.queryByExmnidAndMarkmode", examineParam);
		
		if( null != estdPackage && null != estdPackage.getDatas() && !estdPackage.getDatas().isEmpty()){
			Iterator estdIterator = estdPackage.getDatas().iterator();
			while(estdIterator.hasNext()){
				try{
					Map estdMap = (Map)estdIterator.next();
//					a)	获取“逻辑[SYSLOGIC]”字段信息；并按“冒号[:]”进行拆分字段串，判断返回数组值是SQL或者PGM；
//					如果是SQL，则将考核周期替换掉@STARTTIME@和@ENDTIME@；返回包含“渠道代码[WAYID]”、
//					“业务量[BUSIVALUE]”信息的记录集合；如果是PGM，则通过反射机制载入该类，并调用该类的examine方法，
//					其中考核周期作为starttime,endtime传参；返回的包含“渠道代码[WAYID]”、“业务量[BUSIVALUE]”信息的记录集合；
					
					List processList = null;
					Float exmnscore = estdMap.get("EXMNSCORE") == null? null: new Float((String)estdMap.get("EXMNSCORE") );//考核项得分
					String sysLogic = estdMap.get("SYSLOGIC") == null? null:(String)estdMap.get("SYSLOGIC");
					if( null == sysLogic || -1 == sysLogic.indexOf(":"))
						throw new Exception("逻辑:["+sysLogic+"] 格式不对");
					
					String[] processType = sysLogic.split(":");
					 if("SQL".equalsIgnoreCase(processType[0])){
						 String sqlString = processType[1];
						 log.info("替换参数前的SQL："+sqlString);
						 if(-1 == sqlString.indexOf("@STARTTIME@") || -1 == sqlString.indexOf("@ENDTIME@") )
							 throw new Exception("参数不正确:"+sqlString);
						 if( -1 != sqlString.indexOf("@CITYID@")){
							 sqlString = sqlString.replaceAll("@CITYID@", user.getCityid()); 
						 }
						 sqlString = sqlString.replaceAll("@STARTTIME@", startTime);
						 sqlString = sqlString.replaceAll("@ENDTIME@", endTime);
						 sqlString = sqlString.replaceAll(";$", "");//如果有;号,则去掉防止用户在SQL最后加;号引起的错误	
						// sqlString = sqlString.replaceAll("(\\s+delete\\s+)|(\\s+update\\s+)|(\\s+alert\\s+)|(\\s+insert\\s+)", "");
						 log.info(sqlString);
						DataPackage tempDP = examineControl.doQueryBySql(sqlString, new ExamineListVO() );
						if( null != tempDP && null != tempDP.getDatas() && !tempDP.getDatas().isEmpty()){
							processList = (List)tempDP.getDatas();
						}									 
					 }else if("PGM".equalsIgnoreCase(processType[0])){
						 String className = processType[1];
						 try{
							 log.info("=============PGM方式：调用接口实现类："+className+"======================");
						 Examine examine = (Examine)Class.forName(className).newInstance();
						
						 processList = examine.examine(startTime, endTime,user.getCityid());
						 }catch(Exception e){
							 e.printStackTrace();
							 throw new Exception("PGM方式 调用接口时处理失败 "+e.getMessage());
						 }
					 }else throw new Exception("逻辑["+sysLogic+"] 处理方式不明确 目前只支持 SQL与PGM方式");
				
//					 b)	通过“考核标识[EXMNID]”和“考核指标[EXMNSTDID]”从“考核项明细[CH_PW_EXMNITEMDTL]”
//						表中获取指标明细设置
					 DataPackage exmnitemdtlDP = this.getExmnitemdtlList((String)estdMap.get("EXMNID"),(String)estdMap.get("EXMNSTDID"));
					 
//					c)	遍历返回的“渠道代码[WAYID]”、“业务量[BUSIVALUE]”记录集合，判断“渠道代码[WAYID]”是否符合考核设定的条件：
//					“区域类型[ADTYPE]”和“星级[STARLEVEL]”(即判断该考核是否应用于该“区域类型[ADTYPE]”、“星级[STARLEVEL]”的渠道)；
					if( null != processList && processList.size() >0){
						
						doSaveItemgraded(processList,estdMap,exmnitemdtlDP,adtype,startLevel,stateTime);
					}
				}catch(Exception e){
					e.printStackTrace();
					LoggerUtils.error(e, log);
				}
			}	
		}
		
	}
	
	
	/**
	 * 通过考核标识，指标标识，获取考核明细
	 * @param exmnid		考核标识
	 * @param exmnstdid		指标标识
	 * @return
	 * @throws Exception 
	 */
	private DataPackage getExmnitemdtlList(String exmnid,String exmnstdid) throws Exception{
		 Exmnitemdtl exmnitemdtlControl = (ExmnitemdtlBO) BOFactory.build(ExmnitemdtlBO.class,user);
		 ExmnitemdtlListVO exmniterdtlParam = new ExmnitemdtlListVO(); 
		 exmniterdtlParam.set_ne_exmnid(exmnid);
		 exmniterdtlParam.set_ne_exmnstdid(exmnstdid);
		 exmniterdtlParam.setQueryAll(true);
		 exmniterdtlParam.setDataOnly(true);
		 return exmnitemdtlControl.doQuery(exmniterdtlParam);
		 
	}
	
	/*
	 * 从考核指标明细列表中取得BUSIVALUE在区间内的明细（优先取指定地市的）
	 */
	private ExmnitemdtlVO getExmnitemdtlVO(DataPackage exmnitemdtlDP,double busivalue,String cityID) throws Exception{
		ExmnitemdtlVO exmnitemdtlVO = null;
		 if( null != exmnitemdtlDP && null != exmnitemdtlDP.getDatas() && !exmnitemdtlDP.getDatas().isEmpty()){
			 Iterator exmniemdtlIterator = exmnitemdtlDP.getDatas().iterator();
			 while(exmniemdtlIterator.hasNext()){
				 try{
					 ExmnitemdtlVO tempVO = (ExmnitemdtlVO) exmniemdtlIterator.next();
					 if(tempVO.getLeastcrtcl().doubleValue()<= busivalue && tempVO.getLargestcrtcl().doubleValue()>=busivalue){
						 exmnitemdtlVO = tempVO;
						 if(cityID.equals(exmnitemdtlVO.getCityid())){
								break; //优先获取本地市的指标明细设置
							 }
					 } 
				 }catch(Exception e){

				 }
			 }
		 }
		 return exmnitemdtlVO;
	}
	/**
	 * 遍历渠道 对满足条件的考核明细增加考核项评分
	 * @param wayBusivalueMapList	渠道MAP列表 元素内容为MAP ，保存：WAYID：渠道ID，BUSIVALUE：渠道的业务量
	 * @param examinestdMap 考核项相关信息MAP
	 * @param adtype		考核的区域类型	
	 * @param startLevel	考核的等级
	 * @param cityID
	 * @throws Exception 
	 */
	private void doSaveItemgraded(List wayBusivalueMapList,Map examinestdMap ,DataPackage exmnitemdtlDP,String adtype,String startLevel,String stateTime) throws Exception{
		 Way wayControl = (WayControlBO) BOFactory.build(WayControlBO.class,user);
		 Float exmnscore = examinestdMap.get("EXMNSCORE") == null? null: new Float((String)examinestdMap.get("EXMNSCORE") );//考核项得分
		 for(int i = 0;i<wayBusivalueMapList.size();i++){
			 try{
				 Map wayMap = (Map)wayBusivalueMapList.get(i);
				 String wayid = wayMap.get("WAYID") == null? null : (String)wayMap.get("WAYID");
				 String bsusivalue = wayMap.get("BUSIVALUE") == null? null : (String)wayMap.get("BUSIVALUE");
				 
//					b)	通过“考核标识[EXMNID]”和“考核指标[EXMNSTDID]”从“考核项明细[CH_PW_EXMNITEMDTL]”
//					表中获取指标明细设置（如果存在省公司和本地市的指标明细设置，则优先获取本地市的指标明细设置）；
					
				 ExmnitemdtlVO exmnitemdtlVO = getExmnitemdtlVO(exmnitemdtlDP,Double.parseDouble(bsusivalue),user.getCityid());

				 if(null != wayid){
					 WayVO wayVO = wayControl.doFindByPk(wayid);
					 if(null == wayVO)
						 continue;//继续下一次循环
					 if( null != adtype && null != startLevel && null!= wayVO.getStarlevel() && null != wayVO.getAdtypecode()
							 && -1 != startLevel.indexOf(""+wayVO.getStarlevel()) && -1 != adtype.indexOf(""+wayVO.getAdtypecode()) ){
//							d)	对符合条件渠道的“业务量[BUSIVALUE]”与“考核项明细[CH_PW_EXMNITEMDTL]”表中的信息进行对比：

						 Itemgraded itemgradedControl = (ItemgradedBO) BOFactory.build(ItemgradedBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
						 ItemgradedVO itemgradedVO = new ItemgradedVO();

						 itemgradedVO.setExmnperiod(stateTime);
						 itemgradedVO.setRegistercode(user.getOprcode());
						 itemgradedVO.setState("1");
						 itemgradedVO.setExmnid(new Integer((String)examinestdMap.get("EXMNID")));
						 itemgradedVO.setExmnstdid(new Integer((String)examinestdMap.get("EXMNSTDID")));
						 itemgradedVO.setWayid(wayid);	
						 if( null == exmnitemdtlVO || null == exmnitemdtlVO.getLargestcrtcl() || null == exmnitemdtlVO.getLeastcrtcl()){
//							 如果该考核的考核项无考核项明细设置或者无对应指标值区间，则新增一笔记录到“考核项评分[CH_PW_ITEMGRADED]”表中，
//							其中“考核周期[EXMNPERIOD]”处理年月，“登记号工[REGISTERCODE]”为后台统一工号，“状态[STATE]”为“通过[1]”；
//							 “扣罚分数[PENALMARK]”= “分数[EXMNSCORE]”（“考核项[CH_PW_EXMNITEM]”表中的；

							 itemgradedVO.setPenalmark(exmnscore);
							 itemgradedControl.doCreate(itemgradedVO);
						 }else if( "0".equals(exmnitemdtlVO.getMarktype()) ){
//							 如果“业务量[BUSIVALUE]”落在考核的考核项对应的指标值区间的“分数类型[MARKTYPE]”为“固定[0]”，
//								“扣罚分数[PENALMARK]”=“分数[EXMNSCORE]”（“考核项[CH_PW_EXMNITEM]”表中）- “分数[BASEMK]”（“考核项明细[CH_PW_EXMNITEMDTL]”表中）；
//								当“扣罚分数[PENALMARK]”不为0时，则新增一笔记录到“考核项评分[CH_PW_ITEMGRADED]”表中，
//								其中“考核周期[EXMNPERIOD]”为处理年月，“登记号工[REGISTERCODE]”为后台统一工号，
//								“状态[STATE]”为“通过[1]”；
							 float basemk = exmnitemdtlVO.getBasemk().floatValue();
							 float penalmark = exmnscore.floatValue() - basemk;
							 if(0 != penalmark ){	
								 itemgradedVO.setPenalmark(new Float(penalmark));
								 itemgradedControl.doCreate(itemgradedVO);
							 }														 
						 }else if("1".equals(exmnitemdtlVO.getMarktype()) ){
//							 如果“业务量[BUSIVALUE]”落在考核的考核项对应的指标值区间的“分数类型[MARKTYPE]”为“线性[1]”，
//								“扣罚分数[PENALMARK]”=“分数[EXMNSCORE]”-（“分数/基础分[BASEMK]”+“线性分[DYNAMICMK]”/(“最大指标值[LARGESTCRTCL]”-“最小指标值[LEASTCRTCL]”)*（“业务量[BUSIVALUE]”-“最小指标值[LEASTCRTCL]”））；
//								当“扣罚分数[PENALMARK]”不为0时，则新增一笔记录到“考核项评分[CH_PW_ITEMGRADED]”表中，
//								其中“考核周期[EXMNPERIOD]”处理年月，“登记号工[REGISTERCODE]”为后台统一工号，“状态[STATE]”为“通过[1]”；
							 float basemk = exmnitemdtlVO.getBasemk().floatValue();
							 float dynamicmk = exmnitemdtlVO.getDynamicmk().floatValue();
							 float largestcrtcl = exmnitemdtlVO.getLargestcrtcl().floatValue();
							 float leastcrtcl = exmnitemdtlVO.getLeastcrtcl().floatValue();	 
							 float busivalueValue = Float.parseFloat(bsusivalue);
							 float penalmark = exmnscore.floatValue()-(basemk+dynamicmk/(largestcrtcl-leastcrtcl)*(busivalueValue-leastcrtcl));
							 
							 if( 0 != penalmark){
								 itemgradedVO.setPenalmark(new Float(penalmark));
								 itemgradedControl.doCreate(itemgradedVO);
							 }														 
						 }
					 }
				 }
			 }catch(Exception e){//c)步骤出错
				 e.printStackTrace();
				 LoggerUtils.error(e, log);
			 } 
		 }
	}
	
}
