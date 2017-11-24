package com.sunrise.boss.ui.commons.taglib;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

public class CodenumbeformatTag extends BodyTagSupport{
	private static final long serialVersionUID = 8728841970108207064L;
	private String value;
	private String definde;
	private Object codeValue;
	public CodenumbeformatTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getDefinde() {
		return definde;
	}

	public void setDefinde(String definde) {
		this.definde = definde;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int doStartTag() {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		if (value != null && value.trim().length() > 0) {
			try {
				evaluateExpressions();
			String returnvalue="";
			NumberFormat format;
			if(!StringUtils.isEmpty(definde) && "%".equals(definde)){//转换成百分号
				format = NumberFormat.getPercentInstance(Locale.CHINA);
				if(codeValue instanceof BigDecimal){
					returnvalue=format.format(((BigDecimal)codeValue).doubleValue());
				}else{
				returnvalue=format.format(codeValue);
				}
			}else if(!StringUtils.isEmpty(definde) && definde.indexOf(".")>0){//转换小数点
				DecimalFormat df = new DecimalFormat(definde);
				if(codeValue instanceof BigDecimal){
					returnvalue=df.format(((BigDecimal)codeValue).doubleValue());
				}else{
					returnvalue=df.format(codeValue);
				}
			}
			else{//转换成人民币
			format = NumberFormat.getCurrencyInstance(Locale.CHINA);
			if(codeValue instanceof BigDecimal){
				returnvalue=format.format(((BigDecimal)codeValue).doubleValue());
			}else{
			returnvalue=format.format(codeValue);
			}
			}
			
			
			pageContext.getOut().print(returnvalue);
			} catch (Exception ex) {
				return EVAL_PAGE;
			}
		}
		return EVAL_PAGE;
	}
	

	/* Evaluates expressions as necessary */
	private void evaluateExpressions() throws JspException,
			NullAttributeException {
		codeValue = ExpressionUtil.evalNotNull("Codenumbeformat", "value", value,
				Object.class, this, pageContext);
	}
}
