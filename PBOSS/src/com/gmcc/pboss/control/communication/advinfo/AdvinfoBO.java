/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.advinfo;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDBParam;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoDAO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVOHelper;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDAO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDBParam;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.business.communication.reply.ReplyVO;
import com.gmcc.pboss.common.utils.tools.FileUtil;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.communication.advaffix.Advaffix;
import com.gmcc.pboss.control.communication.advaffix.AdvaffixBO;
import com.gmcc.pboss.control.communication.advapproval.Advapproval;
import com.gmcc.pboss.control.communication.advapproval.AdvapprovalBO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.control.communication.reply.Reply;
import com.gmcc.pboss.control.communication.reply.ReplyBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: AdvinfoBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/communication/advinfo/control/AdvinfoBO"
 *           name="Advinfo" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AdvinfoBO extends AbstractControlBean implements Advinfo {
	private static Log log = LogFactory
			.getLog("com.gmcc.pboss.control.communication.advinfo.AdvinfoBO");

	public AdvinfoVO doCreate(AdvinfoVO vo) throws Exception {
		try {
			AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class,
					user);
			// TODO set the pk */
			return (AdvinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdvinfoVO vo) throws Exception {
		try {
			AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvinfoVO doUpdate(AdvinfoVO vo) throws Exception {
		try {
			AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class,
					user);
			return (AdvinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvinfoVO doFindByPk(Serializable pk) throws Exception {
		AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class, user);
		return (AdvinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdvinfoDBParam params) throws Exception {
		AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class, user);
		return dao.query(params);
	}

	public DataPackage doQAOnlineQuery(AdvinfoDBParam params) throws Exception {
		AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class, user);
		return dao.doQAOnlineQuery(params);
	}

	public AdvinfoVO doKrSave(AdvinfoVOHelper avHelper, File[] docs,
			String[] docFileNames, String delAffixs, boolean createFlag)
			throws Exception {
		AdvinfoVO aiVo = null;
		try {
			Advaffix afBo = (AdvaffixBO) BOFactory
					.build(AdvaffixBO.class, user);
			if (createFlag) {
				aiVo = new AdvinfoVO();
				avHelper.setType(new Short("4"));
				avHelper.setNdapproval(new Short("0"));
				avHelper.setSmsnotify(new Short("0"));
				avHelper.setEnddate(new SimpleDateFormat("yyyy-MM-dd")
						.parse("2099-12-31"));
				BeanUtils.copyProperties(aiVo, avHelper);
				aiVo = this.doCreate(aiVo);
			} else {
				aiVo = this.doFindByPk(avHelper.getAdvinfoid());
				BeanUtils.copyProperties(aiVo, avHelper);
				this.doUpdate(aiVo);

				if (delAffixs != null && delAffixs.length() > 0) {
					String[] affixsArr = delAffixs.split(";");
					List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>();
					for (String affixInfo : affixsArr) {
						String[] affix = affixInfo.split(",");
						AdvaffixVO advaffixVO = new AdvaffixVO();
						advaffixVO.setAffixid(Long.valueOf(affix[0]));
						advaffixVO.setAffixpath(affix[1]);
						affixsList.add(advaffixVO);
					}
					afBo.doRemoveAffixs(affixsList);
				}
			}
			// �������ϴ����ļ������� ���� ������Ϣ���뵽 ���渽����Ϣ��(CH_PW_ADVAFFIX)
			afBo.doUploadAffixs(aiVo.getAdvinfoid(), docs, docFileNames);
			return aiVo;
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	public void doRemoveKrByAdvinfoid(Long advinfoid) throws Exception {
		try {
			// ��ɾ��֪ʶ���¼
			this.doRemoveByPK(advinfoid);
			// ������ɾ����֪ʶ���µĸ���(�������ĸ�����¼�ͷ������ϵĸ����ļ�)
			Advaffix afBo = (AdvaffixBO) BOFactory
					.build(AdvaffixBO.class, user);
			AdvaffixDBParam afParam = new AdvaffixDBParam();
			afParam.set_ne_advinfoid(advinfoid.toString());
			afParam.set_pagesize("0");
			afParam.setDataOnly(true);
			List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>(afBo
					.doQuery(afParam).getDatas());

			// ɾ���������еĸ�����Ϣ��ɾ���ļ��������еĸ���
			afBo.doRemoveAffixs(affixsList);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvinfoVO doAdvSave(AdvinfoVOHelper avHelper, File[] docs,
			String[] docFileNames, File logoFile, String logoFileName,
			String delAffixs) throws Exception {
		AdvinfoVO aiVo = new AdvinfoVO();
		
		try {
			Session session = SessionUtils.currentSession(user.getCityid());
			
			BeanUtils.copyProperties(aiVo, avHelper);
			String desttype = String.valueOf(avHelper.getDesttype());
			
			aiVo.setOprcode(user.getOprcode());
			if (logoFileName != null && !"".equals(logoFileName)) {
				String logoPath = FileUtil.genFileName(logoFileName);
				aiVo.setImglogopath(logoPath);
			}
			
			//�Ƿ�������ʶ
			Boolean createFlag = false;
			if (aiVo.getAdvinfoid() == null) {
				createFlag = true;
			}
			
			//�༭ʱ�����ն������͸ı��ʶ
			Boolean destChangeFlag = true;
			
			//���湫��
			if (createFlag) {
				aiVo = this.doCreate(aiVo);
			} else {
				AdvinfoVO aiVoOld = new AdvinfoVO();
				aiVoOld = doFindByPk(aiVo.getAdvinfoid());
				
				String desttypeOld = String.valueOf(aiVoOld.getDesttype());
				if(null!=desttype && null!=desttypeOld && desttype.equals(desttypeOld))
				{
					destChangeFlag = false;
				}
				
				//��aiVoOld�����Ҫ�������Ϣ
				BeanUtils.copyProperties(aiVoOld, aiVo);
				
				this.doUpdate(aiVoOld);
			}

			//�����õ����������漰�����ն���sqlִ��˳����Ҫ���߼�ִ��
			session.flush();
			
			//2��������ն�����Ϣ
			Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
			if(null==desttype){
				throw new Exception("���ն������Ͳ����ڣ�����!");
			}
			String objinfo = avHelper.getObjinfo();
			rcvobj.doSaveRcvobj(aiVo.getAdvinfoid(), desttype, objinfo, createFlag, destChangeFlag);
			
			/*
			// ������Ŵ�������Ϣ,ע�����Ŵ�������Ϣֻ���벻ɾ��
			Short smsnotify = avHelper.getSmsnotify();
			if (null != smsnotify && String.valueOf(smsnotify).equals("1")
					&& String.valueOf(avHelper.getNdapproval()).equals("0")) {
				Smstmpl Smstmpl = (Smstmpl) BOFactory.build(SmstmplBO.class,
						user);
				Map<String, String> map = new HashMap<String, String>();
				map.put("TITLE", aiVo.getTitle());
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);
				// String content = "�𾴵Ŀͻ�������1���µĴ����봦��" + aiVo.getTitle();

				Waitreq waitreq = (Waitreq) BOFactory.build(WaitreqBO.class,
						user);
				Short mobileType = Waitreq.SMS_GOTO;
				waitreq.doSaveWaitreq(mobileType, content, desttype, objidList);
			}
			*/
			
			// �������ϴ����ļ������� ���� ������Ϣ���뵽 ���渽����Ϣ��(CH_PW_ADVAFFIX)
			Advaffix advaffix = (AdvaffixBO) BOFactory.build(AdvaffixBO.class, user);
			
			if (delAffixs != null && delAffixs.length() > 0) {
				String[] affixsArr = delAffixs.split(";");
				List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>();
				for (String affixInfo : affixsArr) {
					String[] affix = affixInfo.split(",");
					AdvaffixVO advaffixVO = new AdvaffixVO();
					advaffixVO.setAffixid(Long.valueOf(affix[0]));
					advaffixVO.setAffixpath(affix[1]);
					affixsList.add(advaffixVO);
				}
				advaffix.doRemoveAffixs(affixsList);
			}
			
			advaffix.doUploadAffixs(aiVo.getAdvinfoid(), docs, docFileNames,
					logoFile, logoFileName, aiVo.getImglogopath());
			return aiVo;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public String doGetObjinfo(Long advinfoid, String desttype)
			throws Exception {
		Rcvobj rcvobj = (Rcvobj) BOFactory.build(RcvobjBO.class, user);
		RcvobjDBParam param = new RcvobjDBParam();
		param.set_ne_advinfoid(String.valueOf(advinfoid));
		param.set_pagesize("0");
		DataPackage dp = rcvobj.doQuery(param);

		List<RcvobjVO> rcvobjList = dp.getDatas();
		String objinfo = "";
		String oid = "";
		String oname = new String();
		if (rcvobjList.size() > 0) {
			// ���ս��ն�������Ϊ�ض�Ⱥ������ڲ����ţ�objinfo����Ҫֻ�ǵ���objid�����������չ��Ҳ֧��objinfo�ɡ�,��ƴ��objid
			if (desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)
					|| desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE)) {
				if (rcvobjList.size() > 1) {
					for (int i = 0; i < rcvobjList.size(); i++) {
						objinfo = objinfo
								+ String.valueOf(rcvobjList.get(i).getObjid())
								+ ",";
					}
				} else {
					objinfo = rcvobjList.get(0).getObjid();
				}
			}
			// ���ս��ն�������Ϊ�ض�����
			else {
				for (int i = 0; i < rcvobjList.size(); i++) {
					Employee employee = (Employee) BOFactory.build(
							EmployeeBO.class, user);
					EmployeeDBParam paramEmp = new EmployeeDBParam();
					oid = ((RcvobjVO) rcvobjList.get(i)).getObjid();
					paramEmp.set_se_employeeid(oid);
					DataPackage dpEmp = employee.doQuery(paramEmp);
					if (null != dpEmp && dpEmp.getDatas().size() > 0) {
						oname = ((EmployeeVO) dpEmp.getDatas().get(0))
								.getEmployeename();
						objinfo = objinfo + String.valueOf(oid) + " " + oname
								+ ",";
					}
				}
			}

		}
		return objinfo;
	}

	/**
	 * ����������Ϣ
	 */
	public void doApprovalSave(AdvinfoVOHelper avHelper) throws Exception {
		Advapproval advapprovalBo = (Advapproval) BOFactory.build(
				AdvapprovalBO.class, user);
		AdvapprovalVO advapprovalVO = new AdvapprovalVO();
		advapprovalVO.setAdvinfoid(avHelper.getAdvinfoid());
		advapprovalVO.setOprcode(user.getOprcode());
		advapprovalVO.setContent(avHelper.getAppContent());
		advapprovalVO.setState(avHelper.getAppState());
		advapprovalBo.doCreate(advapprovalVO);
		AdvinfoVO advinfoVO = this.doFindByPk(avHelper.getAdvinfoid());
		if (avHelper.getAppState() == 1) {
			/*
			// ���Ͷ���
			if (advinfoVO.getSmsnotify() == 1) {
				String desttype = String.valueOf(advinfoVO.getDesttype());

				// ��ȡ������Ա�б�
				List<String> objidList = new ArrayList<String>();
				Rcvobj rcvobj = (Rcvobj) BOFactory.build(RcvobjBO.class, user);
				RcvobjDBParam param = new RcvobjDBParam();
				param
						.set_ne_advinfoid(String.valueOf(advinfoVO
								.getAdvinfoid()));
				DataPackage dp = rcvobj.doQuery(param);
				if (dp.getRowCount() > 0) {
					List<RcvobjVO> rcvobjList = dp.getDatas();
					for (int i = 0; i < rcvobjList.size(); i++) {
						objidList.add(rcvobjList.get(i).getObjid());
					}
				}

				// ���Ͷ���
				Smstmpl Smstmpl = (Smstmpl) BOFactory.build(SmstmplBO.class,
						user);
				Map<String, String> map = new HashMap<String, String>();
				map.put("TITLE", advinfoVO.getTitle());
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);

				Waitreq waitreq = (Waitreq) BOFactory.build(WaitreqBO.class,
						user);
				Short mobileType = Waitreq.SMS_GOTO;
				waitreq.doSaveWaitreq(mobileType, content, desttype, objidList);
			}
			*/
			advinfoVO.setState(Short.valueOf("1"));
		} else
			advinfoVO.setState(Short.valueOf("5"));
		this.doUpdate(advinfoVO);

	}

	public DataPackage doPendTaskQuery(AdvinfoDBParam params, String oprcode)
			throws Exception {
		AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class, user);
		return dao.doPendTaskQuery(params, oprcode);
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doRemoveAdvByIds(String[] ids) throws Exception {
		try {
			Reply reBo = (ReplyBO) BOFactory.build(ReplyBO.class, user);
			ReplyDBParam reParams = new ReplyDBParam();
			List<ReplyVO> replyInfoList = null;

			Advaffix afBo = (AdvaffixBO) BOFactory
					.build(AdvaffixBO.class, user);
			AdvaffixDBParam afParams = new AdvaffixDBParam();
			List<AdvaffixVO> advaffixList = null;

			Advapproval advapprovalBo = (Advapproval) BOFactory.build(
					AdvapprovalBO.class, user);
			AdvapprovalDBParam appParams = new AdvapprovalDBParam();
			List<AdvapprovalVO> advapprovalList = null;

			Rcvobj rcvobj = (Rcvobj) BOFactory.build(RcvobjBO.class, user);
			RcvobjDBParam param = new RcvobjDBParam();
			param.set_pagesize("0");
			DataPackage dp = new DataPackage();
			List<RcvobjVO> rcvobjList = new ArrayList<RcvobjVO>();
			Long oid = -1L;

			Advaffix advaffix = (Advaffix) BOFactory.build(AdvaffixBO.class,
					user);
			AdvaffixDBParam param2 = new AdvaffixDBParam();
			param2.set_pagesize("0");
			List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>();
			for (String id : ids) {
				// ɾ���ظ���Ϣ
				reParams.set_ne_advinfoid(id);
				reParams.setQueryAll(true);
				replyInfoList = reBo.doQuery(reParams).getDatas();
				for (ReplyVO replyInfo : replyInfoList) {
					reBo.doRemoveByVO(replyInfo);
				}

				// ɾ�����ն���
				param.set_ne_advinfoid(id);
				dp = rcvobj.doQuery(param);
				rcvobjList = dp.getDatas();
				if (rcvobjList.size() > 0) {
					for (int j = 0; j < rcvobjList.size(); j++) {
						oid = rcvobjList.get(j).getRvcobjid();
						rcvobj.doRemoveByPK(oid);
					}
				}

				// �����б�
				param2.set_ne_advinfoid(id);
				List<AdvaffixVO> affixsTempList = advaffix.doQuery(param2)
						.getDatas();
				if (affixsTempList != null) {
					affixsList.addAll(affixsTempList);
				}

				// ɾ�������Ϣ
				appParams.set_ne_advinfoid(id);
				advapprovalList = advapprovalBo.doQuery(appParams).getDatas();
				for (AdvapprovalVO advapprovalVO : advapprovalList) {
					advapprovalBo.doRemoveByVO(advapprovalVO);
				}
				// ɾ��������Ϣ
				this.doRemoveByPK(Long.valueOf(id));
			}

			// ɾ������
			advaffix.doRemoveAffixs(affixsList);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvinfoVO doFinishadvinfo(Long pk_applyno,Long seqid,boolean isWay) throws Exception {
		AdvinfoVO resultVO=null;
		try {
			String lkCondition=null;
			if(isWay){
			 lkCondition = "/channel/wayapply_edit.do%param._pk="
					+ pk_applyno+"&form.seqid="+seqid;
			}else
			{
				lkCondition = "/channel/employeeapply_edit.do%param._pk="
					+ pk_applyno+"&form.seqid="+seqid;
			}
			AdvinfoDBParam param = new AdvinfoDBParam();
			param.set_sk_url(lkCondition);
			param.set_ne_type("5");
			AdvinfoDAO dao = (AdvinfoDAO) DAOFactory.build(AdvinfoDAO.class,
					user);
			DataPackage dp = dao.query(param);
			if (dp.getRowCount() > 0) {
				Iterator it = dp.getDatas().iterator();
				if (it.hasNext()) {
					AdvinfoVO advinfoVO = (AdvinfoVO) it.next();
					//�رմ��죬�޸�״̬Ϊ2
					doFixobj(advinfoVO);
					if(log.isInfoEnabled())
					{
						log.info("������Ϣ�Ѿ�����");
					}
				}
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new JOPException(e);
		}
		return resultVO;
	}

	public void doFixobj(AdvinfoVO vo) throws Exception {
		RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class, user);
		if (vo != null && vo.getAdvinfoid() != null) {
			RcvobjDBParam param = new RcvobjDBParam();
			param.set_ne_state("1");
			param.set_ne_advinfoid(String.valueOf(vo.getAdvinfoid()));
			param.set_se_objid(user.getOprcode());
			DataPackage dp = dao.query(param);
			if (dp != null && dp.getRowCount()>0 ) {
				Iterator it = dp.getDatas().iterator();
				if (it.hasNext()) {
					RcvobjVO advinfoVO = (RcvobjVO) it.next();
					advinfoVO.setState(new Short("2"));
					advinfoVO.setObjid(vo.getOprcode());
					advinfoVO.setStatetime(new java.util.Date());
					dao.update(advinfoVO);
					if(log.isInfoEnabled())
					{
						log.info("����״̬�Ѿ��ǹر�״̬");
					}
				}
			} 
		}

	}
}
