package com.sunrise.jop.infrastructure.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheFactory {
	
	private static Log log = LogFactory.getLog(CacheFactory.class);
	public static CacheManager cacheManager;
	static {		
		try {
			cacheManager = CacheManager.create( CacheFactory.class.getResource("/ehcache.xml"))	;
			
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}
		
	public  static CacheManager getCacheManager() {
		return cacheManager;
	}
	
	public static void logStatistics() {
		if(log.isDebugEnabled()) 
			log.debug("************ Cache Report start*******************************");
		String[] cacheNames = CacheFactory.getCacheManager().getCacheNames();
		for(int i=0 ; i < cacheNames.length ; i++) {
			Cache cache =  CacheFactory.getCacheManager().getCache(cacheNames[i]);
			
			if(log.isDebugEnabled()) 
				log.debug(cacheNames[i] + ":  " + cache.getStatistics());
		}
		if(log.isDebugEnabled()) 
			log.debug("************ Cache Report end *******************************");
	}
}
