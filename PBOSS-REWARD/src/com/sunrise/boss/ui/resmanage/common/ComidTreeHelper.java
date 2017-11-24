package com.sunrise.boss.ui.resmanage.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.business.resmanage.simplebossconfig.comtreeshow.persistent.ComtreeShowListVO;
import com.sunrise.boss.business.resmanage.simplebossconfig.comtreeshow.persistent.ComtreeShowVO;
import com.sunrise.boss.business.resmanage.simplebossconfig.simpleboss.persistent.SimpleBossVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

public class ComidTreeHelper {
	
	public static final Map comclassidMap = new HashMap();

	// 如果系统不用到缓存,则把商品标识树存储在treeMap里
	public static Map treeMap;

	public final static String[] comclassidnames = new String[] {"刮卡类",
			"手机类", "手机配件类", "SIM套卡类", "电子充值券", "集团信息化产品产品设备", "赠送商品", "实体营销卡", "其他" };

	public final static String[] comclassids = new String[] {"0", "1",
			"2", "3", "4", "5", "6", "10", "99" };

	static {
		for (int i = 0;i < comclassids.length;i++){
			comclassidMap.put(comclassids[i], comclassidnames[i]);
		}
	}

	public static String getComtypeName(Long comtype, User user) {
		String name = comtype.toString();
		try {
			DictitemDelegate dt = new DictitemDelegate();
			DictitemVO pk = new DictitemVO();
			pk.setDictid(comtype.toString());
			pk.setGroupid("IM_COMTYPE");
			DictitemVO vo = dt.doFindByPk(pk, user);
			if (vo != null) {
				name = vo.getDictname();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	
	public static Map getConditions(String condition) {
		Map map = new HashMap();
		if (condition == null || condition.trim().length() < 1) {
			return map;
		}
		List comclassids = new ArrayList();
		List comtypes = new ArrayList();
		String comclassid;
		String comtype;
		String[] conditions = condition.split(";");
		for (int i = 0; i < conditions.length; i++) {
			if (conditions[i].indexOf("comclassid") != -1){
				comclassid = conditions[i].substring(conditions[i].indexOf(":") + 1);
				if (!comclassids.contains(comclassid)){
					comclassids.add(comclassid);
				}
			}else if (conditions[i].indexOf("comtype") != -1){
				comtype = conditions[i].substring(conditions[i].indexOf(":") + 1);
				if (!comtypes.contains(comtype)){
					comtypes.add(comtype);
				}
			}	
		}
		if (!comclassids.isEmpty()){
			Collections.sort(comclassids);
			map.put("comclassid", comclassids);
		}
		if (!comtypes.isEmpty()){
			map.put("comtype", comtypes);
		}
		return map;
	}
	
	
	/**
	 * 为简版BOSS而增加的方法
	 * 直接查询表im_pr_comtreeshow
	 * add time:20081209
	 * @param condition
	 * @return
	 */
	public static Map getConditions2(User user)throws Exception{
		Map map = new HashMap();
		
		Set comclassidSet = new HashSet();
		Set comtypeSet = new HashSet();
		
		List comclassidList = new ArrayList();
		List comtypeList = new ArrayList();

		CommonDelegate simplebossdelgate = new CommonDelegate(SimpleBossVO.class);
		CommonDelegate comtreeshowdelgate = new CommonDelegate(ComtreeShowVO.class);
		
		String wayid = user.getWayid();
		
		SimpleBossVO simplebossvo = new SimpleBossVO();
		simplebossvo.setCityid(new Long(user.getCityid()));
		simplebossvo.setWayid(user.getWayid());
		SimpleBossVO simplebossvo_query = null;
		if(null!=simplebossvo_query){
			int state = simplebossvo_query.getState().intValue();
			if(state==1){//该渠道启用了简版BOSS
				ComtreeShowListVO comtreeshowlistvo = new ComtreeShowListVO();
				comtreeshowlistvo.set_se_wayid(wayid);
				DataPackage comtreeshowdp = comtreeshowdelgate.doQuery(comtreeshowlistvo,user);
				Iterator it = comtreeshowdp.getDatas().iterator();
				while(it.hasNext()){
					ComtreeShowVO comtreeshowvo = (ComtreeShowVO)it.next();
					int avtivestate = comtreeshowvo.getState().intValue();
					if(avtivestate==1){
						comclassidSet.add(comtreeshowvo.getComclassid().toString());
						comtypeSet.add(comtreeshowvo.getComtype().toString());
					}//if
				}//while
				
				if(!comclassidSet.isEmpty()){
					Iterator comclassidsetit = comclassidSet.iterator();
					while(comclassidsetit.hasNext()){
						comclassidList.add(comclassidsetit.next());
					}
				}
				
				if(!comtypeSet.isEmpty()){
					Iterator comtypesetit = comtypeSet.iterator();
					while(comtypesetit.hasNext()){
						comtypeList.add(comtypesetit.next());
					}
				}

				
			}//if(state==1){
		}//if(null!=simplebossvo_query){

		if (!comclassidList.isEmpty()){
			map.put("comclassid", comclassidList);
		}
		if (!comtypeList.isEmpty()){
			map.put("comtype", comtypeList);
		}
		
		return map;
	}
	
	
	
	
	public static boolean doFilter(ComVO vo ,String filterFlag){
		if (vo == null){
			return false;
		}
		if (filterFlag.indexOf("_amp") != -1){
			filterFlag = filterFlag.replaceAll("_amp", "&");
		}
		String comid = vo.getComid().toString();
		String comname = vo.getComname();
		String likeComid = null;
		String likeComname = null;
		
		String[] comidName = filterFlag.split("\\,");
		//请参考ComidtreeAction中组装filterFlag的过程
		if (filterFlag.indexOf(",") != -1){		
			if (comidName.length ==2){
				likeComid = comidName[0];
				likeComname = comidName[1];
			}else {
				likeComid = comidName[0];
			}
		}else {
			likeComname = filterFlag;
		}
		if (comidName.length == 1){
			if ((likeComid != null && comid.indexOf(likeComid) != -1) || (likeComname != null && comname != null && comname.indexOf(likeComname) != -1)){
				return true;
			}
		}else {
			if (comid.indexOf(likeComid) != -1 && comname.indexOf(likeComname) != -1){
				return true;
			}
		}
		return false;
	}

	public static void initTreeMap() {
		if (treeMap == null) {
			treeMap = new HashMap();
		}
		treeMap.clear();

		ComidTree tree;
		String treeKey;

		Set set = ComidTreeHelper.comclassidMap.keySet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			treeKey = (String) it.next();
			tree = new ComidTree(treeKey);
			treeMap.put(treeKey, tree);
		}
	}
}
