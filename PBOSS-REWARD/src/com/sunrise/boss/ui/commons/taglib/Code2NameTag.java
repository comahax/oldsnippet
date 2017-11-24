package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;
import com.sunrise.boss.ui.commons.tools.RequestCacheUtils;

/**
 * Title:自定义标签
 * 
 * Description: 翻译标签
 * 
 * Copyright: Copyright (c) 2006
 * 
 * Company: sunrise Tech Ltd.
 * 
 * @author Huang BaiMing
 * 
 * @version 1.0
 */
public class Code2NameTag extends BodyTagSupport {

	private static final long serialVersionUID = 5307581419270193600L;

	private static Logger log = Logger.getRootLogger();

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.code2name.impl.";

	public Code2NameTag() {
		super();
	}

	private String definition, code, dbFlag;

	private Object codeValue;

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
	
	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public int doEndTag() throws JspException {
		if (definition != null && definition.trim().length() > 0 && code != null && code.trim().length() > 0) {
			try {
				evaluateExpressions();
			} catch (JspException ex) {
				return EVAL_PAGE;
			}

			/** 取得user和dbFlag(cityid) */
			User user = (User) pageContext.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			User newUser = new User();

			try {
				BeanUtils.copyProperties(newUser, user);
			} catch (Exception ex) {
				code2NameLog("Code2name Tag exception", ex);
			}
			if (dbFlag != null && dbFlag.trim().length() > 0) {
				newUser.setCityid(dbFlag);
			}

			/** 三种翻译方式 */
			String theName = null;
			if (definition.indexOf(SYSCODE_FLAG) == 0) { // 1.查系统字典参数表里面的翻译
				String groupId = definition.substring(1, definition.length());
				theName = getFromSystemParam(newUser, groupId);
			} else if (definition.indexOf(CONFIG_FLAG) == 0) { // 2.根据配置文件配置的单表相应的翻译
				theName = getFromConfig(newUser);
			} else { // 3.自定义方法，实现Code2Name接口
				theName = getFromInterface(newUser);
			}

			/** 判断有没翻译，没有的话code值原样放回 */
			try {
				if (theName != null) {
					pageContext.getOut().print(theName);
				} else {
					pageContext.getOut().print(codeValue);
				}
			} catch (IOException ex) {
				code2NameLog("Code2name Tag exception", ex);
			}
		}
		return EVAL_PAGE;
	}

	// 1.查系统字典参数表里面的翻译
	private String getFromSystemParam(User newUser, String groupId) {
		String theName = null;
		try {
			DictitemVO vo = new DictitemVO();
			if (!SysInfo.USE_CACHE_FLAG) { // 判断是否使用缓存
				CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
				vo.setGroupid(groupId);
				vo.setDictid(codeValue.toString());
				vo = (DictitemVO) dictitemDelegate.doFindByPk(vo, newUser);
			} else {
				// modify by Ge Aiping on 16-Oct-2006
				try {
					Cache cache = CacheSinglton.getInstance().getCache();
					if (cache.get(codeValue.toString() + "-" + groupId) != null) {
						vo = (DictitemVO) cache.get(codeValue.toString() + "-" + groupId).getValue();
					}
				} catch (Exception ex) {
					code2NameLog("get Cache Error:", ex);
				}
				// modify End
			}

			if (null != vo) {
				theName = vo.getDictname();
			}
		} catch (Exception ex) {
			code2NameLog("Code2name Tag(1) exception", ex);
		}
		return theName;
	}

	// 2.根据配置文件配置的单表相应的翻译
	private String getFromConfig(User newUser) {
		String theName = RequestCacheUtils.get(pageContext.getRequest(), definition + "-" + code); // 从requestCache里取翻译
		if (theName == null) {
			try {
				Object obj = Code2NameConfiger.getName(definition.substring(1, definition.length()), codeValue, newUser.getCityid());
				if (obj != null) {
					theName = obj.toString();
					RequestCacheUtils.put(pageContext.getRequest(), definition + "-" + code, theName);// 把翻译缓存在requestCache里
				}
			} catch (Exception ex) {
				code2NameLog("Code2name Tag(2) exception", ex);
			}
		}
		return theName;
	}

	// 3.自定义方法，实现Code2Name接口
	private String getFromInterface(User newUser) {
		String theName = RequestCacheUtils.get(pageContext.getRequest(), definition + "-" + code); // 从requestCache里取翻译
		if (theName == null) {
			try {
				Code2name instance = (Code2name) Class.forName(CLASS_PREFIX + definition).newInstance();
				theName = instance.translate(codeValue, newUser);
				if(theName!=null){
					RequestCacheUtils.put(pageContext.getRequest(), definition + "-" + code, theName);// 把翻译缓存在requestCache里
				}
			} catch (Exception ex) {
				code2NameLog("Code2name Tag(3) exception", ex);
			}
		}
		return theName;
	}

	// 自定义格式的日志输出
	private void code2NameLog(String message, Exception ex) {
		log.info("--------");
		log.info("definition:" + definition + ",code:" + code);
		log.info(message, ex);
		log.info("--------");
	}

	/* Evaluates expressions as necessary */
	private void evaluateExpressions() throws JspException, NullAttributeException {
		codeValue = ExpressionUtil.evalNotNull("Code2Name", "code", code, Object.class, this, pageContext);
	}

}
