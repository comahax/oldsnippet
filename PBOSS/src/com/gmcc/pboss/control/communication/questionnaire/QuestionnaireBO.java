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
			//接收接收对象类型为特定群组或者内部工号，objinfo按需要只是单个objid，这里便于扩展，也支持objinfo由“,”拼接objid
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
			//接收接收对象类型为特定对象
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
	
	//通过advinfoid查询对应附件列表
	public List<AdvaffixVO> doGetAdvaffixByAdvinfoid(Long advinfoid)throws Exception
	{
		Advaffix advaffix = (Advaffix)BOFactory.build(AdvaffixBO.class,user);
		AdvaffixDBParam param = new AdvaffixDBParam();
		param.set_pagesize("0");
		param.set_ne_advinfoid(String.valueOf(advinfoid));
		List<AdvaffixVO> advaffixList = advaffix.doQuery(param).getDatas();
		return advaffixList;
	}
	
	//通过advinfoid查询对应回复列表
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
			
			//1、保存基本信息
			String desttype = String.valueOf(questionnaireVO.getDesttype());
			questionnaireVO.setNdapproval(QuestionnaireConstant.NDAPPROVAL_NO);
			questionnaireVO.setType(QuestionnaireConstant.TYPE_QUESTIONNAIRE);
			questionnaireVO.setState(QuestionnaireConstant.STATE_PUBLISHED);
			questionnaireVO.setOprcode(user.getOprcode());
			
			//编辑时，接收对象类型改变标识
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
				
				//用questionnaireVOOld存放需要保存的信息
				BeanUtils.copyProperties(questionnaireVOOld, questionnaireVO);
				questionnaireVO = doUpdate(questionnaireVOOld);
			}
			
			//这里用到触发器有涉及到接收对象，sql执行顺序需要按逻辑执行
			session.flush();
			
			//2、保存接收对象信息
			Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
			if(null==desttype){
				throw new Exception("接收对象类型不存在，请检查!");
			}
			String objinfo = helper.getObjinfo();
			//处理接收对象
			rcvobj.doSaveRcvobj(questionnaireVO.getAdvinfoid(), desttype, objinfo, createFlag, destChangeFlag);
			
			/*
			//3、保存短信待发送信息,注：短信待发送信息只插入不删除
			Short smsnotify = helper.getSmsnotify();
			if(null!=smsnotify && String.valueOf(smsnotify).equals("1"))
			{
				Smstmpl Smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class,user);
				Map<String,String> map = new HashMap<String,String>();
				map.put("TITLE", questionnaireVO.getTitle());
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);
				//String content = "尊敬的客户，您有1条新的待办请处理：" + questionnaireVO.getTitle();
				
				Waitreq waitreq = (Waitreq)BOFactory.build(WaitreqBO.class,user);
				Short mobileType = Waitreq.SMS_GOTO;
				waitreq.doSaveWaitreq(mobileType,content,desttype,objidList);
			}
			*/
			
			//4、保存附件信息，注：附件要最后保存，因为附件上传操作其中一步是拷到服务器指定目录，不操作数据库，出错后不会回滚
			Advaffix advaffix = (Advaffix)BOFactory.build(AdvaffixBO.class, user);
			if(!createFlag)
			{
				//删除附件
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
			//上传附件
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

		//删除接收对象
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
			
			//删除接收对象
			if(rcvobjList.size()>0)
			{
				for(int j=0; j<rcvobjList.size(); j++)
				{
					oid = rcvobjList.get(j).getRvcobjid();
					rcvobj.doRemoveByPK(oid);
				}
			}
		}
		
		//删除相关附件
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
