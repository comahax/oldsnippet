/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.control.sales.canorderinfo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDAO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.cityrescode.CityrescodeBO;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: canorderinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoBO extends AbstractControlBean implements
		Canorderinfo {

	public CanorderinfoVO doCreate(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class, user);
			// TODO set the pk */
			return (CanorderinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CanorderinfoVO doUpdate(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			return (CanorderinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CanorderinfoVO doFindByPk(Serializable pk) throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return (CanorderinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CanorderinfoDBParam params)
			throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return dao.query(params);
	}

	public List doStatPartnerres(CanorderinfoDBParam params)
			throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return dao.doStatPartnerres(params);
	}
	
	public CanorderinfoVO doNotceOne(DBAccessUser user, WayVO wayvo) throws Exception {
		CanorderinfoVO coiVO = new CanorderinfoVO();
		List brandList = new ArrayList<CanorderinfoVO>();
		List cardList = new ArrayList<CanorderinfoVO>();
		List emptyList = new ArrayList<CanorderinfoVO>();
		
		//��ȡ����ģ��
		String sContentString = getSmsContent();
		if(sContentString == null || "".equals(sContentString)){
			String errStr1 = "��Ʒ�����������Ѷ���ģ��δ���ã�����ϵϵͳ����Ա��顣";
			
			throw new Exception(errStr1);
		}
		//��ȡ�����������Ŷ˿�
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
		if(sysparamvalue42 == null || "".equals(sysparamvalue42)){
			String errStr2 = "�����������Ŷ˿�δ���ã�����ϵϵͳ����Ա���";
			
			throw new Exception(errStr2);
		}
		coiVO.setSendNum(sysparamvalue42);
		
		//��ȡ�׿�Ʒ�Ƽ���
		doQueryBrand(brandList, user, wayvo);
		
		//��ȡ��ֵ��������Ϣ
		doQueryStock(cardList, user, wayvo);
		
		//��ȡ�հ�SIM��������Ϣ
		doQueryEmpty(emptyList, user, wayvo);
		
		ComcatebrandBO comcatebrandBO = (ComcatebrandBO) BOFactory.build(ComcatebrandBO.class, user);
		ComcatebrandDBParam comcatebrandDBParam = new ComcatebrandDBParam();
		comcatebrandDBParam.setDataOnly(true);
		comcatebrandDBParam.setQueryAll(true);
		comcatebrandDBParam.setSelectFieldsString("cityrescode,comcategory,brand");
		DataPackage res2ComcateDP = comcatebrandBO.doQueryRes2Comcate(comcatebrandDBParam,user.getCityid());	
				
		//�Կɶ��������Ͻ��б���(�׿�)
		Map<String,String> brand2Comcategory = new HashMap<String,String>();//�׿�Ʒ��-->��Ʒ���࣬��Ӧ��ϵ
		Map<String,String> brand2Res = new HashMap<String,String>();//�׿�Ʒ��-->������Դ���룬��Ӧ��ϵ
		for(int i = 0;i<brandList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(i);
			String rcBrand = bvo.getBrand();
			if(rcBrand != null && !"".equals(rcBrand) && rcBrand.indexOf(",")>=0){
				//����Ʒ�ƴ���
				String rcBrands[] = rcBrand.split(",");
				String allBr = "";
				if(rcBrands != null && !"".equals(rcBrands) && rcBrands.length > 0){
					
					for(int j=0 ; j<rcBrands.length ; j++){
						String inBra = rcBrands[j];//����Ʒ����ÿ��Ʒ��
						boolean innerBrandFlag_j = false;//����Ʒ����ÿ��Ʒ���Ƿ����ڵ�����Դ����
						String inBraRes = "";
						
						if(res2ComcateDP != null && !"".equals(res2ComcateDP) 
								&& res2ComcateDP.getDatas() != null && !"".equals(res2ComcateDP.getDatas())
								&& res2ComcateDP.getDatas().size() > 0){
							for(int k=0 ; k<res2ComcateDP.getDatas().size() ; k++){
								Map obj = (Map)res2ComcateDP.getDatas().get(k);
								
								if(obj != null && obj.get("brand") != null && obj.get("brand").equals(inBra)){
									innerBrandFlag_j = true;
									inBraRes = (String)obj.get("cityrescode") ;
									if(!brand2Comcategory.containsKey(rcBrand))
										brand2Comcategory.put(inBra, (String)obj.get("comcategory"));
									if(!brand2Res.containsKey(rcBrand)){
										brand2Res.put(inBra, (String)obj.get("cityrescode"));
									}
									break;
								}
							}
						}
						
						allBr = allBr + inBraRes + ",";
						if(!innerBrandFlag_j){
							//����Ʒ����ĳ��Ʒ�Ʋ����ڵ�����Դ����
							String errStr3 = "Ʒ��["+inBra+"]δ����[����Ʒ�ƶ�Ҫ�еĵ�����Դ���룿]��Ӧ�ĵ�����Դ���룬����ϵϵͳ����Ա��顣";
							
							throw new Exception(errStr3);
						}
					}
					if(allBr != null && !"".equals(allBr)){
						allBr = allBr.substring(0, (allBr.length()-1));
					}
				}
				
				brand2Res.put(rcBrand, allBr);
			}else{
				//�ǹ���Ʒ�ƴ���
				if(res2ComcateDP != null && !"".equals(res2ComcateDP) 
						&& res2ComcateDP.getDatas() != null && !"".equals(res2ComcateDP.getDatas())
						&& res2ComcateDP.getDatas().size() > 0){
					for(int j=0 ; j<res2ComcateDP.getDatas().size() ; j++){
						Map obj = (Map)res2ComcateDP.getDatas().get(j);
						
						if(obj != null && obj.get("brand") != null && obj.get("brand").equals(rcBrand)){
							brandFlag = true;
							if(!brand2Comcategory.containsKey(rcBrand))
								brand2Comcategory.put(rcBrand, (String)obj.get("comcategory"));
							if(!brand2Res.containsKey(rcBrand)){
								brand2Res.put(rcBrand, (String)obj.get("cityrescode"));
								break;
							}
						}						
					}
				}
				if(!brandFlag){
					String errStr3 = "Ʒ��["+rcBrand+"]δ����[����Ʒ�ƶ�Ҫ�еĵ�����Դ���룿]��Ӧ�ĵ�����Դ���룬����ϵϵͳ����Ա��顣";
					
					throw new Exception(errStr3);
				}
			}
			
		}
		
		//�Կɶ��������Ͻ��б���(��ֵ��)
		CityrescodeBO cityrescodeBO = (CityrescodeBO) BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cityrescodeDBParam = new CityrescodeDBParam();
		cityrescodeDBParam.setDataOnly(true);
		cityrescodeDBParam.setQueryAll(true);
		cityrescodeDBParam.set_se_cityid(user.getCityid());
		DataPackage crDP = cityrescodeBO.doQuery(cityrescodeDBParam);
		Map<String,String> category2Res = new HashMap<String,String>();//��Ʒ����-->������Դ���룬��Ӧ��ϵ
		for(int i = 0;i<cardList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO cvo = (CanorderinfoVO)cardList.get(i);
			if (null == crDP
					|| null == crDP.getDatas()
					|| crDP.getDatas().size() < 1){
				
			}else{
				List litTmp = crDP.getDatas();
				if(litTmp != null && !"".equals(litTmp) 
						&& litTmp.size() > 0){
					for(int j=0 ; j<litTmp.size() ; j++){
						CityrescodeVO cityrescodeVO = (CityrescodeVO)litTmp.get(j);
						if(cityrescodeVO.getComcategory().equals(cvo.getCardtype())){
							brandFlag = true;
							if(!category2Res.containsKey(cvo.getCardtype()))
								category2Res.put(cvo.getCardtype(), cityrescodeVO.getCityrescode());
						}
					}
				}
			}
			if(!brandFlag){
				String errStr4 = "��ֵ��["+cvo.getCardtype()+"]δ���ö�Ӧ�ĵ�����Դ���룬����ϵϵͳ����Ա��顣";
				
				throw new Exception(errStr4);
			}
		}
		
		//�Կɶ��������Ͻ��б���(�հ�SIM��)
		CityrescodeBO cityrescodeBO1 = (CityrescodeBO) BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cityrescodeDBParam1 = new CityrescodeDBParam();
		cityrescodeDBParam1.setDataOnly(true);
		cityrescodeDBParam1.setQueryAll(true);
		cityrescodeDBParam1.set_se_cityid(user.getCityid());
		DataPackage crDP1 = cityrescodeBO.doQuery(cityrescodeDBParam1);
		Map<String,String> category3Res = new HashMap<String,String>();//��Ʒ����-->������Դ���룬��Ӧ��ϵ
		for(int i = 0;i<emptyList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO cvo = (CanorderinfoVO)emptyList.get(i);
			if (null == crDP1
					|| null == crDP1.getDatas()
					|| crDP1.getDatas().size() < 1){
				
			}else{
				List litTmp = crDP1.getDatas();
				if(litTmp != null && !"".equals(litTmp) 
						&& litTmp.size() > 0){
					for(int j=0 ; j<litTmp.size() ; j++){
						CityrescodeVO cityrescodeVO = (CityrescodeVO)litTmp.get(j);
						if(cityrescodeVO.getComcategory().equals(cvo.getCardtype())){
							brandFlag = true;
							if(!category3Res.containsKey(cvo.getCardtype()))
								category3Res.put(cvo.getCardtype(), cityrescodeVO.getCityrescode());
						}
					}
				}
			}
			if(!brandFlag){
				String errStr4 = "�հ�SMIN��["+cvo.getCardtype()+"]δ���ö�Ӧ�ĵ�����Դ���룬����ϵϵͳ����Ա��顣";
				
				throw new Exception(errStr4);
			}
		}
		
		//��ȡ�������������ն�����
		Map<String,Long> brandRes2Canorder = new HashMap<String,Long>();//������Դ���루�׿�Ʒ�ƣ�-->���ն���������Ӧ��ϵ
		Map<String,Long> cityRes2Canorder = new HashMap<String,Long>();//������Դ���루��ֵ����-->���ն���������Ӧ��ϵ
		Map<String,Long> cityRes3Canorder = new HashMap<String,Long>();//������Դ���루��ֵ����-->���ն���������Ӧ��ϵ
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		for(int i = 0;i<brandList.size();i++){//�׿�Ʒ��
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(i);
			
			if(bvo.getBrand() != null && !"".equals(bvo.getBrand()) && bvo.getBrand().indexOf(",")>=0){
				//����Ʒ�ƣ�ȡ��һ��Ʒ�ƵĶ�������ΪĬ�ϵĶ�������
				String rcBrands[] = bvo.getBrand().split(",");
				String unitage = comorder.doGetUnitage(user.getCityid(), 
						(String)brand2Comcategory.get(rcBrands[0]));
				long lastOrder = 0;
				if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
						&& bvo.getCanorder() != null && !"".equals(bvo.getCanorder()))
					lastOrder = ((long)(bvo.getCanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
				
				brandRes2Canorder.put((String)brand2Res.get(bvo.getBrand()), lastOrder);
			}else{
				//�ǹ���Ʒ��
				String unitage = comorder.doGetUnitage(user.getCityid(), 
						(String)brand2Comcategory.get(bvo.getBrand()));
				long lastOrder = 0;
				if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
						&& bvo.getCanorder() != null && !"".equals(bvo.getCanorder()))
					lastOrder = ((long)(bvo.getCanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
				brandRes2Canorder.put((String)brand2Res.get(bvo.getBrand()), new Long(lastOrder));
			}
		}
		for(int i = 0;i<cardList.size();i++){//��ֵ��
			CanorderinfoVO cvo = (CanorderinfoVO)cardList.get(i);
			
			String unitage = comorder.doGetUnitage(user.getCityid(), 
					cvo.getCardtype());
			long lastOrder = 0;
			if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
					&& cvo.getCardcanorder() != null && !"".equals(cvo.getCardcanorder()))
				lastOrder = ((long)(cvo.getCardcanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
			cityRes2Canorder.put(category2Res.get(cvo.getCardtype()), new Long(lastOrder));
			
		}
		
		for(int i = 0;i<emptyList.size();i++){//�հ�SIM��
			CanorderinfoVO cvo = (CanorderinfoVO)emptyList.get(i);
			
			String unitage = comorder.doGetUnitage(user.getCityid(), 
					cvo.getCardtype());
			long lastOrder = 0;
			if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
					&& cvo.getCardcanorder() != null && !"".equals(cvo.getCardcanorder()))
				lastOrder = ((long)(cvo.getCardcanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
			cityRes3Canorder.put(category3Res.get(cvo.getCardtype()), new Long(lastOrder));
			
		}
		
		//��ȡ���Ž��պ���Ϳͻ�����
		EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(wayvo.getWayid());//ƥ������������ں����̱���
		employeeDBParam.set_se_isnet(Short.parseShort("1"));//�Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1��
		employeeDBParam.set_se_empstatus(Short.parseShort("0"));//�ù�״̬Ϊ�ڸڣ���EMPSTATUS=0��
		DataPackage employeeDP = employeeBO.doQuery(employeeDBParam);
		String employeename = "�ͻ�";
		String officetel = "";
		String errStr5 = "��ȡ������["+wayvo.getWayid()+"]���������ʧ�ܣ�����ú����̻������ϡ�";
		if (null != employeeDP && !"".equals(employeeDP)
				&& null != employeeDP.getDatas() && !"".equals(employeeDP.getDatas())
				&& employeeDP.getDatas().size() > 0){
			EmployeeVO employeeVO = (EmployeeVO)employeeDP.getDatas().get(0);
			if(employeeVO.getEmployeename() != null 
					&& !"".equals(employeeVO.getEmployeename())){
				employeename = employeeVO.getEmployeename();
			}
			if(employeeVO.getOfficetel() != null 
					&& !"".equals(employeeVO.getOfficetel())){
				officetel = employeeVO.getOfficetel();
				if(officetel.length() != 11){					
					throw new Exception(errStr5);
				}
			}else{
				throw new Exception(errStr5);
			}			
		}else{			
			throw new Exception(errStr5);
		}
		String orderCom = "";
		
		Iterator iter = brandRes2Canorder.keySet().iterator();
		while (iter.hasNext()) {
		    String key = (String)iter.next();
		    Long val = brandRes2Canorder.get(key);
		    if(val != null && val.longValue() > 0){
			    if(key != null && !"".equals(key) && key.indexOf(",")>=0){
			    	//����Ʒ��
			    	String key1 = "(" + key.replaceAll(",", "+") + ")";
			    	orderCom = orderCom + key1 + val;
			    }else{
			    	//�ǹ���Ʒ��
			    	orderCom = orderCom + key + val;
			    }
		    }
		}
		iter = cityRes2Canorder.keySet().iterator();
		while (iter.hasNext()) {
		    Object key = iter.next();
		    Long val = cityRes2Canorder.get(key);
		    if(val != null && val.longValue() > 0){
		    	orderCom = orderCom + key + val;
		    }
		}
		
		sContentString = new String(sContentString);
		Map<String,String> keyAndValue = new HashMap<String,String>();
		keyAndValue.put("CUSTNAME", employeename);
		keyAndValue.put("WAYID", wayvo.getWayid());
		keyAndValue.put("ORDERCOM", orderCom);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String content = smstmplBO.doGenSMS("FX_ORDER_NOTICE",sContentString,keyAndValue);
		
		coiVO.setSmsContent(content);
		coiVO.setOfficetel(officetel);
		
		return coiVO;
	}
	
	/**
	 * ���ݱ�ʶ��FX_ORDER_NOTICE������Ч״̬��1����ѯ����ģ���
	 * ��CH_SMS_SMSTMPL������ȡģ�����ݣ���������ݻ�����Ϊ�գ�����ʾ���˳�
	 */	
	public String getSmsContent() throws Exception{
			
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_NOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			
			return "";
		}
			
		SmstmplVO smstmplVO = (SmstmplVO) dp.getDatas().get(0);
		
		return smstmplVO.getScontent();
	}

	public List doQueryBrand(List brandList, DBAccessUser user,WayVO wayvo) throws Exception {
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		//��������-->��ȡ�׿�Ʒ�Ƽ���
		List<DictitemVO> brandlist1 = comorder.doGetBrandList(wayid);
				
		//��ȡ�׿�������Ϣ��Ԥ����棩
		List<OrderStockalarmVO> orderStockalarmList = comorder
			.doGetOrderInfoByStockalarm(wayvo,brandlist1);			
		if(orderStockalarmList != null 
				&& !"".equals(orderStockalarmList)
				&& orderStockalarmList.size()>0){
			for(int i=0; i<orderStockalarmList.size(); i++){
				OrderStockalarmVO orderStockalarmVO = (OrderStockalarmVO)orderStockalarmList.get(i);
				
				CanorderinfoVO bvo = new CanorderinfoVO();
				bvo.setBrand(orderStockalarmVO.getBrand());
				bvo.setBrandName(orderStockalarmVO.getBrandsName());
				bvo.setCanorder(0L);	//�ɶ�����
				bvo.setMaxorder(0L);	//��߿��
				bvo.setCurorder(0L);	//��ǰ���
				bvo.setThrmonavg(0d);	//ǰ����ƽ��������
				bvo.setSixmonavg(0d);	//ǰ����ƽ�������� 
				bvo.setReferdata("");	//�ο����� 
				bvo.setCanorder((orderStockalarmVO.getMaxStock()
						-orderStockalarmVO.getNowstock()));
				if(bvo.getCanorder()<0){
					bvo.setCanorder(0L);
				}
				bvo.setMaxorder(orderStockalarmVO.getMaxStock());
				bvo.setCurorder(orderStockalarmVO.getNowstock());
				
				brandList.add(bvo);
				
			}
		}
					
		//��ȡ�ο�����
		int intervalThr = 3;
		doStat(brandList,intervalThr,wayid,user);
		int intervalSix = 6;
		doStat(brandList,intervalSix,wayid,user);
		List brandListTmp = new ArrayList<CanorderinfoVO>();
		for(int j = 0;j<brandList.size();j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(j);
			brandListTmp.add(bvo);
		}
		for(int j = 0;j<brandListTmp.size();j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandListTmp.get(j);
			if(bvo.getCanorder() == 0 && bvo.getMaxorder() == 0
					&& bvo.getCurorder() == 0 && bvo.getThrmonavg() == 0
					&& bvo.getSixmonavg() == 0 ){
				brandList.remove(bvo);
			}
		}
		
		return brandList;
	}
	
	/**
	 * ǰ����ƽ������������ǰ����ƽ�������� ��ͳ��
	 * 
	 * 
	 * @param brandList	Ʒ���б�
	 * @param interval	ǰ��6���¡���ǰ��3����
	 * @param wayid		�����̱���
	 * @throws Exception
	 */
	public void doStat(List brandList,int interval,String wayid,DBAccessUser user) throws Exception{
		Date[] periodTime = PublicUtils.getMonthPeriod(new Date(), interval);			
		CanorderinfoDBParam canorderinfoParams = new CanorderinfoDBParam();
		canorderinfoParams.setDataOnly(true);
		canorderinfoParams.setQueryAll(true);
		canorderinfoParams.setWayid(wayid);
		canorderinfoParams.setBegintime(periodTime[0]);
		canorderinfoParams.setEndtime(periodTime[1]);
		canorderinfoParams.setSelectFieldsString("month,brand,count");
		Canorderinfo canorderinfoBO = (Canorderinfo)BOFactory.build(CanorderinfoBO.class,user);
		List canorderinfoList= canorderinfoBO.doStatPartnerres(canorderinfoParams);
		Map<String,List> brandGroup = new HashMap<String,List>();//��Ʒ�Ʒ������׿�����������ͳ��
		if (null == canorderinfoList || "".equals(canorderinfoList)
				|| canorderinfoList.size() < 1){
			//������
		}else{
			for(int i=0; i<canorderinfoList.size(); i++){
				Object[] tmpList = (Object[])canorderinfoList.get(i);
					if(brandGroup.containsKey(tmpList[1])){
						List ll = brandGroup.get((String)tmpList[1]);
						ll.add(tmpList);
					}else{
						List ll = new ArrayList();
						ll.add(tmpList);
						
						brandGroup.put((String)tmpList[1], ll);
					}
			}
		}
		for(int j = 0; j<brandList.size(); j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(j);
			if(bvo.getBrand().indexOf(",")>=0){//����Ʒ��
				Map brandMap = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
				
				List referdataList = new ArrayList();
				String rcBrands[] = bvo.getBrand().split(",");
				String allBr = "";
				long count = 0;
				if(rcBrands != null && !"".equals(rcBrands) && rcBrands.length > 0){
					for(int k=0 ; k<rcBrands.length ; k++){
						String inBra = rcBrands[k];//����Ʒ����ÿ��Ʒ��
						if(brandGroup.containsKey(inBra)){
							List ll = brandGroup.get(inBra);
							
							SimpleDateFormat sdf0 = new SimpleDateFormat("yyyyMM");
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM�� ");
							
							for(int l = 0; l<ll.size(); l++){
								Object[] tmpList = (Object[])ll.get(l);
								if(tmpList[2] != null && !"".equals(tmpList[2])){
									count = count + Integer.parseInt(tmpList[2].toString());
								}
								//�ο����ݣ�����
								if(tmpList[0] != null && !"".equals(tmpList[0])){
									Date date = sdf0.parse(tmpList[0].toString());
									String rd = sdf1.format(date) + (String)brandMap.get(inBra) + " " + tmpList[2] ;
									CanorderinfoVO cv = new CanorderinfoVO();
									cv.setReferdata(rd);
									referdataList.add(cv);
								}
							}
						}
					}
				}
				
//				NumberFormat nf = NumberFormat.getIntegerInstance();
//				nf.setMinimumFractionDigits(2);//ָ��С��λ��
				DecimalFormat df = new DecimalFormat("#.##");
				if(interval == 3){
					bvo.setThrmonavg(new Double(df.format((double)(1.0*count/rcBrands.length/interval))));
				}
				if(interval == 6){
					//�ο����ݣ�����
					bvo.setReferdataList(referdataList);
					bvo.setSixmonavg(new Double(df.format((double)(1.0*count/rcBrands.length/interval))));
				}
			}else{
				doStat1(brandGroup, bvo.getBrand(), bvo, interval);
			}
		}
	}
	
	public void doStat1(Map<String,List> brandGroup, String brand, CanorderinfoVO bvo, int interval) throws Exception{
		if(brandGroup.containsKey(brand)){
			List ll = brandGroup.get(brand);
			long count = 0;
			SimpleDateFormat sdf0 = new SimpleDateFormat("yyyyMM");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM�� ");
			
			List referdataList = new ArrayList();
			for(int k = 0; k<ll.size(); k++){
				Object[] tmpList = (Object[])ll.get(k);
				if(tmpList[2] != null && !"".equals(tmpList[2])){
					count = count + Integer.parseInt(tmpList[2].toString());
				}
				//�ο����ݣ�����
				if(tmpList[0] != null && !"".equals(tmpList[0])){
					Date date = sdf0.parse(tmpList[0].toString());
					String rd = sdf1.format(date) + tmpList[2] ;
					CanorderinfoVO cv = new CanorderinfoVO();
					cv.setReferdata(rd);
					referdataList.add(cv);
				}
			}
			
//			NumberFormat nf = NumberFormat.getIntegerInstance();
//			nf.setMinimumFractionDigits(2);//ָ��С��λ��
			DecimalFormat df = new DecimalFormat("#.##");
			if(interval == 3){
				bvo.setThrmonavg(new Double(df.format((double)(1.0*count/interval))));
			}
			if(interval == 6){
				//�ο����ݣ�����
				bvo.setReferdataList(referdataList);
				bvo.setSixmonavg(new Double(df.format((double)(1.0*count/interval))));
			}
		}
	}
	
	public List doQueryStock(List cardList, DBAccessUser user, WayVO wayvo) throws Exception {
		// TODO Auto-generated method stub
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		
		List<OrderCardVO> orderCardList = comorder.doGetOrderInfoByCard(wayvo);
		if(orderCardList != null && !"".equals(orderCardList)
				&& orderCardList.size() > 0){
			for(int i = 0;i<orderCardList.size();i++){
				OrderCardVO ocVO = orderCardList.get(i);
				CanorderinfoVO cvo = new CanorderinfoVO();
				
				cvo.setCardtype(ocVO.getComcategory());				//��ֵ������
				
				/*
				 * �ڻ�ȡoncelimitʱ������ΪnullʱΪ0, �������ﴦ���ʱ�� ���oncelimitΪ0ʱ��
				 * �ɶ�������ȡocVO.getOrderRemainMonth()  ocVO.getOrderRemainDay() 
				 * �е���Сֵ
				 * 
				 * �ɶ�����ȡ����ʣ�ඩ����������ʣ�ඩ�����͵��ζ���������������Сֵ
				 */				
				//cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
				if(ocVO.getOncelimit() == null || "".equals(ocVO.getOncelimit())
						|| ocVO.getOncelimit() == 0){
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
					}else{
						cvo.setCardcanorder(ocVO.getOrderRemainDay());	//�ɶ�����
					}
				}else{
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						if(ocVO.getOrderRemainMonth() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//�ɶ�����
						}
					}else{
						if(ocVO.getOrderRemainDay() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainDay());	//�ɶ�����
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//�ɶ�����
						}
					}
				}
				
				cvo.setCardmonlim(ocVO.getOrderMaxMonth());			//�¶�������
				cvo.setCarddaylim(ocVO.getOrderMaxDay());			//�ն������� 
				cvo.setCardtimelim(ocVO.getOncelimit());		//���ζ�������
				cvo.setCardmonordered(ocVO.getOrderedMonth());		//�����Ѷ���
				cvo.setCarddayordered(ocVO.getOrderedDay());		//�����Ѷ��� 
				
				if(cvo.getCardcanorder()<0){
					cvo.setCardcanorder(0L);
				}
				
				cardList.add(cvo);
			}
		}
		
		return cardList;
	}

	//��ȡ�հ�SIM��������Ϣ
	public List doQueryEmpty(List emptyList, DBAccessUser user, WayVO wayvo) throws Exception {
		// TODO Auto-generated method stub
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		
		List<OrderCardVO> orderCardList = comorder.doGetOrderInfoByEmptyCard(wayvo);
		if(orderCardList != null && !"".equals(orderCardList)
				&& orderCardList.size() > 0){
			for(int i = 0;i<orderCardList.size();i++){
				OrderCardVO ocVO = orderCardList.get(i);
				CanorderinfoVO cvo = new CanorderinfoVO();
				
				cvo.setCardtype(ocVO.getComcategory());				//��ֵ������
				
				/*
				 * �ڻ�ȡoncelimitʱ������ΪnullʱΪ0, �������ﴦ���ʱ�� ���oncelimitΪ0ʱ��
				 * �ɶ�������ȡocVO.getOrderRemainMonth()  ocVO.getOrderRemainDay() 
				 * �е���Сֵ
				 * 
				 * �ɶ�����ȡ����ʣ�ඩ����������ʣ�ඩ�����͵��ζ���������������Сֵ
				 */				
				//cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
				if(ocVO.getOncelimit() == null || "".equals(ocVO.getOncelimit())
						|| ocVO.getOncelimit() == 0){
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
					}else{
						cvo.setCardcanorder(ocVO.getOrderRemainDay());	//�ɶ�����
					}
				}else{
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						if(ocVO.getOrderRemainMonth() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//�ɶ�����
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//�ɶ�����
						}
					}else{
						if(ocVO.getOrderRemainDay() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainDay());	//�ɶ�����
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//�ɶ�����
						}
					}
				}
				
				cvo.setCardmonlim(ocVO.getOrderMaxMonth());			//�¶�������
				cvo.setCarddaylim(ocVO.getOrderMaxDay());			//�ն������� 
				cvo.setCardtimelim(ocVO.getOncelimit());		//���ζ�������
				cvo.setCardmonordered(ocVO.getOrderedMonth());		//�����Ѷ���
				cvo.setCarddayordered(ocVO.getOrderedDay());		//�����Ѷ��� 
				
				if(cvo.getCardcanorder()<0){
					cvo.setCardcanorder(0L);
				}
				
				emptyList.add(cvo);
			}
		}
		
		return emptyList;
	}
	
	public String doCheckWayAndModel(DBAccessUser user, WayVO wayvo, String wayid)
			throws Exception {
		//�����̼��
		Way way = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayParams = new WayDBParam();
		wayParams.set_se_cityid(user.getCityid());
		wayParams.set_se_wayid(wayid);
		wayParams.set_se_waytype("AG");//�����������WAYTYPE=AG)
		DataPackage wayDp= way.doQuery(wayParams);
		//WayVO wayvo = null;//��������Ϣ
		if (null == wayDp
				|| null == wayDp.getDatas()
				|| wayDp.getDatas().size() < 1){
			//������
			String errStr1 = "��������Ϣ�����ڣ���������̱����Ƿ���ȷ";
			
			throw new Exception(errStr1);
			
			
		}else{
			WayVO wayvo1 = (WayVO)wayDp.getDatas().get(0);
			BeanUtils.copyProperties(wayvo, wayvo1);
		}
		
		if (wayvo.getWaystate() != 1) {
			throw new Exception("������״̬��Ϊ����״̬");
		}
		
		if(wayvo.getCountyid() == null || "".equals(wayvo.getCountyid()) ||
				wayvo.getStarlevel() == null || "".equals(wayvo.getStarlevel())){
			String errStr2 = "��������Ϣ�����������顣";
			
			throw new Exception(errStr2);
			
		}
		
		//��������-->��ȡ������Լ��ģʽ
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String sysparamvalue45 = sysparamBO.doFindByID("45", "pboss_fx");
		String errStr2 = "������Լ��ģʽ���������ݣ�����ϵϵͳ����Ա���м�顣";
		if(sysparamvalue45 == null || "".equals(sysparamvalue45)){			
			
			throw new Exception(errStr2);
			
			
		}else{
			if(!sysparamvalue45.equals("STOCKALARM")){
				errStr2 = "������Լ����Ԥ�����ģʽ������ϵϵͳ����Ա���м�顣";
				
				throw new Exception(errStr2);
								
			}
		}
		
		return "";
	}
}
