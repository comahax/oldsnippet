package com.sunrise.jop.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.UserProvider;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.sunrise.jop.ui.tag.component.MoreCheckDialog;
import com.sunrise.jop.ui.tag.component.MultiCheckBox;
import com.sunrise.jop.ui.tag.component.PickerDialog;
import com.sunrise.jop.ui.tag.component.Selector;

/** 
 * User: He Kun
 * Date: 2006-8-18
 * Time: 15:34:32
 * To change this template use File | Settings | File Templates.
 */
public class SelectorTag extends AbstractUITag {

	protected String definition;    
	protected String condition;  //过滤器,只保留指定条件的值    
	protected String  dbFlag;    
    protected String showonly;    
    protected String nameOnly;    
    protected String readonly ;
    protected String headOption; // 下拉框的第一个Option <option value="">headOption</option>
    protected String mode;  // 选择模式 picker为弹出框 selector为下拉框 morecheck为多选框

	public void setCondition(String condition) {
		this.condition = condition;		
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setNameOnly(String nameOnly) {
		this.nameOnly = nameOnly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public void setShowonly(String showonly) {
		this.showonly = showonly;
	}
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setHeadOption(String headOption) {
		this.headOption = headOption;
	}
	
	/**
	 * 
	 * @param stack
	 * @param req
	 * @param res
	 * @return
	 */
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		Class clazz = InterfaceUtils.getInstance().getImplClass(UserProvider.class);
		UserProvider provider;
		try {
			provider = (UserProvider)clazz.newInstance();
			DBAccessUser user = (DBAccessUser)provider.getUser();// req.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			dbFlag = user.getCityid();
		}catch (Exception e) {
			throw new IllegalArgumentException("Can't find or instant UserProvider's impl class! ");
		}
		
		if( mode == null){
			if( definition.startsWith("#"))  //动态数据，使用对话框
			{
				return new PickerDialog(stack,req,res);
				
			}else  { //数据字段和固定参数 使用 select 控件 
				return new Selector(stack,req,res);
			}
		}else if(mode.equalsIgnoreCase("picker")){
			return new PickerDialog(stack,req,res);
		}else if(mode.equalsIgnoreCase("selector")){
			return new Selector(stack,req,res);
		}else if(mode.equalsIgnoreCase("morecheck")){
			return new MoreCheckDialog(stack,req,res);
		}else if(mode.equalsIgnoreCase("multicheckbox")){
			return new  MultiCheckBox(stack,req,res);
		}else{
			return null;
		}
		
	}
	
	
	protected void populateParams() {		
		super.populateParams();
		
		if( mode == null){
			if( definition.startsWith("#")){  //动态数据，使用对话框
				usePicker();
			}else  { //数据字段和固定参数 使用 select 控件 
				useSelector();
			}
		}else if(mode.equalsIgnoreCase("picker")){
			usePicker();
		}else if(mode.equalsIgnoreCase("selector")){
			useSelector();
		}else if(mode.equalsIgnoreCase("morecheck")){
			useMorecheck();
		}else if(mode.equalsIgnoreCase("multicheckbox")){
			useMultiCheckbox();
		}else{
			//该方法失效
		}
	}
	
	private void useMultiCheckbox() {
		// TODO Auto-generated method stub
		MultiCheckBox checkbox = (MultiCheckBox)component;
		checkbox.setDefinition(definition);
		checkbox.setCondition(condition);
		checkbox.setDbFlag(dbFlag);
	}

	private void useMorecheck() {
		// TODO Auto-generated method stub
		MoreCheckDialog morecheck = (MoreCheckDialog)component;
		morecheck.setDefinition(definition);
		morecheck.setCondition(condition);	
		morecheck.setReadonly(readonly);			
		morecheck.setDbFlag(dbFlag);
	}

	private void useSelector(){
		Selector selector = (Selector)component;			
		selector.setDefinition(definition);
		selector.setCondition(condition);
		selector.setNameOnly(nameOnly);
		selector.setReadonly(readonly);
		selector.setShowonly(showonly);
		selector.setDbFlag(dbFlag);		
		selector.setHeadOption(headOption);
	}
	
	private void usePicker(){
		PickerDialog selector = (PickerDialog)component;		
		selector.setDefinition(definition);
		selector.setCondition(condition);	
		selector.setReadonly(readonly);			
		selector.setDbFlag(dbFlag);
	}
	

}
