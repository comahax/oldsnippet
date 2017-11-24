package com.sunrise.boss.business.cms.distribute.cpexam.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CpexamListVO</p>
 * <p>Description: Query Params Object for CpexamDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangbinli
 * @version 1.0
 */
public class CpexamListVO extends BaseListVO {
  private String _se_examid;
  private String _se_cooperauid;
  private String _se_comtype;
  private String _se_examtype;
  private String _se_examresult;
  private String _se_basenum;
  private String _se_realnum;
  private String _sk_cooperauid;

  public String get_se_examid() {
    return _se_examid;
  } 
   
  public String get_se_cooperauid() {
    return _se_cooperauid;
  } 
   
  public String get_se_comtype() {
    return _se_comtype;
  } 
   
  public String get_se_examtype() {
    return _se_examtype;
  } 
   
  public String get_se_examresult() {
    return _se_examresult;
  } 
   
  public String get_se_basenum() {
    return _se_basenum;
  } 
   
  public String get_se_realnum() {
    return _se_realnum;
  } 
   

  public void set_se_examid(String _se_examid) {
    this._se_examid = _se_examid;
  }
  
  public void set_se_cooperauid(String _se_cooperauid) {
    this._se_cooperauid = _se_cooperauid;
  }
  
  public void set_se_comtype(String _se_comtype) {
    this._se_comtype = _se_comtype;
  }
  
  public void set_se_examtype(String _se_examtype) {
    this._se_examtype = _se_examtype;
  }
  
  public void set_se_examresult(String _se_examresult) {
    this._se_examresult = _se_examresult;
  }
  
  public void set_se_basenum(String _se_basenum) {
    this._se_basenum = _se_basenum;
  }
  
  public void set_se_realnum(String _se_realnum) {
    this._se_realnum = _se_realnum;
  }

public String get_sk_cooperauid() {
	return _sk_cooperauid;
}

public void set_sk_cooperauid(String _sk_cooperauid) {
	this._sk_cooperauid = _sk_cooperauid;
}
  

}
