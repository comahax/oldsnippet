package com.sunrise.jop.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.ui.tag.component.CheckboxList;

public class CheckboxListTag extends org.apache.struts2.views.jsp.ui.CheckboxListTag {

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new CheckboxList(stack, req, res);
	}
}
