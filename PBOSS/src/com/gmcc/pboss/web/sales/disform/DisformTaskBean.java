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
		super.setBatchName("配送单批量更新");
	}

	protected String doStart() {
		
		return "配送单批量更新结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String optype = (String)getParameterMap().get("optype");
		
		String discomcode = (String)getParameterMap().get("discomcode");
		try{
				if( null == optype || "".equals(optype)|| null == discomcode || "".equals(discomcode))
					throw new Exception("操作类型  配送商不能为空");
		String items[] = StringUtils.splitPreserveAllTokens(line, "|");
		DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
		DisformVO dfvo = new DisformVO();

		dfvo = dfbo.doFindByPk(new Long(items[0]));
		
		if( null != dfvo && discomcode.equals(dfvo.getDiscomcode())){
			if("START".equals(optype)){
				if(!"WAITDIS".equals(dfvo.getDisstate())){
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    错误信息:" + "配送单状态不正确,待配送状态才能启动配送!";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("DISING");
					dfbo.doUpdate(dfvo);
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    系统信息:" + "更新成功!";
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
			}else if("FINISH".equals(optype)){
				if(!"DISING".equals(dfvo.getDisstate())){
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    错误信息:" + "配送单状态不正确,配送中状态才能完成配送!";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("DISOVER");
					dfbo.doUpdate(dfvo);
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    系统信息:" + "更新成功!";
					OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if(ordervo != null){
						ordervo.setDisovertime(new Date());
						orderbo.doUpdate(ordervo);
					}
					
					Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
					String param72 = sysparamBO.doFindByID("72", "pboss_fx");
					if(param72 != null && "1".equals(param72)){
						//新增数据到分销短信确认表（FX_SW_SMSCONFIRM）
						Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class, user);
						SmsconfirmVO smsconfirmVO = new SmsconfirmVO();
						String orderid = dfvo.getOrderid();
						String subOrderID = "";
						if(orderid != null && orderid.length() >= 4){
							subOrderID = orderid.substring(orderid.length()-4);
						}
						
						smsconfirmVO.setType("PARSIGN");//类型取合作商签收
						smsconfirmVO.setStream(subOrderID);//确认流水号取订单末尾4位
						smsconfirmVO.setMobileno(dfvo.getRecetel());//手机号码取配送单中的收货人电话
						smsconfirmVO.setOrderid(orderid);//关联订单号取订单编号
						smsconfirmVO.setState("WAITREP");//状态取待回复
						smsconfirmVO.setSendtime(new Date());//通知时间取当前时间
						//回复时间和回复描述留空
						
						smsconfirmBO.doCreate(smsconfirmVO);
						
						//新增数据到短信待发送表(CH_SMS_WAITREQ)
						String param42 = sysparamBO.doFindByID("42", "pboss_fx");//发送号码
						if(param42 != null && !"".equals(param42)){
							
						}else{//报错
							line = line + "已完成配送，但通知短信失败，发送号码为空";
							resultVO.setInfo(line);
							resultVO.setOk(true);
							return resultVO;
						}
						String receTel = dfvo.getRecetel();//接收号码
						if(receTel != null && !"".equals(receTel)){
							
						}else{//报错
							line = line + "已完成配送，但通知短信失败，接收号码为空";
							resultVO.setInfo(line);
							resultVO.setOk(true);
							return resultVO;
						}
						String recename = dfvo.getRecename();//客户名称取配送单中的收货人姓名
						if(recename != null && !"".equals(recename)){
							
						}else{
							recename = "客户";
						}
						String logisticsno = "";
						//物流单号
						if (null != dfvo.getLogisticsno() && !("").equals(dfvo.getLogisticsno())) {
							logisticsno = dfvo.getLogisticsno();
						}
						
						//短信内容
						//尊敬的{CUSTNAME}，{YEAR}年{MONTH}月{DAY}日配送的物资（订单号：{ ORDERID }）
						//是否收到，回复"Q{STREAM}"确认签收，回复"N{STREAM}"拒绝签收。广东移动。
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
							line = line + "已完成配送，但通知短信失败，短信内容为空";
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
			}else if("SEND".equals(optype)){//仓管发货
				if(!"WAITOUT".equals(dfvo.getDisstate())){//检查配送单状态是否为“待发货”
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    只有当配送单状态为待发货时，才允许执行发货操作，配送单["+line+"]状态非待发货。";
					resultVO.setInfo(line);
					resultVO.setOk(false);	
				}else{
					dfvo.setDisstate("WAITDIS");//配送单状态为“待配送”
					dfvo.setStoresman(user.getOprcode());//发货人填入当前操作员工号
					dfvo.setOuttime(new Date());//发货时间填入当前时间
					dfbo.doUpdate(dfvo);
					
					
					OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if(ordervo != null){
						ordervo.setSignstate("WAITSIGN");//订单表签收状态为“待签收”
						orderbo.doUpdate(ordervo);
					}
					
					Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
					String param42 = sysparamBO.doFindByID("42", "pboss_fx");//发送号码
					if(param42 != null && !"".equals(param42)){
						
					}else{//报错
						line = line + "已完成配送，但通知短信失败，发送号码为空";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
					
					//接收手机
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
						
					}else{//报错
						line = line + "已完成配送，但通知短信失败，接收号码为空";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
					
					String logisticsno = "";
					//物流单号
					if (null != dfvo.getLogisticsno() && !("").equals(dfvo.getLogisticsno())) {
						logisticsno = dfvo.getLogisticsno();
					}
					
					//分公司
					String countyid = "";
					if(ordervo != null){
						countyid = ordervo.getCountyid();
					}
					
					String recename = "客户";
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
						line = line + "已完成配送，但通知短信失败，短信内容为空";
						resultVO.setInfo(line);
						resultVO.setOk(true);
						return resultVO;
					}
						
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, param42,officetel);
					
					line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    系统信息:" + "更新成功!";
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
			}

		}else{
			line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    错误信息:" + "配送单信息在系统不存在!";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		} catch (Exception e) {
			line = rowCount + "   " + "配送单号:" + line + "    配送商编码:" + discomcode + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}

}
