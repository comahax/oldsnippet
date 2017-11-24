/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busyxplan;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: BusyxplanForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanForm extends BaseActionForm {
    
	private String _ne_yxplanid;
    private String _se_cityid;
    private String _se_opnid;
    private String _se_opnname;
    private String _se_yxplanname;
    private String _ne_seq;
    private String _sk_yxplanname;
    private String _se_plankind;
    private String _se_areacode;
    private String   _se_prodid;

	private String opnid;
	private Long yxplanid;
	private Double wrapfee;
	private String cityid;
	private String planbusitype;
	
	private String grade;

	private String wayid;
	
	 private Long noncyc ; //客户维系酬金发放期数
	 private String prodid;
	    
	    private Long seq;
    public String getProdid() {
			return prodid;
		}

		public void setProdid(String prodid) {
			this.prodid = prodid;
		}

		public Long getSeq() {
			return seq;
		}

		public void setSeq(Long seq) {
			this.seq = seq;
		}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

		public  String getOpnid() {
        return opnid;
    }
		public void setOpnid(String opnid) {
        this.opnid=opnid;
    }
		public  Long getYxplanid() {
        return yxplanid;
    }
		public void setYxplanid(Long yxplanid) {
        this.yxplanid=yxplanid;
    }
		public  Double getWrapfee() {
        return wrapfee;
    }
		public void setWrapfee(Double wrapfee) {
        this.wrapfee=wrapfee;
    }
		public  String getCityid() {
        return cityid;
    }
		public void setCityid(String cityid) {
        this.cityid=cityid;
    }

		public String get_se_opnid() {
			return _se_opnid;
		}

		public void set_se_opnid(String _se_opnid) {
			this._se_opnid = _se_opnid;
		}

		public String get_se_opnname() {
			return _se_opnname;
		}

		public void set_se_opnname(String _se_opnname) {
			this._se_opnname = _se_opnname;
		}

		public String get_se_yxplanname() {
			return _se_yxplanname;
		}

		public void set_se_yxplanname(String _se_yxplanname) {
			this._se_yxplanname = _se_yxplanname;
		}

		public String getPlanbusitype() {
			return planbusitype;
		}

		public void setPlanbusitype(String planbusitype) {
			this.planbusitype = planbusitype;
		}

		public String get_se_areacode() {
			return _se_areacode;
		}

		public void set_se_areacode(String _se_areacode) {
			this._se_areacode = _se_areacode;
		}

		public String get_se_plankind() {
			return _se_plankind;
		}

		public void set_se_plankind(String _se_plankind) {
			this._se_plankind = _se_plankind;
		}

		public String get_sk_yxplanname() {
			return _sk_yxplanname;
		}

		public void set_sk_yxplanname(String _sk_yxplanname) {
			this._sk_yxplanname = _sk_yxplanname;
		}

		public String getWayid() {
			return wayid;
		}

		public void setWayid(String wayid) {
			this.wayid = wayid;
		}

		public Long getNoncyc() {
			return noncyc;
		}

		public void setNoncyc(Long noncyc) {
			this.noncyc = noncyc;
		}

		public String get_se_prodid() {
			return _se_prodid;
		}

		public void set_se_prodid(String _se_prodid) {
			this._se_prodid = _se_prodid;
		}

		public String get_ne_seq() {
			return _ne_seq;
		}

		public void set_ne_seq(String _ne_seq) {
			this._ne_seq = _ne_seq;
		}
}
