package com.gmcc.pboss.business.channel.wayprovince;

import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayprovinceVO extends BaseVO implements Serializable,BusinessLog {

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String uniquewayid;

    /** nullable persistent field */
    private String section;

    /** nullable persistent field */
    private String town;

    /** nullable persistent field */
    private Short provtype;

    /** nullable persistent field */
    private Short ettype;

    /** nullable persistent field */
    private Short mobilemall;

    /** nullable persistent field */
    private Double frontarea;

    /** nullable persistent field */
    private Short haswaitmach;

    /** nullable persistent field */
    private Short hasposmach;

    /** nullable persistent field */
    private Short has24mall;

    /** nullable persistent field */
    private Short hasvipseat;

    /** nullable persistent field */
    private Short hasviproom;

    /** nullable persistent field */
    private Double g3area;

    /** nullable persistent field */
    private Short ispconntype;

    /** nullable persistent field */
    private String friewayid;

    /** nullable persistent field */
    private String ofwayid;

    /** full constructor */
    public WayprovinceVO(java.lang.String wayid, java.lang.String uniquewayid, java.lang.String section, java.lang.String town, java.lang.Short provtype, java.lang.Short ettype, java.lang.Short mobilemall, java.lang.Double frontarea, java.lang.Short haswaitmach, java.lang.Short hasposmach, java.lang.Short has24mall, java.lang.Short hasvipseat, java.lang.Short hasviproom, java.lang.Double g3area, java.lang.Short ispconntype, java.lang.String friewayid, java.lang.String ofwayid) {
        this.wayid = wayid;
        this.uniquewayid = uniquewayid;
        this.section = section;
        this.town = town;
        this.provtype = provtype;
        this.ettype = ettype;
        this.mobilemall = mobilemall;
        this.frontarea = frontarea;
        this.haswaitmach = haswaitmach;
        this.hasposmach = hasposmach;
        this.has24mall = has24mall;
        this.hasvipseat = hasvipseat;
        this.hasviproom = hasviproom;
        this.g3area = g3area;
        this.ispconntype = ispconntype;
        this.friewayid = friewayid;
        this.ofwayid = ofwayid;
    }

    /** default constructor */
    public WayprovinceVO() {
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getUniquewayid() {
        return this.uniquewayid;
    }

    public void setUniquewayid(java.lang.String uniquewayid) {
        this.uniquewayid = uniquewayid;
    }

    public java.lang.String getSection() {
        return this.section;
    }

    public void setSection(java.lang.String section) {
        this.section = section;
    }

    public java.lang.String getTown() {
        return this.town;
    }

    public void setTown(java.lang.String town) {
        this.town = town;
    }

    public java.lang.Short getProvtype() {
        return this.provtype;
    }

    public void setProvtype(java.lang.Short provtype) {
        this.provtype = provtype;
    }

    public java.lang.Short getEttype() {
        return this.ettype;
    }

    public void setEttype(java.lang.Short ettype) {
        this.ettype = ettype;
    }

    public java.lang.Short getMobilemall() {
        return this.mobilemall;
    }

    public void setMobilemall(java.lang.Short mobilemall) {
        this.mobilemall = mobilemall;
    }

    public java.lang.Double getFrontarea() {
        return this.frontarea;
    }

    public void setFrontarea(java.lang.Double frontarea) {
        this.frontarea = frontarea;
    }

    public java.lang.Short getHaswaitmach() {
        return this.haswaitmach;
    }

    public void setHaswaitmach(java.lang.Short haswaitmach) {
        this.haswaitmach = haswaitmach;
    }

    public java.lang.Short getHasposmach() {
        return this.hasposmach;
    }

    public void setHasposmach(java.lang.Short hasposmach) {
        this.hasposmach = hasposmach;
    }

    public java.lang.Short getHas24mall() {
        return this.has24mall;
    }

    public void setHas24mall(java.lang.Short has24mall) {
        this.has24mall = has24mall;
    }

    public java.lang.Short getHasvipseat() {
        return this.hasvipseat;
    }

    public void setHasvipseat(java.lang.Short hasvipseat) {
        this.hasvipseat = hasvipseat;
    }

    public java.lang.Short getHasviproom() {
        return this.hasviproom;
    }

    public void setHasviproom(java.lang.Short hasviproom) {
        this.hasviproom = hasviproom;
    }

    public java.lang.Double getG3area() {
        return this.g3area;
    }

    public void setG3area(java.lang.Double g3area) {
        this.g3area = g3area;
    }

    public java.lang.Short getIspconntype() {
        return this.ispconntype;
    }

    public void setIspconntype(java.lang.Short ispconntype) {
        this.ispconntype = ispconntype;
    }

    public java.lang.String getFriewayid() {
        return this.friewayid;
    }

    public void setFriewayid(java.lang.String friewayid) {
        this.friewayid = friewayid;
    }

    public java.lang.String getOfwayid() {
        return this.ofwayid;
    }

    public void setOfwayid(java.lang.String ofwayid) {
        this.ofwayid = ofwayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WayprovincelogVO.class;
	}

}
