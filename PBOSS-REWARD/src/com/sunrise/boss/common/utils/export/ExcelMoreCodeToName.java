package com.sunrise.boss.common.utils.export;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.MoreCode2NameTag;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2NameConfiger;

public class ExcelMoreCodeToName {
	private static Logger log = Logger.getRootLogger();

	private String /*dbFlag,*/ split;

	static public final String SYSCODE_FLAG = "$";

	static public final String DEFAULT_SPLIT_FLAG = ",";

	static public final String CONFIG_FLAG = "#";

	static public final String DEFAULT_ALLNAME_FLAG = "全部匹配";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.morecode2name.impl.";

	

	public String moreCodeToName(String code, String codevalue, User user_1) {
		String theName =code;
		if (code != null && code.trim().length() > 0 && codevalue != null
				&& codevalue.trim().length() > 0) {

			/** 取得user和dbFlag(cityid) */
			User user = user_1;
			User newUser = new User();
			//changed by liwenjing
//			if (user == null)
//				user = new User();
			try {
				BeanUtils.copyProperties(newUser, user);
				if(newUser.getCityid()==null||newUser.getCityid().trim().length()<1){
					newUser.setCityid(SysInfo.COMMON_DB_FLAG);
				}
			} catch (Exception e) {
				log.info("MoreCode2name Tag exception", e);
				e.printStackTrace();
			}
			/*if (dbFlag != null && dbFlag.trim().length() > 0) {
				newUser.setCityid(dbFlag);
			}*/

			if (null == split || "".equals(split)) {
				split = DEFAULT_SPLIT_FLAG;
			}

			/** 三种翻译方式 */
			if (code.indexOf(SYSCODE_FLAG) == 0) {

				theName = doDict(newUser, code, codevalue); // 1.查系统字典参数表里面的翻译

			} else if (code.indexOf(CONFIG_FLAG) == 0) {

				theName = doConfig(newUser, code, codevalue); // 2.根据配置文件配置的单表相应的翻译

			} else {

				theName = doOther(newUser, code, codevalue); // 3.自定义方法，实现MoreCode2Name接口
			}

		}
		return theName;
	}

	/**
	 * 处理$字典表情况
	 */
	public String doDict(User user, String definition, String code) {
		String theName = null;
		try {
			String allcode = MoreCode2NameConfiger
					.getDictAllCodeProperty(definition.substring(1, definition
							.length()));
			if (code.equals(allcode)) {
				theName = getAllName(definition.substring(1, definition
						.length()), SYSCODE_FLAG, code);
			} else {
				String[] codekey = code.toString().split(split);

				if (!SysInfo.USE_CACHE_FLAG) {
					CommonDelegate dictitemDelegate = new CommonDelegate(
							DictitemVO.class);
					DictitemListVO dictlistvo = new DictitemListVO();
					dictlistvo.set_se_groupid(definition.substring(1));
					dictlistvo.set_pagesize("0");
					DataPackage dp = (DataPackage) dictitemDelegate.doQuery(
							dictlistvo, user);
					if (null != dp && null != dp.getDatas()
							&& dp.getDatas().size() > 0) {
						List dpList = (List) dp.getDatas();
						Map map = new LinkedHashMap();
						for (int i = 0; i < dpList.size(); i++) {
							DictitemVO dictVO = (DictitemVO) dpList.get(i);
							map.put(dictVO.getDictid(), dictVO.getDictname());
						}
						theName = getMoreName(map, codekey);

						dp.getDatas().clear();
						dp = null;
					}

				} else {
				
					Cache cache = CacheSinglton.getInstance().getCache();
					String key;
					String groupId = definition.substring(1);
					Iterator it = cache.getKeys().iterator();
					Map map = new LinkedHashMap();
					while (it.hasNext()) {
						key = (String) it.next();
						if (key.endsWith("-" + groupId)) {
							DictitemVO dictVO = (DictitemVO) cache.get(key)
									.getValue();
							map.put(dictVO.getDictid(), dictVO.getDictname());
						}
					}

					theName = getMoreName(map, codekey);
					// Modified end
				}

			}

		} catch (Exception ex) {
			log.info("MoreCode2Name Tag exception by doDict!");
			log.error("MoreCode2Name Tag exception", ex);
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
						moreName.append(getSplit());
					} else {
						if (null != codekey[i] && !"".equals(codekey[i])) {
							moreName.append(codekey[i]);
							moreName.append(getSplit());
						}
					}

				} else {
					if (null != codekey[i] && !"".equals(codekey[i])) {
						moreName.append(codekey[i]);
						moreName.append(getSplit());
					}
				}
			}
			return moreName.toString();
		}
		return null;
	}

	/**
	 * 判断全选有没有翻译，没有的话 全选缺省值 原样放回
	 * 
	 */
	private String getAllName(String definition, String falg, String allname) {
		String theName = "";

		if (null != allname && "".equals(allname.trim())) {
			theName = allname;
		} else if (SYSCODE_FLAG.equals(falg)) {
			try {
				theName = MoreCode2NameConfiger
						.getDictAllNameProperty(definition);
			} catch (Exception e) {
				log
						.info(
								"fail :  MoreCode2Name Tag exception by get Dict allname!",
								e);
			}
		} else if (CONFIG_FLAG.equals(falg)) {
			try {
				theName = MoreCode2NameConfiger.getAllNameProperty(definition);
			} catch (Exception e) {
				log.info("fail :  MoreCode2Name Tag exception by get allname!",
						e);
			}
		}
		if (null == theName || "".equals(theName))
			theName = DEFAULT_ALLNAME_FLAG;
		return theName;
	}

	/**
	 * 处理#自定义情况
	 */
	public String doConfig(User user, String definition, String code) {
		String theName = null;
		try {
			String allcode = MoreCode2NameConfiger
					.getAllCodeProperty(definition.substring(1, definition
							.length()));
			if (code.equals(allcode)) {
				theName = getAllName(definition.substring(1, definition
						.length()), CONFIG_FLAG, code);
			} else {
				String[] codekey = code.toString().split(split);
				Map map = MoreCode2NameConfiger.valueList(definition.substring(
						1, definition.length()), null, user.getCityid(), true);

				theName = getMoreName(map, codekey);
			}

		} catch (Exception ex) {
			log.info("MoreCode2Name Tag exception by doConfig!");
			log.error("MoreCode2Name Tag exception", ex);
		}
		return theName;
	}

	/**
	 * 自定义接口
	 */
	public String doOther(User user, String definition, String code) {
		String theName = null;
		MoreCode2Name instance = null;
		try {
			instance = (MoreCode2Name) Class.forName(CLASS_PREFIX + definition)
					.newInstance();
			theName = instance.translateMore(code, user);
		} catch (Exception ex) {
			log.info("MoreCode2Name Tag exception by doOther!");
			log.error("MoreCode2Name Tag exception", ex);
		}
		return theName;
	}

	public String getSplit() {
		return split;
	}

	public void setSplit(String split) {
		this.split = split;
	}

}
