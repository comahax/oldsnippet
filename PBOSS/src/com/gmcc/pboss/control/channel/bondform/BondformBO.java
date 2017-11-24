/**
 * auto-generated code
 * Thu Dec 29 08:58:06 CST 2011
 */
package com.gmcc.pboss.control.channel.bondform;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.gmcc.pboss.business.channel.bondform.BondformDAO;
import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bondaudit.BondauditBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: BondformBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondformBO extends AbstractControlBean implements
		Bondform {

	public BondformVO doCreate(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class, user);
			// TODO set the pk */
			return (BondformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformVO doUpdate(BondformVO vo) throws Exception {
		try {
			BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
			return (BondformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformVO doFindByPk(Serializable pk) throws Exception {
		BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
		return (BondformVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BondformDBParam params)
			throws Exception {
		BondformDAO dao = (BondformDAO) DAOFactory.build(BondformDAO.class,user);
		return dao.query(params);
	}
	
	
	//�ύ���
	public String doSubmitboss(String formid,String boss,User user) throws Exception {		
		BondauditBO bondauditBO = (BondauditBO) BOFactory.build(BondauditBO.class,user);
		BondauditVO bondauditVO = new BondauditVO();
		BondformVO bondformVO = new BondformVO();
		// ����˹����б�������ѡ����˹��ţ���ȷ����
		// ��ʱ�ڡ���֤����˱�[FX_SW_BONDAUDIT]����������һ����֤�����˼�¼��
		// ���С����[SEQID]��Ϊ��ǰ����+������У�
		//���ύ��[PRESENTER]��Ϊ��ǰ�ύ���ţ�
		// ���ύʱ��[SMSNTIME]��Ϊ��ǰϵͳʱ�䣬
		//�������[AUDITOR]��Ϊ�б���ѡ��������˹��ţ�
		//��״̬[STATE]��Ϊ�������[0]����
		//����֤�����뵥��š�Ϊ��ǰ�ύ���뵥�š�
		//���뵥����Ϊ�õ����������͡�
		
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		
		String seq = "";
		Date date = new Date(System.currentTimeMillis());
		
		 Calendar cal = Calendar.getInstance();
		 String day = cal.get(Calendar.DATE)+"";
		 String month = (cal.get(Calendar.MONTH) + 1)+"";
		 String year = cal.get(Calendar.YEAR)+"";
		 if(day.toString().length()==1){
			 day="0"+day;
		 }
		 
		 if(month.toString().length()==1){
			 month="0"+month;
		 }
		 
		 seq =  year+month+day+bondauditBO.doQuerySeq();
		 bondauditVO.setSeqid(Long.parseLong(seq));
		 bondauditVO.setPresenter(user.getOprcode());
		 bondauditVO.setSmsntime(date);
		 bondauditVO.setAuditor(boss);
		 bondauditVO.setState("0");
		 bondauditVO.setFormid(bondformVO.getFormid());
		 bondauditVO.setBondtype(bondformVO.getBondtype());
			
		 bondauditBO.doCreate(bondauditVO);
		 
		 
		// ���±�֤�����뵥��״̬Ϊ������ˡ�
			//��󷵻�ҳ��ɹ���Ϣ���ύ�����ɹ�����
		 bondformVO.setState(Short.parseShort("1"));
		 this.doUpdate(bondformVO);
		return null;
	}
	
	
	//���ŷ���
	public String doSendinfor(String formid,User user) throws Exception {
//		1.�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)��
//		2�ֶ�ȡֵ���£�
//		//3��������ȡ3��
//		//4���ͺ��룺��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ��
//		//5���պ��룺ȡ�����Ĺ�������룻
//		//6�������ݣ�������Ʒ�������Ź��÷�������֤���Ͻ�ȷ�ϣ���ȡ��
//		//7�ͻ�����ȡ�������ƣ�������ֶ�Ϊ����Ĭ��ȡ���ͻ�����
//		8����ȡ��ǰʱ�䣻
//		//9���Ϊ�Ͻɽ�
//		//10�Ͻɵ���ȡ���뵥�ţ�
//		//11���й�˾Ϊ�����������й�˾��
//		
//		˵����������ͺ��롢���պ�������������һ��Ϊ�գ������Ͷ���֪ͨ��
//		����ҳ�������Ϣ�����ͺ���/���պ���/��������Ϊ�գ�����
//		���Ͷ��ųɹ��󣬸��±�֤�����뵥��״̬Ϊ����ȷ�ϡ���״̬Ϊ��ȷ��δͨ����ʱ�����¡�
//		��󷵻�ҳ��ɹ���Ϣ������ȷ�϶��ųɹ�����	
		
		WaitreqVO waitreqVO = new WaitreqVO();
		
		
		//��֤�����뵥
		BondformVO bondformVO = new BondformVO();
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		//��ѯ���������
		EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(bondformVO.getWayid());		
		employeeDBParam.set_se_empstatus(Short.parseShort("0"));
		
		DataPackage dp = employeeBO.doQuery(employeeDBParam);
		
		if(dp.getDatas()!=null && dp.getDatas().size()>0){
			EmployeeVO employeeVO = (EmployeeVO)dp.getDatas().get(0);
			waitreqVO.setRecno(employeeVO.getOfficetel());
			
		}
		
		
		//��ѯ������Ϣ
		Way way = (Way) BOFactory.build(WayBO.class,user);
		WayVO vo=way.doFindByPk(bondformVO.getWayid());
		
		
		
		//���ͺ���
		SysparamBO sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
		String sysstr = sysparamBO.doFindByID(42L, "pboss_fx");  
		
		
		//CUSTNAME-�ͻ�����,AMT-��FORMID-�Ͻɵ��ţ�CITYNAME-���й�˾
		Date date = new Date(System.currentTimeMillis());
		
		
		Map<String,String> map = new HashMap<String,String>();
		if(vo.getWayname()!=null && !vo.getWayname().equals("")){
			map.put("CUSTNAME", vo.getWayname());
		}else{
			map.put("CUSTNAME", "�ͻ�");
		}
		
		map.put("AMT", bondformVO.getPayamt()+"");
		map.put("FORMID", bondformVO.getFormid()+"");
		map.put("CITYNAME", ""+Code2NameUtils.code2Name("CITYNAME", user.getCityid(), user.getCityid()));	
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String smsContent = smstmplBO.doGenSMS("FX_BOND_PAYCONFIR", map);
		
		
		
		waitreqVO.setSendno(sysstr);
		waitreqVO.setSmstype(Short.parseShort("3"));
		waitreqVO.setMessage(smsContent);

		WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
		
		//������Ŵ����ͱ�
		if(waitreqVO.getRecno()==null || waitreqVO.getRecno().equals("") || waitreqVO.getSendno()==null || waitreqVO.getSendno().equals("") || waitreqVO.getMessage()==null || waitreqVO.getMessage().equals("")){
			 throw new Exception("���ͺ���/���պ���/��������Ϊ�գ�");			
		}else{		
		waitreqBO.doInsert3(waitreqVO.getSmstype(), waitreqVO.getMessage(), waitreqVO.getSendno(), waitreqVO.getRecno(), date);
		}
		
		
		
//		���Ͷ��ųɹ��󣬸��±�֤�����뵥��״̬Ϊ����ȷ�ϡ���״̬Ϊ��ȷ��δͨ����ʱ�����¡�
		if(bondformVO.getState()!=5){
			 bondformVO.setState(Short.parseShort("4"));
			 this.doUpdate(bondformVO);
		}
				
		return null;
	}

	
	//����
	public String doMvaccount(String formid, User user) throws Exception {

		//���л��ۼ�¼���
		Bankdeduct bankdeduct = (Bankdeduct)BOFactory.build(BankdeductBO.class, user);
		
		
		//��֤�����뵥
		BondformVO bondformVO = new BondformVO();
		bondformVO = this.doFindByPk(Long.parseLong(formid));
		
		Date date = new Date(System.currentTimeMillis());
		
//		��ȡ�˻�����
//		���������̱����ѯ�����ʻ�����(CH_PW_WAYACCOUNT)����������ݣ��򷵻�ҳ����ϢΪ���˻����ϲ����ڡ�������ж������ݣ��Ե�һ������Ϊ׼��
//		�ж��ʺ������Ƿ�Ϊ�գ����Ϊ�գ��򷵻�ҳ����ϢΪ���ʺ�����Ϊ�ա���
//		�жϿ��๺�����������˺��Ƿ�Ϊ�գ����Ϊ�գ��򷵻�ҳ����ϢΪ�������˺�Ϊ�ա�����
//		�жϿ��๺�������ʺ������Ƿ�Ϊ�գ����Ϊ�գ��򷵻�ҳ����ϢΪ���ʺ�����Ϊ�ա���
//		�жϿ��๺���������б�ʶ�Ƿ�Ϊ�գ����Ϊ�գ��򷵻�ҳ����ϢΪ�����б�ʶΪ�ա���
		
		//����˻�����
		String bankid;//���д���
		String acctnum;//�����˺�
		Short accttype;//�ʺ�����
		String acctname;//�˻�����
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam wparam = new WayaccountDBParam();
		wparam.set_se_wayid(bondformVO.getWayid());
		DataPackage dp2 = wayaccount.doQuery(wparam);
		if(null!=dp2&&dp2.getDatas().size()>0){
			WayaccountVO wayaccountvo = (WayaccountVO)dp2.getDatas().iterator().next();
			if(StringUtils.isBlank(wayaccountvo.getAccttype().toString()))
				throw new Exception("������["+bondformVO.getWayid()+"]�ʺ�����Ϊ��");
			accttype = wayaccountvo.getAccttype();
			if(StringUtils.isBlank(wayaccountvo.getDeacctno()))
				throw new Exception("������["+bondformVO.getWayid()+"]�����˺�Ϊ��");
			acctnum = wayaccountvo.getDeacctno();
			if(StringUtils.isBlank(wayaccountvo.getDeacctname()))
				throw new Exception("������["+bondformVO.getWayid()+"]�ʺ�����Ϊ��");
			acctname = wayaccountvo.getDeacctname();
			if(StringUtils.isBlank(wayaccountvo.getDebankid()))
				throw new Exception("������["+bondformVO.getWayid()+"]���б�ʶΪ��");
			bankid = wayaccountvo.getDebankid();
		}else{
			throw new Exception("������["+bondformVO.getWayid()+"]�˻����ϲ�����");
		}
		
		
		
		
		//��ȡ�����̻���Ϣ
		String shopnum;//�̻���
		String terminalnum;//�ն˺�
		Bankshop bankshop = (Bankshop)BOFactory.build(BankshopBO.class, user);
		BankshopDBParam bparam = new BankshopDBParam();
		bparam.set_se_cityid(user.getCityid());
		bparam.set_se_countyid(bondformVO.getCountyid());
		DataPackage dp3 = bankshop.doQuery(bparam);
		if(null!=dp3&&dp3.getDatas().size()>0){
			BankshopVO bankshopvo = (BankshopVO)dp3.getDatas().iterator().next();
			shopnum = bankshopvo.getShopnum();
			terminalnum = bankshopvo.getTerminalnum();
		}else{
			throw new Exception("�޷���ȡ������["+bondformVO.getWayid()+"]��Ӧ�������̻���Ϣ");
		}
		
		
		
		//��ȡ�ֻ�����
		String officetel = "";//�ֻ�����
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam eparam = new EmployeeDBParam();
		eparam.set_se_wayid(bondformVO.getWayid());
		eparam.set_ne_empstatus("0");
		
		if(bondformVO.getBoneobjtype()==0){
			eparam.set_ne_isnet("3");
			
		}else{
			eparam.set_ne_isnet("1");
		}
		DataPackage dp4 = employee.doQuery(eparam);
		if(null!=dp4&&dp4.getDatas().size()>0){
			EmployeeVO employeevo = (EmployeeVO)dp4.getDatas().iterator().next();
			officetel = employeevo.getOfficetel();
		}
		
//		���ۼ�¼��ȡ���У�
//		�������������գ�
//		���д���ȡ�˻����ϱ��еĿ��๺���������б�ʶ[DEBANKID]��
//		�����˺�ȡ�˻����ϱ��еĿ��๺�����������˺ţ�
//		�ʺ�����ȡ�˻����ϱ��е��˺����ͣ�
//		�˻�����ȡ�˻����ϱ��еĿ��๺�������ʺ����ƣ�
//		���۽��ȡ�Ͻɽ�
//		����״̬ȡ������
//		����ʱ���״̬���ʱ��ȡ��ǰʱ�䣬
//		֪ͨ����ȡ�ѻ�ȡ���ֻ����룬
//		�̻��ź��ն˺�ȡ�ѻ�ȡ���̻���Ϣ��
		
		//�������ۼ�¼
		BankdeductVO bankdeductvo = new BankdeductVO();
		bankdeductvo.setOrderid(formid);
		bankdeductvo.setBankid(bankid);
		bankdeductvo.setAcctnum(acctnum);
		bankdeductvo.setAccttype(accttype);
		bankdeductvo.setAcctname(acctname);
		bankdeductvo.setDeductamt(bondformVO.getPayamt());
		bankdeductvo.setState("WAITPROC");
		bankdeductvo.setCreatdate(date);
		bankdeductvo.setStatechgtime(date);
		bankdeductvo.setCallnum(officetel);
		bankdeductvo.setShopnum(shopnum);
		bankdeductvo.setTerminalnum(terminalnum);
		bankdeductvo.setFormtype((short)2);
		bankdeduct.doCreate(bankdeductvo);
		
		
//		���±�֤�����뵥�����(FX_SW_BONDFORM)��״̬Ϊ��֧����
		 bondformVO.setState(Short.parseShort("7"));
		 this.doUpdate(bondformVO);
		
		return null;
	}
	
	
	
}
