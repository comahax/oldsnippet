/**
* auto-generated code
* Tue Dec 26 19:35:31 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cooperator.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CooperatorListVO</p>
 * <p>Description: Query Params Object for CooperatorDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperatorListVO extends BaseListVO {
	//LIST查询调价
    private String _sk_cooperauid;    	//=合作商编号
    private String _sk_cooperaname;		//like 合作商名称
    private String _sk_cpabbrname;		//合作商简称
    private String _se_districtid;      //所属营业区域  
    
    
    private String _dnl_starttime; //合作开始时间
	private String _dnm_starttime; //合作结束时间
	private String _dnl_licvalidate; //营业执照有效期开始时间
	private String _dnm_licvalidate; //营业执照有效期结束时间
	private String _se_cooperauid; //合作商编号
	private String _se_state;  //分销合作商状态
	private String _se_oldcoopera; //旧系统合作商编号
	private String _se_servpwd;
    //SELECTCOOPERATOR 过滤
    //private String _nne_state;       
	
	public String get_sk_cooperauid() {
		return _sk_cooperauid;
	}
	public void set_sk_cooperauid(String _sk_cooperauid) {
		this._sk_cooperauid = _sk_cooperauid;
	}
	public String get_sk_cooperaname() {
		return _sk_cooperaname;
	}
	public void set_sk_cooperaname(String _sk_cooperaname) {
		this._sk_cooperaname = _sk_cooperaname;
	}

	public String get_sk_cpabbrname() {
		return _sk_cpabbrname;
	}
	public void set_sk_cpabbrname(String _sk_cpabbrname) {
		this._sk_cpabbrname = _sk_cpabbrname;
	}



	public String get_dnm_licvalidate() {
		return _dnm_licvalidate;
	}
	public String get_dnm_starttime() {
		return _dnm_starttime;
	}
	public String get_dnl_licvalidate() {
		return _dnl_licvalidate;
	}
	public String get_dnl_starttime() {
		return _dnl_starttime;
	}
	public String get_se_cooperauid() {
		return _se_cooperauid;
	}
	public String get_se_oldcoopera() {
		return _se_oldcoopera;
	}
	public String get_se_state() {
		return _se_state;
	}

	public void set_dnm_licvalidate(String _dnm_licvalidate) {
		this._dnm_licvalidate = _dnm_licvalidate;
	}
	public void set_dnm_starttime(String _dnm_starttime) {
		this._dnm_starttime = _dnm_starttime;
	}
	public void set_dnl_licvalidate(String _dnl_licvalidate) {
		this._dnl_licvalidate = _dnl_licvalidate;
	}
	public void set_dnl_starttime(String _dnl_starttime) {
		this._dnl_starttime = _dnl_starttime;
	}
	public void set_se_cooperauid(String _se_cooperauid) {
		this._se_cooperauid = _se_cooperauid;
	}
	public void set_se_oldcoopera(String _se_oldcoopera) {
		this._se_oldcoopera = _se_oldcoopera;
	}
	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}
	public String get_se_servpwd() {
		return _se_servpwd;
	}
	public void set_se_servpwd(String _se_servpwd) {
		this._se_servpwd = _se_servpwd;
	}
	public String get_se_districtid() {
		return _se_districtid;
	}
	public void set_se_districtid(String _se_districtid) {
		this._se_districtid = _se_districtid;
	}
    


}
