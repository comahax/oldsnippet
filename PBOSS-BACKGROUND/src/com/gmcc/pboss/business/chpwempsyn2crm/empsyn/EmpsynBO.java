
package com.gmcc.pboss.business.chpwempsyn2crm.empsyn;

import java.io.Serializable;
import java.util.Date;
import java.util.List; 
import net.gmcc.ngcrm.Empsynreq;
import net.gmcc.ngcrm.Empsynrsp;
import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Msgrspheader.Retinfo; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.Empsynlog;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogBO;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogVO;
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
public class EmpsynBO extends AbstractControlBean implements
		Empsyn {
	
	private static Log log = LogFactory.getLog(EmpsynBO.class);
	
	public EmpsynVO doCreate(EmpsynVO vo) throws Exception {
		try {
			EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class, user);
			// TODO set the pk */
			return (EmpsynVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmpsynVO vo) throws Exception {
		try {
			EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpsynVO doUpdate(EmpsynVO vo) throws Exception {
		try {
			EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class,user);
			return (EmpsynVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpsynVO doFindByPk(Serializable pk) throws Exception {
		EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class,user);
		return (EmpsynVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmpsynDBParam params)
			throws Exception {
		EmpsynDAO dao = (EmpsynDAO) DAOFactory.build(EmpsynDAO.class,user);
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
				this.pro_HW(serPort, batch_size);
				log.info("----------------华为CRM调用结束-------------------");
			}else{//从兴CRM
				log.info("----------------从兴CRM调用开始-------------------");
				this.pro_CX(serPort, batch_size);
				log.info("----------------从兴CRM调用结束-------------------");
			}			
		}	
	}
	
	private void pro_CX(Object serPort, int batch_size) throws Exception{
		//Empsyn bo = (Empsyn) BOFactory.build(EmpsynBO.class, user);
		EmpsynDBParam param=new EmpsynDBParam();
		param.set_pagesize(""+batch_size);//一次处理100条记录
		param.set_ne_opract("0");
		param.set_orderby("itemid");//需要按照itemid升序同步
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<EmpsynVO> empsynvolist=(List<EmpsynVO>)dp.getDatas();
		if(empsynvolist==null || empsynvolist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "empsyn";
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
		
		net.gmcc.ngcrm.pboss.Empsynreq empsynreq=new net.gmcc.ngcrm.pboss.Empsynreq();
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		net.gmcc.ngcrm.pboss.Empsynreq.Msgbody msgbody=new net.gmcc.ngcrm.pboss.Empsynreq.Msgbody();
		net.gmcc.ngcrm.pboss.Empsynreq.Msgbody.Empinfo empinfo=new net.gmcc.ngcrm.pboss.Empsynreq.Msgbody.Empinfo();
		net.gmcc.ngcrm.pboss.GDProdPort servicePort = (net.gmcc.ngcrm.pboss.GDProdPort) serPort;

		Empsynlog logBO = (Empsynlog) BOFactory.build(EmpsynlogBO.class,user);
		for (int j = 0; j < empsynvolist.size(); j++) {
			EmpsynVO empsynVO = empsynvolist.get(j);
			try{				
				log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "]");
				BeanUtils.copyProperties(empinfo, empsynVO);

				// 时间统一YYYYMMDDhh24miss
				if (empsynVO.getBirthday() != null && !"".equals(empsynVO.getBirthday()))
					empinfo.setBirthday(PublicUtils.formatUtilDate(empsynVO.getBirthday(), "yyyyMMddHHmmss"));

				if (empsynVO.getIntime() != null && !"".equals(empsynVO.getIntime()))
					empinfo.setIntime(PublicUtils.formatUtilDate(empsynVO.getIntime(), "yyyyMMddHHmmss"));

				if (empsynVO.getOuttime() != null && !"".equals(empsynVO.getOuttime()))
					empinfo.setOuttime(PublicUtils.formatUtilDate(empsynVO.getOuttime(), "yyyyMMddHHmmss"));

				if (empsynVO.getGradtime() != null && !"".equals(empsynVO.getGradtime()))
					empinfo.setGradtime(PublicUtils.formatUtilDate(empsynVO.getGradtime(), "yyyyMMddHHmmss"));

				if (empsynVO.getRegdate() != null && !"".equals(empsynVO.getRegdate()))
					empinfo.setRegdate(PublicUtils.formatUtilDate(empsynVO.getRegdate(), "yyyyMMddHHmmss")); 
				msgbody.setEmpinfo(empinfo);
				empsynreq.setMsgbody(msgbody);

				String reqSeq = "" + empsynVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
						processCode, perifyCode, reqTime, reqSeq, unicontact,
						testflag, routeType, routeValue, operatorid, channelid,
						unitid);
				empsynreq.setMsgreqheader(msgreqheader);

				// webservice调用
				log.info("----------------empsyn调用接口-------------------"+ empsynVO.getEmployeeid());
				log.info("PBOSS_IM_005人员资料更新，人员ID[" + empsynVO.getEmployeeid() + "]调用从兴CRM接口请求报文信息：");
				log.info(Object2String.complexObject2Str(empsynreq));
				net.gmcc.ngcrm.pboss.Empsynrsp empsynrsp = servicePort.empsyn(empsynreq);
				log.info("PBOSS_IM_005人员资料更新，人员ID[" + empsynVO.getEmployeeid() + "]调用从兴CRM接口响应报文信息：");
				log.info(Object2String.complexObject2Str(empsynrsp));
				net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = empsynrsp.getMsgrspheader().getRetinfo();

				if (0 == retinfo.getRetcode()) {//同步成功
					// 删除记录
//					this.doRemoveByPK(empsynVO.getItemid());//bo.doRemoveByPK(empsynvolist.get(j).getItemid());
//					log.info("删除CH_PW_EMPSYN[itemid:" + empsynVO.getItemid()
//							+ ";employeeid:" + empsynVO.getEmployeeid() + ";oprtype:"
//							+ empsynVO.getOprtype() + "]");
//					
					empsynVO.setOpract((short)10);
					this.doUpdate(empsynVO); 
					log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"成功，修改Opract状态为：10 ]");
					
				}else{
					//NG系统校验未通过数据
					empsynVO.setOpract((short)-2);
					this.doUpdate(empsynVO); 
					log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid() + ";oprtype:"
							+ empsynVO.getOprtype() + "在NG系统未通过验证数据]");
					 
				}
				
				
				// 写日志表
				EmpsynlogVO empsynlogVO = new EmpsynlogVO();
				BeanUtils.copyProperties(empsynlogVO, empsynVO);
				// synstate 0：同步成功 1：同步失败
				if (0 == retinfo.getRetcode()) {
					empsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					empsynlogVO.setSynstate(Short.parseShort("1"));
				}
				empsynlogVO.setSynmemo(retinfo.getRetmsg());
				logBO.doCreate(empsynlogVO);
				log.info("新增CH_PW_EMPSYNLOG[itemid:" + empsynlogVO.getItemid()
						+ ";employeeid:" + empsynlogVO.getEmployeeid() + ";oprtype:"
						+ empsynlogVO.getOprtype() + "]");
			
			}catch(Exception e){
				//opract 0 -> -1 COMS影响程序退出数据 
				log.info("捕获程序异常，将oparct状态改为-1：", e);
				empsynVO.setOpract((short)-1);
				this.doUpdate(empsynVO);
				log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "COMS影响程序退出数据]"+e.getMessage()); 
				
			}
		}
	}
	
	private void pro_HW(Object serPort, int batch_size) throws Exception{
		//Empsyn bo = (Empsyn) BOFactory.build(EmpsynBO.class, user);
		EmpsynDBParam param=new EmpsynDBParam();
		param.set_pagesize(""+batch_size);//一次处理100条记录
		param.set_ne_opract("0");
		param.set_orderby("itemid");//需要按照itemid升序同步
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<EmpsynVO> empsynvolist=(List<EmpsynVO>)dp.getDatas();
		if(empsynvolist==null || empsynvolist.size()==0){
			log.info("没有数据需要同步");
			return;
		}
		
		//消息头信息
		String processCode = "empsyn";
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
		
		Empsynreq empsynreq=new Empsynreq();
		Msgreqheader msgreqheader = new Msgreqheader();
		Empsynreq.Msgbody msgbody=new Empsynreq.Msgbody();
		Empsynreq.Msgbody.Empinfo empinfo=new Empsynreq.Msgbody.Empinfo();
		GDProdPort servicePort = (GDProdPort) serPort;

		Empsynlog logBO = (Empsynlog) BOFactory.build(EmpsynlogBO.class,user);
		for (int j = 0; j < empsynvolist.size(); j++) {
			EmpsynVO empsynVO = empsynvolist.get(j);
			try {
				log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "]");
				BeanUtils.copyProperties(empinfo, empsynVO);

				// 时间统一YYYYMMDDhh24miss
				if (empsynVO.getBirthday() != null 	&& !"".equals(empsynVO.getBirthday()))
					empinfo.setBirthday(PublicUtils.formatUtilDate(empsynVO.getBirthday(), "yyyyMMddHHmmss"));

				if (empsynVO.getIntime() != null && !"".equals(empsynVO.getIntime()))
					empinfo.setIntime(PublicUtils.formatUtilDate(empsynVO.getIntime(), "yyyyMMddHHmmss"));

				if (empsynVO.getOuttime() != null && !"".equals(empsynVO.getOuttime()))
					empinfo.setOuttime(PublicUtils.formatUtilDate(empsynVO.getOuttime(), "yyyyMMddHHmmss"));

				if (empsynVO.getGradtime() != null && !"".equals(empsynVO.getGradtime()))
					empinfo.setGradtime(PublicUtils.formatUtilDate(empsynVO.getGradtime(), "yyyyMMddHHmmss"));

				if (empsynVO.getRegdate() != null && !"".equals(empsynVO.getRegdate()))
					empinfo.setRegdate(PublicUtils.formatUtilDate(empsynVO.getRegdate(), "yyyyMMddHHmmss"));

				msgbody.setEmpinfo(empinfo);
				empsynreq.setMsgbody(msgbody);

				String reqSeq = "" + empsynVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader(menuid, processCode,
						perifyCode, reqTime, reqSeq, unicontact, testflag,
						routeType, routeValue, operatorid, channelid, unitid);
				empsynreq.setMsgreqheader(msgreqheader);

				// webservice调用
				log.info("----------------empsyn调用开始-------------------"+ empsynVO.getEmployeeid());
				log.info("PBOSS_IM_005人员资料更新，人员ID[" + empsynVO.getEmployeeid() + "]调用华为CRM接口请求报文信息：");
				log.info(Object2String.complexObject2Str(empsynreq));
				Empsynrsp empsynrsp = servicePort.empsyn(empsynreq);
				log.info("PBOSS_IM_005人员资料更新，人员ID[" + empsynVO.getEmployeeid() + "]调用华为CRM接口响应报文信息：");
				log.info(Object2String.complexObject2Str(empsynrsp));
				log.info("----------------empsyn调用结束-------------------");
				Retinfo retinfo = empsynrsp.getMsgrspheader().getRetinfo();

				if (0 == retinfo.getRetcode()) {//同步成功
					// 删除记录
					//this.doRemoveByPK(empsynVO.getItemid()); 
//					log.info("删除CH_PW_EMPSYN[itemid:" + empsynVO.getItemid()
//							+ ";employeeid:" + empsynVO.getEmployeeid() + ";oprtype:"
//							+ empsynVO.getOprtype() + "]");
					empsynVO.setOpract((short)10);
					this.doUpdate(empsynVO); 
					log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"成功，修改Opract状态为：10 ]");
				}else{
					//NG系统校验未通过数据
					empsynVO.setOpract((short)-2);
					this.doUpdate(empsynVO); 
					log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"在NG系统未通过验证数据]");
				}   
				// 写日志表
				EmpsynlogVO empsynlogVO = new EmpsynlogVO();
				BeanUtils.copyProperties(empsynlogVO, empsynVO);
				// synstate 0：同步成功 1：同步失败
				if (0 == retinfo.getRetcode()) {
					empsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					empsynlogVO.setSynstate(Short.parseShort("1"));
				}
				empsynlogVO.setSynmemo(retinfo.getRetmsg());
				logBO.doCreate(empsynlogVO);
				log.info("新增CH_PW_EMPSYNLOG[itemid:" + empsynlogVO.getItemid()
						+ ";employeeid:" + empsynlogVO.getEmployeeid() + ";oprtype:"
						+ empsynlogVO.getOprtype() + "]");
				//修改opract=-1的专员数据（isnet=2）的subname、employeename 为手机号码，同时修改opract=0（待同步）再次发起同步。
				 log.info("修改专员为-1的数据啦");
				EmpsynDBParam paramrs=new EmpsynDBParam();
				paramrs.set_ne_opract("-1");
				paramrs.set_ne_isnet("2");
				DataPackage employeevodp=this.doQuery(paramrs);
				List<EmpsynVO>  list=(List<EmpsynVO>)employeevodp.getDatas();
				for (int w = 0; w < list.size(); w++) {
				   EmpsynVO	vo = list.get(w);
				   vo.setOpract(Short.parseShort("0"));	
				   if (null != vo.getTelephone() && !("").equals(vo.getTelephone())){
				      vo.setSubname(vo.getTelephone());
				      vo.setEmployeename(vo.getTelephone());
				   }else{
					  vo.setSubname("");
					  vo.setEmployeename("");
				   }
				   this.doUpdate(vo);
				   log.info("修改成功 哦啦啦");
				}
				
			} catch (Exception e) {
				//opract 0 -> -1 COMS影响程序退出数据  
				log.info("捕获程序异常，将oparct状态改为-1：", e);
				empsynVO.setOpract((short)-1);
				this.doUpdate(empsynVO);
				log.info("当前处理CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "COMS影响程序退出数据]"+e.getMessage());
			}
		}
	}
}
