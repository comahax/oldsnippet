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
 * �̶���������
 * @author tangzhu
 * @date 2009-12-22
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class ConstantServiceImpl extends BaseServiceImpl implements
		ConstantService {
	/**
	 * ϵͳ�̶���Ϣ����
	 */
	protected Map<String,Map<String,SaDbDictitem>> constantMap = new LinkedHashMap<String, Map<String,SaDbDictitem>>();
	/**
	 * ���зֹ�˾����
	 */
	protected Map<String,ChPwCntycompany> cntycompanyMap = new LinkedHashMap<String,ChPwCntycompany>();
	/**
	 * �����д�ŵ��зֹ�˾��Ϣ
	 */
	protected Map<String,Map<String,ChPwCntycompany>> branchcompanyMap = new LinkedHashMap<String,Map<String,ChPwCntycompany>>();
	
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(ConstantServiceImpl.class);

	protected ConstantDao cntycompanyDao;
	
	public ConstantServiceImpl() {
		this.serviceCode = ServiceCode.CONSTANT_LOAD;
		this.serviceName = "�����ݿ��м��ع̶�����";
	}

	public Map<String, String> getConstantMap(String groupid) {
		// TODO Auto-generated method stub
		Map<String, SaDbDictitem> dtlMap = this.constantMap.get(groupid);
		
		//���ȡ��Ϊ�����¼���
		if(dtlMap == null ){
			this.init();
			dtlMap = this.constantMap.get(groupid);
		}
		
		Map<String,String> rtn = new LinkedHashMap<String, String>();
		String key;
		SaDbDictitem dtl;
		//��װ��������
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
		
		//���ȡ��Ϊ�����¼���
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
		//sb.append("δ֪�̶�����[")
		//.append(groupid).append('_')
		//.append(dictid).append("]�̶�����");
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
	 * ��ʼ������
	 */
	public void init() {
		// TODO Auto-generated method stub
		//��װ��ѯ����,�ֶ�����
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
			//@@�����Ż�
			this.clear();//����ѱ���Ĳ���
			for (SaDbDictitem dtl:allDictitem){
				inGroupid = dtl.getId().getGroupid();
				inDictid = dtl.getId().getDictid();
				//���������ж�
				if (this.constantMap.containsKey(inGroupid)){
					temp = this.constantMap.get(inGroupid);
					temp.put(inDictid, dtl);
				}else{
					temp = new LinkedHashMap<String, SaDbDictitem>();//�����ڣ���LinkedHashMap
					temp.put(inDictid, dtl);
					this.constantMap.put(inGroupid, temp);
				}
				//�����ݷ����ڴ�
			}//for
			temp = null;
			//��ʾ������Ϣ
			for (String dGroupid:groupid){
				temp = this.constantMap.get(dGroupid);
				
				StringBuffer info = new StringBuffer();
				String desc = mapGroupid.get(dGroupid);
				
				if (temp!=null){
					
					info.append(desc).append('[').append(dGroupid).append("]�ɹ����أ�").append(temp.size());
					//logger.info(info.toString());
				}else{
					info.append(desc).append('[').append(dGroupid).append("]����ʧ��");
					logger.warn(info.toString());
				}
				
				Log.cacheLog(serviceCode, serviceName, info.toString());
			}
			//���ص����ӹ�˾
			List<ChPwCntycompany> cntycompany = this.getCntycompanyDao().getAll();
			for (ChPwCntycompany obj:cntycompany){
				this.cntycompanyMap.put(obj.getCountycompid(), obj);
			}
			logger.info("�����ӹ�˾��Ϣ���سɹ�,������["+cntycompanyMap.size()+"]��");
			Log.cacheLog(serviceCode, serviceName, "�����ӹ�˾��Ϣ���سɹ�,������["+cntycompanyMap.size()+"]��");
		}else{
			logger.error("�̶�������Ϊ��!");
		}
		//���ص��зֹ�˾
		this.loadBranchCntyComp();
	}
	public void refresh() {
		// TODO Auto-generated method stub
		init();
	}
	
	/**
	 * ���зֹ�˾���� - ���зֹ�˾����ĵ����б�
	 */
	private void loadBranchCntyComp(){
		String[] allCity = null;
		//��ȡ��Ҫ����ĵ����б�
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
		//��˳����ص��зֹ�˾��Ϣ
		int i=0;
		for (String city:allCity){
			param.setCitycompid(city);
			List<ChPwCntycompany> cityAll = this.getCntycompanyDao().getAll(proc, param).getData();
			Map<String,ChPwCntycompany> temp = new LinkedHashMap<String, ChPwCntycompany>();
			for (ChPwCntycompany dtl:cityAll){
				temp.put(dtl.getCountycompid(), dtl);
			}//�ϳ�List
			
			//�滻Map����
			//�ж��Ƿ�Ҫ�滻
			if (temp.size()>0){
				logger.info("������["+ city +"]���طֹ�˾��Ϣ���سɹ�,������["+temp.size()+"]��");
				this.branchcompanyMap.remove(city);
				this.branchcompanyMap.put(city, temp);
				Log.cacheLog(serviceCode, serviceName, "������["+ city +"]���طֹ�˾��Ϣ���سɹ�,������["+temp.size()+"]��");
			}//���򣬱��־����ݲ���
			i++;
		}

		logger.info("������"+branchcompanyMap.size()+"���ĵ��еķֹ�˾��Ϣ");
		Log.cacheLog(serviceCode, serviceName, "������"+branchcompanyMap.size()+"���ĵ��еķֹ�˾��Ϣ");
	} 
	
	/** 
	 * �����뷵�ص����ӹ�˾������
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
	 * �����б�ʶ��ȡ���зֹ�˾
	 * @param cityid ���б�ʶ
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
