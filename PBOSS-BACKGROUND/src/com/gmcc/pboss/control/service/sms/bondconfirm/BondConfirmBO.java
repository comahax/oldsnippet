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
 * ��������֤���Ͻ����뵥ȷ�ϡ������ӿ��߼�
 * ����������������ͨ���ظ�����ȷ�Ͻ����Ϣ
 * @author dengxingxin
 *
 */

public class BondConfirmBO extends AbstractControlBean implements BondConfirm{
	
	private static Logger logger = Logger.getLogger(BondConfirmBO.class);
	
	public String doConfirm(String tranData) throws Exception {
		try {
			String[] datatrans = StringUtils.split(tranData, SMSProtocol.WORD_SLIT_SYMBOL);
			
			//1����ȡ�����������
			/*Nosect nosectBO = (Nosect) BOFactory.build(
					NosectBO.class, user);
			String bossarea = nosectBO.doQueryCityID(datatrans[0]);
			if(bossarea == null || "".equals(bossarea)){
				throw new SMSException("��ȡ�����������ʧ��","1");
			}*/
			
			//2����鱣֤��������Ϣ
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
				throw new SMSException("��֤��������Ϣ������","2");
			}
			
			if(bondformVO != null && !"".equals(bondformVO)){
				Short state = bondformVO.getState();
				if(state != 4){//�Ǵ�ȷ��
					throw new SMSException("��֤�����뵥״̬��Ϊ��ȷ��","3");
				}
			}
			
			//��Ա���
			EmployeeVO employeeVO = new EmployeeVO();
			Employee employeeBO = (Employee) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam employeeDBParam = new EmployeeDBParam();
			employeeDBParam.set_se_officetel(datatrans[0]);	//�ֻ�
			employeeDBParam.set_ne_isnet("1");				//����
			employeeDBParam.set_ne_empstatus("0");			//�ڸ�
			DataPackage employeeDp = employeeBO.doQuery(employeeDBParam);
			
			if(employeeDp.getRowCount() > 0){
				employeeVO = (EmployeeVO)employeeDp.getDatas().get(0);
			}else{
				throw new SMSException("���ֻ�����û��ȷ��Ȩ�ޣ�","5");
			}
			if(employeeVO.getWayid() != null && 
					!employeeVO.getWayid().equals(bondformVO.getWayid())){
				throw new SMSException("���ֻ�����û��ȷ��Ȩ�ޣ�","5");
			}
			
			//3�����±�֤�����뵥�����(FX_SW_BONDFORM)
			if(bondformVO != null && !"".equals(bondformVO)){
				if("Y".equals(formRess[1])){//ȷ�Ͻ��Ϊ���ǡ�
					bondformVO.setState(Short.parseShort("6"));
					
					bondformBO.doUpdate(bondformVO);
				}else if("N".equals(formRess[1])){//ȷ�Ͻ��Ϊ����
					bondformVO.setState(Short.parseShort("5"));
					
					bondformBO.doUpdate(bondformVO);
				}else{//����
					throw new SMSException("ȷ�Ͻ����Ϣ��������","4");
				}
				
			}
			
			//4�����ض���Ӫҵ��
			return doReturnSuccVal().toString();
		} catch (SMSException e) {
			// SMSException ����Ҫ�ع�����
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
		result.setMessage("�ɹ�");
		return result;
	}

}
