package com.sunrise.jop.ui.tag.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.util.ValueStack;

public class MoreCheckDialog extends PickerDialog{
	
	private static Log log = LogFactory.getLog(MoreCheckDialog.class);

	final public static String TEMPLATE = "morecheck";
	
    protected String readonly = "true"; // Morecheck always true 
	
	public MoreCheckDialog(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getDefaultTemplate() {
		// TODO Auto-generated method stub
		return this.TEMPLATE;
	}

}
