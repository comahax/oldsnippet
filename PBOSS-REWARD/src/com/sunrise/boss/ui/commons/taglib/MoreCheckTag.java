package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.log4j.Logger;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

/**
 * Title:自定义标签
 * 
 * Description: 多选弹出框标签
 * 
 * Copyright: Copyright (c) 2006
 * 
 * Company: sunrise Tech Ltd.
 * 
 * @author mys
 * 
 * @version 1.0
 */
public class MoreCheckTag extends BaseFieldTag {
	
	private static Logger log = Logger.getRootLogger();
    
    private String definition;
    
    private String condition;  //过滤器,只保留指定条件的值
    
    private String  dbFlag;
    
    private String showonly;
    
    private String nameOnly;
    
    private boolean readonly = true;
    
    public MoreCheckTag() {
		super();
	}
    
    
    public String getNameOnly() {
		return nameOnly;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

	
	
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
    	
    public int doEndTag() throws JspTagException,JspException {
    	try{
	    	Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
	    	String value = "";
	    	if( obj != null ){
	    		value = obj.toString();
	    	}
	    	
	    	MoreCode2NameTag tag = new MoreCode2NameTag();
	    	tag.setCode(value);
	    	tag.setDefinition(definition);
	    	tag.setPageContext( pageContext );
	    
	    	inputHiddleText(value);	
	    	
	    	inputText(tag,value);
	    	
    	}catch ( Exception ex ) {
    		log.info("MoreCheck Tag error!");
    		log.error("MoreCheck Tag exception", ex);
    	}

        return EVAL_PAGE;
    }
    
    
    /**
     * 输出OnClick的html代码
     */
    private String jsOnClick(String value){
    	
    	String conditionvalue = "";
    	try{
    		conditionvalue = evaluateCondition();
    		if(conditionvalue == null) conditionvalue = "";
    	}catch(Exception ex){
    		log.info("MoreCheck Tag condition EL transfer error!");
    	}
    	
    	StringBuffer onclick = new StringBuffer(" onclick=\"getMoreCheck(");
    	
    	onclick.append("\'").append(URLEncoder.encode(definition)).append("\', ");    	
    	onclick.append("\'").append(conditionvalue).append("\', ");    	 	
    	onclick.append("\'").append(this.getProperty()).append("\', ");    	
    	onclick.append("\'").append(dbFlag).append("\' ");
    	
    	onclick.append(")\" ");
		return onclick.toString();
    }
    
    /**
     * 输出Text文本框的html代码
     */
    private void inputText(MoreCode2NameTag tag,String value){
    	try{
        	StringBuffer input = new StringBuffer();
        	input.append("<input type=\"text\" name=\"")
        		.append( this.getProperty()).append("_morecheck")
        		.append("\" value=\"");    	        	
        	
        	pageContext.getOut().write(input.toString());
        	tag.doEndTag();
        	input = new StringBuffer().append("\" ");
        	
        	if( !"true".equalsIgnoreCase(showonly)){
        		input.append(jsOnClick(value));
        	}
        	input.append(doElse()).append( prepareStyles() ).append(" ").append(prepareEventHandlers()).append("/>");
        	pageContext.getOut().write(input.toString());

        	
        	}catch(Exception ex){
        		log.info("MoreCheck Tag inputText error!");
        		log.error("MoreCheck Tag exception", ex);
        	}
    }
    
    
    /**
     * 输出hiddle文本框的html代码
     *
     */
    private void inputHiddleText(String value){
    	try{
	    	StringBuffer hidden = new StringBuffer();
	    	hidden.append("<input type=\"hidden\" name=\"").append( this.getProperty())
	    		.append("\" value=\"").append(value).append("\" ")
	    		.append(" />");
	    	pageContext.getOut().write(hidden.toString());	    	
	    	
    	}catch(Exception ex){
    		log.info("MoreCheck Tag inputHiddleText error!");
    		log.error("MoreCheck Tag exception", ex);
    	}

    }
    
   
    /**
     * 输出readonly或者Disabled属性
     */
    private String doElse() {
    	StringBuffer sb = new StringBuffer();
    	if( this.getReadonly() ){
    		sb.append( "readonly " );
    	}
    	if( this.getDisabled() ){
    		sb.append( "disabled " );
    	}
		return sb.toString();
    }
	
    
	private String evaluateCondition() throws JspException, NullAttributeException {
		String conditionValue = (String)ExpressionUtil.evalNotNull("ZoomTag", "condition", condition,
				Object.class, this, pageContext);
		return conditionValue;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getShowonly() {
		return showonly;
	}

	public void setShowonly(String showonly) {
		this.showonly = showonly;
	}

	public boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	
	
	
}
