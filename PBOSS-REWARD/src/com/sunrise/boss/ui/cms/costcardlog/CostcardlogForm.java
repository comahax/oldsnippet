/**
* auto-generated code
* Fri May 02 07:00:08 CST 2008
*/
package com.sunrise.boss.ui.cms.costcardlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;

/**
 * <p>Title: CostcardlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CostcardlogForm extends BaseActionForm {

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String wayid;
		private String calcmonth;
		private String opnid;
		private Integer salenum;


		public  Long getLogid() {
        return logid;
    }
		public void setLogid(Long logid) {
        this.logid=logid;
    }
		public  java.util.Date getOptime() {
        return optime;
    }
		public void setOptime(java.util.Date optime) {
        this.optime=optime;
    }
		public  String getOprcode() {
        return oprcode;
    }
		public void setOprcode(String oprcode) {
        this.oprcode=oprcode;
    }
		public  String getOprtype() {
        return oprtype;
    }
		public void setOprtype(String oprtype) {
        this.oprtype=oprtype;
    }
		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  String getCalcmonth() {
        return calcmonth;
    }
		public void setCalcmonth(String calcmonth) {
        this.calcmonth=calcmonth;
    }
		public  String getOpnid() {
        return opnid;
    }
		public void setOpnid(String opnid) {
        this.opnid=opnid;
    }
		public  Integer getSalenum() {
        return salenum;
    }
		public void setSalenum(Integer salenum) {
        this.salenum=salenum;
    }

}
