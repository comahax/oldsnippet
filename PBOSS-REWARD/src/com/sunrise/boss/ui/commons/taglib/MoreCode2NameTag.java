package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2NameConfiger;

/**
 * Title:自定义标签
 * 
 * Description: 翻译标签
 * 
 * Copyright: Copyright (c) 2006
 * 
 * Company: sunrise Tech Ltd.
 * 
 * @author mys
 * 
 * @version 1.0
 */
public class MoreCode2NameTag extends BodyTagSupport {

	private static final long serialVersionUID = 5307581419270193600L;

	private static Logger log = Logger.getRootLogger();

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	static public final String DEFAULT_SPLIT_FLAG = ",";

	static public final String DEFAULT_ALLNAME_FLAG = "全部匹配";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.morecode2name.impl.";

	public MoreCode2NameTag() {
		super();
	}

	private String definition, code, dbFlag, split, allname;

	private Object codeValue;

	public String getAllname() {
		return allname;
	}

	public void setAllname(String allname) {
		this.allname = allname;
	}

	public String getSplit() {
		return split;
	}

	public void setSplit(String split) {
		this.split = split;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int doStartTag() {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		if (definition != null && definition.trim().length() > 0
				&& code != null && code.trim().length() > 0) {
			try {
				evaluateExpressions();
			} catch (JspException ex) {
				return EVAL_PAGE;
			}

			/** 取得user和dbFlag(cityid) */
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			User newUser = new User();
			//changed by liwenjing
//			if (user == null)
//				user = new User();
			try {
				BeanUtils.copyProperties(newUser, user);
			} catch (Exception e) {
				log.info("Code2name Tag exception", e);
				e.printStackTrace();
			}
			if (dbFlag != null && dbFlag.trim().length() > 0) {
				newUser.setCityid(dbFlag);
			}

			if (null == split || "".equals(split)) {
				split = DEFAULT_SPLIT_FLAG;
			}

			/** 三种翻译方式 */
			String theName = null;
			if (definition.indexOf(SYSCODE_FLAG) == 0) {

				theName = doDict(newUser); // 1.查系统字典参数表里面的翻译

			} else if (definition.indexOf(CONFIG_FLAG) == 0) {

				theName = doConfig(newUser); // 2.根据配置文件配置的单表相应的翻译

			} else {

				theName = doOther(newUser); // 3.自定义方法，实现MoreCode2Name接口
			}

			/** 判断有法翻译，没有的话code值原样放回 */
			try {
				if (theName != null) {
					pageContext.getOut().print(theName);
				} else {
					pageContext.getOut().print(codeValue);
				}
			} catch (IOException ex) {
				log.info("MoreCode2Name Tag exception by pageContext!");
			}
		}
		return EVAL_PAGE;
	}

	/**
	 * 处理$字典表情况
	 */
	public String doDict(User user) {
		String theName = null;
		try {
			String allcode = MoreCode2NameConfiger
					.getDictAllCodeProperty(definition.substring(1, definition
							.length()));
			if (codeValue.equals(allcode)) {
				theName = getAllName(definition.substring(1, definition
						.length()), SYSCODE_FLAG);
			} else {
				String[] codekey = codeValue.toString().split(split);
				/*
				 * CommonDelegate dictitemDelegate = new
				 * CommonDelegate(DictitemVO.class); DictitemListVO dictlistvo =
				 * new DictitemListVO();
				 * dictlistvo.set_se_groupid(definition.substring(1,
				 * definition.length())); dictlistvo.set_pagesize("0");
				 * dictlistvo.set_desc("0"); dictlistvo.set_orderby("dictid");
				 * 
				 * DataPackage dp =
				 * (DataPackage)dictitemDelegate.doQuery(dictlistvo, user);
				 * 
				 * if( null != dp && null != dp.getDatas() &&
				 * dp.getDatas().size() > 0 ){ List dpList =
				 * (List)dp.getDatas(); Map map = new LinkedHashMap(); for( int
				 * i=0 ;i<dpList.size(); i++ ){ DictitemVO dictVO =
				 * (DictitemVO)dpList.get(i); map.put(dictVO.getDictid(),
				 * dictVO.getDictname()); } theName = getMoreName(map,codekey);
				 * 
				 * dp.getDatas().clear(); dp = null; }
				 */

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
					// Modified by Ge Aiping 26-Oct-2006
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
					//Modified end
				}

			}

		} catch (Exception ex) {
			log.info("MoreCode2Name Tag exception by doDict!");
			log.error("MoreCode2Name Tag exception", ex);
		}
		return theName;
	}

	/**
	 * 处理#自定义情况
	 */
	public String doConfig(User user) {
		String theName = null;
		try {
			String allcode = MoreCode2NameConfiger
					.getAllCodeProperty(definition.substring(1, definition
							.length()));
			if (codeValue.equals(allcode)) {
				theName = getAllName(definition.substring(1, definition
						.length()), CONFIG_FLAG);
			} else {
				String[] codekey = codeValue.toString().split(split);
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
	public String doOther(User user) {
		String theName = null;
		MoreCode2Name instance = null;
		try {
			instance = (MoreCode2Name) Class.forName(CLASS_PREFIX + definition)
					.newInstance();
			theName = instance.translateMore(codeValue, user);
		} catch (Exception ex) {
			log.info("MoreCode2Name Tag exception by doOther!");
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
	private String getAllName(String definition, String falg) {
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

	/* Evaluates expressions as necessary */
	private void evaluateExpressions() throws JspException,
			NullAttributeException {
		codeValue = ExpressionUtil.evalNotNull("Code2Name", "code", code,
				Object.class, this, pageContext);
	}

}
