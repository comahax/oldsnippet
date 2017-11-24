/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-8-24
 */
package com.sunrise.boss.ui.commons.dtree;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * TreeNode
 * <br> Description: dTree组件的服务器端类。
 * <br> Company: Maywide,Guangzhou</br>
 * 参考： dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open, checked, disabled) {
  this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open, checked, disabled);
  };
  
  <br>TreeNode只处理与界面特性无关的数据，如id，name等，而url,target等不进行存储。
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-8-24
 */
public class TreeNode implements Serializable {

	private String id;
	private String parentId;
	private String name;
	private String type;
	private boolean checked;
	private boolean disabled;
	
	public TreeNode() {
		
	}
	
	public TreeNode(String id,String parentId,String name,String type) {
		this.id = id;
		this.parentId = parentId;
		if(id.equals(parentId))
			throw new IllegalArgumentException("id and parentId can't be equal. " + id + " " + parentId );
		this.name = name;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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

}
