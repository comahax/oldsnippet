
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
			//��ԭ��HW�Ľӿ�
		}else{//��CRM�Ľӿ�
			if(GDProdPort.class.isInstance(serPort)){//��ΪCRM
				log.info("----------------��ΪCRM���ÿ�ʼ-------------------");
				this.pro_HW(serPort, batch_size);
				log.info("----------------��ΪCRM���ý���-------------------");
			}else{//����CRM
				log.info("----------------����CRM���ÿ�ʼ-------------------");
				this.pro_CX(serPort, batch_size);
				log.info("----------------����CRM���ý���-------------------");
			}			
		}	
	}
	
	private void pro_CX(Object serPort, int batch_size) throws Exception{
		//Empsyn bo = (Empsyn) BOFactory.build(EmpsynBO.class, user);
		EmpsynDBParam param=new EmpsynDBParam();
		param.set_pagesize(""+batch_size);//һ�δ���100����¼
		param.set_ne_opract("0");
		param.set_orderby("itemid");//��Ҫ����itemid����ͬ��
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<EmpsynVO> empsynvolist=(List<EmpsynVO>)dp.getDatas();
		if(empsynvolist==null || empsynvolist.size()==0){
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
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
				log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "]");
				BeanUtils.copyProperties(empinfo, empsynVO);

				// ʱ��ͳһYYYYMMDDhh24miss
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

				// webservice����
				log.info("----------------empsyn���ýӿ�-------------------"+ empsynVO.getEmployeeid());
				log.info("PBOSS_IM_005��Ա���ϸ��£���ԱID[" + empsynVO.getEmployeeid() + "]���ô���CRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(empsynreq));
				net.gmcc.ngcrm.pboss.Empsynrsp empsynrsp = servicePort.empsyn(empsynreq);
				log.info("PBOSS_IM_005��Ա���ϸ��£���ԱID[" + empsynVO.getEmployeeid() + "]���ô���CRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(empsynrsp));
				net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = empsynrsp.getMsgrspheader().getRetinfo();

				if (0 == retinfo.getRetcode()) {//ͬ���ɹ�
					// ɾ����¼
//					this.doRemoveByPK(empsynVO.getItemid());//bo.doRemoveByPK(empsynvolist.get(j).getItemid());
//					log.info("ɾ��CH_PW_EMPSYN[itemid:" + empsynVO.getItemid()
//							+ ";employeeid:" + empsynVO.getEmployeeid() + ";oprtype:"
//							+ empsynVO.getOprtype() + "]");
//					
					empsynVO.setOpract((short)10);
					this.doUpdate(empsynVO); 
					log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"�ɹ����޸�Opract״̬Ϊ��10 ]");
					
				}else{
					//NGϵͳУ��δͨ������
					empsynVO.setOpract((short)-2);
					this.doUpdate(empsynVO); 
					log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid() + ";oprtype:"
							+ empsynVO.getOprtype() + "��NGϵͳδͨ����֤����]");
					 
				}
				
				
				// д��־��
				EmpsynlogVO empsynlogVO = new EmpsynlogVO();
				BeanUtils.copyProperties(empsynlogVO, empsynVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				if (0 == retinfo.getRetcode()) {
					empsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					empsynlogVO.setSynstate(Short.parseShort("1"));
				}
				empsynlogVO.setSynmemo(retinfo.getRetmsg());
				logBO.doCreate(empsynlogVO);
				log.info("����CH_PW_EMPSYNLOG[itemid:" + empsynlogVO.getItemid()
						+ ";employeeid:" + empsynlogVO.getEmployeeid() + ";oprtype:"
						+ empsynlogVO.getOprtype() + "]");
			
			}catch(Exception e){
				//opract 0 -> -1 COMSӰ������˳����� 
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				empsynVO.setOpract((short)-1);
				this.doUpdate(empsynVO);
				log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "COMSӰ������˳�����]"+e.getMessage()); 
				
			}
		}
	}
	
	private void pro_HW(Object serPort, int batch_size) throws Exception{
		//Empsyn bo = (Empsyn) BOFactory.build(EmpsynBO.class, user);
		EmpsynDBParam param=new EmpsynDBParam();
		param.set_pagesize(""+batch_size);//һ�δ���100����¼
		param.set_ne_opract("0");
		param.set_orderby("itemid");//��Ҫ����itemid����ͬ��
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<EmpsynVO> empsynvolist=(List<EmpsynVO>)dp.getDatas();
		if(empsynvolist==null || empsynvolist.size()==0){
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
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
				log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "]");
				BeanUtils.copyProperties(empinfo, empsynVO);

				// ʱ��ͳһYYYYMMDDhh24miss
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

				// webservice����
				log.info("----------------empsyn���ÿ�ʼ-------------------"+ empsynVO.getEmployeeid());
				log.info("PBOSS_IM_005��Ա���ϸ��£���ԱID[" + empsynVO.getEmployeeid() + "]���û�ΪCRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(empsynreq));
				Empsynrsp empsynrsp = servicePort.empsyn(empsynreq);
				log.info("PBOSS_IM_005��Ա���ϸ��£���ԱID[" + empsynVO.getEmployeeid() + "]���û�ΪCRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(empsynrsp));
				log.info("----------------empsyn���ý���-------------------");
				Retinfo retinfo = empsynrsp.getMsgrspheader().getRetinfo();

				if (0 == retinfo.getRetcode()) {//ͬ���ɹ�
					// ɾ����¼
					//this.doRemoveByPK(empsynVO.getItemid()); 
//					log.info("ɾ��CH_PW_EMPSYN[itemid:" + empsynVO.getItemid()
//							+ ";employeeid:" + empsynVO.getEmployeeid() + ";oprtype:"
//							+ empsynVO.getOprtype() + "]");
					empsynVO.setOpract((short)10);
					this.doUpdate(empsynVO); 
					log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"�ɹ����޸�Opract״̬Ϊ��10 ]");
				}else{
					//NGϵͳУ��δͨ������
					empsynVO.setOpract((short)-2);
					this.doUpdate(empsynVO); 
					log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
							+ empsynVO.getEmployeeid()   + ";oprtype:"
							+ empsynVO.getOprtype() +"��NGϵͳδͨ����֤����]");
				}   
				// д��־��
				EmpsynlogVO empsynlogVO = new EmpsynlogVO();
				BeanUtils.copyProperties(empsynlogVO, empsynVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				if (0 == retinfo.getRetcode()) {
					empsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					empsynlogVO.setSynstate(Short.parseShort("1"));
				}
				empsynlogVO.setSynmemo(retinfo.getRetmsg());
				logBO.doCreate(empsynlogVO);
				log.info("����CH_PW_EMPSYNLOG[itemid:" + empsynlogVO.getItemid()
						+ ";employeeid:" + empsynlogVO.getEmployeeid() + ";oprtype:"
						+ empsynlogVO.getOprtype() + "]");
				//�޸�opract=-1��רԱ���ݣ�isnet=2����subname��employeename Ϊ�ֻ����룬ͬʱ�޸�opract=0����ͬ�����ٴη���ͬ����
				 log.info("�޸�רԱΪ-1��������");
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
				   log.info("�޸ĳɹ� Ŷ����");
				}
				
			} catch (Exception e) {
				//opract 0 -> -1 COMSӰ������˳�����  
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				empsynVO.setOpract((short)-1);
				this.doUpdate(empsynVO);
				log.info("��ǰ����CH_PW_EMPSYN[itemid:" + empsynVO.getItemid() + ";employeeid:"
						+ empsynVO.getEmployeeid() + ";oprtype:"
						+ empsynVO.getOprtype() + "COMSӰ������˳�����]"+e.getMessage());
			}
		}
	}
}
