/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.web.promotion.elmttmpl;

import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;

/**
 * <p>Title: ElmttmplForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class ElmttmplForm extends ElmttmplVO {
	
	/** persistent field */
	private Long tmplid;

    /** persistent field */
    private String tmplname;

    /** persistent field */
    private String gatheringmode;

    /** persistent field */
    private String columnsinfo;

    /** persistent field */
    private String gatheringlogic;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String memo;


	public String getColumnsinfo() {
		return columnsinfo;
	}

	public void setColumnsinfo(String columnsinfo) {
		this.columnsinfo = columnsinfo;
	}

	public String getGatheringlogic() {
		return gatheringlogic;
	}

	public void setGatheringlogic(String gatheringlogic) {
		this.gatheringlogic = gatheringlogic;
	}

	public String getGatheringmode() {
		return gatheringmode;
	}

	public void setGatheringmode(String gatheringmode) {
		this.gatheringmode = gatheringmode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public Long getTmplid() {
		return tmplid;
	}

	public void setTmplid(Long tmplid) {
		this.tmplid = tmplid;
	}

	public String getTmplname() {
		return tmplname;
	}

	public void setTmplname(String tmplname) {
		this.tmplname = tmplname;
	}
}
