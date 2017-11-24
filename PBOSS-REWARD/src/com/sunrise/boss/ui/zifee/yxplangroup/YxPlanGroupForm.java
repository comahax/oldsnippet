package com.sunrise.boss.ui.zifee.yxplangroup;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.BaseActionForm;

public class YxPlanGroupForm extends BaseActionForm{
	
	private FormFile inputFile; // 批量上传文件

	private String reInfo;      // 批量处理返回信息，包括出错记录和出错原因
	
	private static final long serialVersionUID = 1L;
	
	private String _ne_memyxplan;
	private String _ne_groupyxplan;
	
    private Long memyxplan;
    private Long groupyxplan;
    
	private Long yxplanid;
	private String yxplanname;
	public String get_ne_groupyxplan() {
		return _ne_groupyxplan;
	}
	public void set_ne_groupyxplan(String _ne_groupyxplan) {
		this._ne_groupyxplan = _ne_groupyxplan;
	}
	public String get_ne_memyxplan() {
		return _ne_memyxplan;
	}
	public void set_ne_memyxplan(String _ne_memyxplan) {
		this._ne_memyxplan = _ne_memyxplan;
	}
	public Long getGroupyxplan() {
		return groupyxplan;
	}
	public void setGroupyxplan(Long groupyxplan) {
		this.groupyxplan = groupyxplan;
	}
	public Long getMemyxplan() {
		return memyxplan;
	}
	public void setMemyxplan(Long memyxplan) {
		this.memyxplan = memyxplan;
	}
	public Long getYxplanid() {
		return yxplanid;
	}
	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}
	public String getYxplanname() {
		return yxplanname;
	}
	public void setYxplanname(String yxplanname) {
		this.yxplanname = yxplanname;
	}
	public FormFile getInputFile() {
		return inputFile;
	}
	public void setInputFile(FormFile inputFile) {
		this.inputFile = inputFile;
	}
	public String getReInfo() {
		return reInfo;
	}
	public void setReInfo(String reInfo) {
		this.reInfo = reInfo;
	}



}
