package com.gmcc.pboss.web.sales.disform;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class BatchSMSSignTaskBean extends BaseBatchTaskBean {
	public BatchSMSSignTaskBean() throws Exception {
		super.setBatchName("��������ǩ�ն���");
		super.setWriteLog(true);
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String discomcode = (String)getParameterMap().get("discomcode");
		
		try{
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			DisformVO dfvo = dfbo.doFindByPk(new Long(line.trim()));
			if(dfvo==null){//���͵�������
				line = rowCount + "|" + line + "|" + "���͵�������" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			if(!discomcode.equals(dfvo.getDiscomcode())){//���͵������ڸ�������
				line = rowCount + "|" + line + "|" + "���͵�������" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			if(!"DISOVER".equals(dfvo.getDisstate())){//���͵�״̬���ǡ�������ɡ�
				line = rowCount + "|" + line + "|" + "���͵�״̬����" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			else{
				//���¶���ȷ�ϼ�¼
				SmsconfirmVO scvo = null;
				SmsconfirmBO scbo = (SmsconfirmBO)BOFactory.build(SmsconfirmBO.class, user);
				scvo = scbo.doFind4BatchSign(
						dfvo.getRecetel(), //���ܺ���
						dfvo.getOrderid());//��������
				if(scvo==null){//�����ڣ�����������
					scvo = new SmsconfirmVO();
					scvo.setType("PARSIGN");
					scvo.setStream(dfvo.getOrderid().substring(dfvo.getOrderid().length()-4));
					scvo.setMobileno(dfvo.getRecetel());
					scvo.setOrderid(dfvo.getOrderid());
					scvo.setState("WAITREP");
					scvo.setSendtime(new Date());
					scbo.doCreate(scvo);
				}else{//���ڣ�ȡ����ʱ��������һ����������ʱ��
					scvo.setSendtime(new Date());	
					scbo.doUpdate(scvo);
				}
				
				//֪ͨ������ǩ��				
				SysparamBO sysbo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
				String sendNO = sysbo.doFindByID(42L, "pboss_fx");
				if(sendNO==null ||"".equals(sendNO)){//���ͺ���Ϊ��
					line = rowCount + "|" + line + "|" + "���ͺ���Ϊ��" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				if(dfvo.getRecetel()==null || "".equals(dfvo.getRecetel().trim())){//���պ���Ϊ��
					line = rowCount + "|" + line + "|" + "���պ���Ϊ��" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				//��������
				//�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�����͵����ʣ������ţ�{ ORDERID }��
				//�Ƿ��յ����ظ�"Q{STREAM}"ȷ��ǩ�գ��ظ�"N{STREAM}"�ܾ�ǩ�ա��㶫�ƶ���
				String recename = "";
				if(dfvo.getRecename()==null || "".equals(dfvo.getRecename().trim())){
					recename = "�ͻ�";
				}else{
					recename = dfvo.getRecename();
				}
				String logisticsno = "";
				//��������
				if (null != dfvo.getLogisticsno() && !("").equals(dfvo.getLogisticsno())) {
					logisticsno = dfvo.getLogisticsno();
				}
				Calendar calendar = Calendar.getInstance();		
				Map<String,String> map = new HashMap<String,String>();
				map.put("CUSTNAME", recename);
				map.put("YEAR", ""+calendar.get(Calendar.YEAR));
				map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
				map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
				map.put("ORDERID", dfvo.getOrderid());
				map.put("STREAM", dfvo.getOrderid().substring(dfvo.getOrderid().length()-4));
				map.put("LOGISTICSINFO",logisticsno );
				SmstmplBO smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
				String smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
				if( null == smsContent || "".equals(smsContent.trim())){//��������Ϊ��
					line = rowCount + "|" + line + "|" + "��������Ϊ��" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsert2(new Short("3"), smsContent, sendNO,dfvo.getRecetel());	
				
				//����ǩ�ն��ųɹ�
				line = rowCount + "|" + line + "|" + "����ǩ�ն��ųɹ�" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			}
		}catch(Exception e){
			e.printStackTrace();
			line = rowCount + "|" + line + "|" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
}
