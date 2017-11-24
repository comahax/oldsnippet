/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-8-24
 */
package com.gmcc.pboss.web.common.xtree;

import java.io.Serializable;

/**
 * TreeNode
 * <br> Description: dTree组件的服务器端类。
 * <br> Company: Maywide,Guangzhou</br>
 * 参考： dTree.prototype.add = function(id, pid, text, url, title, target, icon, iconOpen, open, checked, disabled) {
  this.aNodes[this.aNodes.length] = new Node(id, pid, text, url, title, target, icon, iconOpen, open, checked, disabled);
  };
  
  <br>TreeNode只处理与界面特性无关的数据，如id，text等，而url,target等不进行存储。
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-8-24
 */
public class XTreeNode implements Serializable {

	private String id;
	private String parentId;
	private String text;
	private String type;
	private String childrenURL;
	private String url;	
	private String function;
	private String target;	
	private String icon;
	private String openIcon;
	private boolean checked;
	private boolean disabled;
	
	public XTreeNode() {
		
	}
	
	public XTreeNode(String id,String parentId,String text,String type) {
		this.id = id;
		this.parentId = parentId;
		this.text = text;
		this.type = type;
	}

	/**
	 * @return Returns the checked.
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked The checked to set.
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @return Returns the disabled.
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled The disabled to set.
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return Returns the icon.
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon The icon to set.
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the openIcon.
	 */
	public String getOpenIcon() {
		return openIcon;
	}

	/**
	 * @param openIcon The openIcon to set.
	 */
	public void setOpenIcon(String openIcon) {
		this.openIcon = openIcon;
	}

	/**
	 * @return Returns the parentId.
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId The parentId to set.
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return Returns the target.
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target The target to set.
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return Returns the text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text The text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the childrenURL.
	 */
	public String getChildrenURL() {
		return childrenURL;
	}

	/**
	 * @param childrenURL The childrenURL to set.
	 */
	public void setChildrenURL(String childrenURL) {
		this.childrenURL = childrenURL;
	}

	/**
	 * @return Returns the function.
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * @param function The function to set.
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
