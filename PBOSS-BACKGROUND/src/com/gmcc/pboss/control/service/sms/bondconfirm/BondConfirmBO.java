package com.gmcc.pboss.control.service.sms.bondconfirm;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.control.channel.bondform.Bondform;
import com.gmcc.pboss.control.channel.bondform.BondformBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.PassAuditResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 
 * 新增【保证金上缴申请单确认】短厅接口逻辑
 * 功能描述：配送商通过回复短信确认结果信息
 * @author dengxingxin
 *
 */

public class BondConfirmBO extends AbstractControlBean implements BondConfirm{
	
	private static Logger logger = Logger.getLogger(BondConfirmBO.class);
	
	public String doConfirm(String tranData) throws Exception {
		try {
			String[] datatrans = StringUtils.split(tranData, SMSProtocol.WORD_SLIT_SYMBOL);
			
			//1、获取号码归属地市
			/*Nosect nosectBO = (Nosect) BOFactory.build(
					NosectBO.class, user);
			String bossarea = nosectBO.doQueryCityID(datatrans[0]);
			if(bossarea == null || "".equals(bossarea)){
				throw new SMSException("获取号码归属地市失败","1");
			}*/
			
			//2、检查保证金申请信息
			BondformVO bondformVO = new BondformVO();
			Bondform bondformBO = (Bondform) BOFactory.build(
					BondformBO.class, user);
			BondformDBParam bondformDBParam = new BondformDBParam();
			String formRes = "";
			if(datatrans[3] != null && !"".equals(datatrans[3]) && datatrans[3].length() >= 2){
				formRes = datatrans[3].substring(2);
			}
			String formRess[] = formRes.split(SMSProtocol.DATA_SLIT_SYMBOL);
			bondformDBParam.set_se_formid(formRess[0]);
			DataPackage bondformDp = bondformBO.doQuery(bondformDBParam);
			if(bondformDp != null && !"".equals(bondformDp)
					&& bondformDp.getDatas() != null && !"".equals(bondformDp.getDatas())
					&& bondformDp.getDatas().size() > 0){
				bondformVO = (BondformVO)bondformDp.getDatas().get(0);
			}else{
				throw new SMSException("保证金申请信息不存在","2");
			}
			
			if(bondformVO != null && !"".equals(bondformVO)){
				Short state = bondformVO.getState();
				if(state != 4){//非待确认
					throw new SMSException("保证金申请单状态不为待确认","3");
				}
			}
			
			//人员检查
			EmployeeVO employeeVO = new EmployeeVO();
			Employee employeeBO = (Employee) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam employeeDBParam = new EmployeeDBParam();
			employeeDBParam.set_se_officetel(datatrans[0]);	//手机
			employeeDBParam.set_ne_isnet("1");				//店主
			employeeDBParam.set_ne_empstatus("0");			//在岗
			DataPackage employeeDp = employeeBO.doQuery(employeeDBParam);
			
			if(employeeDp.getRowCount() > 0){
				employeeVO = (EmployeeVO)employeeDp.getDatas().get(0);
			}else{
				throw new SMSException("该手机号码没有确认权限！","5");
			}
			if(employeeVO.getWayid() != null && 
					!employeeVO.getWayid().equals(bondformVO.getWayid())){
				throw new SMSException("该手机号码没有确认权限！","5");
			}
			
			//3、更新保证金申请单管理表(FX_SW_BONDFORM)
			if(bondformVO != null && !"".equals(bondformVO)){
				if("Y".equals(formRess[1])){//确认结果为“是”
					bondformVO.setState(Short.parseShort("6"));
					
					bondformBO.doUpdate(bondformVO);
				}else if("N".equals(formRess[1])){//确认结果为“否”
					bondformVO.setState(Short.parseShort("5"));
					
					bondformBO.doUpdate(bondformVO);
				}else{//其它
					throw new SMSException("确认结果信息输入有误","4");
				}
				
			}
			
			//4、返回短信营业厅
			return doReturnSuccVal().toString();
		} catch (SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}
	}
	
	private PassAuditResult doReturnSuccVal()
		throws Exception {
		PassAuditResult result = new PassAuditResult();
		result.setRet(PassAuditResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}

}
