package com.sunrise.boss.ui.commons.taglib.morecode2name.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.i18n.I18nMessage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.MoreCode2NameTag;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.morecode2name.Node;

public class GetDoPayMode extends MoreCode2NameTag implements MoreCode2Name {

	/** value 传值过来 */
	public String translateMore(Object value, User user) throws Exception {

		String codeValue = "";
		if (value == null)
			return codeValue;
		codeValue = value.toString();
		String theName = codeValue;

		String allcode = MoreCode2NameConfiger
				.getDictAllCodeProperty("IB_PAYMODETYPE");
		if (codeValue.equals(allcode)) {
			theName = getAllName();
		} else {
			String[] codekey = codeValue.toString().split(",");
			Map map = new LinkedHashMap();
			map = (Map) getList(null, user);
			if (map != null && map.size() != 0)
				theName = getMoreName(map, codekey);
			map.clear();
		}
		return theName;
	}

	/**
	 * 判断有没有翻译，没有的话code值原样放回
	 * 
	 */
	private String getMoreName(Map map, String[] codekey) {
		if (map != null) {
			StringBuffer moreName = new StringBuffer();
			for (int i = 0; i < codekey.length; i++) {
				String ketName = "";
				if (map.containsKey(codekey[i])) {
					ketName = (String) map.get(codekey[i]);

					if (null != ketName && !"".equals(ketName)) {
						moreName.append(ketName);
						moreName.append(",");
					} else {
						if (null != codekey[i] && !"".equals(codekey[i])) {
							moreName.append(codekey[i]);
							moreName.append(",");
						}
					}

				} else {
					if (null != codekey[i] && !"".equals(codekey[i])) {
						moreName.append(codekey[i]);
						moreName.append(",");
					}
				}
			}
			return moreName.toString();
		}
		return "";
	}

	/** params 可以传listvo过来 ，获取分页信息；或者是自己定义的bean等等 */
	public Object getList(Object params, User user) throws Exception {
		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		DictitemListVO dictForm = new DictitemListVO();
		dictForm.set_se_groupid("IB_PAYMODETYPE");
		dictForm.set_pagesize("0");
		DataPackage dp = (DataPackage) dictitemDelegate.doQuery(dictForm, user);
		Map map = new LinkedHashMap();
		if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
			List dpList = (List) dp.getDatas();
			DictitemVO vo = new DictitemVO();
			vo.setDictid("-1");
			vo.setGroupid("IB_PAYMODETYPE");
			vo.setDictname(I18nMessage.getString(
					"com.sunrise.boss.resource.i18n.fee.credit.CredStateChg",
					"addpaymode", new Locale("zh", "CN")));
			dpList.add(vo);
			// dp.setDatas(dpList);

			for (int i = 0; i < dpList.size(); i++) {
				DictitemVO dictVO = (DictitemVO) dpList.get(i);
				map.put(dictVO.getDictid(), dictVO.getDictname());
			}
			/*
			 * if (null != dp && null != dp.getDatas() && dp.getDatas().size() >
			 * 0) { List list = new ArrayList(); for (Iterator iter =
			 * dp.getDatas().iterator();iter.hasNext();) { DictitemVO dictvo =
			 * (DictitemVO) iter.next(); Node node = new Node();
			 * node.setCode(dictvo.getDictid());
			 * node.setName(dictvo.getDictname()); list.add(node); }
			 * dp.setDatas(list); return list; }
			 */}
		dp.getDatas().clear();
		dp = null;
		return map;
	}

	public String getAllName() throws Exception {
		return "全部匹配";
	}

	public String getAllCode() throws Exception {
		return "*,";
	}

	public Object getObject(Object params, User user) throws Exception {
		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		DictitemListVO dictForm = new DictitemListVO();
		dictForm.set_se_groupid("IB_PAYMODETYPE");
		dictForm.set_pagesize("10");
		DataPackage dp = (DataPackage) dictitemDelegate.doQuery(dictForm, user);
		List dpList = (List) dp.getDatas();
		DictitemVO vo = new DictitemVO();
		vo.setDictid("-1");
		vo.setGroupid("IB_PAYMODETYPE");
		vo.setDictname(I18nMessage.getString(
				"com.sunrise.boss.resource.i18n.fee.credit.CredStateChg",
				"addpaymode", new Locale("zh", "CN")));
		dpList.add(vo);
		dp.setDatas(dpList);

		if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
			List list = new ArrayList();
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				DictitemVO dictvo = (DictitemVO) iter.next();
				Node node = new Node();
				node.setCode(dictvo.getDictid());
				node.setName(dictvo.getDictname());
				list.add(node);
			}
			dp.setDatas(list);

		}
		return dp;
	}

}
