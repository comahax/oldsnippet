package com.gmcc.pboss.web.sales.disform;



import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map; 
import org.apache.commons.lang.StringUtils; 

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class DisformTaskBean extends BaseBatchTaskBean {
	
	public DisformTaskBean() throws Exception {
		super.setBatchName("���͵���������");
	}

	protected String doStart() {
		
		return "���͵��������½��  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String optype = (String)getParameterMap().get("optype");
		
		String discomcode = (String)getParameterMap().get("discomcode");
		try{
				if( null == optype || "".equals(optype)|| null == discomcode || "".equals(discomcode))
					throw new Exception("��������  �����̲���Ϊ��");
		String items[] = StringUtils.splitPreserveAllTokens(line, "|");
		DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
		DisformVO dfvo = new DisformVO();

		dfvo = dfbo.doFindByPk(new Long(items[0]));
		
		if( null != dfvo && discomcode.equals(dfvo.getDiscomcode())){
			if("START".equals(optype)){
				if(!"WAITDIS".equals(dfvo.getDisstate())){
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ������Ϣ:" + "���͵�״̬����ȷ,������״̬������������!";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("DISING");
					dfbo.doUpdate(dfvo);
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ϵͳ��Ϣ:" + "���³ɹ�!";
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
			}else if("FINISH".equals(optype)){
				if(!"DISING".equals(dfvo.getDisstate())){
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ������Ϣ:" + "���͵�״̬����ȷ,������״̬�����������!";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("DISOVER");
					dfbo.doUpdate(dfvo);
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ϵͳ��Ϣ:" + "���³ɹ�!";
					OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if(ordervo != null){
						ordervo.setDisovertime(new Date());
						orderbo.doUpdate(ordervo);
					}
					
					Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
					String param72 = sysparamBO.doFindByID("72", "pboss_fx");
					if(param72 != null && "1".equals(param72)){
						//�������ݵ���������ȷ�ϱ�FX_SW_SMSCONFIRM��
						Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class, user);
						SmsconfirmVO smsconfirmVO = new SmsconfirmVO();
						String orderid = dfvo.getOrderid();
						String subOrderID = "";
						if(orderid != null && orderid.length() >= 4){
							subOrderID = orderid.substring(orderid.length()-4);
						}
						
						smsconfirmVO.setType("PARSIGN");//����ȡ������ǩ��
						smsconfirmVO.setStream(subOrderID);//ȷ����ˮ��ȡ����ĩβ4λ
						smsconfirmVO.setMobileno(dfvo.getRecetel());//�ֻ�����ȡ���͵��е��ջ��˵绰
						smsconfirmVO.setOrderid(orderid);//����������ȡ�������
						smsconfirmVO.setState("WAITREP");//״̬ȡ���ظ�
						smsconfirmVO.setSendtime(new Date());//֪ͨʱ��ȡ��ǰʱ��
						//�ظ�ʱ��ͻظ���������
						
						smsconfirmBO.doCreate(smsconfirmVO);
						
						//�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)
						String param42 = sysparamBO.doFindByID("42", "pboss_fx");//���ͺ���
						if(param42 != null && !"".equals(param42)){
							
						}else{//����
							line = line + "��������ͣ���֪ͨ����ʧ�ܣ����ͺ���Ϊ��";
							resultVO.setInfo(line);
							resultVO.setOk(true);
							return resultVO;
						}
						String receTel = dfvo.getRecetel();//���պ���
						if(receTel != null && !"".equals(receTel)){
							
						}else{//����
							line = line + "��������ͣ���֪ͨ����ʧ�ܣ����պ���Ϊ��";
							resultVO.setInfo(line);
							resultVO.setOk(true);
							return resultVO;
						}
						String recename = dfvo.getRecename();//�ͻ�����ȡ���͵��е��ջ�������
						if(recename != null && !"".equals(recename)){
							
						}else{
							recename = "�ͻ�";
						}
						String logisticsno = "";
						//��������
						if (null != dfvo.getLogisticsno() && !("").equals(dfvo.getLogisticsno())) {
							logisticsno = dfvo.getLogisticsno();
						}
						
						//��������
						//�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�����͵����ʣ������ţ�{ ORDERID }��
						//�Ƿ��յ����ظ�"Q{STREAM}"ȷ��ǩ�գ��ظ�"N{STREAM}"�ܾ�ǩ�ա��㶫�ƶ���
						Calendar calendar = Calendar.getInstance();		
						Map<String,String> map = new HashMap<String,String>();
						map.put("CUSTNAME", recename);
						map.put("YEAR", ""+calendar.get(Calendar.YEAR));
						map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
						map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
						map.put("ORDERID", orderid);
						map.put("STREAM", subOrderID);
						map.put("LOGISTICSINFO",logisticsno);
						Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
						String smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
						if( null == smsContent || "".equals(smsContent.trim())){
							line = line + "��������ͣ���֪ͨ����ʧ�ܣ���������Ϊ��";
							resultVO.setInfo(line);
							resultVO.setOk(true);
							return resultVO;
						}
							
						Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
						waitreqBO.doInsert2(new Short("3"), smsContent, param42,receTel);
						
					}
					
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
			}else if("SEND".equals(optype)){//�ֹܷ���
				if(!"WAITOUT".equals(dfvo.getDisstate())){//������͵�״̬�Ƿ�Ϊ����������
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ֻ�е����͵�״̬Ϊ������ʱ��������ִ�з������������͵�["+line+"]״̬�Ǵ�������";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("WAITDIS");//���͵�״̬Ϊ�������͡�
					dfvo.setStoresman(user.getOprcode());//���������뵱ǰ����Ա����
					dfvo.setOuttime(new Date());//����ʱ�����뵱ǰʱ��
					dfbo.doUpdate(dfvo);
					
					
					OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if(ordervo != null){
						ordervo.setSignstate("WAITSIGN");//������ǩ��״̬Ϊ����ǩ�ա�
						orderbo.doUpdate(ordervo);
					}
					
					Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
					String param42 = sysparamBO.doFindByID("42", "pboss_fx");//���ͺ���
					if(param42 != null && !"".equals(param42)){
						
					}else{//����
						line = line + "��������ͣ���֪ͨ����ʧ�ܣ����ͺ���Ϊ��";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
					
					//�����ֻ�
					Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
					EmployeeDBParam employeeList=new EmployeeDBParam();
					employeeList.set_se_wayid(dfvo.getRecewayid());
					employeeList.set_ne_empstatus("0");
					employeeList.set_ne_isnet("1");
					DataPackage employeeDp= employee.doQuery(employeeList);
					EmployeeVO empVO = null;
					String officetel = "";
					if(employeeDp.getRowCount()>0){
						Iterator it=employeeDp.getDatas().iterator();
						if(it.hasNext()){
							empVO=(EmployeeVO)it.next();
							officetel=empVO.getOfficetel();
						}
					}
					if(officetel != null && !"".equals(officetel)){
						
					}else{//����
						line = line + "��������ͣ���֪ͨ����ʧ�ܣ����պ���Ϊ��";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
					
					String logisticsno = "";
					//��������
					if (null != dfvo.getLogisticsno() && !("").equals(dfvo.getLogisticsno())) {
						logisticsno = dfvo.getLogisticsno();
					}
					
					//�ֹ�˾
					String countyid = "";
					if(ordervo != null){
						countyid = ordervo.getCountyid();
					}
					
					String recename = "�ͻ�";
					if(empVO != null && !"".equals(empVO)){
						recename = empVO.getEmployeename();
					}
					
					Calendar calendar = Calendar.getInstance();		
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTNAME", recename);
					map.put("YEAR", ""+calendar.get(Calendar.YEAR));
					map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
					map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
					map.put("COUNTYID",Code2NameUtils.code2Name("#CNTYCOMPANY",countyid,user.getCityid()));
					map.put("LOGISTICSINFO",logisticsno);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNREM", map);
					if( null == smsContent || "".equals(smsContent.trim())){
						line = line + "��������ͣ���֪ͨ����ʧ�ܣ���������Ϊ��";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
						
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, param42,officetel);
					
					line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ϵͳ��Ϣ:" + "���³ɹ�!";
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
			}

		}else{
			line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ������Ϣ:" + "���͵���Ϣ��ϵͳ������!";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		} catch (Exception e) {
			line = rowCount + "   " + "���͵���:" + line + "    �����̱���:" + discomcode + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}

}
