package com.gmcc.pboss.service.control.goodsresource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.business.sales.resdetview.ResdetviewDBParam;
import com.gmcc.pboss.business.sales.resdetview.ResdetviewVO;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.gmcc.pboss.control.sales.resdetview.Resdetview;
import com.gmcc.pboss.control.sales.resdetview.ResdetviewBO;
import com.gmcc.pboss.control.sales.smpextramid.Smpextramid;
import com.gmcc.pboss.control.sales.smpextramid.SmpextramidBO;
import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.GoodsResource;
import com.gmcc.pboss.service.result.goods.SCPackage;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * ��Ʒ��Դ��ȡ�ӿ�
 * @author Canigar
 *
 */
public class GainGoodsResourceBO extends AbstractControlBean implements GainGoodsResource{

	private static Logger logger = Logger.getLogger(GainGoodsResourceBO.class);
	
	//step1 �������ϲ�ѯ
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("�ú�����["+wayid+"]������Ϣ������",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	
	//step2 ��Ʒ����״̬
	private void doGoodsBookState(String comType) throws Exception{
		Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, user);
		ComorderstateDBParam params = new ComorderstateDBParam();
		params.set_se_cityid(user.getCityid());
		params.set_se_comcategory(comType);
		DataPackage dp = comorderstate.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			//ͳһ��ʽ���� do nothing
		}else{
			ComorderstateVO vo = (ComorderstateVO)dp.getDatas().get(0);
			if(!"NORMAL".equals(vo.getOrderstate())){
				throw new WebSiteException(vo.getMsgcontent(),RetResult.FAILURE);
			}
		}
	}
	
	//step3 ��ȡ��Դ��ϸ�鿴����
	private void doGainResourcesDetailsFrequence(String wayid, String comType) throws Exception{
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String sysvalue = sysparam.doFindByID("16", "pboss_fx");
		if(StringUtils.isEmpty(sysvalue)){
			throw new WebSiteException("��Դ��ϸ�鿴��������δ���ã�����ϵ����Ա",RetResult.FAILURE);
		}
		Resdetview resdetview = (Resdetview)BOFactory.build(ResdetviewBO.class, user);
		ResdetviewDBParam resparams = new ResdetviewDBParam();
		resparams.set_se_wayid(wayid);
		resparams.set_se_comcategory(comType);
		DataPackage resDp = resdetview.doQuery(resparams);
		if(resDp.getDatas() == null || resDp.getDatas().size() == 0){
			
		}else{//������
			ResdetviewVO resvo = (ResdetviewVO)resDp.getDatas().get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			if(sdf.format(new Date()).equals(sdf.format(resvo.getUpdatedate()))){ //�������ʱ����Ϊ����
				if(resvo.getTimes().shortValue() >= Short.parseShort(sysvalue)){
					throw new WebSiteException("��ѯ������������",GoodsResource.OVER_QUERY_LIMIT_TIMES);
				}
			}
		}
	}
	
	//step4 ��ȡ�׿�Ʒ��
	private String doGainCardBrand(String wayid,String comType) throws Exception{
		Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
		ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
		params.set_se_comcategory(comType);
		DataPackage dp = comcategoryrela.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("�׿�Ʒ�Ʋ�����",RetResult.FAILURE);
		}
		ComcategoryrelaVO vo = (ComcategoryrelaVO)dp.getDatas().get(0);
		if(!"COMRESSMP".equals(vo.getRestype())){
			throw new WebSiteException("ֻ���׿���Դ���ܽ��в�ѯ",RetResult.FAILURE);
		}else{
			doCardActivityRatio(wayid,vo.getBrand()); //step5
		}
		return vo.getBrand();
	}
	
	//step5 ����׿�������
	private void doCardActivityRatio(String wayid, String brand) throws Exception{
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String sysvalue = sysparam.doFindByID("12", "pboss_fx");
		if(StringUtils.isEmpty(sysvalue)){
			throw new WebSiteException("�Ƿ�����Ʒ�Ʋ���δ���ã�����ϵ����Ա",RetResult.FAILURE);
		}
		/*Activerate activerate = (Activerate)BOFactory.build(ActiverateBO.class, user);
		ActiverateDBParam params = new ActiverateDBParam();*/
		List<ActiverateVO> activerateList=null;
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		try {
			//��ȡ�׿�Ʒ�Ƽ���
			List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);

			// �����׿���������Ϣ
			activerateList = comorder.doGetActiveList(wayid,brandlist);
			
		} catch (Exception e) {
			throw new WebSiteException("�ú�����["+wayid+"]�׿���������Ϣ����",3);
		}
		
		
		if(activerateList == null || activerateList.size() == 0){
			throw new WebSiteException("�ú�����["+wayid+"]�׿����������ݲ�����",RetResult.FAILURE);
		}else{
			ActiverateVO vo = activerateList.get(0);
			if(0 == vo.getIsachieve()){
				throw new WebSiteException("������δ���",RetResult.FAILURE);
			}
		}
		/*if("1".equals(sysvalue)){
			params.set_se_brand(brand);
		}else{
			params.set_se_brand("AllBrand");
		}
		params.set_se_wayid(wayid);
		DataPackage dp = activerate.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("�ú�����["+wayid+"]�׿����������ݲ�����",RetResult.FAILURE);
		}else{
			ActiverateVO vo = (ActiverateVO)dp.getDatas().get(0);
			if(0 == vo.getIsachieve()){
				throw new WebSiteException("������δ���",RetResult.FAILURE);
			}
		}*/
	}
	
	
	//step6	�����̲�ѯ
	private String doQueryDistributor() throws Exception{ 
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String sysvalue = sysparam.doFindByID("21", "pboss_fx");
		if(StringUtils.isEmpty(sysvalue)){
			throw new WebSiteException("������Դ�Ƿ���������̲���δ���ã�����ϵ����Ա",RetResult.FAILURE);
		}
		return sysvalue;
		//��¼�Ƿ���������̲���������һ��
	}
	
	//step7 ��ȡ�׿�Ʒ�ư���С
	private String doGainCardbrandPackage(String brand) throws Exception{
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		SysparamDBParam sysparams = new SysparamDBParam();
		sysparams.set_ne_systemid("5");
		sysparams.set_se_paramtype("pboss_fx");
		DataPackage sysDp = sysparam.doQuery(sysparams);
		if(sysDp.getDatas() == null || sysDp.getDatas().size() == 0){
			throw new WebSiteException("�׿�Ʒ�ư���С����δ���ã�����ϵ����Ա",RetResult.FAILURE);
		}
		SysparamVO sysvo = (SysparamVO)sysDp.getDatas().get(0);
		String[] strs = StringUtils.split(sysvo.getParamvalue(), "|");
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0; i<strs.length; i++){
			String str = strs[i];
			map.put(str.substring(0, str.indexOf(":")), str.substring(str.indexOf(":")+1));
		}
		if(map.get(brand) == null){
			throw new WebSiteException("�׿�Ʒ��["+brand+"]����С����δ���ã�����ϵ����Ա",RetResult.FAILURE);
		}
		return map.get(brand);
		//ƥ��ɹ����¼����С������һ��
	}
	
	//step8 ��ȡ��Դ��ȡ�Ŵ���
	private String doGainResourceEnlargeMultiple() throws Exception{
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		SysparamDBParam sysparams = new SysparamDBParam();
		sysparams.set_ne_systemid("17");
		sysparams.set_se_paramtype("pboss_fx");
		DataPackage sysDp = sysparam.doQuery(sysparams);
		if(sysDp.getDatas() == null || sysDp.getDatas().size() == 0){
			return "1";
		}
		SysparamVO sysvo = (SysparamVO)sysDp.getDatas().get(0);
		return sysvo.getParamvalue();
	}
	
	//step9 ��ȡ���β�ѯ��ϸ�������
	private String doGainQueryDetailsBiggestQuanlityOnce() throws Exception{
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		SysparamDBParam sysparams = new SysparamDBParam();
		sysparams.set_ne_systemid("18");
		sysparams.set_se_paramtype("pboss_fx");
		DataPackage sysDp = sysparam.doQuery(sysparams);
		if(sysDp.getDatas() == null || sysDp.getDatas().size() == 0){
			return "300";
		}
		SysparamVO sysvo = (SysparamVO)sysDp.getDatas().get(0);
		return sysvo.getParamvalue();
	}
	
	//step10 ȷ����ȡ��Ʒ������
	private String doSureGoodsPackageQuanlity(String brand, int orderCount) throws Exception{
		Double detailsQuanlity = orderCount * Double.parseDouble(doGainResourceEnlargeMultiple()); //��ȡ��ϸ����
		String maxQuanlity = doGainQueryDetailsBiggestQuanlityOnce();  //��ȡ���β�ѯ��ϸ�������
		if(detailsQuanlity > Double.parseDouble(maxQuanlity)){ 
			//������ڵ��β�ѯ������������ȡ��ϸ����ȡ���β�ѯ�������
			detailsQuanlity = Double.parseDouble(maxQuanlity);
		}
		//��Ʒ������=��ȡ��ϸ����/Ʒ�ư���С
		Double goodsPackageQuanlity = Math.ceil(detailsQuanlity / Double.parseDouble(doGainCardbrandPackage(brand))); 
		return goodsPackageQuanlity.toString();
	}
	
	//step11 ��ȡ��Դ����
	private String doGainResourceDistrict(String wayid) throws Exception{
		Way way = (Way)BOFactory.build(WayBO.class, user);
		WayVO vo = way.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		return comorder.doGetStorArea(vo);
	}
	
	//step12 ��Ʒ����ȡ
	private List<SCPackage> doGainGoodsPackage(String wayid, String comType, int orderCount) throws Exception{
		//comType ��ȡ��Ʒ����
		String brand = doGainCardBrand(wayid,comType); //��ȡƷ��
		
		String cardbrandPackage = doGainCardbrandPackage(brand); //��Ʒ�����������׿�Ʒ�ư���С��
		String packstate = "1"; //����
		String fxresuse = "NORMAL"; //��Դ��;���ճ�������
		String district = doGainResourceDistrict(wayid); //��������
		String isdistributor = doQueryDistributor(); //���������̣�������ʱʡ�ԣ� 
		String cardbrandPackageQuanlity = doSureGoodsPackageQuanlity(brand,orderCount);
		
		Compack compack = (Compack)BOFactory.build(CompackBO.class, user);
		CompackDBParam compackParam = new CompackDBParam();
		compackParam.set_se_comcategory(comType);
		compackParam.set_ne_amount(Short.parseShort(cardbrandPackage));
		compackParam.set_se_packstate(packstate);
		compackParam.set_se_resuse(fxresuse);
		compackParam.set_se_storarea(district);
		compackParam.set_pagesize(cardbrandPackageQuanlity);
		if("1".equals(isdistributor)){
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam params = new WayDBParam();
			params.set_se_wayid(wayid);
			params.set_se_waytype("AG");
			DataPackage dp = way.doQuery(params);
			compackParam.set_se_discomcode(((WayVO)dp.getDatas().get(0)).getLogiscode()); 
		}
		DataPackage dp = compack.doQuery(compackParam);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("��Ʒ��Դ������",RetResult.FAILURE);
		}
		
		List<CompackVO> list = dp.getDatas();
		
		Smpextramid smpextramid = (Smpextramid)BOFactory.build(SmpextramidBO.class, user);
		Date date = new Date();
		for(Iterator<CompackVO> itt = list.iterator(); itt.hasNext(); ){
			CompackVO vo = (CompackVO)itt.next();
			vo.setPackstate("5");
			compack.doUpdate(vo);
			
			SmpextramidVO idvo = new SmpextramidVO();
			idvo.setWayid(wayid);
			idvo.setComcategory(comType);
			idvo.setBatchno(vo.getBatchno());
			idvo.setBoxnum(vo.getBoxnum());
			idvo.setExtratime(date);
			idvo.setValidflag((short)1);
			smpextramid.doCreate(idvo);
		}
		
		//����List
		List<SCPackage> scPackages = new ArrayList<SCPackage>();
		Comressmp comressmp = (Comressmp)BOFactory.build(ComressmpBO.class, user);
		for(Iterator<CompackVO> itt = list.iterator(); itt.hasNext(); ){
			CompackVO vo = (CompackVO)itt.next();
			SCPackage pack = new SCPackage();
			pack.setBatchNo(vo.getBatchno());
			pack.setPackageNo(vo.getBoxnum());
			
			ComressmpDBParam params = new ComressmpDBParam();
			params.set_se_batchno(vo.getBatchno());
			params.set_se_boxnum(vo.getBoxnum());
			DataPackage smpDp = comressmp.doQuery(params);
			String[] mobiles = null;
			if(smpDp.getDatas() == null || smpDp.getDatas().size() == 0){
				//do nothing
			}else{
				List<String> mobileList = new ArrayList<String>();
				for(Iterator<ComressmpVO> smpItt = smpDp.getDatas().iterator(); smpItt.hasNext(); ){
					mobileList.add(smpItt.next().getComresid());
				}
				mobiles = mobileList.toArray(new String[mobileList.size()]);
			}
			pack.setMobiles(mobiles);
			scPackages.add(pack);
		}
		return scPackages;
	}
	
	//step13 �Ǽ���Դ��ϸ�鿴������¼��
	private void doUpdateResdetview(String wayid, String comType) throws Exception{
		Resdetview resdetview = (Resdetview)BOFactory.build(ResdetviewBO.class, user);
		ResdetviewDBParam resparams = new ResdetviewDBParam();
		resparams.set_se_wayid(wayid);
		resparams.set_se_comcategory(comType);
		DataPackage resDp = resdetview.doQuery(resparams);
		if(resDp.getDatas() == null || resDp.getDatas().size() == 0){
			ResdetviewVO vo = new ResdetviewVO();
			vo.setWayid(wayid);
			vo.setComcategory(comType);
			vo.setTimes((short)1);
			vo.setUpdatedate(new Date());
			resdetview.doCreate(vo);
		}else{
			ResdetviewVO vo = (ResdetviewVO)resDp.getDatas().get(0);
			vo.setTimes((short)(vo.getTimes()+1));
			vo.setUpdatedate(new Date());
			resdetview.doUpdate(vo);
		}
	}
	
	private GoodsResource doReturnSuccVal(String wayid, String comType, int orderCount) throws Exception{
		GoodsResource result = new GoodsResource();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage("�ɹ�");
		result.setGoodsList(doGainGoodsPackage(wayid,comType,orderCount));
		return result;
	}
	
	
	public GoodsResource doGain(String wayid, String comType, int orderCount) throws Exception{
		try{
			doBasicQualification(wayid);
			doGoodsBookState(comType);
			doGainResourcesDetailsFrequence(wayid,comType);
			GoodsResource result = doReturnSuccVal(wayid,comType,orderCount);
			doUpdateResdetview(wayid,comType);
			return result;
		}catch (Exception e) {
			throw e;
		}
	}
	
}
