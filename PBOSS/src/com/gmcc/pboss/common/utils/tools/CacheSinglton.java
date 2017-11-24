package com.gmcc.pboss.common.utils.tools;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class CacheSinglton {
	private static CacheSinglton instance = null;
	private CacheManager manager;
	private CacheSinglton() {
		try {
			// URL url = getClass().getResource("/ehcache-config.xml");
			manager = CacheManager.create();
			
			Cache cache = new Cache("dictcache", 50000, false, true, 0, 0);
			//cache.
			manager.addCache(cache);
			if (cache != null)
				System.out.println("cache:" + cache);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CacheSinglton getInstance() {
		if (instance == null)
			instance = new CacheSinglton();

		return instance;
	}

	public Cache getCache() {
		return manager.getCache("dictcache");
	}
	/**
	 * ��������ȡ������,���ʹ�������������Ҫ��New һ��Cache���ӵ�CacheManager
	 * @param keyName
	 * @return
	 */
	public Cache getCache(String keyName) {
		return manager.getCache(keyName);
	}
}