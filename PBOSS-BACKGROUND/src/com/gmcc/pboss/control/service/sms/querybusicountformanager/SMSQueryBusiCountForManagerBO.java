package com.gmcc.pboss.control.service.sms.querybusicountformanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.operationsms.OperationsmsDBParam;
import com.gmcc.pboss.business.channel.operationsms.OperationsmsVO;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.operationsms.Operationsms;
import com.gmcc.pboss.control.channel.operationsms.OperationsmsBO;
import com.gmcc.pboss.control.channel.smsloghis.Smsloghis;
import com.gmcc.pboss.control.channel.smsloghis.SmsloghisBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.QueryBusiCountForEmployeeResult;
import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSQueryBusiCountForManagerBO extends AbstractControlBean implements SMSQueryBusiCountForManager {
	private static Logger logger = Logger.getLogger(SMSQueryBusiCountForManagerBO.class);

	public String doQueryBusiCountForManager(String mobile,String cityid,String smscontent)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			//1.�����Ÿ�ʽ
			String[] content = StringUtils.split(smscontent, SMSProtocol.DATA_SLIT_SYMBOL);
			if(!"qdjlcx".equalsIgnoreCase(content[0])){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_016", map, mobile);
				return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016",new Short("1")).toString();
			}
			//date0Ϊqdjlcx,date1Ϊ�������,date2Ϊ��ʼ���ڣ�date3Ϊ��ֹ����
			String wayid = "";
			String date1 = "";
			String date2 = "";
			java.util.Date udate1 = null;
			java.util.Date udate2 = null;
			int length = content.length;
			if(length!=3 && length!=4){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_016", map, mobile);
				return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_019",new Short("1")).toString();
			}else if(length==3){
//				qdjlcx#�������#yyyymmdd
				wayid=content[1];
				date1 = content[2];
				udate1 = PublicUtils.strToSqlDate(date1, "yyyyMMdd");
				if(!PublicUtils.checkDateTime(2, date1, "", "", "") || !PublicUtils.checkWayid(content[1])){
					Map<String,String> map = new HashMap<String,String>();
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsertForCj("CJ_016", map, mobile);
					return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016",new Short("1")).toString();
				}
			}else if(length==4){
//				qdjlcx#�������#yyyymmdd#yyyymmdd
				wayid = content[1];
				date1 = content[2];
				date2=content[3];
				udate1 = PublicUtils.strToSqlDate(date1, "yyyyMMdd");
				udate2 = PublicUtils.strToSqlDate(date2, "yyyyMMdd");
				if(!PublicUtils.checkDateTime(2, date1, "", "", "") || !PublicUtils.checkWayid(content[1])){
					Map<String,String> map = new HashMap<String,String>();
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsertForCj("CJ_016", map, mobile);
					return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016",new Short("1")).toString();
				}
				if(!PublicUtils.checkDateTime(2, date2, "", "", "")){
					Map<String,String> map = new HashMap<String,String>();
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsertForCj("CJ_016", map, mobile);
					return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016",new Short("1")).toString();
				}
				int days = PublicUtils.compareDate(udate1, udate2);
				if(days<0){
					Map<String,String> map = new HashMap<String,String>();
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsertForCj("CJ_016", map, mobile);
					return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016",new Short("1")).toString();
				}
				if(days>30){
					Map<String,String> map = new HashMap<String,String>();
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsertForCj("CJ_024", map, mobile);
					return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_024",new Short("1")).toString();
				}
			}
			
			//2.������к����Ƿ�Ϊ���������������
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam empparam = new EmployeeDBParam();
			empparam.set_se_officetel(mobile);
			empparam.set_ne_empstatus("0");
			empparam.set_ne_isnet("4");//��������
			empparam.setDataOnly(true);
			EmployeeVO employeevo = new EmployeeVO();
			DataPackage dp = employee.doQuery(empparam);
			if(null!=dp&&dp.getDatas().size()>0){
				employeevo = (EmployeeVO)dp.getDatas().iterator().next();
			}else{
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_010", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_010",new Short("1")).toString();
			}
			
			//2.5  ͵Цing...
			//������������Ƿ�Ϊ�����������Ͻ��Χ������
			Way way=(Way)BOFactory.build(WayBO.class, user);
			WayDBParam wayparam=new WayDBParam();
			wayparam.set_ne_waystate("1");
			wayparam.set_se_waytype("AG");
			wayparam.set_se_waymagcode(employeevo.getEmployeeid());
			wayparam.set_se_wayid(wayid);
			if(way.doQuery(wayparam).getRowCount()<=0){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				map.put("wayid", wayid);
				waitreqBO.doInsertForCj("CJ_018", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_018",new Short("1")).toString();
			}
			
			//3.ҵ������ѯ
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime = "";
			String endTime = "";
			if(length==3){
				startTime = format1.format(udate1)+" 00:00:00";
				endTime = format1.format(udate1)+" 23:59:59";
			}else{
				startTime = format1.format(udate1)+" 00:00:00";
				endTime = format1.format(udate2)+" 23:59:59";
			}
			StringBuilder sb = new StringBuilder(300);
			sb.append("select a.opnid as OPNID, count(*) as COUNT");
			sb.append(" from ch_pw_registersim a");
			sb.append(" where a.cityid = :CITYID");
			sb.append(" and a.wayid= :WAYID");
			sb.append(" and a.oprtime >= :STARTTIME");
			sb.append(" and a.oprtime <= :ENDTIME ");
			sb.append(" group by a.opnid");
			DBQueryParam param = new DBQueryParam();
			param.setQueryAll(true);
			param.setDataOnly(true);
			param.getQueryConditions().put("CITYID", cityid);
			param.getQueryConditions().put("WAYID", wayid);
			param.getQueryConditions().put("STARTTIME", format2.parse(startTime));
			param.getQueryConditions().put("ENDTIME", format2.parse(endTime));
			param.setSelectFieldsString("OPNID,COUNT");
			DataPackage dp2 = doQueryBySql(sb.toString(),param);
			StringBuffer opncount = new StringBuffer("");
			Long sum =new Long("0");
			if( null != dp2 && null != dp2.getDatas() && dp2.getDatas().size()>0){
				opncount.append("���� ");
				for(Map<String,String> map:(List<Map<String,String>>) dp2.getDatas()){
					String opnname = getOpnname(map.get("OPNID"), cityid);
					opncount.append(opnname).append(":").append(map.get("COUNT")).append(" ");
					sum = sum + Long.valueOf(map.get("COUNT"));
				}
			}
			Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
			Map<String,String> map = new HashMap<String,String>();
			map.put("count", sum.toString());
			map.put("opncount", opncount.toString());
			map.put("wayid", wayid);
			if(length==4){
				map.put("startdate", date1);
				map.put("enddate", date2);
				waitreqBO.doInsertForCj("CJ_019", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_019",new Short("0")).toString();
			}else{
				map.put("qdate", date1);
				waitreqBO.doInsertForCj("CJ_023", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_023",new Short("0")).toString();
			}
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
	 * 7��	��¼���ж�����־��ʷ�����ض���Ӫҵ��
	 * 
	 * @throws Exception
	 */
	private QueryBusiCountForEmployeeResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid,Short success)
			throws Exception {
		Smsloghis smsloghis = (Smsloghis)BOFactory.build(SmsloghisBO.class, user);
		SmsloghisVO smsvo = new SmsloghisVO();
		smsvo.setMobile(mobile);
		smsvo.setCityid(cityid);
		smsvo.setSmsno("10086111");
		smsvo.setCommandid("77016");
		smsvo.setSmsseq("-1");
		smsvo.setScontent(smscontent);
		smsvo.setSstate(success);
		smsvo.setOprtime(new Date());
		smsvo.setRemark(templateid);
		smsloghis.doCreate(smsvo);
		
		QueryBusiCountForEmployeeResult result = new QueryBusiCountForEmployeeResult();
		result.setRet(ResetPasswordResult.RET_TYPE_SUCC_0);
		result.setMessage("�ɹ�");
		return result;
	}
	
	public DataPackage doQueryBySql(String sql,DBQueryParam param) throws Exception{
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		return dao.queryBySql(sql, param);
	}
	
	public String getOpnname(String opnid,String cityid) throws Exception{
		String opnname = opnid;
		Operationsms bo = (Operationsms)BOFactory.build(OperationsmsBO.class, user);
		OperationsmsDBParam param = new OperationsmsDBParam();
		param.set_se_opnid(opnid);
		param.set_se_smsno("10086111");
		param.set_ne_opntype("1");
		param.set_se_cityid(cityid);
		DataPackage dp = bo.doQuery(param);
		if(null!=dp && dp.getDatas().size()>0){
			OperationsmsVO vo = (OperationsmsVO)dp.getDatas().get(0);
			opnname = vo.getOpnname();
		}
		return opnname;
	}
	
	public static void main(String []args) throws Exception {
		String strCheck="[a-zA-Z][a-zA-z0-9-]{0,18}";
		System.out.println("j��m-".matches(strCheck));
	}
}
