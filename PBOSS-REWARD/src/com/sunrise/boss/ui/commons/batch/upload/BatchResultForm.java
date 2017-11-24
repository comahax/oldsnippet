package com.sunrise.boss.ui.commons.batch.upload;

import org.apache.struts.validator.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author hbm
 * @version 1.0
 */
public class BatchResultForm extends ValidatorForm {
  private String inFile; //输入文件
  private String fileName; //上传文件名
  private long total; //总记录数
  private long ok; //成功记录数
  private long fail; //失败记录数
  private String opercode; //操作员
  private String wayid; //渠道

  public BatchResultForm() {
  }

  public long getFail() {
    return fail;
  }

  public long getOk() {
    return ok;
  }

  public void setOk(long ok) {
    this.ok = ok;
  }

  public void setFail(long fail) {
    this.fail = fail;
  }

  public String getInFile() {
    return inFile;
  }

  public void setInFile(String inFile) {
    this.inFile = inFile;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public String getOpercode() {
    return opercode;
  }

  public void setOpercode(String opercode) {
    this.opercode = opercode;
  }

  public String getWayid() {
    return wayid;
  }
  
  public void setWayid(String wayid) {
    this.wayid = wayid;
  }

  public String getFileName() {
	return fileName;
  }

  public void setFileName(String fileName) {
	this.fileName = fileName;
  }
}
