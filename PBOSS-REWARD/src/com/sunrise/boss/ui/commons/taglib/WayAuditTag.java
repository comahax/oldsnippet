package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.sunrise.boss.delegate.cms.fdaudit.FdauditDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class WayAuditTag extends BodyTagSupport {
	private String typename;
	private String pk;
	private String pk1;
	private Object pkvalue;
	private Object pkvalue2;
	private String url;
	public WayAuditTag() {
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getPk1() {
		return pk1;
	}

	public void setPk1(String pk1) {
		this.pk1 = pk1;
	}

	public Object getPkvalue() {
		return pkvalue;
	}
	public void setPkvalue(Object pkvalue) {
		this.pkvalue = pkvalue;
	}
	public Object getPkvalue2() {
		return pkvalue2;
	}
	public void setPkvalue2(Object pkvalue2) {
		this.pkvalue2 = pkvalue2;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer("<a href='cms/fdaudit.do?CMD=LIST");
		if(StringUtils.isNotEmpty(pk)){
			try{
				evaluateExpressions();
				buffer.append("&PK="+pkvalue);
			}catch(Exception e){
				return SKIP_BODY;
			}
		}
		if(StringUtils.isNotEmpty(pk1)){
			try{
				evaluateExpressions2();
				buffer.append("&PK2="+pkvalue2);
			}catch(Exception e){
				return SKIP_BODY;
			}
		}
		buffer.append("&TYPE="+typename).append("&fromURL="+url).append("'>");
		User user = (User) pageContext.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		try {
			FdauditDelegate delegate=new FdauditDelegate();
			if(delegate.hasUnauditedFields("",typename,pkvalue,user)){
				buffer.append("×Ö¶ÎÉóÅú</a>");
				pageContext.getOut().print(buffer.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	private void evaluateExpressions() throws JspException,
	NullAttributeException {
		pkvalue = ExpressionUtil.evalNotNull("WayAudit", "pk", pk,
		Object.class, this, pageContext);

	}
	private void evaluateExpressions2() throws JspException,
	NullAttributeException {
		pkvalue2 = ExpressionUtil.evalNotNull("WayAudit", "pk1", pk1,
				Object.class, this, pageContext);
	}
}
