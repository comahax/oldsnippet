package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import net.sf.ehcache.Cache;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.taglib.html.Constants;
import org.apache.struts.taglib.html.SelectTag;
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
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.options.Options;

/**
 * Created by IntelliJ IDEA. User: langx Date: 2006-8-18 Time: 15:34:32 To
 * change this template use File | Settings | File Templates.
 */
public class OptionsTag extends TagSupport {

	private static Logger log = Logger.getRootLogger();

	private String definition;

	private String condition; // 过滤器,只保留指定条件的值

	private String nameOnly; // false 使用code+name的lable显示；true

	// 只使用name的lable显示

	private String dbFlag;

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.options.impl.";

	public OptionsTag() {
		super();
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public int doEndTag() throws JspTagException, JspException {

		SelectTag selectTag = (SelectTag) pageContext
				.getAttribute(Constants.SELECT_KEY);
		if (selectTag == null) {
			throw new JspException("OptionsTag.select");
		}

		if (definition != null && definition.trim().length() > 0) {

			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);

			User newUser = new User();

			try {
				BeanUtils.copyProperties(newUser, user);
			} catch (Exception e) {
				log.info("Code2name Tag exception", e);
				e.printStackTrace();
			}
			if (dbFlag != null && dbFlag.trim().length() > 0) {
				newUser.setCityid(dbFlag);
			}

			if (definition.indexOf(SYSCODE_FLAG) == 0) { // 查系统字典参数表里面的翻译
				try {
					if (!SysInfo.USE_CACHE_FLAG) {
						CommonDelegate dictitemDelegate = new CommonDelegate(
								DictitemVO.class);
						DictitemListVO dictlistvo = new DictitemListVO();
						dictlistvo.set_se_groupid(definition.substring(1));
						dictlistvo.set_pagesize("0");
						DataPackage dp = (DataPackage) dictitemDelegate
								.doQuery(dictlistvo, newUser);
						if (dp.getDatas() != null) {
							List dpList = (List) dp.getDatas();
							// * 没办法用java方法排序，只能寄希望于取系统参数表内容的时候已经有排序
							for (int i = 0; i < dpList.size(); i++) {
								DictitemVO dictVO = (DictitemVO) dpList.get(i);
								writeOption(dictVO.getDictid(), dictVO
										.getDictname(), selectTag
										.isMatched(dictVO.getDictid()));
							}
							dp.getDatas().clear();
							dp = null;
						}

					} else {
						// Modified by Ge Aiping 16-Oct-2006
						Cache cache = CacheSinglton.getInstance().getCache();
						String key;
						String groupId = definition.substring(1);
						Iterator it = cache.getKeys().iterator();
						while (it.hasNext()) {
							key = (String) it.next();
							if (key.endsWith("-" + groupId)) {
								DictitemVO dictVO = (DictitemVO) cache.get(key)
										.getValue();
								writeOption(dictVO.getDictid(), dictVO
										.getDictname(), selectTag
										.isMatched(dictVO.getDictid()));
							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					/** @todo add log */
				}
			} else if (definition.indexOf(CONFIG_FLAG) == 0) { // 根据配置文件配置的单表相应的翻译
				/** @todo 添加参数 */
				try {
					String conditionValue = null;
					if (!StringUtils.isEmpty(condition)) {
						conditionValue = evaluateCondition();
					}

					Map values = Code2NameConfiger.valueList(definition
							.substring(1, definition.length()), conditionValue,
							newUser.getCityid());

					if (values != null && !values.isEmpty()) {
						Object[] keys = values.keySet().toArray();
						/**
						 * 用自然排序，以升序排列，依次列成option选项
						 */
						try {
							Arrays.sort(keys);
						} catch (Exception e) {
							e.printStackTrace();
						}
						for (int i = 0; i < keys.length; i++) {
							Object key = keys[i];
							Object value = values.get(key);
							writeOption(key, value, selectTag.isMatched(String
									.valueOf(key)));
						}
					} else {
						writeOption(null, "请选择", selectTag.isMatched(null));
						/** @todo 中文最好提到资源文件 */
					}
				} catch (Exception ex) {
					log.info("Code2name Tag exception", ex);
					ex.printStackTrace();
				}
			} else {// 实现Options接口
				Options instance = null;
				try {
					instance = (Options) Class.forName(
							CLASS_PREFIX + definition).newInstance();
					Map values = instance.valueList(user);
					if (values != null && !values.isEmpty()) {
						Object[] keys = values.keySet().toArray();
						/**
						 * 用自然排序，以升序排列，依次列成option选项
						 */
						try {
							Arrays.sort(keys);
						} catch (Exception e) {
							e.printStackTrace();
						}
						for (int i = keys.length - 1; i >= 0; i--) {
							Object key = keys[i];
							Object value = values.get(key);
							writeOption(key, value, selectTag.isMatched(String
									.valueOf(key)));
						}
						values.clear();
						values = null;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}

		return EVAL_PAGE;
	}

	private void writeOption(Object code, Object ob, boolean ismatch)
			throws JspTagException, IOException {
		StringBuffer sb = new StringBuffer();
		String name = "";
		if (ob != null) {
			name = ob.toString();
		}
		if (code == null)
			sb.append("<option value=\"\" ").append(">");
		else
			sb.append("<option value=\"").append(code).append("\" ").append(
					(ismatch ? "selected" : "")).append(">");
		if (this.nameOnly != null && this.nameOnly.equalsIgnoreCase("false")) {
			sb.append(code).append("\t");
		}
		sb.append(name).append("</option>");
		pageContext.getOut().println(sb.toString());
	}

	private String evaluateCondition() throws JspException,
			NullAttributeException {
		String conditionValue = (String) ExpressionUtil.evalNotNull(
				"Code2Name", "condition", condition, Object.class, this,
				pageContext);
		return conditionValue;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getNameOnly() {
		return nameOnly;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

}
