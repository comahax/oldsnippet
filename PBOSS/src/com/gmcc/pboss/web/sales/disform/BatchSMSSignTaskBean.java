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
		super.setBatchName("批量补发签收短信");
		super.setWriteLog(true);
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String discomcode = (String)getParameterMap().get("discomcode");
		
		try{
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			DisformVO dfvo = dfbo.doFindByPk(new Long(line.trim()));
			if(dfvo==null){//配送单不存在
				line = rowCount + "|" + line + "|" + "配送单不存在" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			if(!discomcode.equals(dfvo.getDiscomcode())){//配送单不属于该配送商
				line = rowCount + "|" + line + "|" + "配送单不存在" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			if(!"DISOVER".equals(dfvo.getDisstate())){//配送单状态不是“配送完成”
				line = rowCount + "|" + line + "|" + "配送单状态错误" + "|";
				resultVO.setInfo(line);
				resultVO.setOk(false);
				return resultVO;
			}
			else{
				//更新短信确认记录
				SmsconfirmVO scvo = null;
				SmsconfirmBO scbo = (SmsconfirmBO)BOFactory.build(SmsconfirmBO.class, user);
				scvo = scbo.doFind4BatchSign(
						dfvo.getRecetel(), //接受号码
						dfvo.getOrderid());//订单编码
				if(scvo==null){//不存在，则新增数据
					scvo = new SmsconfirmVO();
					scvo.setType("PARSIGN");
					scvo.setStream(dfvo.getOrderid().substring(dfvo.getOrderid().length()-4));
					scvo.setMobileno(dfvo.getRecetel());
					scvo.setOrderid(dfvo.getOrderid());
					scvo.setState("WAITREP");
					scvo.setSendtime(new Date());
					scbo.doCreate(scvo);
				}else{//存在，取当天时间内最早一条，更新其时间
					scvo.setSendtime(new Date());	
					scbo.doUpdate(scvo);
				}
				
				//通知合作商签收				
				SysparamBO sysbo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
				String sendNO = sysbo.doFindByID(42L, "pboss_fx");
				if(sendNO==null ||"".equals(sendNO)){//发送号码为空
					line = rowCount + "|" + line + "|" + "发送号码为空" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				if(dfvo.getRecetel()==null || "".equals(dfvo.getRecetel().trim())){//接收号码为空
					line = rowCount + "|" + line + "|" + "接收号码为空" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				//短信内容
				//尊敬的{CUSTNAME}，{YEAR}年{MONTH}月{DAY}日配送的物资（订单号：{ ORDERID }）
				//是否收到，回复"Q{STREAM}"确认签收，回复"N{STREAM}"拒绝签收。广东移动。
				String recename = "";
				if(dfvo.getRecename()==null || "".equals(dfvo.getRecename().trim())){
					recename = "客户";
				}else{
					recename = dfvo.getRecename();
				}
				String logisticsno = "";
				//物流单号
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
				if( null == smsContent || "".equals(smsContent.trim())){//短信内容为空
					line = rowCount + "|" + line + "|" + "短信内容为空" + "|";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
				
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsert2(new Short("3"), smsContent, sendNO,dfvo.getRecetel());	
				
				//补发签收短信成功
				line = rowCount + "|" + line + "|" + "补发签收短信成功" + "|";
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
