package com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDAO;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SalesstdWarnBO extends AbstractControlBean implements SalesstdWarn {
	private static Logger log = Logger.getLogger(SalesstdWarnBO.class);
	
	public void doProcess() throws Exception {
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		
		//��ȡ���ŷ��ͺ���
		String param7 = sysparamBO.doFindByID("7", "pboss");
		if(param7 == null || "".equals(param7)){
			param7 = "10086";
		}
		
		//��ȡ����ʱ��
		String param58 = sysparamBO.doFindByID("58", "pboss_fx");
		if(param58 == null || "".equals(param58)){
			param58 = "08:30";
		}
		
		SalesstdDAO salesstdDAO = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class, user);
		//������������ֵ
		Map<String,List<HashMap>> limitMap = new HashMap<String,List<HashMap>>();
		//��ȡ������������ֵ
		dealLimitMap(salesstdDAO,limitMap);
		
		SimpleDateFormat smYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat smMonth = new SimpleDateFormat("MM");
		SimpleDateFormat smDay = new SimpleDateFormat("dd");
		
		//�³� --��ǰ��1����ʱ���� yyyy-MM-01 00:00:00
		Date date = new Date();
		String year = smYear.format(date);
		String month = smMonth.format(date);
		String day = smDay.format(date);
		String acttime = year + "-" + month + "-01 00:00:00";
		
		//��ȡ��������
		//�����������������̷��飬���Map��keyΪwayid���ڲ�Map��keyΪbrandId��valueΪ������
		Map<String,Map<String,Long>> salesMap 
					= new HashMap<String,Map<String,Long>>();
		dealSalesMap(salesstdDAO,salesMap,acttime);
		
		//δ��꼯��
		Map<String,List<String>> unLimitMap = new HashMap<String,List<String>>();//δ��꼯��
		dealUnlimitMap(limitMap,salesMap,unLimitMap);
		
		//δ��꣬���ŷ���
		dealSendSms(unLimitMap,month,day,param7,param58);
				
	}
	
	/**
	 * δ��꣬���ŷ���
	 * 
	 * @param unLimitMap		δ��꼯��
	 * @param sContentString	����ģ��
	 * @param month				��ǰ��
	 * @param day				��ǰ��
	 * @param param7			���ŷ��ͺ���
	 * @param param58			����ʱ��
	 * @throws Exception
	 */
	private void dealSendSms(Map<String,List<String>> unLimitMap,String month,String day,
			String param7,String param58) throws Exception{
		Iterator ulIter = unLimitMap.entrySet().iterator();
		while (ulIter.hasNext()) {
			Map.Entry entry = (Map.Entry) ulIter.next();
			String wayid = (String)entry.getKey();
			List val = (List)entry.getValue();
			String brandSaleSstd = "";
			for(int i=0; i<val.size(); i++){
				String bCont = (String)val.get(i);
				brandSaleSstd = brandSaleSstd + bCont + "��";				
			}
			if(brandSaleSstd != null && !"".equals(brandSaleSstd)){
				brandSaleSstd=brandSaleSstd.substring(0, brandSaleSstd.length()-1);
			}
						
			Map<String,String> map = new HashMap<String,String>();
			map.put("MONTH", month);
			map.put("DAY", ""+day);
			map.put("BRANDSALESSTD", brandSaleSstd);
			Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
			String content = smstmplBO.doGenSMS("FX_ORDER_SALESNOTICE", map);
			
			//���ŷ���
			//��ѯ�ֻ�����
			Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam employeeList=new EmployeeDBParam();
			employeeList.set_se_wayid(wayid);
			employeeList.set_ne_empstatus("0");
			employeeList.set_ne_isnet("1");
			DataPackage employeeDp= employee.doQuery(employeeList);
			if(employeeDp.getRowCount()>0){
				Iterator it=employeeDp.getDatas().iterator();
				if(it.hasNext()){
					EmployeeVO empVO=(EmployeeVO)it.next();
					String officetel=empVO.getOfficetel();
					
					if(officetel != null && !"".equals(officetel) && officetel.length() == 11){
						//���ŷ���
						
	    				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
	    				SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    				Calendar calendar = Calendar.getInstance();
	    				Date sendDate = dateTimeFormat2.parse(
								dateTimeFormat.format(calendar.getTime()) + " " + param58);
	    				WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
	    				
	    				waitreqBO.doInsert3(new Short("3"), content, param7, officetel,sendDate);
					}else{
						log.info("������["+wayid+"]��������벻����");
					}
				}
			}else{
				log.info("������["+wayid+"]��������벻����");
			}
			
		}
	}
	
	/**
	 * ͳ��δ�������
	 * @param limitMap		������������ֵ
	 * @param salesMap		��������
	 * @param unLimitMap	δ��꼯��
	 * @throws Exception
	 */
	private void dealUnlimitMap(Map<String,List<HashMap>> limitMap, Map<String,Map<String,Long>> salesMap, 
			Map<String,List<String>> unLimitMap) throws Exception{
		Iterator limiIiter = limitMap.entrySet().iterator();		
		while (limiIiter.hasNext()) {
			 Map.Entry entry = (Map.Entry) limiIiter.next();
			 String key = (String)entry.getKey();
			 List val = (List)entry.getValue();
			 if(!salesMap.containsKey(key)){
				 //��������,�����������ݣ���ú���������Ʒ��δ��꣬Ĭ�ϵ�������0
				 for(int i=0; i<val.size(); i++){
					HashMap ooaVO = (HashMap)val.get(i);
					String brand = (String)ooaVO.get("brand");
					Long salesstd = (Long)ooaVO.get("salesstd");
					
					getBrandContent(unLimitMap,key,brand,0L,salesstd);					
				 }
			 }else{
				 //��������,�����������ݣ�
			 	 //�ú���������Ʒ�Ƶ����������ϣ�key��Ʒ�ƣ�value������
				 Map<String,Long> sMap = salesMap.get(key);
				 
				 for(int i=0; i<val.size(); i++){
					HashMap ooaVO = (HashMap)val.get(i);
					String brand = (String)ooaVO.get("brand");
					Long salesstd = (Long)ooaVO.get("salesstd");
					if(sMap.containsKey(brand)){
						//��δ������ݣ���������<������ֵ�����浽������
						if(sMap.get(brand)<salesstd){
							getBrandContent(unLimitMap,key,brand,sMap.get(brand),salesstd);							
						}
					}else{
						//��Ʒ�����������ݣ�Ĭ��0
						getBrandContent(unLimitMap,key,brand,0L,salesstd);						
					}
				 }
			 }
		}
	}
	/**
	 * 	��ȡ��������
	 * @param salesstdDAO
	 * @param salesMap
	 * @param acttime
	 * @throws Exception
	 */
	private void dealSalesMap(SalesstdDAO salesstdDAO, Map<String,Map<String,Long>> salesMap, 
			String acttime) throws Exception{
		SalesstdDBParam sstsdParam2 = new SalesstdDBParam();
		sstsdParam2.setDataOnly(true);
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("acttime", acttime);
		sstsdParam2.setQueryConditions(map2);
		sstsdParam2.setSelectFieldsString("wayid,brand,count");
		DataPackage dp2 = salesstdDAO.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.salesstdquery.doQuerySale", sstsdParam2);
		
		if (null == dp2
				|| null == dp2.getDatas()
				|| dp2.getDatas().size() < 1){
			//������
		}else{
			for(int i=0; i<dp2.getDatas().size(); i++){
				HashMap ooaVO = (HashMap)dp2.getDatas().get(i);
				String wayid = (String)ooaVO.get("wayid");
				String brand = (String)ooaVO.get("brand");
				Long count = new Long((String)ooaVO.get("count"));
				
				if(salesMap.containsKey(wayid)){
					salesMap.get(wayid).put(brand, count);
				}else{
					Map<String,Long> sMap = new HashMap<String,Long>();
					sMap.put(brand, count);
										
					salesMap.put(wayid, sMap);
				}
			}
		}
	}
	
	/**
	 * 	��ȡ������������ֵ
	 * @param salesstdDAO
	 * @param limitMap		������������ֵ���ϣ�List�����������Map�������̡�Ʒ�ơ���ֵ��
	 * @throws Exception
	 */
	private void dealLimitMap(SalesstdDAO salesstdDAO, Map<String,List<HashMap>> limitMap) throws Exception{		
		SalesstdDBParam sstsdParam = new SalesstdDBParam();
		sstsdParam.setDataOnly(true);
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("cityid", user.getCityid());
		sstsdParam.setQueryConditions(map1);
		sstsdParam.setSelectFieldsString("wayid,wayName,brand,salesstd");
		DataPackage dp1 = salesstdDAO.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.salesstdquery.doQueryLimit", sstsdParam);
		
		if (null == dp1
				|| null == dp1.getDatas()
				|| dp1.getDatas().size() < 1){
			//������
		}else{
			for(int i=0; i<dp1.getDatas().size(); i++){
				HashMap ooaVO = (HashMap)dp1.getDatas().get(i);
				String wayid = (String)ooaVO.get("wayid");
				String wayName = (String)ooaVO.get("wayName");
				String brand = (String)ooaVO.get("brand");
				Long salesstd = (Long)ooaVO.get("salesstd");
				
				//�Ժ����̷��飬list�����ú����̵�����Ʒ��
				if(limitMap.containsKey(wayid)){
					limitMap.get(wayid).add(ooaVO);
				}else{
					List<HashMap> l = new ArrayList<HashMap>();
					l.add(ooaVO);
					limitMap.put(wayid, l);
				}
			}
		}
	}
	
	/**
	 * ���조Ʒ��A/80/100�������浽�Ժ����̷����Map����
	 * @param unLimitMap
	 * @param wayid
	 * @param brand
	 * @param salesCount	������
	 * @param salesstd		������ֵ
	 */
	private void getBrandContent(Map<String,List<String>> unLimitMap, 
			String wayid, String brand, Long salesCount, Long salesstd){
		String listString = Code2NameUtils.code2Name("$FX_SMPBRAND", 
				brand, user.getCityid())+"/"+salesCount+"/"+salesstd;
		log.info("�����̱��룺"+wayid+"  Ʒ�ƣ�"+brand+
				"  ������ֵ��"+salesstd+"  ��������"+salesCount);
		if(unLimitMap.containsKey(wayid)){
			unLimitMap.get(wayid).add(listString);
		}else{
			List<String> inList = new ArrayList<String>();
			inList.add(listString);
			unLimitMap.put((String)wayid, inList);
		}
	}

}
