package com.gmcc.pboss.common.constant.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.constant.dao.ConstantDao;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.constant.support.BranchCntyCompQueryParameter;
import com.gmcc.pboss.common.constant.support.ConstantQueryParameter;
import com.gmcc.pboss.common.constant.support.processor.BranchCntyCompQueryProcessor;
import com.gmcc.pboss.common.constant.support.processor.ConstantQueryProcessor;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.constant.ChPwCntycompany;
import com.gmcc.pboss.model.constant.SaDbDictitem;

/**
 * 固定参数加载
 * @author tangzhu
 * @date 2009-12-22
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class ConstantServiceImpl extends BaseServiceImpl implements
		ConstantService {
	/**
	 * 系统固定信息缓存
	 */
	protected Map<String,Map<String,SaDbDictitem>> constantMap = new LinkedHashMap<String, Map<String,SaDbDictitem>>();
	/**
	 * 地市分公司缓存
	 */
	protected Map<String,ChPwCntycompany> cntycompanyMap = new LinkedHashMap<String,ChPwCntycompany>();
	/**
	 * 按地市存放地市分公司信息
	 */
	protected Map<String,Map<String,ChPwCntycompany>> branchcompanyMap = new LinkedHashMap<String,Map<String,ChPwCntycompany>>();
	
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(ConstantServiceImpl.class);

	protected ConstantDao cntycompanyDao;
	
	public ConstantServiceImpl() {
		this.serviceCode = ServiceCode.CONSTANT_LOAD;
		this.serviceName = "从数据库中加载固定参数";
	}

	public Map<String, String> getConstantMap(String groupid) {
		// TODO Auto-generated method stub
		Map<String, SaDbDictitem> dtlMap = this.constantMap.get(groupid);
		
		//如果取出为空重新加载
		if(dtlMap == null ){
			this.init();
			dtlMap = this.constantMap.get(groupid);
		}
		
		Map<String,String> rtn = new LinkedHashMap<String, String>();
		String key;
		SaDbDictitem dtl;
		//封装返回数组
		for (Entry<String,SaDbDictitem> entry: dtlMap.entrySet()){
			key = entry.getKey();
			dtl = entry.getValue();
			rtn.put(key, dtl.getDictname());
		}
		return rtn;
	}

	public String getConstantName(String groupid, String dictid) {
		// TODO Auto-generated method stub
		Map<String, SaDbDictitem> dtlMap = this.constantMap.get(groupid);
		
		//如果取出为空重新加载
		if(dtlMap == null ){
			this.init();
			dtlMap = this.constantMap.get(groupid);
		}
		
		if (dtlMap != null){
			SaDbDictitem dtl = dtlMap.get(dictid);
			if (dtl != null){
				return dtl.getDictname();
			}
		}
		//StringBuffer sb = new StringBuffer();
		//sb.append("未知固定参数[")
		//.append(groupid).append('_')
		//.append(dictid).append("]固定参数");
		//return sb.toString();
		return dictid;
	}

	public void clear() {
		// TODO Auto-generated method stub
		constantMap.clear();
		cntycompanyMap.clear();
		branchcompanyMap.clear();
	}

	/**
	 * 初始化数据
	 */
	public void init() {
		// TODO Auto-generated method stub
		//封装查询条件,手动加数
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		Map<String, String> mapGroupid = Constant.getConstantGroupid();
		String groupid[] = new String[mapGroupid.size()];
		int i=0;
		for (Entry<String,String> entry: mapGroupid.entrySet()){
			groupid[i] = entry.getKey();
			i++;
		}
		
		ConstantQueryParameter parma = new ConstantQueryParameter(); 
		parma.setGroupid(groupid);
		List<SaDbDictitem> allDictitem = this.getDao().getAll(new ConstantQueryProcessor(),parma).getData();
		Map<String, SaDbDictitem> temp;
		String inGroupid,inDictid;
		if (allDictitem.size()>0){
			//@@可以优化
			this.clear();//清除已保存的参数
			for (SaDbDictitem dtl:allDictitem){
				inGroupid = dtl.getId().getGroupid();
				inDictid = dtl.getId().getDictid();
				//主键存在判断
				if (this.constantMap.containsKey(inGroupid)){
					temp = this.constantMap.get(inGroupid);
					temp.put(inDictid, dtl);
				}else{
					temp = new LinkedHashMap<String, SaDbDictitem>();//不存在，建LinkedHashMap
					temp.put(inDictid, dtl);
					this.constantMap.put(inGroupid, temp);
				}
				//把数据放入内存
			}//for
			temp = null;
			//显示加载信息
			for (String dGroupid:groupid){
				temp = this.constantMap.get(dGroupid);
				
				StringBuffer info = new StringBuffer();
				String desc = mapGroupid.get(dGroupid);
				
				if (temp!=null){
					
					info.append(desc).append('[').append(dGroupid).append("]成功加载：").append(temp.size());
					//logger.info(info.toString());
				}else{
					info.append(desc).append('[').append(dGroupid).append("]加载失败");
					logger.warn(info.toString());
				}
				
				Log.cacheLog(serviceCode, serviceName, info.toString());
			}
			//加载地市子公司
			List<ChPwCntycompany> cntycompany = this.getCntycompanyDao().getAll();
			for (ChPwCntycompany obj:cntycompany){
				this.cntycompanyMap.put(obj.getCountycompid(), obj);
			}
			logger.info("地市子公司信息加载成功,加载了["+cntycompanyMap.size()+"]条");
			Log.cacheLog(serviceCode, serviceName, "地市子公司信息加载成功,加载了["+cntycompanyMap.size()+"]条");
		}else{
			logger.error("固定参数表为空!");
		}
		//加载地市分公司
		this.loadBranchCntyComp();
	}
	public void refresh() {
		// TODO Auto-generated method stub
		init();
	}
	
	/**
	 * 地市分公司加载 - 地市分公司缓冲的地市列表
	 */
	private void loadBranchCntyComp(){
		String[] allCity = null;
		//提取需要缓冲的地市列表
		String branchName = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME,CommonConfig.SYSSUPPORT_BRANCH);
		if("ALL".equals(branchName)){
			Map<String,String> map = Constant.getConstantsMap(ConstantsType.BRANCH_NAME);
			Set<String> set = map.keySet();
			String[] e = new String[map.size()];
			int i = 0;
			for(Iterator<String> it = set.iterator();it.hasNext();){
				e[i++] = it.next();
			}
			allCity = e;
		}
		else{
			allCity = branchName.split("\\|");
		}//if
		
		BranchCntyCompQueryProcessor proc = new BranchCntyCompQueryProcessor();
		BranchCntyCompQueryParameter param = new BranchCntyCompQueryParameter();
		//按顺序加载地市分公司信息
		int i=0;
		for (String city:allCity){
			param.setCitycompid(city);
			List<ChPwCntycompany> cityAll = this.getCntycompanyDao().getAll(proc, param).getData();
			Map<String,ChPwCntycompany> temp = new LinkedHashMap<String, ChPwCntycompany>();
			for (ChPwCntycompany dtl:cityAll){
				temp.put(dtl.getCountycompid(), dtl);
			}//合成List
			
			//替换Map内容
			//判断是否要替换
			if (temp.size()>0){
				logger.info("按地市["+ city +"]加载分公司信息加载成功,加载了["+temp.size()+"]条");
				this.branchcompanyMap.remove(city);
				this.branchcompanyMap.put(city, temp);
				Log.cacheLog(serviceCode, serviceName, "按地市["+ city +"]加载分公司信息加载成功,加载了["+temp.size()+"]条");
			}//否则，保持旧内容不变
			i++;
		}

		logger.info("加载了"+branchcompanyMap.size()+"个的地市的分公司信息");
		Log.cacheLog(serviceCode, serviceName, "加载了"+branchcompanyMap.size()+"个的地市的分公司信息");
	} 
	
	/** 
	 * 按代码返回地市子公司的名称
	 */
	public String getCntcompanyName(String companyCode){
		ChPwCntycompany t = this.cntycompanyMap.get(companyCode);
		if (t!=null){
			return t.getCountycompname();
		}else{
			return companyCode;
		}
	} 

	/**
	 * 按地市标识提取地市分公司
	 * @param cityid 地市标识
	 * @return
	 */
	public Map<String, ChPwCntycompany> getBranchCntyComps(String cityid) {
		// TODO Auto-generated method stub
		return this.branchcompanyMap.get(cityid);
	}
	
	//Setter and getter
	/**
	 * @return the cntycompanyDao
	 */
	public ConstantDao getCntycompanyDao() {
		return cntycompanyDao;
	}

	/**
	 * @param cntycompanyDao the cntycompanyDao to set
	 */
	public void setCntycompanyDao(ConstantDao cntycompanyDao) {
		this.cntycompanyDao = cntycompanyDao;
	}
	

}
