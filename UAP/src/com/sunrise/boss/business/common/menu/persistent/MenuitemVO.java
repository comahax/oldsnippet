package com.sunrise.boss.business.common.menu.persistent;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MenuitemVO extends BaseVO {

    /** persistent field */
    private String menuid;

    /** nullable persistent field */
    private String menuname;

    /** nullable persistent field */
    private String menupid;

    /** nullable persistent field */
    private String guiobject;

    /** nullable persistent field */
    private String rltguiobjid;

    /** nullable persistent field */
    private String addedinfo;

    /** nullable persistent field */
    private String tiptext;

    /** nullable persistent field */
    private String subsystemid;

    /** nullable persistent field */
    private String guitype;

    /** nullable persistent field */
    private String recdefid;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private String domainname;

    /** nullable persistent field */
    private Integer region;

    /** full constructor */
    public MenuitemVO(java.lang.String menuid, java.lang.String menuname, java.lang.String menupid, java.lang.String guiobject, java.lang.String rltguiobjid, java.lang.String addedinfo, java.lang.String tiptext, java.lang.String subsystemid, java.lang.String guitype, java.lang.String recdefid, java.lang.Short sortorder, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.String domainname, java.lang.Integer region) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.menupid = menupid;
        this.guiobject = guiobject;
        this.rltguiobjid = rltguiobjid;
        this.addedinfo = addedinfo;
        this.tiptext = tiptext;
        this.subsystemid = subsystemid;
        this.guitype = guitype;
        this.recdefid = recdefid;
        this.sortorder = sortorder;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
        this.domainname = domainname;
        this.region = region;
    }

    /** default constructor */
    public MenuitemVO() {
    }

    

    public java.lang.String getGuiobject() {
        return this.guiobject;
    }

    public void setGuiobject(java.lang.String guiobject) {
        this.guiobject = guiobject;
    }

    public java.lang.String getRltguiobjid() {
        return this.rltguiobjid;
    }

    public void setRltguiobjid(java.lang.String rltguiobjid) {
        this.rltguiobjid = rltguiobjid;
    }

    public java.lang.String getAddedinfo() {
        return this.addedinfo;
    }

    public void setAddedinfo(java.lang.String addedinfo) {
        this.addedinfo = addedinfo;
    }

    public java.lang.String getTiptext() {
        return this.tiptext;
    }

    public void setTiptext(java.lang.String tiptext) {
        this.tiptext = tiptext;
    }

    public java.lang.String getSubsystemid() {
        return this.subsystemid;
    }

    public void setSubsystemid(java.lang.String subsystemid) {
        this.subsystemid = subsystemid;
    }

    public java.lang.String getGuitype() {
        return this.guitype;
    }

    public void setGuitype(java.lang.String guitype) {
        this.guitype = guitype;
    }

    public java.lang.String getRecdefid() {
        return this.recdefid;
    }

    public void setRecdefid(java.lang.String recdefid) {
        this.recdefid = recdefid;
    }

    public java.lang.Short getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(java.lang.Short sortorder) {
        this.sortorder = sortorder;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

   

    public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenupid() {
		return menupid;
	}

	public void setMenupid(String menupid) {
		this.menupid = menupid;
	}

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
