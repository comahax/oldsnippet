/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.questionnaire;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixDBParam;
import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireConstant;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireDAO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireDBParam;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVOHelper;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDBParam;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.communication.advaffix.Advaffix;
import com.gmcc.pboss.control.communication.advaffix.AdvaffixBO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoConstant;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.control.communication.reply.Reply;
import com.gmcc.pboss.control.communication.reply.ReplyBO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: QuestionnaireBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/questionnaire/control/QuestionnaireBO"
*    name="Questionnaire"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class QuestionnaireBO extends AbstractControlBean implements Questionnaire {
	public QuestionnaireVO doCreate(QuestionnaireVO vo) throws Exception {
		try {
			QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class, user);
			// TODO set the pk */
			return (QuestionnaireVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(QuestionnaireVO vo) throws Exception {
		try {
			QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public QuestionnaireVO doUpdate(QuestionnaireVO vo) throws Exception {
		try {
			QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class,user);
			return (QuestionnaireVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public QuestionnaireVO doFindByPk(Serializable pk) throws Exception {
		QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class,user);
		return (QuestionnaireVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(QuestionnaireDBParam params)
			throws Exception {
		QuestionnaireDAO dao = (QuestionnaireDAO) DAOFactory.build(QuestionnaireDAO.class,user);
		return dao.query(params);
	}
	
	public String doGetObjinfo(Long advinfoid, String desttype)throws Exception{
		Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
		RcvobjDBParam param = new RcvobjDBParam();
		param.set_pagesize("0");
		param.set_ne_advinfoid(String.valueOf(advinfoid));
		DataPackage dp = rcvobj.doQuery(param);
		
		
		List<RcvobjVO> rcvobjList = dp.getDatas();
		String objinfo = "";
		String oid = "";
		String oname = new String();
		if(rcvobjList.size()>0)
		{
			//���ս��ն�������Ϊ�ض�Ⱥ������ڲ����ţ�objinfo����Ҫֻ�ǵ���objid�����������չ��Ҳ֧��objinfo�ɡ�,��ƴ��objid
			if(desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)||desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE))
			{
				if(rcvobjList.size()>1)
				{
					for(int i=0; i<rcvobjList.size(); i++)
					{
						objinfo = objinfo + String.valueOf(rcvobjList.get(i).getObjid()) + ",";
					}
				}
				else
				{
					objinfo = rcvobjList.get(0).getObjid();
				}
			}
			//���ս��ն�������Ϊ�ض�����
			else
			{
				for(int i=0; i<rcvobjList.size(); i++)
				{
					Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
					EmployeeDBParam paramEmp = new EmployeeDBParam();
					oid = ((RcvobjVO)rcvobjList.get(i)).getObjid();
					paramEmp.set_se_employeeid(oid);
					DataPackage dpEmp = employee.doQuery(paramEmp);
					if(null!=dpEmp && dpEmp.getDatas().size()>0)
					{
						oname = ((EmployeeVO)dpEmp.getDatas().get(0)).getEmployeename();
						objinfo = objinfo + String.valueOf(oid) + " " + oname + ",";
					}
				}
			}

		}
		return objinfo;
	}
	
	//ͨ��advinfoid��ѯ��Ӧ�����б�
	public List<AdvaffixVO> doGetAdvaffixByAdvinfoid(Long advinfoid)throws Exception
	{
		Advaffix advaffix = (Advaffix)BOFactory.build(AdvaffixBO.class,user);
		AdvaffixDBParam param = new AdvaffixDBParam();
		param.set_pagesize("0");
		param.set_ne_advinfoid(String.valueOf(advinfoid));
		List<AdvaffixVO> advaffixList = advaffix.doQuery(param).getDatas();
		return advaffixList;
	}
	
	//ͨ��advinfoid��ѯ��Ӧ�ظ��б�
	public DataPackage doGetReplyByAdvinfoid(Long advinfoid)throws Exception{
		Reply reply = (Reply)BOFactory.build(ReplyBO.class,user);
		ReplyDBParam param = new ReplyDBParam();
		param.set_ne_advinfoid(String.valueOf(advinfoid));
		DataPackage dp = reply.doQuery(param);
		return dp;
	}
	
	public Long doQueSave(QuestionnaireVOHelper helper, File[] docs, String[] docFileNames, Boolean createFlag) throws Exception {
		QuestionnaireVO questionnaireVO = new QuestionnaireVO();
		try {
			Session session = SessionUtils.currentSession(user.getCityid());
			BeanUtils.copyProperties(questionnaireVO, helper);
			
			//1�����������Ϣ
			String desttype = String.valueOf(questionnaireVO.getDesttype());
			questionnaireVO.setNdapproval(QuestionnaireConstant.NDAPPROVAL_NO);
			questionnaireVO.setType(QuestionnaireConstant.TYPE_QUESTIONNAIRE);
			questionnaireVO.setState(QuestionnaireConstant.STATE_PUBLISHED);
			questionnaireVO.setOprcode(user.getOprcode());
			
			//�༭ʱ�����ն������͸ı��ʶ
			Boolean destChangeFlag = true;
			
			if(createFlag)
			{
				questionnaireVO = doCreate(questionnaireVO);
			}
			else
			{
				QuestionnaireVO questionnaireVOOld = new QuestionnaireVO();
				questionnaireVOOld = doFindByPk(questionnaireVO.getAdvinfoid());
				
				String desttypeOld = String.valueOf(questionnaireVOOld.getDesttype());
				if(null!=desttype && null!=desttypeOld && desttype.equals(desttypeOld))
				{
					destChangeFlag = false;
				}
				
				//��questionnaireVOOld�����Ҫ�������Ϣ
				BeanUtils.copyProperties(questionnaireVOOld, questionnaireVO);
				questionnaireVO = doUpdate(questionnaireVOOld);
			}
			
			//�����õ����������漰�����ն���sqlִ��˳����Ҫ���߼�ִ��
			session.flush();
			
			//2��������ն�����Ϣ
			Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
			if(null==desttype){
				throw new Exception("���ն������Ͳ����ڣ�����!");
			}
			String objinfo = helper.getObjinfo();
			//������ն���
			rcvobj.doSaveRcvobj(questionnaireVO.getAdvinfoid(), desttype, objinfo, createFlag, destChangeFlag);
			
			/*
			//3��������Ŵ�������Ϣ,ע�����Ŵ�������Ϣֻ���벻ɾ��
			Short smsnotify = helper.getSmsnotify();
			if(null!=smsnotify && String.valueOf(smsnotify).equals("1"))
			{
				Smstmpl Smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class,user);
				Map<String,String> map = new HashMap<String,String>();
				map.put("TITLE", questionnaireVO.getTitle());
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);
				//String content = "�𾴵Ŀͻ�������1���µĴ����봦��" + questionnaireVO.getTitle();
				
				Waitreq waitreq = (Waitreq)BOFactory.build(WaitreqBO.class,user);
				Short mobileType = Waitreq.SMS_GOTO;
				waitreq.doSaveWaitreq(mobileType,content,desttype,objidList);
			}
			*/
			
			//4�����渽����Ϣ��ע������Ҫ��󱣴棬��Ϊ�����ϴ���������һ���ǿ���������ָ��Ŀ¼�����������ݿ⣬����󲻻�ع�
			Advaffix advaffix = (Advaffix)BOFactory.build(AdvaffixBO.class, user);
			if(!createFlag)
			{
				//ɾ������
				String delAffixs = helper.getDelAffixs();
				if(delAffixs != null && delAffixs.length() > 0) {
					String[] affixsArr = delAffixs.split(";");
					List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>();
					for(String affixInfo: affixsArr)
					{
						String[] affix = affixInfo.split(",");
						AdvaffixVO advaffixVO = new AdvaffixVO();
						advaffixVO.setAffixid(Long.valueOf(affix[0]));
						advaffixVO.setAffixpath(affix[1]);
						affixsList.add(advaffixVO);
					}
					advaffix.doRemoveAffixs(affixsList);
				}
			}
			//�ϴ�����
			advaffix.doUploadAffixs(questionnaireVO.getAdvinfoid(),docs,docFileNames);
			
			return questionnaireVO.getAdvinfoid();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	
	public void doQueDelete(DBQueryParam dbparam)throws Exception{
		String[] selectArray = ((DBQueryParam) dbparam).get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			doRemoveByPK(Long.valueOf(selectArray[i]));
		}

		//ɾ�����ն���
		Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
		RcvobjDBParam param = new RcvobjDBParam();
		param.set_pagesize("0");
		DataPackage dp = new DataPackage();
		List<RcvobjVO> rcvobjList = new ArrayList<RcvobjVO>();
		
		Long oid = -1L; 
		for (int i = 0; i < selectArray.length; i++) {
			param.set_ne_advinfoid(selectArray[i]);
			dp = rcvobj.doQuery(param);
			rcvobjList = dp.getDatas();
			
			//ɾ�����ն���
			if(rcvobjList.size()>0)
			{
				for(int j=0; j<rcvobjList.size(); j++)
				{
					oid = rcvobjList.get(j).getRvcobjid();
					rcvobj.doRemoveByPK(oid);
				}
			}
		}
		
		//ɾ����ظ���
		Advaffix advaffix = (Advaffix) BOFactory.build(AdvaffixBO.class,user);
		AdvaffixDBParam param2 = new AdvaffixDBParam();
		param2.set_pagesize("0");
		List<AdvaffixVO> affixsList = new ArrayList<AdvaffixVO>();
		for (int i = 0; i < selectArray.length; i++) {
			param2.set_ne_advinfoid(selectArray[i]);
			List<AdvaffixVO> affixsTempList = advaffix.doQuery(param2).getDatas();
			if(affixsTempList!=null)
			{
				affixsList.addAll(affixsTempList);
			}
		}
		
		advaffix.doRemoveAffixs(affixsList);
	}
}
