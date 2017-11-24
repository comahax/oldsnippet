package com.sunrise.boss.ui.commons.taglib;

import java.io.*;
import java.util.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.*;
import org.apache.log4j.*;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;
import org.apache.taglibs.standard.tag.common.core.*;
import org.apache.taglibs.standard.tag.el.core.*;

import com.sunrise.boss.business.admin.dictitem.persistent.*;
import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.utils.bean.*;
import com.sunrise.boss.delegate.common.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.ui.commons.taglib.code2name.*;
import com.sunrise.boss.ui.commons.taglib.multibox.Multibox;

/**
 * Title:自定义标签
 * 
 * Description: 多选标签
 * 
 * Copyright: Copyright (c) 2006
 * 
 * Company: sunrise Tech Ltd.
 * 
 * @author wkx
 * 
 * @version 1.0
 */
public class MultiboxTag extends BaseFieldTag {

	private static Logger log = Logger.getRootLogger();

	private String definition;

//	private String property;



	 private boolean disabled=false ;

	private String condition; // 过滤器,只保留指定条件的值

	private String nameOnly; // false 使用code+name的lable显示；true

	// 只使用name的lable显示

	private String dbFlag;

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.multibox.impl.";

	public MultiboxTag() {
		super();
	}
	public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public int doEndTag() throws JspTagException, JspException {

		String servtypevalue = "";
//		Object bean = pageContext.getRequest().getAttribute(form);
		try {
			Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
			
	    
	  	if( obj != null ){
	    	servtypevalue = obj.toString();
	    	}
//			servtypevalue = (String) PropertyUtils.getProperty(bean, property);
		} catch (Exception ex) {
			// TODO 自动生成 catch 块
			ex.printStackTrace();
		}
		if (servtypevalue == null) {
			servtypevalue = "";
		}
		
		StringBuffer sbhidden = new StringBuffer();
    	sbhidden.append("<input  type=\"hidden\" name=\"").append( this.getProperty())
    		.append("\" value=\"").append(servtypevalue).append("\"  ")
    		.append(" >");
    	try {
			pageContext.getOut().write(sbhidden.toString());
		} catch (IOException e1) {
			
		}

		// String[] servtypes = servtypevalue.split(",");
		if (definition != null && definition.trim().length() > 0) {
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);

			User newUser = new User();

			try {
				BeanUtils.copyProperties(newUser, user);
			} catch (Exception e) {
				log.info("Multibox Tag exception", e);
				e.printStackTrace();
			}
			if (dbFlag != null && dbFlag.trim().length() > 0) {
				newUser.setCityid(dbFlag);
			}

			if (definition.indexOf(SYSCODE_FLAG) == 0) { // 查系统字典参数表里面的翻译
				try {
					CommonDelegate dictitemDelegate = new CommonDelegate(
							DictitemVO.class);
					DictitemListVO dictlistvo = new DictitemListVO();
					dictlistvo.set_se_groupid(definition.substring(1));
					dictlistvo.set_pagesize("0");
					dictlistvo.set_orderby("dictid");
					DataPackage dp = (DataPackage) dictitemDelegate.doQuery(
							dictlistvo, newUser);
					if (dp.getDatas() != null) {
						List dpList = (List) dp.getDatas();
						/**
						 * 没办法用java方法排序，只能寄希望于取系统参数表内容的时候已经有排序
						 */
				//		inputHiddleText(servtypevalue);
						writeAll(property,this.getDisabled() , servtypevalue);
						for (int i = 0; i < dpList.size(); i++) {
							DictitemVO dictVO = (DictitemVO) dpList.get(i);
							writeMultibox(dictVO.getDictid(), dictVO
									.getDictname(), property,this.getDisabled(),
									servtypevalue);
						}
						dp.getDatas().clear();
						dp = null;
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
					//	inputHiddleText(servtypevalue);
						writeAll(property, this.getDisabled(), servtypevalue);
						for (int i = 0; i < keys.length; i++) {
							Object key = keys[i];
							Object value = values.get(key);
							writeMultibox(key, value, property, this.getDisabled(),
									servtypevalue);
						}
					} else {
						writeAll(property, this.getDisabled(), servtypevalue);
						/** @todo 中文最好提到资源文件 */
					}
				} catch (Exception ex) {
					log.info("Code2name Tag exception", ex);
					ex.printStackTrace();
				}
			} else {// 实现Multibox接口
				Multibox instance = null;
				try {
					instance = (Multibox) Class.forName(
							CLASS_PREFIX + definition).newInstance();
					Map values = instance.valueList();
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
				//		inputHiddleText(servtypevalue);
						writeAll(property, this.getDisabled(), servtypevalue);
						for (int i = keys.length - 1; i >= 0; i--) {
							Object key = keys[i];
							Object value = values.get(key);
							writeMultibox(key, value, property, this.getDisabled(),
									servtypevalue);
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

 
    
   
	private void writeMultibox(Object code, Object ob, Object property,
			boolean disabled, String servtypevalue) throws JspTagException,
			IOException {
		String[] servtypes = servtypevalue.split(",");
		StringBuffer sb = new StringBuffer();
		String name = "";
		if (ob != null) {
			name = ob.toString();
		}
		if (code == null)
			sb.append("<checkbox ").append(">");
		else
		{	sb
					.append(
							"<div class=\"item_checkbox\"><input type=\"checkbox\" name=\"item_")
					.append(property).append("\" value=\"").append(code)
					.append("\" onclick=\"checkTheOne('formItem','").append(
							property).append("');\" class=\"table_checkbox\"");
		if (this.isDisabled()) {
			sb.append("disabled=\"disable\"");
		}
		if ("*,".equals(servtypevalue)) {
			sb.append("checked=\"checked\"");
		} else {
			for (int j = 0; j < servtypes.length; j++) {
				if (servtypes[j].equals(code.toString())) {
					sb.append("checked=\"checked\"");
					break;
				}
			}
		}
		sb.append(">");}
		if (this.nameOnly != null && this.nameOnly.equalsIgnoreCase("false")) {
			sb.append(code).append("\t");
		}
		sb.append(name).append("</div>");
		pageContext.getOut().println(sb.toString());
	}

	private void writeAll(Object property, boolean disabled, String servtypevalue)
			throws JspTagException, IOException {
		StringBuffer sb = new StringBuffer();
		// String name = "";
		sb
				.append(
						"<div class=\"item_checkbox\"><input type=\"checkbox\" name=\"item")
				.append(property)
				.append("\" value=\"on \" onclick=\"checkTheAll('formItem','")
				.append(property).append("');\" class=\"table_checkbox\"");
		if (this.isDisabled()) {
			sb.append("disabled=\"disable\"");
		}

		if ("*,".equals(servtypevalue)) {
			sb.append("checked=\"checked\"");
		}
		sb.append(">&nbsp;<font color=red>全选</font></div>");
		pageContext.getOut().println(sb.toString());
	}

	private String evaluateCondition() throws JspException,
			NullAttributeException {
		String conditionValue = (String) ExpressionUtil.evalNotNull("Multibox",
				"condition", condition, Object.class, this, pageContext);
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
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

/*	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}*/
	



	


/*	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}*/

}
