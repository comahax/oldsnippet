package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;

/**
 * �����Ʒ��
 *  
 * @version 1.1 ��ӶԶ�ѡ��֧�� modify by jiaofl 2009-01-09 
 * 
 */

public class MainprodTag extends BaseFieldTag {

	private static final String code2nameDefinition = "#PRODUCT";
	
	private String selectType = "1"; // ��Ʒ����ѡ or ��ѡ��ʶ��1��radioʱ��ѡ��2��checkboxʱ��ѡ��Ĭ�ϵ�ѡ��
	
	public MainprodTag(){
		super();
	}
	
	public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
	
	public int doEndTag() throws JspTagException,JspException {
		try{
			Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
			String value = "";
			if(obj != null){
				value = obj.toString();
			}
			MoreCode2NameTag tag = new MoreCode2NameTag();
			tag.setCode(value);
			tag.setDefinition(code2nameDefinition);
			tag.setPageContext(pageContext);
			StringBuffer buffHidden = new StringBuffer();
			buffHidden.append("<input type=\"hidden\" name=\"").append( this.getProperty())
    				.append("\" value=\"").append(value).append("\"  ")
    				.append(" >\n");
			pageContext.getOut().write(buffHidden.toString());
			
			StringBuffer input = new StringBuffer();
	    	input.append("<input type=\"text\" name=\"")
	    		.append( this.getProperty()).append("_mainprod")
	    		.append("\" value=\"");
	    	pageContext.getOut().write(input.toString());
	    	tag.doEndTag();
	    	input = new StringBuffer();
	    	input.append("\" onclick=\"showMainprod").append(property).append("()\" readonly=\"ture\" ");
	    	if(this.getDisabled()){
	    		input.append(" disabled=\"true\" ");
	    	}
	    	input.append( prepareStyles() ).append("/>\n");
	    	// д��JavaScript
//	    	input.append("<script language=\"JavaScript\"> \n");
//	    	input.append("function showMainprod").append(property).append("(){\n");
//	    	input.append("var returnvalue = window.showModalDialog(contextPath+\"").append("/resmanage/common/mainprodtree.jsp\", \"\" , 'dialogWidth=405px;dialogHeight=430px;status:no;scroll=yes;');\n");
//	    	input.append("if( returnvalue == '' || returnvalue == undefined ) return;");
//	    	input.append("if( returnvalue == ' | '  ) {");
//	    	input.append(" document.forms[0].").append(property).append(".value = ''; ");
//	    	input.append(" document.forms[0].").append(property).append("_mainprod.value = ''; return;");
//	    	input.append("");
//	    	input.append("}");
//	    	input.append(" var pos = returnvalue.indexOf('|');");
//	    	input.append(" document.forms[0].").append(property).append(".value = returnvalue.substring(0,pos); ");
//	    	input.append(" document.forms[0].").append(property).append("_mainprod.value = returnvalue.substring(pos+1,returnvalue.length); ");
//	    	input.append("}\n" );
//	    	input.append("</script>");
	    	pageContext.getOut().write(input.toString());
	    	pageContext.getOut().write(javascript(value));
	    	
		}catch ( Exception ex ) {
    		ex.printStackTrace();
    	}

        return EVAL_PAGE;
	}
	
	
	private String javascript(String value)throws Exception{
		StringBuffer scriptBuf = new StringBuffer(300);
		scriptBuf.append("<script language=\"JavaScript\"> \n")
				 .append("function showMainprod").append(property).append("(){\n")
				 .append(" var defaultValue =\"\"; ")
				 .append(" if(typeof(document.forms[0])!= undefined && typeof(document.forms[0].").append(property).append(") != undefined){\n ")
				 .append(" defaultValue = document.forms[0].").append(property).append(".value; \n")// �õ�input�ĵ�ǰֵ
				 .append("} \n")
				 .append(" var array = new Array();\n")// ���ڶ�ѡʱ�����Ѿ�ѡ��Ĳ�Ʒ
				 .append(" array[0] = defaultValue ;\n");
		
		// selectTypeĬ��Ϊ��ѡ
		if(StringUtils.isBlank(selectType)){
			selectType = "1";
		}else if(selectType.equalsIgnoreCase("radio") || selectType.equals("1")){
			selectType = "1";
		}else if(selectType.equalsIgnoreCase("checkbox") || selectType.equals("2")){
			selectType = "2";
		}else{
			selectType = "1";
		}
		
		scriptBuf.append("var returnvalue = window.showModalDialog(contextPath+\"")
				 .append("/resmanage/common/mainprodtree.jsp?").append("selectType=").append(selectType).append("\",array,'dialogWidth=405px;dialogHeight=430px;status:no;scroll=yes;');\n")
				 .append("if( returnvalue == undefined || returnvalue == null || returnvalue == '' ) return;"); // ���۵�ѡ���Ƕ�ѡ�����ؽ��Ϊ�ն������κδ���
		
		// ��ѡ����ѡ����ʽ��ͬ
		if(selectType.equals("1")){// ��ѡ
			scriptBuf.append("if( returnvalue == '|'  ) {")
	    			 .append(" document.forms[0].").append(property).append(".value = ''; ")
			    	 .append(" document.forms[0].").append(property).append("_mainprod.value = ''; return;")
			    	 .append("")
			    	 .append("}")
			    	 .append(" var pos = returnvalue.indexOf('|');")
			    	 .append(" document.forms[0].").append(property).append(".value = returnvalue.substring(0,pos); ")
			    	 .append(" document.forms[0].").append(property).append("_mainprod.value = returnvalue.substring(pos+1,returnvalue.length); ")
			    	 .append("}\n" );
		}else{// ��ѡ
			scriptBuf.append("if( returnvalue == '|' || returnvalue == 'clear'  ) {")
	    		     .append(" document.forms[0].").append(property).append(".value = ''; ")
	    		     .append(" document.forms[0].").append(property).append("_mainprod.value = ''; return;")
	    		     .append("}\n")
	    		     .append("var nameStr = '';\n")
	    		     .append("var valueStr = '';\n")
	    		     .append("var returnValArr = returnvalue.split(\",\");\n")
	    		     .append("for(var i=0;i<returnValArr.length; i++){\n")
	    		     .append("if(returnValArr[i] != null && returnValArr[i] != ''){\n")
	    		     .append("var tempArr = returnValArr[i].split('|');\n")
	    		     .append("valueStr += tempArr[0]+',';\n")
	    		     .append("nameStr += tempArr[1]+',';\n")
	    		     .append("}\n")
	    		     .append("}\n")
	    		     .append("document.forms[0].prodid.value = valueStr.substring(0,valueStr.length-1);\n")
	    		     .append("document.forms[0].prodid_mainprod.value = nameStr.substring(0,nameStr.length-1);\n")
	    			 .append("}\n" );
		}
		scriptBuf.append("</script>");
		return scriptBuf.toString();
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}
}
