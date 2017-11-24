package com.gmcc.pboss.web.resource.common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowDBParam;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowVO;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossVO;
import com.gmcc.pboss.control.resource.comtreeshow.ComtreeshowBO;
import com.gmcc.pboss.control.resource.simpleboss.SimplebossBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ComidTreeHelper {
	
	public static final Map comclassidMap = new HashMap();

	// 如果系统不用到缓存,则把商品标识树存储在treeMap里
	public static Map treeMap;

	public final static String[] comclassidnames = new String[] {"刮卡类","手机类", "手机配件类", "SIM套卡类", "电子充值券", "集团信息化产品产品设备", "赠送商品", "空白SIM卡", "USIM卡", "其他" };
	public final static String[] comclassids = new String[] {"0", "1","2", "3", "4", "5", "6", "7", "8", "99" };

	static {
		for (int i = 0;i < comclassids.length;i++){
			comclassidMap.put(comclassids[i], comclassidnames[i]);
		}
	}

	public static String getComtypeName(Integer comtype, User user) {
		String condition = "CODE:"+comtype;
		return Code2NameUtils.code2Name("$IM_COMTYPE", condition, user.getCityid());
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

		SimplebossBO simplebossdelgate = new SimplebossBO();
		ComtreeshowBO comtreeshowdelgate = new ComtreeshowBO();
		
		String wayid = user.getWayid();
		
		SimplebossVO simplebossvo = new SimplebossVO();
		String cityid = CityMappingUtil.getCityNo(user.getCityid());
		simplebossvo.setCityid(cityid);
		simplebossvo.setWayid(user.getWayid());
		SimplebossVO simplebossvo_query = null;
		if(null!=simplebossvo_query){
			int state = simplebossvo_query.getState().intValue();
			if(state==1){//该渠道启用了简版BOSS
				ComtreeshowDBParam comtreeshowlistvo = new ComtreeshowDBParam();
				comtreeshowlistvo.set_se_wayid(wayid);
				DataPackage comtreeshowdp = comtreeshowdelgate.doQuery(comtreeshowlistvo);
				Iterator it = comtreeshowdp.getDatas().iterator();
				while(it.hasNext()){
					ComtreeshowVO comtreeshowvo = (ComtreeshowVO)it.next();
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
