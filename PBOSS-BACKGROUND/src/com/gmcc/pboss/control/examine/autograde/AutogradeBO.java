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
//		1.	��ȡ������ĿǰӦ���ڳ����������еĿ��ˣ������õ��������Ŀ��˻���ʡ��˾����Ӧ���ڸõ��У�
//		����״̬Ϊ��Ч�Ŀ��ˣ��������ÿ������ڻ��߿������ڵġ���ֹ��[ENDMONTH]���������£���
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date stateDate = null;
		try{
			stateDate = format.parse(stateTime);
		}catch(Exception e){
			System.out.println("===============��������������["+stateTime+"]  ��ʽ ����ȷ��yyyyMM)");
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
//				2.	����ÿһ���ˣ�				
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
//		1)	���ݡ����˱�ʶ[EXMNID]���͡���ֹ��[ENDMONTH]���������¡���ע����ʽΪyyyymm��Ĭ�Ͽ�����Ϊ�������е�ǰʱ�����һ���·ݣ�
//		�ӡ���������[CH_PW_EXMNPERIOD]�����л�ȡ�ÿ��˵����һ���������ڣ�
		
		/*************************�ڵ�һ��ȡ����ʱ�Ѿ�������1����ȡֵ����*******************************/
		
//		2)	���û�����ÿ������ڣ���ÿ��˵Ŀ�������Ϊ��Ȼ�£����紦������Ϊ200911��
//          ��ÿ��˵ĵ�ǰ��������Ϊ20091001000000��20091031235959
//		           ���򣬸ÿ��˵Ŀ�������Ϊ����������[CH_PW_EXMNPERIOD]����¼�еġ���ʼ��[BEGINMONTH]���͡���ֹ��[ENDMONTH]����
		String startTime = null;//�������ڿ�ʼʱ��
		String endTime = null;//�������ڽ���ʱ��
		if(null == examineMap.get("ENDMONTH") || "".equals((String)examineMap.get("ENDMONTH"))
				|| null == examineMap.get("BEGINMONTH") || "".equals((String)examineMap.get("BEGINMONTH"))){
//			String[] lastMonthDay = PublicUtils.getLastMonthDay(new Date());
//			startTime = lastMonthDay[0]+"000000";
//			endTime = lastMonthDay[1]+"235959";
			//��Ʊ䶯��2011-8-2��
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
			if(endMonth<startMonth)//����
				calendar.set(Calendar.YEAR, -1);
			calendar.set(Calendar.MONTH, startMonth-1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startTime = PublicUtils.formatUtilDate(calendar.getTime(), "yyyy-MM-dd")+" 00:00:00";
		}
		startTime = startTime.replaceAll("-", "").replaceAll("\\s+", "").replaceAll(":", "");//
		endTime = endTime.replaceAll("-", "").replaceAll("\\s+", "").replaceAll(":", "");
		log.info("********************startTime="+startTime+"******************endTime="+endTime);
		
//		3)	���ݡ����˱�ʶ[EXMNID]���ӡ�ָ��[CH_PW_EXAMINESTD]���͡�������[CH_PW_EXMNITEM]��
//		���й�����ѯ�������ַ�ʽ[MARKMODE]��Ϊ��ϵͳ[1]���Ŀ���ָ�ꡣ�������п���ָ�꣺

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
//					a)	��ȡ���߼�[SYSLOGIC]���ֶ���Ϣ��������ð��[:]�����в���ֶδ����жϷ�������ֵ��SQL����PGM��
//					�����SQL���򽫿��������滻��@STARTTIME@��@ENDTIME@�����ذ�������������[WAYID]����
//					��ҵ����[BUSIVALUE]����Ϣ�ļ�¼���ϣ������PGM����ͨ���������������࣬�����ø����examine������
//					���п���������Ϊstarttime,endtime���Σ����صİ�������������[WAYID]������ҵ����[BUSIVALUE]����Ϣ�ļ�¼���ϣ�
					
					List processList = null;
					Float exmnscore = estdMap.get("EXMNSCORE") == null? null: new Float((String)estdMap.get("EXMNSCORE") );//������÷�
					String sysLogic = estdMap.get("SYSLOGIC") == null? null:(String)estdMap.get("SYSLOGIC");
					if( null == sysLogic || -1 == sysLogic.indexOf(":"))
						throw new Exception("�߼�:["+sysLogic+"] ��ʽ����");
					
					String[] processType = sysLogic.split(":");
					 if("SQL".equalsIgnoreCase(processType[0])){
						 String sqlString = processType[1];
						 log.info("�滻����ǰ��SQL��"+sqlString);
						 if(-1 == sqlString.indexOf("@STARTTIME@") || -1 == sqlString.indexOf("@ENDTIME@") )
							 throw new Exception("��������ȷ:"+sqlString);
						 if( -1 != sqlString.indexOf("@CITYID@")){
							 sqlString = sqlString.replaceAll("@CITYID@", user.getCityid()); 
						 }
						 sqlString = sqlString.replaceAll("@STARTTIME@", startTime);
						 sqlString = sqlString.replaceAll("@ENDTIME@", endTime);
						 sqlString = sqlString.replaceAll(";$", "");//�����;��,��ȥ����ֹ�û���SQL����;������Ĵ���	
						// sqlString = sqlString.replaceAll("(\\s+delete\\s+)|(\\s+update\\s+)|(\\s+alert\\s+)|(\\s+insert\\s+)", "");
						 log.info(sqlString);
						DataPackage tempDP = examineControl.doQueryBySql(sqlString, new ExamineListVO() );
						if( null != tempDP && null != tempDP.getDatas() && !tempDP.getDatas().isEmpty()){
							processList = (List)tempDP.getDatas();
						}									 
					 }else if("PGM".equalsIgnoreCase(processType[0])){
						 String className = processType[1];
						 try{
							 log.info("=============PGM��ʽ�����ýӿ�ʵ���ࣺ"+className+"======================");
						 Examine examine = (Examine)Class.forName(className).newInstance();
						
						 processList = examine.examine(startTime, endTime,user.getCityid());
						 }catch(Exception e){
							 e.printStackTrace();
							 throw new Exception("PGM��ʽ ���ýӿ�ʱ����ʧ�� "+e.getMessage());
						 }
					 }else throw new Exception("�߼�["+sysLogic+"] ����ʽ����ȷ Ŀǰֻ֧�� SQL��PGM��ʽ");
				
//					 b)	ͨ�������˱�ʶ[EXMNID]���͡�����ָ��[EXMNSTDID]���ӡ���������ϸ[CH_PW_EXMNITEMDTL]��
//						���л�ȡָ����ϸ����
					 DataPackage exmnitemdtlDP = this.getExmnitemdtlList((String)estdMap.get("EXMNID"),(String)estdMap.get("EXMNSTDID"));
					 
//					c)	�������صġ���������[WAYID]������ҵ����[BUSIVALUE]����¼���ϣ��жϡ���������[WAYID]���Ƿ���Ͽ����趨��������
//					����������[ADTYPE]���͡��Ǽ�[STARLEVEL]��(���жϸÿ����Ƿ�Ӧ���ڸá���������[ADTYPE]�������Ǽ�[STARLEVEL]��������)��
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
	 * ͨ�����˱�ʶ��ָ���ʶ����ȡ������ϸ
	 * @param exmnid		���˱�ʶ
	 * @param exmnstdid		ָ���ʶ
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
	 * �ӿ���ָ����ϸ�б���ȡ��BUSIVALUE�������ڵ���ϸ������ȡָ�����еģ�
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
								break; //���Ȼ�ȡ�����е�ָ����ϸ����
							 }
					 } 
				 }catch(Exception e){

				 }
			 }
		 }
		 return exmnitemdtlVO;
	}
	/**
	 * �������� �����������Ŀ�����ϸ���ӿ���������
	 * @param wayBusivalueMapList	����MAP�б� Ԫ������ΪMAP �����棺WAYID������ID��BUSIVALUE��������ҵ����
	 * @param examinestdMap �����������ϢMAP
	 * @param adtype		���˵���������	
	 * @param startLevel	���˵ĵȼ�
	 * @param cityID
	 * @throws Exception 
	 */
	private void doSaveItemgraded(List wayBusivalueMapList,Map examinestdMap ,DataPackage exmnitemdtlDP,String adtype,String startLevel,String stateTime) throws Exception{
		 Way wayControl = (WayControlBO) BOFactory.build(WayControlBO.class,user);
		 Float exmnscore = examinestdMap.get("EXMNSCORE") == null? null: new Float((String)examinestdMap.get("EXMNSCORE") );//������÷�
		 for(int i = 0;i<wayBusivalueMapList.size();i++){
			 try{
				 Map wayMap = (Map)wayBusivalueMapList.get(i);
				 String wayid = wayMap.get("WAYID") == null? null : (String)wayMap.get("WAYID");
				 String bsusivalue = wayMap.get("BUSIVALUE") == null? null : (String)wayMap.get("BUSIVALUE");
				 
//					b)	ͨ�������˱�ʶ[EXMNID]���͡�����ָ��[EXMNSTDID]���ӡ���������ϸ[CH_PW_EXMNITEMDTL]��
//					���л�ȡָ����ϸ���ã��������ʡ��˾�ͱ����е�ָ����ϸ���ã������Ȼ�ȡ�����е�ָ����ϸ���ã���
					
				 ExmnitemdtlVO exmnitemdtlVO = getExmnitemdtlVO(exmnitemdtlDP,Double.parseDouble(bsusivalue),user.getCityid());

				 if(null != wayid){
					 WayVO wayVO = wayControl.doFindByPk(wayid);
					 if(null == wayVO)
						 continue;//������һ��ѭ��
					 if( null != adtype && null != startLevel && null!= wayVO.getStarlevel() && null != wayVO.getAdtypecode()
							 && -1 != startLevel.indexOf(""+wayVO.getStarlevel()) && -1 != adtype.indexOf(""+wayVO.getAdtypecode()) ){
//							d)	�Է������������ġ�ҵ����[BUSIVALUE]���롰��������ϸ[CH_PW_EXMNITEMDTL]�����е���Ϣ���жԱȣ�

						 Itemgraded itemgradedControl = (ItemgradedBO) BOFactory.build(ItemgradedBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
						 ItemgradedVO itemgradedVO = new ItemgradedVO();

						 itemgradedVO.setExmnperiod(stateTime);
						 itemgradedVO.setRegistercode(user.getOprcode());
						 itemgradedVO.setState("1");
						 itemgradedVO.setExmnid(new Integer((String)examinestdMap.get("EXMNID")));
						 itemgradedVO.setExmnstdid(new Integer((String)examinestdMap.get("EXMNSTDID")));
						 itemgradedVO.setWayid(wayid);	
						 if( null == exmnitemdtlVO || null == exmnitemdtlVO.getLargestcrtcl() || null == exmnitemdtlVO.getLeastcrtcl()){
//							 ����ÿ��˵Ŀ������޿�������ϸ���û����޶�Ӧָ��ֵ���䣬������һ�ʼ�¼��������������[CH_PW_ITEMGRADED]�����У�
//							���С���������[EXMNPERIOD]���������£����ǼǺŹ�[REGISTERCODE]��Ϊ��̨ͳһ���ţ���״̬[STATE]��Ϊ��ͨ��[1]����
//							 ���۷�����[PENALMARK]��= ������[EXMNSCORE]������������[CH_PW_EXMNITEM]�����еģ�

							 itemgradedVO.setPenalmark(exmnscore);
							 itemgradedControl.doCreate(itemgradedVO);
						 }else if( "0".equals(exmnitemdtlVO.getMarktype()) ){
//							 �����ҵ����[BUSIVALUE]�����ڿ��˵Ŀ������Ӧ��ָ��ֵ����ġ���������[MARKTYPE]��Ϊ���̶�[0]����
//								���۷�����[PENALMARK]��=������[EXMNSCORE]������������[CH_PW_EXMNITEM]�����У�- ������[BASEMK]��������������ϸ[CH_PW_EXMNITEMDTL]�����У���
//								�����۷�����[PENALMARK]����Ϊ0ʱ��������һ�ʼ�¼��������������[CH_PW_ITEMGRADED]�����У�
//								���С���������[EXMNPERIOD]��Ϊ�������£����ǼǺŹ�[REGISTERCODE]��Ϊ��̨ͳһ���ţ�
//								��״̬[STATE]��Ϊ��ͨ��[1]����
							 float basemk = exmnitemdtlVO.getBasemk().floatValue();
							 float penalmark = exmnscore.floatValue() - basemk;
							 if(0 != penalmark ){	
								 itemgradedVO.setPenalmark(new Float(penalmark));
								 itemgradedControl.doCreate(itemgradedVO);
							 }														 
						 }else if("1".equals(exmnitemdtlVO.getMarktype()) ){
//							 �����ҵ����[BUSIVALUE]�����ڿ��˵Ŀ������Ӧ��ָ��ֵ����ġ���������[MARKTYPE]��Ϊ������[1]����
//								���۷�����[PENALMARK]��=������[EXMNSCORE]��-��������/������[BASEMK]��+�����Է�[DYNAMICMK]��/(�����ָ��ֵ[LARGESTCRTCL]��-����Сָ��ֵ[LEASTCRTCL]��)*����ҵ����[BUSIVALUE]��-����Сָ��ֵ[LEASTCRTCL]��������
//								�����۷�����[PENALMARK]����Ϊ0ʱ��������һ�ʼ�¼��������������[CH_PW_ITEMGRADED]�����У�
//								���С���������[EXMNPERIOD]���������£����ǼǺŹ�[REGISTERCODE]��Ϊ��̨ͳһ���ţ���״̬[STATE]��Ϊ��ͨ��[1]����
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
			 }catch(Exception e){//c)�������
				 e.printStackTrace();
				 LoggerUtils.error(e, log);
			 } 
		 }
	}
	
}
