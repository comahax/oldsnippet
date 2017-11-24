package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;

public class ComidtreeTag extends BaseFieldTag {

	private String definition;

	private String condition;

	private String property;

	private boolean readonly;

	private boolean disabled;

	private String comtype;

	private String onchange;

	private String nameOnly = "true";

	public String getNameOnly() {
		return nameOnly;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ComidtreeTag() {
		super();
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException, JspException {
		try {
			Object obj = TagUtils.getInstance().lookup(pageContext, name,
					property, null);
			String value = "";
			if (obj != null) {
				value = obj.toString();
			}

			Code2NameTag tag = new Code2NameTag();
			tag.setCode(value);
			tag.setDefinition(definition);
			tag.setPageContext(pageContext);

			StringBuffer sbhidden = new StringBuffer();
			sbhidden.append("<input type=\"hidden\" name=\"").append(
					this.getProperty()).append("\" value=\"").append(value)
					.append("\"  ").append(" />");
			pageContext.getOut().write(sbhidden.toString());

			StringBuffer input = new StringBuffer();
			input.append("<input type=\"text\" name=\"").append(
					this.getProperty()).append("_tree").append("\" value=\"");

			if ("false".equals(nameOnly)) {
				input.append(value);
				if (null != value && !"".equals(value)) {
					input.append(" ");
				}
			}
			pageContext.getOut().write(input.toString());
			tag.doEndTag();
			input = new StringBuffer().append("\" ");
			input.append("onkeydown=\"document.forms[0].").append(property)
					.append(".value=''\" onchange=\"").append("changedata")
					.append(this.getProperty()).append("();");
			if (getOnchange() != null && getOnchange().trim().length() > 0) {
				input.append(getOnchange());
			}
			input.append("\" ");
			input.append("onblur=\"reputvalue").append(this.getProperty()).append("();");
			if(getOnblur() != null && getOnblur().trim().length() > 0){
				input.append(getOnblur());
			}
			input.append("\" ");
			input.append(doElse()).append(prepareStyles()).append(
					prepareEventHandlers()).append(" ").append("/>");

			input
					.append(
							"<input type=\"button\" name=\"treebt\" title=\"点击选择商品标识\" class='clickbutton' value=\"...\" onclick=\"showtree")
					.append("()\" ");
			if (this.isDisabled()) {
				input.append("disabled=\"true\"");
			}
			input.append(" />");
			pageContext.getOut().write(input.toString());
			pageContext.getOut().write(javaScript());
		} catch (JspTagException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_PAGE;
	}

	private String javaScript() throws Exception {
		StringBuffer buff = new StringBuffer();
		buff
				.append("<script language=\"JavaScript\" type=\"text/javascript\"> \n");
		// 使用该标签的页面必须要在<head>处导入rescommon.js文件
		buff.append("function showtree").append("() { \n");
		buff.append("  var array = new Array();\n");
		if (this.getCondition() != null
				&& this.getCondition().trim().length() > 0) {
			buff.append("      oldCondition=\"").append(this.getCondition())
					.append("\";\n");
		}
		buff.append("  array[0] = oldCondition + condition;\n");
		buff.append(
				"\n  var returnvalue = window.showModalDialog(contextPath+\"")
				.append("/resmanage/com/selectcomidtree.jsp");
		buff
				.append("\",array,\"dialogWidth:635px;dialogHeight:455px;status:no;resizable:yes;\");");

		buff.append(" \n  var oldvalue = document.forms[0].").append(property)
				.append(".value; ");
		buff
				.append(
						"\n  if (returnvalue != null && returnvalue.length){\ndocument.forms[0].")
				.append(property).append(".value=returnvalue[0];");
		if ("false".equals(nameOnly)) {
			buff.append("\n  document.forms[0].").append(property).append(
					"_tree.value=returnvalue[0]+\"  \"+returnvalue[1];");
		} else {
			buff.append("\n  document.forms[0].").append(property).append(
					"_tree.value=returnvalue[1];");
		}
		if (this.getOnchange() != null) {
			buff.append(" \n  if ( oldvalue != document.forms[0].").append(
					property).append(".value ){ ");
			buff.append("   \n  document.forms[0].").append(property).append(
					"_tree.fireEvent(\"onchange\");");
			buff.append(" } ");
		}
		buff.append("\n  }\n}");
		buff.append("function changedata").append(this.getProperty()).append("() { ");
		buff.append(" if ( document.forms[0].").append(property).append(".value == '' && ");
		buff.append(" 	  document.forms[0].").append(property).append("_tree.value != '' ) { ");
		buff.append("      document.forms[0].").append(property).append(".value=");
		buff.append("document.forms[0].").append(property).append("_tree.value; ");
		buff.append(" }");
		buff.append("}\n");

		buff.append("function reputvalue").append(this.getProperty()).append("() { ");
		buff.append(" if ( document.forms[0].").append(property).append(".value == '' && ");
		buff.append(" 	  document.forms[0].").append(property).append("_tree.value != '' ) { ");
		buff.append("var comstr=document.forms[0].").append(property).append("_tree.value;\n");
		buff.append("var strs = comstr.split(\" \");\n");
		buff.append("document.forms[0].").append(property).append(".value=strs[0];\n");
		buff.append(" }");
		buff.append("}\n");

		buff.append("</script>");

		return buff.toString();
	}

	private String doElse() {
		StringBuffer sb = new StringBuffer();
		if (this.isReadonly()) {
			sb.append(" readonly=\"true\" ");
		}
		if (this.isDisabled()) {
			sb.append(" disabled=\"true\" ");
		}
		return sb.toString();
	}

	public String getComtype() {
		return comtype;
	}

	public void setComtype(String comtype) {
		this.comtype = comtype;
	}
}
