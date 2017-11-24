package com.gmcc.pboss.control.sales.realtimemt;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * �׿�ʵʱ����������
 * @author wefrogll  
 * @version 1.0 2009-12-29
 * @version 2.0 2010-6-22 by zhangsiwei
 */
public class RealTimeOrderBO extends AbstractControlBean implements RealTimeOrder{
	private final static String BRAND_ALLBRAND = "AllBrand";
	private Log log = LogFactory.getLog(RealTimeOrderBO.class);
	private static final String DAYANDMONTHORDER_STATE_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.DAYANDMONTHORDER_STATE_NOTBY_BRAND";
	
	private static final String DAYANDMONTHORDER_STATE_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.DAYANDMONTHORDER_STATE_BY_BRAND";
	
	private static final String STORAGE_COUNT_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_COUNT_NOTBY_BRAND";
	
	private static final String STORAGE_STATE_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_STATE_NOTBY_BRAND";
	
	private static final String STORAGE_COUNT_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_COUNT_BY_BRAND";
	
	private static final String STORAGE_STATE_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_STATE_BY_BRAND";
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
		try{
//			1)
			//boolean isMonDayLimit = false; // �Ƿ�"���¶�����ģʽ" Ĭ��Ϊ��
			
			// ================��������CR_ZQ20100611_1051316���޸�=============
			// ��ȡ������Լ��ģʽ, ��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��45����
			// ����������Ҳ���ֵ��Ϊ�գ��򶩹���Լ��ģʽȡ����ֵ�����򶩹���Լ��ģʽĬ��ȡ���¶�����ģʽ����MONDAYLIMIT��
			/*Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String paramValue = sysparamBO.doFindByID("45", "pboss_fx");
			if("".equals(paramValue) || paramValue == null) {
				paramValue = "MONDAYLIMIT";
			}
			if(paramValue.equals("MONDAYLIMIT"))
				isMonDayLimit = true;*/
//			��ȡ�׿��Ƿ�����Ʒ�ƣ���ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ��������͵��ڡ�pboss_fx����������ʶ���ڡ�12����
//			����������Ҳ���ֵΪ1������Ʒ�ƣ���������Ʒ�ơ��������Ʒ�ƣ����ѯ�����ֵ��SA_DB_DICTITEM����ȡƷ�Ƽ��ϣ�
//			����SQL��select DICTID, DICTNAME from SA_DB_DICTITEM where GROUPID='FX_SMPBRAND' and DICTID<>'AllBrand';
//			 ����DICTID��ӦƷ�Ʊ�ʶ������DICTNAME��ӦƷ�����ơ�
			Dictitem dictitemBO = (DictitemBO)BOFactory.build(DictitemBO.class,user);
			DictitemDBParam dictitemParam = new DictitemDBParam();
			dictitemParam.setQueryAll(true);
			dictitemParam.setDataOnly(true);
			dictitemParam.set_se_groupid("FX_SMPBRAND");
			dictitemParam.set_sne_dictid(BRAND_ALLBRAND);
			DataPackage dictitemDP = dictitemBO.doQuery(dictitemParam);
			List<DictitemVO> brands = dictitemDP.getDatas();


//			2)��ѯ��Ʒ����������Ϣ��FX_RU_WAYASSISTANT����ƥ���Ƿ�ɷ��𶩹�Ϊ�ǣ���CANORDER=1�����Բ�ѯ�����������
			Wayassistant wayassistantBO = (WayassistantBO)BOFactory.build(WayassistantBO.class,user);
			WayassistantDBParam wayassistantParam = new WayassistantDBParam();
			wayassistantParam.setQueryAll(true);
			wayassistantParam.setDataOnly(true);
			//wayassistantParam.set_ne_canorder("1");
			DataPackage wayassistantDP =  wayassistantBO.doQuery(wayassistantParam);
			if( null != wayassistantDP && null != wayassistantDP.getDatas() && 0<wayassistantDP.getDatas().size()){
				RealTimeOrder realTimeOrderBO = (RealTimeOrderBO)BOFactory.build(RealTimeOrderBO.class,user);
				List<WayassistantVO> wayassistantList = wayassistantDP.getDatas();
				
				
				for(WayassistantVO wayassistantVO:wayassistantList){
					long s = System.currentTimeMillis();
					try{
						realTimeOrderBO.doUpdateRealtimeOrder(wayassistantVO.getWayid(), brands);
					}catch(Exception e){
						LoggerUtils.error(e,log);
					}
					//System.out.println("======================="+(System.currentTimeMillis()-s));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new JOPException(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void doUpdateRealtimeOrder(String wayId,List<DictitemVO> brands) throws Exception {
		try{
//			������ѯ������FX_SW_ORDER���Ͷ�����Դ��ϸ��FX_SW_ORDERRESDET��ͳ�ƺ����̵����׿���������
			Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
			OrderresdetDAO orderresdetDAO = (OrderresdetDAO)DAOFactory.build(OrderresdetDAO.class, user);
			DBQueryParam queryParam = new DBQueryParam();
			queryParam.setQueryAll(true);
			queryParam.setDataOnly(true);
			queryParam.setSelectFieldsString("num");
			queryParam.getQueryConditions().put("WAYID", wayId);
			
//			������ѯ������FX_SW_ORDER����������Ʒ���ࣨFX_SW_ORDERRESDET������Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA��ͳ�ƺ����̵����׿���������
			//Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
			PartnerresDAO partnerresDAO = (PartnerresDAO)DAOFactory.build(PartnerresDAO.class, user);
			DBQueryParam queryParam1 = new DBQueryParam();
			queryParam1.setQueryAll(true);
			queryParam1.setDataOnly(true);
			queryParam1.getQueryConditions().put("WAYID", wayId);
			
			//log.info("=========������Ʒ�ƣ��������¶����������¿�棬��ʼ����==========");
			doNotByBrand(wayId,brands,realtimeamtBO,orderresdetDAO,queryParam,partnerresDAO,queryParam1);//
			//log.info("=========������Ʒ�ƣ��������¶����������¿�棬�������==========");
			
			//log.info("========= ����Ʒ�ƣ��������¶����������¿�棬��ʼ����==========");
			doByBrand(wayId,brands,realtimeamtBO,orderresdetDAO,queryParam,partnerresDAO,queryParam1);//
			//log.info("========= ����Ʒ�ƣ��������¶����������¿�棬�������==========");
			
			//if(isMonDayLimit){
//				a��	�������¶�����
//				���������Լ��ģʽ�������¶�����ģʽ�����������裬���������
				//this.doDayAndMonthOrder(wayassistantVO.getWayid(),brands);
			//}else {
//				b��	���¿����
//				���������Լ��ģʽΪ���¶�����ģʽ�����������裬���������
				//this.doStorage(wayassistantVO.getWayid(),brands)	;
			//}

		}catch(Exception e){
			LoggerUtils.error(e,log);
			if( null != e.getCause() && null != e.getCause().getMessage())
				throw new JOPException(e.getCause().getMessage());
			throw new JOPException(e.getMessage());
		}
	}
	
	/**
	 * ������Ʒ�ƣ��������¶����������¿��<BR>
	 * 
	 * @param wayid	�����̱���
	 * @param brands	Ʒ��
	 * @throws Exception
	 */
	private void doNotByBrand(String wayid,List<DictitemVO> brands,Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO,DBQueryParam queryParam,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam1) throws Exception {//
//		���������Ʒ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩��Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����
//		ƥ������̱����Ʒ�ƣ�ȡAllBrand�������������������µ����Ѷ�����ΪSQLͳ��ֵ�����µ����Ѷ�����Ϊ0��
//		����ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬
//		�׿�Ʒ��ȡAllBrand�������Ѷ�����ȡSQLͳ��ֵ�������Ѷ�����ȡ0������ʱ��ȡ��ǰϵͳʱ�䡣
		String count = "";
		DataPackage orderesDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_NOTBY_BRAND, queryParam);
		if( null != orderesDP && null != orderesDP.getDatas() && 0<orderesDP.getDatas().size() && orderesDP.getDatas().get(0) != null){
			count = (String)orderesDP.getDatas().get(0);
		}else{
			count = "0";
		}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
						
//			���ȣ���ѯ��������Դ��FX_SW_PARTNERRES��ͳ�ƺ�����δ�����׿�����
			queryParam1.setSelectFieldsString("num");
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_NOTBY_BRAND, queryParam1);
			long notActive = 0;
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				���������Ʒ������õ�һ��SQL����ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩����δ�����δ������ɵ��׿��������кϲ��ۼӣ�
//				Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����ƥ������̱����Ʒ�ƣ�ȡAllBrand����
//				���������������µ�ǰ�����ΪSQLͳ��ֵ������ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼
//				�������̱���ȡ�������룬�׿�Ʒ��ȡAllBrand����ǰ�����ȡ�ۼ�����������ʱ��ȡ��ǰϵͳʱ�䡣			
						
			}
			
			queryParam1.setSelectFieldsString("num");
			DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_NOTBY_BRAND, queryParam1);
			String notOrder = "0";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				notOrder = (String)numDP.getDatas().get(0);
			}
			log.info("������Ʒ�ƣ��������¶����������¿��===" +
					"��wayid��"+wayid+
					"��brand��"+BRAND_ALLBRAND+
					"�����¶�������"+count+
					"�����δ��������"+notActive+
					"��δ�����������"+notOrder);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive);// ��ǰ����� = δ����+δ������ɵ��׿�����
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive);// ��ǰ����� = δ����+δ������ɵ��׿�����
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
	}
	
	/**
	 * ����Ʒ�ƣ��������¶����������¿��<BR>
	 * 
	 * @param wayid	�����̱���
	 * @param brands	Ʒ��
	 * @throws Exception
	 */
	private void doByBrand(String wayid,List<DictitemVO> brands,Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO,DBQueryParam queryParam,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam1) throws Exception {//
//		�������Ʒ���򣬶�Ʒ�Ƽ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩��Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����
//		ƥ������̱����Ʒ�ƣ����������������µ����Ѷ�����ΪSQLͳ��ֵ�����µ����Ѷ�����Ϊ0������ʱ��ȡ��ǰϵͳʱ�䣻
//		������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬�׿�Ʒ��ȡ��ӦƷ�Ʊ��룬
//		�����Ѷ�����ȡSQLͳ��ֵ�������Ѷ�����ȡ0������ʱ��ȡ��ǰϵͳʱ�䡣
		for(DictitemVO dictiemVO:brands){
			//log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.getQueryConditions().put("BRAND", dictiemVO.getDictid());
			DataPackage numDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_BY_BRAND, queryParam);
			String count = "";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && numDP.getDatas().get(0) != null){
				count = (String)numDP.getDatas().get(0);
			}else{
				count = "0";
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(dictiemVO.getDictid());
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			
			queryParam1.setSelectFieldsString("num");
			queryParam1.getQueryConditions().put("BRAND",dictiemVO.getDictid());
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_BY_BRAND, queryParam1);
			long notActive = 0;
			String notOrder = "0";
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				�������Ʒ������õڶ���SQL��Ʒ�Ƽ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩����δ�����δ������ɵ��׿��������кϲ��ۼӣ�
//				Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����ƥ������̱����Ʒ�ƣ����������������µ�ǰ�����ΪSQLͳ��ֵ��
//				����ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬
//				�׿�Ʒ��ȡ��ӦƷ�ƣ���ǰ�����ȡ�ۼ�����������ʱ��ȡ��ǰϵͳʱ�䡣
								
			}
			queryParam1.setSelectFieldsString("num");
			numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_BY_BRAND, queryParam1);
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				notOrder = (String) numDP.getDatas().get(0);
			}
			
			log.info("����Ʒ�ƣ��������¶����������¿��+++" +
					"��wayid��"+wayid+
					"��brand��"+dictiemVO.getDictid()+
					"�����¶�������"+count+
					"�����δ��������"+notActive+
					"��δ�����������"+notOrder);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive); // ��ǰ����� = δ����+δ������ɵ��׿�����
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive); // ��ǰ����� = δ����+δ������ɵ��׿�����
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
		}
	}

	/**
	 * �������¶�����
	 * @param wayid	�����̱���
	 * @param isBbrand	�Ƿ�����Ʒ�� TRUE:Y,FALSE:N
	 * @throws Exception
	 */
	private void doDayAndMonthOrder(String wayid,List<DictitemVO> brands) throws Exception {
//			������ѯ������FX_SW_ORDER���Ͷ�����Դ��ϸ��FX_SW_ORDERRESDET��ͳ�ƺ����̵����׿���������
		Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
		OrderresdetDAO orderresdetDAO = (OrderresdetDAO)DAOFactory.build(OrderresdetDAO.class, user);
		DBQueryParam queryParam = new DBQueryParam();
		queryParam.setQueryAll(true);
		queryParam.setDataOnly(true);
		queryParam.setSelectFieldsString("num");
		queryParam.getQueryConditions().put("WAYID", wayid);
		log.info("================�������¶�����=======================");
		dayAndMonthOrderNotWithBrand(wayid,realtimeamtBO,orderresdetDAO,queryParam);
		dayAndMonthOrderWithBrand(wayid,brands,realtimeamtBO,orderresdetDAO,queryParam);
	}
	/**
	 * ���¿��
	 * @param wayid	�����̱���
	 * @param isBbrand	�Ƿ�����Ʒ�� TRUE:Y,FALSE:N
	 * @throws Exception
	 */
	private void doStorage(String wayid,List<DictitemVO> brands) throws Exception {
//		������ѯ������FX_SW_ORDER����������Ʒ���ࣨFX_SW_ORDERRESDET������Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA��ͳ�ƺ����̵����׿���������
		Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
		PartnerresDAO partnerresDAO = (PartnerresDAO)DAOFactory.build(PartnerresDAO.class, user);
		DBQueryParam queryParam = new DBQueryParam();
		queryParam.setQueryAll(true);
		queryParam.setDataOnly(true);
		queryParam.getQueryConditions().put("WAYID", wayid);
		log.info("================���¿��=======================");
		storageNotWithBrand(wayid,realtimeamtBO,partnerresDAO,queryParam);
		storageWithBrand(wayid,brands,realtimeamtBO,partnerresDAO,queryParam);
	}
	
	/**
	 * ���¶���������(������Ʒ��)
	 * @param wayid
	 * @param realtimeamtBO
	 * @param orderresdetDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void dayAndMonthOrderNotWithBrand(String wayid,Realtimeamt realtimeamtBO,OrderresdetDAO orderresdetDAO,DBQueryParam queryParam) throws Exception {
		
//		���������Ʒ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩��Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����
//		ƥ������̱����Ʒ�ƣ�ȡAllBrand�������������������µ����Ѷ�����ΪSQLͳ��ֵ�����µ����Ѷ�����Ϊ0��
//		����ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬
//		�׿�Ʒ��ȡAllBrand�������Ѷ�����ȡSQLͳ��ֵ�������Ѷ�����ȡ0������ʱ��ȡ��ǰϵͳʱ�䡣
		String count = "";
		DataPackage orderesDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_NOTBY_BRAND, queryParam);
		if( null != orderesDP && null != orderesDP.getDatas() && 0<orderesDP.getDatas().size() && orderesDP.getDatas().get(0) != null){
			count = (String)orderesDP.getDatas().get(0);
		}else{
			count = "0";
		}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
	}
	/**
	 * ���¶���������(����Ʒ��)
	 * @param wayid
	 * @param brands
	 * @param realtimeamtBO
	 * @param orderresdetDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void dayAndMonthOrderWithBrand(String wayid,
			List<DictitemVO> brands, Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO, DBQueryParam queryParam)
			throws Exception {
		
//		�������Ʒ���򣬶�Ʒ�Ƽ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩��Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����
//		ƥ������̱����Ʒ�ƣ����������������µ����Ѷ�����ΪSQLͳ��ֵ�����µ����Ѷ�����Ϊ0������ʱ��ȡ��ǰϵͳʱ�䣻
//		������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬�׿�Ʒ��ȡ��ӦƷ�Ʊ��룬
//		�����Ѷ�����ȡSQLͳ��ֵ�������Ѷ�����ȡ0������ʱ��ȡ��ǰϵͳʱ�䡣
		for(DictitemVO dictiemVO:brands){
			log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.getQueryConditions().put("BRAND", dictiemVO.getDictid());
			DataPackage numDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_BY_BRAND, queryParam);
			String count = "";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && numDP.getDatas().get(0) != null){
				count = (String)numDP.getDatas().get(0);
			}else{
				count = "0";
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(dictiemVO.getDictid());
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
		}
	}
	
	/**
	 * ���������(������Ʒ��)
	 * @param wayid
	 * @param realtimeamtBO
	 * @param partnerresDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void storageNotWithBrand(String wayid, Realtimeamt realtimeamtBO,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam)
			throws Exception {
//		���ȣ���ѯ��������Դ��FX_SW_PARTNERRES��ͳ�ƺ�����δ�����׿�����
		queryParam.setSelectFieldsString("num");
		DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_NOTBY_BRAND, queryParam);
		if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
			long notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//			���������Ʒ������õ�һ��SQL����ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩����δ�����δ������ɵ��׿��������кϲ��ۼӣ�
//			Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����ƥ������̱����Ʒ�ƣ�ȡAllBrand����
//			���������������µ�ǰ�����ΪSQLͳ��ֵ������ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼
//			�������̱���ȡ�������룬�׿�Ʒ��ȡAllBrand����ǰ�����ȡ�ۼ�����������ʱ��ȡ��ǰϵͳʱ�䡣			

			queryParam.setSelectFieldsString("num");
			DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_NOTBY_BRAND, queryParam);
			String count = "0";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				count = (String)numDP.getDatas().get(0);
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			
			if( null != realtimeamtVO){
				realtimeamtVO.setUptime(new Date());
				realtimeamtVO.setNowstock(new Long(count)+notActive);
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setNowstock(new Long(count)+notActive);
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doCreate(realtimeamtVO);
			}	
		}
	}
	
	/**
	 * ���������(����Ʒ��)
	 * @param wayid
	 * @param brands
	 * @param realtimeamtBO
	 * @param partnerresDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void storageWithBrand(String wayid,List<DictitemVO> brands, Realtimeamt realtimeamtBO,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam)
			throws Exception {
		
		for(DictitemVO dictiemVO:brands){
			log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.setSelectFieldsString("num");
			queryParam.getQueryConditions().put("BRAND",dictiemVO.getDictid());
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_BY_BRAND, queryParam);
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				long notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				�������Ʒ������õڶ���SQL��Ʒ�Ƽ�������ͳ�ƣ�ͳ�ƽ��Ϊ��ʱĬ��ͳ��ֵȡ�㣩����δ�����δ������ɵ��׿��������кϲ��ۼӣ�
//				Ȼ���ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT����ƥ������̱����Ʒ�ƣ����������������µ�ǰ�����ΪSQLͳ��ֵ��
//				����ʱ��ȡ��ǰϵͳʱ�䣻������������ݣ�����붩����ʵʱ��¼��һ����¼�������̱���ȡ�������룬
//				�׿�Ʒ��ȡ��ӦƷ�ƣ���ǰ�����ȡ�ۼ�����������ʱ��ȡ��ǰϵͳʱ�䡣

				String count = "0";
				queryParam.setSelectFieldsString("num");
				DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_BY_BRAND, queryParam);
				if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
					count = (String) numDP.getDatas().get(0);
				}
				
				RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
				if( null != realtimeamtVO){
					realtimeamtVO.setNowstock(new Long(count)+notActive); // ��ǰ����� = δ����+δ������ɵ��׿�����
					realtimeamtVO.setUptime(new Date());
					realtimeamtBO.doUpdate(realtimeamtVO);
				}else{
					realtimeamtVO = new RealtimeamtVO();
					realtimeamtVO.setBrand(dictiemVO.getDictid());
					realtimeamtVO.setWayid(wayid);
					realtimeamtVO.setNowstock(new Long(count)+notActive);
					realtimeamtVO.setUptime(new Date());
					realtimeamtBO.doCreate(realtimeamtVO);
				}	
			}
		}
	}
}
