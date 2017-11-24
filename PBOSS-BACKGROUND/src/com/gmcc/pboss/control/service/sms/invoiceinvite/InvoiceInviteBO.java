package com.gmcc.pboss.control.service.sms.invoiceinvite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.invoice.InvoiceVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bondform.Bondform;
import com.gmcc.pboss.control.channel.bondform.BondformBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.invoice.Invoice;
import com.gmcc.pboss.control.channel.invoice.InvoiceBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.PassAuditResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class InvoiceInviteBO extends AbstractControlBean implements InvoiceInvite {
	
	private static Logger logger = Logger.getLogger(InvoiceInviteBO.class);
	
	public String doInvite(String mobileno) throws Exception {
		try {
			//1����ȡ�����������
			/*Nosect nosectBO = (Nosect) BOFactory.build(
					NosectBO.class, user);
			String bossarea = nosectBO.doQueryCityID(mobileno);
			if(bossarea == null || "".equals(bossarea)){
				throw new SMSException("��ȡ�����������ʧ��","1");
			}*/
			
			//2�������������
			EmployeeVO itVO = null;
			Employee employeeBO = (Employee) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam employeeDBParam = new EmployeeDBParam();
			employeeDBParam.set_se_officetel(mobileno);//ƥ�乫������루OFFICETEL�����ں���
			employeeDBParam.set_ne_empstatus("0");//�ù�״̬����0����EMPSTATUS=0��
			DataPackage employeeDp = employeeBO.doQuery(employeeDBParam);
			if (employeeDp.getRowCount() <= 0) {
				throw new SMSException("����δ�Ǽ�","2");
			} else {
				Iterator it = employeeDp.getDatas().iterator();
				if (it.hasNext()) {
					itVO = (EmployeeVO) it.next();
					if(itVO.getIsnet() != 1){
						throw new SMSException("�ǵ���������Ȩ��","3");
					}
				}
			}
			
			//3��ȡ�������۽��
			Order orderBO = (Order) BOFactory.build(
					OrderBO.class, user);
			OrderDBParam orderDBParam = new OrderDBParam();
			orderDBParam.set_se_wayid(itVO.getWayid());//ƥ������������ں����̱���
			orderDBParam.set_sne_orderstate("CANCEL");//����״̬����������
			//�ϸ���
			DateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar calendar = Calendar.getInstance();
			Date date=new Date();
			calendar.setTime(date);		
			String thisMon = format.format(calendar.getTime());//����		
			calendar.add(Calendar.MONTH,-1);//����
			String lastMon = format.format(calendar.getTime());//����		
			
			String dnl = lastMon + "-01 00:00:00";
			String dl = thisMon + "-01 00:00:00";
			
			orderDBParam.set_dnl_paytime(dnl);//����ʱ��������(>=����1�� 00:00:00)
			orderDBParam.set_dl_paytime(dl);//����ʱ��������(<����1�� 00:00:00)
			double actamt = 0;//ʵ�ս����кϼ�
			DataPackage orderDp = orderBO.doQuery(orderDBParam);
			if (orderDp.getRowCount() > 0) {
				Iterator it = orderDp.getDatas().iterator();
				while (it.hasNext()) {
					OrderVO orderVO = (OrderVO)it.next();
					
					actamt = actamt + orderVO.getActamt();
				}
			}
			
			//4�������������
			Bondform bondformBO = (Bondform) BOFactory.build(
					BondformBO.class, user);
			BondformDBParam bondformDBParam = new BondformDBParam();
			bondformDBParam.set_se_wayid(itVO.getWayid());//��������
			bondformDBParam.set_ne_state("8");//״̬Ϊ�Ѿ�����
			DataPackage bondformDp = bondformBO.doQuery(bondformDBParam);
			if (bondformDp.getRowCount() > 0) {
				BondformVO bondformVO = (BondformVO)bondformDp.getDatas().get(0);
				Double payamt = bondformVO.getPayamt();//��֤���()
				//���������Ǽ�����4~6��1~3��
				Way wayBO = (Way) BOFactory.build(
						WayBO.class, user);
				WayDBParam wayDBParam = new WayDBParam();
				wayDBParam.set_se_wayid(itVO.getWayid());
				DataPackage waymDp = wayBO.doQuery(wayDBParam);
				if (waymDp.getRowCount() > 0) {
					WayVO wayVO = (WayVO)waymDp.getDatas().get(0);
					String wayid = wayVO.getWayid();
					String wayname = wayVO.getWayname();//��������
					Long starLevel = wayVO.getStarlevel();//�Ǽ�
					
					Double relDou = 0.0;//���������ķ�Ʊ���
					
					Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
					String sysparam79=sysparamBO.doFindByID("79", "channel");
					Double multi = 0.0;//��Ʊ���������
					if(sysparam79 != null && !"".equals(sysparam79)){
						multi = Double.parseDouble(sysparam79);
					}
					
					Double setDou = 5000.0;//5000�������
					//3S���µ� ����
					if(starLevel == 1 || starLevel == 2 || starLevel == 3){
						if(payamt >= 500){
							Double levMax = 10000.0;//3S���µ�����ÿ����Ʊ���
							String sysparam81=sysparamBO.doFindByID("81", "channel");
							if(sysparam81 != null && !"".equals(sysparam81)){
								levMax = Double.parseDouble(sysparam81);
							}
							relDou = cal(actamt,multi,levMax,setDou);
						}
					}
					//4 - 6 S������
					if(starLevel == 4 || starLevel == 5 || starLevel == 6){
						if(payamt >= 1000){
							Double levMax = 20000.0;//4 - 6S����ÿ����Ʊ���
							String sysparam80=sysparamBO.doFindByID("80", "channel");
							if(sysparam80 != null && !"".equals(sysparam80)){
								levMax = Double.parseDouble(sysparam80);
							}
							relDou = cal(actamt,multi,levMax,setDou);
						}
					}
					if(relDou > 0){
						Invoice invoiceBO=(Invoice)BOFactory.build(InvoiceBO.class,user);
						InvoiceVO invoiceVO = new InvoiceVO();
						invoiceVO.setWayid(wayid);
						invoiceVO.setWayname(wayname);
						invoiceVO.setApplytime(new Date());
						invoiceVO.setMomney(relDou.longValue());//��ȷ�ϣ��Ƿ���Double��
						
						invoiceBO.doCreate(invoiceVO);
					}
					
				}
			}
			
			//5�����ض���Ӫҵ��
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
	/**
	 * ����ʵ����ȡ���
	 * 
	 * @param actamt	�������۽��
	 * @param multi		��ȡ����
	 * @param levMax	�Ǽ������ȡ���
	 * @param setDou	5000�������
	 * @return
	 */
	private Double cal(Double actamt,Double multi,Double levMax,Double setDou){
		Double canDou = actamt * multi;//����ķ�Ʊ���
		Double relIntD = canDou/setDou;
		int relInt = relIntD.intValue();//����
		Double relDou = relInt*setDou;
		if(relDou > levMax){
			relDou = levMax;
		}
		
		return relDou;
	}
	
	private PassAuditResult doReturnSuccVal()
		throws Exception {
		PassAuditResult result = new PassAuditResult();
		result.setRet(PassAuditResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		return result;
	}
}
