package com.gmcc.pboss.web.resource.common.quartz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gmcc.pboss.common.utils.tools.CacheSinglton;
import com.gmcc.pboss.web.common.xtree.WebFXLoadTreeHelpBean;
import com.gmcc.pboss.web.resource.common.ComidTree;
import com.gmcc.pboss.web.resource.common.ComidTreeHelper;

public class ComidTreeJob implements Job{
	
	public static final Log log = LogFactory.getLog(ComidTreeJob.class);
	private static final HashMap<String, Integer> monitorMap = new HashMap<String, Integer>();

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		refreshComidTreeCache();
		monitorWebFxLoadTreeHashMap();
	}
	
	//刷新ComidTree缓存
	private void refreshComidTreeCache(){
		// TODO Auto-generated method stub
		try{
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
			log.info("-------------------------------------");
			log.info("------ Refresh ComidTree Cache ------");
			log.info("-------------------------------------");
		}catch (Exception e) {
			// TODO: handle exception
			if(log.isErrorEnabled()) log.error(e);
			e.printStackTrace();
		}
		
	}
	
	//监控WebFXLoadTreeHelpBean辅助类内存占用空间
	private void monitorWebFxLoadTreeHashMap(){
		for(Iterator ittHelpKey = WebFXLoadTreeHelpBean.strHashMap.keySet().iterator(); ittHelpKey.hasNext(); ){
			String parentNodeKey = (String)ittHelpKey.next();
			if(WebFXLoadTreeHelpBean.strHashMap.get(parentNodeKey) == null){
				continue;
			}else{
				if(monitorMap.get(parentNodeKey) == null){
					monitorMap.put(parentNodeKey, WebFXLoadTreeHelpBean.strHashMap.get(parentNodeKey).size()); //如果监控Map找不到,则将List的大小放入监控中
				}else{
					if(monitorMap.get(parentNodeKey).intValue() == WebFXLoadTreeHelpBean.strHashMap.get(parentNodeKey).size()){
						//比较大小,如果大小一致,则认为两者在半个钟内占用了内存无使用,进行清理
						WebFXLoadTreeHelpBean.strHashMap.get(parentNodeKey).clear();
						WebFXLoadTreeHelpBean.strHashMap.put(parentNodeKey, null);
						log.info("------------------------------------------------------------");
						log.info("| WebFXLoadTreeHelpBean.strHashMap "+parentNodeKey+" Clear |");
						log.info("------------------------------------------------------------");
					}else{
						//否则进行更新
						monitorMap.put(parentNodeKey, WebFXLoadTreeHelpBean.strHashMap.get(parentNodeKey).size());
					}
				}
			}
		}
	}
	
}
