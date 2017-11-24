package com.gmcc.pboss.control.sales.notice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.BgProcess.sales.notice.ComcategoryInfo;
import com.gmcc.pboss.BgProcess.sales.notice.DeliverInfo;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class DeliverTakeGoodsNoticeBO extends AbstractControlBean implements DeliverTakeGoodsNotice{

	private Log log = LogFactory.getLog(DeliverTakeGoodsNoticeBO.class);
	
	public void doNotice() throws Exception{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		String startTime = format1.format(nowDate)+" 00:00:00";
		String endTime = format1.format(nowDate)+" 23:59:59";
		SmstmplVO smstemlVO = doGetSmsTemplete();
		List<DeliverInfo> delivers = doGetDelivers(format2.parse(startTime),format2.parse(endTime));
		doStateComcate(delivers,format2.parse(startTime),format2.parse(endTime));
		doSmsReplace(delivers,smstemlVO,nowDate);
	}
	/*
	 * 1��	��ȡ����ģ��
	���ݱ�ʶ��FX_ORDER_DISRECNOTICE������Ч״̬��1����ѯ����ģ���CH_SMS_SMSTMPL��
	����ȡģ�����ݣ���������ݻ�����Ϊ�գ�����ʾ���˳���
	 */
	public SmstmplVO doGetSmsTemplete() throws Exception{
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class,user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_DISRECNOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if( null == dp || null == dp.getDatas() || dp.getDatas().size()<1 || ((SmstmplVO)dp.getDatas().get(0)).getScontent().trim().length() == 0)
			throw new Exception("�޷���������ģ������");
		return (SmstmplVO)dp.getDatas().get(0);
	}
	
	/**
	 * 2��	ͳ�����͵�
	 */
	public List<DeliverInfo> doGetDelivers(Date startTime,Date endTime) throws Exception {
		List<DeliverInfo> delivers = new ArrayList<DeliverInfo>();
		StringBuilder sb = new StringBuilder(200);
		sb.append("select a.discomcode as DISCOMCODE, count(*) as TOTALCOUNT, sum(b.actamt) as SUMPRICE");
		sb.append(" from FX_SW_DISFORM a, FX_SW_ORDER b");
		sb.append(" where a.orderid = b.orderid");
		sb.append(" and a.createtime >= :STARTTIME");
		sb.append(" and a.createtime <= :ENDTIME ");
		sb.append(" and b.orderstate not in ('WAITCON', 'CANCEL')");
		sb.append(" group by a.discomcode");
		DBQueryParam param = new DBQueryParam();
		param.setQueryAll(true);
		param.setDataOnly(true);
		param.getQueryConditions().put("STARTTIME", startTime);
		param.getQueryConditions().put("ENDTIME", endTime);
		param.setSelectFieldsString("DISCOMCODE,TOTALCOUNT,SUMPRICE");
		DataPackage dp = doQueryBySql(sb.toString(),param);
		if( null != dp && null != dp.getDatas() && dp.getDatas().size()>0){
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
				DeliverInfo deliver = new DeliverInfo();
				deliver.setDiscomcode(map.get("DISCOMCODE"));
				deliver.setTotalCount(Long.valueOf(map.get("TOTALCOUNT")));
				deliver.setSumPrice(Double.valueOf(map.get("SUMPRICE")));
				delivers.add(deliver);
			}
		}
		return delivers;
	}
	
	/*
	 * 3��	ͳ����Ʒ����
	 * @see com.gmcc.pboss.control.sales.notice.DeliverTakeGoodsNotice#doStateComcate(java.util.List, java.util.Date, java.util.Date)
	 */
	public void doStateComcate(List<DeliverInfo> delivers, Date startTime,Date endTime) throws Exception{
		StringBuilder sb = new StringBuilder(200);
		sb.append("select c.comcategory as COMCATE, sum(c.orderamt) as SUMORDER ");
		sb.append(" from FX_SW_DISFORM a, FX_SW_ORDER b, FX_SW_ORDERCOMCATE c");
		sb.append(" where a.orderid = b.orderid");
		sb.append(" and b.orderid = c.orderid");
		sb.append(" and a.createtime >= :STARTTIME");
		sb.append(" and a.createtime <= :ENDTIME");
		sb.append(" and b.orderstate not in ('WAITCON', 'CANCEL')");
		sb.append(" and a.discomcode = :DISCOMCODE");
		sb.append(" group by c.comcategory");
		DBQueryParam param = new DBQueryParam();
		param.setQueryAll(true);
		param.setDataOnly(true);
		param.getQueryConditions().put("STARTTIME", startTime);
		param.getQueryConditions().put("ENDTIME", endTime);
		param.setSelectFieldsString("COMCATE,SUMORDER");
		DataPackage dp = null;
		for(DeliverInfo deliver: delivers){
			param.getQueryConditions().put("DISCOMCODE", deliver.getDiscomcode());
			dp = doQueryBySql(sb.toString(),param);
			if( null != dp && null != dp.getDatas() && dp.getDatas().size()>0){
				if( null == deliver.getOrders())
					deliver.setOrders(new ArrayList<ComcategoryInfo>());				
				for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
					ComcategoryInfo comcate = new ComcategoryInfo();
					comcate.setComcate(map.get("COMCATE"));
					comcate.setSumOrder(Long.valueOf(map.get("SUMORDER")));
					deliver.getOrders().add(comcate);
				}
			}
		}
	}
	
	/**
	 * 4��	���������滻
	 */
	public void doSmsReplace(List<DeliverInfo> delivers,SmstmplVO smstmp,Date nowDate) throws Exception{
//		�ͻ����ƣ���ѯ������Ա������Ϣ��CH_PW_EMPLOYEE����ƥ���������루�������̱��룩��
//		�Ƿ�Ϊ����Ϊ�����̣���ISNET=3�����ù�״̬Ϊ�ڸڣ���EMPSTATUS=0�����ͻ�����ȡ�����ֶ�
//		����������ݻ�����Ϊ�գ���Ĭ��ȡ���ͻ�����
		
		String userName = "�ͻ�";
		Employee employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam employeeParam = new EmployeeDBParam();
		employeeParam.setDataOnly(true);
		employeeParam.setQueryAll(true);
		employeeParam.set_ne_isnet("3");
		employeeParam.set_ne_empstatus("0");
		for(DeliverInfo deliver:delivers){
			userName = "�ͻ�";
			employeeParam.set_se_wayid(deliver.getDiscomcode() == null ? "":deliver.getDiscomcode());
			DataPackage dp = employeeBO.doQuery(employeeParam);
			if( null != dp && null != dp.getDatas() && dp.getDatas().size()>0){
				EmployeeVO employeeVO = (EmployeeVO) dp.getDatas().get(0);
				if( null != employeeVO.getEmployeename() && employeeVO.getEmployeename().trim().length()>0 )
					userName = employeeVO.getEmployeename();
//				������Ʒ������ȡ��Ʒ����ͳ�����ݣ�����Ʒ���������������ϣ���ʽΪ����Ʒ1xx�ף�
//				��Ʒ2xx�ף���������ƷNxx�ס�����Ʒ����Ҫ����Ϊ���ġ�
				StringBuilder orderDes = new StringBuilder(200);
				for(ComcategoryInfo comcate :deliver.getOrders()){
					orderDes.append(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcate.getComcate(), user.getCityid()));
					orderDes.append(": ").append(comcate.getSumOrder()).append("��, ");
				}
				try{
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
//					5��	���Ͷ���֪ͨ
//					�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)����������ȡ3��
//					���պ���ȡ������Ա������Ϣ���еĹ�������롣
//					�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�յ��������͵��Ѿ��������ϼƵ�����{FORMAMT}��
//					��Ʒ����[{COMDESC}]������ȡʵ��������ͣ�лл���㶫�ƶ���
					Map<String,String> map = new HashMap<String,String>();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(nowDate);
					map.put("CUSTNAME", userName);
					map.put("YEAR", ""+calendar.get(Calendar.YEAR));
					map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
					map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
					map.put("FORMAMT", ""+deliver.getTotalCount());
					map.put("COMDESC", orderDes.toString().replaceAll(",$", ""));
					
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS("FX_ORDER_DISRECNOTICE", map);
					waitreqBO.doInsert(new Short("3"), smsContent, employeeVO.getOfficetel());
				}catch(Exception e){
					LoggerUtils.error(e, log);
				}
			}
		}
	}
		
	public DataPackage doQueryBySql(String sql,DBQueryParam param) throws Exception{
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		return dao.queryBySql(sql, param);
	}
	
}
