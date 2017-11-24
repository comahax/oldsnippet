/**
 * auto-generated code
 * Tue Sep 13 15:06:31 CST 2011
 */
package com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsyn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Resparamsynreq;
import net.gmcc.ngcrm.Resparamsynrsp;
import net.gmcc.ngcrm.Msgrspheader.Retinfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog.Rlparamsynlog;
import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog.RlparamsynlogBO;
import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog.RlparamsynlogVO;
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
 * <p>Title: RlparamsynBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RlparamsynBO extends AbstractControlBean implements
		Rlparamsyn {
	
	private static Log log = LogFactory.getLog(RlparamsynBO.class);

	public RlparamsynVO doCreate(RlparamsynVO vo) throws Exception {
		try {
			RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class, "DB_COMMON");//user
			return (RlparamsynVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RlparamsynVO vo) throws Exception {
		try {
			RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class,"DB_COMMON");//user
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class,"DB_COMMON");//user
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RlparamsynVO doUpdate(RlparamsynVO vo) throws Exception {
		try {
			RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class,"DB_COMMON");//user
			return (RlparamsynVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RlparamsynVO doFindByPk(Serializable pk) throws Exception {
		RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class,"DB_COMMON");//user
		return (RlparamsynVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RlparamsynDBParam params)
			throws Exception {
		RlparamsynDAO dao = (RlparamsynDAO) DAOFactory.build(RlparamsynDAO.class,"DB_COMMON");//user
		return dao.query(params);
	}

	public void doProcess(String cityid, int batch_size) throws Exception {
		ICRMServiceforback service=new CRMServiceforback();
		Object serPort=service.getServicePort(cityid);
		log.info("----------------serPort-------------------"+serPort);
		if(serPort!=null){
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
		//Rlparamsyn bo=(Rlparamsyn)BOFactory.build(RlparamsynBO.class,user);
		RlparamsynDBParam param=new RlparamsynDBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_se_cityid(user.getCityid());
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<RlparamsynVO> rlparamsynvolist=(List<RlparamsynVO>)dp.getDatas();
		if(rlparamsynvolist==null || rlparamsynvolist.size()==0){
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
		String processCode = "resparamsyn";
		String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
		String routeType = "0";
		String routeValue = CityMappingUtil.getCityNo(user.getCityid());
		String menuid = "PBOSS";
		String perifyCode = "";
		String unicontact = "";
		String testflag = "0";
		String operatorid = "COMS-BG";
		String channelid = "bsacComs";
		String unitid = channelid;
				
		net.gmcc.ngcrm.pboss.Resparamsynreq resparamsynreq=new net.gmcc.ngcrm.pboss.Resparamsynreq();
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody msgBody=new net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody();
		net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist paramlist=new net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist();
		List<net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist.Paraminfo> paramlistinfo=new ArrayList<net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist.Paraminfo>();
		
		Rlparamsynlog logBO = (Rlparamsynlog) BOFactory.build(RlparamsynlogBO.class, user);
		for (int k = 0; k < rlparamsynvolist.size(); k++) {
			paramlistinfo = new ArrayList<net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist.Paraminfo>();			
			RlparamsynVO rlparamsynVO = rlparamsynvolist.get(k);	
			try {
				log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
						+ rlparamsynVO.getRestype() + ";oprtype:"
						+ rlparamsynVO.getOprtype() + "]");
				net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist.Paraminfo paraminfo = new net.gmcc.ngcrm.pboss.Resparamsynreq.Msgbody.Paramlist.Paraminfo();
				BeanUtils.copyProperties(paraminfo, rlparamsynVO);
				paramlistinfo.add(paraminfo);
				paramlist.getParaminfo().addAll(paramlistinfo);
				msgBody.setParamlist(paramlist);
				resparamsynreq.setMsgbody(msgBody);

				String reqSeq = "" + rlparamsynVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
						processCode, perifyCode, reqTime, reqSeq, unicontact,
						testflag, routeType, routeValue, operatorid, channelid,
						unitid);
				resparamsynreq.setMsgreqheader(msgreqheader);

				// webservice����
				log.info("----------------resparamsyn���ýӿ�-------------------"+ rlparamsynVO.getItemid());
				log.info("PBOSS_IM_004��Դ������ͬ���ӿڣ�Itemid["	+ rlparamsynVO.getItemid() + "]���ô���CRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(resparamsynreq));
				net.gmcc.ngcrm.pboss.Resparamsynrsp resparamsynrsp = servicePort.resparamsyn(resparamsynreq);
				log.info("PBOSS_IM_004��Դ������ͬ���ӿڣ�Itemid["	+ rlparamsynVO.getItemid() + "]���ô���CRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(resparamsynrsp));
				net.gmcc.ngcrm.pboss.Msgrspheader.Retinfo retinfo = resparamsynrsp.getMsgrspheader().getRetinfo();

				// ɾ����¼
				if ( 0 == retinfo.getRetcode()){ 
				this.doRemoveByPK(rlparamsynVO.getItemid());// bo.doRemoveByPK(rlparamsynVO.getItemid());
				log.info("ɾ��im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
						+ rlparamsynVO.getRestype() + ";oprtype:"
						+ rlparamsynVO.getOprtype() + "]");
				}else{
					rlparamsynVO.setOpract((short)-2);
					this.doUpdate(rlparamsynVO);
					log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
							+ rlparamsynVO.getRestype() + ";oprtype:"
							+ rlparamsynVO.getOprtype() + "NGϵͳУ��δͨ������]");
				}
				// д��־��
				RlparamsynlogVO rlparamsynlogVO = new RlparamsynlogVO();
				BeanUtils.copyProperties(rlparamsynlogVO, rlparamsynVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				// 0 �ɹ� ; 888001 ����������У�� ; 888002 ��������
				if (0 == retinfo.getRetcode()) {
					rlparamsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					rlparamsynlogVO.setSynstate(Short.parseShort("1"));
				}
				rlparamsynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(rlparamsynlogVO);
				log.info("����im_pr_rlparamsynlog[itemid:" + rlparamsynlogVO.getItemid() + ";restype:"
						+ rlparamsynlogVO.getRestype() + ";oprtype:"
						+ rlparamsynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//Ӱ��COMS��̨�����˳�������
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				 rlparamsynVO.setOpract((short)-1);
				 this.doUpdate(rlparamsynVO);
				 log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
							+ rlparamsynVO.getRestype() + ";oprtype:"
							+ rlparamsynVO.getOprtype() + "Ӱ��COMS��̨�����˳�������]"+e.getMessage());
			}
		}
	}
	
	private void pro_HW(Object serPort, int batch_size) throws Exception{
		GDProdPort servicePort = (GDProdPort)serPort;
		//Rlparamsyn bo=(Rlparamsyn)BOFactory.build(RlparamsynBO.class,user);
		RlparamsynDBParam param=new RlparamsynDBParam();
		param.set_pagesize(""+batch_size);
		param.set_ne_opract("0");
		param.set_se_cityid(user.getCityid());
		param.set_orderby("itemid");
		param.set_desc("0");//param.setAscending(true);
		param.setDataOnly(true);
		DataPackage dp=this.doQuery(param);//bo.doQuery(param);
		List<RlparamsynVO> rlparamsynvolist=(List<RlparamsynVO>)dp.getDatas();
		if(rlparamsynvolist==null || rlparamsynvolist.size()==0){
			log.info("û��������Ҫͬ��");
			return;
		}
		
		//��Ϣͷ��Ϣ
		String processCode = "resparamsyn";
		String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
		String routeType = "0";
		String routeValue = CityMappingUtil.getCityNo(user.getCityid());
		String menuid = "PBOSS";
		String perifyCode = "";
		String unicontact = "";
		String testflag = "0";
		String operatorid = "COMS-BG";
		String channelid = "bsacComs";
		String unitid = channelid;
		
		Resparamsynreq resparamsynreq=new Resparamsynreq();
		Msgreqheader msgreqheader = new Msgreqheader();
		Resparamsynreq.Msgbody msgBody=new Resparamsynreq.Msgbody();
		Resparamsynreq.Msgbody.Paramlist paramlist=new Resparamsynreq.Msgbody.Paramlist();
		List<Resparamsynreq.Msgbody.Paramlist.Paraminfo> paramlistinfo=new ArrayList<Resparamsynreq.Msgbody.Paramlist.Paraminfo>();
		
		Rlparamsynlog logBO = (Rlparamsynlog) BOFactory.build(RlparamsynlogBO.class, user);
		for (int k = 0; k < rlparamsynvolist.size(); k++) {
			paramlistinfo = new ArrayList<Resparamsynreq.Msgbody.Paramlist.Paraminfo>();
			RlparamsynVO rlparamsynVO = rlparamsynvolist.get(k);
			try {
				log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
						+ rlparamsynVO.getRestype() + ";oprtype:"
						+ rlparamsynVO.getOprtype() + "]");
				
				Resparamsynreq.Msgbody.Paramlist.Paraminfo paraminfo = new Resparamsynreq.Msgbody.Paramlist.Paraminfo();
				BeanUtils.copyProperties(paraminfo, rlparamsynVO);
				paramlistinfo.add(paraminfo);
				paramlist.getParaminfo().addAll(paramlistinfo);
				msgBody.setParamlist(paramlist);
				resparamsynreq.setMsgbody(msgBody);

				String reqSeq = "" + rlparamsynVO.getItemid();
				msgreqheader = CRMServiceUtil.getMsgreqheader(menuid, processCode,
						perifyCode, reqTime, reqSeq, unicontact, testflag,
						routeType, routeValue, operatorid, channelid, unitid);
				resparamsynreq.setMsgreqheader(msgreqheader);

				// webservice����
				log.info("----------------resparamsyn���ýӿ�-------------------"+ rlparamsynVO.getItemid());
				log.info("PBOSS_IM_004��Դ������ͬ���ӿڣ�Itemid["	+ rlparamsynVO.getItemid() + "]���û�ΪCRM�ӿ���������Ϣ��");
				log.info(Object2String.complexObject2Str(resparamsynreq));
				Resparamsynrsp resparamsynrsp = servicePort.resparamsyn(resparamsynreq);
				log.info("PBOSS_IM_004��Դ������ͬ���ӿڣ�Itemid["	+ rlparamsynVO.getItemid() + "]���û�ΪCRM�ӿ���Ӧ������Ϣ��");
				log.info(Object2String.complexObject2Str(resparamsynrsp));
				Retinfo retinfo = resparamsynrsp.getMsgrspheader().getRetinfo();

				// ɾ����¼
				if ( 0 == retinfo.getRetcode()){ 
				this.doRemoveByPK(rlparamsynVO.getItemid());// bo.doRemoveByPK(rlparamsynVO.getItemid());
				log.info("ɾ��im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
						+ rlparamsynVO.getRestype() + ";oprtype:"
						+ rlparamsynVO.getOprtype() + "]");
				}else{
					rlparamsynVO.setOpract((short)-2);
					this.doUpdate(rlparamsynVO);
					log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
							+ rlparamsynVO.getRestype() + ";oprtype:"
							+ rlparamsynVO.getOprtype() + "NGϵͳУ��δͨ������]");
				}
				// д��־��
				RlparamsynlogVO rlparamsynlogVO = new RlparamsynlogVO();
				BeanUtils.copyProperties(rlparamsynlogVO, rlparamsynVO);
				// synstate 0��ͬ���ɹ� 1��ͬ��ʧ��
				// 0 �ɹ� ; 888001 ����������У�� ; 888002 ��������
				if (0 == retinfo.getRetcode()) {
					rlparamsynlogVO.setSynstate(Short.parseShort("0"));
				} else {
					rlparamsynlogVO.setSynstate(Short.parseShort("1"));
				}
				rlparamsynlogVO.setSynmemo(retinfo.getRetmsg());

				logBO.doCreate(rlparamsynlogVO);
				log.info("����im_pr_rlparamsynlog[itemid:" + rlparamsynlogVO.getItemid() + ";restype:"
						+ rlparamsynlogVO.getRestype() + ";oprtype:"
						+ rlparamsynlogVO.getOprtype() + "]");
			} catch (Exception e) {
				//Ӱ��COMS��̨�����˳������� 
				log.info("��������쳣����oparct״̬��Ϊ-1��", e);
				 rlparamsynVO.setOpract((short)-1);
				 this.doUpdate(rlparamsynVO);
				 log.info("��ǰ����im_pr_rlparamsyn[itemid:" + rlparamsynVO.getItemid() + ";restype:"
							+ rlparamsynVO.getRestype() + ";oprtype:"
							+ rlparamsynVO.getOprtype() + "Ӱ��COMS��̨�����˳�������]"+e.getMessage());
			}
		}
	}
}
