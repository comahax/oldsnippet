/**
 * auto-generated code
 * Wed Nov 18 16:14:43 CST 2009
 */
package com.gmcc.pboss.control.channel.waitreq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqDAO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqDBParam;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.employee.EmployeeConstant;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj;
import com.gmcc.pboss.control.communication.advgroupobj.AdvgroupobjBO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoConstant;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: WaitreqBO
 * </p>
 * ;
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
 * @author Jerimy
 * @version 1.0
 */
public class WaitreqBO extends AbstractControlBean implements Waitreq {
	public static final String RECNO = "10086111";

	public WaitreqVO doCreate(WaitreqVO vo) throws Exception {
		try {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class,
					user);
			// TODO set the pk */
			return (WaitreqVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaitreqVO vo) throws Exception {
		try {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaitreqVO doUpdate(WaitreqVO vo) throws Exception {
		try {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class,
					user);
			return (WaitreqVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaitreqVO doFindByPk(Serializable pk) throws Exception {
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		return (WaitreqVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaitreqDBParam params) throws Exception {
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		return dao.query(params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gmcc.pboss.control.channel.waitreq.Waitreq#doInsert(java.lang.Short,
	 * java.lang.String, java.lang.String)
	 */
	public WaitreqVO doInsert(Short mobileType, String content, String mobile)
			throws Exception {
		String recno = "";

		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		SysparamDBParam param = new SysparamDBParam();
		param.set_se_paramtype("pboss");
		param.set_ne_systemid("7");
		DataPackage dp = sysparam.doQuery(param);
		if (dp.getRowCount() > 0)
			recno = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();

		WaitreqVO newVO = new WaitreqVO();
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		newVO.setSmstype(mobileType);
		newVO.setAreacode(user.getCityid());
		// 待发送时填写生成时间
		// newVO.setDealtime(dealtime);
		newVO.setCreattime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setRecno(mobile);
		// 接收号码
		// newVO.setRecno("");
		newVO.setDealcount(new Short("0"));
		newVO.setSendno(recno);
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		// TODO Auto-generated method stub
		return (WaitreqVO) dao.create(newVO);
	}

	/*
	 * 参数:短信类型,短信内容,发送号码,接收号码
	 */
	public WaitreqVO doInsert2(Short mobileType, String content, String sendno, String recno)
			throws Exception {
		WaitreqVO newVO = new WaitreqVO();
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		newVO.setSmstype(mobileType);
		newVO.setAreacode(user.getCityid());
		newVO.setCreattime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setRecno(recno);
		newVO.setDealcount(new Short("0"));
		newVO.setSendno(sendno);
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		return (WaitreqVO) dao.create(newVO);
	}
	
	/*
	 * 参数:短信类型,短信内容,发送号码,接收号码,发送时间
	 */
	public WaitreqVO doInsert3(Short mobileType, String content, String sendno, String recno, Date senttime)
			throws Exception {
		WaitreqVO newVO = new WaitreqVO();
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		newVO.setSmstype(mobileType);
		newVO.setAreacode(user.getCityid());
		newVO.setCreattime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setRecno(recno);
		newVO.setDealcount(new Short("0"));
		newVO.setSendno(sendno);
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		newVO.setSenttime(senttime);//发送时间
		return (WaitreqVO) dao.create(newVO);
	}

	// 保存到信息待发送表
	public void doSaveWaitreq(Short mobileType, String content,
			String desttype, List<String> objidList) throws Exception {
		if (!StringUtils.isEmpty(desttype)) {
			EmployeeDBParam param = new EmployeeDBParam();
			param.set_pagesize("0");

			List<String> employeeidList = new ArrayList<String>();
			// 接收接收对象类型为特定对象
			if (desttype.equals(AdvinfoConstant.DESTTYPE_EMPLOYEE)) {
				if (null != objidList && objidList.size() > 0) {
					employeeidList.addAll(objidList);
					param.set_sin_employeeid(employeeidList);
					saveWaitreq(mobileType, content, desttype, param);
				}
			}
			// 接收对象类型等于内部工号
			else if (desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE)) {
				if (null != objidList && objidList.size() > 0) {
					Operator operator = (Operator) BOFactory.build(
							OperatorBO.class, user);
					OperatorDBParam param1 = new OperatorDBParam();
					param1.set_pagesize("0");
					param1.set_sin_operid(objidList);
					DataPackage dp1 = operator.doQuery(param1);
					List<OperatorVO> operatorList = dp1.getDatas();
					if (null != operatorList && operatorList.size() > 0) {
						for (OperatorVO operatorVO : operatorList) {
							doInsert(mobileType, content, operatorVO
									.getContactphone());
						}
					}
				}
			}
			// 接收接收对象类型为特定群组
			else if (desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)) {
				if (null != objidList && objidList.size() > 0) {
					Advgroupobj advgroupobj = (Advgroupobj) BOFactory.build(
							AdvgroupobjBO.class, user);
					AdvgroupobjDBParam param2 = new AdvgroupobjDBParam();
					param2.set_pagesize("0");
					param2.set_sin_groupid(objidList);
					DataPackage dp2 = advgroupobj.doQuery(param2);
					List<AdvgroupobjVO> advgroupobjList = dp2.getDatas();

					// 用Set去重复
					Set<String> employeeidSet = new HashSet<String>();
					for (AdvgroupobjVO advgroupobjVO : advgroupobjList) {
						employeeidSet.add(advgroupobjVO.getOid());
					}
					employeeidList.addAll(employeeidSet);
					param.set_sin_employeeid(employeeidList);
					saveWaitreq(mobileType, content, desttype, param);
				}
			}
			// 如果接收对象类型等于全社会/全部签约渠道/全部签约渠道及其店员
			else if (desttype.equals(AdvinfoConstant.DESTTYPE_SOCIETY)
					|| desttype.equals(AdvinfoConstant.DESTTYPE_WAY)
					|| desttype.equals(AdvinfoConstant.DESTTYPE_WAY_EMPLOYEE)) {
				param.set_se_waytype(EmployeeConstant.WAYTYPE_AG);
				param.set_ne_isnet(EmployeeConstant.ISNET_YES);
				param.set_ne_empstatus(EmployeeConstant.STATUS_EMP_USEFUL);
				saveWaitreq(mobileType, content, desttype, param);
			}
		}
	}

	private void saveWaitreq(Short mobileType, String content, String desttype,
			EmployeeDBParam param) throws Exception {
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
		DataPackage dp = employee.doQuery(param);
		List<EmployeeVO> employeeList = dp.getDatas();
		if (null != employeeList && employeeList.size() > 0) {
			for (EmployeeVO employeeVO : employeeList) {
				if (!StringUtils.isEmpty(employeeVO.getTelephone())) {
					doInsert(mobileType, content, employeeVO.getTelephone());
				}
			}
		}
	}
	
	/**
	 * 【发送短信】公共方法 --采集平台所用到的
	 *  @param 短信标识,需替换参数的键值，接收号码,flag
	 *  
	 * 根据短信标识查询短信模板表，并对短信内容进行替换，然后插入短信待发送表           
	 * @author yedaoe
	 */
	public WaitreqVO doInsertForCj(String sId, Map<String,String> keyAndValue, String recno) 
			throws Exception {
		Smstmpl smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class, user);
		String content = smstmpl.doGenSMS(sId, keyAndValue);
		WaitreqVO newVO = new WaitreqVO();
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		newVO.setSmstype(new Short("0"));//短信类型（SMSTYPE）取0（渠道）
		newVO.setAreacode(user.getCityid());
		newVO.setCreattime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setRecno(recno);
		newVO.setDealcount(new Short("0"));
		newVO.setSendno("10086111");//短信发送号码(SENDNO=10086111)
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		//正式使用后将即时发送，即让senttime字段为空
		//待正式使用时删除以下等号之间的几行代码
		//=================================
//		String senttime="20990101";
//		Dictparam dictbo = (Dictparam)BOFactory.build(DictparamBO.class, user);
//		DictparamVO dvo = dictbo.doFindByPk("CJ_SENTTIME");
//		if(null!=dvo){
//			senttime = dvo.getDvalue();
//		}
//		newVO.setSenttime(PublicUtils.UtilStrToDate(senttime, "yyyyMMdd"));
		//=================================
		
		return (WaitreqVO) dao.create(newVO);
	}
	
}
