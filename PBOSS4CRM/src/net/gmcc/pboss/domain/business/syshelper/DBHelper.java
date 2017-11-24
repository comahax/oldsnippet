package net.gmcc.pboss.domain.business.syshelper;

import java.util.List;

import org.apache.log4j.Logger;

import net.gmcc.pboss.common.dao.IBaseDao;
//import com.gmcc.hsc.webservice.domain.model.common.NegwnodeVO;
//import com.gmcc.hsc.webservice.domain.model.subproductsyn.AbmnodeVO;

public class DBHelper {

	private Logger log = Logger.getLogger(DBHelper.class);
	
	protected IBaseDao dao;
	
	protected String transId;
	
	public DBHelper(IBaseDao dao,String transId){
		this.dao = dao ;
		this.transId = transId;
	}
	
//	/**
//	 * 融合计费用户判断
//	 * 
//	 * 先查找散号路由表《NEGW号码业务路由策略表(HSC_NORES_NEGWNODE)》，如找到则表示是融合计费用户，
//	 * 未找到则继续查找号 段路由表《NEGW号段业务路由策略表(HSC_NOSECT_ABMNODE)》,如找到则表示是融合计费用户
//	 * 
//	 * @param msisdn
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean isABMUser(String msisdn) throws Exception{
//		if(getNegwnodeVOByMsisdn(msisdn) != null){//散号表 HSC_NORES_NEGWNODE
//			return true;
//		}
//		if(getAbmNodeIDByMsisdn(msisdn) != null){//号段表 HSC_NOSECT_ABMNODE
//			return true;
//		}
//		return false;
//	}
//	
//	
//	/**
//	 * 根据号码到散号表查找该号码信息(HSC_NORES_NEGWNODE)
//	 * @param msisdn
//	 * @param dao
//	 * @return
//	 * @throws Exception 
//	 */
//	protected NegwnodeVO getNegwnodeVOByMsisdn(String msisdn) throws Exception{
//		NegwnodeVO negwnodeVO = null;
//		Object[] values = new Object[1];
//		values[0] = new Object();
//		values[0] = msisdn;
//		
//		try{
//			String hql = "from NegwnodeVO where mobileno = ?";
//			List<?> negwnodeVOList = dao.find(hql,values);
//			if(negwnodeVOList != null && negwnodeVOList.size() > 0){
//				negwnodeVO = (NegwnodeVO)negwnodeVOList.get(0);
//		    }
//			if(negwnodeVO == null){
//				log.info(transId+"号码：" + msisdn + " 在号码业务路由表尚未配置.");
//			}else{
//			    log.info(transId+"号码：" + msisdn + " 在号码业务路由表有配置信息.");
//			}
//		}catch(Exception e){
//			throw new Exception(transId+"获取号码：" + msisdn + " 在号码业务路由表信息出错."+e.getMessage());
//		}
//		return negwnodeVO;
//	}
//	
//	/**
//	 * 根据号码查找该号码对应的ABM节点标识(HSC_NOSECT_ABMNODE)
//	 * @param msisdn
//	 * @param dao
//	 * @return
//	 * @throws Exception 
//	 */
//	protected String getAbmNodeIDByMsisdn(String msisdn) throws Exception{
//		//根据号码查找NOSECT_ABMNODE表，找到则取配置表里面的节点信息
//		//select NODEID from HSC_NOSECT_ABMNODE where mobileno between BEGINNO and ENDNO
//		String abmnodeid = null;
//		Object[] values = new Object[1];
//		values[0] = new Object();
//		values[0] = msisdn;
//		try{
//			String hql = "from AbmnodeVO where ? between beginno and endno";
//			List<?> abmnodevoList = dao.find(hql,values);
////			Srting hql = "from AbmnodeVO where '" + msisdn +"' between beginno and endno";//两种方式find
////			List abmnodevoList = dao.find(hql,null);
//			if(abmnodevoList != null && abmnodevoList.size() > 0){
//				AbmnodeVO abmnodeVO = (AbmnodeVO)abmnodevoList.get(0);
//				abmnodeid = abmnodeVO.getNodeid().toString();
//		    }
//			if(abmnodeid == null || "".equals(abmnodeid)){
//				log.info(transId+"号码：" + msisdn + "所属号段的ABM节点信息尚未配置");
//			}else{
//			    log.info(transId+"号码：" + msisdn + "所属号段的ABM节点为:" + abmnodeid);
//			}
//		}catch(Exception e){
//			throw new Exception(transId+"获取号码：" + msisdn + "所属号段的ABM节点信息出错."+e.getMessage());
//		}
//		return abmnodeid;
//	}
}
