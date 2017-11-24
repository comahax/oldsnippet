package com.gmcc.pboss.web.common.xtree;

import java.io.Serializable;

import com.sunrise.jop.common.utils.lang.StringUtils;

/**
 * WebFXLoadTreeItem类,辅助大数据量的树刷新
 * @author Canigar
 *
 */
public class WebFXLoadTreeNode implements Serializable {
	
	private String sText;
	private String sXmlSrc;
	private String sAction;
	private String eParent;
	private String sIcon;
	private String sOpenIcon;
	
	public WebFXLoadTreeNode(String sText, String sXmlSrc, String sAction){
		this.sText = sText;
		this.sXmlSrc = sXmlSrc;
		this.sAction = sAction;
	}

	public String getSText() {
		if(StringUtils.isEmpty(sText)){
			return "";
		}
		return sText;
	}

	public void setSText(String text) {
		sText = text;
	}

	public String getSXmlSrc() {
		if(StringUtils.isEmpty(sXmlSrc)){
			return "";
		}
		return sXmlSrc;
	}

	public void setSXmlSrc(String xmlSrc) {
		sXmlSrc = xmlSrc;
	}

	public String getSAction() {
		if(StringUtils.isEmpty(sAction)){
			return "";
		}
		return sAction;
	}

	public void setSAction(String action) {
		sAction = action;
	}

	public String getEParent() {
		if(StringUtils.isEmpty(eParent)){
			return "";
		}
		return eParent;
	}

	public void setEParent(String parent) {
		eParent = parent;
	}

	public String getSIcon() {
		if(StringUtils.isEmpty(sIcon)){
			return "";
		}
		return sIcon;
	}

	public void setSIcon(String icon) {
		sIcon = icon;
	}

	public String getSOpenIcon() {
		if(StringUtils.isEmpty(sOpenIcon)){
			return "";
		}
		return sOpenIcon;
	}

	public void setSOpenIcon(String openIcon) {
		sOpenIcon = openIcon;
	}
	
}
