/**
* auto-generated code
* Wed Nov 14 16:51:17 CST 2007
*/
package com.sunrise.boss.ui.zifee.feediscmonth;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;

/**
 * <p>Title: FeediscmonthForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class FeediscmonthForm extends BaseActionForm {
    private String _ne_yxplanid;
    private String _ne_disctype;
    private String _nnl_discvalue;
    private String _nnm_discvalue;
    private String _sk_discbill;
    private String _sk_excludebill;

		private Long discid;
		private Long yxplanid;
		private Short disctype;
		private Double discvalue;
		private Integer presentprio;
		private Byte presentbalanceflag;
		private String discbill;
		private String excludebill;

    public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }
    public String get_ne_disctype(){
        return _ne_disctype;
    }

    public void set_ne_disctype(String _ne_disctype){
        this._ne_disctype = _ne_disctype;
    }
    public String get_nnl_discvalue(){
        return _nnl_discvalue;
    }

    public void set_nnl_discvalue(String _nnl_discvalue){
        this._nnl_discvalue = _nnl_discvalue;
    }
    public String get_nnm_discvalue(){
        return _nnm_discvalue;
    }

    public void set_nnm_discvalue(String _nnm_discvalue){
        this._nnm_discvalue = _nnm_discvalue;
    }
    public String get_sk_discbill(){
        return _sk_discbill;
    }

    public void set_sk_discbill(String _sk_discbill){
        this._sk_discbill = _sk_discbill;
    }
    public String get_sk_excludebill(){
        return _sk_excludebill;
    }

    public void set_sk_excludebill(String _sk_excludebill){
        this._sk_excludebill = _sk_excludebill;
    }

		public  Long getDiscid() {
        return discid;
    }
		public void setDiscid(Long discid) {
        this.discid=discid;
    }
		public  Long getYxplanid() {
        return yxplanid;
    }
		public void setYxplanid(Long yxplanid) {
        this.yxplanid=yxplanid;
    }
		public  Short getDisctype() {
        return disctype;
    }
		public void setDisctype(Short disctype) {
        this.disctype=disctype;
    }
		public  Double getDiscvalue() {
        return discvalue;
    }
		public void setDiscvalue(Double discvalue) {
        this.discvalue=discvalue;
    }
		public  Integer getPresentprio() {
        return presentprio;
    }
		public void setPresentprio(Integer presentprio) {
        this.presentprio=presentprio;
    }
		public  Byte getPresentbalanceflag() {
        return presentbalanceflag;
    }
		public void setPresentbalanceflag(Byte presentbalanceflag) {
        this.presentbalanceflag=presentbalanceflag;
    }
		public  String getDiscbill() {
        return discbill;
    }
		public void setDiscbill(String discbill) {
        this.discbill=discbill;
    }
		public  String getExcludebill() {
        return excludebill;
    }
		public void setExcludebill(String excludebill) {
        this.excludebill=excludebill;
    }

}
