package com.gmcc.pboss.menu.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.menu.dao.SaDbWebfunctionitemDao;
import com.gmcc.pboss.menu.model.SaDbWebfunctionitem;
import com.gmcc.pboss.menu.service.SaDbWebfunctionitemService;
import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;

public class SaDbWebfunctionitemServiceImpl extends BaseServiceImpl implements
		SaDbWebfunctionitemService {
	public SaDbWebfunctionitemServiceImpl(){
		this.serviceCode = ServiceCode.MENU_LOAD;
		this.serviceName = "�Ӹ������п��м��ز˵���";
		this.isNeedLogin = false;
	}
	
	//��ַ��ʶ��ZS��ZH��21�����б�ʶ
	private String[] cities;
	
	//��ȡϵͳ����
	private IbGlSysparamDao ibGlSysparamDao;
	
	//����Ƿ���ʾ
	protected Map<String,String> showReward = new HashMap<String,String>();
	
	//���س���Ƿ���ʾ
	protected Map<String,String> showLocalReward = new HashMap<String,String>();
	
	//Map<���б�ʶ,Map<��Ա����,Map<�˵�����,�Ӳ˵��б�>>>
	protected Map<String,Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>>> menuTree = 
		new LinkedHashMap<String,Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>>>();

	//��¼������־���˵�������Ϣ
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(SaDbWebfunctionitemServiceImpl.class);
	
	/**
	 * ��ȡ�˵���DAO����
	 */
	private SaDbWebfunctionitemDao saDbWebfunctionitemDao;
	public void setSaDbWebfunctionitemDao(SaDbWebfunctionitemDao saDbWebfunctionitemDao){
		this.saDbWebfunctionitemDao = saDbWebfunctionitemDao;
	}
	
	/**
	 * ��ʼ������
	 */
	public void init() {
		Log.cacheLog(this.serviceCode, this.serviceName, "------------------���ز˵������濪ʼ");
		this.clear();//�����¼���֮ǰ�����
		for(String city : cities){
			SessionFactoryContextHolder.setSessionFactoryContext(city);
			ibGlSysparamDao.reloadSessionFactory();
			saDbWebfunctionitemDao.reloadSessionFactory();
			
			System.out.println("------------------------��ʼ����"+city+"�˵�----------------------------------");
			//����Ƿ���ʾ
			String paramReward = ibGlSysparamDao.getSysValue(1L, "pboss_Web");
			this.showReward.put(city, paramReward);
			//���س���Ƿ���ʾ
			String paramLocalReward = ibGlSysparamDao.getSysValue(2L, "pboss_Web");
			this.showLocalReward.put(city, paramLocalReward);
			
			List<SaDbWebfunctionitem> menuList = this.saDbWebfunctionitemDao.getAllMenu();
			//System.out.println("���ز˵�-"+city+"-"+menuList.size()+"��");
			SaDbWebfunctionitem root = null;
			List<SaDbWebfunctionitem> masterList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> missionerList = new ArrayList<SaDbWebfunctionitem>();			
			List<SaDbWebfunctionitem> deliveryList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> managerList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> gdmanagerList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> citymanagerList = new ArrayList<SaDbWebfunctionitem>();
			for(int i=0;i<menuList.size();i++){
				SaDbWebfunctionitem item = menuList.get(i);
//				System.out.println("�˵�����-"+item.getType());
				switch((int)item.getType()){
					case 0:
						root = item;//���ڵ㣬��һ����ǽڵ�
						break;
					case 1:
						masterList.add(item);//��Ա����ʹ��
						break;
					case 2:
						missionerList.add(item);//�ƹ�רԱ
						break;
					case 3:
						deliveryList.add(item);//������
						break;
					case 4:
						managerList.add(item);//��������
						break;
					case 5:
						gdmanagerList.add(item);//ʡ����Ա
						break;
					case 6:
						citymanagerList.add(item);//�й���Ա
						break;
					default:
						;						
				}
			}
			Map masterMap = this.createMenuTree(masterList);
			masterMap = this.filterMasterMenu(masterMap,paramReward,paramLocalReward);
			Map missionerMap = this.createMenuTree(missionerList);
			Map deliveryMap = this.createMenuTree(deliveryList);			
			Map managerMap = this.createMenuTree(managerList);
			Map gdmanagerMap = this.createMenuTree(gdmanagerList);
			Map citymanagerMap = this.createMenuTree(citymanagerList);
			Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>> cityMap = 
				new LinkedHashMap<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>>();
			cityMap.put(1, masterMap);
			cityMap.put(2, missionerMap);
			cityMap.put(3, deliveryMap);
			cityMap.put(4, managerMap);
			cityMap.put(5, gdmanagerMap);
			cityMap.put(6, citymanagerMap);
			this.menuTree.put(city, cityMap);
			System.out.println("------------------------��ɼ���"+city+"�˵�----------------------------------");
			//this.print(cityMap);
			logger.info("���й�˾["+city+"]���ز˵�������-��"+menuList.size()+"��");
			Log.cacheLog(this.serviceCode, this.serviceName, "���й�˾["+city+"]���ز˵�������-��"+menuList.size()+"��");
			this.printMenuCache(cityMap);
		}
		Log.cacheLog(this.serviceCode, this.serviceName, "------------------���ز˵����������");
//		SessionFactoryContextHolder.setSessionFactoryContext(null);
//		ibGlSysparamDao.reloadSessionFactory();
	}
	
	private void print(Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>> map){
		for(int type:map.keySet()){
			Map<String,ArrayList<SaDbWebfunctionitem>> values = map.get(type);
			System.out.println("��Ա���� "+type+"��");
			for(String parent:values.keySet()){
				System.out.println("\t "+parent+"��");
				List<SaDbWebfunctionitem> child = values.get(parent);
				for(SaDbWebfunctionitem item:child){
					System.out.println("\t\t"+item.getFuncid()+" "+item.getFuncname());//+"��"
				}				
			}
		}		
	}
	
	private void printMenuCache(Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>> map){
		StringBuffer sb = new StringBuffer();
		for(int type:map.keySet()){
			Map<String,ArrayList<SaDbWebfunctionitem>> values = map.get(type);
			sb.append("��Ա���� "+type+"��\n");
			for(String parent:values.keySet()){
				sb.append("\t "+parent+"��\n");
				List<SaDbWebfunctionitem> child = values.get(parent);
				for(SaDbWebfunctionitem item:child){
					sb.append("\t\t"+item.getFuncid()+" "+item.getFuncname()+"\n");//+"��"
				}				
			}
		}
		Log.cacheLog(this.serviceCode, this.serviceName, "\n"+sb.toString());
	}
	
	private Map filterMasterMenu(Map menuMap,String paramReward,String paramLocalReward){
		List rewardSub = (ArrayList)menuMap.get("REWARD");//��ȡREWARD�����˵���
		if(rewardSub==null){//���ģ�鲻�ɼ�
			//this.menuMapForDistributer = menuMap;
			return menuMap;
		}
		Iterator iter = null;
		//�Ƿ���ʾ���ģ�飺����Ҫ��ʾ���ģ�飬�����Map��ɾ��
		if( !paramReward.equals("1") ){
			//ɾ�������˵�
			for(int i=0;i<rewardSub.size();i++){
				String key = ((SaDbWebfunctionitem)rewardSub.get(i)).getFuncid();
				menuMap.remove(key);
			}
			//ɾ�������˵�
			menuMap.remove("REWARD");
			//�Ӹ��˵��аѳ����һ���˵�ɾ��
			ArrayList rootSub = (ArrayList)menuMap.get("ROOT");
			for(Iterator iterator = rootSub.iterator();iterator.hasNext();){
				if(((SaDbWebfunctionitem)iterator.next()).getFuncid().equals("REWARD")){
					iterator.remove();
					break;
				}
			}
			menuMap.put("ROOT", rootSub);//���д���Ӧ�ÿ���ע�͵�
			//menuMapForDistributer = menuMap;
			return menuMap;
		}
		/***/
		//��ʾ���ģ�飬�Ƿ���ʾ���س��ģ�飺�����û���Ϣ��ͬ�����ɲ�ͬ�������˵�
		if( paramLocalReward.equals("1")  ){//��ʾ������ѯ
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( !temp.getFuncid().equals("RewardLocal")){
					String key = temp.getFuncid();
					menuMap.remove(key);//ɾ���������Ӳ˵�
					iter.remove();//ɾ����Ӧ�Ķ����˵���
				}
			}
		}
		else{//��ʾ����𱨱�ͳ����ϸ��ѯ
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( temp.getFuncid().equals("RewardLocal") ){
					String key = temp.getFuncid();
					menuMap.remove(key);//ɾ���������Ӳ˵�
					iter.remove();//ɾ����Ӧ�Ķ����˵���
				}
			}
		}
		//menuMapForDistributer = menuMap;
		return menuMap;
	}
	private Map createMenuTree(List<SaDbWebfunctionitem> menuItem){
		Map map = new HashMap<String,ArrayList<SaDbWebfunctionitem>>();
		ArrayList<SaDbWebfunctionitem> children = null;
		SaDbWebfunctionitem item = null;
		for(int i=0;i<menuItem.size();i++){
			item = menuItem.get(i);
			String parentId = item.getParentid();
			if(map.containsKey(parentId)){
				children = (ArrayList)map.get(parentId);
				children.add(item);
				map.put(parentId,children);
			}
			else{
				children = new ArrayList<SaDbWebfunctionitem>();
				children.add(item);
				map.put(parentId, children);
			}
		}
		return map;
	}
	public void refresh() {
		// TODO Auto-generated method stub
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>�˵���ˢ��");
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX�ҽ�����ˢ�·���");
		init();
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX���˳���ˢ�·���");
	}	
	/**
	 * ����
	 */
	public void clear() {
		// TODO Auto-generated method stub
		this.showReward.clear();
		this.showLocalReward.clear();
		this.menuTree.clear();
	}
	
	public Map getMenuMap(String city, int type){
		if(type==0){//��Ա������˵���ͬ
			type = 1;
		}
		return this.menuTree.get(city).get(type);
	}
	public String getShowReward(String city){
		return this.showReward.get(city);
		
	}
	public String getShowLocalReward(String city){
		return this.showLocalReward.get(city);
	}
	
	/**
	 * �����в˵���Ϣ����һ��Map�У�������ҳ����ʾ
	 * @param loginMember ��½�û�
	 * @return      KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(LoginMember loginMember){
		LoginMember member = loginMember;
		short isnet = Short.parseShort(member.getIsnet().toString());
		Map map = new HashMap<String,ArrayList<SaDbWebfunctionitem>>();
		switch(isnet){
			case 0:
			case 1:
				map = this.getMasterMenu(loginMember);
				break;
			case 3:
				map = this.getDeliveryMenu(isnet);
				break;
			case 4:
				map = this.getManagerMenu(isnet);
				break;
			case 5:
				map = this.getGdmanagerMenu(isnet);
				break;
			case 6:
				map = this.getCitymanagerMenu(isnet);
				break;
			default:
				;
		}
		return map;
	}
	
	/**
	 * ��Ա��������ȡ�˵���
	 * @param loginMember
	 * @return
	 */
	private Map getMasterMenu(LoginMember loginMember){
		LoginMember member = loginMember;
//		Map menuMap = this.saDbWebfunctionitemDao.getMenuMap(member);//��ȡ���в˵���
		Map menuMap = this.saDbWebfunctionitemDao.getMenuMap(Short.parseShort(member.getIsnet().toString()));//��ȡ���в˵���
		
		List rewardSub = (ArrayList)menuMap.get("REWARD");//��ȡREWARD�����˵���
		if(rewardSub==null){//���ģ�鲻�ɼ�
			//this.menuMapForDistributer = menuMap;
			return menuMap;
		}
		Iterator iter = null;
		//�Ƿ���ʾ���ģ�飺����Ҫ��ʾ���ģ�飬�����Map��ɾ��
		if( !member.getIsShowReward().equals("1") ){
			//ɾ�������˵�
			for(int i=0;i<rewardSub.size();i++){
				String key = ((SaDbWebfunctionitem)rewardSub.get(i)).getFuncid();
				menuMap.remove(key);
			}
			//ɾ�������˵�
			menuMap.remove("REWARD");
			//�Ӹ��˵��аѳ����һ���˵�ɾ��
			ArrayList rootSub = (ArrayList)menuMap.get("ROOT");
			for(Iterator iterator = rootSub.iterator();iterator.hasNext();){
				if(((SaDbWebfunctionitem)iterator.next()).getFuncid().equals("REWARD")){
					iterator.remove();
					break;
				}
			}
			menuMap.put("ROOT", rootSub);
			//menuMapForDistributer = menuMap;
			return menuMap;
		}
		/***/
		//��ʾ���ģ�飬�Ƿ���ʾ���س��ģ�飺�����û���Ϣ��ͬ�����ɲ�ͬ�������˵�
		if( member.getIsShowLocalReward().equals("1")  ){//��ʾ������ѯ
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( !temp.getFuncid().equals("RewardLocal")){
					String key = temp.getFuncid();
					menuMap.remove(key);//ɾ���������Ӳ˵�
					iter.remove();//ɾ����Ӧ�Ķ����˵���
				}
			}
		}
		else{//��ʾ����𱨱�ͳ����ϸ��ѯ
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( temp.getFuncid().equals("RewardLocal") ){
					String key = temp.getFuncid();
					menuMap.remove(key);//ɾ���������Ӳ˵�
					iter.remove();//ɾ����Ӧ�Ķ����˵���
				}
			}
		}
		//menuMapForDistributer = menuMap;
		return menuMap;
	}
	
	/**
	 * �����̣���ȡ�����̲˵���
	 */
	private Map getDeliveryMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * ������Ա:��ȡ������Ա�˵���
	 */
	private Map getManagerMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * ʡ����Ա:��ȡʡ����Ա�˵���
	 */
	private Map getGdmanagerMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * �й���Ա:��ȡ�й���Ա�˵���
	 */
	private Map getCitymanagerMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}
	
	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
}
