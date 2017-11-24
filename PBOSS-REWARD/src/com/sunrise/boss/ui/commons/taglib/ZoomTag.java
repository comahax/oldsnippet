package com.sunrise.boss.ui.commons.taglib;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.jsp.*;

import org.apache.log4j.*;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.*;
import org.apache.taglibs.standard.tag.common.core.*;
import org.apache.taglibs.standard.tag.el.core.*;

/**
 * Created by IntelliJ IDEA.
 * User: langx
 * Date: 2006-8-18
 * Time: 15:34:32
 * To change this template use File | Settings | File Templates.
 */
public class ZoomTag extends BaseFieldTag {
	
	private static Logger log = Logger.getRootLogger();
    
    protected String definition;
    
    protected String condition;  //过滤器,只保留指定条件的值
    
    protected String  dbFlag;
    
    protected String showonly;
    
    protected String nameOnly;
    
    protected boolean readonly = true;
    
    private static String checkebox=";EBOXUNIT;WOFF-EBOXUNIT";
    private static String checkacct=";ACCTNAME;ZIFEE-ACCTNAME;WOFF-ACCT";
    
	public String getNameOnly() {
		return nameOnly;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

	public ZoomTag() {
		super();
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
	    	
	    	if(checkebox.indexOf(definition.substring(1))>=0){
	    		EboxAcctTag eatag=new EboxAcctTag();
	    		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(eatag, this);
	    		eatag.setPageContext(pageContext);
	    		eatag.setParent(this.getParent());
	    		eatag.setType("EBOXUNIT");
	    		eatag.setProperty(this.getProperty());
	    		return eatag.doEndTag();
	    	}
	    	if(checkacct.indexOf(definition.substring(1))>=0){
	    		EboxAcctTag eatag=new EboxAcctTag();
	    		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(eatag, this);
	    		eatag.setPageContext(pageContext);
	    		eatag.setParent(this.getParent());
	    		eatag.setType("ACCT");
	    		eatag.setProperty(this.getProperty());
	    		return eatag.doEndTag();
	    	}
	    	Code2NameTag tag = new Code2NameTag();
	    	tag.setCode(value);
	    	tag.setDefinition(definition);
	    	tag.setPageContext( pageContext );
	    
	    	StringBuffer sbhidden = new StringBuffer();
	    	sbhidden.append("<input type=\"hidden\" name=\"").append( this.getProperty())
	    		.append("\" value=\"").append(value).append("\"  ")
	    		.append(" >");
	    	pageContext.getOut().write(sbhidden.toString());
	    	
	    	StringBuffer input = new StringBuffer();
	    	input.append("<input type=\"text\" name=\"")
	    		.append( this.getProperty()).append("_zoom")
	    		.append("\" value=\"");
	    	
	    	if( "false".equals(nameOnly) ) {
	    		input.append(value).append("");
	    	}
	    	pageContext.getOut().write(input.toString());
	    	tag.doEndTag();
	    	input = new StringBuffer().append("\" ");
	    	if( !"true".equals(showonly) && readonly ){
	    		input.append(" onclick=\"showzoom")
	    			.append(property).append("()\" ");
	    	}
	    	if( !readonly ){
	    		input.append("onchange=\"changedata").append(getProperty()).append("();\" onkeydown=\"document.forms[0].").append(property).append(".value=''\" ");
	    	}
	    	input.append(doElse()).append( prepareStyles() ).append( " ").append(prepareEventHandlers()).append("/>");
	    	pageContext.getOut().write(input.toString());
	    	
	    	if( !readonly ) {
	    		input = new StringBuffer();
	    		input.append("<input type=\"button\" value=\"...\" class=\"clickbutton\" ");
	    		input.append(" onclick=\"showzoom")
    				.append(property).append("()\" ");
	    		input.append(" > ");
	    		
	    		if( getOnchange() != null ) {
	    			throw new JspTagException("如果是可录入编辑框不支持onchange事件！");
	    		}
	    		pageContext.getOut().write(input.toString());
	    	}
	    	
	    	if( !"true".equals(showonly) ){
	    		pageContext.getOut().write(javaScript());
	    	}
	    	
	    	
    	}
    	catch( JspTagException ex ){
    		ex.printStackTrace();
    		throw ex;
    	}
    	catch ( Exception ex ) {
    		ex.printStackTrace();
    	}

        return EVAL_PAGE;
    }
    
    protected String javaScript() throws Exception {
    	StringBuffer buff = new StringBuffer();
    	buff.append("<script language=\"JavaScript\"> \n");
    	buff.append( "function showzoom").append(this.getProperty()).append("() { \n" );
    	buff.append( "var arg = new Array();" ); 
    	buff.append("var returnvalue = window.showModalDialog(contextPath+\"").append("/commons/showzoomwait.jsp?definition=")
			.append(URLEncoder.encode(definition)).append("&property=").append(property);
		if( condition != null ){
			buff.append("&condition=").append(evaluateCondition());
		}
		buff.append("\",arg,\"dialogWidth:600px;dialogHeight:440px;status:no;resizable:yes;\");");
		
		buff.append(" var oldvalue = document.forms[0].").append(property).append(".value; ");
		buff.append("if( returnvalue == '' || returnvalue == undefined ) return;");
		buff.append("if( returnvalue == ' ; '  ) {");
		buff.append(" document.forms[0].").append(property).append(".value = ''; ");
		buff.append(" document.forms[0].").append(property).append("_zoom.value = ''; ");
		if( this.getOnchange() != null ) {
			buff.append(" if ( oldvalue != document.forms[0].").append(property).append(".value ){ ");
			buff.append( "   document.forms[0].").append(property).append("_zoom.fireEvent(\"onchange\");" );
			buff.append(" } ");
		}
		buff.append("return;}");
		buff.append(" var pos = returnvalue.indexOf(';');");
		buff.append(" document.forms[0].").append(property).append(".value = returnvalue.substring(0,pos); ");
		if( "false".equals(nameOnly) ){
			buff.append(" document.forms[0].").append(property).append("_zoom.value = returnvalue.substring(0,pos) + \" \" +  returnvalue.substring(pos+1,returnvalue.length); ");
		}else{
			buff.append(" document.forms[0].").append(property).append("_zoom.value = returnvalue.substring(pos+1,returnvalue.length); ");
		}
		
		if( readonly && this.getOnchange() != null ) {
			buff.append(" if ( oldvalue != document.forms[0].").append(property).append(".value ){ ");
			buff.append( "   document.forms[0].").append(property).append("_zoom.fireEvent(\"onchange\");" );
			buff.append(" } ");
		}
		
    	buff.append("}\n" );
    	
    	if( !readonly ){
    		buff.append( "function changedata").append(this.getProperty()).append("() { " );
    		buff.append(" if ( document.forms[0].").append(property).append(".value == '' && ");
    		buff.append(" 	  document.forms[0].").append(property).append("_zoom.value != '' ) { ");
    		buff.append("      document.forms[0].").append(property).append(".value=");
    		buff.append("document.forms[0].").append(property).append("_zoom.value; ");
    		buff.append(" }" );
    		buff.append("}\n" );
    	}
    	
    	buff.append("</script>");
 
		return buff.toString();
    }
    
    protected String doElse() {
    	StringBuffer sb = new StringBuffer();
    	if( this.getReadonly() ){
    		sb.append( "readonly " );
    	}
    	if( this.getDisabled() ){
    		sb.append( "disabled " );
    	}
		return sb.toString();
    }
	
    protected String evaluateCondition() throws JspException, NullAttributeException {
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
