package com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Waysynreq;
import net.gmcc.ngcrm.Waysynrsp;
import net.gmcc.ngcrm.Msgrspheader.Retinfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2log.Waysyn2log;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2log.Waysyn2logBO;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2log.Waysyn2logVO;
import com.gmcc.pboss.common.utils.Object2String;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
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
 * <p>Title: Waysyn2BO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class Waysyn2BO extends AbstractControlBean implements
		Waysyn2 {
	
	private static Log log = LogFactory.getLog(Waysyn2BO.class);

	public Waysyn2VO doCreate(Waysyn2VO vo) throws Exception {
		try {
			Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class, user);
			// TODO set the pk */
			return (Waysyn2VO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(Waysyn2VO vo) throws Exception {
		try {
			Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Waysyn2VO doUpdate(Waysyn2VO vo) throws Exception {
		try {
			Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class,user);
			return (Waysyn2VO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Waysyn2VO doFindByPk(Serializable pk) throws Exception {
		Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class,user);
		return (Waysyn2VO) dao.findByPk(pk);
	}

	public DataPackage doQuery(Waysyn2DBParam params)
			throws Exception {
		Waysyn2DAO dao = (Waysyn2DAO) DAOFactory.build(Waysyn2DAO.class,user);
		return dao.query(params);
	}
	public void doProcess(String cityid, int batch_size) throws Exception{
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
		//从兴CRM
		//Waysyn2 bo = (Waysyn2) BOFactory.build(Waysyn2BO.class, user);
		Waysyn2DBParam param=new Waysyn2DBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<Waysyn2VO> waysyn2volist=(List<Waysyn2VO>)dp.getDatas();
		if(waysyn2volist==null || waysyn2volist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "waysyn";
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
		
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		net.gmcc.ngcrm.pboss.Waysynreq.Msgbody msgbody=new net.gmcc.ngcrm.pboss.Waysynreq.Msgbody();
		net.gmcc.ngcrm.pboss.Waysynreq.Msgbody.Wayinfo wayinfo=new net.gmcc.ngcrm.pboss.Waysynreq.Msgbody.Wayinfo();
		net.gmcc.ngcrm.pboss.Waysynreq waysynreq=new net.gmcc.ngcrm.pboss.Waysynreq();
		net.gmcc.ngcrm.pboss.GDProdPort servicePort = (net.gmcc.ngcrm.pboss.GDProdPort) serPort;

		Waysyn2log logBO = (Waysyn2log) BOFactory.build(Waysyn2logBO.class,user);
		Cntycompany cntycompany = (Cntycompany) BOFactory.build(CntycompanyBO.class, user);
		for (int j = 0; j < waysyn2volist.size(); j++) {
			Waysyn2VO waysyn2VO = waysyn2volist.get(j);
		try {
			log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
					+ waysyn2VO.getWayid() + ";oprtype:"
					+ waysyn2VO.getOprtype() + "]");
			BeanUtils.copyProperties(wayinfo, waysyn2VO);

			// 时间统一YYYYMMDDhh24miss
			if (waysyn2VO.getStarttime() != null && !"".equals(waysyn2VO.getStarttime()))
				wayinfo.setStarttime(PublicUtils.formatUtilDate(waysyn2VO.getStarttime(), "yyyyMMddHHmmss"));

			if (waysyn2VO.getCreatetime() != null && !"".equals(waysyn2VO.getCreatetime()))
				wayinfo.setCreatetime(PublicUtils.formatUtilDate(waysyn2VO.getCreatetime(), "yyyyMMddHHmmss"));

			if (waysyn2VO.getDisabletime() != null && !"".equals(waysyn2VO.getDisabletime()))
				wayinfo.setDisabletime(PublicUtils.formatUtilDate(waysyn2VO.getDisabletime(), "yyyyMMddHHmmss"));

			if (waysyn2VO.getUpdatedate() != null && !"".equals(waysyn2VO.getUpdatedate()))
				wayinfo.setUpdatedate(PublicUtils.formatUtilDate(waysyn2VO.getUpdatedate(), "yyyyMMddHHmmss"));

			if (waysyn2VO.getCityid() == null || "".equals(waysyn2VO.getCityid().trim())) {
				wayinfo.setCityid(user.getCityid());
			}

			if (waysyn2VO.getCountyid() == null || "".equals(waysyn2VO.getCountyid().trim())) {
				String cityid = wayinfo.getCityid().toString();
				CntycompanyDBParam params = new CntycompanyDBParam();
				params.set_se_citycompid(cityid);
				params.set_orderby("countycompid");
				params.set_desc("0");
				params.setDataOnly(true);
				DataPackage cntycompanyDP = cntycompany.doQuery(params);
				if (cntycompanyDP.getDatas() != null && cntycompanyDP.getDatas().size() > 0) {
					CntycompanyVO cntycompanyVO = (CntycompanyVO) cntycompanyDP.getDatas().get(0);
					wayinfo.setCountyid(cntycompanyVO.getCountycompid());
				}
			}

			msgbody.setWayinfo(wayinfo);
			waysynreq.setMsgbody(msgbody);

			String reqSeq = "" + waysyn2VO.getItemid();
			msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
					processCode, perifyCode, reqTime, reqSeq, unicontact,
					testflag, routeType, routeValue, operatorid, channelid,
					unitid);
			waysynreq.setMsgreqheader(msgreqheader);

			// webservice调用
			log.info("----------------waysyn调用开始-------------------"+ waysyn2VO.getWayid());
			log.info("PBOSS_IM_006PBOSS渠道资料更新（全表字段同步），渠道ID["	+ waysyn2VO.getWayid() + "]调用从兴CRM接口请求报文信息：");
			log.info(Object2String.complexObject2Str(waysynreq));
			net.gmcc.ngcrm.pboss.Waysynrsp waysynrsp = servicePort.waysyn(waysynreq);
			log.info("PBOSS_IM_006PBOSS渠道资料更新（全表字段同步），渠道ID["	+ waysyn2VO.getWayid() + "]调用从兴CRM接口响应报文信息：");
			log.info(Object2String.complexObject2Str(waysynrsp));
			log.info("----------------waysyn调用结束-------------------");
			net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = waysynrsp.getMsgrspheader().getRetinfo();

			// 删除记录
			if (0 == retinfo.getRetcode()){
			this.doRemoveByPK(waysyn2VO.getItemid());//bo.doRemoveByPK(waysyn2VO.getItemid());
			log.info("删除CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid()
					+ ";wayid:" + waysyn2VO.getWayid() + ";oprtype:"
					+ waysyn2VO.getOprtype() + "]");
			} else {
				//NG系统校验未通过数据
				waysyn2VO.setOpract((short)-2);
				this.doUpdate(waysyn2VO);
				 log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
							+ waysyn2VO.getWayid() + ";oprtype:"
							+ waysyn2VO.getOprtype() + "NG系统校验未通过数据]");
			}
			

			// 写日志表
			Waysyn2logVO waysyn2logVO = new Waysyn2logVO();
			BeanUtils.copyProperties(waysyn2logVO, waysyn2VO);
			// synstate 0：同步成功 1：同步失败
			// 0 成功 ; 888001 参数完整性校验 ; 888002 其他错误
			if (0 == retinfo.getRetcode()) {
				waysyn2logVO.setSynstate(Short.parseShort("0"));
			} else {
				waysyn2logVO.setSynstate(Short.parseShort("1"));
			}
			waysyn2logVO.setSynmemo(retinfo.getRetmsg());
			logBO.doCreate(waysyn2logVO);
			log.info("新增CH_PW_WAYSYN2LOG[itemid:" + waysyn2logVO.getItemid()
					+ ";wayid:" + waysyn2logVO.getWayid() + ";oprtype:"
					+ waysyn2logVO.getOprtype() + "]");
		} catch (Exception e) { 
			//影响COMS后台程序退出的数据
			log.info("捕获程序异常，将oparct状态改为-1：", e);
			waysyn2VO.setOpract((short)-1);
			 this.doUpdate(waysyn2VO);
			 log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
						+ waysyn2VO.getWayid() + ";oprtype:"
						+ waysyn2VO.getOprtype() + "COMS影响程序退出数据]"+e.getMessage());
		}
		}
	}
	
	private void pro_HW(Object serPort, int batch_size) throws Exception{
		//华为CRM
		//Waysyn2 bo = (Waysyn2) BOFactory.build(Waysyn2BO.class, user);
		Waysyn2DBParam param=new Waysyn2DBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<Waysyn2VO> waysyn2volist=(List<Waysyn2VO>)dp.getDatas();
		if(waysyn2volist==null || waysyn2volist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "waysyn";
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
			
		Msgreqheader msgreqheader = new Msgreqheader();
		Waysynreq.Msgbody msgbody=new Waysynreq.Msgbody();
		Waysynreq.Msgbody.Wayinfo wayinfo=new Waysynreq.Msgbody.Wayinfo();	
		Waysynreq waysynreq=new Waysynreq();		
		GDProdPort servicePort = (GDProdPort) serPort;
		
		Waysyn2log logBO = (Waysyn2log) BOFactory.build(Waysyn2logBO.class,user);		
		Cntycompany cntycompany = (Cntycompany) BOFactory.build(CntycompanyBO.class, user);
		for (int j = 0; j < waysyn2volist.size(); j++) {
			Waysyn2VO waysyn2VO = waysyn2volist.get(j);
			try {
				log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
						+ waysyn2VO.getWayid() + ";oprtype:"
						+ waysyn2VO.getOprtype() + "]");
				BeanUtils.copyProperties(wayinfo, waysyn2VO);

				// 时间统一YYYYMMDDhh24miss
				if (waysyn2VO.getStarttime() != null && !"".equals(waysyn2VO.getStarttime()))
					wayinfo.setStarttime(PublicUtils.formatUtilDate(waysyn2VO.getStarttime(), "yyyyMMddHHmmss"));

				if (waysyn2VO.getCreatetime() != null && !"".equals(waysyn2VO.getCreatetime()))
					wayinfo.setCreatetime(PublicUtils.formatUtilDate(waysyn2VO.getCreatetime(), "yyyyMMddHHmmss"));

				if (waysyn2VO.getDisabletime() != null && !"".equals(waysyn2VO.getDisabletime()))
					wayinfo.setDisabletime(PublicUtils.formatUtilDate(waysyn2VO.getDisabletime(), "yyyyMMddHHmmss"));

				if (waysyn2VO.getUpdatedate() != null && !"".equals(waysyn2VO.getUpdatedate()))
					wayinfo.setUpdatedate(PublicUtils.formatUtilDate(waysyn2VO.getUpdatedate(), "yyyyMMddHHmmss"));

				if (waysyn2VO.getCityid() == null || "".equals(waysyn2VO.getCityid().trim())) {
					wayinfo.setCityid(user.getCityid());
				}

				if (waysyn2VO.getCountyid() == null || "".equals(waysyn2VO.getCountyid().trim())) {
					String cityid = wayinfo.getCityid().toString();
					CntycompanyDBParam params = new CntycompanyDBParam();
					params.set_se_citycompid(cityid);
					params.set_orderby("countycompid");
					params.set_desc("0");
					param.setDataOnly(true);
					DataPackage cntycompanyDP = cntycompany.doQuery(params);
					if (cntycompanyDP.getDatas() != null && cntycompanyDP.getDatas().size() > 0) {
						CntycompanyVO cntycompanyVO = (CntycompanyVO) cntycompanyDP.getDatas().get(0);
						wayinfo.setCountyid(cntycompanyVO.getCountycompid());
					}
				}

				msgbody.setWayinfo(wayinfo);
				waysynreq.setMsgbody(msgbody);

				String reqSeq = "" + waysyn2VO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader(menuid, processCode,
						perifyCode, reqTime, reqSeq, unicontact, testflag,
						routeType, routeValue, operatorid, channelid, unitid);
				waysynreq.setMsgreqheader(msgreqheader);

				// webservice调用
				log.info("----------------waysyn调用开始-------------------"	+ waysyn2VO.getWayid());
				log.info("PBOSS_IM_006PBOSS渠道资料更新（全表字段同步），渠道ID["	+ waysyn2VO.getWayid() + "]调用华为CRM接口请求报文信息：");
				log.info(Object2String.complexObject2Str(waysynreq));
				Waysynrsp waysynrsp = servicePort.waysyn(waysynreq);
				log.info("PBOSS_IM_006PBOSS渠道资料更新（全表字段同步），渠道ID["	+ waysyn2VO.getWayid() + "]调用华为CRM接口响应报文信息：");
				log.info(Object2String.complexObject2Str(waysynrsp));
				log.info("----------------waysyn调用结束-------------------");
				Retinfo retinfo = waysynrsp.getMsgrspheader().getRetinfo();

				// 删除记录
				if (0 == retinfo.getRetcode()){
				this.doRemoveByPK(waysyn2VO.getItemid());//bo.doRemoveByPK(waysyn2VO.getItemid());
				log.info("删除CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid()
						+ ";wayid:" + waysyn2VO.getWayid() + ";oprtype:"
						+ waysyn2VO.getOprtype() + "]");
				} else {
					//NG系统校验未通过数据
					waysyn2VO.setOpract((short)-2);
					this.doUpdate(waysyn2VO);
					 log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
								+ waysyn2VO.getWayid() + ";oprtype:"
								+ waysyn2VO.getOprtype() + "NG系统校验未通过数据]");
				} 
				// 写日志表
				Waysyn2logVO waysyn2logVO = new Waysyn2logVO();
				BeanUtils.copyProperties(waysyn2logVO, waysyn2VO);
				// synstate 0：同步成功 1：同步失败
				// 0 成功 ; 888001 参数完整性校验 ; 888002 其他错误
				if (0 == retinfo.getRetcode()) {
					waysyn2logVO.setSynstate(Short.parseShort("0"));
				} else {
					waysyn2logVO.setSynstate(Short.parseShort("1"));
				}
				waysyn2logVO.setSynmemo(retinfo.getRetmsg());
				logBO.doCreate(waysyn2logVO);
				log.info("新增CH_PW_WAYSYN2LOG[itemid:" + waysyn2logVO.getItemid()
						+ ";wayid:" + waysyn2logVO.getWayid() + ";oprtype:"
						+ waysyn2logVO.getOprtype() + "]");
			} catch (Exception e) {
				//影响COMS后台程序退出的数据 
				log.info("捕获程序异常，将oparct状态改为-1：", e);
				waysyn2VO.setOpract((short)-1);
				 this.doUpdate(waysyn2VO);
				 log.info("当前处理CH_PW_WAYSYN2[itemid:" + waysyn2VO.getItemid() + ";wayid:"
							+ waysyn2VO.getWayid() + ";oprtype:"
							+ waysyn2VO.getOprtype() + "COMS影响程序退出数据]"+e.getMessage());
			}
		}
	}
}
