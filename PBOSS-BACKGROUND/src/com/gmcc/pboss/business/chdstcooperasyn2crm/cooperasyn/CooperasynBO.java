
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
			//��ԭ��HW�Ľӿ�
		}else{//��CRM�Ľӿ�
			if(GDProdPort.class.isInstance(serPort)){//��ΪCRM
				log.info("----------------��ΪCRM���ÿ�ʼ-------------------");
				pro_HW(serPort, batch_size);
				log.info("----------------��ΪCRM���ý���-------------------");
			}else{//����CRM
				log.info("----------------����CRM���ÿ�ʼ-------------------");
				pro_CX(serPort, batch_size);
				log.info("----------------����CRM���ý���-------------------");
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
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
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
				log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
						+ cooperatorVO.getCooperauid() + ";oprtype:"
						+ cooperatorVO.getOprtype() + "]");
				BeanUtils.copyProperties(estinfo, cooperatorVO);

				// ʱ��ͳһYYYYMMDDhh24miss
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

				// webservice����
				log.info("----------------cooperator���ýӿ�-------------------"	+ cooperatorVO.getCooperauid());
				log.info("PBOSS_IM_012PBOSS���������ϸ��£�������ID[" + cooperatorVO.getCooperauid() + "]���ô���CRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(cooperatorsynreq));
				net.gmcc.ngcrm.pboss.Cooperatorsynrsp cooperatorsynrsp = servicePort.cooperatorsyn(cooperatorsynreq);
				log.info("PBOSS_IM_012PBOSS���������ϸ��£�������ID[" + cooperatorVO.getCooperauid() + "]���ô���CRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(cooperatorsynrsp));
				net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = cooperatorsynrsp.getMsgrspheader().getRetinfo();

				
				
				// ɾ����¼
				if (0==retinfo.getRetcode() ){
				this.doRemoveByPK(cooperatorVO.getItemid());// bo.doRemoveByPK(cooperatorsynvolist.get(j).getItemid());
				log.info("ɾ��CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
						+ cooperatorVO.getCooperauid() + ";oprtype:"+ cooperatorVO.getOprtype() + "]");
				} else{
					//NGϵͳУ��δͨ������
					 cooperatorVO.setOpract((short)-2);
					 this.doUpdate(cooperatorVO);
					 log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
								+ cooperatorVO.getCooperauid() + ";oprtype:"
								+ cooperatorVO.getOprtype() + "NGϵͳУ��δͨ������]");
				}
				
				// д��־��
				CooperasynlogVO cooperasynlogVO = new CooperasynlogVO();
				BeanUtils.copyProperties(cooperasynlogVO, cooperatorVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				if (0 == retinfo.getRetcode()) {
					cooperasynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					cooperasynlogVO.setSynstate(Short.parseShort("1"));
				}
				cooperasynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(cooperasynlogVO);
				log.info("����CH_DST_COOPERASYNLOG[itemid:" + cooperasynlogVO.getItemid() + ";cooperauid:"
						+ cooperasynlogVO.getCooperauid() + ";oprtype:"
						+ cooperasynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//Ӱ��COMS��̨�����˳������� 
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				 cooperatorVO.setOpract((short)-1);
				 this.doUpdate(cooperatorVO);
				 log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperatorVO.getItemid() + ";cooperauid:"
							+ cooperatorVO.getCooperauid() + ";oprtype:"
							+ cooperatorVO.getOprtype() + "Ӱ��COMS��̨�����˳�������]"+e.getMessage());
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
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
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
				log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
						+ cooperasynVO.getCooperauid() + ";oprtype:"
						+ cooperasynVO.getOprtype() + "]");
				BeanUtils.copyProperties(estinfo, cooperasynVO);

				// ʱ��ͳһYYYYMMDDhh24miss
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

				// webservice����
				log.info("----------------cooperasyn���ýӿ�-------------------"	+ cooperasynVO.getCooperauid());
				log.info("PBOSS_IM_012PBOSS���������ϸ��£�������ID[" + cooperasynVO.getCooperauid() + "]���û�ΪCRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(cooperatorsynreq));
				Cooperatorsynrsp cooperatorsynrsp = servicePort.cooperatorsyn(cooperatorsynreq);
				log.info("PBOSS_IM_012PBOSS���������ϸ��£�������ID[" + cooperasynVO.getCooperauid() + "]���û�ΪCRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(cooperatorsynrsp));
				Retinfo retinfo = cooperatorsynrsp.getMsgrspheader().getRetinfo(); 
				
				// ɾ����¼
				if (0==retinfo.getRetcode() ){
				this.doRemoveByPK(cooperasynVO.getItemid()); 
				log.info("ɾ��CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
						+ cooperasynVO.getCooperauid() + ";oprtype:"+ cooperasynVO.getOprtype() + "]");
				} else{
					//NGϵͳУ��δͨ������
					cooperasynVO.setOpract((short)-2);
					 this.doUpdate(cooperasynVO);
					 log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
								+ cooperasynVO.getCooperauid() + ";oprtype:"
								+ cooperasynVO.getOprtype() + "NGϵͳУ��δͨ������]");
				}
				 
				// д��־��
				CooperasynlogVO cooperasynlogVO = new CooperasynlogVO();
				BeanUtils.copyProperties(cooperasynlogVO, cooperasynVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				if (0 == retinfo.getRetcode()) {
					cooperasynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					cooperasynlogVO.setSynstate(Short.parseShort("1"));
				}
				cooperasynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(cooperasynlogVO);
				log.info("����CH_DST_COOPERASYNLOG[itemid:" + cooperasynlogVO.getItemid() + ";cooperauid:"
						+ cooperasynlogVO.getCooperauid() + ";oprtype:"
						+ cooperasynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//Ӱ��COMS��̨�����˳�������
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				cooperasynVO.setOpract((short)-1);
				 this.doUpdate(cooperasynVO);
				 log.info("��ǰ����CH_DST_COOPERASYN[itemid:" + cooperasynVO.getItemid() + ";cooperauid:"
							+ cooperasynVO.getCooperauid() + ";oprtype:"
							+ cooperasynVO.getOprtype() + "Ӱ��COMS��̨�����˳�������]"+e.getMessage());
			}
		}
	}
	
}
