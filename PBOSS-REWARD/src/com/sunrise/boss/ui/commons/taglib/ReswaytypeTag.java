package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;

public class ReswaytypeTag extends BaseFieldTag {
	
	private String definition = "#WAY";

	private String property;

	private boolean readonly;

	private boolean disabled;

	private String onchange;

	private String property_wayid;
	
	private String valueOnly = "true";

	public ReswaytypeTag() {
		super();
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException, JspException {
		try {
			Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
			Object obj2 = TagUtils.getInstance().lookup(pageContext, name, property_wayid, null);
			String value = "";
			String wayidValue = "";
			if (obj != null) {
				value = obj.toString();
			}
			if (obj2 != null) {
				wayidValue = obj2.toString();
			}
			pageContext.getOut().write(writeSelect(value));
//			pageContext.getOut().write(writeInput(value, wayidValue));
			this.writeInput(value, wayidValue);
			pageContext.getOut().write(javaScript());
		} catch (JspTagException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 得到文件格式下拉框
	 * 下拉框名称: waystyle
	 * @param value
	 * @return
	 */
	private String writeSelect(String value) {
		StringBuffer sbselect = new StringBuffer();
		sbselect.append("<td nowrap align=\"right\" height=25>文件格式:</td>")
				.append("<td><select onchange=\"selectwaytype();\" name=\"waystyle\"")
				.append(doElse()).append(">");
		
		//判断默认选择项
		if ("noway".equals(value)) {
			sbselect.append("<option value=\"newway\" >有新渠道</option><option value=\"noway\" selected>无新渠道</option>");
		} else {
			sbselect.append("<option value=\"newway\" selected>有新渠道</option><option value=\"noway\" >无新渠道</option>");
		}
		sbselect.append("</select><font color=red>&nbsp;*</font></td>\n")
				.append("</tr>");
		
		return sbselect.toString();
	}

	/**
	 * 得到渠道输入框
	 * @param value
	 * @param wayidValue
	 * @return
	 * @throws IOException 
	 * @throws JspException 
	 */
	private void writeInput(String value, String wayidValue) throws IOException, JspException {
		
		StringBuffer input = new StringBuffer();
		
		input.append("<tr>")
			 .append("<td nowrap align=\"right\" id=\"way1\"");
		if ("newway".equals(value) || "".equals(value)){
			input.append(" style=\"display:none\"");
		}
		input.append(">新渠道:</td>");
		
		input.append("<td nowrap align=\"left\" id=\"way2\"");
		if ("newway".equals(value) || "".equals(value)){
			input.append(" style=\"display:none\"");
		}
		input.append(">");
		
		pageContext.getOut().write(input.toString());
		
		/**
		 * valueOnly == false 显示 渠道ID+" "+渠道名称； 否则只显示渠道ID
		 * modify by jiaofl at 2008.10.30
		 */
		if(valueOnly.equals("true")){
			StringBuffer wayinput = new StringBuffer();
			wayinput.append("<input type=\"text\" name=\"").append(property_wayid).append("\" value=\"");
			if ("noway".equals(value)) {
				wayinput.append(wayidValue).append("\"");
			}else {
				wayinput.append("\"");
			}	
			wayinput.append(" class=\"form_input_1x\" onclick=\"showSelectWay(this);\"  readonly=\"true\"");
			if (isDisabled() || "newway".equals(value) || "".equals(value)) {
				wayinput.append(" disabled=\"true\"");
			}
			wayinput.append("/>");
			pageContext.getOut().write(wayinput.toString());
		}else{
			// hidden
			StringBuffer wayidhidden = new StringBuffer();
			wayidhidden.append("<input type=\"hidden\" name=\"").append(property_wayid).append("\" value=\"");
			if ("noway".equals(value)) {
				wayidhidden.append(wayidValue).append("\"");
			}else {
				wayidhidden.append("\"");
			}
			if (isDisabled() || "newway".equals(value) || "".equals(value)) {
				wayidhidden.append(" disabled=\"true\"");
			}
			wayidhidden.append(" />");
			pageContext.getOut().write(wayidhidden.toString());

			// input
			Code2NameTag tag = new Code2NameTag();
			tag.setCode(wayidValue);
			tag.setDefinition(definition);
			tag.setPageContext(pageContext);

			StringBuffer wayinput = new StringBuffer();
			wayinput.append("<input type=\"text\" name=\"")
				 .append(property_wayid).append("_tree").append("\" readonly=\"true\" value=\"");
			if ("noway".equals(value)) {
				wayinput.append(wayidValue).append(" ");
				pageContext.getOut().write(wayinput.toString());
				tag.doEndTag();
			}else {
				wayinput.append("\"");
				pageContext.getOut().write(wayinput.toString());
			}
			
			wayinput = new StringBuffer().append("\" ");
			if (isDisabled() || "newway".equals(value) || "".equals(value)) {
				wayinput.append(" disabled=\"true\"");
			}
			
			wayinput.append(prepareStyles()).append(
					prepareEventHandlers()).append(" ").append("/>");
			
			//button
			wayinput.append("<input type=\"button\" name=\"wayButton\" class=\"clickbutton\" title=\"点击选择渠道\" value=\"...\" onClick='javascript:showSelectWay(document.all.")
				    .append(property_wayid)
				    .append("_tree,")
				    .append("\"").append(property_wayid).append("\"")
				    .append(");document.all.").append(property_wayid).append("_tree").append(".focus();'");

			wayinput.append(doElse()).append("/>");
			
			pageContext.getOut().write(wayinput.toString());
		}		
				
//		if ("noway".equals(value)) {
//			input.append(wayidValue).append("\"");
//		}else {
//			input.append("\"");
//		}	
//		input.append(" class=\"form_input_1x\" onclick=\"showSelectWay(this);\"  readonly=\"true\"");
//		if (isDisabled() || "newway".equals(value) || "".equals(value)) {
//			input.append(" disabled=\"true\"");
//		}
//		input.append("/>")
		input = new StringBuffer().append("<font color=red>&nbsp;*</font></td>\n");		
		input.append("</tr>");
		pageContext.getOut().write(input.toString());
	}

	private String javaScript() throws Exception {
		StringBuffer buff = new StringBuffer();
		buff.append("\n<script language=\"JavaScript\" type=\"text/javascript\"> \n");
		buff.append("var el_text = document.getElementById(\"filestyletext\");\n");
		buff.append("var el_examtext = document.getElementById(\"exampletext\");\n");
		buff.append("var oldtext = el_text.innerText;\n");
		buff.append("var newway_text = oldtext.slice(0,oldtext.indexOf(\"|\")+1);\n");
		buff.append("var oldexamtext = el_examtext.innerText;\n");
		buff.append("var newway_examtext = oldexamtext.slice(0,oldexamtext.indexOf(\"|\")+1);\n");
		buff.append("function selectwaytype(){\n");
		buff.append("  var waytype = document.all(\"").append(property).append("\").value;\n");
		buff.append("  var inwayid = document.all(\"").append(property_wayid).append("\");\n");
		
		if(valueOnly.equals("false")){
			buff.append(" var inwayid_tree = document.all(\"").append(property_wayid).append("_tree").append("\");\n");
		}
		
		buff.append("  var el_wayid1 = document.getElementById(\"way1\");\n");
		buff.append("  var el_wayid2 = document.getElementById(\"way2\");\n");		
		buff.append("  if (waytype == \"newway\"){\n");
		buff.append("    inwayid.value = \"\";\n");
		buff.append("    inwayid.disabled = true;\n");
		
		if(valueOnly.equals("false")){
			buff.append("    inwayid_tree.value = \"\";\n");
			buff.append("    inwayid_tree.disabled = true;\n");
		}
		
		buff.append("    el_wayid1.style.display = \"none\";\n");
		buff.append("    el_wayid2.style.display = \"none\";\n");
		buff.append("    el_text.innerText = oldtext;\n");
		buff.append("    el_examtext.innerText = oldexamtext;\n");
		buff.append("  }else {\n");
		buff.append("    el_wayid1.style.display = \"inline\";\n");
		buff.append("    el_wayid2.style.display = \"inline\";\n");
		buff.append("    inwayid.disabled = false;\n");
		
		if(valueOnly.equals("false")){			
			buff.append("    inwayid_tree.disabled = false;\n");
		}
		
		buff.append("    el_text.innerText = newway_text;\n");
		buff.append("    el_examtext.innerText = newway_examtext; el_examtext.style.color=\"red\"\n");
		buff.append("  }\n");
		buff.append("}\n</script>");
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

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public String getProperty_wayid() {
		return property_wayid;
	}

	public void setProperty_wayid(String property_wayid) {
		this.property_wayid = property_wayid;
	}

	public String getValueOnly() {
		return valueOnly;
	}

	public void setValueOnly(String valueOnly) {
		this.valueOnly = valueOnly;
	}

//	public static void main(String args[])throws Exception{
//		ReswaytypeTag tag = new ReswaytypeTag();
//		System.out.println(tag.writeInput("noway","test"));
//		
//	}
}
