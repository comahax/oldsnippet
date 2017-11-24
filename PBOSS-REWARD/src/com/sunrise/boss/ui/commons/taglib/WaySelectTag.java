package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseFieldTag;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class WaySelectTag extends BaseFieldTag {
	
	private String definition ="#WAY";

	private String showParent;

	private String showOfCitycom;

	private String valueOnly = "true";//因waycommon.js中showSelectWay的限制，当前只提供value、value+" "+name两种选择
	
	private ACLDelegate delegate;
	
	// 是否显示下属渠道选择框;
	private boolean showBox;
	// 令牌值，控制下属渠道选择框的显示;
	private String controlID;
	
	public WaySelectTag() {
		super();
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException, JspException {
		try {
			Object obj = TagUtils.getInstance().lookup(pageContext, name, property, null);
			String value = "";
			if (obj != null) {
				value = obj.toString();
			}
			
			/***
			 * 当valueOnly == false 时，显示 value+" "+name;
			 * 同修改前相同，默认只显示value
			 * modify by jiaofl at 2008.10.30
			 */
			if("false".equalsIgnoreCase(valueOnly)){
				this.showValname(value);
			}else{
				this.showValueonly(value);
			}
			
		}catch (JspTagException ex) {
			ex.printStackTrace();
			throw ex;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	/**
	 * 
	 * @param value
	 * @throws Exception
	 */
	private void showValueonly(String value) throws Exception{
		try{
			StringBuffer tagStr = new StringBuffer();
			tagStr.append("<input type=\"text\" name=\"")
				  .append(this.getProperty()).append("\" value=\"").append(value)
				  .append("\" ").append(prepareStyles());
			
//			if (this.getDisabled()) {
//				tagStr.append(" disabled=\"true\" ");
//			}
			tagStr.append(this.doElse());
			
			tagStr.append("/>")
				  .append("<input type='button' name='wayBtn' class='clickbutton' title='点击选择渠道' value='...' onClick='javascript:showSelectWay(document.all.")
				  .append(this.getProperty())
				  .append(");document.all.").append(this.getProperty()).append(".focus();'");
			
			if (this.getDisabled()) {
				tagStr.append(" disabled=\"true\" ");
			}
			
			tagStr.append("/>");
			tagStr.append(showCheckBox());
			pageContext.getOut().write(tagStr.toString());
		}catch (Exception e){
			throw e;
		}
	}
	
	private void showValname(String value) throws Exception{
		try{
			// hidden
			StringBuffer wayidhidden = new StringBuffer();
			wayidhidden.append("<input type=\"hidden\" name=\"").append(this.getProperty())
					   .append("\" value=\"").append(value).append("\" ")
					   .append(" />");
			pageContext.getOut().write(wayidhidden.toString());

			// input
			Code2NameTag tag = new Code2NameTag();
			tag.setCode(value);
			tag.setDefinition(definition);
			tag.setPageContext(pageContext);

			StringBuffer input = new StringBuffer();
			input.append("<input type=\"text\" name=\"").append(
					this.getProperty()).append("_tree").append("\" value=\"").append(value).append(" ");

			
//			if ("false".equals(valueOnly)) {
//				input.append(value);
//				if (null != value && !"".equals(value)) {
//					input.append(" ");
//				}
//			}
			pageContext.getOut().write(input.toString());
			tag.doEndTag();
			input = new StringBuffer().append("\" ");
			input.append(doElse()).append(prepareStyles()).append(
					prepareEventHandlers()).append(" ").append("/>");
			
			//button
			input.append("<input type=\"button\" name=\"wayButton\" class=\"clickbutton\" title=\"点击选择渠道\" value=\"...\" onClick='javascript:showSelectWay(document.all.")
				 .append(this.getProperty())
				 .append("_tree,")
				 .append("\"").append(this.getProperty()).append("\"")
				 .append(this.getArguments())
				 .append(");document.all.").append(this.getProperty()).append("_tree").append(".focus();'");

			input.append(doElse()).append("/>");
			input.append(showCheckBox());
			pageContext.getOut().write(input.toString());
		}catch (Exception e){
			throw e;
		}
		
	}
	
	
	private String doElse() {
		StringBuffer sb = new StringBuffer();
		if (this.getReadonly()) {
			sb.append(" readonly=\"true\" ");
		}
		if (this.getDisabled()) {
			sb.append(" disabled=\"true\" ");
		}
		return sb.toString();
	}
	private String showCheckBox()throws Exception
	{
		//首先，查找系统参数66,判断是否显示包含下级渠道
		if (!chkQuerySubWays()) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		if(this.isShowBox())
		{
			if(this.havePurview(this.getControlID()))
			{
				String isChecked =null;
				try{
				isChecked= (String) TagUtils.getInstance().lookup(pageContext, "org.apache.struts.taglib.html.BEAN",
						"containSubWay", null);
				}catch(Exception ex)
				{
					throw new Exception("form　bean shout have property:containSubWay");
				}
				if (isChecked == null) {
					isChecked = " ";
				} else {
					isChecked = isChecked.trim().equals("1") ? " checked ": " ";
				}
				sb.append("<font color=blue>包含子渠道</font>")
				.append("<input type=\"checkbox\" name=\"containSubWay\" value=\"1\" title=\"选中查询当前渠道及所属下属渠道\" class=\"table_checkbox\"")
				.append(isChecked).append("/>");
			}
		}
		return sb.toString();
	}
	/**
	 * 得到参数 function showSelectWay(control, idCtlId, showParent, showOfCitycom)
	 * 
	 * @return
	 */
	private String getArguments() {
		
		StringBuffer argu = new StringBuffer(20);
		
		if (showParent != null && !"".equals(showParent)) {
			argu.append(",\"").append(showParent).append("\"");
		}else{
			argu.append(",\"").append("\"");
		}
		
		if (showOfCitycom != null && !"".equals(showOfCitycom)) {			
			argu.append(",\"").append(showOfCitycom).append("\"");
		}else{
			argu.append(",\"").append("\"");
		}
		
		return argu.toString();
	}
	
	/**
	 * 有市公司权限 或 本渠道及下属渠道权限时，才显示是否包含下级渠道
	 * @param controlID
	 * @return
	 */
	protected boolean havePurview(String controlID) {
		// 市公司权限
		String A = "_JHQUERYRGT_A";
		// 本渠道及下属渠道权限
		String C = "_JHQUERYRGT_C";
		// 本渠道权限
		String D = "_JHQUERYRGT_D";
		User user = (User) pageContext.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		boolean canA =false;
		boolean canC=false;
		
		try {
			delegate=new ACLDelegate();
			canA = delegate.checkPermission(user.getOpercode(), controlID+A);
		} catch (Exception e) {
			e.printStackTrace();
			canA = false;
		}
		if(!canA)
			try {
				canC = delegate.checkPermission(user.getOpercode(), controlID+C);
			} catch (Exception e) {
				e.printStackTrace();
				canC = false;
			}
		return (canA||canC);
	}
	
	/**
	 * 查找系统参数66,判断是否显示包含下级渠道
	 * 
	 * @return
	 */
	private boolean chkQuerySubWays() {
		try {
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			
			CommonDelegate delegate = new CommonDelegate(SysparamVO.class);
			SysparamVO paramVO = new SysparamVO();
			paramVO.setSystemid(new Long(66));
			paramVO.setParamtype("resource");
			paramVO = (SysparamVO)delegate.doFindByPk(paramVO, user);
			if (paramVO != null
					&& StringUtils.isNotBlank(paramVO.getParamvalue())
					&& paramVO.getParamvalue().equals("1")) {// 仅当参数值为1时,才显示
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 

	

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getShowParent() {
		return showParent;
	}

	public void setShowParent(String showParent) {
		this.showParent = showParent;
	}

	public String getShowOfCitycom() {
		return showOfCitycom;
	}

	public void setShowOfCitycom(String showOfCitycom) {
		this.showOfCitycom = showOfCitycom;
	}

	public String getValueOnly() {
		return valueOnly;
	}

	public void setValueOnly(String valueOnly) {
		this.valueOnly = valueOnly;
	}

	public String getControlID() {
		return controlID;
	}

	public void setControlID(String controlID) {
		this.controlID = controlID;
	}

	public boolean isShowBox() {
		return showBox;
	}

	public void setShowBox(boolean showBox) {
		this.showBox = showBox;
	}
}
