package com.gmcc.pboss.common.tagext;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-2
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������21����ַ�����Զ����ǩ
 */
public class SelectTag extends TagSupport{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6608876422173130387L;
	
	/**Select name*/
	private String name;
	/**Select ��ʽ*/
	private String className;
	/**Select ����*/
	private String type;
	/**Select ѡ���ĸ�ֵ*/
	private String selected;
	/**
	 * ���ݴ����Map������Select��ǩ
	 * @param map
	 * @param def Ϊtrueʱ(selected��Ϊ��ʱ)��select��һ����ʾ����ѡ�����valueΪ-1
	 * @return
	 */
	private String getSelectTag(Map map, boolean def){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<select name='").append(getName())
		.append("' class='").append(getClassName()).append("' >");
		
		if(def)
		sb.append("<option selected value='-1' >��ѡ��</option>");
		
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
		String sb = "<select><option>δ֪����</option></select>";
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
