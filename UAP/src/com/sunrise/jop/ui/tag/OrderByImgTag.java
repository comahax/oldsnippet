package com.sunrise.jop.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.ui.tag.component.OrderByImg;

public class OrderByImgTag extends AbstractClosingTag{
	
	protected String href;
	
    public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
    public Component getBean(ValueStack stack, HttpServletRequest req,
    		HttpServletResponse res) {
    	// TODO Auto-generated method stub
    	return new OrderByImg(stack, req, res);
    }
    
    @Override
    protected void populateParams() {
    	// TODO Auto-generated method stub
    	super.populateParams();
    	OrderByImg tag = (OrderByImg)this.component;
    	tag.setHref(href);
    }
    
}
