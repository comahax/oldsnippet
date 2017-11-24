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
	 * 获取商品包抽取功能的商品包(对渠道表的关联以获取商品包归属分公司)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryCompackResdraw(CompackDBParam param,String countyid,String svccode,String mareacode)throws Exception {
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		return dao.doQueryCompackResdraw(param, countyid,svccode,mareacode);
	}
	
	/**
	 * 确实资源目标
	 * @param wayid 归属渠道
	 * @param batchno	商品批次
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
			Map<String,Long> comcategoryTotalMap = new HashMap<String,Long>();//记录各类套卡总数量
			String comcategory = null;
			String numbertype = null;
			String num = null;
			Map<String,Long> comcategoryPackSizeMap = new HashMap<String,Long>();//记录商品种类对应 的包大小
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
//				根据商品种类查询商品种类组合关系表，如果无数据则提示“商品种类[商品种类编码]组合关系无数据，
//				无法获取对应品牌，请联系管理员”并返回；
				comcategory =map.get("COMCATEGORY");
				num = map.get("NUM");
				relaParam.set_se_comcategory(comcategory);
				DataPackage relaDP = comcategoryrelaBO.doQuery(relaParam);
				if( null == relaDP || null == relaDP.getDatas()){
					throw new Exception("商品种类["+comcategory+"]组合关系无数据");
				}
//				根据品牌查询套卡品牌包MAP获取对应套卡包大小，
//				如果无数据则提示“套卡品牌[品牌代码]包大小未设置，请联系管理员”并返回；
				ComcategoryrelaVO relaVO = (ComcategoryrelaVO)relaDP.getDatas().get(0);
				Long packCount = brandMap.get(relaVO.getBrand());
				if(null == packCount)
					throw new Exception("套卡品牌["+relaVO.getBrand()+"]包大小未设置，请联系管理员");
				comcategoryPackSizeMap.put(comcategory, packCount);
				if( null == comcategoryTotalMap.get(comcategory)){
					comcategoryTotalMap.put(comcategory, Long.valueOf(num));
				}else{
					comcategoryTotalMap.put(comcategory, comcategoryTotalMap.get(comcategory)+Long.valueOf(num));
				}
			}
//			计算总包数，总包数=各类型套卡数量/包大小，有小数时向上取整；
			Map<String,Long> comcategoryPackNumMap = new HashMap<String,Long>();//商品种类总包数
			for(String key:comcategoryTotalMap.keySet()){
				comcategoryPackNumMap.put(key, (comcategoryTotalMap.get(key)+comcategoryPackSizeMap.get(key)-1)/comcategoryPackSizeMap.get(key));
			}
			//保存商品信息（供页面展示的结构）(为了方便操作把信息先放MAP中)
			Map<String,ComcategoryInfo> comcategoryInfoMap = new HashMap<String,ComcategoryInfo>();
//			计算每包套卡中各类型所占比例，类型A比例=类型A数量/总包数，有小数时取小数点后两位；
			Double scale = null;
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
				comcategory =map.get("COMCATEGORY");
				if( null == comcategory)
					throw new Exception("商品种类为空");
				numbertype = map.get("NUMBERTYPE");
				if( null == numbertype )
					throw new Exception("号码类型为空");		
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
			//存放为LIST
			List<ComcategoryInfo> comcateinfoList = new ArrayList<ComcategoryInfo>();
			for(String key: comcategoryInfoMap.keySet()){
				comcateinfoList.add(comcategoryInfoMap.get(key));
			}
			
//			如果各类型比例之和不等于（即小于）包大小，则对非整数的比例进行逐个递加0.01，
//			直到各类型之和等于包大小为止，记录最终比例
			this.adjustScale(comcateinfoList);
			returnDP.setDatas(comcateinfoList);
		}
		return returnDP;
	}
	
	/*
	 * 调整比例
	 * 如果各类型比例之和不等于（即小于）包大小，则对非整数的比例进行逐个递加0.01，
	 * 直到各类型之和等于包大小为止，记录最终比例
	 */
	private void adjustScale(List<ComcategoryInfo> comcategoryInfos){
		for(ComcategoryInfo info:comcategoryInfos){
			info.adjustScale();
		}
	}
	
	
	
	/**
	 * 获取套卡品牌包大小： 查询系统参数配置表（IB_GL_SYSPARAM）
	 * ，匹配参数类型为“pboss_fx”，参数标识为“5”，如果无记录则提示“参数[套卡品牌包大小]未设置，
	 * 请联系管理员”并返回。对参数值进行拆分（参数值为品牌和包大小的组合，以竖线和冒号分隔
	 * ，如BrandMzone:20|BrandSzx:20|BrandDzk:10|），将品牌、包大小保存至品牌包大小MAP。
	 * 包大小要求为大于0的整数，否则提示“参数[套卡品牌包大小]设置错误，请联系管理员”并返回。
	 * @return
	 */
	private Map<String,Long> getBrandMap() throws Exception{
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		
		//载入套卡品牌包大小
		String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new Exception("参数[套卡品牌包大小]未设置");
		}
		String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
		Map<String,Long> brandMap=new HashMap<String,Long>();
		String[] vals=null;
		for(String val:values){
			if(!"".equals(val)){
				vals=val.split(":");
				if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
					throw new Exception(  "套卡品牌包大小设置错误，要求为大于0的整数");
				}
				brandMap.put(vals[0],Long.valueOf(vals[1]));
			}
		}
		return brandMap;
	}
	
	/**
	 * 资源打包
	 */
	public void packResource(List<ComcategoryInfo> comcateList,String wayid,String batchno,PackResourceInfo packInfo,OutputStream os) throws Exception{
		long orderNum = 0;//序号
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		
//		获取套卡默认商品状态：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，
//		参数标识为“1”，如果无数据或参数值为空则提示“参数[套卡默认商品状态]未设置，请联系管理员”并返回，否则继续。
		String defaultState = sysparamBO.doFindByID("1", "pboss_fx");
		if( null == defaultState || "".equals(defaultState))
			throw new Exception ("参数[套卡默认商品状态]未设置，请联系管理员");
//		查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“2”，
//		如果无数据或参数值为空则提示“参数[套卡入库默认资源用途]未设置，请联系管理员”并返回，否则继续。
		String resourceUse =sysparamBO.doFindByID("2", "pboss_fx");
		if( null == resourceUse || "".equals(resourceUse))
			throw new Exception ("参数[套卡入库默认资源用途]未设置，请联系管理员");
//		查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“3”，
//		如果无数据或参数值为空则提示“参数[套卡入库默认所属库区]未设置，请联系管理员”并返回，否则继续。
		 String resourceArear =sysparamBO.doFindByID("3", "pboss_fx");
		if( null == resourceArear || "".equals(resourceArear))
			throw new Exception ("参数[套卡入库默认所属库区]未设置，请联系管理员");
//		获取最大盒号：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“39”，
//		如果有数据则对参数值进行拆分（参数值为品牌和最大盒号的组合，以竖线和冒号分隔，如BrandMzone:5|BrandSzx:5|BrandDzk:5|），
//		将品牌和最大盒号的集合载入内存；如果无数据则默认集合为空
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
				
//		获取最大包号：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，
//		参数标识为“40”，如果有数据则对参数值进行拆分（参数值为品牌和最大包号的组合，
//		以竖线和冒号分隔，如BrandMzone:5|BrandSzx:10|BrandDzk:10|），
//		将品牌和最大包号的集合载入内存；如果无数据则默认集合为空。
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
				
//		获取初始箱号：初始箱号=xxx001，其中xxx为随机数。取三位随机数，
//		然后查询套卡资源表中是否已经存在，如果存在则重新取随机数，查询SQL大致如下： 
//		select count(*) from IM_FX_COMRESSMP where BATCHNO = :批次 and BOXNUM like 'xxx%';
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
		
		long totalPack = 0;//总包数
		long totlaResource = 0;//资源总数
		//计算总包数
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
		int intBox = 0;//初始箱号
		
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
					//删除商品包
					compackBO.doRemoveByVO(vo);
				}
			}		
			
//			获取最大盒号和最大包号
//			根据商品种类查询商品种类组合关系表(IM_PR_COMCATEGORYRELA)，如果无数据则提示“无法获取商品种类[xxx]对应的套卡品牌”并返回，如果有数据则取第一条的套卡品牌。
//			根据品牌查询“品牌和最大盒号集合”获取最大盒号，如果无数据则默认取5。
//			根据品牌查询“品牌和最大包号集合”获取最大包号，如果无数据则默认取10。
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
				throw new Exception("无法获取商品种类["+comcategoryInfo.getComcategory()+"]对应的套卡品牌");
			}
			if( null == maxBoxnum )
				maxBoxnum = "5";
			if( null == maxPacknum)
				maxPacknum = "10";
			
			
//			套卡资源排序
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
				long packCount = (resourceCount+comcategoryInfo.getPackSize()-1)/comcategoryInfo.getPackSize();//可分配包数
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
						//记录文件
						if( null != useResource){
							int seq = 1;
							for(String key:useResource.keySet()){
								for(ComressmpVO vo:useResource.get(key)){
									sb = new StringBuilder(100);
									orderNum++;
//									序号|商品种类|号码|类型|批次包号|批次包号（旧）|
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
	 * 单个组包
	 * @param comcategory　商品类型
	 * @param typeNumMap　号码类型在一个包中的资源数量ＭＡＰ　
	 * @param comressmpMap	各种类型号码的可使用资源
	 * @param wayid			归属渠道
	 * @param batchno		批次
	 * @param packNum		包号
	 * @param storearea		库区
	 * @param use			用途
	 * @param defaultState	默认状态
	 * @return				此次被抽取的号码类型资源
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
//				商品数量取套卡数量，商品种类取集合信息，包状态取可售，资源用途和所属库区取已获取的系统参数，
//				归属号段取包内号码前3位出现次数最多的，归属渠道取界面渠道，打包时间取当前时间，其余字段留空
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
				
//				更改对应套卡资源的包号
				Comressmp comressmpBO = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
				String oldBoxnum = null;
				int i =1;
				for(String key:beUseResource.keySet()){
					for(ComressmpVO vo:beUseResource.get(key) ){
						ComressmpVO newVO = new ComressmpVO(); 
						BeanUtils.copyProperties(newVO, vo);
						newVO.setBoxnum(packNum);
						newVO.setInsideseq(i++);
						comressmpBO.doUpdate(newVO);//不直接使用VO去更新是为了记录旧的包号以供写文件时使用
					}
				}				
			}
		}catch(Exception e){
			throw new JOPException(e);
		}
		return beUseResource;
	}
	
	/**
	 * 从资源中按号码前3位出现最多的为号段
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
	 * 对每个商品包按各类号码分配从资源列表的抽取资源
	 * @param typeNumMap	号码类型及其在此包中分配的资源数量
	 * @param resourceMap	待分配的资源列表
	 * @return Map<号吗类型，分配的资源列表>
	 */
	private Map<String,List<ComressmpVO>> pack(Map<String,Long> typeNumMap,Map<String,List<ComressmpVO>> resourceMap){
		
		Map<String,List<ComressmpVO>> beUseResource = new HashMap<String,List<ComressmpVO>>();//被抽取出来使用的资源
		Set<String> numTypeKeySet = typeNumMap.keySet();	//号码类型KEYSET
			
		List<ComressmpVO> typeResourceList = null;
		for(String key:numTypeKeySet){
			typeResourceList = resourceMap.get(key);//资源列表中相应号码类型的资源列表
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
	 * 从其它资源 中抽取指定数目的资源
	 * @param resourceMap	源资源列表
	 * @param number	抽取数目
	 * @return
	 */
	private List<ComressmpVO> getResourceFormOther(Map<String,List<ComressmpVO>> resourceMap,long number){
		Set<String> resourceKeySet = resourceMap.keySet();	//资源KEYSET
		List<ComressmpVO> resuleList = new ArrayList<ComressmpVO>();
		List<ComressmpVO> typeResourceList = null;
		while(number>0 && countResource(resourceMap)>0){
			//每次从一个类型取一个，直到补足为止
			//按照各类型套卡数量从大到小顺序，
			TreeSet<ResourceTypeSize> typeSet = new TreeSet<ResourceTypeSize>();
			for(String key:resourceKeySet){
				ResourceTypeSize typeSize = new ResourceTypeSize(key,resourceMap.get(key) == null? 0:resourceMap.get(key).size());
				typeSet.add(typeSize);
			}
			
			for(ResourceTypeSize typeSizeBena :typeSet){
				typeResourceList = resourceMap.get(typeSizeBena.getType());
				if(typeResourceList != null && typeResourceList.size()>0){
					resuleList.add(typeResourceList.get(0));
					typeResourceList.remove(0);//被抽取的资源应该从资源列表中移除
					--number;
					if(number<=0 || countResource(resourceMap)<=0 )//已经取够或可用资源已经用完则退出抽取
						break;
				}
			}
		}
		return resuleList;
	}
	
	
	/*
	 * 计算资源总数
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
	 * 按号码类型重组套卡资源
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
	
	//返回三位（1-9）的随机数
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
	 * 套卡打包工具确定资源
	 * @param resourceFile 各种号码类型的资源
	 * @param comcategory 商品种类
	 * @return	
	 * @throws Exception
	 */
	public DataPackage doPackToolConfirmResource(Map<String,List<ComressmpVO>> resourceMap,String comcategory) throws Exception{
				
		List<ComcategoryrelaVO> relaList = this.getComcategoryrelas(comcategory);
		if( null == relaList || relaList.isEmpty() )
			throw new Exception("商品种类["+comcategory+"]组合关系无数据");
//		根据品牌查询套卡品牌包MAP获取对应套卡包大小，
//		如果无数据则提示“套卡品牌[品牌代码]包大小未设置，请联系管理员”并返回；
		Map<String,Long> brandMap = this.getBrandMap();
		ComcategoryrelaVO relaVO = relaList.get(0);
		Long brandPackSize = brandMap.get(relaVO.getBrand());
		if(null == brandPackSize)
			throw new Exception("套卡品牌["+relaVO.getBrand()+"]包大小未设置，请联系管理员");
				
		List<NumtypedefVO> numtypeList = this.getNumtypedefList();
		if( null == numtypeList)
			throw new Exception("号码类型定义表（IM_RU_NUMTYPEDEF）找不到有效数据");
		ComcategoryInfo comcategoryInfo = new ComcategoryInfo(numtypeList);
		comcategoryInfo.setComcategory(comcategory);
		comcategoryInfo.setPackSize(brandPackSize);
		int resourceCount = 0;//资源总数
		for(String key:resourceMap.keySet()){
			resourceCount += resourceMap.get(key).size();
		}		
		int  packCount = (resourceCount+(brandPackSize.intValue()-1))/brandPackSize.intValue();//计算况 包数				
		List<NumberTypeInfo> numberTypeInfos = comcategoryInfo.getNumberTypeInfo();
				
		for(NumberTypeInfo typeInfo:numberTypeInfos){
			int typeResourceCount = resourceMap.get(typeInfo.getType()) == null ? 0:resourceMap.get(typeInfo.getType()).size();//某一号码类型资源数
			Double scale = (0.0+typeResourceCount)/packCount;	
			BigDecimal decimal = new BigDecimal(scale);
			typeInfo.setScale(decimal.setScale(2, RoundingMode.DOWN).doubleValue());	
			typeInfo.setQuantity(new Long(typeResourceCount));
			typeInfo.setRemain(new Long(typeResourceCount));
		}		
		comcategoryInfo.adjustScale();//调整比例
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
	 * 根据商品种类查询商品种类组合关系表，
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
	 * 套卡批量调拨
	 * 根据商品包更新套卡表，依据商品包的批次和包号，修改相关套卡表
	 * 将商品包和其中对应的套卡记录的渠道编码字段改成新的渠道编码
	 * @param compackVO  商品包
	 * @param newWayid   新渠道编码
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
			
			//更新商品包渠道信息wayid
			compackVO.setWayid(newWayid);
			this.doUpdate(compackVO);
		}catch(Exception ex){
			throw new JOPException(ex);
		}
	}
	
	/**
	 * 套卡资源打包工具打包
	 */
	public void packToolResource(ComcategoryInfo comcategoryInfo,Map<String,List<ComressmpVO>> resourceMap,PackResourceInfo packInfo,OutputStream os) throws Exception{
		long orderNum = 0;//序号
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			
		long resourceCount = 0;//资源总数
		long  packCount = 0;//总包数
		for(String key:resourceMap.keySet()){
			resourceCount += resourceMap.get(key).size();
		}						
		packInfo.setResource(resourceCount);
		
		int intBox = 0;//初始箱号
		String startBoxnum = this.getStartBoxnum();//初始箱号
		Map<String,String> brandMaxBoxnumMap = this.getBrandMaxBoxnum();//最大盒号
		Map<String,String> brandMaxPacknum = this.getBrandMaxPacknum();//最大包号

		StringBuilder sb = new StringBuilder(20);
		Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
		intBox++;
		int intCase = 1;
		int pack = 0;
				
//		获取最大盒号和最大包号
//		根据商品种类查询商品种类组合关系表(IM_PR_COMCATEGORYRELA)，如果无数据则提示“无法获取商品种类[xxx]对应的套卡品牌”并返回，如果有数据则取第一条的套卡品牌。
//		根据品牌查询“品牌和最大盒号集合”获取最大盒号，如果无数据则默认取5。
//		根据品牌查询“品牌和最大包号集合”获取最大包号，如果无数据则默认取10。
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
			throw new Exception("无法获取商品种类["+comcategoryInfo.getComcategory()+"]对应的套卡品牌");
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
				//记录文件
				if( null != useResource){
					for(String key:useResource.keySet()){
						for(ComressmpVO vo:useResource.get(key) ){
//							号码|旧包号|新包号|							
							os.write((vo.getComresid()+"|"+(vo.getBoxnum() == null?"":vo.getBoxnum())+"|"+packNum+"|\r\n").getBytes());	
						}
					}
				}
			}catch(Exception e){
				LoggerUtils.error(e, log);
			}	
		}
		
	}
	
//	获取最大盒号：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“39”，
//	如果有数据则对参数值进行拆分（参数值为品牌和最大盒号的组合，以竖线和冒号分隔，如BrandMzone:5|BrandSzx:5|BrandDzk:5|），
//	将品牌和最大盒号的集合载入内存；如果无数据则默认集合为空
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
	
	
//	获取最大包号：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，
//	参数标识为“40”，如果有数据则对参数值进行拆分（参数值为品牌和最大包号的组合，
//	以竖线和冒号分隔，如BrandMzone:5|BrandSzx:10|BrandDzk:10|），
//	将品牌和最大包号的集合载入内存；如果无数据则默认集合为空。
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
	
//	获取初始箱号：初始箱号=xxx001，其中xxx为随机数。取三位随机数，
//	然后查询套卡资源表中是否已经存在，如果存在则重新取随机数，查询SQL大致如下： 
//	select count(*) from IM_FX_COMRESSMP where BATCHNO = :批次 and BOXNUM like 'xxx%';	
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


