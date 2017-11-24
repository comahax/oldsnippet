package com.sunrise.boss.ui.resmanage.common;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.resmanage.com.ComForm;

public class ComidTreeAction extends BaseAction {
	public ActionForward doComidfilter(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String filterFlag = "";
		ComForm form = (ComForm) actionForm;
		if (!StringUtils.isBlank(form.get_sk_comid())) {
			filterFlag += form.get_sk_comid() + ",";
		}
		if (!StringUtils.isBlank(form.get_sk_comname())) {
			filterFlag += form.get_sk_comname();
		}
		if (filterFlag.indexOf("&") != -1) {
			filterFlag = filterFlag.replaceAll("&", "_amp");
		}

		request.setAttribute("filterFlag", filterFlag);

		return (actionMapping.findForward("list"));

	}

	public ActionForward doFresh(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		refreshComidtree();
		request.setAttribute("filterFlag", "");

		return (actionMapping.findForward("list"));

	}

	private synchronized void refreshComidtree() {
		if (SysInfo.USE_CACHE_FLAG) {
			try {
				Cache cache = CacheSinglton.getInstance().getCache();// ////////////

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
