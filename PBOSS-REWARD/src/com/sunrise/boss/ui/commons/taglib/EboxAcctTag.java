package com.sunrise.boss.ui.commons.taglib;

import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.log4j.Logger;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

public class EboxAcctTag extends BaseFieldTag {

	private static Logger log = Logger.getRootLogger();

	private boolean readonly = true ;
	
    private String condition;  //过滤器,只保留指定条件的值
	

	private String type;
	

	public int doStartTag() {
		return SKIP_BODY;
	}

	public int doEndTag() {

		try {
			Object obj = TagUtils.getInstance().lookup(pageContext, name,
					property, null);
			String value = "";
			if (obj != null) {
				value = obj.toString();
			}
			Code2NameTag tag = new Code2NameTag();
			tag.setCode(value);
			if (type != null && type.toLowerCase().equals("eboxunit")) {
				tag.setDefinition("#EBOXUNIT");
			} else if(type != null && type.toLowerCase().equals("acct")) {
				tag.setDefinition("#ACCTNAME");
			}else{
				throw new Exception("type has not defined");
			}
			tag.setPageContext(pageContext);
			StringBuffer sbhidden = new StringBuffer();
			sbhidden.append("<input type=\"hidden\" name=\"").append(
					this.getProperty()).append("\" value=\"").append(value)
					.append("\"  ").append(" >");
			pageContext.getOut().write(sbhidden.toString());

			StringBuffer input = new StringBuffer();
			input.append("<input type=\"text\" name=\"").append(
					this.getProperty()).append("_zoom").append("\" value=\"");
			pageContext.getOut().write(input.toString());
			tag.doEndTag();
			input = new StringBuffer().append("\" ");
			if(!this.getDisabled() && readonly){
			      input.append(" onclick=\"showzoom").append(property)
					 .append("()\" ");
			}
			if( !readonly ){
	    		input.append("onchange=\"changedata").append(getProperty()).append("();\" onkeydown=\"document.forms[0].").append(property).append(".value=''\" ");
	    	}
			input.append(doElse()).
		    	append(prepareStyles()).append(" ").append(
					prepareEventHandlers()).append("/>");
			pageContext.getOut().write(input.toString());
			if( !readonly ) {
	    		input = new StringBuffer();
	    		input.append("&nbsp;<input type=\"button\" value=\"...\" ");
	    		input.append(" onclick=\"showzoom")
    				.append(property).append("()\" ");
	    		input.append(" > ");
	    		
	    		if( getOnchange() != null ) {
	    			throw new JspTagException("如果是可录入编辑框不支持onchange事件！");
	    		}
	    		pageContext.getOut().write(input.toString());
	    	}
			if(!this.getDisabled()){
	    	    pageContext.getOut().write(javaScript());
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return EVAL_PAGE;
	}

	private String javaScript() throws Exception {
		StringBuffer buff = new StringBuffer();
		buff.append("<script language=\"JavaScript\"> \n");
		buff.append("function showzoom").append(this.getProperty()).append(
				"() { \n");
		buff.append("var arg = new Array();");
		buff.append("var returnvalue = window.showModalDialog(contextPath+\"")
				.append("/fee/commons/eboxacct.do?").append("type=").append(
						type);
		if( condition != null ){
			buff.append("&condition=").append(evaluateCondition());
		}
		buff
				.append("\",arg,\"dialogWidth:600px;dialogHeight:440px;status:no;resizable:yes;\");");
		buff.append(" var oldvalue = document.forms[0].").append(property)
				.append(".value; ");
		buff
				.append("if( returnvalue == '' || returnvalue == undefined ) return;");
		buff.append("if( returnvalue == ' ; '  ) {");
		buff.append(" document.forms[0].").append(property).append(
				".value = ''; ");
		buff.append(" document.forms[0].").append(property).append(
				"_zoom.value = ''; ");
		buff.append("return;}");
		buff.append(" var pos = returnvalue.indexOf(';');");
		buff.append(" document.forms[0].").append(property).append(
				".value = returnvalue.substring(0,pos); ");
		buff
				.append(" document.forms[0].")
				.append(property)
				.append(
						"_zoom.value = returnvalue.substring(pos+1,returnvalue.length); ");
		buff.append("}\n");
		buff.append("</script>");
		return buff.toString();
	}

	public boolean isReadonly() {
		return readonly;
	}
	
	public boolean getReadonly(){
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	

	
	
	 public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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


	private String doElse() {
	    	StringBuffer sb = new StringBuffer();
	    	if( this.isReadonly() ){
	    		sb.append( "readonly " );
	    	}
	/*    	if( this.getDisabled() ){
	    		sb.append( "disabled " );
	    	}*/
			return sb.toString();
	    }
}
