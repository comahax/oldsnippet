package com.gmcc.pboss.common.utils.tools;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.web.resource.common.ComidTree;
import com.gmcc.pboss.web.resource.common.ComidTreeHelper;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;

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
			DictitemBO delegate = new DictitemBO();
			User usr = new User();
			usr.setCityid(CoreConfigInfo.COMMON_DB_NAME);
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

	public void refreshComidtree() {
		try {
			User usr = new User();
			usr.setCityid(CoreConfigInfo.COMMON_DB_NAME);
			Cache cache = CacheSinglton.getInstance().getCache();

			Element element;
			String elementKey = "";
			ComidTree tree;
			Set set = ComidTreeHelper.comclassidMap.keySet();
			for (Iterator it = set.iterator(); it.hasNext();) {
				elementKey = (String) it.next();
				tree = new ComidTree(elementKey);
				element = new Element(elementKey, tree);
				cache.put(element);
			}

		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

	public void refershPurviewData() {

	}

}
