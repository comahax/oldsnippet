package com.gmcc.pboss.control.service.sms.empconfirm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDBParam;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmVO;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDBParam;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmVO;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.emodconfirm.Emodconfirm;
import com.gmcc.pboss.control.channel.emodconfirm.EmodconfirmBO;
import com.gmcc.pboss.control.channel.empconfirm.Empconfirm;
import com.gmcc.pboss.control.channel.empconfirm.EmpconfirmBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.empmodel.Empmodel;
import com.gmcc.pboss.control.channel.empmodel.EmpmodelBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.EmpConfirmResult;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSEmpConfirmBO extends AbstractControlBean implements SMSEmpConfirm {
	private static Logger logger = Logger.getLogger(SMSEmpConfirmBO.class);

	public String doEmpConfirm(String mobile,String yesorno)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			String newempstatus = "";
			String oldempstatus = "";
			String employeename = "";
			String wayid = "";
			String wayname = "";
			Empconfirm empconfirm = (Empconfirm)BOFactory.build(EmpconfirmBO.class, user);
			EmpconfirmDBParam empparam = new EmpconfirmDBParam();
			empparam.set_se_telephone(mobile);
			empparam.set_ne_smsstatus("0");//待确认
			//获取当前时间和24小时之前的时间
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			empparam.set_dnm_smscreattime(format.format(calendar.getTime()));
	        //   24小时之前的时间
	        calendar.add(Calendar.DATE, -1);
	        empparam.set_dnl_smscreattime(format.format(calendar.getTime()));
			empparam.setDataOnly(true);
			DataPackage dp = empconfirm.doQuery(empparam);
			List list = dp.getDatas();
			if (list == null || list.size() == 0) {
				String message = "不存在专员信息";
				throw new SMSException(message, EmpConfirmResult.RET_TYPE_FAIL_1);
			}else{
				EmpconfirmVO empvo = (EmpconfirmVO)list.get(0);
				newempstatus = empvo.getEmpstatus().toString();
				employeename = empvo.getEmployeename();
				wayid = empvo.getWayid();
				Way way = (Way)BOFactory.build(WayBO.class, user);
				wayname = ((WayVO)way.doFindByPk(wayid)).getWayname();
				empvo.setSmsconfirmtime(new Date());
				Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
				EmployeeVO emoloyeevo = employee.doFindByPk(empvo.getEmployeeid());
				if(null!=emoloyeevo){
					oldempstatus = emoloyeevo.getEmpstatus().toString();
				}
				if("Y".equalsIgnoreCase(yesorno)){
					empvo.setSmsstatus(new Short("1"));//已确认
					empconfirm.doUpdate(empvo);
					if(emoloyeevo==null){
						EmployeeVO newemoloyeevo = new EmployeeVO();
						BeanUtils.copyProperties(newemoloyeevo, empvo);
						employee.doCreate(newemoloyeevo);
					}else{
						BeanUtils.copyProperties(emoloyeevo, empvo);
						employee.doUpdate(emoloyeevo);
					}
					
					//对ch_pw_empmodel进行数据操作
					Empmodel empmodel = (Empmodel)BOFactory.build(EmpmodelBO.class, user);
					Emodconfirm emodconfirm = (Emodconfirm)BOFactory.build(EmodconfirmBO.class, user);
					EmodconfirmDBParam emodparam = new EmodconfirmDBParam();
					emodparam.set_ne_smsstatus("0");
					emodparam.set_se_employeeid(empvo.getEmployeeid());
					//获取当前时间和24小时之前的时间
					Calendar calendar2 = Calendar.getInstance();
					emodparam.set_dnm_smscreattime(format.format(calendar2.getTime()));
			        //   24小时之前的时间
			        calendar2.add(Calendar.DATE, -1);
			        emodparam.set_dnl_smscreattime(format.format(calendar2.getTime()));
			        DataPackage dp2 = emodconfirm.doQuery(emodparam);
			        if(null!=dp2 && dp2.getDatas().size()>0){
			        	EmodconfirmVO emodvo = (EmodconfirmVO)dp2.getDatas().get(0);
			        	EmpmodelDBParam empmparam = new EmpmodelDBParam();
			        	empmparam.set_se_employeeid(empvo.getEmployeeid());
			        	DataPackage dp3 = empmodel.doQuery(empmparam);
			        	if(null==dp3||dp3.getDatas().size()==0){
			        		EmpmodelVO empmodelvo = new EmpmodelVO();
			        		//BeanUtils.copyProperties(empmodelvo, emodvo);
			        		empmodelvo.setEmpmodelid(emodvo.getEmpmodelid());
			        		empmodelvo.setEmployeeid(emodvo.getEmployeeid());
			        		empmodelvo.setModel(emodvo.getModel());
			        		empmodelvo.setState(emodvo.getState());
			        		empmodel.doCreate(empmodelvo);
			        		
			        		emodvo.setSmsconfirmtime(new Date());
			        		emodvo.setSmsstatus(new Short("1"));
			        		emodconfirm.doUpdate(emodvo);
			        	}else{
			        		List<EmpmodelVO> empmodelList = dp3.getDatas();
			        		for(EmpmodelVO empmodelvo: empmodelList){
				        		//BeanUtils.copyProperties(empmodelvo, emodvo);
				        		empmodelvo.setEmployeeid(emodvo.getEmployeeid());
				        		empmodelvo.setModel(emodvo.getModel());
				        		empmodelvo.setState(emodvo.getState());
				        		empmodel.doUpdate(empmodelvo);
				        		emodvo.setSmsconfirmtime(new Date());
				        		emodvo.setSmsstatus(new Short("1"));
				        		emodconfirm.doUpdate(emodvo);
			        		}
			        		
			        	}
			        }
			        // 返回短信营业厅
					return doReturnSuccVal(newempstatus,employeename,wayid,wayname).toString();
				}else{
					empvo.setSmsstatus(new Short("2"));//已拒绝  
					empconfirm.doUpdate(empvo);
					
					Emodconfirm emodconfirm = (Emodconfirm)BOFactory.build(EmodconfirmBO.class, user);
					EmodconfirmDBParam emodparam = new EmodconfirmDBParam();
					emodparam.set_ne_smsstatus("0");
					emodparam.set_se_employeeid(empvo.getEmployeeid());
					//获取当前时间和24小时之前的时间
					Calendar calendar2 = Calendar.getInstance();
					emodparam.set_dnm_smscreattime(format.format(calendar2.getTime()));
			        //   24小时之前的时间
			        calendar2.add(Calendar.DATE, -1);
			        emodparam.set_dnl_smscreattime(format.format(calendar2.getTime()));
			        DataPackage dp2 = emodconfirm.doQuery(emodparam);
			        if(null!=dp2 && dp2.getDatas().size()>0){
			        	EmodconfirmVO emodvo = (EmodconfirmVO)dp2.getDatas().get(0);
			        	emodvo.setSmsstatus(new Short("2"));//已拒绝  
			        	emodvo.setSmsconfirmtime(new Date());
			        	emodconfirm.doUpdate(emodvo);
			        }
			        // 返回短信营业厅
					return doReturnSuccVal(oldempstatus,employeename,wayid,wayname).toString();
				}
			}
		} catch (SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}
	}
	
	/**
	 * 返回短信营业厅
	 * 
	 * @throws Exception
	 */
	private EmpConfirmResult doReturnSuccVal (String empstatus,String employeename,String wayid,String wayname)
			throws Exception {
		EmpConfirmResult result = new EmpConfirmResult();
		List<String> list = new ArrayList<String>();
		StringBuffer datas = new StringBuffer();
		datas.append(empstatus).append(SMSProtocol.WORD_SLIT_SYMBOL).append(employeename).append(SMSProtocol.WORD_SLIT_SYMBOL).append(wayid).append(SMSProtocol.WORD_SLIT_SYMBOL).append(wayname);
		list.add(datas.toString());
		result.setRet(EmpConfirmResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}
	
}
