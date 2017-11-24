package com.sunrise.boss.ui.commons.taglib;

import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

/**
 * 
 * @author Canigar
 *
 */
public class MyZoomTag extends ZoomTag{
	
	public int doEndTag() throws JspTagException, JspException {
		try{
	    	Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
	    	String value = "";
	    	if( obj != null ){
	    		value = obj.toString();
	    	}
	    
	    	StringBuffer sbhidden = new StringBuffer();
	    	sbhidden.append("<input type=\"hidden\" name=\"").append( this.getProperty())
	    		.append("\" value=\"").append(value).append("\"  ")
	    		.append(" >");
	    	pageContext.getOut().write(sbhidden.toString());
	    	
	    	StringBuffer input = new StringBuffer();
	    	input.append("<input type=\"text\" name=\"")
	    		.append( this.getProperty()).append("_zoom")
	    		.append("\" value=\"");
	    	
	    	if( "false".equals(nameOnly) || StringUtils.isEmpty(nameOnly)){
	    		input.append(value);
	    	}
	    	pageContext.getOut().write(input.toString());
	    	
	    	if(!("false".equals(nameOnly) || StringUtils.isEmpty(nameOnly))){
		    	Code2NameTag tag = new Code2NameTag();
		    	tag.setCode(value);
		    	tag.setDefinition(definition);
		    	tag.setPageContext( pageContext );
		    	tag.doEndTag();
	    	}
	    	
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
	
	/**
	 * 直接返回编码,不返回名称
	 */
	protected String javaScript() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
    	buff.append("<script language=\"JavaScript\"> \n");
    	buff.append( "function showzoom").append(this.getProperty()).append("() { \n" );
    	buff.append( "var arg = new Array();" ); 
    	buff.append("var returnvalue = window.showModalDialog(contextPath+\"").append("/commons/showmyzoomwait.jsp?definition=")
			.append(URLEncoder.encode(definition)).append("&property=").append(property);
		if( condition != null ){
			buff.append("&condition=").append(evaluateCondition());
		}
		buff.append("\",arg,\"dialogWidth:600px;dialogHeight:460px;status:no;resizable:yes;\");");
		
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
		if( "false".equals(nameOnly) || StringUtils.isEmpty(nameOnly)){
			buff.append(" document.forms[0].").append(property).append("_zoom.value = returnvalue.substring(0,pos); ");
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
}
