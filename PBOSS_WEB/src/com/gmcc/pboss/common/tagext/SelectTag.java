package com.gmcc.pboss.common.tagext;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：21个地址下拉自定义标签
 */
public class SelectTag extends TagSupport{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6608876422173130387L;
	
	/**Select name*/
	private String name;
	/**Select 样式*/
	private String className;
	/**Select 类型*/
	private String type;
	/**Select 选中哪个值*/
	private String selected;
	/**
	 * 根据传入的Map，生成Select标签
	 * @param map
	 * @param def 为true时(selected不为空时)，select第一行显示“请选择”项，其value为-1
	 * @return
	 */
	private String getSelectTag(Map map, boolean def){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<select name='").append(getName())
		.append("' class='").append(getClassName()).append("' >");
		
		if(def)
		sb.append("<option selected value='-1' >请选择</option>");
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String value = (String)map.get(key);
			
			if(!CommonUtil.isEmptyOrNull(getSelected()) && key.equals(getSelected())){
				sb.append("<option value='").append(key).append("' selected>");
			}
			else{
				sb.append("<option value='").append(key).append("'>");
			}
			
			sb.append(value).append("</option>");
		}//while
		
		sb.append("</select>");
		return sb.toString();
	}
	public int doEndTag() throws JspException {
		String sb = "<select><option>未知类型</option></select>";
		Map map = Constant.getConstantsMap(getType());
		
		if(map != null){
			boolean def = CommonUtil.isEmptyOrNull(this.getSelected());
			sb = getSelectTag(map, def);
		}
		
		try {
			//System.out.println("SELECT = " + sb);
			pageContext.getOut().println(sb);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return EVAL_PAGE;
	}

	public String getName() {
		if(CommonUtil.isEmptyOrNull(name)){
			return "";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		if(CommonUtil.isEmptyOrNull(className)){
			return "formSelect_2L";
		}
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	

}
