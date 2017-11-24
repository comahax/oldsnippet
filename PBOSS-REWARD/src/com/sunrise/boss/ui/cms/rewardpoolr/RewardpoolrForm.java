/**
* auto-generated code
* Fri Feb 01 18:16:01 CST 2008
*/
package com.sunrise.boss.ui.cms.rewardpoolr;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrVO;

/**
 * <p>Title: RewardpoolrForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrForm extends BaseActionForm {
    private String _ne_rewardtype;
    private String _se_region;
    private String _dnl_startdate;
    private String _dnm_stopdate;
    private String inputrewardbuss;
    private String beforinputrewardbuss;
    
		private Integer rewardtype;
		private String region;
		//private String slv;
		private String star[] = { "1", "2", "3",
				"4", "5", "6" };
		private String[] seleteSlv = {};
		private java.util.Date startdate;
		private java.util.Date stopdate;
		private String memo;
		private String proportion;
		private String cycle;

    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_dnl_startdate(){
        return _dnl_startdate;
    }

    public void set_dnl_startdate(String _dnl_startdate){
        this._dnl_startdate = _dnl_startdate;
    }
    public String get_dnm_stopdate(){
        return _dnm_stopdate;
    }

    public void set_dnm_stopdate(String _dnm_stopdate){
        this._dnm_stopdate = _dnm_stopdate;
    }

		public  Integer getRewardtype() {
        return rewardtype;
    }
		public void setRewardtype(Integer rewardtype) {
        this.rewardtype=rewardtype;
    }
		public  String getRegion() {
        return region;
    }
		public void setRegion(String region) {
        this.region=region;
    }
		public void setSlv(String slv) {
			if (slv != null && slv.length() != 0) {
				seleteSlv = new String[6];
				for (int i = 0; i < 6; i++) {
					if (i >= slv.length())
						return;
					seleteSlv[i] = slv.substring(i, i + 1).equals(
							"0") ? "" : star[i];
				}
			}

		}

		public String getSlv() {
			String[] star = getStar();
			String[] seleteSlv = getSeleteSlv();
			StringBuffer slv = new StringBuffer();
			for (int i = 0; i < star.length; i++) {
				boolean equal = false;
				for (int j = 0; j < seleteSlv.length; j++) {
					if (star[i].equals(seleteSlv[j])) {
						slv.append("1");
						equal = true;
						break;
					}
				}
				if (!equal)
					slv.append("0");
			}
			return slv.toString();
		}

		
		public String[] getStar() {
			return star;
		}

		public void setStar(String[] star) {
			this.star = star;
		}

		public  java.util.Date getStartdate() {
        return startdate;
    }
		public void setStartdate(java.util.Date startdate) {
        this.startdate=startdate;
    }
		public  java.util.Date getStopdate() {
        return stopdate;
    }
		public void setStopdate(java.util.Date stopdate) {
        this.stopdate=stopdate;
    }
		public  String getMemo() {
        return memo;
    }
		public void setMemo(String memo) {
        this.memo=memo;
    }

		public String[] getSeleteSlv() {
			return seleteSlv;
		}

		public void setSeleteSlv(String[] seleteSlv) {
			this.seleteSlv = seleteSlv;
		}

		public String getInputrewardbuss() {
			return inputrewardbuss;
		}

		public void setInputrewardbuss(String inputrewardbuss) {
			this.inputrewardbuss = inputrewardbuss;
		}

		public String getBeforinputrewardbuss() {
			return beforinputrewardbuss;
		}

		public void setBeforinputrewardbuss(String beforinputrewardbuss) {
			this.beforinputrewardbuss = beforinputrewardbuss;
		}

		public String getProportion() {
			return proportion;
		}

		public void setProportion(String proportion) {
			this.proportion = proportion;
		}

		public String getCycle() {
			return cycle;
		}

		public void setCycle(String cycle) {
			this.cycle = cycle;
		}

}




