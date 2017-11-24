
package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.gmcc.ngcrm.Cooperatorsynreq;
import net.gmcc.ngcrm.Cooperatorsynrsp;
import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Msgrspheader.Retinfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog.Cooperasynlog;
import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog.CooperasynlogBO;
import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog.CooperasynlogVO;
import com.gmcc.pboss.common.utils.Object2String;
import com.gmcc.pboss.web.common.webservice.CRMServiceUtil;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.gmcc.pboss.web.common.webservice.ICRMServiceforback;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: EmpsynBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperasynBO extends AbstractControlBean implements
	Cooperasyn {
	
	private static Log log = LogFactory.getLog(CooperasynBO.class);
	
	public CooperasynVO doCreate(CooperasynVO vo) throws Exception {
		try {
			CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class, user);
			// TODO set the pk */
			return (CooperasynVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CooperasynVO vo) throws Exception {
		try {
			CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperasynVO doUpdate(CooperasynVO vo) throws Exception {
		try {
			CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class,user);
			return (CooperasynVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CooperasynVO doFindByPk(Serializable pk) throws Exception {
		CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class,user);
		return (CooperasynVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CooperasynDBParam params)
			throws Exception {
		CooperasynDAO dao = (CooperasynDAO) DAOFactory.build(CooperasynDAO.class,user);
		return dao.query(params);
	}

	public void doProcess(String cityid, int batch_size) throws Exception {
		ICRMServiceforback service=new CRMServiceforback();
		Object serPort=service.getServicePort(cityid);
		log.info("----------------serPort-------------------"+serPort);
		if(serPort==null){
			//调原来HW的接口
		}else{//调CRM的接口
			if(GDProdPort.class.isInstance(serPort)){//华为CRM
				log.info("----------------华为CRM调用开始-------------------");
				pro_HW(serPort, batch_size);
				log.info("----------------华为CRM调用结束-------------------");
			}else{//从兴CRM
				log.info("----------------从兴CRM调用开始-------------------");
				pro_CX(serPort, batch_size);
				log.info("----------------从兴CRM调用结束-------------------");
			}			
		}	
	}
	
	private void pro_CX(Object serPort, int batch_size) throws Exception{
		net.gmcc.ngcrm.pboss.GDProdPort servicePort = (net.gmcc.ngcrm.pboss.GDProdPort)serPort;
		//Cooperasyn bo = (Cooperasyn) BOFactory.build(CooperasynBO.class, user);
		CooperasynDBParam param=new CooperasynDBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<CooperasynVO> cooperatorsynvolist=(List<CooperasynVO>)dp.getDatas();
		if(cooperatorsynvolist==null || cooperatorsynvolist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "cooperator";
		String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
		String routeType = "0";
		String routeValue = CityMappingUtil.getCityNo(user.getCityid());
		//String routeValue = "750";
		String menuid = "PBOSS";
		String perifyCode = "";
		String unicontact = "";
		String testflag = "0";
		String operatorid = "COMS-BG";
		String channelid = "bsacComs";
		String unitid = channelid;
		
		net.gmcc.ngcrm.pboss.Cooperatorsynreq cooperatorsynreq=new net.gmcc.ngcrm.pboss.Cooperatorsynreq();
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		net.gmcc.ngcrm.pboss.Cooperatorsynreq.Msgbody msgbody=new net.gmcc.ngcrm.pboss.Cooperatorsynreq.Msgbody();
		net.gmcc.ngcrm.pboss.Cooperatorsynreq.Msgbody.Estinfo estinfo=new net.gmcc.ngcrm.pboss.Cooperatorsynreq.Msgbody.Estinfo();
		
		Cooperasynlog logBO = (Cooperasynlog) BOFactory.build(CooperasynlogBO.class, user);
		for (int j = 0; j < cooperatorsynvolist.size(); j++) {
			CooperasynVO cooperatorVO = cooperatorsynvolist.get(j);
			try {
				log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
						+ cooperatorVO.getCooperauid() + ";oprtype:"
						+ cooperatorVO.getOprtype() + "]");
				BeanUtils.copyProperties(estinfo, cooperatorVO);

				// 时间统一YYYYMMDDhh24miss
				if (cooperatorVO.getIntime() != null && !"".equals(cooperatorVO.getIntime()))
					estinfo.setIntime(PublicUtils.formatUtilDate(cooperatorVO.getIntime(), "yyyyMMddHHmmss"));

				if (cooperatorVO.getLicvalidate() != null && !"".equals(cooperatorVO.getLicvalidate()))
					estinfo.setLicvalidate(PublicUtils.formatUtilDate(cooperatorVO.getLicvalidate(), "yyyyMMddHHmmss"));

				if (cooperatorVO.getStarttime() != null && !"".equals(cooperatorVO.getStarttime()))
					estinfo.setStarttime(PublicUtils.formatUtilDate(cooperatorVO.getStarttime(), "yyyyMMddHHmmss"));

				msgbody.setEstinfo(estinfo);
				cooperatorsynreq.setMsgbody(msgbody);

				String reqSeq = "" + cooperatorVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
						processCode, perifyCode, reqTime, reqSeq, unicontact,
						testflag, routeType, routeValue, operatorid, channelid,
						unitid);
				cooperatorsynreq.setMsgreqheader(msgreqheader);

				// webservice调用
				log.info("----------------cooperator调用接口-------------------"	+ cooperatorVO.getCooperauid());
				log.info("PBOSS_IM_012PBOSS合作商资料更新，合作商ID[" + cooperatorVO.getCooperauid() + "]调用从兴CRM接口请求报文信息：");
				log.info(Object2String.complexObject2Str(cooperatorsynreq));
				net.gmcc.ngcrm.pboss.Cooperatorsynrsp cooperatorsynrsp = servicePort.cooperatorsyn(cooperatorsynreq);
				log.info("PBOSS_IM_012PBOSS合作商资料更新，合作商ID[" + cooperatorVO.getCooperauid() + "]调用从兴CRM接口响应报文信息：");
				log.info(Object2String.complexObject2Str(cooperatorsynrsp));
				net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = cooperatorsynrsp.getMsgrspheader().getRetinfo();

				
				
				// 删除记录
				if (0==retinfo.getRetcode() ){
				this.doRemoveByPK(cooperatorVO.getItemid());// bo.doRemoveByPK(cooperatorsynvolist.get(j).getItemid());
				log.info("删除CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
						+ cooperatorVO.getCooperauid() + ";oprtype:"+ cooperatorVO.getOprtype() + "]");
				} else{
					//NG系统校验未通过数据
					 cooperatorVO.setOpract((short)-2);
					 this.doUpdate(cooperatorVO);
					 log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
								+ cooperatorVO.getCooperauid() + ";oprtype:"
								+ cooperatorVO.getOprtype() + "NG系统校验未通过数据]");
				}
				
				// 写日志表
				CooperasynlogVO cooperasynlogVO = new CooperasynlogVO();
				BeanUtils.copyProperties(cooperasynlogVO, cooperatorVO);
				// synstate 0：同步成功 1：同步失败
				if (0 == retinfo.getRetcode()) {
					cooperasynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					cooperasynlogVO.setSynstate(Short.parseShort("1"));
				}
				cooperasynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(cooperasynlogVO);
				log.info("新增CH_DST_COOPERASYNLOG[itemid:" + cooperasynlogVO.getItemid() + ";cooperauid:"
						+ cooperasynlogVO.getCooperauid() + ";oprtype:"
						+ cooperasynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//影响COMS后台程序退出的数据 
				log.info("捕获程序异常，将oparct状态改为-1：", e);
				 cooperatorVO.setOpract((short)-1);
				 this.doUpdate(cooperatorVO);
				 log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
							+ cooperatorVO.getCooperauid() + ";oprtype:"
							+ cooperatorVO.getOprtype() + "影响COMS后台程序退出的数据]"+e.getMessage());
			}
		}
	}
	
	private void pro_HW(Object serPort, int batch_size) throws Exception{
		GDProdPort servicePort = (GDProdPort)serPort;
		//Cooperasyn bo = (Cooperasyn) BOFactory.build(CooperasynBO.class, user);
		CooperasynDBParam param=new CooperasynDBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<CooperasynVO> cooperatorsynvolist=(List<CooperasynVO>)dp.getDatas();
		if(cooperatorsynvolist==null || cooperatorsynvolist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "cooperatorsyn";
		String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
		String routeType = "0";
		String routeValue = CityMappingUtil.getCityNo(user.getCityid());
		//String routeValue = "750";
		String menuid = "PBOSS";
		String perifyCode = "";
		String unicontact = "";
		String testflag = "0";
		String operatorid = "COMS-BG";
		String channelid = "bsacComs";
		String unitid = channelid;
		
		Cooperatorsynreq cooperatorsynreq=new Cooperatorsynreq();
		Msgreqheader msgreqheader = new Msgreqheader();
		Cooperatorsynreq.Msgbody msgbody=new Cooperatorsynreq.Msgbody();
		Cooperatorsynreq.Msgbody.Estinfo estinfo=new Cooperatorsynreq.Msgbody.Estinfo();
		
		Cooperasynlog logBO = (Cooperasynlog) BOFactory.build(CooperasynlogBO.class, user);
		for (int j = 0; j < cooperatorsynvolist.size(); j++) {
			CooperasynVO cooperasynVO = cooperatorsynvolist.get(j);
			try {
				log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
						+ cooperasynVO.getCooperauid() + ";oprtype:"
						+ cooperasynVO.getOprtype() + "]");
				BeanUtils.copyProperties(estinfo, cooperasynVO);

				// 时间统一YYYYMMDDhh24miss
				if (cooperasynVO.getIntime() != null && !"".equals(cooperasynVO.getIntime()))
					estinfo.setIntime(PublicUtils.formatUtilDate(cooperasynVO.getIntime(), "yyyyMMddHHmmss"));

				if (cooperasynVO.getLicvalidate() != null && !"".equals(cooperasynVO.getLicvalidate()))
					estinfo.setLicvalidate(PublicUtils.formatUtilDate(cooperasynVO.getLicvalidate(), "yyyyMMddHHmmss"));

				if (cooperasynVO.getStarttime() != null && !"".equals(cooperasynVO.getStarttime()))
					estinfo.setStarttime(PublicUtils.formatUtilDate(cooperasynVO.getStarttime(), "yyyyMMddHHmmss"));

				msgbody.setEstinfo(estinfo);
				cooperatorsynreq.setMsgbody(msgbody);

				String reqSeq = "" + cooperasynVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader(menuid, processCode,
						perifyCode, reqTime, reqSeq, unicontact, testflag,
						routeType, routeValue, operatorid, channelid, unitid);
				cooperatorsynreq.setMsgreqheader(msgreqheader);

				// webservice调用
				log.info("----------------cooperasyn调用接口-------------------"	+ cooperasynVO.getCooperauid());
				log.info("PBOSS_IM_012PBOSS合作商资料更新，合作商ID[" + cooperasynVO.getCooperauid() + "]调用华为CRM接口请求报文信息：");
				log.info(Object2String.complexObject2Str(cooperatorsynreq));
				Cooperatorsynrsp cooperatorsynrsp = servicePort.cooperatorsyn(cooperatorsynreq);
				log.info("PBOSS_IM_012PBOSS合作商资料更新，合作商ID[" + cooperasynVO.getCooperauid() + "]调用华为CRM接口响应报文信息：");
				log.info(Object2String.complexObject2Str(cooperatorsynrsp));
				Retinfo retinfo = cooperatorsynrsp.getMsgrspheader().getRetinfo(); 
				
				// 删除记录
				if (0==retinfo.getRetcode() ){
				this.doRemoveByPK(cooperasynVO.getItemid()); 
				log.info("删除CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
						+ cooperasynVO.getCooperauid() + ";oprtype:"+ cooperasynVO.getOprtype() + "]");
				} else{
					//NG系统校验未通过数据
					cooperasynVO.setOpract((short)-2);
					 this.doUpdate(cooperasynVO);
					 log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
								+ cooperasynVO.getCooperauid() + ";oprtype:"
								+ cooperasynVO.getOprtype() + "NG系统校验未通过数据]");
				}
				 
				// 写日志表
				CooperasynlogVO cooperasynlogVO = new CooperasynlogVO();
				BeanUtils.copyProperties(cooperasynlogVO, cooperasynVO);
				// synstate 0：同步成功 1：同步失败
				if (0 == retinfo.getRetcode()) {
					cooperasynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					cooperasynlogVO.setSynstate(Short.parseShort("1"));
				}
				cooperasynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(cooperasynlogVO);
				log.info("新增CH_DST_COOPERASYNLOG[itemid:" + cooperasynlogVO.getItemid() + ";cooperauid:"
						+ cooperasynlogVO.getCooperauid() + ";oprtype:"
						+ cooperasynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//影响COMS后台程序退出的数据
				log.info("捕获程序异常，将oparct状态改为-1：", e);
				cooperasynVO.setOpract((short)-1);
				 this.doUpdate(cooperasynVO);
				 log.info("当前处理CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
							+ cooperasynVO.getCooperauid() + ";oprtype:"
							+ cooperasynVO.getOprtype() + "影响COMS后台程序退出的数据]"+e.getMessage());
			}
		}
	}
	
}
