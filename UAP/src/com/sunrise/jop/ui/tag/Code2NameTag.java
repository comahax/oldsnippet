package com.sunrise.jop.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.UserProvider;
import com.sunrise.jop.ui.tag.component.Code2NameCom;

/**
 * Title:自定义标签
 * 
 * Description: 翻译标签
 * 
 * Copyright: Copyright (c) 2006
 * 
 * Company: sunrise Tech Ltd.
 * 
 * @author Huang BaiMing， He Kun
 * 
 * @version 1.0
 */
public class Code2NameTag extends ComponentTagSupport {

	private static final long serialVersionUID = 5307581419270193600L;

	private static Logger log = LoggerFactory.getLogger("com.sunrise.jop.code2name");

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	private String definition, code, dbFlag, split;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    	Code2NameCom code2NameCom =  new Code2NameCom(stack);
    	Class clazz = InterfaceUtils.getInstance().getImplClass(UserProvider.class);
    	UserProvider provider;
		try {
			provider = (UserProvider)clazz.newInstance();
			DBAccessUser user = (DBAccessUser)provider.getUser();// req.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	    	code2NameCom.setUser(user);
	    	return code2NameCom;
		} catch (Exception e) {		
			throw new IllegalArgumentException("Can't find or instant UserProvider's impl class! ");
		}
    }
    	
    
    /**
     * 填充主要属性
     */
    protected void populateParams() {    	
    	super.populateParams();
    	Code2NameCom d = (Code2NameCom)component;
    	d.setDefinition(definition);
    	d.setCode(code);
    	d.setDbFlag(dbFlag);    	
    	d.setSplit(split);    	
    }
    
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getSplit() {
		return split;
	}

	public void setSplit(String split) {
		this.split = split;
	}
}
