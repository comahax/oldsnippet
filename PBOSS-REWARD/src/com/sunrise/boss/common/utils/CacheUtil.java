package com.sunrise.boss.common.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.resmanage.common.ComidTree;
import com.sunrise.boss.ui.resmanage.common.ComidTreeHelper;


public final class CacheUtil {

	public void clearData() {
		Cache cache = CacheSinglton.getInstance().getCache();
		try {
			if (cache.getSize() > 0)
				cache.removeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void refreshDictCache() {
		try {
			DictitemDelegate delegate = new DictitemDelegate();
			User usr = new User();
			usr.setCityid(SysInfo.COMMON_DB_FLAG);
			Collection dictList = delegate.doFindAll(usr);
			Iterator it = dictList.iterator();
			DictitemVO dictitem = null;
			Cache cache = CacheSinglton.getInstance().getCache();

			// System.out.print("+++++++++++++++++++++++++cache cap
			// size:"+cache.);
			Element element;

			String elemKey = "";
			while (it.hasNext()) {
				dictitem = (DictitemVO) it.next();

				elemKey = dictitem.getDictid() + "-" + dictitem.getGroupid();
				element = new Element(elemKey, dictitem);
				cache.put(element);
			}
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}
	
	
	public void refreshComidtree(){
		try{
			User usr = new User();
			usr.setCityid(SysInfo.COMMON_DB_FLAG);
			Cache cache = CacheSinglton.getInstance().getCache();//////////////
			
			Element element;
			String elementKey = "";
			ComidTree tree;
			Set set = ComidTreeHelper.comclassidMap.keySet();
			for (Iterator it = set.iterator();it.hasNext();){
				elementKey = (String)it.next();
				tree = new ComidTree(elementKey);
				element = new Element(elementKey,tree);
				cache.put(element);
			}
			
		}catch(Exception ne){
			ne.printStackTrace();
		}
	}
	
	public void refershPurviewData() {

	}

}
