package com.gmcc.pboss.web.resource.common;

import java.util.Iterator;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.utils.tools.CacheSinglton;
import com.gmcc.pboss.web.resource.com.ComWebParam;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.struts2.BaseAction;

public class ComidTreeAction extends BaseAction {
	public ComidTreeAction() {
		super();
		this.setParam(new ComWebParam());
	}
	
	public String doComidfilter() throws Exception {
		String filterFlag = "";
		ComWebParam param = (ComWebParam) super.getParam();
		if (!StringUtils.isBlank(param.get_ne_comid())) {
			filterFlag += param.get_ne_comid() + ",";
		}
		if (!StringUtils.isBlank(param.get_sk_comname())) {
			filterFlag += param.get_sk_comname();
		}
		if (filterFlag.indexOf("&") != -1) {
			filterFlag = filterFlag.replaceAll("&", "_amp");
		}

		ServletActionContext.getRequest().setAttribute("filterFlag", filterFlag);

		return ("list");

	}

	public String doFresh() throws Exception {

		refreshComidtree();
		ServletActionContext.getRequest().setAttribute("filterFlag", "");

		return ("list");

	}

	private synchronized void refreshComidtree() {
		if (CoreConfigInfo.USE_CACHE_FLAG) {
			try {
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
		} else {
			ComidTreeHelper.initTreeMap();
		}
	}
}
