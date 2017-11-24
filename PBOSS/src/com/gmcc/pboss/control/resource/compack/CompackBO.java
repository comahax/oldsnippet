/**
 * auto-generated code
 * Fri Sep 25 15:08:39 CST 2009
 */
package com.gmcc.pboss.control.resource.compack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.ComcategoryInfo;
import com.gmcc.pboss.business.resource.compack.CompackDAO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackPriterInfo;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.NumberTypeInfo;
import com.gmcc.pboss.business.resource.compack.PackMobilePrinterInfo;
import com.gmcc.pboss.business.resource.compack.PackResourceInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.numtypedef.Numtypedef;
import com.gmcc.pboss.control.resource.numtypedef.NumtypedefBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CompackBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class CompackBO extends AbstractControlBean implements
		Compack {
		private Logger log = Logger.getLogger(CompackBO.class);
	public CompackVO doCreate(CompackVO vo) throws Exception {
		try {
			CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class, user);
			// TODO set the pk */
			return (CompackVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CompackVO vo) throws Exception {
		try {
			CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompackVO doUpdate(CompackVO vo) throws Exception {
		try {
			CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
			return (CompackVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompackVO doFindByPk(Serializable pk) throws Exception {
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		return (CompackVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CompackDBParam params)
			throws Exception {
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryBynameSql(String sqlName,DBQueryParam params)throws Exception {
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		return dao.queryByNamedSqlQuery(sqlName, params);	
	}
	/**
	 * ��ȡ��Ʒ����ȡ���ܵ���Ʒ��(��������Ĺ����Ի�ȡ��Ʒ�������ֹ�˾)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryCompackResdraw(CompackDBParam param,String countyid,String svccode,String mareacode)throws Exception {
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		return dao.doQueryCompackResdraw(param, countyid,svccode,mareacode);
	}
	
	/**
	 * ȷʵ��ԴĿ��
	 * @param wayid ��������
	 * @param batchno	��Ʒ����
	 * @throws Exception
	 */
	public DataPackage doConfirmResource(String wayid,String batchno) throws Exception{
		Map<String,Long> brandMap = null;
		DataPackage returnDP = new DataPackage();
		try{
			brandMap = this.getBrandMap();
		}catch(Exception e){
			throw new JOPException(e.getMessage());
		}
		
		List<NumtypedefVO> numtypeList = null;
		Numtypedef numtypedefBO = (NumtypedefBO)BOFactory.build(NumtypedefBO.class,user);
		NumtypedefDBParam numtypedefParam = new NumtypedefDBParam();
		numtypedefParam.set_ne_effective("1");
		numtypedefParam.set_orderby("prilevel");
		
		DataPackage defDP = numtypedefBO.doQuery(numtypedefParam);
		if( null != defDP){
			numtypeList = defDP.getDatas();
		}
		
		
//		DecimalFormat doubleFormat = new DecimalFormat("###.00");
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		CompackDBParam param = new CompackDBParam();
		param.setQueryAll(true);
		param.setDataOnly(true);
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("DISCOMCODE", wayid);
		conditionMap.put("BATCHNO", batchno);
		param.setQueryConditions(conditionMap);
		param.setSelectFieldsString("COMCATEGORY,NUMBERTYPE,NUM");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.compack.queryByWayidAndBatchno", param);
		if( null != dp && null != dp.getDatas() ){
			Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam relaParam = new ComcategoryrelaDBParam();
			Map<String,Long> comcategoryTotalMap = new HashMap<String,Long>();//��¼�����׿�������
			String comcategory = null;
			String numbertype = null;
			String num = null;
			Map<String,Long> comcategoryPackSizeMap = new HashMap<String,Long>();//��¼��Ʒ�����Ӧ �İ���С
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
//				������Ʒ�����ѯ��Ʒ������Ϲ�ϵ���������������ʾ����Ʒ����[��Ʒ�������]��Ϲ�ϵ�����ݣ�
//				�޷���ȡ��ӦƷ�ƣ�����ϵ����Ա�������أ�
				comcategory =map.get("COMCATEGORY");
				num = map.get("NUM");
				relaParam.set_se_comcategory(comcategory);
				DataPackage relaDP = comcategoryrelaBO.doQuery(relaParam);
				if( null == relaDP || null == relaDP.getDatas()){
					throw new Exception("��Ʒ����["+comcategory+"]��Ϲ�ϵ������");
				}
//				����Ʒ�Ʋ�ѯ�׿�Ʒ�ư�MAP��ȡ��Ӧ�׿�����С��
//				�������������ʾ���׿�Ʒ��[Ʒ�ƴ���]����Сδ���ã�����ϵ����Ա�������أ�
				ComcategoryrelaVO relaVO = (ComcategoryrelaVO)relaDP.getDatas().get(0);
				Long packCount = brandMap.get(relaVO.getBrand());
				if(null == packCount)
					throw new Exception("�׿�Ʒ��["+relaVO.getBrand()+"]����Сδ���ã�����ϵ����Ա");
				comcategoryPackSizeMap.put(comcategory, packCount);
				if( null == comcategoryTotalMap.get(comcategory)){
					comcategoryTotalMap.put(comcategory, Long.valueOf(num));
				}else{
					comcategoryTotalMap.put(comcategory, comcategoryTotalMap.get(comcategory)+Long.valueOf(num));
				}
			}
//			�����ܰ������ܰ���=�������׿�����/����С����С��ʱ����ȡ����
			Map<String,Long> comcategoryPackNumMap = new HashMap<String,Long>();//��Ʒ�����ܰ���
			for(String key:comcategoryTotalMap.keySet()){
				comcategoryPackNumMap.put(key, (comcategoryTotalMap.get(key)+comcategoryPackSizeMap.get(key)-1)/comcategoryPackSizeMap.get(key));
			}
			//������Ʒ��Ϣ����ҳ��չʾ�Ľṹ��(Ϊ�˷����������Ϣ�ȷ�MAP��)
			Map<String,ComcategoryInfo> comcategoryInfoMap = new HashMap<String,ComcategoryInfo>();
//			����ÿ���׿��и�������ռ����������A����=����A����/�ܰ�������С��ʱȡС�������λ��
			Double scale = null;
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
				comcategory =map.get("COMCATEGORY");
				if( null == comcategory)
					throw new Exception("��Ʒ����Ϊ��");
				numbertype = map.get("NUMBERTYPE");
				if( null == numbertype )
					throw new Exception("��������Ϊ��");		
				num = map.get("NUM");
				NumberTypeInfo numberType = new NumberTypeInfo();
				
				scale = Double.valueOf(num)/comcategoryPackNumMap.get(comcategory);
				BigDecimal decimal = new BigDecimal(scale);
				numberType.setScale(decimal.setScale(2, RoundingMode.DOWN).doubleValue());
				numberType.setType(numbertype);
				numberType.setQuantity(Long.valueOf(num));
				numberType.setRemain(Long.valueOf(num));
				ComcategoryInfo info = null;
				if( null == comcategoryInfoMap.get(comcategory)){
					info = new ComcategoryInfo(numtypeList);
					info.setComcategory(comcategory);
					info.setPackSize(comcategoryPackSizeMap.get(comcategory));
					comcategoryInfoMap.put(comcategory, info);
				}else{
					info = comcategoryInfoMap.get(comcategory);
				}
				List<NumberTypeInfo> numberTypeList = info.getNumberTypeInfo();
				int i =0;
				for(i=0;i<numberTypeList.size();i++){
					NumberTypeInfo numTypeInfo = numberTypeList.get(i);
					if(numbertype.equals(numTypeInfo.getType())){
						BeanUtils.copyProperties(numTypeInfo, numberType);
						break;
					}
				}
				if(i>=numberTypeList.size() ){
					numberTypeList.add(numberType);
				}
			}
			//���ΪLIST
			List<ComcategoryInfo> comcateinfoList = new ArrayList<ComcategoryInfo>();
			for(String key: comcategoryInfoMap.keySet()){
				comcateinfoList.add(comcategoryInfoMap.get(key));
			}
			
//			��������ͱ���֮�Ͳ����ڣ���С�ڣ�����С����Է������ı�����������ݼ�0.01��
//			ֱ��������֮�͵��ڰ���СΪֹ����¼���ձ���
			this.adjustScale(comcateinfoList);
			returnDP.setDatas(comcateinfoList);
		}
		return returnDP;
	}
	
	/*
	 * ��������
	 * ��������ͱ���֮�Ͳ����ڣ���С�ڣ�����С����Է������ı�����������ݼ�0.01��
	 * ֱ��������֮�͵��ڰ���СΪֹ����¼���ձ���
	 */
	private void adjustScale(List<ComcategoryInfo> comcategoryInfos){
		for(ComcategoryInfo info:comcategoryInfos){
			info.adjustScale();
		}
	}
	
	
	
	/**
	 * ��ȡ�׿�Ʒ�ư���С�� ��ѯϵͳ�������ñ�IB_GL_SYSPARAM��
	 * ��ƥ���������Ϊ��pboss_fx����������ʶΪ��5��������޼�¼����ʾ������[�׿�Ʒ�ư���С]δ���ã�
	 * ����ϵ����Ա�������ء��Բ���ֵ���в�֣�����ֵΪƷ�ƺͰ���С����ϣ������ߺ�ð�ŷָ�
	 * ����BrandMzone:20|BrandSzx:20|BrandDzk:10|������Ʒ�ơ�����С������Ʒ�ư���СMAP��
	 * ����СҪ��Ϊ����0��������������ʾ������[�׿�Ʒ�ư���С]���ô�������ϵ����Ա�������ء�
	 * @return
	 */
	private Map<String,Long> getBrandMap() throws Exception{
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		
		//�����׿�Ʒ�ư���С
		String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new Exception("����[�׿�Ʒ�ư���С]δ����");
		}
		String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
		Map<String,Long> brandMap=new HashMap<String,Long>();
		String[] vals=null;
		for(String val:values){
			if(!"".equals(val)){
				vals=val.split(":");
				if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
					throw new Exception(  "�׿�Ʒ�ư���С���ô���Ҫ��Ϊ����0������");
				}
				brandMap.put(vals[0],Long.valueOf(vals[1]));
			}
		}
		return brandMap;
	}
	
	/**
	 * ��Դ���
	 */
	public void packResource(List<ComcategoryInfo> comcateList,String wayid,String batchno,PackResourceInfo packInfo,OutputStream os) throws Exception{
		long orderNum = 0;//���
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		
//		��ȡ�׿�Ĭ����Ʒ״̬����ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����
//		������ʶΪ��1������������ݻ����ֵΪ������ʾ������[�׿�Ĭ����Ʒ״̬]δ���ã�����ϵ����Ա�������أ����������
		String defaultState = sysparamBO.doFindByID("1", "pboss_fx");
		if( null == defaultState || "".equals(defaultState))
			throw new Exception ("����[�׿�Ĭ����Ʒ״̬]δ���ã�����ϵ����Ա");
//		��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��2����
//		��������ݻ����ֵΪ������ʾ������[�׿����Ĭ����Դ��;]δ���ã�����ϵ����Ա�������أ����������
		String resourceUse =sysparamBO.doFindByID("2", "pboss_fx");
		if( null == resourceUse || "".equals(resourceUse))
			throw new Exception ("����[�׿����Ĭ����Դ��;]δ���ã�����ϵ����Ա");
//		��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��3����
//		��������ݻ����ֵΪ������ʾ������[�׿����Ĭ����������]δ���ã�����ϵ����Ա�������أ����������
		 String resourceArear =sysparamBO.doFindByID("3", "pboss_fx");
		if( null == resourceArear || "".equals(resourceArear))
			throw new Exception ("����[�׿����Ĭ����������]δ���ã�����ϵ����Ա");
//		��ȡ���кţ���ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��39����
//		�����������Բ���ֵ���в�֣�����ֵΪƷ�ƺ����кŵ���ϣ������ߺ�ð�ŷָ�����BrandMzone:5|BrandSzx:5|BrandDzk:5|����
//		��Ʒ�ƺ����кŵļ��������ڴ棻�����������Ĭ�ϼ���Ϊ��
		String maxBoxnum =sysparamBO.doFindByID("39", "pboss_fx");
		Map<String,String> brandMaxBoxnumMap = new HashMap<String,String>();
		if(maxBoxnum != null && !"".equals(maxBoxnum.trim())){
			String[] temp = maxBoxnum.split("\\|");
			for(String brandMaxbox : temp){
				try{
					brandMaxBoxnumMap.put(brandMaxbox.split(":")[0], brandMaxbox.split(":")[1]);
				}catch(Exception e){
					
				}	
			}
		}
				
//		��ȡ�����ţ���ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����
//		������ʶΪ��40���������������Բ���ֵ���в�֣�����ֵΪƷ�ƺ������ŵ���ϣ�
//		�����ߺ�ð�ŷָ�����BrandMzone:5|BrandSzx:10|BrandDzk:10|����
//		��Ʒ�ƺ������ŵļ��������ڴ棻�����������Ĭ�ϼ���Ϊ�ա�
		String maxPacknum =sysparamBO.doFindByID("40", "pboss_fx");
		Map<String,String> brandMaxPacknumMap = new HashMap<String,String>();
		if(maxPacknum != null && !"".equals(maxPacknum.trim())){
			String[] temp = maxPacknum.split("\\|");
			for(String brandMaxpack : temp){
				try{
					brandMaxPacknumMap.put(brandMaxpack.split(":")[0], brandMaxpack.split(":")[1]);
				}catch(Exception e){
					
				}	
			}
		}
				
//		��ȡ��ʼ��ţ���ʼ���=xxx001������xxxΪ�������ȡ��λ�������
//		Ȼ���ѯ�׿���Դ�����Ƿ��Ѿ����ڣ��������������ȡ���������ѯSQL�������£� 
//		select count(*) from IM_FX_COMRESSMP where BATCHNO = :���� and BOXNUM like 'xxx%';
		String randomBoxnum = this.getRandomBoxnum();
		Comressmp comressmpBO = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
		ComressmpDBParam comressParam = new ComressmpDBParam();
		comressParam.setCountOnly(true);
		comressParam.set_se_batchno(batchno);
		comressParam.set_ssw_boxnum(randomBoxnum);
		DataPackage dp = comressmpBO.doQuery(comressParam);
		while(dp != null && dp.getRowCount()>0){
			randomBoxnum = this.getRandomBoxnum();
			comressParam.set_ssw_boxnum(randomBoxnum);
			dp = comressmpBO.doQuery(comressParam);
		}
		
		
		CompackBO compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
		
		long totalPack = 0;//�ܰ���
		long totlaResource = 0;//��Դ����
		//�����ܰ���
		for(ComcategoryInfo comcategoryInfo : comcateList){							
			CompackDBParam param = new CompackDBParam();
			param.setCountOnly(true);
			param.setQueryAll(true);			
			param.getQueryConditions().put("WAYID", wayid);
			param.getQueryConditions().put("BATCHNO", batchno);
			param.getQueryConditions().put("COMCATEGORY", comcategoryInfo.getComcategory());
			
			DataPackage comressmpDP = comressmpBO.doQueryBySqlName("com.gmcc.pboss.business.resource.comressmp.queryComressmp", param);
			if( null != comressmpDP){
				totlaResource += comressmpDP.getRowCount();
				totalPack += (comressmpDP.getRowCount()+comcategoryInfo.getPackSize()-1)/comcategoryInfo.getPackSize();
			}
			
		}	
		packInfo.setTotalPack(totalPack);
		packInfo.setResource(totlaResource);
		int intBox = 0;//��ʼ���
		
		StringBuilder sb = new StringBuilder(20);
		List<String> packStateList = new ArrayList<String>();
		packStateList.add("1");
		packStateList.add("30");
		for(ComcategoryInfo comcategoryInfo : comcateList){	
			intBox++;
			int intCase = 1;
			int pack = 0;
			DataPackage compackDP = null;
			CompackDBParam compackParam = new CompackDBParam();
			compackParam.setQueryAll(true);
			compackParam.setDataOnly(true);
			compackParam.set_nin_packstate(packStateList);
			compackParam.set_se_wayid(wayid);
			compackParam.set_se_batchno(batchno);
			compackParam.set_se_comcategory(comcategoryInfo.getComcategory());
			compackDP = compackBO.doQuery(compackParam);
			if( null != compackDP && null != compackDP.getDatas()){
				for(CompackVO vo:(List<CompackVO>)compackDP.getDatas()){
					//ɾ����Ʒ��
					compackBO.doRemoveByVO(vo);
				}
			}		
			
//			��ȡ���кź�������
//			������Ʒ�����ѯ��Ʒ������Ϲ�ϵ��(IM_PR_COMCATEGORYRELA)���������������ʾ���޷���ȡ��Ʒ����[xxx]��Ӧ���׿�Ʒ�ơ������أ������������ȡ��һ�����׿�Ʒ�ơ�
//			����Ʒ�Ʋ�ѯ��Ʒ�ƺ����кż��ϡ���ȡ���кţ������������Ĭ��ȡ5��
//			����Ʒ�Ʋ�ѯ��Ʒ�ƺ������ż��ϡ���ȡ�����ţ������������Ĭ��ȡ10��
			maxBoxnum = "5";
			maxPacknum = "10";
			Comcategoryrela comcategrorelaBO = (ComcategoryrelaBO)BOFactory.build(ComcategoryrelaBO.class,user);
			ComcategoryrelaDBParam comcategoryrelaParam = new ComcategoryrelaDBParam();
			comcategoryrelaParam.set_se_comcategory(comcategoryInfo.getComcategory());
			DataPackage comcategoryrelaDP = comcategrorelaBO.doQuery(comcategoryrelaParam);
			if( null != comcategoryrelaDP && null != comcategoryrelaDP.getDatas() && comcategoryrelaDP.getDatas().size()>0){
				ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO)comcategoryrelaDP.getDatas().get(0);
				maxBoxnum = brandMaxBoxnumMap.get(comcategoryrelaVO.getBrand());
				maxPacknum = brandMaxPacknumMap.get(comcategoryrelaVO.getBrand());
			}else{
				throw new Exception("�޷���ȡ��Ʒ����["+comcategoryInfo.getComcategory()+"]��Ӧ���׿�Ʒ��");
			}
			if( null == maxBoxnum )
				maxBoxnum = "5";
			if( null == maxPacknum)
				maxPacknum = "10";
			
			
//			�׿���Դ����
			CompackDBParam param = new CompackDBParam();
			param.setDataOnly(true);
			param.setQueryAll(true);
			param.getQueryConditions().put("WAYID", wayid);
			param.getQueryConditions().put("BATCHNO", batchno);
			param.getQueryConditions().put("COMCATEGORY", comcategoryInfo.getComcategory());
			DataPackage comressmpDP = comressmpBO.doQueryBySqlName("com.gmcc.pboss.business.resource.comressmp.queryComressmp", param);
			if( null != comressmpDP && null != comressmpDP.getDatas() && comressmpDP.getDatas().size() >0){
				Map<String,List<ComressmpVO>> comressmpMap = this.recomposeComressmp((List<ComressmpVO>)comressmpDP.getDatas());
				List<Map<String,Long>> typeDistributeList = comcategoryInfo.numberTypeDistribute();
				long resourceCount = this.countResource(comressmpMap);
				long packCount = (resourceCount+comcategoryInfo.getPackSize()-1)/comcategoryInfo.getPackSize();//�ɷ������
				for(int i = 0;i<packCount;++i){
					System.out.println("******** #pack = "+i);
					try{
						if(++pack>Integer.parseInt(maxPacknum)){
							pack = 1;
							intCase++;
						}
						if(intCase>Integer.parseInt(maxBoxnum)){
							intCase = 1;
							intBox++;
							pack = 1;
						}
						String boxStr = "000000"+intBox;
						String packNum = randomBoxnum+boxStr.substring(boxStr.length()-3)+"-"+intCase+"-"+pack;
						
						packInfo.setProcessPack(packInfo.getProcessPack()+1);
						int index = i%typeDistributeList.size();
						Map<String,List<ComressmpVO>> useResource = null;
						useResource = compackBO.doPakcage(comcategoryInfo.getComcategory(), typeDistributeList.get(index), comressmpMap,
								wayid, batchno, packNum, resourceArear, resourceUse,defaultState);													
						//��¼�ļ�
						if( null != useResource){
							int seq = 1;
							for(String key:useResource.keySet()){
								for(ComressmpVO vo:useResource.get(key)){
									sb = new StringBuilder(100);
									orderNum++;
//									���|��Ʒ����|����|����|���ΰ���|���ΰ��ţ��ɣ�|
									sb.append(orderNum).append("|");
									sb.append(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategoryInfo.getComcategory(), user.getCityid())).append("|");
									sb.append(vo.getComresid()).append("|");
									sb.append(Code2NameUtils.code2Name("#Numtypedef", vo.getNumbertype(), user.getCityid())).append("|");
									sb.append(vo.getBatchno()).append("-");
									sb.append(packNum).append("-");
									sb.append(seq++).append("|");
									sb.append(vo.getBatchno()).append("-");
									sb.append(vo.getBoxnum()).append("-");
									sb.append(vo.getInsideseq() == null?"0":vo.getInsideseq() ).append("|\r\n");
									os.write(sb.toString().getBytes());
								}
							}
						}
					}catch(Exception e){
						LoggerUtils.error(e, log);
					}	
				}	
			}						
		}		
	}
	
	/**
	 * �������
	 * @param comcategory����Ʒ����
	 * @param typeNumMap������������һ�����е���Դ�����ͣ��С�
	 * @param comressmpMap	�������ͺ���Ŀ�ʹ����Դ
	 * @param wayid			��������
	 * @param batchno		����
	 * @param packNum		����
	 * @param storearea		����
	 * @param use			��;
	 * @param defaultState	Ĭ��״̬
	 * @return				�˴α���ȡ�ĺ���������Դ
	 * @throws Exception
	 */
	public Map<String,List<ComressmpVO>> doPakcage(String comcategory,Map<String,Long> typeNumMap,Map<String,List<ComressmpVO>> comressmpMap
			,String wayid,String batchno,String packNum,String storearea,String use,String defaultState ) throws Exception{
		Map<String,List<ComressmpVO>> beUseResource = null;
		try{						
			beUseResource = this.pack(typeNumMap, comressmpMap);			
			
			if( null != beUseResource && this.countResource(beUseResource) >0){
				long count = this.countResource(beUseResource);
				String nosect = this.getNosect(beUseResource);
//				��Ʒ����ȡ�׿���������Ʒ����ȡ������Ϣ����״̬ȡ���ۣ���Դ��;����������ȡ�ѻ�ȡ��ϵͳ������
//				�����Ŷ�ȡ���ں���ǰ3λ���ִ������ģ���������ȡ�������������ʱ��ȡ��ǰʱ�䣬�����ֶ�����
				CompackBO compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
				CompackVO packVO = new CompackVO();
				packVO.setAmount(new Short(""+count));
				packVO.setComcategory(comcategory);
				packVO.setPackstate(defaultState);
				packVO.setBatchno(batchno);
				packVO.setWayid(wayid);
				packVO.setStorarea(storearea);
				packVO.setBoxnum(packNum);
				packVO.setNosect(nosect);
				packVO.setResuse(use);
				packVO.setPacktime(new Date());
				compackBO.doCreate(packVO);
				
//				���Ķ�Ӧ�׿���Դ�İ���
				Comressmp comressmpBO = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
				String oldBoxnum = null;
				int i =1;
				for(String key:beUseResource.keySet()){
					for(ComressmpVO vo:beUseResource.get(key) ){
						ComressmpVO newVO = new ComressmpVO(); 
						BeanUtils.copyProperties(newVO, vo);
						newVO.setBoxnum(packNum);
						newVO.setInsideseq(i++);
						comressmpBO.doUpdate(newVO);//��ֱ��ʹ��VOȥ������Ϊ�˼�¼�ɵİ����Թ�д�ļ�ʱʹ��
					}
				}				
			}
		}catch(Exception e){
			throw new JOPException(e);
		}
		return beUseResource;
	}
	
	/**
	 * ����Դ�а�����ǰ3λ��������Ϊ�Ŷ�
	 * @param resource
	 * @return
	 */
	private String getNosect(Map<String,List<ComressmpVO>> resource){
		String result  = null;
		Map<String,Integer> nosectMap = new HashMap<String,Integer>();
		String comresid = null;
		String subComresid = null;
		int maxCount = 0;
		for(String key:resource.keySet()){
			for(ComressmpVO vo:resource.get(key)){	
				comresid = vo.getComresid();
				subComresid  = comresid.substring(0,3);
				if( null != comresid ){
					if( null == nosectMap.get(subComresid)){
						nosectMap.put(subComresid, 1);
					}else{
						nosectMap.put(subComresid, nosectMap.get(subComresid)+1);
					}
				}
			}
		}
		
		for(String key:nosectMap.keySet()){
			if(nosectMap.get(key)> maxCount){
				maxCount = nosectMap.get(key);
				result = key;
			}
		}
		return result;
	}
	
	
	/**
	 * ��ÿ����Ʒ�����������������Դ�б�ĳ�ȡ��Դ
	 * @param typeNumMap	�������ͼ����ڴ˰��з������Դ����
	 * @param resourceMap	���������Դ�б�
	 * @return Map<�������ͣ��������Դ�б�>
	 */
	private Map<String,List<ComressmpVO>> pack(Map<String,Long> typeNumMap,Map<String,List<ComressmpVO>> resourceMap){
		
		Map<String,List<ComressmpVO>> beUseResource = new HashMap<String,List<ComressmpVO>>();//����ȡ����ʹ�õ���Դ
		Set<String> numTypeKeySet = typeNumMap.keySet();	//��������KEYSET
			
		List<ComressmpVO> typeResourceList = null;
		for(String key:numTypeKeySet){
			typeResourceList = resourceMap.get(key);//��Դ�б�����Ӧ�������͵���Դ�б�
			List<ComressmpVO> tempList = new ArrayList<ComressmpVO>();
			for(int i = 0;i<typeNumMap.get(key);i++){
				tempList.add(typeResourceList.get(0));
				typeResourceList.remove(0);
				beUseResource.put(key, tempList);
			}
		}	
		return beUseResource;
		
	}
	
	/**
	 * ��������Դ �г�ȡָ����Ŀ����Դ
	 * @param resourceMap	Դ��Դ�б�
	 * @param number	��ȡ��Ŀ
	 * @return
	 */
	private List<ComressmpVO> getResourceFormOther(Map<String,List<ComressmpVO>> resourceMap,long number){
		Set<String> resourceKeySet = resourceMap.keySet();	//��ԴKEYSET
		List<ComressmpVO> resuleList = new ArrayList<ComressmpVO>();
		List<ComressmpVO> typeResourceList = null;
		while(number>0 && countResource(resourceMap)>0){
			//ÿ�δ�һ������ȡһ����ֱ������Ϊֹ
			//���ո������׿������Ӵ�С˳��
			TreeSet<ResourceTypeSize> typeSet = new TreeSet<ResourceTypeSize>();
			for(String key:resourceKeySet){
				ResourceTypeSize typeSize = new ResourceTypeSize(key,resourceMap.get(key) == null? 0:resourceMap.get(key).size());
				typeSet.add(typeSize);
			}
			
			for(ResourceTypeSize typeSizeBena :typeSet){
				typeResourceList = resourceMap.get(typeSizeBena.getType());
				if(typeResourceList != null && typeResourceList.size()>0){
					resuleList.add(typeResourceList.get(0));
					typeResourceList.remove(0);//����ȡ����ԴӦ�ô���Դ�б����Ƴ�
					--number;
					if(number<=0 || countResource(resourceMap)<=0 )//�Ѿ�ȡ���������Դ�Ѿ��������˳���ȡ
						break;
				}
			}
		}
		return resuleList;
	}
	
	
	/*
	 * ������Դ����
	 */
	private long countResource(Map<String,List<ComressmpVO>> comressmpMap){
		long result = 0;
		for(String key:comressmpMap.keySet()){
			if( null != comressmpMap.get(key))
				result += comressmpMap.get(key).size();
		}
		return result;
	}
	
	
	/**
	 * ���������������׿���Դ
	 * @param comressMaps
	 * @return
	 */
	private Map<String,List<ComressmpVO>> recomposeComressmp(List<ComressmpVO>  comressMaps){
		Map<String,List<ComressmpVO>> resultMap = new HashMap<String,List<ComressmpVO>>();
		for(ComressmpVO vo:comressMaps){
			
			if( null == resultMap.get(vo.getNumbertype())){
				List<ComressmpVO> list = new ArrayList<ComressmpVO>();
				list.add(vo);
				resultMap.put(vo.getNumbertype(), list);
			}else{
				resultMap.get(vo.getNumbertype()).add(vo);
			}
		}
		return resultMap;
	}
	
	//������λ��1-9���������
	private String getRandomBoxnum(){
		String result = "";
		Random random = new Random();
		int randomInt = 0;
		for(int i = 0 ;i<3;i++){
			while((randomInt = random.nextInt(9)) == 0){}
			result += randomInt;
		}
		return result;
	}

	class ResourceTypeSize implements Comparable{
		private String type;
		private int size;
		
		public ResourceTypeSize(String type,int size){
			this.type = type;
			this.size = size;
		}
		public String getType() {
			return type;
		}
		
		
		public void setType(String type) {
			this.type = type;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			if( null != o){
				if( o instanceof ResourceTypeSize)
					return -(this.size - ((ResourceTypeSize)o).getSize());
			}
			return 0;
		}
		
	}
	
	/**
	 * �׿��������ȷ����Դ
	 * @param resourceFile ���ֺ������͵���Դ
	 * @param comcategory ��Ʒ����
	 * @return	
	 * @throws Exception
	 */
	public DataPackage doPackToolConfirmResource(Map<String,List<ComressmpVO>> resourceMap,String comcategory) throws Exception{
				
		List<ComcategoryrelaVO> relaList = this.getComcategoryrelas(comcategory);
		if( null == relaList || relaList.isEmpty() )
			throw new Exception("��Ʒ����["+comcategory+"]��Ϲ�ϵ������");
//		����Ʒ�Ʋ�ѯ�׿�Ʒ�ư�MAP��ȡ��Ӧ�׿�����С��
//		�������������ʾ���׿�Ʒ��[Ʒ�ƴ���]����Сδ���ã�����ϵ����Ա�������أ�
		Map<String,Long> brandMap = this.getBrandMap();
		ComcategoryrelaVO relaVO = relaList.get(0);
		Long brandPackSize = brandMap.get(relaVO.getBrand());
		if(null == brandPackSize)
			throw new Exception("�׿�Ʒ��["+relaVO.getBrand()+"]����Сδ���ã�����ϵ����Ա");
				
		List<NumtypedefVO> numtypeList = this.getNumtypedefList();
		if( null == numtypeList)
			throw new Exception("�������Ͷ����IM_RU_NUMTYPEDEF���Ҳ�����Ч����");
		ComcategoryInfo comcategoryInfo = new ComcategoryInfo(numtypeList);
		comcategoryInfo.setComcategory(comcategory);
		comcategoryInfo.setPackSize(brandPackSize);
		int resourceCount = 0;//��Դ����
		for(String key:resourceMap.keySet()){
			resourceCount += resourceMap.get(key).size();
		}		
		int  packCount = (resourceCount+(brandPackSize.intValue()-1))/brandPackSize.intValue();//����� ����				
		List<NumberTypeInfo> numberTypeInfos = comcategoryInfo.getNumberTypeInfo();
				
		for(NumberTypeInfo typeInfo:numberTypeInfos){
			int typeResourceCount = resourceMap.get(typeInfo.getType()) == null ? 0:resourceMap.get(typeInfo.getType()).size();//ĳһ����������Դ��
			Double scale = (0.0+typeResourceCount)/packCount;	
			BigDecimal decimal = new BigDecimal(scale);
			typeInfo.setScale(decimal.setScale(2, RoundingMode.DOWN).doubleValue());	
			typeInfo.setQuantity(new Long(typeResourceCount));
			typeInfo.setRemain(new Long(typeResourceCount));
		}		
		comcategoryInfo.adjustScale();//��������
		List<ComcategoryInfo> comcategoryList = new ArrayList<ComcategoryInfo>();
		comcategoryList.add(comcategoryInfo);
		DataPackage dp = new DataPackage();
		dp.setDatas(comcategoryList);
		return dp;
	}
	
	private List<NumtypedefVO> getNumtypedefList() throws Exception{
		Numtypedef numtypedefBO = (NumtypedefBO)BOFactory.build(NumtypedefBO.class,user);
		NumtypedefDBParam numtypedefParam = new NumtypedefDBParam();
		numtypedefParam.set_ne_effective("1");
		numtypedefParam.set_orderby("prilevel");
		
		DataPackage defDP = numtypedefBO.doQuery(numtypedefParam);
		if( null == defDP || null == defDP.getDatas())
			return null;
		return  defDP.getDatas();
	}
	
	
	
	/**
	 * ������Ʒ�����ѯ��Ʒ������Ϲ�ϵ��
	 */
	private List<ComcategoryrelaVO> getComcategoryrelas(String comcategory) throws Exception{
		Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class, user);
		ComcategoryrelaDBParam relaParam = new ComcategoryrelaDBParam();
		relaParam.set_se_comcategory(comcategory);
		DataPackage relaDP = comcategoryrelaBO.doQuery(relaParam);
		if( null == relaDP || null == relaDP.getDatas())
			return null;
		return relaDP.getDatas();
	}	
	
	/**
	 * �׿���������
	 * ������Ʒ�������׿���������Ʒ�������κͰ��ţ��޸�����׿���
	 * ����Ʒ�������ж�Ӧ���׿���¼�����������ֶθĳ��µ���������
	 * @param compackVO  ��Ʒ��
	 * @param newWayid   ����������
	 * @return
	 */
	public void doUpdateComressmp(CompackVO compackVO, String newWayid){
		try{
			ComressmpDBParam param = new ComressmpDBParam();
			//param.set_se_batchno(compackVO.getBatchno());
			//param.set_se_boxnum(compackVO.getBoxnum());
			param.getQueryConditions().put("BATCHNO", compackVO.getBatchno());
			param.getQueryConditions().put("BOXNUM", compackVO.getBoxnum());
			param.set_pagesize("0");
			
			Comressmp smpBO = (Comressmp)BOFactory.build(ComressmpBO.class, user);
			String sqlName="com.gmcc.pboss.business.resource.comressmp.queryByCompack";
			DataPackage dp = smpBO.doQueryBySqlName(sqlName, param);
			List<ComressmpVO> dpData = dp.getDatas();
			Iterator<ComressmpVO> iter = dpData.iterator();
			while(iter.hasNext()){
				ComressmpVO smpVO = (ComressmpVO)iter.next();
				smpVO.setWayid(newWayid);
				smpBO.doUpdate(smpVO);
			}
			
			//������Ʒ��������Ϣwayid
			compackVO.setWayid(newWayid);
			this.doUpdate(compackVO);
		}catch(Exception ex){
			throw new JOPException(ex);
		}
	}
	
	/**
	 * �׿���Դ������ߴ��
	 */
	public void packToolResource(ComcategoryInfo comcategoryInfo,Map<String,List<ComressmpVO>> resourceMap,PackResourceInfo packInfo,OutputStream os) throws Exception{
		long orderNum = 0;//���
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			
		long resourceCount = 0;//��Դ����
		long  packCount = 0;//�ܰ���
		for(String key:resourceMap.keySet()){
			resourceCount += resourceMap.get(key).size();
		}						
		packInfo.setResource(resourceCount);
		
		int intBox = 0;//��ʼ���
		String startBoxnum = this.getStartBoxnum();//��ʼ���
		Map<String,String> brandMaxBoxnumMap = this.getBrandMaxBoxnum();//���к�
		Map<String,String> brandMaxPacknum = this.getBrandMaxPacknum();//������

		StringBuilder sb = new StringBuilder(20);
		Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
		intBox++;
		int intCase = 1;
		int pack = 0;
				
//		��ȡ���кź�������
//		������Ʒ�����ѯ��Ʒ������Ϲ�ϵ��(IM_PR_COMCATEGORYRELA)���������������ʾ���޷���ȡ��Ʒ����[xxx]��Ӧ���׿�Ʒ�ơ������أ������������ȡ��һ�����׿�Ʒ�ơ�
//		����Ʒ�Ʋ�ѯ��Ʒ�ƺ����кż��ϡ���ȡ���кţ������������Ĭ��ȡ5��
//		����Ʒ�Ʋ�ѯ��Ʒ�ƺ������ż��ϡ���ȡ�����ţ������������Ĭ��ȡ10��
		String maxBoxnum = "5";
		String maxPacknum = "10";
		Comcategoryrela comcategrorelaBO = (ComcategoryrelaBO)BOFactory.build(ComcategoryrelaBO.class,user);
		ComcategoryrelaDBParam comcategoryrelaParam = new ComcategoryrelaDBParam();
		comcategoryrelaParam.set_se_comcategory(comcategoryInfo.getComcategory());
		DataPackage comcategoryrelaDP = comcategrorelaBO.doQuery(comcategoryrelaParam);
		if( null != comcategoryrelaDP && null != comcategoryrelaDP.getDatas() && comcategoryrelaDP.getDatas().size()>0){
			ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO)comcategoryrelaDP.getDatas().get(0);
			maxBoxnum = brandMaxBoxnumMap.get(comcategoryrelaVO.getBrand());
			maxPacknum = brandMaxPacknum.get(comcategoryrelaVO.getBrand());
		}else{
			throw new Exception("�޷���ȡ��Ʒ����["+comcategoryInfo.getComcategory()+"]��Ӧ���׿�Ʒ��");
		}
		if( null == maxBoxnum )
			maxBoxnum = "5";
		if( null == maxPacknum)
			maxPacknum = "10";
				
		List<Map<String,Long>> typeDistributeList = comcategoryInfo.numberTypeDistribute();
		packInfo.setTotalPack(typeDistributeList.size());
		for(int i = 0;i<typeDistributeList.size();++i){
			try{
				if(++pack>Integer.parseInt(maxPacknum)){
					pack = 1;
					intCase++;
				}
				if(intCase>Integer.parseInt(maxBoxnum)){
					intCase = 1;
					intBox++;
					pack = 1;
				}
				String boxStr = "000000"+intBox;
				String packNum = startBoxnum+boxStr.substring(boxStr.length()-3)+"-"+intCase+"-"+pack;				
				packInfo.setProcessPack(packInfo.getProcessPack()+1);
				
				Map<String, List<ComressmpVO>> useResource = null;
				useResource = this.pack(typeDistributeList.get(i), resourceMap);												
				//��¼�ļ�
				if( null != useResource){
					for(String key:useResource.keySet()){
						for(ComressmpVO vo:useResource.get(key) ){
//							����|�ɰ���|�°���|							
							os.write((vo.getComresid()+"|"+(vo.getBoxnum() == null?"":vo.getBoxnum())+"|"+packNum+"|\r\n").getBytes());	
						}
					}
				}
			}catch(Exception e){
				LoggerUtils.error(e, log);
			}	
		}
		
	}
	
//	��ȡ���кţ���ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��39����
//	�����������Բ���ֵ���в�֣�����ֵΪƷ�ƺ����кŵ���ϣ������ߺ�ð�ŷָ�����BrandMzone:5|BrandSzx:5|BrandDzk:5|����
//	��Ʒ�ƺ����кŵļ��������ڴ棻�����������Ĭ�ϼ���Ϊ��
	private Map<String,String> getBrandMaxBoxnum() throws Exception {
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String maxBoxnum =sysparamBO.doFindByID("39", "pboss_fx");
		Map<String,String> brandMaxBoxnumMap = new HashMap<String,String>();
		if(maxBoxnum != null && !"".equals(maxBoxnum.trim())){
			String[] temp = maxBoxnum.split("\\|");
			for(String brandMaxbox : temp){
				try{
					brandMaxBoxnumMap.put(brandMaxbox.split(":")[0], brandMaxbox.split(":")[1]);
				}catch(Exception e){
					LoggerUtils.error(e, log);
				}	
			}
		}
		return brandMaxBoxnumMap;
	}
	
	
//	��ȡ�����ţ���ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����
//	������ʶΪ��40���������������Բ���ֵ���в�֣�����ֵΪƷ�ƺ������ŵ���ϣ�
//	�����ߺ�ð�ŷָ�����BrandMzone:5|BrandSzx:10|BrandDzk:10|����
//	��Ʒ�ƺ������ŵļ��������ڴ棻�����������Ĭ�ϼ���Ϊ�ա�
	private Map<String,String> getBrandMaxPacknum() throws Exception {
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String maxPacknum =sysparamBO.doFindByID("40", "pboss_fx");
		Map<String,String> brandMaxPacknumMap = new HashMap<String,String>();
		if(maxPacknum != null && !"".equals(maxPacknum.trim())){
			String[] temp = maxPacknum.split("\\|");
			for(String brandMaxpack : temp){
				try{
					brandMaxPacknumMap.put(brandMaxpack.split(":")[0], brandMaxpack.split(":")[1]);
				}catch(Exception e){
					LoggerUtils.error(e, log);
				}	
			}
		}
		return brandMaxPacknumMap;
	}
	
//	��ȡ��ʼ��ţ���ʼ���=xxx001������xxxΪ�������ȡ��λ�������
//	Ȼ���ѯ�׿���Դ�����Ƿ��Ѿ����ڣ��������������ȡ���������ѯSQL�������£� 
//	select count(*) from IM_FX_COMRESSMP where BATCHNO = :���� and BOXNUM like 'xxx%';	
	private String getStartBoxnum() throws Exception{
		String randomBoxnum = this.getRandomBoxnum();
		Comressmp comressmpBO = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
		ComressmpDBParam comressParam = new ComressmpDBParam();
		comressParam.setCountOnly(true);
		comressParam.set_ssw_boxnum(randomBoxnum);
		DataPackage dp = comressmpBO.doQuery(comressParam);
		while(dp != null && dp.getRowCount()>0){
			randomBoxnum = this.getRandomBoxnum();
			comressParam.set_ssw_boxnum(randomBoxnum);
			dp = comressmpBO.doQuery(comressParam);
		}
		return randomBoxnum;
	}
	
	
}


