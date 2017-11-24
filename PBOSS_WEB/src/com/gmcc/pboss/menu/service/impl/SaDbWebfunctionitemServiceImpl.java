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
		this.serviceName = "从各个地市库中加载菜单项";
		this.isNeedLogin = false;
	}
	
	//地址标识：ZS、ZH等21个地市标识
	private String[] cities;
	
	//获取系统参数
	private IbGlSysparamDao ibGlSysparamDao;
	
	//酬金是否显示
	protected Map<String,String> showReward = new HashMap<String,String>();
	
	//本地酬金是否显示
	protected Map<String,String> showLocalReward = new HashMap<String,String>();
	
	//Map<地市标识,Map<人员类型,Map<菜单主键,子菜单列表>>>
	protected Map<String,Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>>> menuTree = 
		new LinkedHashMap<String,Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>>>();

	//记录缓存日志：菜单加载信息
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(SaDbWebfunctionitemServiceImpl.class);
	
	/**
	 * 获取菜单类DAO对象
	 */
	private SaDbWebfunctionitemDao saDbWebfunctionitemDao;
	public void setSaDbWebfunctionitemDao(SaDbWebfunctionitemDao saDbWebfunctionitemDao){
		this.saDbWebfunctionitemDao = saDbWebfunctionitemDao;
	}
	
	/**
	 * 初始化数据
	 */
	public void init() {
		Log.cacheLog(this.serviceCode, this.serviceName, "------------------加载菜单到缓存开始");
		this.clear();//在重新加载之前先清空
		for(String city : cities){
			SessionFactoryContextHolder.setSessionFactoryContext(city);
			ibGlSysparamDao.reloadSessionFactory();
			saDbWebfunctionitemDao.reloadSessionFactory();
			
			System.out.println("------------------------开始加载"+city+"菜单----------------------------------");
			//酬金是否显示
			String paramReward = ibGlSysparamDao.getSysValue(1L, "pboss_Web");
			this.showReward.put(city, paramReward);
			//本地酬金是否显示
			String paramLocalReward = ibGlSysparamDao.getSysValue(2L, "pboss_Web");
			this.showLocalReward.put(city, paramLocalReward);
			
			List<SaDbWebfunctionitem> menuList = this.saDbWebfunctionitemDao.getAllMenu();
			//System.out.println("加载菜单-"+city+"-"+menuList.size()+"条");
			SaDbWebfunctionitem root = null;
			List<SaDbWebfunctionitem> masterList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> missionerList = new ArrayList<SaDbWebfunctionitem>();			
			List<SaDbWebfunctionitem> deliveryList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> managerList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> gdmanagerList = new ArrayList<SaDbWebfunctionitem>();
			List<SaDbWebfunctionitem> citymanagerList = new ArrayList<SaDbWebfunctionitem>();
			for(int i=0;i<menuList.size();i++){
				SaDbWebfunctionitem item = menuList.get(i);
//				System.out.println("菜单类型-"+item.getType());
				switch((int)item.getType()){
					case 0:
						root = item;//根节点，是一个标记节点
						break;
					case 1:
						masterList.add(item);//店员店主使用
						break;
					case 2:
						missionerList.add(item);//推广专员
						break;
					case 3:
						deliveryList.add(item);//配送商
						break;
					case 4:
						managerList.add(item);//渠道经理
						break;
					case 5:
						gdmanagerList.add(item);//省管理员
						break;
					case 6:
						citymanagerList.add(item);//市管理员
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
			System.out.println("------------------------完成加载"+city+"菜单----------------------------------");
			//this.print(cityMap);
			logger.info("地市公司["+city+"]加载菜单到缓存-共"+menuList.size()+"条");
			Log.cacheLog(this.serviceCode, this.serviceName, "地市公司["+city+"]加载菜单到缓存-共"+menuList.size()+"条");
			this.printMenuCache(cityMap);
		}
		Log.cacheLog(this.serviceCode, this.serviceName, "------------------加载菜单到缓存完成");
//		SessionFactoryContextHolder.setSessionFactoryContext(null);
//		ibGlSysparamDao.reloadSessionFactory();
	}
	
	private void print(Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>> map){
		for(int type:map.keySet()){
			Map<String,ArrayList<SaDbWebfunctionitem>> values = map.get(type);
			System.out.println("人员类型 "+type+"：");
			for(String parent:values.keySet()){
				System.out.println("\t "+parent+"：");
				List<SaDbWebfunctionitem> child = values.get(parent);
				for(SaDbWebfunctionitem item:child){
					System.out.println("\t\t"+item.getFuncid()+" "+item.getFuncname());//+"："
				}				
			}
		}		
	}
	
	private void printMenuCache(Map<Integer,Map<String,ArrayList<SaDbWebfunctionitem>>> map){
		StringBuffer sb = new StringBuffer();
		for(int type:map.keySet()){
			Map<String,ArrayList<SaDbWebfunctionitem>> values = map.get(type);
			sb.append("人员类型 "+type+"：\n");
			for(String parent:values.keySet()){
				sb.append("\t "+parent+"：\n");
				List<SaDbWebfunctionitem> child = values.get(parent);
				for(SaDbWebfunctionitem item:child){
					sb.append("\t\t"+item.getFuncid()+" "+item.getFuncname()+"\n");//+"："
				}				
			}
		}
		Log.cacheLog(this.serviceCode, this.serviceName, "\n"+sb.toString());
	}
	
	private Map filterMasterMenu(Map menuMap,String paramReward,String paramLocalReward){
		List rewardSub = (ArrayList)menuMap.get("REWARD");//获取REWARD二级菜单项
		if(rewardSub==null){//酬金模块不可见
			//this.menuMapForDistributer = menuMap;
			return menuMap;
		}
		Iterator iter = null;
		//是否显示酬金模块：不需要显示酬金模块，将其从Map中删除
		if( !paramReward.equals("1") ){
			//删除三级菜单
			for(int i=0;i<rewardSub.size();i++){
				String key = ((SaDbWebfunctionitem)rewardSub.get(i)).getFuncid();
				menuMap.remove(key);
			}
			//删除二级菜单
			menuMap.remove("REWARD");
			//从根菜单中把酬金项一级菜单删除
			ArrayList rootSub = (ArrayList)menuMap.get("ROOT");
			for(Iterator iterator = rootSub.iterator();iterator.hasNext();){
				if(((SaDbWebfunctionitem)iterator.next()).getFuncid().equals("REWARD")){
					iterator.remove();
					break;
				}
			}
			menuMap.put("ROOT", rootSub);//此行代码应该可以注释掉
			//menuMapForDistributer = menuMap;
			return menuMap;
		}
		/***/
		//显示酬金模块，是否显示本地酬金模块：根据用户信息不同，生成不同的三级菜单
		if( paramLocalReward.equals("1")  ){//显示：酬金查询
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( !temp.getFuncid().equals("RewardLocal")){
					String key = temp.getFuncid();
					menuMap.remove(key);//删除其三级子菜单
					iter.remove();//删除对应的二级菜单项
				}
			}
		}
		else{//显示：酬金报表和酬金明细查询
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( temp.getFuncid().equals("RewardLocal") ){
					String key = temp.getFuncid();
					menuMap.remove(key);//删除其三级子菜单
					iter.remove();//删除对应的二级菜单项
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
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>菜单项刷新");
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX我进入了刷新方法");
		init();
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX我退出了刷新方法");
	}	
	/**
	 * 清理
	 */
	public void clear() {
		// TODO Auto-generated method stub
		this.showReward.clear();
		this.showLocalReward.clear();
		this.menuTree.clear();
	}
	
	public Map getMenuMap(String city, int type){
		if(type==0){//店员与店主菜单相同
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
	 * 将所有菜单信息读入一个Map中，用于在页面显示
	 * @param loginMember 登陆用户
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
	 * 店员店主：获取菜单项
	 * @param loginMember
	 * @return
	 */
	private Map getMasterMenu(LoginMember loginMember){
		LoginMember member = loginMember;
//		Map menuMap = this.saDbWebfunctionitemDao.getMenuMap(member);//获取所有菜单项
		Map menuMap = this.saDbWebfunctionitemDao.getMenuMap(Short.parseShort(member.getIsnet().toString()));//获取所有菜单项
		
		List rewardSub = (ArrayList)menuMap.get("REWARD");//获取REWARD二级菜单项
		if(rewardSub==null){//酬金模块不可见
			//this.menuMapForDistributer = menuMap;
			return menuMap;
		}
		Iterator iter = null;
		//是否显示酬金模块：不需要显示酬金模块，将其从Map中删除
		if( !member.getIsShowReward().equals("1") ){
			//删除三级菜单
			for(int i=0;i<rewardSub.size();i++){
				String key = ((SaDbWebfunctionitem)rewardSub.get(i)).getFuncid();
				menuMap.remove(key);
			}
			//删除二级菜单
			menuMap.remove("REWARD");
			//从根菜单中把酬金项一级菜单删除
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
		//显示酬金模块，是否显示本地酬金模块：根据用户信息不同，生成不同的三级菜单
		if( member.getIsShowLocalReward().equals("1")  ){//显示：酬金查询
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( !temp.getFuncid().equals("RewardLocal")){
					String key = temp.getFuncid();
					menuMap.remove(key);//删除其三级子菜单
					iter.remove();//删除对应的二级菜单项
				}
			}
		}
		else{//显示：酬金报表和酬金明细查询
			for(iter = rewardSub.iterator();iter.hasNext();){
				SaDbWebfunctionitem temp = (SaDbWebfunctionitem)iter.next();
				if( temp.getFuncid().equals("RewardLocal") ){
					String key = temp.getFuncid();
					menuMap.remove(key);//删除其三级子菜单
					iter.remove();//删除对应的二级菜单项
				}
			}
		}
		//menuMapForDistributer = menuMap;
		return menuMap;
	}
	
	/**
	 * 配送商：获取配送商菜单项
	 */
	private Map getDeliveryMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * 经理人员:获取经理人员菜单项
	 */
	private Map getManagerMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * 省管理员:获取省管理员菜单项
	 */
	private Map getGdmanagerMenu(short type){
//		return this.saDbWebfunctionitemDao.getMenuMap(loginMember);
		return this.saDbWebfunctionitemDao.getMenuMap(type);
	}
	
	/**
	 * 市管理员:获取市管理员菜单项
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
